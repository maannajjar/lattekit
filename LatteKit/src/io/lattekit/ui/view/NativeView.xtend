package io.lattekit.ui.view

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
import android.view.MotionEvent
import android.view.View
import android.view.View.MeasureSpec
import android.view.View.OnClickListener
import android.view.View.OnTouchListener
import android.view.ViewGroup.LayoutParams
import android.widget.AdapterView
import android.widget.TextView
import io.lattekit.ui.style.Style
import io.lattekit.util.Util
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors

import static io.lattekit.util.Util.*

class NativeView extends LatteView implements OnTouchListener,OnClickListener {
	
    public final static int MATCH_PARENT = LayoutParams.MATCH_PARENT;
    public final static int WRAP_CONTENT = LayoutParams.WRAP_CONTENT;
    public final static int match_parent = LayoutParams.MATCH_PARENT;
    public final static int wrap_content = LayoutParams.WRAP_CONTENT;

	Style _style = new Style();
	
	// Contains all applicable styles for each pseudo ( key for map is pseudo )
    // For example, for "touched" pseudo, the list will be all in normal + touched
    Map<String,List<Style>> allStyles = newHashMap(); 
    
    // Contains styles defined exclusively for a pseudo. 
    // For example, for "touched" pseudo, it will only returns styles that has :touched (that doesn't include normal) 
    Map<String,List<Style>> pseudoStyles = newHashMap(); // Contains styles that are only
    
    // Contains computed style for each pseudo. That's the final style object for each pseudo
    Map<String,Style> computedStyles = newHashMap(); 
    
    var Set<String> currentSelectedPseudos = newHashSet("normal"); 
    
   
	
    @Accessors public Style normalStyle = new Style();
    @Accessors public Style touchedStyle = new Style() => [ parentStyle = normalStyle ];
    @Accessors public Style disabledStyle = new Style() => [ parentStyle = normalStyle ];

    public var Animator currentAnimation;
    public var List<Animator> pendingChildAnimations = newArrayList();
    public ShapeDrawable shapeDrawable;
    public LayerDrawable backgroundDrawable;
     
	
	def View renderNative(Context context) {
		var cls = if (viewType.startsWith("android")) {
			Class.forName(viewType);
		} else {
			View
		}
		return cls.constructors.findFirst[parameterTypes.size == 1].newInstance(context) as View
	}
	def void applyProps() {
        if (androidView != null) {
	        if (this.androidView.id == -1 && this.id != null) {
	            this.androidView.id = Util.makeResId("io.lattekit", "id", id);
	        }
        	
            if (isStyleModified) {
                computeAllStyles();
            }

            if (!isMounted) {
                _style.cloneFrom(activeStyle);
                _style.applyToView(this);
            } else {
                if (isStyleModified) {
                    transitionStyle
                }
            }
            if (androidView instanceof TextView) {
            	if (props.get("text") != null) {
            		(androidView as TextView).text = props.get("text") as String
            	}
            }
        }
    }
        
    def boolean isStyleModified() {
//        var modifiedKeys = modifiedProps.keySet()
        return !isMounted /*|| modifiedKeys.contains("cls") || modifiedKeys.contains("style") || (parentView != null && parentView.isStyleModified); */
    }

	override onViewMounted() {
		if (androidView != null) {
			computeAllStyles();
			
			androidView.layoutParams.width = normalStyle.width.inPixelsInt(androidView.context);
			androidView.layoutParams.height = normalStyle.height.inPixelsInt(androidView.context)
	        createBackgroundDrawable();
	        updateTextColorDrawable();
	        
            _style.cloneFrom(activeStyle);
            _style.applyToView(this);
		
	        
	        if (!(androidView instanceof AdapterView<?>)) {
	            androidView.onClickListener = this;
	        }
	        androidView.onTouchListener = this;
	        
	        if (normalStyle._computedX == null) {
	            watchTree();
	        }
		}
    }
    
	def void watchTree() {
        androidView.viewTreeObserver.addOnGlobalLayoutListener([
            normalStyle._computedX = androidView.x
            normalStyle._computedY = androidView.y
            androidView.viewTreeObserver.removeOnGlobalLayoutListener(self)
        ])
    }

    
    def Point getMeasuredSize() {
        return getMeasuredSize(computedStyles.get("normal"));
    }
    
    def getWindowWidth() {
        androidView.context.getResources().getDisplayMetrics().widthPixels
    }
    
    def getWindowHeight() {
        androidView.context.getResources().getDisplayMetrics().heightPixels
    }
    
