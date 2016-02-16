package io.lattekit.ui.drawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class BorderDrawable extends Drawable {
    @Accessors
    private int topBorderColor = Color.BLACK;

    @Accessors
    private int leftBorderColor = Color.BLACK;

    @Accessors
    private int rightBorderColor = Color.BLACK;

    @Accessors
    private int bottomBorderColor = Color.BLACK;

    @Accessors
    private float topBorderWidth = 10;

    @Accessors
    private float leftBorderWidth = 10;

    @Accessors
    private float rightBorderWidth = 10;

    @Accessors
    private float bottomBorderWidth = 10;

    @Accessors
    private float topLeftRadiusV = 0;

    @Accessors
    private float topRightRadiusV = 0;

    @Accessors
    private float bottomLeftRadiusV = 0;

    @Accessors
    private float bottomRightRadiusV = 0;

    @Accessors
    private float topLeftRadiusH = 0;

    @Accessors
    private float topRightRadiusH = 0;

    @Accessors
    private float bottomLeftRadiusH = 0;

    @Accessors
    private float bottomRightRadiusH = 0;

    private Paint paint;

    private Path path;

    public BorderDrawable() {
        Paint _paint = new Paint();
        this.paint = _paint;
        Path _path = new Path();
        this.path = _path;
    }

    public void arcTo(final Path path, final float left, final float top, final float right, final float bottom, final float startAngle, final float sweepAngle, final boolean forceMoveTo) {
        RectF _rectF = new RectF(left, top, right, bottom);
        path.arcTo(_rectF, startAngle, sweepAngle, forceMoveTo);
    }

    public void drawSegment(final Canvas canvas, final Path path, final RectF bounds, final float segementWidth, final float firstCornerRadiusH, final float firstCornerRadiusV, final float firstAdjacentWidth, final float secondCornerRadiusH, final float secondCornerRadiusV, final float secondAdjacentWidth) {
        path.reset();
        if (((firstCornerRadiusH > 0) || (firstCornerRadiusV > 0))) {
            this.arcTo(path, bounds.left, bounds.top, (bounds.left + (firstCornerRadiusH * 2)), (bounds.top + (firstCornerRadiusV * 2)), (-135), 45, true);
        } else {
            path.moveTo(bounds.left, bounds.top);
        }
        path.lineTo((bounds.right / 2.0f), bounds.top);
        path.lineTo((bounds.right / 2.0f), (bounds.top + segementWidth));
        float innerRadiusLeft = ((firstCornerRadiusH - firstAdjacentWidth) * 2);
        float innerRadiusTop = ((firstCornerRadiusV - segementWidth) * 2);
        if (((innerRadiusLeft > 0) && (innerRadiusTop > 0))) {
            path.lineTo(((bounds.left + firstAdjacentWidth) + innerRadiusLeft), (bounds.top + segementWidth));
            this.arcTo(path, (bounds.left + firstAdjacentWidth), (bounds.top + segementWidth),
                    ((bounds.left + firstAdjacentWidth) + innerRadiusLeft), ((bounds.top + segementWidth) + innerRadiusTop), (-90), (-45), false);
        } else {
            path.lineTo((bounds.left + firstAdjacentWidth), (bounds.top + segementWidth));
        }
        path.close();
        canvas.drawPath(path, this.paint);
        path.reset();
        if ((secondCornerRadiusH > 0)) {
            this.arcTo(path, (bounds.right - (secondCornerRadiusH * 2)), bounds.top, bounds.right, (bounds.top + (secondCornerRadiusV * 2)), (-45), (-45), true);
        } else {
            path.moveTo(bounds.right, bounds.top);
        }
        path.lineTo((bounds.right / 2.0f), bounds.top);
        path.lineTo((bounds.right / 2.0f), (bounds.top + segementWidth));
        float innerRadiusRight = ((secondCornerRadiusH - secondAdjacentWidth) * 2);
        float innerRadiusTop2 = ((secondCornerRadiusV - segementWidth) * 2);
        if (((innerRadiusRight > 0) && (innerRadiusTop2 > 0))) {
            path.lineTo(((bounds.right - secondAdjacentWidth) - innerRadiusRight), (bounds.top + segementWidth));
            this.arcTo(path, ((bounds.right - secondAdjacentWidth) - innerRadiusRight), (bounds.top + segementWidth),
                    (bounds.right - secondAdjacentWidth), ((bounds.top + segementWidth) + innerRadiusTop2), (-90), 45, false);
        } else {
            path.lineTo((bounds.right - secondAdjacentWidth), (bounds.top + segementWidth));
        }
        path.close();
        canvas.drawPath(path, this.paint);
    }

    @Override
    public void draw(final Canvas canvas) {
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.paint.setStrokeWidth(0.5f);
        Rect _bounds = this.getBounds();
        int _height = _bounds.height();
        float _divide = (_height / 2.0f);
        float topLeftRadiusV = Math.min(this.topLeftRadiusV, _divide);
        Rect _bounds_1 = this.getBounds();
        int _height_1 = _bounds_1.height();
        float _divide_1 = (_height_1 / 2.0f);
        float topRightRadiusV = Math.min(this.topRightRadiusV, _divide_1);
        Rect _bounds_2 = this.getBounds();
        int _height_2 = _bounds_2.height();
        float _divide_2 = (_height_2 / 2.0f);
        float bottomLeftRadiusV = Math.min(this.bottomLeftRadiusV, _divide_2);
        Rect _bounds_3 = this.getBounds();
        int _height_3 = _bounds_3.height();
        float _divide_3 = (_height_3 / 2.0f);
        float bottomRightRadiusV = Math.min(this.bottomRightRadiusV, _divide_3);
        Rect _bounds_4 = this.getBounds();
        int _width = _bounds_4.width();
        float _divide_4 = (_width / 2.0f);
        float topLeftRadiusH = Math.min(this.topLeftRadiusH, _divide_4);
        Rect _bounds_5 = this.getBounds();
        int _width_1 = _bounds_5.width();
        float _divide_5 = (_width_1 / 2.0f);
        float topRightRadiusH = Math.min(this.topRightRadiusH, _divide_5);
        Rect _bounds_6 = this.getBounds();
        int _width_2 = _bounds_6.width();
        float _divide_6 = (_width_2 / 2.0f);
        float bottomLeftRadiusH = Math.min(this.bottomLeftRadiusH, _divide_6);
        Rect _bounds_7 = this.getBounds();
        int _width_3 = _bounds_7.width();
        float _divide_7 = (_width_3 / 2.0f);
        float bottomRightRadiusH = Math.min(this.bottomRightRadiusH, _divide_7);
        if (((this.topLeftRadiusV == this.topLeftRadiusH) && (topLeftRadiusV != topLeftRadiusH))) {
            topLeftRadiusV = (topLeftRadiusH = Math.min(topLeftRadiusV, topLeftRadiusH));
        }
        if (((this.topRightRadiusV == this.topRightRadiusH) && (topRightRadiusV != topRightRadiusH))) {
            topRightRadiusV = (topRightRadiusH = Math.min(topRightRadiusV, topRightRadiusH));
        }
        if (((this.bottomLeftRadiusV == this.bottomLeftRadiusH) && (bottomLeftRadiusV != bottomLeftRadiusH))) {
            bottomLeftRadiusV = (bottomLeftRadiusH = Math.min(bottomLeftRadiusV, bottomLeftRadiusH));
        }
        if (((this.bottomRightRadiusV == this.bottomRightRadiusH) && (bottomRightRadiusV != bottomRightRadiusH))) {
            bottomRightRadiusV = (bottomRightRadiusH = Math.min(bottomRightRadiusV, bottomRightRadiusH));
        }
        canvas.save();
        Rect _bounds_8 = this.getBounds();
        int _width_4 = _bounds_8.width();
        Rect _bounds_9 = this.getBounds();
        int _height_4 = _bounds_9.height();
        int _minus = (_width_4 - _height_4);
        int _minus_1 = (-_minus);
        float _divide_8 = (_minus_1 / 2.0f);
        Rect _bounds_10 = this.getBounds();
        int _height_5 = _bounds_10.height();
        Rect _bounds_11 = this.getBounds();
        int _width_5 = _bounds_11.width();
        int _minus_2 = (_height_5 - _width_5);
        float _divide_9 = (_minus_2 / 2.0f);
        canvas.translate(_divide_8, _divide_9);
        Rect _bounds_12 = this.getBounds();
        int _centerX = _bounds_12.centerX();
        Rect _bounds_13 = this.getBounds();
        int _centerY = _bounds_13.centerY();
        canvas.rotate((-90), _centerX, _centerY);
        if ((this.leftBorderWidth > 0)) {
            this.paint.setColor(this.leftBorderColor);
            Rect _bounds_14 = this.getBounds();
            RectF mb = new RectF(_bounds_14);
            Rect _bounds_15 = this.getBounds();
            int _height_6 = _bounds_15.height();
            float _plus = (mb.left + _height_6);
            mb.right = _plus;
            this.drawSegment(canvas, this.path, mb, this.leftBorderWidth, bottomLeftRadiusV, bottomLeftRadiusH, this.bottomBorderWidth, topLeftRadiusV, topLeftRadiusH, this.topBorderWidth);
        }
        canvas.restore();
        canvas.save();
        if ((this.topBorderWidth > 0)) {
            this.paint.setColor(this.topBorderColor);
            Rect _bounds_16 = this.getBounds();
            RectF _rectF = new RectF(_bounds_16);
            this.drawSegment(canvas, this.path, _rectF, this.topBorderWidth, topLeftRadiusH, topLeftRadiusV, this.leftBorderWidth, topRightRadiusH, topRightRadiusV, this.rightBorderWidth);
        }
        canvas.restore();
        canvas.save();
        Rect _bounds_17 = this.getBounds();
        int _width_6 = _bounds_17.width();
        Rect _bounds_18 = this.getBounds();
        int _height_7 = _bounds_18.height();
        int _minus_3 = (_width_6 - _height_7);
        float _divide_10 = (_minus_3 / 2.0f);
        Rect _bounds_19 = this.getBounds();
        int _height_8 = _bounds_19.height();
        Rect _bounds_20 = this.getBounds();
        int _width_7 = _bounds_20.width();
        int _minus_4 = (_height_8 - _width_7);
        int _minus_5 = (-_minus_4);
        float _divide_11 = (_minus_5 / 2.0f);
        canvas.translate(_divide_10, _divide_11);
        Rect _bounds_21 = this.getBounds();
        int _centerX_1 = _bounds_21.centerX();
        Rect _bounds_22 = this.getBounds();
        int _centerY_1 = _bounds_22.centerY();
        canvas.rotate(90, _centerX_1, _centerY_1);
        if ((this.rightBorderWidth > 0)) {
            this.paint.setColor(this.rightBorderColor);
            Rect _bounds_23 = this.getBounds();
            RectF mb_1 = new RectF(_bounds_23);
            Rect _bounds_24 = this.getBounds();
            int _height_9 = _bounds_24.height();
            float _plus_1 = (mb_1.left + _height_9);
            mb_1.right = _plus_1;
            this.drawSegment(canvas, this.path, mb_1, this.rightBorderWidth, topRightRadiusV, topRightRadiusH, this.topBorderWidth, bottomRightRadiusV, bottomRightRadiusH, this.bottomBorderWidth);
        }
        canvas.restore();
        canvas.save();
        Rect _bounds_25 = this.getBounds();
        int _centerX_2 = _bounds_25.centerX();
        Rect _bounds_26 = this.getBounds();
        int _centerY_2 = _bounds_26.centerY();
        canvas.rotate((90 * 2), _centerX_2, _centerY_2);
        if ((this.bottomBorderWidth > 0)) {
            this.paint.setColor(this.bottomBorderColor);
            Rect _bounds_27 = this.getBounds();
            RectF _rectF_1 = new RectF(_bounds_27);
            this.drawSegment(canvas, this.path, _rectF_1, this.bottomBorderWidth, bottomRightRadiusH, bottomRightRadiusV, this.rightBorderWidth, bottomLeftRadiusH, bottomLeftRadiusV, this.leftBorderWidth);
        }
        canvas.restore();
    }

    public void drawByOutlines(final Canvas canvas) {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth(2f);
        this.paint.setColor(Color.RED);
        Path path = this.getOuterPath();
        Path _innerPath = this.getInnerPath();
        path.op(_innerPath, Path.Op.DIFFERENCE);
        canvas.drawPath(path, this.paint);
    }

    public Path getInnerPath() {
        Rect _copyBounds = this.copyBounds();
        RectF bounds = new RectF(_copyBounds);
        float _left = bounds.left;
        bounds.left = (_left + this.leftBorderWidth);
        float _p = bounds.top;
        bounds.top = (_p + this.topBorderWidth);
        float _right = bounds.right;
        bounds.right = (_right - this.rightBorderWidth);
        float _bottom = bounds.bottom;
        bounds.bottom = (_bottom - this.bottomBorderWidth);
        Path innerPath = new Path();
        float innerRadiusWidth = (this.topLeftRadiusH - this.leftBorderWidth);
        float innerRadiusHeight = (this.topLeftRadiusV - this.topBorderWidth);
        if (((innerRadiusHeight > 0) || (innerRadiusWidth > 0))) {
            this.arcTo(innerPath, bounds.left, bounds.top, (bounds.left + (innerRadiusWidth * 2)), (bounds.top + (innerRadiusHeight * 2)), (-180), 90, true);
        } else {
            innerPath.moveTo(bounds.left, bounds.top);
        }
        innerRadiusWidth = (this.topRightRadiusH - this.rightBorderWidth);
        innerRadiusHeight = (this.topRightRadiusV - this.topBorderWidth);
        innerPath.lineTo((bounds.right - innerRadiusWidth), bounds.top);
        if ((innerRadiusHeight > 0)) {
            this.arcTo(innerPath, (bounds.right - (innerRadiusWidth * 2)), bounds.top, bounds.right, (bounds.top + (innerRadiusHeight * 2)), (-90), 90, false);
        }
        innerRadiusWidth = (this.bottomRightRadiusH - this.rightBorderWidth);
        innerRadiusHeight = (this.bottomRightRadiusV - this.bottomBorderWidth);
        innerPath.lineTo(bounds.right, (bounds.bottom - innerRadiusHeight));
        if (((innerRadiusWidth > 0) || (innerRadiusHeight > 0))) {
            this.arcTo(innerPath, (bounds.right - (innerRadiusWidth * 2)), (bounds.bottom - (innerRadiusHeight * 2)), bounds.right, bounds.bottom, 0, 90, false);
        }
        innerRadiusWidth = (this.bottomLeftRadiusH - this.leftBorderWidth);
        innerRadiusHeight = (this.bottomLeftRadiusV - this.bottomBorderWidth);
        innerPath.lineTo((bounds.left + innerRadiusWidth), bounds.bottom);
        if (((innerRadiusWidth > 0) || (innerRadiusHeight > 0))) {
            this.arcTo(innerPath, bounds.left, (bounds.bottom - (innerRadiusHeight * 2)), (bounds.left + (innerRadiusWidth * 2)), bounds.bottom, 90, 90, false);
        }
        innerRadiusHeight = (this.topLeftRadiusH - this.topBorderWidth);
        innerPath.lineTo(bounds.left, (bounds.top + innerRadiusHeight));
        return innerPath;
    }

    public Path getOuterPath() {
        Path outerPath = new Path();
        if (((this.topLeftRadiusH > 0) || (this.topLeftRadiusV > 0))) {
            Rect _bounds = this.getBounds();
            Rect _bounds_1 = this.getBounds();
            this.arcTo(outerPath, _bounds.left, _bounds_1.top, (this.getBounds().left + (this.topLeftRadiusH * 2)), (this.getBounds().top + (this.topLeftRadiusV * 2)), (-180), 90, true);
        } else {
            Rect _bounds_2 = this.getBounds();
            Rect _bounds_3 = this.getBounds();
            outerPath.moveTo(_bounds_2.left, _bounds_3.top);
        }
        Rect _bounds_4 = this.getBounds();
        outerPath.lineTo((this.getBounds().right - this.topRightRadiusH), _bounds_4.top);
        if (((this.topRightRadiusH > 0) || (this.topRightRadiusV > 0))) {
            Rect _bounds_5 = this.getBounds();
            Rect _bounds_6 = this.getBounds();
            this.arcTo(outerPath, (this.getBounds().right - (this.topRightRadiusH * 2)), _bounds_5.top, _bounds_6.right, (this.getBounds().top + (this.topRightRadiusV * 2)), (-90), 90, false);
        }
        Rect _bounds_7 = this.getBounds();
        outerPath.lineTo(_bounds_7.right, (this.getBounds().bottom - this.bottomRightRadiusV));
        if (((this.bottomRightRadiusH > 0) || (this.bottomRightRadiusV > 0))) {
            Rect _bounds_8 = this.getBounds();
            Rect _bounds_9 = this.getBounds();
            this.arcTo(outerPath, (this.getBounds().right - (this.bottomRightRadiusH * 2)), (this.getBounds().bottom - (this.bottomRightRadiusV * 2)), _bounds_8.right, _bounds_9.bottom, 0, 90, false);
        }
        Rect _bounds_10 = this.getBounds();
        outerPath.lineTo((this.getBounds().left + this.bottomLeftRadiusH), _bounds_10.bottom);
        if ((this.bottomLeftRadiusH > 0)) {
            Rect _bounds_11 = this.getBounds();
            Rect _bounds_12 = this.getBounds();
            this.arcTo(outerPath, _bounds_11.left, (this.getBounds().bottom - (this.bottomLeftRadiusV * 2)), (this.getBounds().left + (this.bottomLeftRadiusH * 2)), _bounds_12.bottom, 90, 90, false);
        }
        Rect _bounds_13 = this.getBounds();
        outerPath.lineTo(_bounds_13.left, (this.getBounds().top + this.topLeftRadiusV));
        return outerPath;
    }

    @Override
    public int getOpacity() {
        return 0;
    }

    @Override
    public void setAlpha(final int alpha) {
    }

    @Override
    public void setColorFilter(final ColorFilter cf) {
    }

    @Pure
    public int getTopBorderColor() {
        return this.topBorderColor;
    }

    public void setTopBorderColor(final int topBorderColor) {
        this.topBorderColor = topBorderColor;
    }

    @Pure
    public int getLeftBorderColor() {
        return this.leftBorderColor;
    }

    public void setLeftBorderColor(final int leftBorderColor) {
        this.leftBorderColor = leftBorderColor;
    }

    @Pure
    public int getRightBorderColor() {
        return this.rightBorderColor;
    }

    public void setRightBorderColor(final int rightBorderColor) {
        this.rightBorderColor = rightBorderColor;
    }

    @Pure
    public int getBottomBorderColor() {
        return this.bottomBorderColor;
    }

    public void setBottomBorderColor(final int bottomBorderColor) {
        this.bottomBorderColor = bottomBorderColor;
    }

    @Pure
    public float getTopBorderWidth() {
        return this.topBorderWidth;
    }

    public void setTopBorderWidth(final float topBorderWidth) {
        this.topBorderWidth = topBorderWidth;
    }

    @Pure
    public float getLeftBorderWidth() {
        return this.leftBorderWidth;
    }

    public void setLeftBorderWidth(final float leftBorderWidth) {
        this.leftBorderWidth = leftBorderWidth;
    }

    @Pure
    public float getRightBorderWidth() {
        return this.rightBorderWidth;
    }

    public void setRightBorderWidth(final float rightBorderWidth) {
        this.rightBorderWidth = rightBorderWidth;
    }

    @Pure
    public float getBottomBorderWidth() {
        return this.bottomBorderWidth;
    }

    public void setBottomBorderWidth(final float bottomBorderWidth) {
        this.bottomBorderWidth = bottomBorderWidth;
    }

    @Pure
    public float getTopLeftRadiusV() {
        return this.topLeftRadiusV;
    }

    public void setTopLeftRadiusV(final float topLeftRadiusV) {
        this.topLeftRadiusV = topLeftRadiusV;
    }

    @Pure
    public float getTopRightRadiusV() {
        return this.topRightRadiusV;
    }

    public void setTopRightRadiusV(final float topRightRadiusV) {
        this.topRightRadiusV = topRightRadiusV;
    }

    @Pure
    public float getBottomLeftRadiusV() {
        return this.bottomLeftRadiusV;
    }

    public void setBottomLeftRadiusV(final float bottomLeftRadiusV) {
        this.bottomLeftRadiusV = bottomLeftRadiusV;
    }

    @Pure
    public float getBottomRightRadiusV() {
        return this.bottomRightRadiusV;
    }

    public void setBottomRightRadiusV(final float bottomRightRadiusV) {
        this.bottomRightRadiusV = bottomRightRadiusV;
    }

    @Pure
    public float getTopLeftRadiusH() {
        return this.topLeftRadiusH;
    }

    public void setTopLeftRadiusH(final float topLeftRadiusH) {
        this.topLeftRadiusH = topLeftRadiusH;
    }

    @Pure
    public float getTopRightRadiusH() {
        return this.topRightRadiusH;
    }

    public void setTopRightRadiusH(final float topRightRadiusH) {
        this.topRightRadiusH = topRightRadiusH;
    }

    @Pure
    public float getBottomLeftRadiusH() {
        return this.bottomLeftRadiusH;
    }

    public void setBottomLeftRadiusH(final float bottomLeftRadiusH) {
        this.bottomLeftRadiusH = bottomLeftRadiusH;
    }

    @Pure
    public float getBottomRightRadiusH() {
        return this.bottomRightRadiusH;
    }

    public void setBottomRightRadiusH(final float bottomRightRadiusH) {
        this.bottomRightRadiusH = bottomRightRadiusH;
    }
}
