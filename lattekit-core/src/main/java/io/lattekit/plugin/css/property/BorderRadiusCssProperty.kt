package io.lattekit.plugin.css.property

import android.content.Context
import android.graphics.Path
import android.graphics.RectF
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Build
import android.util.Log
import android.widget.ImageView
import io.lattekit.drawable.BorderDrawable
import io.lattekit.plugin.css.CssAccessory
import io.lattekit.plugin.css.NodeStyle
import io.lattekit.plugin.css.declaration.BorderRadius
import io.lattekit.plugin.css.declaration.LengthValue
import io.lattekit.plugin.css.declaration.SingleCornerBorderRadius
import io.lattekit.view.ClippableImageView
import io.lattekit.view.NativeView

/**
 * Created by maan on 2/25/16.
 */
open class BorderRadiusCssProperty : CssProperty("border-radius") {
    var hBorderRadius =  mutableMapOf(
        "border-top-left-radius" to LengthValue("0px"),
        "border-top-right-radius" to LengthValue("0px"),
        "border-bottom-right-radius" to LengthValue("0px"),
        "border-bottom-left-radius" to LengthValue("0px")
    )
    var vBorderRadius =  mutableMapOf(
        "border-top-left-radius" to LengthValue("0px"),
        "border-top-right-radius" to LengthValue("0px"),
        "border-bottom-right-radius" to LengthValue("0px"),
        "border-bottom-left-radius" to LengthValue("0px")
    )
    var borderRadius = mapOf(
        "horizontal" to hBorderRadius,
        "vertical" to vBorderRadius
    )

    fun readShorthand(axis: String, values: List<LengthValue>) {
        if (values.size == 1) {
            borderRadius[axis]?.keys?.forEach{
                borderRadius[axis]?.put(it, values[0])

            }
        } else if (values.size == 2) {
            borderRadius[axis]?.put("border-top-left-radius", values[0])
            borderRadius[axis]?.put("border-bottom-right-radius", values[0])
            borderRadius[axis]?.put("border-top-right-radius", values[1])
            borderRadius[axis]?.put("border-bottom-left-radius", values[1])
        } else if (values.size == 3) {
            borderRadius[axis]?.put("border-top-left-radius", values[0])
            borderRadius[axis]?.put("border-bottom-right-radius", values[2])
            borderRadius[axis]?.put("border-top-right-radius", values[1])
            borderRadius[axis]?.put("border-bottom-left-radius", values[1])
        } else if (values.size == 4) {
            borderRadius[axis]?.put("border-top-left-radius", values[0])
            borderRadius[axis]?.put("border-top-right-radius", values[1])
            borderRadius[axis]?.put("border-bottom-right-radius", values[2])
            borderRadius[axis]?.put("border-bottom-left-radius", values[3])
        }
    }

    override fun computeValue(context: Context, view: NativeView, style: NodeStyle) {
        var declarations = style.getDeclarations("border-radius", "border-top-left-radius", "border-top-right-radius", "border-bottom-right-radius", "border-bottom-left-radius")
        declarations.forEach {
            if (it.propertyName == "border-radius") {
                var values = it.value as BorderRadius
                readShorthand("horizontal", values.hRadius);
                if (values.vRadius.isEmpty()) {
                    readShorthand("vertical", values.hRadius)
                } else {
                    readShorthand("vertical", values.vRadius);
                }
            } else if (it.value is SingleCornerBorderRadius) {
                if (it.value.hLength != null) {
                    borderRadius["horizontal"]?.put(it.propertyName, it.value.hLength!!)
                    if (it.value.vLength != null) {
                        borderRadius["vertical"]?.put(it.propertyName, it.value.vLength!!)
                    } else {
                        borderRadius["vertical"]?.put(it.propertyName, it.value.hLength!!)
                    }
                }
            }
        }
    }

