package io.lattekit.view

import io.lattekit.view.LatteView
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.Color
import android.text.TextUtils
import android.text.TextPaint
import android.text.TextUtils.TruncateAt
import android.graphics.RectF

class Label extends LatteView {
	
	private static float textScale = 0.85f;
	@Property String text = "";
	@Property int textColor = Color.BLACK;
	@Property int fontSize = 15;
	@Property Typeface typeface;
	@Property TextAlignment textAlign = TextAlignment.CENTER;
	@Property VerticalTextAlignment verticalTextAlign = VerticalTextAlignment.MIDDLE;
	
	@Property TextTruncate truncate = TextTruncate.CLIP_END;
	
	enum TextAlignment {
		START,
		CENTER,
		END
	}
	enum VerticalTextAlignment {
		TOP,
		MIDDLE,
		BOTTOM
	}
	
	
	enum TextTruncate {
		ELLIPSIZE_START,
		ELLIPSIZE_MIDDLE,
		ELLIPSIZE_END,
		CLIP_END
	}
	
	
	new(int x, int y, int width, int height) {
		super(x, y, width, height)
		typeface = Typeface.create("sans-serif",Typeface.NORMAL);
	}
	
	override drawView(Canvas canvas) {
		super.drawView(canvas);
		
		var Paint textPaint = new Paint();
		textPaint.antiAlias = true;
		textPaint.color = this.textColor;
		textPaint.typeface = this.typeface;
		textPaint.textSize = this.fontSize.scaledPixel;
		

		var TextPaint tp = new TextPaint(textPaint);
		var text = this.text; 
		if (this.truncate == TextTruncate.ELLIPSIZE_START) {
			text = TextUtils.ellipsize(this.text,tp, this.width.scaledPixel, TruncateAt.START).toString;
		} else if (this.truncate == TextTruncate.ELLIPSIZE_MIDDLE) {
			text = TextUtils.ellipsize(this.text,tp, this.width.scaledPixel, TruncateAt.MIDDLE).toString;
		} else if (this.truncate == TextTruncate.ELLIPSIZE_END) {
			text = TextUtils.ellipsize(this.text,tp, this.width.scaledPixel, TruncateAt.END).toString;
		} else {
			canvas.clipRect(new RectF(0,0,this.width, this.height).scaleRect);
		}
		
		var float x = 0;
		var float y = this.fontSize.scaledPixel;
		
		if (this.textAlign == TextAlignment.START) {
		} else if (this.textAlign == TextAlignment.CENTER) {
			var float realTW = textPaint.measureText(text, 0, text.length())*textScale;
			var float textW = realTW.abstractPixel;
			x = (this.width-textW)/2;
		} else {
			var float realTW = textPaint.measureText(text, 0, text.length())*textScale;
			var float textW = realTW.abstractPixel;
			x = (this.width-textW)-5;
		}
		
		// Align Middle
		if (this.verticalTextAlign == VerticalTextAlignment.MIDDLE) {
			y = (this.height.scaledPixel/2) - ((textPaint.descent() + textPaint.ascent()) / 2);	
		} else if (this.verticalTextAlign == VerticalTextAlignment.BOTTOM) {
			y = (this.height.scaledPixel) - textPaint.descent() ;
		} else if (this.verticalTextAlign == VerticalTextAlignment.TOP) {
			y = this.fontSize.scaledPixel;			
		}
		
		
		
		canvas.drawText(text, x.scaledPixel, y, textPaint);
		
	}
	
}