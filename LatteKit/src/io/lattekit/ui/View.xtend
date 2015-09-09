package io.lattekit.ui

import android.R
import android.app.Activity
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.RippleDrawable
import android.graphics.drawable.StateListDrawable
import android.os.Build
import android.util.Log
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.TextView
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

import static extension io.lattekit.xtend.ArrayLiterals2.*
import android.animation.StateListAnimator
import android.view.MotionEvent

public abstract class View {
	
	public final int MATCH_PARENT = LayoutParams.MATCH_PARENT;
	public final int WRAP_CONTENT = LayoutParams.WRAP_CONTENT;
	public final int match_parent = LayoutParams.MATCH_PARENT;
	public final int wrap_content = LayoutParams.WRAP_CONTENT;
	 
	/** Base Attributes */ 
	@Accessors public String id;
	@Accessors public (View)=>void onTap;
	@Accessors public int width = WRAP_CONTENT;
	@Accessors public int height = WRAP_CONTENT;
	
	
	
	Style _style = new Style => [
		backgroundColor = Color.WHITE
	]
	@Accessors public Style touchedStyle;
	@Accessors public Style disabledStyle;
	Style _resolvedTouchedStyle;
	Style _resolvedDisabledStyle;
	
	@Accessors public boolean enabled = true;
	
	// Generic Attributes
	public Map<String,Object> attributes = newHashMap();
	
	@Accessors public View parentView;
	// This contains current active children
	@Accessors public List<View> children = newArrayList;
	@Accessors private List<View> subviews = newArrayList;
	
	// This contains children list being built while parsing the tree
	private List<View> _children = newArrayList;
	
	
	
	Activity activity;
	@Accessors android.view.View androidView;
	View latteView;
	
	
	protected (View)=>void attributesProc;
	protected (View)=>void layoutProc;
	private boolean isRendering = false;
	
	
	def setStyle(Style style) {
		this._style = style.clone();
		_resolvedTouchedStyle = null;
		_resolvedDisabledStyle = null;
		onStateChanged("style");	
	}
	def getStyle() {
		return _style;
	}
	def setTouchedStyle(Style style) {
		this.touchedStyle = style.clone();
		onStateChanged("touchedStyle");	
	}
	def setDisabledStyle(Style style) {
		this.disabledStyle = style.clone();
		onStateChanged("disabledStyle");	
	}
	
	def getResolvedTouchedStyle() {
		if (touchedStyle == null) return style;
		if (_resolvedTouchedStyle == null) _resolvedTouchedStyle = touchedStyle.inheritsFrom(style);
		return _resolvedTouchedStyle
	}
	
	def getResolvedDisabledStyle() {
		if (disabledStyle == null) return style;
		if (_resolvedDisabledStyle == null) _resolvedDisabledStyle = disabledStyle.inheritsFrom(style);
		return _resolvedDisabledStyle
	}
	
	def getActiveStyle() {
		if (!enabled && disabledStyle != null) {
			return resolvedDisabledStyle
		} else if (androidView != null && androidView.isPressed && touchedStyle != null) {
			return resolvedTouchedStyle;
		}
		return style;
	}
	def void applyAttributes() {
		if (androidView != null) {
			androidView.enabled = enabled;
			updateBackgroundDrawable()
			updateTextColorDrawable()
			updateStateListAnimator()
			
			activeStyle.applyStyle(androidView)
			androidView.onTouchListener = [ v, e|
				if (e.action == MotionEvent.ACTION_UP) {
					style.createAnimatorFrom(resolvedTouchedStyle, androidView).start
				}
				return false;
			]
			
			if (onTap != null) {
				androidView.onClickListener = [ onTap.apply(this) ];
			}
			
		}
	}
	def updateStateListAnimator() {
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return;
		var stateAnimator = new StateListAnimator();
		
		if (touchedStyle != null) {
			stateAnimator.addState(#[ R.attr.state_enabled, R.attr.state_pressed], resolvedTouchedStyle.createAnimatorFrom(style, androidView))
//			stateAnimator.addState(#[ R.attr.state_active, R.attr.state_enabled, -R.attr.state_pressed], style.createAnimatorFrom(resolvedTouchedStyle, androidView))
			Log.d("Latte", style +" : creating animator for "+this);
		}
		
		androidView.stateListAnimator = stateAnimator;
		
	}
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
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			val StateListDrawable  sld = new StateListDrawable();
			if (disabledStyle != null) {
				sld.addState(#[-R.attr.state_enabled], resolvedDisabledStyle.drawable)
			}
			sld.addState(#[], style.getDrawable())
			androidView.background =  new RippleDrawable(new ColorStateList(colorStates.unwrap, colorList),sld, style.shapeDrawable);				
		} else {
			var StateListDrawable  sld = new StateListDrawable();
			if (touchedStyle != null) {
				sld.addState(#[ R.attr.state_enabled, R.attr.state_pressed], resolvedTouchedStyle.getDrawable())
			}
			sld.addState(#[ R.attr.state_enabled, -R.attr.state_pressed], style.getDrawable())
			if (disabledStyle != null) {
				sld.addState(#[ -R.attr.state_enabled ], resolvedDisabledStyle.getDrawable())	
			}
			androidView.background = sld;
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
	
	def android.view.View createAndroidView(Activity a) { null; }
	def void onChildrenAdded() {}
		
	def <T extends View> void processNode(View parent, String id, (T)=>void attrs, (T)=>void children) {
		isRendering = true;
		parentView = parent as View;
		if (parent != null && parent._children != null) {
			parent.children.add(this);				
		}	

		_children = newArrayList();
		if (attrs != null) {
			attributesProc = attrs as (View)=>void;
			attrs.apply(this as T);
		}
		if (children != null) {
			layoutProc = children as (View)=>void;
			children.apply(this as T);
		}

		var oldLatteView = latteView;
		latteView = render();
		if (latteView != null) {
			subviews = newArrayList()
			subviews.add(latteView);
			if (oldLatteView != null) {
				compareView(latteView, oldLatteView);
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
	
	def void compareView(View newView, View oldView) {
		if (newView.class != oldView.class) {
			return;
		} else {
			if (newView.latteView != null && oldView.latteView != null) {

				// Both are virtual nodes. Compare the underlying nodes
				compareView(newView.latteView, oldView.latteView);
				
				// Compare children 
				for (var i =0; i < subviews.size; i++) {
					var oldChildView = if ( oldView.subviews.size > i) oldView.subviews.get(i) else null;
					if (oldChildView != null) {
						compareView(subviews.get(i), oldChildView);
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
	
	def View render() { null; }
	
	def android.view.View getRootAndroidView() {
		if (this.androidView == null) {
			return this.latteView.rootAndroidView
		}
		return this.androidView
	}
	
	def android.view.View buildAndroidViewTree(Activity a, ViewGroup.LayoutParams lp) {
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
		if (androidView != null && lp != null) {
			androidView.layoutParams = lp;
		}
		applyAttributes
		if (subviews.size > 0) {
			var myContainer = myView as ViewGroup
			myContainer.removeAllViews
			for (View v : subviews) {
				var childLP = createLayoutParams(v.width, v.height);				
				var android.view.View childView = v.buildAndroidViewTree(a, childLP);
				myContainer.addView(childView, childLP)
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
			var nativeView = buildAndroidViewTree(a, null);
			a.setContentView(nativeView);	
		}
		
	}
	
}