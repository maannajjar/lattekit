package io.lattekit.ui

import android.R
import android.animation.Animator
import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.RippleDrawable
import android.graphics.drawable.ShapeDrawable
import android.os.Build
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.MeasureSpec
import android.view.View.OnClickListener
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.AdapterView
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import io.lattekit.State
import io.lattekit.stylesheet.Stylesheet
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

import static io.lattekit.xtend.ArrayLiterals2.*

public  class LatteView<T> implements OnTouchListener, OnClickListener {
	
	public final static int MATCH_PARENT = LayoutParams.MATCH_PARENT;
	public final static int WRAP_CONTENT = LayoutParams.WRAP_CONTENT;
	public final static int match_parent = LayoutParams.MATCH_PARENT;
	public final static int wrap_content = LayoutParams.WRAP_CONTENT;
	
	/** Base Attributes */ 
	@Accessors public String id;
	@Accessors public (LatteView<?>)=>void onTap;
	@Accessors public (LatteView<?>, MotionEvent)=>boolean onTouch;
	
	public var Animator currentAnimation;
	public var List<Animator> pendingChildAnimations = newArrayList(); 
	public var Style pendingStyle;
	
	Style classStyle;
	Style touchedClassStyle;
	Style disabledClassStyle;
	@Accessors public Style normalStyle = new Style();
	@Accessors public Style touchedStyle = new Style() => [ parentStyle = normalStyle ];
	@Accessors public Style disabledStyle = new Style() => [ parentStyle = normalStyle ];
	
	@Accessors public (Context)=>View onCreateAndroidView;
	@Accessors public Runnable onApplyAttributes
	
	Style _style = new Style();	
	@State public boolean touched = false;
	@State String cls; 
	Stylesheet stylesheet = new Stylesheet();
	
		
	// Generic Attributes
	public Map<String,Object> attributes = newHashMap();
	
	@Accessors public LatteView parentView;
	// This contains current active children
	@Accessors public List<LatteView> children = newArrayList;
	@Accessors private List<LatteView> subviews = newArrayList;
	private Map<String,Object> newProperties = newHashMap();
	
	public Context activity;
	@Accessors View androidView;
	
	public ShapeDrawable shapeDrawable;
	public LayerDrawable backgroundDrawable;
	protected (LatteView)=>void attributesProc;
	protected (LatteView)=>void layoutProc;
	private boolean isRendering = false;
	private boolean isMounted = false;
	@Accessors protected (LatteView)=>void onViewMounted;
	
	def setStyle(String style) {
		setStyle(Style.parseStyle(style));
	}
	def setTouchedStyle(String style) {
		setTouchedStyle(Style.parseStyle(style));
	}
	def setDisabledtyle(String style) {
		setDisabledStyle(Style.parseStyle(style));
	}
	def setStyle(Style style) {
		normalStyle.cloneFrom(style);
		if (_style == null) {
			_style = new Style();
			_style.cloneFrom(normalStyle);
		}		
		onStateChanged("style");	
	}
	
	def applySubviewStyles() {
		subviews.forEach[ LatteView<?> it |
			it.activeStyle.applyToView(it);
		]
	}
	
	def updateStyles() {
		classStyle = new Style();
		touchedClassStyle = new Style();
		disabledClassStyle = new Style();
		
		touchedClassStyle.parentStyle = normalStyle;
		disabledClassStyle.parentStyle = normalStyle;
		
		normalStyle.parentStyle = classStyle;
		touchedStyle.parentStyle = touchedClassStyle;
		disabledStyle.parentStyle = disabledClassStyle;
		if (cls != null) {
			cls.split(" ").forEach[
				var style = stylesheet.getClass(it) 
				Log.d("Latte","Looking for "+it +" : "+style);
				if (style != null) {
					classStyle.overrideWithStyle(style);
				}
				var touchedStyle = stylesheet.getClass(it+":touched");
				if (touchedStyle != null) touchedClassStyle.overrideWithStyle(touchedStyle); 
				var disabledStyle = stylesheet.getClass(it+":disabled");
				if (disabledStyle != null) disabledClassStyle.overrideWithStyle(disabledStyle); 
			]
		}
		
	}
	def getStyle() {
		return normalStyle;
	}
	
