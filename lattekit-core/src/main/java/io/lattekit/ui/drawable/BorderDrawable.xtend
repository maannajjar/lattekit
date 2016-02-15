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

    @Accessors float topLeftRadiusV = 0;
    @Accessors float topRightRadiusV = 0;
    @Accessors float bottomLeftRadiusV = 0;
    @Accessors float bottomRightRadiusV = 0;

    @Accessors float topLeftRadiusH = 0;
    @Accessors float topRightRadiusH = 0;
    @Accessors float bottomLeftRadiusH = 0;
    @Accessors float bottomRightRadiusH = 0;

    private Paint paint;
    private Path path;

    new() {
        paint = new Paint();
        path = new Path();
    }


    def void arcTo(Path path, float left ,float top,float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo) {
        path.arcTo(new RectF(left,top,right,bottom), startAngle,sweepAngle,forceMoveTo);
    }

    def drawSegment(Canvas canvas,Path path, RectF bounds,float segementWidth, float firstCornerRadiusH,float firstCornerRadiusV,float firstAdjacentWidth, float secondCornerRadiusH, float secondCornerRadiusV,float secondAdjacentWidth) {
        path.reset()
        // Outer line
        if (firstCornerRadiusH > 0 || firstCornerRadiusV > 0) {
            arcTo(path,bounds.left,bounds.top,bounds.left+firstCornerRadiusH*2,bounds.top+firstCornerRadiusV*2,-135,45, true);
        } else {
            path.moveTo(bounds.left,bounds.top);
        }

        path.lineTo(bounds.right/2.0f,bounds.top);
        path.lineTo(bounds.right/2.0f,bounds.top+segementWidth);

        //Inner line
        // We're multiplying inner radius with 2 to keep the inner radius consistent with outer radius (similar to iOS)
        // If we want to mimic  CSS, we should multiply by 1 and adjust outer radius
        // But that means we should make the border drawn outside the view which means the border affects view size (not intuitive in android)
        var innerRadiusLeft = (firstCornerRadiusH-firstAdjacentWidth)*2;
        var innerRadiusTop = (firstCornerRadiusV-segementWidth)*2;

        if (innerRadiusLeft > 0 && innerRadiusTop > 0) {
            path.lineTo(bounds.left+firstAdjacentWidth+innerRadiusLeft,bounds.top+segementWidth);
            arcTo(path,bounds.left+firstAdjacentWidth,bounds.top+segementWidth,
                    bounds.left+firstAdjacentWidth+innerRadiusLeft,bounds.top+segementWidth+innerRadiusTop,-90,-45, false);
        } else {
            path.lineTo(bounds.left+firstAdjacentWidth,bounds.top+segementWidth);
        }
        path.close();
        canvas.drawPath(path,paint);
        path.reset()
        // Outer line
        if (secondCornerRadiusH > 0) {
            arcTo(path,bounds.right-secondCornerRadiusH*2,bounds.top,bounds.right,bounds.top+secondCornerRadiusV*2,-45,-45, true);
        } else {
            path.moveTo(bounds.right,bounds.top);
        }

        path.lineTo(bounds.right/2.0f,bounds.top);
        path.lineTo(bounds.right/2.0f,bounds.top+segementWidth);

        //Inner line
        var innerRadiusRight = (secondCornerRadiusH-secondAdjacentWidth)*2;
        var innerRadiusTop2 = (secondCornerRadiusV-segementWidth)*2;


        if (innerRadiusRight > 0 && innerRadiusTop2 > 0) {
            path.lineTo(bounds.right-secondAdjacentWidth-innerRadiusRight,bounds.top+segementWidth);
            arcTo(path,bounds.right-secondAdjacentWidth-innerRadiusRight,bounds.top+segementWidth,
                    bounds.right-secondAdjacentWidth,bounds.top+segementWidth+innerRadiusTop2,-90,45, false);
        } else {
            path.lineTo(bounds.right-secondAdjacentWidth,bounds.top+segementWidth);
        }
        path.close();
        canvas.drawPath(path,paint);


    }

    override draw(Canvas canvas) {
        paint.style = Paint.Style.FILL_AND_STROKE;
        paint.strokeWidth = 0.5f

        var topLeftRadiusV = Math.min(this.topLeftRadiusV, bounds.height/2.0f);
        var topRightRadiusV = Math.min(this.topRightRadiusV, bounds.height/2.0f);
        var bottomLeftRadiusV = Math.min(this.bottomLeftRadiusV, bounds.height/2.0f);
        var bottomRightRadiusV = Math.min(this.bottomRightRadiusV, bounds.height/2.0f);

        var topLeftRadiusH = Math.min(this.topLeftRadiusH, bounds.width/2.0f);
        var topRightRadiusH = Math.min(this.topRightRadiusH, bounds.width/2.0f);
        var bottomLeftRadiusH = Math.min(this.bottomLeftRadiusH, bounds.width/2.0f);
        var bottomRightRadiusH = Math.min(this.bottomRightRadiusH, bounds.width/2.0f);

        // Keep  radius symmetric if they were intended to be
        if (this.topLeftRadiusV == this.topLeftRadiusH && topLeftRadiusV != topLeftRadiusH) {
            topLeftRadiusV = topLeftRadiusH = Math.min(topLeftRadiusV,topLeftRadiusH);
        }
        if (this.topRightRadiusV == this.topRightRadiusH && topRightRadiusV != topRightRadiusH) {
            topRightRadiusV = topRightRadiusH = Math.min(topRightRadiusV,topRightRadiusH);
        }
        if (this.bottomLeftRadiusV == this.bottomLeftRadiusH && bottomLeftRadiusV != bottomLeftRadiusH) {
            bottomLeftRadiusV = bottomLeftRadiusH = Math.min(bottomLeftRadiusV,bottomLeftRadiusH);
        }
        if (this.bottomRightRadiusV == this.bottomRightRadiusH && bottomRightRadiusV != bottomRightRadiusH) {
            bottomRightRadiusV = bottomRightRadiusH = Math.min(bottomRightRadiusV,bottomRightRadiusH);
        }

        canvas.save()
        canvas.translate(-(bounds.width-bounds.height)/2.0f, (bounds.height-bounds.width)/2.0f);
        canvas.rotate(-90,bounds.centerX,bounds.centerY);
        if (leftBorderWidth > 0) {
            paint.color = leftBorderColor;
            var mb = new RectF(bounds);
            mb.right = mb.left + (bounds.height);
            drawSegment(canvas,path, mb, leftBorderWidth, bottomLeftRadiusV,bottomLeftRadiusH, bottomBorderWidth, topLeftRadiusV, topLeftRadiusH, topBorderWidth);
        }
        canvas.restore();

        canvas.save()
        if (topBorderWidth > 0) {
            paint.color = topBorderColor;
            drawSegment(canvas,path, new RectF(bounds), topBorderWidth, topLeftRadiusH, topLeftRadiusV, leftBorderWidth, topRightRadiusH, topRightRadiusV, rightBorderWidth);
        }
        canvas.restore();

        canvas.save()
        canvas.translate((bounds.width-bounds.height)/2.0f, -(bounds.height-bounds.width)/2.0f);
        canvas.rotate(90,bounds.centerX,bounds.centerY);
        if (rightBorderWidth > 0) {
            paint.color = rightBorderColor;

            var mb = new RectF(bounds);
            mb.right = mb.left + (bounds.height);

            drawSegment(canvas,path, mb, rightBorderWidth, topRightRadiusV, topRightRadiusH, topBorderWidth, bottomRightRadiusV, bottomRightRadiusH, bottomBorderWidth);
        }
        canvas.restore();

        canvas.save()
        canvas.rotate(90*2,bounds.centerX,bounds.centerY);
        if (bottomBorderWidth > 0) {
            paint.color = bottomBorderColor;
            drawSegment(canvas,path, new RectF(bounds), bottomBorderWidth, bottomRightRadiusH, bottomRightRadiusV, rightBorderWidth, bottomLeftRadiusH,bottomLeftRadiusV, leftBorderWidth);
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

        var innerRadiusWidth = (topLeftRadiusH-leftBorderWidth);
        var innerRadiusHeight = (topLeftRadiusV-topBorderWidth);

        if (innerRadiusHeight > 0 || innerRadiusWidth >0) {
            arcTo(innerPath,bounds.left,bounds.top,bounds.left+innerRadiusWidth*2,bounds.top+innerRadiusHeight*2,-180,90,true);
        } else {
            innerPath.moveTo(bounds.left,bounds.top);
        }
        innerRadiusWidth = (topRightRadiusH-rightBorderWidth);
        innerRadiusHeight = (topRightRadiusV-topBorderWidth);

        innerPath.lineTo(bounds.right-innerRadiusWidth,bounds.top);
        if ( innerRadiusHeight >0) {
            arcTo(innerPath,bounds.right-innerRadiusWidth*2,bounds.top,bounds.right,bounds.top+innerRadiusHeight*2,-90,90,false);
        }
        
        innerRadiusWidth = (bottomRightRadiusH-rightBorderWidth);
        innerRadiusHeight = (bottomRightRadiusV-bottomBorderWidth);
        
        innerPath.lineTo(bounds.right,bounds.bottom-innerRadiusHeight);
        if (innerRadiusWidth > 0 || innerRadiusHeight > 0) {
            arcTo(innerPath,bounds.right-innerRadiusWidth*2,bounds.bottom-innerRadiusHeight*2,bounds.right,bounds.bottom,0,90,false);
        }
        
        innerRadiusWidth = (bottomLeftRadiusH-leftBorderWidth);
        innerRadiusHeight = (bottomLeftRadiusV-bottomBorderWidth);
        innerPath.lineTo(bounds.left+innerRadiusWidth,bounds.bottom);
        
        if (innerRadiusWidth > 0 || innerRadiusHeight > 0) {
            arcTo(innerPath,bounds.left,bounds.bottom-innerRadiusHeight*2,bounds.left+innerRadiusWidth*2,bounds.bottom,90,90,false);
        }
        
        innerRadiusHeight = (topLeftRadiusH-topBorderWidth);
        innerPath.lineTo(bounds.left,bounds.top+innerRadiusHeight);
        return innerPath;   
    }



    def getOuterPath() {
        var outerPath = new Path();
        if (topLeftRadiusH > 0 || topLeftRadiusV > 0) {
            arcTo(outerPath,bounds.left,bounds.top,bounds.left+topLeftRadiusH*2,bounds.top+topLeftRadiusV*2,-180,90,true);
        } else {
            outerPath.moveTo(bounds.left,bounds.top);
        }
        outerPath.lineTo(bounds.right-topRightRadiusH,bounds.top);
        if (topRightRadiusH > 0 || topRightRadiusV > 0) {
            arcTo(outerPath,bounds.right-topRightRadiusH*2,bounds.top,bounds.right,bounds.top+topRightRadiusV*2,-90,90,false);
        }
        outerPath.lineTo(bounds.right,bounds.bottom-bottomRightRadiusV);
        if (bottomRightRadiusH > 0 || bottomRightRadiusV > 0) {
            arcTo(outerPath,bounds.right-bottomRightRadiusH*2,bounds.bottom-bottomRightRadiusV*2,bounds.right,bounds.bottom,0,90,false);
        }
        outerPath.lineTo(bounds.left+bottomLeftRadiusH,bounds.bottom);
        
        if (bottomLeftRadiusH > 0) {
            arcTo(outerPath,bounds.left,bounds.bottom-bottomLeftRadiusV*2,bounds.left+bottomLeftRadiusH*2,bounds.bottom,90,90,false);
        }
        outerPath.lineTo(bounds.left,bounds.top+topLeftRadiusV);
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