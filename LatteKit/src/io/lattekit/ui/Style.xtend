package io.lattekit.ui

import android.R
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.AssetManager
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Shader.TileMode
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
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
import io.lattekit.StyleProperty
import java.util.ArrayList
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

import static extension io.lattekit.xtend.ArrayLiterals2.*
import io.lattekit.ui.drawable.BorderDrawable

class NumberValue {
    @Accessors var int value;
    @Accessors var int type;
    @Accessors String valueType;
    Float cached;
    new(int value, int type) {
        this.value = value;
        this.type = type;
        valueType = "Integer";
        if (type == TypedValue.COMPLEX_UNIT_PX) {
            cached = value as float;
        }   
    }
    
    new(float value, int type) {
        this.value = Math.round(value);
        this.type = type;
        valueType = "Float";
        if (type == TypedValue.COMPLEX_UNIT_PX) {
            cached = value;
        }
    }   
    def inPixels(Context context) {
        if (cached != null) { return cached;}
        if (type == TypedValue.COMPLEX_UNIT_DIP) {
            cached = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value,context.resources.displayMetrics);
        } else if (type == TypedValue.COMPLEX_UNIT_SP) {
            cached = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value,context.resources.displayMetrics);
        }
        if (cached == null) {
            cached = value as float
        }
        return cached;
    }
    
    def int inPixelsInt(Context context) {
        return Math.round(inPixels(context))
    }
} 


class Style {
    
    @Accessors Style parentStyle;
    @StyleProperty public Object backgroundColor = Color.WHITE;
    @StyleProperty public Object rippleColor;
    
    @StyleProperty public Object textColor = Color.BLACK;
    

    @StyleProperty public String backgroundDrawable = "";
    @StyleProperty public String backgroundRepeat = "no-repeat-x no-repeat-y";
    @StyleProperty public String backgroundGravity = "fill_vertical, fill_horizontal";
    
    @StyleProperty public Object borderColor = Color.WHITE;
    @StyleProperty public Object borderLeftColor;
    @StyleProperty public Object borderTopColor;
    @StyleProperty public Object borderRightColor;
    @StyleProperty public Object borderBottomColor;
    
        
    @StyleProperty public NumberValue borderRadius = new NumberValue(0,TypedValue.COMPLEX_UNIT_DIP);
    @StyleProperty public NumberValue borderTopLeftRadius;
    @StyleProperty public NumberValue borderTopRightRadius;
    @StyleProperty public NumberValue borderBottomLeftRadius;
    @StyleProperty public NumberValue borderBottomRightRadius;
    
    @StyleProperty public NumberValue borderWidth = new NumberValue(0,TypedValue.COMPLEX_UNIT_DIP);
    @StyleProperty public NumberValue borderLeftWidth;
    @StyleProperty public NumberValue borderTopWidth;
    @StyleProperty public NumberValue borderRightWidth;
    @StyleProperty public NumberValue borderBottomWidth;
    
    
    
    
    @StyleProperty public NumberValue margin = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue marginTop;
    @StyleProperty public NumberValue marginBottom;
    @StyleProperty public NumberValue marginLeft;
    @StyleProperty public NumberValue marginRight;
    
    @StyleProperty public NumberValue elevation = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue translationY = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue translationX = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue x;
    @StyleProperty public NumberValue y;
    public Float _computedX;
    public Float _computedY;
    
    @StyleProperty public NumberValue padding = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue paddingTop;
    @StyleProperty public NumberValue paddingBottom;
    @StyleProperty public NumberValue paddingLeft;
    @StyleProperty public NumberValue paddingRight;
    
    @StyleProperty public String fontFamily = "default";
    @StyleProperty public String fontStyle = "bold";
    @StyleProperty public NumberValue fontSize;
    
    @StyleProperty public List<List<Object>> transitions;
    
