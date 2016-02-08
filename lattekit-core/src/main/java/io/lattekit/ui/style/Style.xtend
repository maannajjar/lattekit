package io.lattekit.ui.style;

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.AssetManager
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
import io.lattekit.annotations.StyleProperty
import io.lattekit.ui.drawable.BorderDrawable
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors

class Style {
    public final static int MATCH_PARENT = LayoutParams.MATCH_PARENT;
    public final static int WRAP_CONTENT = LayoutParams.WRAP_CONTENT;
    public final static int match_parent = LayoutParams.MATCH_PARENT;
    public final static int wrap_content = LayoutParams.WRAP_CONTENT;
	
    @Accessors String definedSelector;
    
    @Accessors Map<String, Style> descendantStyles = newHashMap();
    @Accessors Map<String, Style> directChildrenStyles = newHashMap();
    @Accessors Map<String, Style> siblingStyles = newHashMap();
    
    @Accessors Style parentStyle;
    @StyleProperty public Object backgroundColor = Color.WHITE;
    @StyleProperty public Object rippleColor = Color.TRANSPARENT;
    @StyleProperty public Object textColor = Color.BLACK;
    
    @StyleProperty(animatable=false) public String backgroundDrawable = "";
    @StyleProperty(animatable=false) public String backgroundRepeat = "no-repeat-x no-repeat-y";
    @StyleProperty(animatable=false) public String backgroundGravity = "fill_vertical, fill_horizontal";
    