	def void setTouchedStyle(Style style) {
		this.touchedStyle.cloneFrom(style);
		onStateChanged("touchedStyle");	
	}
	
	def void setDisabledStyle(Style style) {
		this.disabledStyle.cloneFrom(style);
		onStateChanged("disabledStyle");	
	}
	
	def getActiveStyle() {
		if (androidView != null && !androidView.enabled && disabledStyle != null) {
			return disabledStyle
		} else if (touched && touchedStyle != null) {
			return touchedStyle;
		}
		return if (normalStyle == null) new Style() else normalStyle;
	}
	def addNewProperty(String propName, Object value) {
		newProperties.put(propName,value);
	}
	def hasProperty(String propName) {
		return newProperties.containsKey(propName);
	}
	
	def void watchTree() {
		androidView.viewTreeObserver.addOnGlobalLayoutListener([
			normalStyle._computedX = androidView.x
			normalStyle._computedY = androidView.y
			if (androidView instanceof Button) {
				Log.d("Latte", androidView.text +": My computed y is "+androidView.y)
			}
			androidView.viewTreeObserver.removeOnGlobalLayoutListener(self)
		])
	}
	
	def void initAndroidView() {
		createBackgroundDrawable();
		updateTextColorDrawable();
		if (!(androidView instanceof AdapterView)) {
			androidView.onClickListener = this;
		}
		androidView.onTouchListener = this;
		
		if (normalStyle._computedX == null) {
			watchTree();
		}
	}
	
	def void loadStylesheet(Stylesheet stylesheet) {
		stylesheet.apply(this.stylesheet);
	}

	def void loadStylesheets(List<? extends Stylesheet> stylesheets) {
		stylesheets.forEach[ it.apply(this.stylesheet) ];
	}
		
	def void applyAttributes() {
		if (androidView != null) {
			onApplyAttributes?.run
			updateStyles();
			
			if (pendingStyle == null ) {
				pendingStyle = activeStyle;
				// Shouldn't clone, apply should have the same effect of clone
				_style.deriveFrom(activeStyle);
				activeStyle.applyToView(this);
			} else /*if (pendingStyle != activeStyle && pendingStyle != null)*/ {
				// Commented out above because even activeStyle may change its values
				pendingStyle = activeStyle;
				var oldAnim = currentAnimation; 
				currentAnimation = pendingStyle.createAnimatorFrom(_style, this, activeStyle == normalStyle)
				if (oldAnim != null) {
					oldAnim.cancel();
				}
				currentAnimation.start;
			}
		}
	}
	
	override onClick(View v) {
		if (onTap != null) {
			onTap.apply(this);
		}				
	}
	
