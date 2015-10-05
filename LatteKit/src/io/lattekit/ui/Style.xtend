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

class NumberValue {
	@Accessors var int value;
	@Accessors var int type;
	new(int value, int type) {
		this.value = value;
		this.type = type;
	}
	def inPixels(Context context) {
		// TODO Convert
		return value;
	}
} 
class Style {
	
	@Accessors Style parentStyle;
	@StyleProperty public Object backgroundColor = Color.WHITE;
	@StyleProperty public Object rippleColor;
	@StyleProperty public Object borderColor = Color.WHITE;
	@StyleProperty public Object textColor = Color.BLACK;

	@StyleProperty public Integer backgroundDrawable;
		
	@StyleProperty public NumberValue cornerRadius = new NumberValue(10,android.util.TypedValue.COMPLEX_UNIT_DIP);
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
	
	
	def Style inheritsFrom(Style parentStyle) {
		var myStyle = new Style();
		
		myStyle.backgroundColor = _backgroundColor.otherwise(parentStyle.backgroundColor)
		myStyle.rippleColor = _rippleColor.otherwise(parentStyle.rippleColor)
		myStyle.borderColor = _borderColor.otherwise(parentStyle.borderColor)
		myStyle.textColor = _textColor.otherwise(parentStyle.textColor)
		myStyle.backgroundDrawable = _backgroundDrawable.otherwise(parentStyle.backgroundDrawable)
		myStyle.cornerRadius = _cornerRadius.otherwise(parentStyle.cornerRadius)
		myStyle.borderWidth = _borderWidth.otherwise(parentStyle.borderWidth)
		myStyle.margin = _margin.otherwise(parentStyle.margin)
		myStyle.marginTop = _marginTop.otherwise(parentStyle.marginTop.otherwise(_margin))
		myStyle.marginBottom = _marginBottom.otherwise(parentStyle.marginBottom.otherwise(_margin))
		myStyle.marginLeft = _marginLeft.otherwise(parentStyle.marginLeft.otherwise(_margin))
		myStyle.marginRight = _marginRight.otherwise(parentStyle.marginRight.otherwise(_margin))
		myStyle.elevation = _elevation.otherwise(parentStyle.elevation)
		myStyle.translationX = _translationX.otherwise(parentStyle.translationX)
		myStyle.translationY = _translationY.otherwise(parentStyle.translationY)
		
		myStyle.x = x.otherwise(parentStyle.x)
		myStyle.y = y.otherwise(parentStyle.y)
		
		myStyle.padding = _padding.otherwise(parentStyle.padding)
		myStyle.paddingTop = _paddingTop.otherwise(parentStyle.paddingTop)
		myStyle.paddingBottom = _paddingBottom.otherwise(parentStyle.paddingBottom)
		myStyle.paddingLeft = _paddingLeft.otherwise(parentStyle.paddingLeft)
		myStyle.paddingRight = _paddingRight.otherwise(parentStyle.paddingRight)
		
		myStyle.width = _width.otherwise(parentStyle.width)
		myStyle.height = _height.otherwise(parentStyle.height)
		
		myStyle.transitions = _transitions.otherwise(new ArrayList<List<Object>>()) as List<List<Object>>
		
		return myStyle
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
				var floatVal = Float.parseFloat(value);
				style.setProperty(key,floatVal);
				return
			} catch(Exception ex) {}			
			style.setProperty(key,value);
		];
		return style;
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
						startStyle.setProperty(it, _computedX)
					} else if (it == "y" && _computedY != null && revertToNormal  && startStyle.y != null) {
						startStyle.setProperty(it, _computedY)
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
				val duration = it.get(1) as Integer;
				val delay = it.get(3) as Integer;

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
				if (propName == "y") {
					Log.d("Latte", "Animating from "+ startValue + " to "+myValue +" (? "+ revertToNormal+" * " + latteView.androidView.y+")");
				}
				var ValueAnimator anim = null;
				if (propName == "width") {
					myValue = actualSize.x;
					startValue = startActualSize.x;
				}
				if (propName == "height") {
					myValue = actualSize.y
					startValue = startActualSize.y
				}
				if (myValue == null || startValue == null) {
					Log.d("Latte", latteView +": No start or end value for "+propName)
					return null;
				}
				if (startValue.class == Integer) {
					anim = ValueAnimator.ofInt(startValue as Integer, myValue as Integer);
					anim.addUpdateListener([ 
						if (latteView.currentAnimation == animSet) { 
							startStyle.setProperty(propName, animatedValue as Integer);
							startStyle.applyStyle(latteView)
						}
					]);
				} else if (startValue.class == Float) {
					anim = ValueAnimator.ofFloat(startValue as Float, myValue as Float);
					anim.addUpdateListener([
						if (latteView.currentAnimation == animSet) { 
							startStyle.setProperty(propName, animatedValue as Float);
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
		view.backgroundDrawable.setStroke(borderWidth.inPixels(view.androidView.context), borderColor.asColor);
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
		
		
		var pLeft = paddingLeft.otherwise(padding).inPixels(androidView.context)
		var pRight = paddingRight.otherwise(padding).inPixels(androidView.context)
		var pTop = paddingTop.otherwise(padding).inPixels(androidView.context)
		var pBottom = paddingBottom.otherwise(padding).inPixels(androidView.context)
		
		androidView.setPadding(pLeft,pTop,pRight,pBottom);
		
		// Layout Params
    	var LayoutParams lp = androidView.layoutParams
		lp.width = width.inPixels(androidView.context)
		lp.height = height.inPixels(androidView.context)
    	if (lp instanceof MarginLayoutParams) {
	    	if (margin != null) {
	    		lp.leftMargin = margin.inPixels(androidView.context)
	    		lp.topMargin = margin.inPixels(androidView.context)
	    		lp.rightMargin = margin.inPixels(androidView.context)
	    		lp.bottomMargin = margin.inPixels(androidView.context)
	    	}
	    	
	    	if (marginLeft != null) {
	    		lp.leftMargin = marginLeft.inPixels(androidView.context)
	    	}
	    	if (marginRight != null) {
	    		lp.rightMargin = marginRight.inPixels(androidView.context)
	    	}
	    	if (marginBottom != null) {
	    		lp.bottomMargin = marginBottom.inPixels(androidView.context)
	    	}
	    	if (marginTop != null) {
	    		lp.topMargin = marginTop.inPixels(androidView.context)
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