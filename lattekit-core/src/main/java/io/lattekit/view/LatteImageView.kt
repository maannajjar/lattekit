package io.lattekit.view

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Key

/**
 * Created by maan on 2/15/16.
 */
class LatteImageView : NativeView() {

    fun getSrc() : Any? {
        return if (props.containsKey("src")) props.get("src") else null;
    }

    fun getScaleType() : String? {
        return props.get("scaleType") as String?
    }
    fun loadWithGlide(view : android.widget.ImageView) {
        if (activity != null && !activity!!.isDestroyed) {
            var glideRequest = Glide.with(activity).load(props.get("src") as String);
            if (props.containsKey("glideSignature")) {
                glideRequest.signature(props["glideSignature"] as Key)
            }
            if (props.containsKey("placeholder")) {
                glideRequest.placeholder(props.get("placeholder") as Int)
            }
            if (props.get("crossFade") == "true" || props.get("crossFade") == true) {
                glideRequest.crossFade();
            }
            if (props.get("centerCrop") == "true" || props.get("centerCrop") == true) {
                glideRequest.centerCrop();
            }
            glideRequest.into(view);
        }

    }

    override fun applyProps(props : Map<String,Any?>) {
        super.applyProps(props)
        var view = androidView as android.widget.ImageView;
        if (getSrc() is String) {
            loadWithGlide(view);
        } else if (getSrc() is Int) {
            view.setImageResource(getSrc() as Int);
        } else if (getSrc() is Drawable) {
            view.setImageDrawable(getSrc() as Drawable)
        }

        if (getScaleType() != null) {
            view.scaleType = if (getScaleType() == "fitXY") {
                android.widget.ImageView.ScaleType.FIT_XY;
            } else {
                try {
                    android.widget.ImageView.ScaleType.valueOf(getScaleType()?.replace("([A-Z])".toRegex(),"_\$1" )?.toUpperCase()!!);
                } catch ( ex : Exception) {
                    null;
                }
            }
        }
    }

    override fun getViewClass() : Class<out View> {
        if (nativeViewClass == ImageView::class.java) {
            return ClippableImageView::class.java;
        }
        return super.getViewClass()
    }
}

class ClippableImageView(context : Context) : ImageView(context) {

    var clipPath : Path? = null;
    var pdMode : PorterDuffXfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    var paint =  Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG);
    var foregroundDrawable : Drawable? = null
        set(drawable : Drawable?) {
            if (foregroundDrawable != null) {
                foregroundDrawable!!.setCallback(null);
                unscheduleDrawable(foregroundDrawable);
            }

            field = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
            }
            requestLayout();
            invalidate();
        }

    override fun setImageDrawable(drawable: Drawable?) {
        clipPath = null;
        super.setImageDrawable(drawable)
    }

    override fun setImageResource(resId: Int) {
        clipPath = null;
        super.setImageResource(resId)
    }

    override fun setImageBitmap(bm: Bitmap?) {
        clipPath = null;
        super.setImageBitmap(bm)
    }

    override fun draw(canvas: Canvas) {
        if (clipPath == null) {
            super.draw(canvas);
        } else {
            var saveFlags = Canvas.MATRIX_SAVE_FLAG or Canvas.CLIP_SAVE_FLAG or Canvas.HAS_ALPHA_LAYER_SAVE_FLAG or Canvas.FULL_COLOR_LAYER_SAVE_FLAG or Canvas.CLIP_TO_LAYER_SAVE_FLAG;
            var saveCount = canvas.saveLayer(0f, 0f, getWidth().toFloat(), getHeight().toFloat(), null, saveFlags);
            super.draw(canvas);
            paint.setXfermode(pdMode);
            canvas.drawPath(clipPath, paint);
            canvas.restoreToCount(saveCount);
            paint.setXfermode(null);
        }
        if (foregroundDrawable != null) {
            foregroundDrawable!!.draw(canvas);
        }
    }


    override fun verifyDrawable(who: Drawable?): Boolean {
        return super.verifyDrawable(who) || who == foregroundDrawable
    }

    override fun jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();

        if (foregroundDrawable != null) foregroundDrawable!!.jumpToCurrentState();
    }

    override fun drawableStateChanged() {
        super.drawableStateChanged()
        if (foregroundDrawable != null && foregroundDrawable!!.isStateful()) {
            foregroundDrawable!!.setState(getDrawableState());
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (foregroundDrawable != null) {
            foregroundDrawable!!.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            invalidate();
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (foregroundDrawable != null) {
            foregroundDrawable!!.setBounds(0, 0, w, h);
            invalidate();
        }

    }
}