	override onTouch(View v, MotionEvent e) {	
		var handled = false;		
		if (onTouch != null && e.action == MotionEvent.ACTION_DOWN) {
			handled = onTouch.apply(this,e);
		}
		if (v.enabled) { 
			if (e.action == MotionEvent.ACTION_DOWN) {
				touched = true; 				
			} else if (e.action == MotionEvent.ACTION_UP) {
				//TODO: THIS IS DONE TO TEMPORARILY WORK AROUND ONCLICK EXECUTING AFTER THIS
				// PLEASE FIND BETTER WAY
				new Handler().postDelayed([ touched = false; ],5);
			}
		}
		if (onTouch != null && e.action == MotionEvent.ACTION_UP) {
			handled = onTouch.apply(this,e);
		}				
		return handled;
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
		// Temporarily apply style to accurately measure size
		// TODO: only apply attributes that affect size
		forStyle.applyToView(this);
	    var widthMeasureSpec = if (forStyle.width.inPixelsInt(androidView.context) == LayoutParams.MATCH_PARENT) {
	    	var parentWidth = if (nonVirtualParent != null) {
	    		nonVirtualParent.measuredSize.x;
	    	} else windowWidth;
	    	MeasureSpec.makeMeasureSpec(parentWidth, MeasureSpec.EXACTLY);
	    } else if (forStyle.width.inPixelsInt(androidView.context) == LayoutParams.WRAP_CONTENT) {
	    	MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
	    } else {
	    	MeasureSpec.makeMeasureSpec(forStyle.width.inPixelsInt(androidView.context), MeasureSpec.EXACTLY);
	    }
	    
		var heightMeasureSpec = if (forStyle.height.inPixelsInt(androidView.context) == LayoutParams.MATCH_PARENT) {
	    	var parentHeight = if (nonVirtualParent != null) {
	    		nonVirtualParent.measuredSize.y;
	    	} else windowHeight;
	    	MeasureSpec.makeMeasureSpec(parentHeight, MeasureSpec.EXACTLY);
	    } else if (forStyle.height.inPixelsInt(androidView.context) == LayoutParams.WRAP_CONTENT) {
	    	MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
	    } else {
	    	MeasureSpec.makeMeasureSpec(forStyle.height.inPixelsInt(androidView.context), MeasureSpec.EXACTLY);
	    }
		androidView.measure(widthMeasureSpec, heightMeasureSpec);
		// Go back to current style;
		_style.applyToView(this);
		return new Point(androidView.measuredWidth,androidView.measuredHeight);
	}

