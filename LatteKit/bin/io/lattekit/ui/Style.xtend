package io.lattekit.ui

import android.animation.AnimatorSet
import android.animation.IntEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.GradientDrawable.Orientation
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Build
import android.util.Log
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.MarginLayoutParams
import org.eclipse.xtend.lib.annotations.Accessors

class Style {
	
	@Accessors public Object backgroundColor;
	@Accessors public Object borderColor;
	@Accessors public Object textColor;
	
	@Accessors public Integer backgroundDrawable;
		
	@Accessors public Integer cornerRadius;
	@Accessors public Integer borderWidth;
	
	@Accessors public Integer margin;
	@Accessors public Integer marginTop;
	@Accessors public Integer marginBottom;
	@Accessors public Integer marginLeft;
	@Accessors public Integer marginRight;
	
	@Accessors public Integer elevation;
	@Accessors public Integer translationY;
	@Accessors public Integer translationX;
	
	
	def Style inheritsFrom(Style parentStyle) {
		var myStyle = new Style();
		
		myStyle.backgroundColor = backgroundColor.otherwise(parentStyle.backgroundColor)
		myStyle.borderColor = borderColor.otherwise(parentStyle.borderColor)
		myStyle.textColor = textColor.otherwise(parentStyle.textColor)
		myStyle.backgroundDrawable = backgroundDrawable.otherwise(parentStyle.backgroundDrawable)
		myStyle.cornerRadius = cornerRadius.otherwise(parentStyle.cornerRadius)
		myStyle.borderWidth = borderWidth.otherwise(parentStyle.borderWidth)
		myStyle.margin = margin.otherwise(parentStyle.margin)
		myStyle.marginTop = marginTop.otherwise(parentStyle.marginTop)
		myStyle.marginBottom = marginBottom.otherwise(parentStyle.marginBottom)
		myStyle.marginLeft = marginLeft.otherwise(parentStyle.marginLeft)
		myStyle.marginRight = marginRight.otherwise(parentStyle.marginRight)
		myStyle.elevation = elevation.otherwise(parentStyle.elevation)
		myStyle.translationX = translationX.otherwise(parentStyle.translationX)
		myStyle.translationY = translationY.otherwise(parentStyle.translationY)
		
		return myStyle
	}
	
	def createAnimatorFrom(Style startStyle, android.view.View androidView) {
		var animSet = new AnimatorSet();
		var animator1 = ObjectAnimator.ofObject(androidView,"elevation",new IntEvaluator(),startStyle.elevation.otherwise(0), elevation.otherwise(0))
		animator1.duration = 100;
		
		var animator2 = ObjectAnimator.ofObject(androidView,"translationY",new IntEvaluator(),startStyle.translationY.otherwise(0), translationY.otherwise(0))
		animator2.duration = 100;
		
		var animator3 = ObjectAnimator.ofObject(androidView,"translationX",new IntEvaluator(),startStyle.translationX.otherwise(0), translationX.otherwise(0))
		animator3.duration = 100;
		
		animSet.playTogether(animator1 ,animator2,animator3)
		
		return animSet
	}
	
	def Object otherwise(Object left, Object or) {
		return if (left != null) left else or;
	}
	
	def Integer otherwise(Integer left, Integer or) {
		return if (left != null) left else or;
	}
	
	def Drawable getDrawable() {
		var drawable = new GradientDrawable(Orientation.BOTTOM_TOP, #[backgroundColor.asColor, backgroundColor.asColor]);
	    drawable.setStroke(borderWidth.otherwise(0), borderColor.asColor);
	    drawable.setCornerRadius(cornerRadius.otherwise(0));
	    return drawable;
//	    
//    	var float[] radii = if (cornerRadius != null) { 
//    		#[cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius];
//    	} else null;
//    	var shape = new RoundRectShape(radii, null,null);
//    	var shapeDrawable = new ShapeDrawable(shape);
//    	shapeDrawable.paint.color = backgroundColor.asColor
//    	
//    	var borderDrawable = new ShapeDrawable(shape);
//    	borderDrawable.paint.color = borderColor.asColor
//    	borderDrawable.paint.strokeWidth = borderWidth.otherwise(0)
//    	borderDrawable.paint.style = Paint.Style.STROKE;
//    	borderDrawable.paint.antiAlias = true;
//    	borderDrawable.paint.dither = true
//    	
//    	
//    	var layers = new LayerDrawable(#[shapeDrawable,borderDrawable]);
//    	
//    	return layers
	    
    }
    
    def getShapeDrawable() {
    	var float[] radii = if (cornerRadius != null) { 
    		#[cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius,cornerRadius];
    	} else null;
    	var shape = new RoundRectShape(radii, null,null);
    	return new ShapeDrawable(shape);
    }
        
    def applyStyle(android.view.View androidView) {

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			androidView.elevation = elevation.otherwise(0)
		}
		androidView.translationY = translationY.otherwise(0);
		androidView.translationX = translationX.otherwise(0);

		
		// Layout Params
    	var LayoutParams lp = androidView.layoutParams 
    	if (lp instanceof MarginLayoutParams) {
    		Log.d("Latte","Setting margins")
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
	    		Log.d("Latte","Setting top margin")
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