    override fun apply(view: NativeView, style: NodeStyle) {
        var cssAccessory = CssAccessory.getCssAccessory(view)

        var borderDrawable = cssAccessory.borderDrawable
        var context = view.androidView?.context!!
        borderDrawable.topLeftRadiusH = borderRadius["horizontal"]!!["border-top-left-radius"]!!.inPixels(context);
        borderDrawable.topLeftRadiusV = borderRadius["vertical"]!!["border-top-left-radius"]!!.inPixels(context);

        borderDrawable.topRightRadiusH = borderRadius["horizontal"]!!["border-top-right-radius"]!!.inPixels(context);
        borderDrawable.topRightRadiusV = borderRadius["vertical"]!!["border-top-right-radius"]!!.inPixels(context);

        borderDrawable.bottomRightRadiusH = borderRadius["horizontal"]!!["border-bottom-right-radius"]!!.inPixels(context);
        borderDrawable.bottomRightRadiusV = borderRadius["vertical"]!!["border-bottom-right-radius"]!!.inPixels(context);

        borderDrawable.bottomLeftRadiusH = borderRadius["horizontal"]!!["border-bottom-left-radius"]!!.inPixels(context);
        borderDrawable.bottomLeftRadiusV = borderRadius["vertical"]!!["border-bottom-left-radius"]!!.inPixels(context);

        var cornerRadii = getCornerRadii(borderDrawable)
        cssAccessory.shapeDrawable.shape = RoundRectShape(cornerRadii, null, null);
        if (cornerRadii.reduce { fl, fr -> if (fl > fr) fl else fr } > 0) {
            cssAccessory.gradientDrawable.setCornerRadii(cornerRadii)
        }
        if (borderDrawable.isRoundRect) {
            cssAccessory.clipRadius = borderDrawable.bottomLeftRadiusH;
            if (view.isAttached) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.androidView?.invalidateOutline()
                }
            }
        } else {
            cssAccessory.clipRadius = 0f;
        }

        if (view.androidView is ClippableImageView) {
            if (view.isAttached) {
                var clipPath = getOuterPath(RectF(0f,0f,view.androidView!!.width.toFloat(),view.androidView!!.height.toFloat()),borderDrawable.topLeftRadiusH,borderDrawable.topLeftRadiusV,borderDrawable.topRightRadiusH,borderDrawable.topLeftRadiusV,
                    borderDrawable.bottomRightRadiusH, borderDrawable.bottomRightRadiusV, borderDrawable.bottomLeftRadiusH, borderDrawable.bottomLeftRadiusV
                )
                clipPath?.fillType = Path.FillType.INVERSE_WINDING
                (view.androidView as ClippableImageView).clipPath = clipPath
                (view.androidView as ClippableImageView).invalidate()
            }
        }



    }

    fun getCornerRadii(borderDrawable : BorderDrawable) : FloatArray {
        var topLeft = borderDrawable.topLeftRadiusH
        var topRight = borderDrawable.topRightRadiusH
        var bottomLeft = borderDrawable.bottomLeftRadiusH
        var bottomRight = borderDrawable.bottomRightRadiusH
        return floatArrayOf(topLeft,topLeft,topRight,topRight,bottomRight,bottomRight,bottomLeft,bottomLeft);
    }

    fun arcTo(path: Path, left: Float, top: Float, right: Float, bottom: Float, startAngle: Float, sweepAngle: Float, forceMoveTo: Boolean) {
        val rect = RectF(left, top, right, bottom)
        path.arcTo(rect, startAngle, sweepAngle, forceMoveTo)
    }

    fun getOuterPath(bounds : RectF, topLeftRadiusH : Float, topLeftRadiusV : Float, topRightRadiusH : Float, topRightRadiusV : Float, bottomRightRadiusH : Float, bottomRightRadiusV : Float, bottomLeftRadiusH : Float, bottomLeftRadiusV : Float): Path {
        val outerPath = Path()
        if (topLeftRadiusH > 0 || topLeftRadiusV > 0) {
            arcTo(outerPath, bounds.left.toFloat(), bounds.top.toFloat(), bounds.left + topLeftRadiusH * 2, bounds.top + topLeftRadiusV * 2, (-180).toFloat(), 90f, true)
        } else {
            outerPath.moveTo(bounds.left.toFloat(), bounds.top.toFloat())
        }
        outerPath.lineTo(bounds.right - topRightRadiusH, bounds.top.toFloat())
        if (topRightRadiusH > 0 || topRightRadiusV > 0) {
            arcTo(outerPath, bounds.right - topRightRadiusH * 2, bounds.top.toFloat(), bounds.right.toFloat(), bounds.top + topRightRadiusV * 2, (-90).toFloat(), 90f, false)
        }
        outerPath.lineTo(bounds.right.toFloat(), bounds.bottom - bottomRightRadiusV)
        if (bottomRightRadiusH > 0 || bottomRightRadiusV > 0) {
            arcTo(outerPath, bounds.right - bottomRightRadiusH * 2, bounds.bottom - bottomRightRadiusV * 2, bounds.right.toFloat(), bounds.bottom.toFloat(), 0f, 90f, false)
        }
        outerPath.lineTo(bounds.left + bottomLeftRadiusH, bounds.bottom.toFloat())
        if (bottomLeftRadiusH > 0) {
            arcTo(outerPath, bounds.left.toFloat(), bounds.bottom - bottomLeftRadiusV * 2, bounds.left + bottomLeftRadiusH * 2, bounds.bottom.toFloat(), 90f, 90f, false)
        }
        outerPath.lineTo(bounds.left.toFloat(), bounds.top + topLeftRadiusV)
        return outerPath
    }

}