    @StyleProperty(shorthands=#["background-filter"])
    public Object backgroundFilterColor = Color.TRANSPARENT;
    
    @StyleProperty(shorthands=#["background-filter"],animatable=false)
    public String backgroundFilterType = "SRC_ATOP";
    
    
    @StyleProperty(shorthands=#["border","border-left"])
    public Object borderLeftColor = Color.BLACK;
    
    @StyleProperty(shorthands=#["border","border-top"])
    public Object borderTopColor = Color.BLACK;
    
    @StyleProperty(shorthands=#["border","border-right"])
    public Object borderRightColor = Color.BLACK;
    
    @StyleProperty(shorthands=#["border","border-bottom"])
    public Object borderBottomColor = Color.BLACK;
    
        
    @StyleProperty(shorthands=#["border-radius","border-top-left-radius"]) 
    public NumberValue borderTopLeftRadiusH  = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["border-radius","border-top-right-radius"]) 
    public NumberValue borderTopRightRadiusH  = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["border-radius","border-bottom-left-radius"])
    public NumberValue borderBottomLeftRadiusH = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
     
    @StyleProperty(shorthands=#["border-radius","border-bottom-right-radius"])
    public NumberValue borderBottomRightRadiusH = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["border-radius","border-top-left-radius"]) 
    public NumberValue borderTopLeftRadiusV = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["border-radius","border-top-right-radius"])
    public NumberValue borderTopRightRadiusV = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["border-radius","border-bottom-left-radius"])
    public NumberValue borderBottomLeftRadiusV = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["border-radius","border-bottom-right-radius"])
    public NumberValue borderBottomRightRadiusV = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    
    @StyleProperty(shorthands=#["border","border-width","border-left"])
    public NumberValue borderLeftWidth = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["border","border-width","border-top"])
    public NumberValue borderTopWidth = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["border","border-width","border-right"])
    public NumberValue borderRightWidth = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["border","border-width","border-bottom"])
    public NumberValue borderBottomWidth = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
        
       
    @StyleProperty(shorthands=#["margin"])
    public NumberValue marginTop = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["margin"])
    public NumberValue marginBottom = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["margin"])
    public NumberValue marginLeft = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["margin"])
    public NumberValue marginRight = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty public NumberValue elevation = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue translationY = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue translationX = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue x;
    @StyleProperty public NumberValue y;
    
    
    @StyleProperty(shorthands=#["padding"])
    public NumberValue paddingTop = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["padding"])
    public NumberValue paddingBottom = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["padding"])
    public NumberValue paddingLeft = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(shorthands=#["padding"])
    public NumberValue paddingRight = new NumberValue(0,TypedValue.COMPLEX_UNIT_PX);
    
    @StyleProperty(animatable=false) public String fontFamily = "default";
    @StyleProperty(animatable=false) public String fontStyle = "normal";
    @StyleProperty public NumberValue fontSize;
    
    @StyleProperty(animatable=false) public List<List<Object>> transition;
    
    @StyleProperty public NumberValue width = new NumberValue(ViewGroup.LayoutParams.WRAP_CONTENT, TypedValue.COMPLEX_UNIT_PX);
    @StyleProperty public NumberValue height = new NumberValue(ViewGroup.LayoutParams.WRAP_CONTENT, TypedValue.COMPLEX_UNIT_PX);
    
    public Float _computedX;
    public Float _computedY;
    
    
    static Set<String> DRAWABLE_PROPS = newHashSet("borderColor","borderTopColor","borderLeftColor","borderRightColor","borderBottomColor","borderRadius","borderTopLeftRadiusV","borderTopRightRadiusV","borderBottomLeftRadiusV","borderBottomRightRadiusV","borderTopLeftRadiusH","borderTopRightRadiusH","borderBottomLeftRadiusH","borderBottomRightRadiusH","backgroundDrawable","backgroundFilterColor","backgroundFilterType","backgroundFilter","backgroundRepeat","backgroundGravity","backgroundColor","rippleColor","borderWidth","borderLeftWidth","borderRightWidth","borderTopWidth","borderBottomWidth")
    
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
            var fullPath = ( if (path != "") path +"/" else "")+it
            if (assets.list(fullPath).length > 0 ){
                loadFontsInAssetPath(assets,fullPath,fonts);
            } else {
                if (it.endsWith(".ttf") || it.endsWith(".otf")) {
                    try {
                        
                        Log.d("Latte","Loading font "+ fullPath);
                        var font = Typeface.createFromAsset(assets,fullPath);
                        allFonts.put(it.substring(0,it.length-4).toLowerCase(), font);
                    } catch (Exception ex) {
                        ex.printStackTrace
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
        
    def createAnimatorFrom(Style startStyle,io.lattekit.ui.view.NativeView latteView, boolean revertToNormal) {
        val animSet = new AnimatorSet();
        val Set<String> transitionProperties = newHashSet();
        
        val Map<String,Set<String>> animationGroups = newHashMap(); // Group of transition by duration, delay & timing function
        val Map<String,List<Object>> animationParams = newHashMap(); // Contains duration, delay & timing function values
        
         if (transition != null) {
            transition.forEach[
                val transitionName = it.get(0) as String;
                val duration = (it.get(1) as Integer) ?: 0;
                val fn = (it.get(2) as String) ?: "";                
                val delay = (it.get(3) as Integer) ?: 0;
                
                val groupName = it.get(1)+","+it.get(2)+","+it.get(3);
                var group = animationGroups.get(groupName);
                if (group == null) {
                    group = newHashSet();
                    animationGroups.put(groupName,group);
                    animationParams.put(groupName, #[duration, fn, delay]);
                }
                transitionProperties.add(transitionName);
                group.add(transitionName);
            ]
        }
        
        val actualSize = latteView.getMeasuredSize(this);
        val startActualSize = latteView.getMeasuredSize(startStyle);
        
        val expandedTransitions = transitionProperties.expandShorthands
        val modifiedAttributes = newHashSet()
        PROPERTIES.filter[UNANIMATED_PROPERTIES.contains(it) || !expandedTransitions.contains(it)].forEach[
            if (it == "x" && _computedX != null && revertToNormal && startStyle.x != null) {
                startStyle.setProperty(it, new NumberValue(_computedX, TypedValue.COMPLEX_UNIT_PX));
            } else if (it == "y" && _computedY != null && revertToNormal  && startStyle.y != null) {
                startStyle.setProperty(it, new NumberValue(_computedY, TypedValue.COMPLEX_UNIT_PX));
            }  else if ( this.getProperty(it) != null) {
                if (this.getProperty(it) != startStyle.getProperty(it)) {
                    modifiedAttributes += it;                   
                }
                startStyle.setProperty(it, this.getProperty(it));
            }
        ]
        if (!modifiedAttributes.empty) {
            startStyle.applyToView(latteView,modifiedAttributes)
        }
        

        var allAnims = animationGroups.keySet.map[
            val propertyList = animationGroups.get(it).expandShorthands;
            var animationParam = animationParams.get(it);
            val duration  = animationParam.get(0) as Integer
            val delay = animationParam.get(2) as Integer            
            val Map<String,String> propertyTypes = newHashMap();
            val List<PropertyValuesHolder> propertyValues = propertyList.map[ propName |
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
                    propertyTypes.put(propName, "Integer")
                    return PropertyValuesHolder.ofInt(propName, start,end);
                } else if (startValue instanceof NumberValue && (startValue as NumberValue).valueType == "Float") {
                    var start = if (startValue instanceof NumberValue) { startValue.inPixels(latteView.androidView.context); } else { startValue as Float;}
                    var end = if (myValue instanceof NumberValue) { myValue.inPixels(latteView.androidView.context); } else { myValue as Float;}
                    propertyTypes.put(propName, "Float")
                    return PropertyValuesHolder.ofFloat(propName,start, end);
                }           
               return null;    
            ].filterNull.toList
            
            var animator =  ValueAnimator.ofPropertyValuesHolder(propertyValues);
            animator.setDuration(duration);
            animator.setStartDelay(delay);
            animator.addUpdateListener([ anim |
                if (latteView.currentAnimation == animSet) { 
                    anim.values.forEach[
                        var value = anim.getAnimatedValue(propertyName)
                        if (propertyTypes.get(propertyName) == "Integer") {
                            startStyle.setProperty(propertyName, new NumberValue(value as Integer, 0));
                        } else if (propertyTypes.get(propertyName) == "Float") {
                            startStyle.setProperty(propertyName, new NumberValue(value as Float, 0));
                        }
                    ]
                    startStyle.applyToView(latteView,propertyList)
                }
            ]);
            
            return animator;
        ].sortBy[ startDelay ]
        
        if (!allAnims.empty) {
            animSet.playTogether(allAnims);
        }
        
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
    
    def updateDrawables(io.lattekit.ui.view.NativeView view) {
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

    def applyDrawableStyle(io.lattekit.ui.view.NativeView view) {
        updateDrawables(view);
        
        view.backgroundDrawable.setDrawableByLayerId(0, backgroundGradientDrawable);
        view.backgroundDrawable.setDrawableByLayerId(1, backgroundImageDrawable);
        view.backgroundDrawable.setDrawableByLayerId(2, borderDrawable);
        
    }
    
    def float[] getCornerRadii(io.lattekit.ui.view.NativeView latteView) {
        var topLeft = borderTopLeftRadiusH.inPixels(latteView.androidView.context)
        var topRight = borderTopRightRadiusH.inPixels(latteView.androidView.context)
        var bottomLeft = borderBottomLeftRadiusH.inPixels(latteView.androidView.context)
        var bottomRight = borderBottomLeftRadiusH.inPixels(latteView.androidView.context)
        return #[topLeft,topLeft,topRight,topRight,bottomRight,bottomRight,bottomLeft,bottomLeft];
    }
    
    def getShape(io.lattekit.ui.view.NativeView latteView) {
        return new RoundRectShape(getCornerRadii(latteView), null,null);
    }
    

    def isDrawableProperty(String propertyName) {
        return DRAWABLE_PROPS.contains(propertyName);
    }

    def applyToView(io.lattekit.ui.view.NativeView latteView, String... properties) {
        if (latteView.androidView == null) {
            return;
        }
        
        initFonts(latteView.androidView.context)
        var applyAll = properties.isEmpty
        
        var androidView = latteView.androidView;
        if ( (applyAll ||  properties.contains("elevation")) && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            androidView.elevation = elevation.inPixels(androidView.context);
        }
        
        if (applyAll || properties.findFirst[ isDrawableProperty ] != null) {
            applyDrawableStyle(latteView);
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
                androidView.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize.inPixelsInt(androidView.context));
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
    
    // TODO: Implement attributes comparison
    override equals(Object other) {
        super.equals(other);
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