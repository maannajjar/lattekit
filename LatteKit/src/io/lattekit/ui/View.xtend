package io.lattekit.ui

import android.R
import android.animation.StateListAnimator
import android.app.Activity
import android.content.res.ColorStateList
import android.graphics.drawable.RippleDrawable
import android.graphics.drawable.StateListDrawable
import android.os.Build
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.FrameLayout
import android.widget.TextView
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
	@Accessors public (LatteView)=>void onTap;
	@Accessors public (LatteView)=>void onClick;
	@Accessors public int width = WRAP_CONTENT;
	@Accessors public int height = WRAP_CONTENT;
	
	
	
	Style _style = null;
	@Accessors public Style normalStyle;
	@Accessors public Style touchedStyle;
	@Accessors public Style disabledStyle;
	Style _resolvedTouchedStyle;
	Style _resolvedDisabledStyle;
	
	@Accessors public boolean enabled = true;
	@Accessors public boolean touched = false;
	
	// Generic Attributes
	public Map<String,Object> attributes = newHashMap();
	
	@Accessors public LatteView parentView;
	// This contains current active children
	@Accessors public List<LatteView> children = newArrayList;
	@Accessors private List<LatteView> subviews = newArrayList;
	
	// This contains children list being built while parsing the tree
	private List<LatteView> _children = newArrayList;
	
	
	
	Activity activity;
	@Accessors View androidView;
	LatteView latteView;
	
	
	protected (LatteView)=>void attributesProc;
	protected (LatteView)=>void layoutProc;
	private boolean isRendering = false;
	
	
	def setStyle(Style style) {
		normalStyle = style;
		if (this._style != null) {
//			this._style.cloneFrom(normalStyle);
		} else {
			this._style = style.clone();
		}
		_resolvedTouchedStyle = null;
		_resolvedDisabledStyle = null;
		onStateChanged("style");	
	}
	def getStyle() {
		if (_style == null) {
			return new Style();
		}
		return _style;
	}
	def setTouchedStyle(Style style) {
		if (this.touchedStyle != null) {
			this.touchedStyle.cloneFrom(style);
		} else {
			this.touchedStyle = style.clone();
		}

		onStateChanged("touchedStyle");	
	}
	def setDisabledStyle(Style style) {
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
	def void applyAttributes() {
		if (androidView != null) {
			androidView.enabled = enabled;
			updateBackgroundDrawable()			
			updateTextColorDrawable()
			activeStyle.applyStyle(androidView)
			androidView.onTouchListener = [ v, e|
				if (enabled && touchedStyle != null) { 
					if (e.action == MotionEvent.ACTION_DOWN) {
						touched = true;
						Log.d("Latte", "Active style "+activeStyle +" vs "+touchedStyle)
						resolvedTouchedStyle.createAnimatorFrom(_style, this).start
					} else if (e.action == MotionEvent.ACTION_UP) {
						touched = false;
						Log.d("Latte", "Active style "+activeStyle +" vs "+touchedStyle)
						normalStyle.createAnimatorFrom(_style, this).start
					}
				}
				return false;
			]
			
			if (onTap != null) {
				androidView.onClickListener = [ onTap.apply(this) ];
			}
			
		}
	}
	
//	override onTouch(View v, MotionEvent event) {
//		if (event.action == MotionEvent.ACTION_UP) {
//			style.createAnimatorFrom(resolvedTouchedStyle, androidView).start
//		}
//		return false;
//	}
	
	def updateStateListAnimator() {
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return;
		var stateAnimator = new StateListAnimator();
		
		if (touchedStyle != null) {
//			stateAnimator.addState(#[ R.attr.state_enabled, R.attr.state_pressed], resolvedTouchedStyle.createAnimatorFrom(style, androidView))
//			stateAnimator.addState(#[ R.attr.state_active, R.attr.state_enabled, -R.attr.state_pressed], style.createAnimatorFrom(resolvedTouchedStyle, androidView))
			Log.d("Latte", style +" : creating animator for "+this);
		}
		
		androidView.stateListAnimator = stateAnimator;
		
	}
	def updateBackgroundDrawable() {
//		Log.d("Latte","MY RADIUS IS " + style.cornerRadius)
//		this.androidView.background = style.drawable;
//		
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
		
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			val StateListDrawable  sld = new StateListDrawable();
			if (disabledStyle != null) {
				sld.addState(#[-R.attr.state_enabled], resolvedDisabledStyle.drawable)
			}

			sld.addState(#[], style.drawable)
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { 
				androidView.background = new RippleDrawable(new ColorStateList(colorStates.unwrap, colorList),sld, style.shapeDrawable);
			} else {			
				androidView.background =  new codetail.graphics.drawables.RippleDrawable(new ColorStateList(colorStates.unwrap, colorList),sld, style.shapeDrawable);
			}		
//		} else {
//			var StateListDrawable  sld = new StateListDrawable();
//			if (touchedStyle != null) {
//				sld.addState(#[ R.attr.state_enabled, R.attr.state_pressed], resolvedTouchedStyle.getDrawable())
//			}
//			sld.addState(#[ R.attr.state_enabled, -R.attr.state_pressed], style.getDrawable())
//			if (disabledStyle != null) {
//				sld.addState(#[ -R.attr.state_enabled ], resolvedDisabledStyle.getDrawable())	
//			}
//			androidView.background = sld;
//		}

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

		var oldLatteView = latteView;
		latteView = render();
		if (latteView != null) {
			subviews = newArrayList()
			
			if (oldLatteView != null) {
				// TODO: Re-used old instance
				latteView = oldLatteView;
				if (oldLatteView.class == latteView.class) {
					subviews.add(oldLatteView);
					compareView(latteView, oldLatteView);	
				} else {
					subviews.add(latteView);
				}
				
			}
		} else {
			// This view doesn't have a render. All children are considered subviews
			var newSubviews = newArrayList()
			for (var i =0 ; i < this.children.size; i++) {
				var newChild = this.children.get(i);
				newSubviews.add(newChild);			
				if (i < this.subviews.size) {
					compareView(newChild,this.subviews.get(i))
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
			handleStateChanged
		}
	}
	
	
	
	def void handleStateChanged() {
		this.processNode(null, null, null, layoutProc);
		buildAndroidViewTree(activity,rootAndroidView.layoutParams);	
	}
	
	def void compareView(LatteView newView, LatteView oldView) {
		if (newView.class != oldView.class) {
			return;
		} else {
			if (newView.androidView == null && oldView.androidView == null) {

				// Both are virtual nodes. Compare the underlying nodes

//				compareView(newView.latteView, oldView.latteView);
//				newView._style = oldView._style;
				
				// Compare children 
				for (var i =0; i < subviews.size; i++) {
					var oldChildView = if ( oldView.subviews.size > i) oldView.subviews.get(i) else null;
					if (oldChildView != null) {
						if (oldChildView.class == subviews.get(i).class) {
							oldChildView.parentView = this;
							subviews.set(i, oldChildView);
							compareView(subviews.get(i), oldChildView);
						}
//						 else {
//							compareView(subviews.get(i), oldChildView);
//						}
					}
				}	
			} else if ((newView.latteView != null && oldView.latteView == null) || (newView.latteView == null && oldView.latteView != null)) {
				
				// No match. One is native and the other is virtual
				
			} else if (newView.androidView == null && oldView.androidView != null) {
				
				Log.d("Latte", "Re-using " + oldView.androidView);
				newView.androidView = oldView.androidView;
				
				for (var i =0; i < newView.subviews.size; i++) {
					var oldChildView = if (oldView.subviews.size > i) oldView.subviews.get(i) else null;
					if (oldChildView != null) {
						compareView(newView.subviews.get(i), oldChildView);
					}
				}
			}
		}
	}
	
	
	

	def LayoutParams createLayoutParams(int width, int height) {
		return null;
	}
	
	def LatteView render() { null; }
	
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
			var c = createAndroidView(a); 
			c;
		} else this.androidView;
		if (myView == null) {
			// If we don't have native android view, then we are virtual node
			return this.latteView.buildAndroidViewTree(a, lp);
		}
		if (this.androidView.id == -1 && this.id != null) {
			this.androidView.id = this.id.hashCode
		}
		if (androidView != null) {
			androidView.layoutParams = lp;
		}
		applyAttributes
		if (subviews.size > 0) {
			var myContainer = myView as ViewGroup
//			myContainer.removeAllViews
			var i = 0;
			for (LatteView v : subviews) {
				var childLP = createLayoutParams(v.width, v.height);				
				var View childView = v.buildAndroidViewTree(a, childLP);
				if (i >= myContainer.childCount) { 
					myContainer.addView(childView, childLP)	
				} else if (myContainer.getChildAt(i) == childView) {
					childView.layoutParams = childLP;
				} else {
					childView.layoutParams = childLP;
					myContainer.addView(childView,i, childLP);
				}
				i++;
			}
			for (var z = i; z < myContainer.childCount; z++) {
				myContainer.removeViewAt(z);
			}
			onChildrenAdded();
		}
		
		return myView;
	}
	
	def void renderOn(Activity a) {
		activity = a;
		latteView = render();
		if (latteView != null) {
			latteView.processNode(this, null, null, null);
			var nativeView = buildAndroidViewTree(a, new FrameLayout.LayoutParams(WRAP_CONTENT, MATCH_PARENT));
			a.setContentView(nativeView);	
		}
		
	}
	
}