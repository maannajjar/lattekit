package io.lattekit.ui.drawable

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.Paint.Style
import android.graphics.Path
import android.graphics.Rect
import android.graphics.drawable.Drawable
import org.eclipse.xtend.lib.annotations.Accessors
import android.graphics.RectF

class BorderDrawable extends Drawable {

	@Accessors private int topBorderColor = Color.BLACK;
	@Accessors private int leftBorderColor = Color.BLACK;
	@Accessors private int rightBorderColor = Color.BLACK;
	@Accessors private int bottomBorderColor = Color.BLACK;
	
	@Accessors float topBorderWidth = 10;
	@Accessors float leftBorderWidth = 10;
	@Accessors float rightBorderWidth = 10;
	@Accessors float bottomBorderWidth = 10;
	
	@Accessors float topLeftRadius = 0;
	@Accessors float topRightRadius = 0;
	@Accessors float bottomLeftRadius = 0;
	@Accessors float bottomRightRadius = 0;
	
	private Paint paint;
	private RectF rect;
	private Path path;
	var cornerPath = new Path();
	
	new() {
		paint = new Paint();
		path = new Path();		
	}
	
	override draw(Canvas canvas) {
		rect = new RectF(copyBounds());
		rect.left += leftBorderWidth/2.0f;
		rect.right -= rightBorderWidth/2.0f;
		rect.top += topBorderWidth/2.0f;
		rect.bottom -= bottomBorderWidth/2.0f;
		paint.setPathEffect(null);
		paint.setAntiAlias(true);
		paint.dither = true;
		paint.strokeCap = Paint.Cap.BUTT
		paint.strokeJoin = Paint.Join.MITER;
		paint.style = Paint.Style.STROKE
		
		canvas.save();
		
		if (topBorderWidth > 0) {
			var paint = new Paint();
			
			
			paint.color = topBorderColor;
			path.reset();
			if (topLeftRadius > 0) {
				path.arcTo(rect.left,rect.top,rect.left+topLeftRadius,rect.top+topLeftRadius,-135,45, true);
			} else {
				path.moveTo(rect.left+leftBorderWidth/2.0f,rect.top);
				
				cornerPath.reset();
				cornerPath.moveTo(bounds.left,bounds.top);
				cornerPath.lineTo(bounds.left+leftBorderWidth,bounds.top);
				cornerPath.lineTo(bounds.left+leftBorderWidth,bounds.top+topBorderWidth);
				cornerPath.close
				paint.style = Paint.Style.FILL
				paint.strokeWidth = 1;
				canvas.drawPath(cornerPath,paint);
				
			}
			
			if (topRightRadius > 0) {
				path.lineTo(rect.right - Math.min(rect.width/2.0f, topRightRadius/2.0f),rect.top);
				path.arcTo(rect.right - topRightRadius,rect.top,rect.right,rect.top+topRightRadius,-90,45, false);
			} else {
				path.lineTo(rect.right - rightBorderWidth/2.0f,rect.top);
				
				cornerPath.reset();
				cornerPath.moveTo(bounds.right,bounds.top);
				cornerPath.lineTo(bounds.right-rightBorderWidth,bounds.top);
				cornerPath.lineTo(bounds.right-rightBorderWidth,bounds.top+topBorderWidth);
				cornerPath.close
				paint.style = Paint.Style.FILL
				paint.strokeWidth = 1;
				canvas.drawPath(cornerPath,paint);
				
			}
			
			paint.strokeWidth = topBorderWidth;
			paint.style = Paint.Style.STROKE
			canvas.drawPath(path,paint);
		}
		
		if (leftBorderWidth > 0) {
			paint.strokeWidth = leftBorderWidth	
			paint.color = leftBorderColor;
			path.reset();
			if (topLeftRadius > 0) {
				// Top Left Corner
				path.arcTo(rect.left,rect.top,rect.left+topLeftRadius,rect.top+topLeftRadius,-135,-45, true);
			} else {
				path.moveTo(rect.left,rect.top+topBorderWidth/2.0f);
				
				cornerPath.reset();
				cornerPath.moveTo(bounds.left,bounds.top);
				cornerPath.lineTo(bounds.left,bounds.top+topBorderWidth);
				cornerPath.lineTo(bounds.left+leftBorderWidth,bounds.top+topBorderWidth);
				cornerPath.close
				paint.style = Paint.Style.FILL
				paint.strokeWidth = 1;
				canvas.drawPath(cornerPath,paint);
				
			}
			
			if (bottomLeftRadius > 0) {
				// Line
				path.lineTo(rect.left,rect.bottom - Math.min(rect.height/2.0f,bottomLeftRadius/2.0f));
				// Bottom Left Corner
				path.arcTo(rect.left,rect.bottom - bottomLeftRadius,rect.left+bottomLeftRadius,rect.bottom,-180,-45,false);								
			} else {
				path.lineTo(rect.left,rect.bottom - bottomBorderWidth/2.0f);
				
				cornerPath.reset();
				cornerPath.moveTo(bounds.left,bounds.bottom);
				cornerPath.lineTo(bounds.left,bounds.bottom-bottomBorderWidth);
				cornerPath.lineTo(bounds.left+leftBorderWidth,bounds.bottom-bottomBorderWidth);
				cornerPath.close
				paint.style = Paint.Style.FILL
				paint.strokeWidth = 1;
				canvas.drawPath(cornerPath,paint);
			}
			paint.strokeWidth = leftBorderWidth;
			paint.style = Paint.Style.STROKE
			canvas.drawPath(path,paint);
		}
		
		
		if (rightBorderWidth > 0) {
			paint.strokeWidth = rightBorderWidth	
			paint.setStyle(Style.STROKE);
			paint.color = rightBorderColor;
			path.reset();
			
			if (topRightRadius > 0) {
				path.arcTo(rect.right-topRightRadius,rect.top,rect.right,rect.top+topRightRadius,-45,45,true);	
			} else {
				path.moveTo(rect.right,rect.top+topBorderWidth/2.0f);
				
				cornerPath.reset();
				cornerPath.moveTo(bounds.right,bounds.top);
				cornerPath.lineTo(bounds.right,bounds.top+topBorderWidth);
				cornerPath.lineTo(bounds.right-rightBorderWidth,bounds.top+topBorderWidth);
				cornerPath.close
				paint.style = Paint.Style.FILL
				paint.strokeWidth = 1;
				canvas.drawPath(cornerPath,paint);

			}
			if (bottomRightRadius > 0) {
				path.lineTo(rect.right,rect.bottom - Math.min(rect.height/2.0f,bottomRightRadius/2.0f));
				path.arcTo(rect.right-bottomRightRadius,rect.bottom - bottomRightRadius,rect.right,rect.bottom,0,45, false)
			} else {
				path.lineTo(rect.right,rect.bottom - bottomBorderWidth/2.0f);
				
				cornerPath.reset();
				cornerPath.moveTo(bounds.right,bounds.bottom);
				cornerPath.lineTo(bounds.right,bounds.bottom-bottomBorderWidth);
				cornerPath.lineTo(bounds.right-rightBorderWidth,bounds.bottom-bottomBorderWidth);
				cornerPath.close
				paint.style = Paint.Style.FILL
				paint.strokeWidth = 1;
				canvas.drawPath(cornerPath,paint);
				
			}
			paint.strokeWidth = rightBorderWidth;
			paint.style = Paint.Style.STROKE
			canvas.drawPath(path,paint);
		}
		
		
		if (bottomBorderWidth > 0) {
			var paint = new Paint();
			paint.strokeWidth = bottomBorderWidth;
			paint.style = Paint.Style.STROKE
			paint.color = bottomBorderColor;
			path.reset();
			if (bottomLeftRadius > 0) {
				path.arcTo(rect.left,rect.bottom-bottomLeftRadius,rect.left+bottomLeftRadius,rect.bottom,-180-45,-45,true);
			} else {
				path.moveTo(rect.left+leftBorderWidth/2.0f,rect.bottom);
				
				cornerPath.reset();
				cornerPath.moveTo(bounds.left,bounds.bottom);
				cornerPath.lineTo(bounds.left+leftBorderWidth,bounds.bottom);
				cornerPath.lineTo(bounds.left+leftBorderWidth,bounds.bottom-bottomBorderWidth);
				cornerPath.close
				paint.style = Paint.Style.FILL
				paint.strokeWidth = 1;
				canvas.drawPath(cornerPath,paint);
				
			}
			if (bottomRightRadius > 0) {
				path.lineTo(rect.right - Math.min(rect.width/2.0f, bottomRightRadius/2.0f),rect.bottom);
				path.arcTo(rect.right-bottomRightRadius,rect.bottom-bottomRightRadius,rect.right,rect.bottom,90,-45, false);
			} else {
				path.lineTo(rect.right - rightBorderWidth/2.0f,rect.bottom);
				
				cornerPath.reset();
				cornerPath.moveTo(bounds.right,bounds.bottom);
				cornerPath.lineTo(bounds.right-rightBorderWidth,bounds.bottom);
				cornerPath.lineTo(bounds.right-rightBorderWidth,bounds.bottom-bottomBorderWidth);
				cornerPath.close
				paint.style = Paint.Style.FILL
				paint.strokeWidth = 1;
				canvas.drawPath(cornerPath,paint);
			}
			
			paint.strokeWidth = bottomBorderWidth;
			paint.style = Paint.Style.STROKE			
			canvas.drawPath(path,paint);
		}
		canvas.restore();
	}
	
	override getOpacity() {
		return 0;
	}
	
	override setAlpha(int alpha) {
		
	}
	
	override setColorFilter(ColorFilter cf) {
		
	}
	
}