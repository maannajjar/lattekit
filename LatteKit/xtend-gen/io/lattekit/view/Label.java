package io.lattekit.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.google.common.base.Objects;
import io.lattekit.view.LatteView;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Label extends LatteView {
  public enum TextAlignment {
    START,
    
    CENTER,
    
    END;
  }
  
  public enum VerticalTextAlignment {
    TOP,
    
    MIDDLE,
    
    BOTTOM;
  }
  
  public enum TextTruncate {
    ELLIPSIZE_START,
    
    ELLIPSIZE_MIDDLE,
    
    ELLIPSIZE_END,
    
    CLIP_END;
  }
  
  private static float textScale = 0.85f;
  
  @Property
  private String _text = "";
  
  @Property
  private int _textColor = Color.BLACK;
  
  @Property
  private int _fontSize = 15;
  
  @Property
  private Typeface _typeface;
  
  @Property
  private Label.TextAlignment _textAlign = Label.TextAlignment.CENTER;
  
  @Property
  private Label.VerticalTextAlignment _verticalTextAlign = Label.VerticalTextAlignment.MIDDLE;
  
  @Property
  private Label.TextTruncate _truncate = Label.TextTruncate.CLIP_END;
  
  public Label(final int x, final int y, final int width, final int height) {
    super(x, y, width, height);
    Typeface _create = Typeface.create("sans-serif", Typeface.NORMAL);
    this.setTypeface(_create);
  }
  
  @Override
  public void drawView(final Canvas canvas) {
    super.drawView(canvas);
    Paint textPaint = new Paint();
    textPaint.setAntiAlias(true);
    int _textColor = this.getTextColor();
    textPaint.setColor(_textColor);
    Typeface _typeface = this.getTypeface();
    textPaint.setTypeface(_typeface);
    int _fontSize = this.getFontSize();
    float _scaledPixel = LatteView.scaledPixel(_fontSize);
    textPaint.setTextSize(_scaledPixel);
    TextPaint tp = new TextPaint(textPaint);
    String text = this.getText();
    Label.TextTruncate _truncate = this.getTruncate();
    boolean _equals = Objects.equal(_truncate, Label.TextTruncate.ELLIPSIZE_START);
    if (_equals) {
      String _text = this.getText();
      float _width = this.getWidth();
      float _scaledPixel_1 = LatteView.scaledPixel(_width);
      CharSequence _ellipsize = TextUtils.ellipsize(_text, tp, _scaledPixel_1, TextUtils.TruncateAt.START);
      String _string = _ellipsize.toString();
      text = _string;
    } else {
      Label.TextTruncate _truncate_1 = this.getTruncate();
      boolean _equals_1 = Objects.equal(_truncate_1, Label.TextTruncate.ELLIPSIZE_MIDDLE);
      if (_equals_1) {
        String _text_1 = this.getText();
        float _width_1 = this.getWidth();
        float _scaledPixel_2 = LatteView.scaledPixel(_width_1);
        CharSequence _ellipsize_1 = TextUtils.ellipsize(_text_1, tp, _scaledPixel_2, TextUtils.TruncateAt.MIDDLE);
        String _string_1 = _ellipsize_1.toString();
        text = _string_1;
      } else {
        Label.TextTruncate _truncate_2 = this.getTruncate();
        boolean _equals_2 = Objects.equal(_truncate_2, Label.TextTruncate.ELLIPSIZE_END);
        if (_equals_2) {
          String _text_2 = this.getText();
          float _width_2 = this.getWidth();
          float _scaledPixel_3 = LatteView.scaledPixel(_width_2);
          CharSequence _ellipsize_2 = TextUtils.ellipsize(_text_2, tp, _scaledPixel_3, TextUtils.TruncateAt.END);
          String _string_2 = _ellipsize_2.toString();
          text = _string_2;
        } else {
          float _width_3 = this.getWidth();
          float _height = this.getHeight();
          RectF _rectF = new RectF(0, 0, _width_3, _height);
          RectF _scaleRect = LatteView.scaleRect(_rectF);
          canvas.clipRect(_scaleRect);
        }
      }
    }
    float x = 0;
    int _fontSize_1 = this.getFontSize();
    float y = LatteView.scaledPixel(_fontSize_1);
    Label.TextAlignment _textAlign = this.getTextAlign();
    boolean _equals_3 = Objects.equal(_textAlign, Label.TextAlignment.START);
    if (_equals_3) {
    } else {
      Label.TextAlignment _textAlign_1 = this.getTextAlign();
      boolean _equals_4 = Objects.equal(_textAlign_1, Label.TextAlignment.CENTER);
      if (_equals_4) {
        int _length = text.length();
        float _measureText = textPaint.measureText(text, 0, _length);
        float realTW = (_measureText * Label.textScale);
        float textW = LatteView.abstractPixel(realTW);
        float _width_4 = this.getWidth();
        float _minus = (_width_4 - textW);
        float _divide = (_minus / 2);
        x = _divide;
      } else {
        int _length_1 = text.length();
        float _measureText_1 = textPaint.measureText(text, 0, _length_1);
        float realTW_1 = (_measureText_1 * Label.textScale);
        float textW_1 = LatteView.abstractPixel(realTW_1);
        float _width_5 = this.getWidth();
        float _minus_1 = (_width_5 - textW_1);
        float _minus_2 = (_minus_1 - 5);
        x = _minus_2;
      }
    }
    Label.VerticalTextAlignment _verticalTextAlign = this.getVerticalTextAlign();
    boolean _equals_5 = Objects.equal(_verticalTextAlign, Label.VerticalTextAlignment.MIDDLE);
    if (_equals_5) {
      float _height_1 = this.getHeight();
      float _scaledPixel_4 = LatteView.scaledPixel(_height_1);
      float _divide_1 = (_scaledPixel_4 / 2);
      float _descent = textPaint.descent();
      float _ascent = textPaint.ascent();
      float _plus = (_descent + _ascent);
      float _divide_2 = (_plus / 2);
      float _minus_3 = (_divide_1 - _divide_2);
      y = _minus_3;
    } else {
      Label.VerticalTextAlignment _verticalTextAlign_1 = this.getVerticalTextAlign();
      boolean _equals_6 = Objects.equal(_verticalTextAlign_1, Label.VerticalTextAlignment.BOTTOM);
      if (_equals_6) {
        float _height_2 = this.getHeight();
        float _scaledPixel_5 = LatteView.scaledPixel(_height_2);
        float _descent_1 = textPaint.descent();
        float _minus_4 = (_scaledPixel_5 - _descent_1);
        y = _minus_4;
      } else {
        Label.VerticalTextAlignment _verticalTextAlign_2 = this.getVerticalTextAlign();
        boolean _equals_7 = Objects.equal(_verticalTextAlign_2, Label.VerticalTextAlignment.TOP);
        if (_equals_7) {
          int _fontSize_2 = this.getFontSize();
          float _scaledPixel_6 = LatteView.scaledPixel(_fontSize_2);
          y = _scaledPixel_6;
        }
      }
    }
    float _scaledPixel_7 = LatteView.scaledPixel(x);
    canvas.drawText(text, _scaledPixel_7, y, textPaint);
  }
  
  @Pure
  public String getText() {
    return this._text;
  }
  
  public void setText(final String text) {
    this._text = text;
  }
  
  @Pure
  public int getTextColor() {
    return this._textColor;
  }
  
  public void setTextColor(final int textColor) {
    this._textColor = textColor;
  }
  
  @Pure
  public int getFontSize() {
    return this._fontSize;
  }
  
  public void setFontSize(final int fontSize) {
    this._fontSize = fontSize;
  }
  
  @Pure
  public Typeface getTypeface() {
    return this._typeface;
  }
  
  public void setTypeface(final Typeface typeface) {
    this._typeface = typeface;
  }
  
  @Pure
  public Label.TextAlignment getTextAlign() {
    return this._textAlign;
  }
  
  public void setTextAlign(final Label.TextAlignment textAlign) {
    this._textAlign = textAlign;
  }
  
  @Pure
  public Label.VerticalTextAlignment getVerticalTextAlign() {
    return this._verticalTextAlign;
  }
  
  public void setVerticalTextAlign(final Label.VerticalTextAlignment verticalTextAlign) {
    this._verticalTextAlign = verticalTextAlign;
  }
  
  @Pure
  public Label.TextTruncate getTruncate() {
    return this._truncate;
  }
  
  public void setTruncate(final Label.TextTruncate truncate) {
    this._truncate = truncate;
  }
}
