package io.lattekit.ui.style;

import android.R
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.AssetManager
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff.Mode
import android.graphics.Shader.TileMode
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Build
import android.os.Handler
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.MarginLayoutParams
import android.widget.TextView
import codetail.graphics.drawables.RippleDrawable
import io.lattekit.StyleProperty
import io.lattekit.ui.drawable.BorderDrawable
import io.lattekit.ui.view.LatteView
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors

import static extension io.lattekit.xtend.ArrayLiterals2.*

class Style {
	@Accessors String definedSelector;
	
    @Accessors Map<String, Style> descendantStyles = newHashMap();
    @Accessors Map<String, Style> directChildrenStyles = newHashMap();
    @Accessors Map<String, Style> siblingStyles = newHashMap();
    
    @Accessors Style parentStyle;
    @StyleProperty public Object backgroundColor = Color.WHITE;
    @StyleProperty public Object rippleColor = Color.TRANSPARENT;
    @StyleProperty public Object textColor = Color.BLACK;
    
    @StyleProperty public String backgroundDrawable = "";
    @StyleProperty public String backgroundRepeat = "no-repeat-x no-repeat-y";
    @StyleProperty public String backgroundGravity = "fill_vertical, fill_horizontal";
    @StyleProperty public Object backgroundFilterColor = Color.TRANSPARENT;
    @StyleProperty public String backgroundFilterType = "SRC_ATOP";
    
    
    @StyleProperty public Object borderLeftColor = Color.BLACK;
    @StyleProperty public Object borderTopColor = Color.BLACK;
    @StyleProperty public Object borderRightColor = Color.BLACK;
    @StyleProperty public Object borderBottomColor = Color.BLACK;
    
        
    @StyleProperty public NumberValue borderTopLeftRadiusH  = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue borderTopRightRadiusH  = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue borderBottomLeftRadiusH = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue borderBottomRightRadiusH = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty public NumberValue borderTopLeftRadiusV = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue borderTopRightRadiusV = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue borderBottomLeftRadiusV = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue borderBottomRightRadiusV = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty public NumberValue borderLeftWidth = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue borderTopWidth = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue borderRightWidth = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue borderBottomWidth = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
        
    @StyleProperty public NumberValue marginTop = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue marginBottom = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue marginLeft = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue marginRight = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty public NumberValue elevation = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue translationY = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue translationX = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue x;
    @StyleProperty public NumberValue y;
    public Float _computedX;
    public Float _computedY;
    
    @StyleProperty public NumberValue paddingTop = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue paddingBottom = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue paddingLeft = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue paddingRight = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty public String fontFamily = "default";
    @StyleProperty public String fontStyle = "bold";
    @StyleProperty public NumberValue fontSize;
    
    @StyleProperty public List<List<Object>> transitions;
    
