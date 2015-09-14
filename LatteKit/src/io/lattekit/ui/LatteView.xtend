package io.lattekit.ui

import android.R
import android.animation.Animator
import android.animation.AnimatorSet
import android.app.Activity
import android.content.res.ColorStateList
import android.graphics.Point
import android.graphics.drawable.RippleDrawable
import android.graphics.drawable.StateListDrawable
import android.os.Build
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.MeasureSpec
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.FrameLayout
import android.widget.TextView
import io.lattekit.State
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

import static extension io.lattekit.xtend.ArrayLiterals2.*

public abstract class LatteView {
	
	public final int MATCH_PARENT = LayoutParams.MATCH_PARENT;
	public final int WRAP_CONTENT = LayoutParams.WRAP_CONTENT;
	public final int match_parent = LayoutParams.MATCH_PARENT;
	public final int wrap_content = LayoutParams.WRAP_CONTENT;
	 
	/** Base Attributes */ 
	@Accessors public String id;
	@State public (LatteView)=>void onTap;
	@State public (LatteView, MotionEvent)=>boolean onTouch;
	
	@Accessors public Style normalStyle;
	@Accessors public Style touchedStyle;
	@Accessors public Style disabledStyle;
	@State Style x_style = null;	
	Style _resolvedTouchedStyle;
	Style _resolvedDisabledStyle;
	public var Animator currentAnimation;
	
	@State public boolean enabled = true;
	@Accessors public boolean touched = false;
	
	// Generic Attributes
	public Map<String,Object> attributes = newHashMap();
	
	@Accessors public LatteView parentView;
	// This contains current active children
	@Accessors public List<LatteView> children = newArrayList;
	@Accessors private List<LatteView> subviews = newArrayList;
	
	// This contains children list being built while parsing the tree
	private List<LatteView> _children = newArrayList;
	
	public Activity activity;
	@Accessors View androidView;
	
	
	protected (LatteView)=>void attributesProc;
	protected (LatteView)=>void layoutProc;
	private boolean isRendering = false;
	
	def setStyle(Style style) {
		if (normalStyle == null) {
			normalStyle = new Style();
		}
		normalStyle.cloneFrom(style);
		if (this.x_style != null) {
//			this.x_style.cloneFrom(normalStyle);
		} else {
			this.x_style = style.clone();
		}
		_resolvedTouchedStyle = null;
		_resolvedDisabledStyle = null;
		onStateChanged("style");	
	}
	def getStyle() {
		if (x_style == null) {
			return new Style() => [
				it.width = WRAP_CONTENT
				it.height = WRAP_CONTENT
			]
		}
		return x_style;
	}
	def void setTouchedStyle(Style style) {
		if (this.touchedStyle != null) {
			this.touchedStyle.cloneFrom(style);
		} else {
			this.touchedStyle = style.clone();
		}

		onStateChanged("touchedStyle");	
	}
	def void setDisabledStyle(Style style) {
		if (this.disabledStyle != null) {
			this.disabledStyle.cloneFrom(style);
		} else {
			this.disabledStyle = style.clone();
		}
		onStateChanged("disabledStyle");	
	}
	
	def getResolvedTouchedStyle() {
		if (touchedStyle == null) return normalStyle;
		if (_resolvedTouchedStyle == null) _resolvedTouchedStyle = touchedStyle.inheritsFrom(normalStyle);
		return _resolvedTouchedStyle
	}
	
	def getResolvedDisabledStyle() {
		if (disabledStyle == null) return normalStyle;
		if (_resolvedDisabledStyle == null) _resolvedDisabledStyle = disabledStyle.inheritsFrom(normalStyle);
		return _resolvedDisabledStyle
	}
	
	def getActiveStyle() {
		if (!enabled && disabledStyle != null) {
			return resolvedDisabledStyle
		} else if (touched && touchedStyle != null) {
			return resolvedTouchedStyle;
		}
		return if (normalStyle == null) new Style() else normalStyle;
	}
	
