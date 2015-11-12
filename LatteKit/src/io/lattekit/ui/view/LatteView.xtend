package io.lattekit.ui.view

import android.R
import android.animation.Animator
import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.MeasureSpec
import android.view.View.OnClickListener
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.AdapterView
import android.widget.FrameLayout
import android.widget.TextView
import codetail.graphics.drawables.RippleDrawable
import io.lattekit.State
import io.lattekit.ui.style.Style
import io.lattekit.ui.style.Stylesheet
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

	List<Style> selectedStyles = newArrayList();
	
	
	@Accessors public Style computedStyle = new Style();
	@Accessors public Style computedStyleTouched = new Style();
	
	@Accessors public Style normalStyle = new Style();
	@Accessors public Style touchedStyle = new Style() => [ parentStyle = normalStyle ];
	@Accessors public Style disabledStyle = new Style() => [ parentStyle = normalStyle ];
	
	@Accessors public (Context)=>View onCreateAndroidView;
	@Accessors public Runnable onApplyAttributes
	
	Style _style = new Style();	
	public boolean touched = false;
	@State String cls; 
	Stylesheet stylesheet = new Stylesheet();
	
	private var boolean dirtyState = false;
	
		
	// Generic Attributes
	public Map<String,Object> attributes = newHashMap();
	
	@Accessors public LatteView<?> parentView;
	// This contains current active children
	@Accessors public List<LatteView<?>> children = newArrayList;
	@Accessors private List<LatteView<?>> subviews = newArrayList;
	private Map<String,Object> newProperties = newHashMap();
	
	public Context activity;
	@Accessors View androidView;
	
	public ShapeDrawable shapeDrawable;
	public LayerDrawable backgroundDrawable;
	protected (LatteView<?>)=>void attributesProc;
	protected (LatteView<?>)=>void layoutProc;
	private boolean isRendering = false;
	private boolean isMounted = false;
	@Accessors protected (LatteView<?>)=>void onViewMounted;

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
	
	def void findDirectChildrenStyles(List<String> selectors, List<Style> outList) {
		selectedStyles.forEach[  style | 
			selectors.forEach[ selector |
				if (style.directChildrenStyles.containsKey(selector)) {
					outList += style.directChildrenStyles.get(selector);
				}
			]
		]
	}
	
	def void findDesecendantStyles(List<String> selectors, List<Style> outList) {
		if (parentView != null) {
			parentView.findDesecendantStyles(selectors,outList);
		}
		selectedStyles.forEach[  style | 
			selectors.forEach[ selector |
				if (style.descendantStyles.containsKey(selector)) {
					outList += style.descendantStyles.get(selector);
				}
			]
		]
	}
	
	def void computeStyle(Style targetStyle,String pseudo) {
		val mySelectors = newArrayList("View");
		if (cls != null) {
			cls.split(" ").forEach[
				mySelectors += "."+it;
			]
		}
		
		selectedStyles.clear();
		if (pseudo != null) {
			mySelectors += mySelectors.map[it+":"+pseudo];
		}
		selectedStyles += mySelectors.map[ stylesheet.getStyle(it)].filterNull
		if (parentView != null) {
			parentView.findDesecendantStyles(mySelectors, selectedStyles)
			parentView.findDirectChildrenStyles(mySelectors, selectedStyles);
		}
		selectedStyles.forEach[
			targetStyle.overrideWithStyle(it);
		]
		targetStyle.overrideWithStyle(normalStyle);
		if (pseudo != null && pseudo == "touched") {
			targetStyle.overrideWithStyle(touchedStyle);
		}
		
	}

	def void updateStyles(boolean shouldTransition, boolean shouldUpdateChildren) {
		// TODO: do a better way to reset styles than creating new object
		computedStyle = new Style();
		computedStyleTouched = new Style();
		computeStyle(computedStyle,null);
		computeStyle(computedStyleTouched,"touched");
		
		if (shouldTransition) {
			transitionStyle();
		}
		// TODO: Only update lower levels if we really need to		
		if (shouldUpdateChildren) {
			subviews.forEach[ updateStyles(shouldTransition, shouldUpdateChildren) ]
		} 
	}
	
	def transitionStyle() {
		if (androidView != null) {
			var oldAnim = currentAnimation; 
			currentAnimation = activeStyle.createAnimatorFrom(_style, this, false)
			if (oldAnim != null) {
				oldAnim.cancel();
			}
			currentAnimation.start;
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
			return computedStyleTouched;
		}
		return computedStyle;
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
			androidView.viewTreeObserver.removeOnGlobalLayoutListener(self)
		])
	}
	
	def void initAndroidView() {
		createBackgroundDrawable();
		updateTextColorDrawable();
		if (!(androidView instanceof AdapterView<?>)) {
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
			updateStyles(false, false);
			if (backgroundDrawable == null) {
				initAndroidView();
			}
			if (!isMounted) {
				_style.cloneFrom(activeStyle);
				_style.applyToView(this);
			} else {
				transitionStyle
			}
			onApplyAttributes?.run
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
				updateStyles(true,true); 				
			} else if (e.action == MotionEvent.ACTION_UP) {
				//TODO: THIS IS DONE TO TEMPORARILY WORK AROUND ONCLICK EXECUTING AFTER THIS
				// PLEASE FIND BETTER WAY
				touched = false; 
				updateStyles(true,true)
			}
		}
		if (onTouch != null && e.action == MotionEvent.ACTION_UP) {
			handled = onTouch.apply(this,e);
		}				
		return handled;
	}
	
	
	def Point getMeasuredSize() {
		return getMeasuredSize(computedStyle);
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
			backgroundDrawable = new LayerDrawable(#[new ColorDrawable(), new ColorDrawable(),new ColorDrawable()])
			backgroundDrawable.setId(0,0)
			backgroundDrawable.setId(1,1)
			backgroundDrawable.setId(2,2)
			shapeDrawable = new ShapeDrawable();
			var rippleColor = new ColorStateList( #[ #[] ], #[ Style.asColor(computedStyleTouched.rippleColor) ]);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
				androidView.background = new android.graphics.drawable.RippleDrawable(rippleColor,backgroundDrawable, shapeDrawable);
			} else {			
				androidView.background =  new RippleDrawable(rippleColor,backgroundDrawable, this.shapeDrawable);
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
//			androidView.textColor = new ColorStateList(colorStatesArray, colorList);	
		}
	}
	
	def View createAndroidView(Context a) {
		if (onCreateAndroidView != null) {
			return onCreateAndroidView.apply(a);
		}
		null;
	}
	def void onChildrenAdded() {}
		

	def addChild(int index, LatteView<?> newChild) {
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
			newChild.stylesheet = stylesheet;
			newChild.render();
		}
	}
	
	def <T extends LatteView<?>> void processNode(LatteView<?> parent, (T)=>void attrs, (T)=>void children) {
		isRendering = true;
		parentView = parent as LatteView<?>;
		if (parent != null) {
			parent.children.add(this);
			this.stylesheet = parent.stylesheet;
		}

		if (attrs != null) {
			attributesProc = attrs as (LatteView<?>)=>void;
			attrs.apply(this as T);
		}
		if (children != null) {
			layoutProc = children as (LatteView<?>)=>void;
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
			if (!dirtyState) {
				// No need to post another task if dirtyState is already true
				dirtyState = true;
			    new Handler(Looper.getMainLooper()).postAtFrontOfQueue([
			 		handleStateChanged
			 		dirtyState = false;   	
			    ])
			}
		}
	}
	
	def void handleStateChanged() {
		this.render();
		buildAndroidViewTree(activity,rootAndroidView.layoutParams);	
	}
		
	def sameView(LatteView<?> leftView, LatteView<?> rightView) {
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
	
	def LatteView<?> getNonVirtualParent() {
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
		if (this.androidView == null) {
			this.androidView = createAndroidView(a); 
		}
		if (this.androidView == null) {
			// If we don't have native android view, then we are virtual node
			var subAndroid =  this.subviews.get(0).buildAndroidViewTree(a, lp);
			if (!isMounted) {
				isMounted = true;
				onViewMounted();
			}
			return subAndroid;
		}
		
		if (this.androidView.id == -1 && this.id != null) {
			this.androidView.id = this.id.hashCode
		}
		if (this.androidView.layoutParams == null) {
			this.androidView.layoutParams = lp;
		}
		this.applyAttributes();
		if (subviews.size > 0) {
			var myContainer = androidView as ViewGroup
			var i = 0;
			for (LatteView<?> v : subviews) {
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
			onChildrenAdded();
		}
		
		if (!isMounted) {
			isMounted = true;
			onViewMounted();
		}
		return androidView;
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
		return this.rootAndroidView;		
	}
	
}