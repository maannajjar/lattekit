package io.lattekit.ui.drawable

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.Paint.Style
import android.graphics.Path
import android.graphics.Path.Direction
import android.graphics.PathDashPathEffect
import android.graphics.RectF
import android.graphics.drawable.Drawable
import org.eclipse.xtend.lib.annotations.Accessors

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
	
	
	def drawSegment(Canvas canvas,Path path, RectF bounds,float segementWidth, float firstCornerRadius,float firstAdjacentWidth, float secondCornerRadius,float secondAdjacentWidth) {
		path.reset()
		// Outer line
		if (firstCornerRadius > 0) {
			path.arcTo(bounds.left,bounds.top,bounds.left+firstCornerRadius,bounds.top+firstCornerRadius,-135,45, true);
		} else {
			path.moveTo(bounds.left,bounds.top);
		}
		
		path.lineTo(bounds.right/2.0f,bounds.top);
		path.lineTo(bounds.right/2.0f,bounds.top+segementWidth);
		
		//Inner line
		// We're multiplying inner radius with 2 to keep the inner radius consistent with outer radius (similar to iOS)
		// If we want to mimic  CSS, we should multiply by 1 and adjust outer radius  
		// But that means we should make the border drawn outside the view which means the border affects view size (not intuitive in android)
		var innerRadiusLeft = (firstCornerRadius-firstAdjacentWidth);
		var innerRadiusTop = (firstCornerRadius-segementWidth);
		
		if (firstCornerRadius > 0 && innerRadiusLeft > 0 && innerRadiusTop > 0) {
			path.lineTo(bounds.left+firstAdjacentWidth+innerRadiusLeft,bounds.top+segementWidth);
			path.arcTo(bounds.left+firstAdjacentWidth,bounds.top+segementWidth,
					bounds.left+firstAdjacentWidth+innerRadiusLeft,bounds.top+segementWidth+innerRadiusTop,-90,-45, false);
		} else {
			path.lineTo(bounds.left+firstAdjacentWidth,bounds.top+segementWidth);
		}
		path.close();
		canvas.drawPath(path,paint);	
		path.reset()
		// Outer line
		if (secondCornerRadius > 0) {
			path.arcTo(bounds.right-secondCornerRadius,bounds.top,bounds.right,bounds.top+secondCornerRadius,-45,-45, true);
		} else {
			path.moveTo(bounds.right,bounds.top);
		}
		
		path.lineTo(bounds.right/2.0f,bounds.top);
		path.lineTo(bounds.right/2.0f,bounds.top+segementWidth);
		
		//Inner line
		var innerRadiusRight = (secondCornerRadius-secondAdjacentWidth);
		var innerRadiusTop2 = (secondCornerRadius-segementWidth);
		
					
		if (secondCornerRadius > 0 && innerRadiusRight > 0 && innerRadiusTop2 > 0) {
			path.lineTo(bounds.right-secondAdjacentWidth-innerRadiusRight,bounds.top+segementWidth);
			path.arcTo(bounds.right-secondAdjacentWidth-innerRadiusRight,bounds.top+segementWidth,
					bounds.right-secondAdjacentWidth,bounds.top+segementWidth+innerRadiusTop2,-90,45, false);
		} else {
			path.lineTo(bounds.right-secondAdjacentWidth,bounds.top+segementWidth);
		}
		path.close();
		canvas.drawPath(path,paint);		
		
		
	}
	
	override draw(Canvas canvas) {
		canvas.save()
		paint.style = Paint.Style.FILL_AND_STROKE;
		paint.strokeWidth = 0.5f
		canvas.rotate(-90,bounds.centerX,bounds.centerY);
		if (leftBorderWidth > 0) {
			paint.color = leftBorderColor;
			drawSegment(canvas,path, new RectF(bounds), leftBorderWidth, bottomLeftRadius, bottomBorderWidth, topLeftRadius, topBorderWidth);
		}
		
		canvas.rotate(90,bounds.centerX,bounds.centerY);
		if (topBorderWidth > 0) {
			paint.color = topBorderColor;
			drawSegment(canvas,path, new RectF(bounds), topBorderWidth, topLeftRadius, leftBorderWidth, topRightRadius, rightBorderWidth);
		}
		
		canvas.rotate(90,bounds.centerX,bounds.centerY);
		if (rightBorderWidth > 0) {
			paint.color = rightBorderColor;
			drawSegment(canvas,path, new RectF(bounds), rightBorderWidth, topRightRadius, topBorderWidth, bottomRightRadius, bottomBorderWidth);
		}

		canvas.rotate(90,bounds.centerX,bounds.centerY);
		if (bottomBorderWidth > 0) {
			paint.color = bottomBorderColor;
			drawSegment(canvas,path, new RectF(bounds), bottomBorderWidth, bottomRightRadius, rightBorderWidth, bottomLeftRadius, leftBorderWidth);
		}
		
		canvas.restore();
		
		
//		// Outer line
//		if (topLeftRadius > 0) {
//			path.arcTo(bounds.left,bounds.top,bounds.left+topLeftRadius*2,bounds.top+topLeftRadius*2,-135,45, true);
//		} else {
//			path.moveTo(bounds.left,bounds.top);
//		}
//		
//		path.lineTo(bounds.right/2.0f,bounds.top);
//		path.lineTo(bounds.right/2.0f,bounds.top+topBorderWidth);
//		
//		//Inner line
//		path.lineTo(bounds.left+leftBorderWidth+topLeftRadius,bounds.top+topBorderWidth);			
//		if (topLeftRadius > 0) {
//			path.arcTo(bounds.left+leftBorderWidth,bounds.top+topBorderWidth,
//					bounds.left+leftBorderWidth+topLeftRadius,bounds.top+topBorderWidth+topLeftRadius,-90,-45, false);
//		} else {
//			path.lineTo(bounds.left+leftBorderWidth+topLeftRadius,bounds.top+topBorderWidth);
//		}
		
		
		
		
		
		
		canvas.restore()
	}
	def drawOld(Canvas canvas) {
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