    @StyleProperty public NumberValue width = new NumberValue(ViewGroup.LayoutParams.WRAP_CONTENT, TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue height = new NumberValue(ViewGroup.LayoutParams.WRAP_CONTENT, TypedValue.COMPLEX_UNIT_PX);
    
    
    static Set<String> DRAWABLE_PROPS = newHashSet("borderColor","borderTopColor","borderLeftColor","borderRightColor","borderBottomColor","borderRadius","borderTopLeftRadiusV","borderTopRightRadiusV","borderBottomLeftRadiusV","borderBottomRightRadiusV","borderTopLeftRadiusH","borderTopRightRadiusH","borderBottomLeftRadiusH","borderBottomRightRadiusH","backgroundDrawable","backgroundFilterColor","backgroundFilterType","backgroundFilter","backgroundRepeat","backgroundGravity","backgroundColor","rippleColor","borderWidth","borderLeftWidth","borderRightWidth","borderTopWidth","borderBottomWidth")
    static Set<String> SHAPE_PROPS = newHashSet("borderColor","borderTopColor","borderLeftColor","borderRightColor","borderBottomColor","borderRadius","borderTopLeftRadiusV","borderTopRightRadiusV","borderBottomLeftRadiusV","borderBottomRightRadiusV","borderTopLeftRadiusH","borderTopRightRadiusH","borderBottomLeftRadiusH","borderBottomRightRadiusH","backgroundDrawable","backgroundFilterColor","backgroundFilterType","backgroundFilter","backgroundRepeat","backgroundGravity","backgroundColor","rippleColor","borderWidth","borderLeftWidth","borderRightWidth","borderTopWidth","borderBottomWidth");
    
    static Map<String,Typeface> allFonts;
    
    protected GradientDrawable backgroundGradientDrawable;
    protected Drawable backgroundImageDrawable;
    
    protected BorderDrawable borderDrawable;
    
    def static initFonts(Context context) {
    	if (allFonts == null) {
    		allFonts = newHashMap();
    		loadFontsInAssetPath(context.assets, "", allFonts);
    	}
    }
    
    def static void loadFontsInAssetPath(AssetManager assets, String path, Map<String,Typeface> fonts) {
    	assets.list(path).forEach[
    		if (assets.list(it).length > 0 ){
    			loadFontsInAssetPath(assets,it,fonts);
    		} else {
    			if (it.endsWith(".ttf") || it.endsWith(".otf")) {
    				try {
    					var font = Typeface.createFromAsset(assets, it);
    					allFonts.put(it.substring(0,it.length-4).toLowerCase(), font);
    				} catch (Exception ex) {
    					
    				}
    			}
    		}
    	]
    }
    
    def static Style newStyle(Object... keysAndValues) {
    	var Style style = new Style=> [
			keysAndValues.forEach[ Object v, int index |
				if (index %2 == 0) {
					setProperty(v as String, keysAndValues.get(index+1));
				}
			]    		
    	]
    	return style;
    }
    
    def overrideWithStyle(Style overridingStyle) {
        _backgroundColor = overridingStyle._backgroundColor ?: _backgroundColor
        _rippleColor = overridingStyle._rippleColor ?: _rippleColor
        _borderLeftColor = overridingStyle._borderLeftColor ?: _borderLeftColor
        _borderTopColor = overridingStyle._borderTopColor ?: _borderTopColor
        _borderRightColor = overridingStyle._borderRightColor ?: _borderRightColor
        _borderBottomColor = overridingStyle._borderBottomColor ?: _borderBottomColor
        
        _textColor = overridingStyle._textColor ?: _textColor
        _backgroundDrawable = overridingStyle._backgroundDrawable ?: _backgroundDrawable
        _backgroundFilterColor = overridingStyle._backgroundFilterColor ?: _backgroundFilterColor
        _backgroundFilterType = overridingStyle._backgroundFilterType ?: _backgroundFilterType
        
        _backgroundRepeat = overridingStyle._backgroundRepeat ?: _backgroundRepeat
        _backgroundGravity = overridingStyle._backgroundGravity ?: _backgroundGravity

        _borderTopLeftRadiusH = overridingStyle._borderTopLeftRadiusH ?: _borderTopLeftRadiusH
        _borderTopRightRadiusH = overridingStyle._borderTopRightRadiusH ?: _borderTopRightRadiusH
        _borderBottomLeftRadiusH = overridingStyle._borderBottomLeftRadiusH ?: _borderBottomLeftRadiusH
        _borderBottomRightRadiusH = overridingStyle._borderBottomRightRadiusH ?: _borderBottomRightRadiusH
        
        _borderTopLeftRadiusV = overridingStyle._borderTopLeftRadiusV ?: _borderTopLeftRadiusV
        _borderTopRightRadiusV = overridingStyle._borderTopRightRadiusV ?: _borderTopRightRadiusV
        _borderBottomLeftRadiusV = overridingStyle._borderBottomLeftRadiusV ?: _borderBottomLeftRadiusV
        _borderBottomRightRadiusV = overridingStyle._borderBottomRightRadiusV ?: _borderBottomRightRadiusV

        
        _borderLeftWidth = overridingStyle._borderLeftWidth ?: _borderLeftWidth
        _borderTopWidth = overridingStyle._borderTopWidth ?: _borderTopWidth
        _borderRightWidth = overridingStyle._borderRightWidth ?: _borderRightWidth
        _borderBottomWidth = overridingStyle._borderBottomWidth ?: _borderBottomWidth
        
        
        _marginTop = overridingStyle._marginTop ?: _marginTop
        _marginBottom = overridingStyle._marginBottom ?: _marginBottom
        _marginLeft = overridingStyle._marginLeft ?: _marginLeft
        _marginRight = overridingStyle._marginRight ?: _marginRight
        _elevation = overridingStyle._elevation ?: _elevation
        _translationX = overridingStyle._translationX ?: _translationX
        _translationY = overridingStyle._translationY ?: _translationY
        
        _x = overridingStyle.x ?: _x
        _y = overridingStyle.y ?: _y
        
        _paddingTop = overridingStyle._paddingTop ?: _paddingTop
        _paddingBottom = overridingStyle._paddingBottom ?: _paddingBottom
        _paddingLeft = overridingStyle._paddingLeft ?: _paddingLeft
        _paddingRight = overridingStyle._paddingRight ?: _paddingRight
        
        _width = overridingStyle._width ?: _width
        _height = overridingStyle._height ?: _height
        
        _fontStyle = overridingStyle._fontStyle ?: _fontStyle
        _fontFamily = overridingStyle._fontFamily ?: _fontFamily
        _fontSize = overridingStyle._fontSize ?: _fontSize
        
        _transitions = overridingStyle._transitions ?: _transitions;
    }

    def void deriveFrom(Style form) {
        this.backgroundColor = form.backgroundColor
        this.rippleColor = form.rippleColor
        this.borderTopColor = form.borderTopColor
        this.borderLeftColor = form.borderLeftColor
        this.borderRightColor = form.borderRightColor
        this.borderBottomColor = form.borderBottomColor
        
        this.textColor = form.textColor
        this.backgroundDrawable = form.backgroundDrawable
        this.backgroundFilterColor = form.backgroundFilterColor
        this.backgroundFilterType = form.backgroundFilterType
        
        this.backgroundRepeat = form.backgroundRepeat;
        this.backgroundGravity = form.backgroundGravity;

        this.borderTopLeftRadiusH = form.borderTopLeftRadiusH
        this.borderTopRightRadiusH = form.borderTopRightRadiusH
        this.borderBottomLeftRadiusH = form.borderBottomLeftRadiusH
        this.borderBottomRightRadiusH = form.borderBottomRightRadiusH
        
        this.borderTopLeftRadiusV = form.borderTopLeftRadiusV
        this.borderTopRightRadiusV = form.borderTopRightRadiusV
        this.borderBottomLeftRadiusV = form.borderBottomLeftRadiusV
        this.borderBottomRightRadiusV = form.borderBottomRightRadiusV

        this.borderLeftWidth = form.borderLeftWidth
        this.borderTopWidth = form.borderTopWidth
        this.borderRightWidth = form.borderRightWidth
        this.borderBottomWidth = form.borderBottomWidth
        
        this.marginTop = form.marginTop
        this.marginBottom = form.marginBottom
        this.marginLeft = form.marginLeft
        this.marginRight = form.marginRight
        this.elevation = form.elevation
        this.translationX = form.translationX
        this.translationY = form.translationY
        this.paddingTop = form.paddingTop
        this.paddingBottom = form.paddingBottom
        this.paddingLeft = form.paddingLeft
        this.paddingRight = form.paddingRight
        this.width = form.width
        this.height = form.height
        this.fontSize = form.fontSize
        this.fontStyle = form.fontStyle
        this.fontFamily = form.fontFamily
        this.transitions = form.transitions
        this.x = form.x
        this.y = form.y
    }
    def void cloneFrom(Style form) {
        this.backgroundColor = form._backgroundColor
        this.rippleColor = form._rippleColor
        this.borderTopColor = form._borderTopColor
        this.borderLeftColor = form._borderLeftColor
        this.borderRightColor = form._borderRightColor
        this.borderBottomColor = form._borderBottomColor
        
        this.textColor = form._textColor
        this.backgroundDrawable = form._backgroundDrawable
        this.backgroundFilterColor = form._backgroundFilterColor
        this.backgroundFilterType = form._backgroundFilterType
        
        this.backgroundRepeat = form._backgroundRepeat
        this.backgroundGravity = form._backgroundGravity

        this.borderTopLeftRadiusH = form._borderTopLeftRadiusH
        this.borderTopRightRadiusH = form._borderTopRightRadiusH
        this.borderBottomLeftRadiusH = form._borderBottomLeftRadiusH
        this.borderBottomRightRadiusH = form._borderBottomRightRadiusH
        
        this.borderTopLeftRadiusV = form._borderTopLeftRadiusV
        this.borderTopRightRadiusV = form._borderTopRightRadiusV
        this.borderBottomLeftRadiusV = form._borderBottomLeftRadiusV
        this.borderBottomRightRadiusV = form._borderBottomRightRadiusV
        

        this.borderTopWidth = form._borderTopWidth
        this.borderLeftWidth = form._borderLeftWidth
        this.borderRightWidth = form._borderRightWidth
        this.borderBottomWidth = form._borderBottomWidth
        
        this.marginTop = form._marginTop
        this.marginBottom = form._marginBottom
        this.marginLeft = form._marginLeft
        this.marginRight = form._marginRight
        this.elevation = form._elevation
        this.translationX = form._translationX
        this.translationY = form._translationY
        this.paddingTop = form._paddingTop
        this.paddingBottom = form._paddingBottom
        this.paddingLeft = form._paddingLeft
        this.paddingRight = form._paddingRight
        this.width = form._width
        this.height = form._height
        this.fontSize = form._fontSize
        this.fontStyle = form._fontStyle
        this.fontFamily = form._fontFamily
        this.transitions = form._transitions
        this.x = form._x
        this.y = form._y
    }
    
    override Style clone() {
        var myStyle = new Style()   
        myStyle.cloneFrom(this);
        return myStyle
    }
    
    def createAnimatorFrom(Style startStyle,LatteView<?> latteView, boolean revertToNormal) {
        val animSet = new AnimatorSet();
        val List<String> transitionProperties = newArrayList();
        val List<List<Object>> expandedTransitions = newArrayList();
         if (transitions != null) {
         	 
         	transitions.forEach[
				val transitionName = it.get(0) as String;

	        	if (transitionName == "borderRadius") {
	        		transitionProperties += "borderTopLeftRadiusH"
	        		transitionProperties += "borderTopRightRadiusH"
	        		transitionProperties += "borderBottomLeftRadiusH"
	        		transitionProperties += "borderBottomRightRadiusH"
	        		transitionProperties += "borderTopLeftRadiusV"
	        		transitionProperties += "borderTopRightRadiusV"
	        		transitionProperties += "borderBottomLeftRadiusV"
	        		transitionProperties += "borderBottomRightRadiusV"
	        		expandedTransitions += #["borderTopLeftRadiusH", it.get(1), it.get(2),it.get(3)];
	        		expandedTransitions += #["borderTopRightRadiusH", it.get(1), it.get(2),it.get(3)];
	        		expandedTransitions += #["borderBottomLeftRadiusH", it.get(1), it.get(2),it.get(3)];
	        		expandedTransitions += #["borderBottomRightRadiusH", it.get(1), it.get(2),it.get(3)];
	        		expandedTransitions += #["borderTopLeftRadiusV", it.get(1), it.get(2),it.get(3)];
	        		expandedTransitions += #["borderTopRightRadiusV", it.get(1), it.get(2),it.get(3)];
	        		expandedTransitions += #["borderBottomLeftRadiusV", it.get(1), it.get(2),it.get(3)];
	        		expandedTransitions += #["borderBottomRightRadiusV", it.get(1), it.get(2),it.get(3)];
	        		
	        	} else if (transitionName == "borderWidth") {
	        		transitionProperties += "borderLeftWidth"
	        		transitionProperties += "borderRightWidth"
	        		transitionProperties += "borderBottomWidth"
	        		transitionProperties += "borderTopWidth"
	        		
	        		expandedTransitions += #["borderLeftWidth", it.get(1), it.get(2),it.get(3)];
	        		expandedTransitions += #["borderRightWidth", it.get(1), it.get(2),it.get(3)];
	        		expandedTransitions += #["borderBottomWidth", it.get(1), it.get(2),it.get(3)];
	        		expandedTransitions += #["borderTopWidth", it.get(1), it.get(2),it.get(3)];
	        		
	        	} else if (transitionName == "background-filter") {  
	        		transitionProperties +="backgroundFilterColor"
	        		expandedTransitions += #["background-filter-color", it.get(1), it.get(2),it.get(3)];
	        		
	        	} else if (transitionName == "padding" || transitionName == "margin") { 
	        		transitionProperties += transitionName+"Top";
	        		transitionProperties += transitionName+"Left";
	        		transitionProperties += transitionName+"Right";
	        		transitionProperties += transitionName+"Bottom";
	        		
	        		expandedTransitions += #[transitionName+"Top", it.get(1), it.get(2),it.get(3)];
	        		expandedTransitions += #[transitionName+"Left", it.get(1), it.get(2),it.get(3)];
	        		expandedTransitions += #[transitionName+"Right", it.get(1), it.get(2),it.get(3)];
	        		expandedTransitions += #[transitionName+"Bottom", it.get(1), it.get(2),it.get(3)];
	        	} else {
	        		transitionProperties += transitionName
	        		expandedTransitions += #[it.get(0), it.get(1), it.get(2),it.get(3)];
	        	}
	        	
	        ]
        }
        
        val actualSize = latteView.getMeasuredSize(this);
        val startActualSize = latteView.getMeasuredSize(startStyle);
        
        var immediateAnim =  ValueAnimator.ofInt(0,1);
        _properties.filter[!transitionProperties.contains(it)].forEach[
            if (it == "x" && _computedX != null && revertToNormal && startStyle.x != null) {
                startStyle.setProperty(it, new NumberValue(_computedX, TypedValue.COMPLEX_UNIT_PX));
            } else if (it == "y" && _computedY != null && revertToNormal  && startStyle.y != null) {
                startStyle.setProperty(it, new NumberValue(_computedY, TypedValue.COMPLEX_UNIT_PX));
            }  else if ( this.getProperty(it) != null) {
                startStyle.setProperty(it, this.getProperty(it));
            }
            startStyle.applyToView(latteView,it)
        ]

        var List<Animator> allAnims = newArrayList();
        allAnims += immediateAnim;
        if (transitions != null) {
            allAnims += expandedTransitions.map[
                val propName = it.get(0) as String;
                val duration = (it.get(1) as Integer) ?: 0;
                val delay = (it.get(3) as Integer) ?: 0;

                var startValue = if (propName == "x") {
                    latteView.androidView.x
                } else if (propName == "y") {
                     latteView.androidView.y
                } else {
                    startStyle.getProperty(propName);
                }
                var myValue = if (propName == "x" && _computedX != null && revertToNormal) {
                    _computedX;
                } else if (propName == "y" && _computedY != null && revertToNormal) {
                     _computedY;
                } else {
                    this.getProperty(propName);
                }
                var ValueAnimator anim = null;
                if (propName == "width") {
                    myValue = new NumberValue(actualSize.x,0);
                    startValue = new NumberValue(startActualSize.x,0);
                }
                if (propName == "height") {
                    myValue = new NumberValue(actualSize.y,0)
                    startValue = new NumberValue(startActualSize.y,0)
                }
                if (myValue == null || startValue == null) {
                    Log.d("Latte", latteView +": No start or end value for "+propName)
                    return null;
                }
                
                if (startValue instanceof NumberValue && (startValue as NumberValue).valueType == "Integer") {
                    var start = if (startValue instanceof NumberValue) { startValue.inPixelsInt(latteView.androidView.context); } else { startValue as Integer}
                    var end = if (myValue instanceof NumberValue) { myValue.inPixelsInt(latteView.androidView.context); } else { myValue as Integer}
                    anim = ValueAnimator.ofInt(start,end);
                    anim.addUpdateListener([ 
                        if (latteView.currentAnimation == animSet) { 
                            startStyle.setProperty(propName, new NumberValue(animatedValue as Integer, 0));
                            startStyle.applyToView(latteView,propName)
                        }
                    ]);
                } else if (startValue instanceof NumberValue && (startValue as NumberValue).valueType == "Float") {
                    var start = if (startValue instanceof NumberValue) { startValue.inPixels(latteView.androidView.context); } else { startValue as Float;}
                    var end = if (myValue instanceof NumberValue) { myValue.inPixels(latteView.androidView.context); } else { myValue as Float;}
                    anim = ValueAnimator.ofFloat(start, end);
                    anim.addUpdateListener([
                        if (latteView.currentAnimation == animSet) { 
                            startStyle.setProperty(propName, new NumberValue(animatedValue as Float, 0));
                            startStyle.applyToView(latteView,propName)
                        }
                    ]);
                }
                if (anim != null) {
                    anim.setDuration(duration)
                    anim.startDelay = delay
                }
                
                return anim;
            ].filterNull
        }
		animSet.playTogether(allAnims);
        val nativeParent = latteView.nonVirtualParent;
        if (nativeParent != null) {
        	nativeParent.pendingChildAnimations += animSet;
	        animSet.addListener(new AnimatorListenerAdapter() {
				override onAnimationEnd(Animator animation) {
					nativeParent.pendingChildAnimations.remove(animSet);
					new Handler().postDelayed([
						if (nativeParent.pendingChildAnimations.isEmpty) {
							nativeParent.applySubviewStyles
						}
					],10);
				}
	        })
	    }
        return animSet
    }
    
    
    def setBorderBottom(NumberValue borderWidth, String borderStyle, Object borderColor) {
    	if (borderWidth != null) {
    		this.borderBottomWidth = borderWidth
    	}
    	if (borderColor != null) {
    		this.borderBottomColor = borderColor;
    	}
    }
    
    def setBorderTop(NumberValue borderWidth, String borderStyle, Object borderColor) {
    	if (borderWidth != null) {
    		this.borderTopWidth = borderWidth
    	}
    	if (borderColor != null) {
    		this.borderTopColor = borderColor;
    	}
    }
    
    def setBorderLeft(NumberValue borderWidth, String borderStyle, Object borderColor) {
    	if (borderWidth != null) {
    		this.borderLeftWidth = borderWidth
    	}
    	if (borderColor != null) {
    		this.borderLeftColor = borderColor;
    	}
    }
    
    def setBorderRight(NumberValue borderWidth, String borderStyle, Object borderColor) {
    	if (borderWidth != null) {
    		this.borderRightWidth = borderWidth
    	}
    	if (borderColor != null) {
    		this.borderRightColor = borderColor;
    	}
    }
    
    def setBorder(NumberValue borderWidth, String borderStyle, Object borderColor) {
    	setBorderLeft(borderWidth,borderStyle,borderColor);
    	setBorderTop(borderWidth,borderStyle,borderColor);
    	setBorderRight(borderWidth,borderStyle,borderColor);
    	setBorderBottom(borderWidth,borderStyle,borderColor);
    }
    
    def setBorderColor(Object... vals) {
    	var values = vals.filterNull;
    	if (values.length == 1) {
    		borderTopColor = values.get(0);
    		borderRightColor = values.get(0);    		
    		borderBottomColor = values.get(0);
    		borderLeftColor = values.get(0);
    	} else if (values.length == 2) {
    		borderTopColor = values.get(0);
    		borderBottomColor = values.get(0);
    		borderLeftColor = values.get(1);
    		borderRightColor = values.get(1);    		
    	} else if (values.length == 3) {
    		borderTopColor = values.get(0);
    		borderBottomColor = values.get(2);
    		borderLeftColor = values.get(1);
    		borderRightColor = values.get(1);    		
    	} else if (values.length == 4) {
    		borderTopColor = values.get(0);
    		borderRightColor = values.get(1);    		
    		borderBottomColor = values.get(2);
    		borderLeftColor = values.get(3);    		
    	}
    }

	def setBorderTopLeftRadius(NumberValue... vals) {
		var values = vals.filterNull;
		if (values.length == 1) {
			borderTopLeftRadiusH = values.get(0);
			borderTopLeftRadiusV = values.get(0);
		} else {
			borderTopLeftRadiusH = values.get(0);
			borderTopLeftRadiusV = values.get(1);
		}
	}
	
	def setBorderTopRightRadius(NumberValue... vals) {
		var values = vals.filterNull;
		if (values.length == 1) {
			borderTopRightRadiusH = values.get(0);
			borderTopRightRadiusV = values.get(0);
		} else {
			borderTopRightRadiusH = values.get(0);
			borderTopRightRadiusV = values.get(1);
		}
	}
	
	def setBorderBottomLeftRadius(NumberValue... vals) {
		var values = vals.filterNull;
		if (values.length == 1) {

			borderBottomLeftRadiusH = values.get(0);
			borderBottomLeftRadiusV = values.get(0);
		} else {
			borderBottomLeftRadiusH = values.get(0);
			borderBottomLeftRadiusV = values.get(1);
		}
	}
	
	def setBorderBottomRightRadius(NumberValue... vals) {
		var values = vals.filterNull;
		if (values.length == 1) {
			borderBottomRightRadiusH = values.get(0);
			borderBottomRightRadiusV = values.get(0);
		} else {
			borderBottomRightRadiusH = values.get(0);
			borderBottomRightRadiusV = values.get(1);
		}
	}
	
    def setBorderRadius(NumberValue... vals) {
    	var values = vals.filterNull;
        if (values.length == 1) {
            borderTopLeftRadius = values.get(0);
            borderTopRightRadius = values.get(0);           
            borderBottomRightRadius = values.get(0);
            borderBottomLeftRadius = values.get(0);
        } else if (values.length == 2) {
            borderTopLeftRadius = values.get(0);
            borderBottomRightRadius = values.get(0);
            borderTopRightRadius = values.get(1);
            borderBottomLeftRadius = values.get(1);           
        } else if (values.length == 3) {
            borderTopLeftRadius = values.get(0);
            borderBottomRightRadius = values.get(2);
            borderTopRightRadius = values.get(1);
            borderBottomLeftRadius = values.get(1);           
        } else if (values.length == 4) {
            borderTopLeftRadius = values.get(0);
            borderTopRightRadius = values.get(1);           
            borderBottomRightRadius = values.get(2);
            borderBottomLeftRadius = values.get(3);            
        }
    }

    def setBorderWidth(NumberValue... vals) {
    	var values = vals.filterNull; 
    	if (values.length == 1) {
    		borderTopWidth = values.get(0);
    		borderRightWidth = values.get(0);    		
    		borderBottomWidth = values.get(0);
    		borderLeftWidth = values.get(0);
    	} else if (values.length == 2) {
    		borderTopWidth = values.get(0);
    		borderBottomWidth = values.get(0);
    		borderLeftWidth = values.get(1);
    		borderRightWidth = values.get(1);    		
    	} else if (values.length == 3) {
    		borderTopWidth = values.get(0);
    		borderBottomWidth = values.get(2);
    		borderLeftWidth = values.get(1);
    		borderRightWidth = values.get(1);    		
    	} else if (values.length == 4) {
    		borderTopWidth = values.get(0);
    		borderRightWidth = values.get(1);    		
    		borderBottomWidth = values.get(2);
    		borderLeftWidth = values.get(3);    		
    	}
    }
    
    
    def setMargin(NumberValue... vals) {
    	var values = vals.filterNull;
    	if (values.length == 1) {
    		marginTop = values.get(0);
    		marginRight = values.get(0);    		
    		marginBottom = values.get(0);
    		marginLeft = values.get(0);
    	} else if (values.length == 2) {
    		marginTop = values.get(0);
    		marginBottom = values.get(0);
    		marginLeft = values.get(1);
    		marginRight = values.get(1);    		
    	} else if (values.length == 3) {
    		marginTop = values.get(0);
    		marginBottom = values.get(2);
    		marginLeft = values.get(1);
    		marginRight = values.get(1);    		
    	} else if (values.length == 4) {
    		marginTop = values.get(0);
    		marginRight = values.get(2);    		
    		marginBottom = values.get(3);
    		marginLeft = values.get(4);    		
    	}
    }
    
      def setPadding(NumberValue... vals) {
      	var values = vals.filterNull;
        if (values.length == 1) {
            paddingTop = values.get(0);
            paddingRight = values.get(0);            
            paddingBottom = values.get(0);
            paddingLeft = values.get(0);
        } else if (values.length == 2) {
            paddingTop = values.get(0);
            paddingBottom = values.get(0);
            paddingLeft = values.get(1);
            paddingRight = values.get(1);            
        } else if (values.length == 3) {
            paddingTop = values.get(0);
            paddingBottom = values.get(2);
            paddingLeft = values.get(1);
            paddingRight = values.get(1);            
        } else if (values.length == 4) {
            paddingTop = values.get(0);
            paddingRight = values.get(2);            
            paddingBottom = values.get(3);
            paddingLeft = values.get(4);         
        }
    }
    
    
    def setBackgroundFilter(Object filterColor, String filterType) {
    	if (filterColor != null) {
    		backgroundFilterColor = filterColor;
    	}
    	if (filterType != null) {
    		backgroundFilterType = filterType;
    	}
    }
    
    def int gravityFromString(String gravity) {
    	gravity.split(",").map[
    		switch(it.toLowerCase().trim()) {
    			case "top": Gravity.TOP
    			case "bottom": Gravity.BOTTOM
    			case "left": Gravity.LEFT
    			case "right": Gravity.RIGHT
    			case "center_vertical": Gravity.CENTER_VERTICAL
    			case "center_horizontal": Gravity.CENTER_HORIZONTAL
    			case "fill_vertical": Gravity.FILL_VERTICAL
    			case "fill_horizontal": Gravity.FILL_HORIZONTAL
    			case "center": Gravity.CENTER
    			case "clip_vertical": Gravity.CLIP_VERTICAL
    			case "clip_horizontal": Gravity.CLIP_HORIZONTAL
    			case "start": Gravity.START
    			case "end": Gravity.END    		
    			default: 0	
    		}
    	].reduce[g,i|  g.bitwiseOr(i) ]
    }
    
    def updateDrawables(LatteView<?> view) {
    	if (backgroundGradientDrawable == null) {
    		backgroundGradientDrawable = new GradientDrawable();
    	}
        backgroundGradientDrawable.colors = #[backgroundColor.asColor, backgroundColor.asColor]
        backgroundGradientDrawable.setCornerRadii(getCornerRadii(view));
        
    	
    	if (backgroundDrawable != null && backgroundDrawable != "") {
    		var drawableResourceId = view.androidView.context.getResources().getIdentifier(backgroundDrawable, "drawable", view.androidView.context.getPackageName());
    		backgroundImageDrawable = view.androidView.context.resources.getDrawable(drawableResourceId).mutate;
    		if (backgroundImageDrawable instanceof BitmapDrawable) {
	    		val bg = (backgroundImageDrawable as BitmapDrawable);
	    		if (backgroundFilterColor != null && backgroundFilterColor.asColor != Color.TRANSPARENT) {
	    			bg.setColorFilter(backgroundFilterColor.asColor, Mode.valueOf(backgroundFilterType.toUpperCase));	
	    		} else {
	    			bg.setColorFilter(null)
	    		}
	    		
	    		if (backgroundGravity != null) { 
	    			bg.gravity = gravityFromString(backgroundGravity);
	    		}
	    		
	    		if (backgroundRepeat != null) {
	    			bg.tileModeY = null;
	    			bg.tileModeX = null;
	    			backgroundRepeat.split(" ").forEach[
	    				if (it == "repeat-x") { bg.tileModeX = TileMode.REPEAT;  }
	    				else if (it == "mirror-x") { bg.tileModeX = TileMode.MIRROR; }
	    				else if (it == "clamp-x") { bg.tileModeX = TileMode.CLAMP; }
	    				else if (it == "no-repeat-x") { bg.tileModeX = null; }
	    				if (it == "repeat-y") { bg.tileModeY = TileMode.REPEAT;  }
	    				else if (it == "mirror-y") { bg.tileModeY = TileMode.MIRROR; }
	    				else if (it == "clamp-y") { bg.tileModeY = TileMode.CLAMP; }
	    				else if (it == "no-repeat-y") { bg.tileModeY = null; }
	    			]
	    		}
			}    			
    	} else {
    		backgroundImageDrawable = new ColorDrawable(Color.TRANSPARENT);
    	}
    	
    	if (borderDrawable == null) {
    		borderDrawable = new BorderDrawable();
    	}
    	
        borderDrawable.topBorderWidth = borderTopWidth.inPixels(view.androidView.context);
        borderDrawable.bottomBorderWidth = borderBottomWidth.inPixels(view.androidView.context);
        borderDrawable.leftBorderWidth = borderLeftWidth.inPixels(view.androidView.context);
        borderDrawable.rightBorderWidth = borderRightWidth.inPixels(view.androidView.context);
        
        
        
    	borderDrawable.topRightRadiusH = borderTopRightRadiusH.inPixels(view.androidView.context);
    	borderDrawable.topRightRadiusV = borderTopRightRadiusV.inPixels(view.androidView.context);

    	borderDrawable.topLeftRadiusH = borderTopLeftRadiusH.inPixels(view.androidView.context);
    	borderDrawable.topLeftRadiusV = borderTopLeftRadiusV.inPixels(view.androidView.context);	

    	borderDrawable.bottomLeftRadiusH = borderBottomLeftRadiusH.inPixels(view.androidView.context);
    	borderDrawable.bottomLeftRadiusV = borderBottomLeftRadiusV.inPixels(view.androidView.context);

    	borderDrawable.bottomRightRadiusH = borderBottomRightRadiusH.inPixels(view.androidView.context);
    	borderDrawable.bottomRightRadiusV = borderBottomRightRadiusV.inPixels(view.androidView.context);
    	    	
    	borderDrawable.topBorderColor = borderTopColor.asColor;
    	borderDrawable.bottomBorderColor = borderBottomColor.asColor;
    	borderDrawable.leftBorderColor = borderLeftColor.asColor;
    	borderDrawable.rightBorderColor =  borderRightColor.asColor;
    }

    def applyDrawableStyle(LatteView<?> view) {
		updateDrawables(view);
		
        var List<List<Integer>> colorStates = newArrayList
        val List<Integer> colorList = newArrayList

        colorStates += #[ R.attr.state_enabled, R.attr.state_pressed ]
        if (rippleColor != null) {
            colorList += Style::asColor(rippleColor)    
        } else {
            colorList += Style::asColor(backgroundColor)
        }
        colorStates += #[R.attr.state_enabled,-R.attr.state_pressed]
        colorList += backgroundColor.asColor;
        
        
        view.backgroundDrawable.setDrawableByLayerId(0, backgroundGradientDrawable);
        view.backgroundDrawable.setDrawableByLayerId(1, backgroundImageDrawable);
        view.backgroundDrawable.setDrawableByLayerId(2, borderDrawable);

	
//		var topBorder = borderTopWidth.inPixelsInt(view.androidView.context)
//        var rightBorder = borderRightWidth.inPixelsInt(view.androidView.context)
//        var bottomBorder = borderBottomWidth.inPixelsInt(view.androidView.context)
//        var leftBorder = borderLeftWidth.inPixelsInt(view.androidView.context)
//        view.backgroundDrawable.setLayerInset(0,leftBorder,topBorder,rightBorder,bottomBorder);
//        view.backgroundDrawable.setLayerInset(1,leftBorder,topBorder,rightBorder,bottomBorder);

//        view.backgroundDrawable.invalidateSelf

        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            (view.androidView.background as RippleDrawable).setColor(new ColorStateList(colorStates.unwrap, colorList));
        } else {        
            (view.androidView.background as RippleDrawable).setColor(new ColorStateList(colorStates.unwrap, colorList));
        }
    }
    
