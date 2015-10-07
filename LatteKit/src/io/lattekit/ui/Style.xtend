package io.lattekit.ui

import android.R
import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.RippleDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Build
import android.util.Log
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.MarginLayoutParams
import io.lattekit.StyleProperty
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

import static extension io.lattekit.xtend.ArrayLiterals2.*
import android.util.TypedValue

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
	@StyleProperty public Object borderColor = Color.WHITE;
	@StyleProperty public Object textColor = Color.BLACK;

	@StyleProperty public Integer backgroundDrawable;
		
	@StyleProperty public NumberValue cornerRadius = new NumberValue(0,android.util.TypedValue.COMPLEX_UNIT_DIP);
	@StyleProperty public NumberValue borderWidth = new NumberValue(0,android.util.TypedValue.COMPLEX_UNIT_DIP);
	
	@StyleProperty public NumberValue margin = new NumberValue(0,android.util.TypedValue.COMPLEX_UNIT_PX);
	@StyleProperty public NumberValue marginTop;
	@StyleProperty public NumberValue marginBottom;
	@StyleProperty public NumberValue marginLeft;
	@StyleProperty public NumberValue marginRight;
	
	@StyleProperty public NumberValue elevation = new NumberValue(0,android.util.TypedValue.COMPLEX_UNIT_PX);
	@StyleProperty public NumberValue translationY = new NumberValue(0,android.util.TypedValue.COMPLEX_UNIT_PX);
	@StyleProperty public NumberValue translationX = new NumberValue(0,android.util.TypedValue.COMPLEX_UNIT_PX);
	@StyleProperty public NumberValue x;
	@StyleProperty public NumberValue y;
	public Float _computedX;
	public Float _computedY;
	
	@StyleProperty public NumberValue padding = new NumberValue(0,android.util.TypedValue.COMPLEX_UNIT_PX);
	@StyleProperty public NumberValue paddingTop;
	@StyleProperty public NumberValue paddingBottom;
	@StyleProperty public NumberValue paddingLeft;
	@StyleProperty public NumberValue paddingRight;
	
	@StyleProperty public List<List<Object>> transitions;
	
	@StyleProperty public NumberValue width = new NumberValue(ViewGroup.LayoutParams.WRAP_CONTENT, android.util.TypedValue.COMPLEX_UNIT_PX);
	@StyleProperty public NumberValue height = new NumberValue(ViewGroup.LayoutParams.WRAP_CONTENT, android.util.TypedValue.COMPLEX_UNIT_PX);
	
	
	
	
    def applyStyle(Style appliedStyle) {
        _backgroundColor = appliedStyle._backgroundColor.otherwise(_backgroundColor)
        _rippleColor = appliedStyle._rippleColor.otherwise(_rippleColor)
        _borderColor = appliedStyle._borderColor.otherwise(_borderColor)
        _textColor = appliedStyle._textColor.otherwise(_textColor)
        _backgroundDrawable = appliedStyle._backgroundDrawable.otherwise(_backgroundDrawable)
        _cornerRadius = appliedStyle._cornerRadius.otherwise(_cornerRadius)
        _borderWidth = appliedStyle._borderWidth.otherwise(_borderWidth)
        _margin = appliedStyle._margin.otherwise(_margin)
        _marginTop = appliedStyle._marginTop.otherwise(_marginTop)
        _marginBottom = appliedStyle._marginBottom.otherwise(_marginBottom)
        _marginLeft = appliedStyle._marginLeft.otherwise(_marginLeft)
        _marginRight = appliedStyle._marginRight.otherwise(_marginRight)
        _elevation = appliedStyle._elevation.otherwise(_elevation)
        _translationX = appliedStyle._translationX.otherwise(_translationX)
        _translationY = appliedStyle._translationY.otherwise(_translationY)
        
        _x = appliedStyle.x.otherwise(_x)
        _y = appliedStyle.y.otherwise(_y)
        
        _padding = appliedStyle._padding.otherwise(_padding)
        _paddingTop = appliedStyle._paddingTop.otherwise(_paddingTop)
        _paddingBottom = appliedStyle._paddingBottom.otherwise(_paddingBottom)
        _paddingLeft = appliedStyle._paddingLeft.otherwise(_paddingLeft)
        _paddingRight = appliedStyle._paddingRight.otherwise(_paddingRight)
        
        _width = appliedStyle._width.otherwise(_width)
        _height = appliedStyle._height.otherwise(_height)
        
        _transitions = appliedStyle._transitions.otherwise(new ArrayList<List<Object>>()) as List<List<Object>>
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
		this.textColor = form.textColor
		this.backgroundDrawable = form.backgroundDrawable
		this.cornerRadius = form.cornerRadius
		this.borderWidth = form.borderWidth
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
		this.transitions = form.transitions
		this.x = form.x
		this.y = form.y
	}
	def void cloneFrom(Style form) {
		this.backgroundColor = form._backgroundColor
		this.rippleColor = form._rippleColor
		this.borderColor = form._borderColor
		this.textColor = form._textColor
		this.backgroundDrawable = form._backgroundDrawable
		this.cornerRadius = form._cornerRadius
		this.borderWidth = form._borderWidth
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
				]
				startStyle.applyStyle(latteView)
				
			}
		])
		immediateAnim.setDuration(1);

		var List<Animator> allAnims = newArrayList();
		allAnims += immediateAnim;
		if (transitions != null) {
			allAnims += transitions.map[
				val propName = it.get(0) as String;
				val duration = (it.get(1) as Integer).otherwise(0);
				val delay = (it.get(3) as Integer).otherwise(0);

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
				if (startValue.class == Integer || startValue instanceof NumberValue) {
					var start = if (startValue instanceof NumberValue) { startValue.inPixelsInt(latteView.androidView.context); } else { startValue as Integer}
					var end = if (myValue instanceof NumberValue) { myValue.inPixelsInt(latteView.androidView.context); } else { myValue as Integer}
					Log.d("Latte", "i Animating "+propName+" from "+ start + " to "+end +" in "+duration);
					anim = ValueAnimator.ofInt(start,end);
					anim.addUpdateListener([ 
						if (latteView.currentAnimation == animSet) { 
//							try { 
//								startStyle.setProperty(propName, animatedValue as Integer);
//							} catch (Exception ex) {
//								startStyle.setProperty(propName, new NumberValue(animatedValue as Integer, 0));
//							}
							startStyle.setProperty(propName, new NumberValue(animatedValue as Integer, 0));
							startStyle.applyStyle(latteView)
						}
					]);
				} else if (startValue.class == Float) {
					var start = if (startValue instanceof NumberValue) { startValue.inPixels(latteView.androidView.context); } else { startValue as Float;}
					var end = if (myValue instanceof NumberValue) { myValue.inPixels(latteView.androidView.context); } else { myValue as Float;}
					anim = ValueAnimator.ofFloat(start, end);
					Log.d("Latte", "f Animating "+propName+" from "+ start + " to "+end );
					anim.addUpdateListener([
						if (latteView.currentAnimation == animSet) { 
//							try { 
//								startStyle.setProperty(propName, animatedValue as Float);
//							} catch (Exception ex) {
//								startStyle.setProperty(propName, new NumberValue(animatedValue as Float, 0));
//							}
							startStyle.setProperty(propName, new NumberValue(animatedValue as Float, 0));
							startStyle.applyStyle(latteView)
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
		return animSet
	}
	
	

    def applyDrawableStyle(LatteView view) {
    	view.backgroundDrawable.colors = #[backgroundColor.asColor, backgroundColor.asColor]
		view.backgroundDrawable.setStroke(borderWidth.inPixelsInt(view.androidView.context), borderColor.asColor);
	    view.backgroundDrawable.setCornerRadius(cornerRadius.inPixels(view.androidView.context));
//	    Todo: investigate whether we need to call this
//	    view.backgroundDrawable.invalidateSelf
//	    view.updateBackgroundDrawable();
	

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
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			(view.androidView.background as RippleDrawable).setColor(new ColorStateList(colorStates.unwrap, colorList));
		} else {		
			(view.androidView.background as codetail.graphics.drawables.RippleDrawable).setColor(new ColorStateList(colorStates.unwrap, colorList));
		}
    }
    
    def applyDrawableShape(LatteView latteView) {
    	var float[] radii = if (cornerRadius != null) { 
    		var radius = cornerRadius.inPixels(latteView.androidView.context)
    		#[radius,radius,radius,radius,radius,radius,radius,radius];
    	} else null;
    	var shape = new RoundRectShape(radii, null,null);
		latteView.shapeDrawable.shape = shape;
//		Todo: investigate whether we need to call this
//		latteView.shapeDrawable.invalidateSelf
    }
    
    def applyStyle(LatteView latteView) {
    	var androidView = latteView.androidView;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			androidView.elevation = elevation.inPixels(androidView.context);
		}
		applyDrawableStyle(latteView);
		applyDrawableShape(latteView);
		androidView.translationY = translationY.inPixels(androidView.context)
		androidView.translationX = translationX.inPixels(androidView.context);
		
		if (x != null) androidView.x = x.inPixels(androidView.context)
		if (y != null) androidView.y = y.inPixels(androidView.context)
		
		
		var pLeft = paddingLeft.otherwise(padding).inPixelsInt(androidView.context)
		var pRight = paddingRight.otherwise(padding).inPixelsInt(androidView.context)
		var pTop = paddingTop.otherwise(padding).inPixelsInt(androidView.context)
		var pBottom = paddingBottom.otherwise(padding).inPixelsInt(androidView.context)
		
		androidView.setPadding(pLeft,pTop,pRight,pBottom);
		
		// Layout Params
    	var LayoutParams lp = androidView.layoutParams
		lp.width = width.inPixelsInt(androidView.context)
		lp.height = height.inPixelsInt(androidView.context)
    	if (lp instanceof MarginLayoutParams) {
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
    	androidView.layoutParams = lp;
    }
    
    
    def NumberValue otherwise(NumberValue left, NumberValue or) {
		return if (left != null) left else or;
	}
    
    
	def Object otherwise(Object left, Object or) {
		return if (left != null) left else or;
	}
	
	def Integer otherwise(Integer left, Integer or) {
		return if (left != null) left else or;
	}
	
	def Float otherwise(Float left, Float or) {
		return if (left != null) left else or;
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