	def void watchTree() {
		androidView.viewTreeObserver.addOnGlobalLayoutListener([
			activeStyle._computedX = androidView.x
			activeStyle._computedY = androidView.y
			androidView.viewTreeObserver.removeOnGlobalLayoutListener(self)
		])
	}
	def void applyAttributes() {
		if (androidView != null) {
			androidView.enabled = enabled;
			updateBackgroundDrawable()			
			updateTextColorDrawable()
			if (activeStyle._computedX == null) {
				watchTree();
			}
			activeStyle.applyStyle(androidView)
			androidView.onClickListener = [v |
				if (onTap != null) {
					onTap.apply(LatteView.this);
				}				
			]
			
			androidView.onTouchListener = [ v, e|
				var AnimatorSet newAnim = null;
				var oldAnim = currentAnimation
				var handled = false;
				if (onTouch != null && e.action == MotionEvent.ACTION_DOWN) {
					handled = onTouch.apply(this,e);
				}				
				
				if (enabled && touchedStyle != null) { 
					if (e.action == MotionEvent.ACTION_DOWN) {
						touched = true;
						newAnim = resolvedTouchedStyle.createAnimatorFrom(x_style, this, false);
					} else if (e.action == MotionEvent.ACTION_UP) {
						touched = false;
						newAnim = normalStyle.createAnimatorFrom(x_style, this, true)
					}
					if (newAnim != null) {
						currentAnimation = newAnim;
						if (oldAnim != null && oldAnim.isRunning) {
							oldAnim.cancel
							newAnim.start
						} else {
							newAnim.start()
						}
					}			
				}
				if (onTouch != null && e.action == MotionEvent.ACTION_UP) {
					handled = onTouch.apply(this,e);
				}				
				return handled;
			]
			
		}
	}
	
	
	def Point getMeasuredSize() {
		return getMeasuredSize(activeStyle);
	}
	
	def getWindowWidth() {
		androidView.context.getResources().getDisplayMetrics().widthPixels
	}
	
	def getWindowHeight() {
		androidView.context.getResources().getDisplayMetrics().heightPixels
	}
	
	def Point getMeasuredSize(Style forStyle) {
	    var widthMeasureSpec = if (forStyle.width == LayoutParams.MATCH_PARENT) {
	    	var parentWidth = if (nonVirtualParent != null) {
	    		nonVirtualParent.measuredSize.x;
	    	} else windowWidth;
	    	MeasureSpec.makeMeasureSpec(parentWidth, MeasureSpec.EXACTLY);
	    } else if (forStyle.width == LayoutParams.WRAP_CONTENT) {
	    	MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
	    } else {
	    	MeasureSpec.makeMeasureSpec(forStyle.width, MeasureSpec.EXACTLY);
	    }
	    
		var heightMeasureSpec = if (forStyle.height == LayoutParams.MATCH_PARENT) {
	    	var parentHeight = if (nonVirtualParent != null) {
	    		nonVirtualParent.measuredSize.y;
	    	} else windowHeight;
	    	MeasureSpec.makeMeasureSpec(parentHeight, MeasureSpec.EXACTLY);
	    } else if (forStyle.height == LayoutParams.WRAP_CONTENT) {
	    	MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
	    } else {
	    	MeasureSpec.makeMeasureSpec(forStyle.height, MeasureSpec.EXACTLY);
	    }
		androidView.measure(widthMeasureSpec, heightMeasureSpec);
		return new Point(androidView.measuredWidth,androidView.measuredHeight);
	}
//	override onTouch(View v, MotionEvent event) {
//		if (event.action == MotionEvent.ACTION_UP) {
//			style.createAnimatorFrom(resolvedTouchedStyle, androidView).start
//		}
//		return false;
//	}
	