    def float[] getCornerRadii(LatteView<?> latteView) {
		var topLeft = borderTopLeftRadiusH.inPixels(latteView.androidView.context)
        var topRight = borderTopRightRadiusH.inPixels(latteView.androidView.context)
        var bottomLeft = borderBottomLeftRadiusH.inPixels(latteView.androidView.context)
        var bottomRight = borderBottomLeftRadiusH.inPixels(latteView.androidView.context)
    	return #[topLeft,topLeft,topRight,topRight,bottomRight,bottomRight,bottomLeft,bottomLeft];
    }
    
    def applyDrawableShape(LatteView<?> latteView) {
        var shape = new RoundRectShape(getCornerRadii(latteView), null,null);
        latteView.shapeDrawable.shape = shape;
//      Todo: investigate whether we need to call this
//      latteView.shapeDrawable.invalidateSelf
    }
    
    def isShapeProperty(String propertyName) {
    	return SHAPE_PROPS.contains(propertyName);
    }
    
    def isDrawableProperty(String propertyName) {
    	return DRAWABLE_PROPS.contains(propertyName);
    }

    def applyToView(LatteView<?> latteView, String... properties) {
    	initFonts(latteView.androidView.context)
    	var applyAll = properties.isEmpty
    	
        var androidView = latteView.androidView;
        if ( (applyAll ||  properties.contains("elevation")) && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            androidView.elevation = elevation.inPixels(androidView.context);
        }
        
        if (applyAll || properties.findFirst[ isDrawableProperty ] != null) {
        	applyDrawableStyle(latteView);
        }
        if (applyAll || properties.findFirst[ isShapeProperty ]  != null) {
        	applyDrawableShape(latteView);
        }
        
        if (applyAll || properties.contains("translationY")) androidView.translationY = translationY.inPixels(androidView.context)
        if (applyAll || properties.contains("translationX")) androidView.translationX = translationX.inPixels(androidView.context);
        
        if ((applyAll || properties.contains("x")) && x != null) androidView.x = x.inPixels(androidView.context)
        if ((applyAll || properties.contains("y")) && y != null) androidView.y = y.inPixels(androidView.context)
        if (applyAll || !properties.filter[it.indexOf("padding") != -1].empty) {
	        var pLeft = paddingLeft.inPixelsInt(androidView.context) + borderLeftWidth.inPixelsInt(androidView.context)
	        var pRight = paddingRight.inPixelsInt(androidView.context) + borderRightWidth.inPixelsInt(androidView.context)
	        var pTop = paddingTop.inPixelsInt(androidView.context) + borderTopWidth.inPixelsInt(androidView.context)
	        var pBottom = paddingBottom.inPixelsInt(androidView.context) + borderBottomWidth.inPixelsInt(androidView.context)
	        
	        androidView.setPadding(pLeft,pTop,pRight,pBottom);
        }
		if (androidView instanceof TextView) {        
			if (applyAll || properties.contains("textColor")) {
	            androidView.setTextColor(textColor.asColor);
	        }
	        if ((applyAll || properties.contains("fontSize")) && fontSize != null) {
                androidView.textSize = fontSize.inPixelsInt(androidView.context);
            }
            
	        if ((applyAll || properties.contains("fontFamily")) && fontFamily != null) {
	        	if (fontFamily == "default") {
	        		androidView.typeface = if (fontStyle == "bold" || fontStyle == "bold-italic") Typeface.DEFAULT_BOLD else Typeface.DEFAULT;
	        	} else {
                	androidView.typeface = allFonts.get(fontFamily.toLowerCase())
                }
            }
            if ((applyAll || properties.contains("fontStyle")) && fontStyle != null) {
            	if (fontStyle == "bold") {
            		androidView.setTypeface(androidView.typeface, Typeface.BOLD);	
            	} else if (fontStyle == "bold-italic") {
            		androidView.setTypeface(androidView.typeface, Typeface.BOLD_ITALIC);
            	}  else if (fontStyle == "italic") {
            		androidView.setTypeface(androidView.typeface, Typeface.ITALIC);
            	} else {
            		androidView.setTypeface(androidView.typeface, Typeface.NORMAL);
            	}
            }
        }
        
        
        // Layout Params
        var LayoutParams lp = androidView.layoutParams
        var lpChanged = false;
		if (applyAll || properties.contains("width")) {
        	lp.width = width.inPixelsInt(androidView.context)
        	lpChanged = true;
        }
        if (applyAll || properties.contains("height")) {
        	lp.height = height.inPixelsInt(androidView.context);
        	lpChanged = true;
        }
        if (applyAll || !properties.filter[it.indexOf("margin") != -1].empty) {
	        if (lp instanceof MarginLayoutParams) {
				lpChanged = true	            
	            if (marginLeft != null) {
	                lp.leftMargin = marginLeft.inPixelsInt(androidView.context)
	            }
	            if (marginRight != null) {
	                lp.rightMargin = marginRight.inPixelsInt(androidView.context)
	            }
	            if (marginBottom != null) {
	                lp.bottomMargin = marginBottom.inPixelsInt(androidView.context)
	            }
	            if (marginTop != null) {
	                lp.topMargin = marginTop.inPixelsInt(androidView.context)
	            }
	        }
        }
        if (lpChanged) {
        	androidView.layoutParams = lp;
        }
    }
    
    
    static def int asColor(Object color) {
        if (color == null) {
            return Color.WHITE;
        } else if (color instanceof Integer) {
            return color as Integer
        } else {
            return Color.parseColor(color as String);
        }
    }
    
    
    
    static def asColorDrawable(Object color) {
        return new ColorDrawable(color.asColor)
    }   
}