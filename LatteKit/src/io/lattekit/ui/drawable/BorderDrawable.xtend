package io.lattekit.ui.drawable

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.Path
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
	private Path path;
	
	new() {
		paint = new Paint();
		path = new Path();		
	}
	
	def drawSegment(Canvas canvas,Path path, RectF bounds,float segementWidth, float firstCornerRadius,float firstAdjacentWidth, float secondCornerRadius,float secondAdjacentWidth) {
		path.reset()
		// Outer line
		if (firstCornerRadius > 0) {
			path.arcTo(bounds.left,bounds.top,bounds.left+firstCornerRadius*2,bounds.top+firstCornerRadius*2,-135,45, true);
		} else {
			path.moveTo(bounds.left,bounds.top);
		}
		
		path.lineTo(bounds.right/2.0f,bounds.top);
		path.lineTo(bounds.right/2.0f,bounds.top+segementWidth);
		
		//Inner line
		// We're multiplying inner radius with 2 to keep the inner radius consistent with outer radius (similar to iOS)
		// If we want to mimic  CSS, we should multiply by 1 and adjust outer radius  
		// But that means we should make the border drawn outside the view which means the border affects view size (not intuitive in android)
		var innerRadiusLeft = (firstCornerRadius-firstAdjacentWidth)*2;
		var innerRadiusTop = (firstCornerRadius-segementWidth)*2;
		
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
			path.arcTo(bounds.right-secondCornerRadius*2,bounds.top,bounds.right,bounds.top+secondCornerRadius*2,-45,-45, true);
		} else {
			path.moveTo(bounds.right,bounds.top);
		}
		
		path.lineTo(bounds.right/2.0f,bounds.top);
		path.lineTo(bounds.right/2.0f,bounds.top+segementWidth);
		
		//Inner line
		var innerRadiusRight = (secondCornerRadius-secondAdjacentWidth)*2;
		var innerRadiusTop2 = (secondCornerRadius-segementWidth)*2;
		
					
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
	}
	
	def drawByOutlines(Canvas canvas) {
		paint.style = Paint.Style.FILL;
		paint.strokeWidth = 2f
		paint.color = Color.RED;
		
		var path = outerPath
		path.op(innerPath,Path.Op.DIFFERENCE);
		canvas.drawPath(path,paint);
	}
	
	def getInnerPath() {
		var bounds = new RectF(copyBounds());
		bounds.left += leftBorderWidth;
		bounds.top += topBorderWidth;
		bounds.right -= rightBorderWidth;
		bounds.bottom -= bottomBorderWidth;
		
        var innerPath = new Path();
		
		var innerRadiusWidth = (topLeftRadius-leftBorderWidth);
		var innerRadiusHeight = (topLeftRadius-topBorderWidth);
		
        if (innerRadiusHeight > 0 || innerRadiusWidth >0) {
            innerPath.arcTo(bounds.left,bounds.top,bounds.left+innerRadiusWidth*2,bounds.top+innerRadiusHeight*2,-180,90,true);
        } else {
            innerPath.moveTo(bounds.left,bounds.top);
        }
		innerRadiusWidth = (topRightRadius-rightBorderWidth);
		innerRadiusHeight = (topRightRadius-topBorderWidth);
		        
        innerPath.lineTo(bounds.right-innerRadiusWidth,bounds.top);
        if ( innerRadiusHeight >0) {
            innerPath.arcTo(bounds.right-innerRadiusWidth*2,bounds.top,bounds.right,bounds.top+innerRadiusHeight*2,-90,90,false);
        }
        
		innerRadiusWidth = (bottomRightRadius-rightBorderWidth);
		innerRadiusHeight = (bottomRightRadius-bottomBorderWidth);
        
        innerPath.lineTo(bounds.right,bounds.bottom-innerRadiusHeight);
        if (innerRadiusWidth > 0 || innerRadiusHeight > 0) {
            innerPath.arcTo(bounds.right-innerRadiusWidth*2,bounds.bottom-innerRadiusHeight*2,bounds.right,bounds.bottom,0,90,false);
        }
        
		innerRadiusWidth = (bottomLeftRadius-leftBorderWidth);
		innerRadiusHeight = (bottomLeftRadius-bottomBorderWidth);        
        innerPath.lineTo(bounds.left+innerRadiusWidth,bounds.bottom);
        
        if (innerRadiusWidth > 0 || innerRadiusHeight > 0) {
            innerPath.arcTo(bounds.left,bounds.bottom-innerRadiusHeight*2,bounds.left+innerRadiusWidth*2,bounds.bottom,90,90,false);
        }
        
		innerRadiusHeight = (topLeftRadius-topBorderWidth);        
        innerPath.lineTo(bounds.left,bounds.top+innerRadiusHeight);
        return innerPath;   
	}
	

	
	def getOuterPath() {
        var outerPath = new Path();
        if (topLeftRadius > 0) {
            outerPath.arcTo(bounds.left,bounds.top,bounds.left+topLeftRadius*2,bounds.top+topLeftRadius*2,-180,90,true);
        } else {
            outerPath.moveTo(bounds.left,bounds.top);
        }
        outerPath.lineTo(bounds.right-topRightRadius,bounds.top);
        if (topRightRadius > 0) {
            outerPath.arcTo(bounds.right-topRightRadius*2,bounds.top,bounds.right,bounds.top+topRightRadius*2,-90,90,false);
        }
        outerPath.lineTo(bounds.right,bounds.bottom-bottomRightRadius);
        if (bottomRightRadius > 0) {
            outerPath.arcTo(bounds.right-bottomRightRadius*2,bounds.bottom-bottomRightRadius*2,bounds.right,bounds.bottom,0,90,false);
        }
        outerPath.lineTo(bounds.left+bottomLeftRadius,bounds.bottom);
        
        if (bottomLeftRadius > 0) {
            outerPath.arcTo(bounds.left,bounds.bottom-bottomLeftRadius*2,bounds.left+bottomLeftRadius*2,bounds.bottom,90,90,false);
        }
        outerPath.lineTo(bounds.left,bounds.top+topLeftRadius);
		return outerPath;	
	}
	
	override getOpacity() {
		return 0;
	}
	
	override setAlpha(int alpha) {
		
	}
	
	override setColorFilter(ColorFilter cf) {
		
	}
	
}