    def Point getMeasuredSize(Style forStyle) {
        // Temporarily apply style to accurately measure size
        // TODO: only apply props that affect size
        forStyle.applyToView(this);
        var widthMeasureSpec = if (forStyle.width.inPixelsInt(androidView.context) == LayoutParams.MATCH_PARENT) {
            var parentWidth = if (nonVirtualParent != null) {
                nonVirtualParent.measuredSize.x-forStyle.marginLeft.inPixelsInt(androidView.context)-forStyle.marginRight.inPixelsInt(androidView.context);
            } else windowWidth;
            MeasureSpec.makeMeasureSpec(parentWidth, MeasureSpec.EXACTLY);
        } else if (forStyle.width.inPixelsInt(androidView.context) == LayoutParams.WRAP_CONTENT) {
            MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        } else {
            MeasureSpec.makeMeasureSpec(forStyle.width.inPixelsInt(androidView.context), MeasureSpec.EXACTLY);
        }
        
        var heightMeasureSpec = if (forStyle.height.inPixelsInt(androidView.context) == LayoutParams.MATCH_PARENT) {
            var parentHeight = if (nonVirtualParent != null) {
                nonVirtualParent.measuredSize.y-forStyle.marginTop.inPixelsInt(androidView.context)-forStyle.marginBottom.inPixelsInt(androidView.context);
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
            shapeDrawable = new ShapeDrawable(computedStyles.get("touched").getShape(this));
            var rippleColor = new ColorStateList( #[ #[] ], #[ Style.asColor(computedStyles.get("touched").rippleColor) ]);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                androidView.background = new RippleDrawable(rippleColor,backgroundDrawable, shapeDrawable);
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
        colorList += Style::asColor(normalStyle.textColor)
        
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
//          androidView.textColor = new ColorStateList(colorStatesArray, colorList);    
        }
    }
    
    override onTouch(View v, MotionEvent e) {
        if (pseudoStyles.get("touched").empty /*&& onTouch == null  */) {
            // No need to handle touch here
            return false;
        }   
        
        var handled = false;        
        if (/*onTouch != null && */e.action == MotionEvent.ACTION_DOWN) {
//            handled = onTouch.apply(this,e);
        }
        if (v.enabled) { 
            if (e.action == MotionEvent.ACTION_DOWN) {
                currentSelectedPseudos += "touched";
                updateStyles(true,true);                
            } else if (e.action == MotionEvent.ACTION_UP) {
                //TODO: THIS IS DONE TO TEMPORARILY WORK AROUND ONCLICK EXECUTING AFTER THIS
                // PLEASE FIND BETTER WAY
                currentSelectedPseudos -= "touched";
                updateStyles(true,true)
            }
        }
        if (/*onTouch != null && */ e.action == MotionEvent.ACTION_UP) {
//            handled = onTouch.apply(this,e);
        }               
        return handled;
    }

    def applySubviewStyles() {
        children.forEach[ LatteView it |
            (it as NativeView).activeStyle.applyToView( it as NativeView);
        ]
    }
    
    
    def List<Style> getSelectedStyles() {
        allStyles.keySet.filter[currentSelectedPseudos.contains(it)].map[ allStyles.get(it) ].flatten.toList 
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
            (parentView as NativeView).findDesecendantStyles(selectors,outList);
        }
        selectedStyles.forEach[  style | 
            selectors.forEach[ selector |
                if (style.descendantStyles.containsKey(selector)) {
                    outList += style.descendantStyles.get(selector);
                }
            ]
        ]
    }
    def String getCls() {
    	return props.get("cls") as String
    }
    
    def List<Style> computeStyle(String pseudo) {
        // TODO: re-use previous computed style and just reset it 
        val targetStyle = new Style(); 
        val mySelectors = newArrayList("View");
        if (cls != null) {
            cls.split(" ").forEach[
                mySelectors += "."+it;
            ]
        }
        var List<Style> selectedStyles = newArrayList();
        if (pseudo != "normal") {
            mySelectors += mySelectors.map[it+":"+pseudo];
        }
        selectedStyles += mySelectors.map[ stylesheet.getStyle(it)].filterNull
        if (parentView != null) {
            (parentView as NativeView).findDesecendantStyles(mySelectors, selectedStyles)
            (parentView as NativeView).findDirectChildrenStyles(mySelectors, selectedStyles);
        }
        selectedStyles.forEach[
            targetStyle.overrideWithStyle(it);
        ]
        targetStyle.overrideWithStyle(normalStyle);
        if ( pseudo == "touched") {
            targetStyle.overrideWithStyle(touchedStyle);
        }
        
        if (pseudo == "normal") {
            allStyles.put("normal", selectedStyles);
            pseudoStyles.put("normal", selectedStyles);
        } else {
            allStyles.put(pseudo, selectedStyles);
            // In order for this to work properly, computeStyle for normal should be called always before
            pseudoStyles.put(pseudo, selectedStyles.filter[!allStyles.get("normal").contains(it)].toList);                      
        }
        computedStyles.put(pseudo, targetStyle);
        
        return selectedStyles
        
    }
    
    def computeAllStyles() {
        computeStyle("normal");
        computeStyle("touched");
    }
    
    def computeActiveStyles() {
        currentSelectedPseudos.forEach[pseudo | computeStyle(pseudo) ]
    }

    def void updateStyles(boolean shouldTransition, boolean shouldUpdateChildren) {
        
        if (shouldTransition) {
            transitionStyle();
        }
        // TODO: Only update lower levels if we really need to      
        if (shouldUpdateChildren) {
            children.forEach[ computeActiveStyles(); updateStyles(shouldTransition, shouldUpdateChildren) ]
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
        
    def getActiveStyle() {
        if (androidView != null && !androidView.enabled && disabledStyle != null) {
            return disabledStyle
        } else if (currentSelectedPseudos.contains("touched") && touchedStyle != null) {
            return computedStyles.get("touched");
        }
        return computedStyles.get("normal");
    }        
    

    def NativeView getNonVirtualParent() {
        if (parentView == null) {
            return null;
        }
        if (parentView.androidView != null) {
            return parentView as NativeView;
        }
        return (parentView as NativeView).nonVirtualParent
    }
    
    
    def Activity getActivity() {
    	return (rootAndroidView.context as Activity)
    }
				
	override onClick(View v) {

	}
    
}