	def updateBackgroundDrawable() {
		var List<List<Integer>> colorStates = newArrayList
		val List<Integer> colorList = newArrayList
		if (touchedStyle != null) {
			colorStates += #[ R.attr.state_enabled, R.attr.state_pressed ]
			colorList += Style::asColor(resolvedTouchedStyle.backgroundColor)
		}
		
		colorStates += #[R.attr.state_enabled, -R.attr.state_pressed]
		colorList += Style::asColor(style.backgroundColor)
		
		if (disabledStyle != null) {
			colorStates += #[ -R.attr.state_enabled ]
			colorList += Style::asColor(resolvedDisabledStyle.backgroundColor)
		}
		
		val StateListDrawable  sld = new StateListDrawable();
		if (disabledStyle != null) {
			sld.addState(#[-R.attr.state_enabled], resolvedDisabledStyle.drawable)
		}

		sld.addState(#[], style.drawable)
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			androidView.background = new RippleDrawable(new ColorStateList(colorStates.unwrap, colorList),sld, if (resolvedTouchedStyle != null ) resolvedTouchedStyle.shapeDrawable else style.shapeDrawable);
		} else {			
			androidView.background =  new codetail.graphics.drawables.RippleDrawable(new ColorStateList(colorStates.unwrap, colorList),sld, if (resolvedTouchedStyle != null ) resolvedTouchedStyle.shapeDrawable else style.shapeDrawable);
		}		
	}
	


	def updateTextColorDrawable() {
		
		var List<List<Integer>> colorStates = newArrayList
		var List<Integer> colorList = newArrayList
		if (touchedStyle != null) {
			colorStates += #[ R.attr.state_enabled, R.attr.state_pressed]
			colorList += Style::asColor(resolvedTouchedStyle.textColor)
		}
		colorStates += #[R.attr.state_enabled, -R.attr.state_pressed ]
		colorList += Style::asColor(style.textColor)
		
		if (disabledStyle != null) {
			colorStates += #[ -R.attr.state_enabled ]
			colorList += Style::asColor(resolvedDisabledStyle.textColor)
		}
		if (androidView instanceof TextView) {
			val int[][] colorStatesArray = intArray(colorStates.size);
			var i = 0;
			for (state : colorStates) {
				colorStatesArray.set(i,state as int[])
				i++
			}
			androidView.textColor = new ColorStateList(colorStatesArray, colorList);	
		}
	}
	
	def View createAndroidView(Activity a) { null; }
	def void onChildrenAdded() {}
		
	def <T extends LatteView> void processNode(LatteView parent, String id, (T)=>void attrs, (T)=>void children) {
		isRendering = true;
		parentView = parent as LatteView;
		if (parent != null && parent._children != null) {
			parent.children.add(this);				
		}	

		_children = newArrayList();
		if (attrs != null) {
			attributesProc = attrs as (LatteView)=>void;
			attrs.apply(this as T);
		}
		if (children != null) {
			layoutProc = children as (LatteView)=>void;
			children.apply(this as T);
		}

		
		var latteView = render();
		if (latteView != null) {
			var oldLatteView = if (subviews.length > 0) subviews.get(0) else null;
			if (oldLatteView != null) {
				// Re-use old instance
				if (oldLatteView.class == latteView.class) {
					Log.d("Latte", this +" Re-using same subview")
					Log.d("Latte", this +" Compare "+ latteView +" with "+ oldLatteView);
					compareView(latteView, oldLatteView);	
				} else {
					subviews.set(0, latteView);
				}
			} else {
				subviews = newArrayList();
				subviews.add(latteView);
			}
		} else {
			// This view doesn't have a render. All children are considered subviews
			var newSubviews = newArrayList()
			for (var i =0 ; i < this.children.size; i++) {
				var newChild = this.children.get(i);
				var oldChild = if (i < this.subviews.size) this.subviews.get(i) else null;
				if (oldChild != null) {
					if (sameView(newChild, oldChild)) {
						newSubviews.add(oldChild);
						compareView(newChild,oldChild)	
					} else {
						newSubviews.add(newChild);
					}
				} else {
					newSubviews.add(newChild);
				}
			}	
			subviews = newSubviews;
		}
		
		isRendering = false;
	}


	def setAttribute(String key, Object value) {
		attributes.put(key, value);
		onStateChanged(key);
	}

	def onStateChanged(String stateName) {
		if (!isRendering) {
			Log.d("Latte", this+" : State changed "+ stateName)
			handleStateChanged
			
		}
	}
	
	
	
	def void handleStateChanged() {
		this.processNode(null, null, null, layoutProc);
		buildAndroidViewTree(activity,rootAndroidView.layoutParams);	
	}
	
	
	def sameView(LatteView leftView, LatteView rightView) {
		if (leftView.class == rightView.class) {
			return true;
		}
		return false;
	}
	def void compareView(LatteView newView, LatteView oldView) {
//		if (newView.class != oldView.class) {
//			return;
//		} else {
//			if (newView.androidView == null && oldView.androidView == null) {

				// Both are virtual nodes. Compare the underlying nodes

//				compareView(newView.latteView, oldView.latteView);
//				newView.x_style = oldView.x_style;
				
				// Compare children 
				oldView.copyState(newView);
				
				if (oldView.normalStyle != null) {
					oldView.normalStyle.cloneFrom(newView.normalStyle, true);	
				} else {
					oldView.normalStyle = newView.normalStyle;
				}

				if (oldView.touchedStyle != null) {
					oldView.touchedStyle.cloneFrom(newView.touchedStyle, true);	
				} else {
					oldView.touchedStyle = newView.touchedStyle;
				}
				
				if (oldView.disabledStyle != null) {
					oldView.disabledStyle.cloneFrom(newView.disabledStyle, true);	
				} else {
					oldView.disabledStyle = newView.disabledStyle;
				}
												
				 
				for (var i =0; i < newView.subviews.size; i++) {
					if (oldView.subviews.size <= i) {
						newView.subviews.get(i).parentView = oldView;
						Log.d("Latte", "Added new view "+ newView.subviews.get(i));
						oldView.subviews.add(newView.subviews.get(i))
					} else {
						var oldChildView = oldView.subviews.get(i);
						var newChildView = newView.subviews.get(i);
						Log.d("Latte", this +": Comparing child "+ newChildView +" with "+oldChildView);
						if (this.sameView(oldChildView,newChildView)) {
							// Accepted ?
							compareView(newChildView, oldChildView);
						} else {
							// Not accepted, replace with the new child
							newChildView.parentView = oldView;
							// RODO: Maybe recycle old view ?
							oldView.subviews.set(i, newChildView);								
						}
					}					
				}

//			} else if ((newView.androidView == null && oldView.androidView != null) || (newView.androidView != null && oldView.androidView == null)) {
//				
//				// No match. One is native and the other is virtual
//				
//			} else if (newView.androidView == null && oldView.androidView != null) {
//				
//				Log.d("Latte", "Re-using " + oldView.androidView);
//				newView.androidView = oldView.androidView;
//				
//				for (var i =0; i < newView.subviews.size; i++) {
//					var oldChildView = if (oldView.subviews.size > i) oldView.subviews.get(i) else null;
//					if (oldChildView != null) {
//						compareView(newView.subviews.get(i), oldChildView);
//					}
//				}
//			}
//		}
	}
	
	
	

	def LayoutParams createLayoutParams(int width, int height) {
		return null;
	}
	
	def LatteView render() { null; }
	
	def LatteView getNonVirtualParent() {
		if (parentView == null) {
			return null;
		}
		if (parentView.androidView != null) {
			return parentView;
		}
		return parentView.nonVirtualParent
	}
	
	def View getRootAndroidView() {
		if (this.androidView == null) {
			return this.subviews.get(0).rootAndroidView
		}
		return this.androidView
	}
	
	def View buildAndroidViewTree(Activity a, ViewGroup.LayoutParams lp) {
		// Log.d("Latte", this.class.simpleName +" Building my tree (subview size = "+ children.size +" ) ");
		// First build my view
		this.activity = a;
		var myView = if (this.androidView == null) { 
			createAndroidView(a); 
		} else this.androidView;
		if (myView == null) {
			// If we don't have native android view, then we are virtual node
			return this.subviews.get(0).buildAndroidViewTree(a, lp);
		}
		this.androidView = myView;
		if (this.androidView.id == -1 && this.id != null) {
			this.androidView.id = this.id.hashCode
		}
		if (this.androidView.layoutParams == null) {
			this.androidView.layoutParams = lp;
		}

		if (subviews.size > 0) {
			var myContainer = myView as ViewGroup
			var i = 0;
			for (LatteView v : subviews) {
				var childLP = createLayoutParams(v.style.width, v.style.height);
				var View childView = v.buildAndroidViewTree(a, childLP);
				if (i >= myContainer.childCount) {
					myContainer.addView(childView, i, childLP)	
				} else if (myContainer.getChildAt(i) == childView) {
//					childView.layoutParams = childLP;
				} else {
					childView.layoutParams = childLP;
					myContainer.addView(childView,i, childLP);
				}
				i++;
			}
			for (var z = i; z < myContainer.childCount; z++) {
				myContainer.removeViewAt(z);
			}

			this.applyAttributes();
			onChildrenAdded();
		} else {
			this.applyAttributes();
		}
		
		return myView;
	}
	
	def void renderOn(Activity a) {
		activity = a;		
		this.processNode(null,null,null, null);
		this.buildAndroidViewTree(a, new FrameLayout.LayoutParams(this.style.width, this.style.height))
		a.setContentView(this.rootAndroidView);		
	}
	
}