	def createBackgroundDrawable() {
		if (backgroundDrawable == null) {
			normalStyle.updateDrawables(this);
			backgroundDrawable = new LayerDrawable(#[new ColorDrawable(), new ColorDrawable(),new ColorDrawable()])
			backgroundDrawable.setId(0,0)
			backgroundDrawable.setId(1,1)
			backgroundDrawable.setId(2,2)
			shapeDrawable = new ShapeDrawable();
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
				androidView.background = new RippleDrawable(new ColorStateList(#[], #[]),this.backgroundDrawable, this.shapeDrawable);
			} else {			
				androidView.background =  new codetail.graphics.drawables.RippleDrawable(new ColorStateList(#[],#[]),this.backgroundDrawable, this.shapeDrawable);
			}
		}
	}
	def updateTextColorDrawable() {
		
		var List<List<Integer>> colorStates = newArrayList
		var List<Integer> colorList = newArrayList
		if (touchedStyle != null) {
			colorStates += #[ R.attr.state_enabled, R.attr.state_pressed]
			colorList += Style::asColor(touchedStyle.textColor)
		}
		colorStates += #[R.attr.state_enabled, -R.attr.state_pressed ]
		colorList += Style::asColor(style.textColor)
		
		if (disabledStyle != null) {
			colorStates += #[ -R.attr.state_enabled ]
			colorList += Style::asColor(disabledStyle.textColor)
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
	
	def View createAndroidView(Context a) {
		if (onCreateAndroidView != null) {
			return onCreateAndroidView.apply(a);
		} 
		null;
	}
	def void onChildrenAdded() {}
		

	def addChild(int index, LatteView newChild) {
		// Compare child with existing subview
		// If accepted then just call render in existing subview after transferring properties
		// If not, then add new subview
		if (index < subviews.size) {
			if (sameView(subviews.get(index),newChild)) {
				//TODO: Maybe need better way to clone states ?
				subviews.get(index).normalStyle.cloneFrom(newChild.normalStyle);
				subviews.get(index).touchedStyle.cloneFrom(newChild.touchedStyle);
				subviews.get(index).disabledStyle.cloneFrom(newChild.disabledStyle);
				
				subviews.get(index).copyStateProps(newChild)
				subviews.get(index).render();
			} else {
				subviews.set(index,newChild)
				newChild.stylesheet = stylesheet;
				newChild.render();
			}
		} else {
			subviews.add(index,newChild);
			newChild.render();
		}
	}
	
	
	
	
	def <T extends LatteView> void processNode(LatteView parent, (T)=>void attrs, (T)=>void children) {
		isRendering = true;
		parentView = parent as LatteView;
		if (parent != null) {
			parent.children.add(this);
			this.stylesheet = parent.stylesheet;
		}

		if (attrs != null) {
			attributesProc = attrs as (LatteView)=>void;
			attrs.apply(this as T);
		}
		if (children != null) {
			layoutProc = children as (LatteView)=>void;
			children.apply(this as T);
		}
		isRendering = false;
	}


	def setAttribute(String key, Object value) {
		attributes.put(key, value);
		onStateChanged(key);
	}

	def onStateChanged(String... states) {
		if (!isRendering) {
			Log.d("Latte", this+" : State changed "+ states.join(","))
			handleStateChanged
		}
	}
	
	def void handleStateChanged() {
		this.render();
		buildAndroidViewTree(activity,rootAndroidView.layoutParams);	
	}
		
	def sameView(LatteView leftView, LatteView rightView) {
		if (leftView.class == rightView.class) {
			return true;
		}
		return false;
	}
	def LayoutParams createLayoutParams(int width, int height) {
		return null;
	}
	
	def void render() {
		this.children = newArrayList();
		if (layoutProc != null) {
			layoutProc.apply(this);
		}		
	 	// This view doesn't have a render. All children are considered subviews
	 	Log.d("Latte", "in "+this+" children are "+ this.children.size)
		for (var i =0 ; i < this.children.size; i++) {
			var newChild = this.children.get(i);
			this.addChild(i,newChild);
		}	
	}
	
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
	
	def T getNativeView() {
		return androidView as T
	}
	def View buildAndroidViewTree(Context a, ViewGroup.LayoutParams lp) {
		// First build my view
		this.activity = a;
		var myView = if (this.androidView == null) {
			this.androidView = createAndroidView(a); 
			if (this.androidView != null) {
				initAndroidView();
			}
			this.androidView
		} else this.androidView;
		if (myView == null) {
			// If we don't have native android view, then we are virtual node
			var subAndroid =  this.subviews.get(0).buildAndroidViewTree(a, lp);
			if (!isMounted) {
				isMounted = true;
				onViewMounted();
			}
			return subAndroid;
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
				var childLP = createLayoutParams(v.normalStyle.width.inPixelsInt(androidView.context), v.normalStyle.height.inPixelsInt(androidView.context));
				var View childView = v.buildAndroidViewTree(a, childLP);
				if (i >= myContainer.childCount) {
					myContainer.addView(childView, i, childLP)	
				} else if (myContainer.getChildAt(i) == childView) {
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
		if (!isMounted) {
			isMounted = true;
			onViewMounted();
		}
		return myView;
	}
	
	def void onViewMounted() {
		if (onViewMounted != null) {
			onViewMounted.apply(this);
		}
	}
	
	def void renderOn(Activity a) {
		activity = a;
		this.processNode(null,null, null);
		this.render();
		this.buildAndroidViewTree(a, new FrameLayout.LayoutParams(this.normalStyle.width.inPixelsInt(a), this.normalStyle.height.inPixelsInt(a)))
		a.setContentView(this.rootAndroidView);		
	}
	

	def View buildView(Context context) {
		activity = context;
		this.processNode(null,null, null);
		this.render();
		var layoutParam = new FrameLayout.LayoutParams(this.normalStyle.width.inPixelsInt(context), this.normalStyle.height.inPixelsInt(context));
		this.buildAndroidViewTree(context, layoutParam)
		Log.d("Latte","Subview "+ this.subviews.get(0) +" width "+ this.subviews.get(0).classStyle.width.inPixelsInt(context) +" vs "+LinearLayout.MATCH_PARENT);
		
		return this.rootAndroidView;		
	}
	
}