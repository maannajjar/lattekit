package io.lattekit.ui

import android.R
import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.RippleDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Build
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.MarginLayoutParams
import io.lattekit.StyleProperty
import java.util.ArrayList
import java.util.List

import static extension io.lattekit.xtend.ArrayLiterals2.*

class Style {
	var boolean isPrivate = false;
	
	@StyleProperty public Object backgroundColor = Color.WHITE;
	@StyleProperty public Object rippleColor;
	@StyleProperty public Object borderColor = Color.WHITE;
	@StyleProperty public Object textColor = Color.BLACK;
	
	@StyleProperty public Integer backgroundDrawable;
		
	@StyleProperty public Integer cornerRadius = 10;
	@StyleProperty public Integer borderWidth = 5;
	
	@StyleProperty public Integer margin = 0;
	@StyleProperty public Integer marginTop;
	@StyleProperty public Integer marginBottom;
	@StyleProperty public Integer marginLeft;
	@StyleProperty public Integer marginRight;
	
	@StyleProperty public Integer elevation = 0;
	@StyleProperty public Integer translationY = 0;
	@StyleProperty public Integer translationX = 0;
	@StyleProperty public Float x;
	@StyleProperty public Float y;
	public Float _computedX;
	public Float _computedY;
	
	@StyleProperty public Integer padding = 0;
	@StyleProperty public Integer paddingTop;
	@StyleProperty public Integer paddingBottom;
	@StyleProperty public Integer paddingLeft = 0;
	@StyleProperty public Integer paddingRight = 0;
	
	@StyleProperty public List<List<Object>> transitions;
	
	@StyleProperty public Integer width = ViewGroup.LayoutParams.WRAP_CONTENT;
	@StyleProperty public Integer height = ViewGroup.LayoutParams.WRAP_CONTENT;
	
	
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
	
	def void cloneFrom(Style from) { cloneFrom(from, false) }
	def void cloneFrom(Style form, boolean excludeComputed) {
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
		if (!excludeComputed) {
			this.x = form._x
			this.y = form._y
		}
	}
	
	override Style clone() {
		var myStyle = new Style()	
		myStyle.cloneFrom(this);
		myStyle.isPrivate = true;	
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
				var ValueAnimator anim = null;
				if (propName == "width") {
					myValue = actualSize.x;
					startValue = startActualSize.x;
				}
				if (propName == "height") {
					myValue = actualSize.y
					startValue = startActualSize.y
				}
				if (myValue == null) {
					return null;
				}
				if (startValue.class == Integer) {
					anim = ValueAnimator.ofInt(startValue as Integer, myValue as Integer);
					anim.addUpdateListener([ 
						if (latteView.currentAnimation == animSet) { 
							startStyle.setProperty(propName, animatedValue as Integer);
							startStyle.applyDrawableStyle(latteView);
							startStyle.applyStyle(latteView)
						}
					]);
				} else if (startValue.class == Float) {
					anim = ValueAnimator.ofFloat(startValue as Float, myValue as Float);
					anim.addUpdateListener([
						if (latteView.currentAnimation == animSet) { 
							startStyle.setProperty(propName, animatedValue as Float);
							startStyle.applyDrawableStyle(latteView);
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
		view.backgroundDrawable.setStroke(borderWidth, borderColor.asColor);
	    view.backgroundDrawable.setCornerRadius(cornerRadius);
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
    
    def applyShapeDrawable(LatteView latteView) {
    	var float[] radii = if (cornerRadius != null) { 
    		#[cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius];
    	} else null;
    	var shape = new RoundRectShape(radii, null,null);
		latteView.shapeDrawable.shape = shape;
//		Todo: investigate whether we need to call this
//		latteView.shapeDrawable.invalidateSelf
    }
    
    def applyStyle(LatteView latteView) {
    	var androidView = latteView.androidView;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			androidView.elevation = elevation;
		}
		applyShapeDrawable(latteView);
		androidView.translationY = translationY
		androidView.translationX = translationX
		
		if (x != null) androidView.x = x
		if (y != null) androidView.y = y
		
		
		var pLeft = paddingLeft.otherwise(padding);
		var pRight = paddingRight.otherwise(padding);
		var pTop = paddingTop.otherwise(padding);
		var pBottom = paddingBottom.otherwise(padding);
		
		androidView.setPadding(pLeft,pTop,pRight,pBottom);
		
		// Layout Params
    	var LayoutParams lp = androidView.layoutParams
		lp.width = width
		lp.height = height
    	if (lp instanceof MarginLayoutParams) {
	    	if (margin != null) {
	    		lp.leftMargin = margin
	    		lp.topMargin = margin
	    		lp.rightMargin = margin
	    		lp.bottomMargin = margin
	    	}
	    	
	    	if (marginLeft != null) {
	    		lp.leftMargin = marginLeft
	    	}
	    	if (marginRight != null) {
	    		lp.rightMargin = marginRight
	    	}
	    	if (marginBottom != null) {
	    		lp.bottomMargin = marginBottom
	    	}
	    	if (marginTop != null) {
	    		lp.topMargin = marginTop
	    	}
    	}
    	androidView.layoutParams = lp;
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