    @StyleProperty public NumberValue width = new NumberValue(ViewGroup.LayoutParams.WRAP_CONTENT, TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue height = new NumberValue(ViewGroup.LayoutParams.WRAP_CONTENT, TypedValue.COMPLEX_UNIT_PX);
    
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
        _borderColor = overridingStyle._borderColor ?: _borderColor
        _borderLeftColor = overridingStyle._borderLeftColor ?: _borderLeftColor
        _borderTopColor = overridingStyle._borderTopColor ?: _borderTopColor
        _borderRightColor = overridingStyle._borderRightColor ?: _borderRightColor
        _borderBottomColor = overridingStyle._borderBottomColor ?: _borderBottomColor
        
        _textColor = overridingStyle._textColor ?: _textColor
        _backgroundDrawable = overridingStyle._backgroundDrawable ?: _backgroundDrawable
        _backgroundRepeat = overridingStyle._backgroundRepeat ?: _backgroundRepeat
        _backgroundGravity = overridingStyle._backgroundGravity ?: _backgroundGravity
        _borderRadius = overridingStyle._borderRadius ?: _borderRadius
        _borderTopLeftRadius = overridingStyle._borderTopLeftRadius ?: _borderTopLeftRadius
        _borderTopRightRadius = overridingStyle._borderTopRightRadius ?: _borderTopRightRadius
        _borderBottomLeftRadius = overridingStyle._borderBottomLeftRadius ?: _borderBottomLeftRadius
        _borderBottomRightRadius = overridingStyle._borderBottomRightRadius ?: _borderBottomRightRadius
        
        _borderWidth = overridingStyle._borderWidth ?: _borderWidth
        _borderLeftWidth = overridingStyle._borderLeftWidth ?: _borderLeftWidth
        _borderTopWidth = overridingStyle._borderTopWidth ?: _borderTopWidth
        _borderRightWidth = overridingStyle._borderRightWidth ?: _borderRightWidth
        _borderBottomWidth = overridingStyle._borderBottomWidth ?: _borderBottomWidth
        
        
        _margin = overridingStyle._margin ?: _margin
        _marginTop = overridingStyle._marginTop ?: _marginTop
        _marginBottom = overridingStyle._marginBottom ?: _marginBottom
        _marginLeft = overridingStyle._marginLeft ?: _marginLeft
        _marginRight = overridingStyle._marginRight ?: _marginRight
        _elevation = overridingStyle._elevation ?: _elevation
        _translationX = overridingStyle._translationX ?: _translationX
        _translationY = overridingStyle._translationY ?: _translationY
        
        _x = overridingStyle.x ?: _x
        _y = overridingStyle.y ?: _y
        
        _padding = overridingStyle._padding ?: _padding
        _paddingTop = overridingStyle._paddingTop ?: _paddingTop
        _paddingBottom = overridingStyle._paddingBottom ?: _paddingBottom
        _paddingLeft = overridingStyle._paddingLeft ?: _paddingLeft
        _paddingRight = overridingStyle._paddingRight ?: _paddingRight
        
        _width = overridingStyle._width ?: _width
        _height = overridingStyle._height ?: _height
        
        _fontStyle = overridingStyle._fontStyle ?: _fontStyle
        _fontFamily = overridingStyle._fontFamily ?: _fontFamily
        _fontSize = overridingStyle._fontSize ?: _fontSize
        
        _transitions = overridingStyle._transitions ?: new ArrayList<List<Object>>() as List<List<Object>>
    }

    def static Style parseStyle(String styleStr) {
        val style = new Style();
        styleStr.split(";").forEach[
            var splitted = split(":");
            var key = splitted.get(0).trim()
            var value = splitted.get(1).trim()
            if (value.toUpperCase == "MATCH_PARENT") {
                value = ""+LayoutParams.MATCH_PARENT    
            } else if (value.toUpperCase == "WRAP_CONTENT") {
                value = ""+LayoutParams.WRAP_CONTENT    
            }
            try {
                var intVal = Integer.parseInt(value);
                style.setProperty(key,intVal);
                return
            } catch(Exception ex) {}

            try {
                var intVal = new NumberValue(Integer.parseInt(value),0);
                style.setProperty(key,intVal);
                return
            } catch(Exception ex) {}

            try {
                var floatVal = Float.parseFloat(value);
                style.setProperty(key,floatVal);
                return
            } catch(Exception ex) {}    
            
            try {
                var floatVal = new NumberValue(Float.parseFloat(value) as int, 0);
                style.setProperty(key,floatVal);
                return
            } catch(Exception ex) {}            
                    
            style.setProperty(key,value);
        ];
        return style;
    }

