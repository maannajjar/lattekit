package io.lattekit.ui

import android.animation.AnimatorSet
import android.animation.IntEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.GradientDrawable.Orientation
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Build
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.MarginLayoutParams
import io.lattekit.StyleProperty

class Style {
	
	var GradientDrawable currentDrawable;
	var boolean isPrivate = false;
	@StyleProperty public Object backgroundColor = Color.WHITE;
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
	
	@StyleProperty public Integer padding = 0;
	@StyleProperty public Integer paddingTop;
	@StyleProperty public Integer paddingBottom;
	@StyleProperty public Integer paddingLeft = 30;
	@StyleProperty public Integer paddingRight = 30;
	
	def Style inheritsFrom(Style parentStyle) {
		var myStyle = new Style();
		
		myStyle.backgroundColor = _backgroundColor.otherwise(parentStyle.backgroundColor)
		myStyle.borderColor = _borderColor.otherwise(parentStyle.borderColor)
		myStyle.textColor = _textColor.otherwise(parentStyle.textColor)
		myStyle.backgroundDrawable = _backgroundDrawable.otherwise(parentStyle.backgroundDrawable)
		myStyle.cornerRadius = _cornerRadius.otherwise(parentStyle.cornerRadius)
		myStyle.borderWidth = _borderWidth.otherwise(parentStyle.borderWidth)
		myStyle.margin = _margin.otherwise(parentStyle.margin)
		myStyle.marginTop = _marginTop.otherwise(parentStyle.marginTop)
		myStyle.marginBottom = _marginBottom.otherwise(parentStyle.marginBottom)
		myStyle.marginLeft = _marginLeft.otherwise(parentStyle.marginLeft)
		myStyle.marginRight = _marginRight.otherwise(parentStyle.marginRight)
		myStyle.elevation = _elevation.otherwise(parentStyle.elevation)
		myStyle.translationX = _translationX.otherwise(parentStyle.translationX)
		myStyle.translationY = _translationY.otherwise(parentStyle.translationY)
		
		myStyle.padding = _padding.otherwise(parentStyle.padding)
		myStyle.paddingTop = _paddingTop.otherwise(parentStyle.paddingTop)
		myStyle.paddingBottom = _paddingBottom.otherwise(parentStyle.paddingBottom)
		myStyle.paddingLeft = _paddingLeft.otherwise(parentStyle.paddingLeft)
		myStyle.paddingRight = _paddingRight.otherwise(parentStyle.paddingRight)
		return myStyle
	}
	
	def void cloneFrom(Style form) {
		this.backgroundColor = form._backgroundColor
		this.borderColor = form._borderColor
		this.textColor = form._textColor
		this.backgroundDrawable = form._backgroundDrawable
		this.cornerRadius = form._cornerRadius
		this.borderWidth = form._borderWidth
		this.margin = form._margin
		this.marginTop = form._marginTop
		this.marginBottom = form._marginBottom
		this.marginLeft = _marginLeft
		this.marginRight = form._marginRight
		this.elevation = form._elevation
		this.translationX = form._translationX
		this.translationY = form._translationY
		this.padding = form._padding
		this.paddingTop = form._paddingTop
		this.paddingBottom = form._paddingBottom
		this.paddingLeft = form._paddingLeft
		this.paddingRight = form._paddingRight
	}
	
	override Style clone() {
		var myStyle = new Style()	
		myStyle.cloneFrom(this);
		myStyle.isPrivate = true;	
		return myStyle
	}
	
	def createAnimatorFrom(Style startStyle,LatteView latteView) {
		var animSet = new AnimatorSet();
		// ObjectAnimator.ofObject(androidView,"elevation",new IntEvaluator(),startStyle.elevation.otherwise(0), elevation.otherwise(0))
		val androidView = latteView.androidView;
		var animator1 = ValueAnimator.ofInt(startStyle.borderWidth, borderWidth)
		animator1.addUpdateListener([ 
			borderWidth = animatedValue as Integer
			applyStyle(androidView)
		]);
		animator1.duration = 100;
		
		var animator2 = ObjectAnimator.ofObject(androidView,"translationY",new IntEvaluator(),startStyle.translationY.otherwise(0), translationY.otherwise(0))
		animator2.duration = 100;
		
		var animator3 = ObjectAnimator.ofObject(androidView,"translationX",new IntEvaluator(),startStyle.translationX.otherwise(0), translationX.otherwise(0))
		animator3.duration = 100;
		
		
		var animator4 = ValueAnimator.ofInt(startStyle.cornerRadius, cornerRadius)
		animator4.addUpdateListener([ 
			startStyle.cornerRadius = animatedValue as Integer
			startStyle.updateDrawable();
			
		]);
		animator4.duration = 300;
		
		
		animSet.playTogether(animator1 ,animator2,animator3,animator4)
		
		return animSet
	}
	
	def Object otherwise(Object left, Object or) {
		return if (left != null) left else or;
	}
	
	def Integer otherwise(Integer left, Integer or) {
		return if (left != null) left else or;
	}
	
	def Drawable getDrawable() {
		if (currentDrawable == null) {
			currentDrawable = new GradientDrawable(Orientation.BOTTOM_TOP, #[backgroundColor.asColor, backgroundColor.asColor]);
		}
		updateDrawable();
		return currentDrawable;
	    
    }
    
    def updateDrawable() {
		currentDrawable.setStroke(borderWidth, borderColor.asColor);
	    currentDrawable.setCornerRadius(cornerRadius);
    }
    
    def getShapeDrawable() {
    	var float[] radii = if (cornerRadius != null) { 
    		#[cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius];
    	} else null;
    	var shape = new RoundRectShape(radii, null,null);
    	return new ShapeDrawable(shape);
    }
        
    def applyStyle(View androidView) {
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			androidView.elevation = elevation;
		}
		androidView.translationY = translationY
		androidView.translationX = translationX
		
		var pLeft = paddingLeft.otherwise(padding);
		var pRight = paddingRight.otherwise(padding);
		var pTop = paddingTop.otherwise(padding);
		var pBottom = paddingBottom.otherwise(padding);
		
		androidView.setPadding(pLeft,pTop,pRight,pBottom);
		
		// Layout Params
    	var LayoutParams lp = androidView.layoutParams 
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
    	
    	return lp;
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