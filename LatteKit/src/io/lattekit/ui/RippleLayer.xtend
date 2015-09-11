package io.lattekit.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class RippleLayer {
	
	var rippleDuration = 400;
	var animationRunning = true;
	var backgroundColor = Color.BLACK;
	var rippleColor = Color.GRAY;
	var  rippleAlpha = 90;
	var Paint paint;
	var x = 0; var y = 0;
	var float radiusMax = 0;	
	var currentRadius = 3;
	new() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(rippleColor);
        paint.setAlpha(rippleAlpha);		
	}
	def void draw(Canvas canvas) {

		canvas.drawCircle(x, y, (radiusMax * (0.5f)), paint);				
	}
}