    def void deriveFrom(Style form) {
        this.backgroundColor = form.backgroundColor
        this.rippleColor = form.rippleColor
        this.borderColor = form.borderColor
        this.borderTopColor = form.borderTopColor
        this.borderLeftColor = form.borderLeftColor
        this.borderRightColor = form.borderRightColor
        this.borderBottomColor = form.borderBottomColor
        
        this.textColor = form.textColor
        this.backgroundDrawable = form.backgroundDrawable
        this.backgroundRepeat = form.backgroundRepeat;
        this.backgroundGravity = form.backgroundGravity;
        this.borderRadius = form.borderRadius
        this.borderTopLeftRadius = form.borderTopLeftRadius
        this.borderTopRightRadius = form.borderTopRightRadius
        this.borderBottomLeftRadius = form.borderBottomLeftRadius
        this.borderBottomRightRadius = form.borderBottomRightRadius
        
        this.borderWidth = form.borderWidth
        this.borderLeftWidth = form.borderLeftWidth
        this.borderTopWidth = form.borderTopWidth
        this.borderRightWidth = form.borderRightWidth
        this.borderBottomWidth = form.borderBottomWidth
        
        this.margin = form.margin
        this.marginTop = form.marginTop
        this.marginBottom = form.marginBottom
        this.marginLeft = form.marginLeft
        this.marginRight = form.marginRight
        this.elevation = form.elevation
        this.translationX = form.translationX
        this.translationY = form.translationY
        this.padding = form.padding
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
        this.borderColor = form._borderColor
        this.borderTopColor = form._borderTopColor
        this.borderLeftColor = form._borderLeftColor
        this.borderRightColor = form._borderRightColor
        this.borderBottomColor = form._borderBottomColor
        
        this.textColor = form._textColor
        this.backgroundDrawable = form._backgroundDrawable
        this.backgroundRepeat = form._backgroundRepeat
        this.backgroundGravity = form._backgroundGravity
        this.borderRadius = form._borderRadius
        this.borderTopLeftRadius = form._borderTopLeftRadius
        this.borderTopRightRadius = form._borderTopRightRadius
        this.borderBottomLeftRadius = form._borderBottomLeftRadius
        this.borderBottomRightRadius = form._borderBottomRightRadius
        
        
        this.borderWidth = form._borderWidth
        this.borderTopWidth = form._borderTopWidth
        this.borderLeftWidth = form._borderLeftWidth
        this.borderRightWidth = form._borderRightWidth
        this.borderBottomWidth = form._borderBottomWidth
        
        this.margin = form._margin
        this.marginTop = form._marginTop
        this.marginBottom = form._marginBottom
        this.marginLeft = form._marginLeft
        this.marginRight = form._marginRight
        this.elevation = form._elevation
        this.translationX = form._translationX
        this.translationY = form._translationY
        this.padding = form._padding
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
    
    def createAnimatorFrom(Style startStyle,LatteView latteView, boolean revertToNormal) {
        val animSet = new AnimatorSet();
        val List<String> transitionProperties = if (transitions != null) transitions.map[it.get(0) as String] else #[];
        
        val actualSize = latteView.getMeasuredSize(this);
        val startActualSize = latteView.getMeasuredSize(startStyle);
        
        var immediateAnim =  ValueAnimator.ofInt(0,1);
        immediateAnim.addUpdateListener([
            if (animatedValue == 0) {
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
                
                
            }
        ])
        immediateAnim.setDuration(1);

        var List<Animator> allAnims = newArrayList();
        allAnims += immediateAnim;
        if (transitions != null) {
            allAnims += transitions.map[
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
		animSet.playTogether(allAnims)
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
    
    def updateDrawables(LatteView view) {
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
    	
        borderDrawable.topBorderWidth = (borderTopWidth ?: borderWidth).inPixels(view.androidView.context);
        borderDrawable.bottomBorderWidth = (borderBottomWidth ?: borderWidth).inPixels(view.androidView.context);
        borderDrawable.leftBorderWidth = (borderLeftWidth ?: borderWidth).inPixels(view.androidView.context);
        borderDrawable.rightBorderWidth = (borderRightWidth ?: borderWidth).inPixels(view.androidView.context);
        
        
        borderDrawable.topLeftRadius = borderRadius.inPixels(view.androidView.context);
        borderDrawable.topRightRadius = borderRadius.inPixels(view.androidView.context);
        borderDrawable.bottomLeftRadius = borderRadius.inPixels(view.androidView.context);
        borderDrawable.bottomRightRadius = borderRadius.inPixels(view.androidView.context);
        
        if (borderTopRightRadius != null) {
        	borderDrawable.topRightRadius = borderTopRightRadius.inPixels(view.androidView.context);
        }
        if (borderTopLeftRadius != null) {
        	borderDrawable.topLeftRadius = borderTopLeftRadius.inPixels(view.androidView.context);	
        }
        if (borderBottomLeftRadius != null) {
        	borderDrawable.bottomLeftRadius = borderBottomLeftRadius.inPixels(view.androidView.context);
        }
        if (borderBottomRightRadius != null) {
        	borderDrawable.bottomRightRadius = borderBottomRightRadius.inPixels(view.androidView.context);
    	}
    	    	
    	borderDrawable.topBorderColor = (borderTopColor ?: borderColor).asColor;
    	borderDrawable.bottomBorderColor = (borderBottomColor ?: borderColor).asColor;
    	borderDrawable.leftBorderColor = (borderLeftColor ?: borderColor).asColor;
    	borderDrawable.rightBorderColor = (borderRightColor ?: borderColor).asColor;
    }

    def applyDrawableStyle(LatteView view) {
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
        //TODO: Should inset with border width ?
		var topBorder = (borderTopWidth ?: borderWidth).inPixelsInt(view.androidView.context)
        var rightBorder = (borderRightWidth ?: borderWidth).inPixelsInt(view.androidView.context)
        var bottomBorder = (borderBottomWidth ?: borderWidth).inPixelsInt(view.androidView.context)
        var leftBorder =(borderLeftWidth ?: borderWidth).inPixelsInt(view.androidView.context)
        
        view.backgroundDrawable.setLayerInset(0,leftBorder,topBorder,rightBorder,bottomBorder);
        view.backgroundDrawable.setLayerInset(1,leftBorder,topBorder,rightBorder,bottomBorder);
        view.backgroundDrawable.invalidateSelf
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            (view.androidView.background as RippleDrawable).setColor(new ColorStateList(colorStates.unwrap, colorList));
        } else {        
            (view.androidView.background as codetail.graphics.drawables.RippleDrawable).setColor(new ColorStateList(colorStates.unwrap, colorList));
        }
    }
    
    def float[] getCornerRadii(LatteView latteView) {
		var topLeft = (borderTopLeftRadius ?: borderRadius).inPixels(latteView.androidView.context)/2.0f
        var topRight = (borderTopRightRadius ?: borderRadius).inPixels(latteView.androidView.context)/2.0f
        var bottomLeft = (borderBottomLeftRadius ?: borderRadius).inPixels(latteView.androidView.context)/2.0f
        var bottomRight = (borderBottomRightRadius ?: borderRadius).inPixels(latteView.androidView.context)/2.0f
    	return #[topLeft,topLeft,topRight,topRight,bottomRight,bottomRight,bottomLeft,bottomLeft];
    }
    
    def applyDrawableShape(LatteView latteView) {
        var shape = new RoundRectShape(getCornerRadii(latteView), null,null);
        latteView.shapeDrawable.shape = shape;
//      Todo: investigate whether we need to call this
//      latteView.shapeDrawable.invalidateSelf
    }
    
    def applyToView(LatteView<?> latteView, String... properties) {
    	initFonts(latteView.androidView.context)
    	var applyAll = properties.isEmpty
    	
        var androidView = latteView.androidView;
        if ( (applyAll ||  properties.contains("elevation")) && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            androidView.elevation = elevation.inPixels(androidView.context);
        }
        
        if (applyAll || !properties.filter[#["borderColor","borderTopColor","borderLeftColor","borderRightColor","borderBottomColor","borderRadius","borderTopLeftRadius","borderTopRightRadius","borderBottomLeftRadius","borderBottomRightRadius","backgroundDrawable","backgroundRepeat","backgroundGravity","backgroundColor","rippleColor","borderWidth","borderLeftWidth","borderRightWidth","borderTopWidth","borderBottomWidth"].contains(it)].empty) {
        	applyDrawableStyle(latteView);
        }
        if (applyAll || !properties.filter[#["borderRadius","borderTopLeftRadius","borderTopRightRadius","borderBottomLeftRadius","borderBottomRightRadius","borderWidth","borderLeftWidth","borderRightWidth","borderTopWidth","borderBottomWidth"].contains(it)].empty) {
        	applyDrawableShape(latteView);
        }
        
        if (applyAll || properties.contains("translationY")) androidView.translationY = translationY.inPixels(androidView.context)
        if (applyAll || properties.contains("translationX")) androidView.translationX = translationX.inPixels(androidView.context);
        
        if ((applyAll || properties.contains("x")) && x != null) androidView.x = x.inPixels(androidView.context)
        if ((applyAll || properties.contains("y")) && y != null) androidView.y = y.inPixels(androidView.context)
        if (applyAll || !properties.filter[it.indexOf("padding") != -1].empty) {
	        var pLeft = (paddingLeft ?: padding).inPixelsInt(androidView.context)
	        var pRight = (paddingRight ?: padding).inPixelsInt(androidView.context)
	        var pTop = (paddingTop ?: padding).inPixelsInt(androidView.context)
	        var pBottom = (paddingBottom ?: padding).inPixelsInt(androidView.context)
	        
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
	            if (margin != null) {
	                lp.leftMargin = margin.inPixelsInt(androidView.context)
	                lp.topMargin = margin.inPixelsInt(androidView.context)
	                lp.rightMargin = margin.inPixelsInt(androidView.context)
	                lp.bottomMargin = margin.inPixelsInt(androidView.context) 
	            }
	            
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