package io.lattekit.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import com.google.common.base.Objects;
import io.lattekit.device.Window;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class LatteView {
  private final static int SIMULATED_WIDTH = 320;
  
  private static float xScale = (-1);
  
  private static float REAL_WIDTH;
  
  private static float REAL_HEIGHT;
  
  public Window window;
  
  public static final float initDeviceConfig(final int width, final int height) {
    float _xblockexpression = (float) 0;
    {
      LatteView.REAL_WIDTH = width;
      _xblockexpression = LatteView.REAL_HEIGHT = height;
    }
    return _xblockexpression;
  }
  
  public static void updateRatios() {
    LatteView.xScale = (LatteView.REAL_WIDTH / LatteView.SIMULATED_WIDTH);
  }
  
  public static float scaledPixel(final float x) {
    if ((LatteView.xScale == (-1))) {
      LatteView.updateRatios();
    }
    return (x * LatteView.xScale);
  }
  
  public static float abstractPixel(final float x) {
    if ((LatteView.xScale == (-1))) {
      LatteView.updateRatios();
    }
    return (x / LatteView.xScale);
  }
  
  public static RectF scaleRect(final RectF rectf) {
    if ((LatteView.xScale == (-1))) {
      LatteView.updateRatios();
    }
    RectF rect = new RectF();
    float _scaledPixel = LatteView.scaledPixel(rectf.left);
    rect.left = _scaledPixel;
    float _scaledPixel_1 = LatteView.scaledPixel(rectf.top);
    rect.top = _scaledPixel_1;
    float _scaledPixel_2 = LatteView.scaledPixel(rectf.right);
    rect.right = _scaledPixel_2;
    float _scaledPixel_3 = LatteView.scaledPixel(rectf.bottom);
    rect.bottom = _scaledPixel_3;
    return rect;
  }
  
  @Accessors
  private float shadowRadius;
  
  @Accessors
  private float shadowDx;
  
  @Accessors
  private float shadowDy;
  
  @Accessors
  private int shadowColor;
  
  @Accessors
  private float centerX;
  
  @Accessors
  private float centerY;
  
  @Accessors
  private float x;
  
  @Accessors
  private float y;
  
  @Accessors
  private float width;
  
  @Accessors
  private float height;
  
  @Accessors
  private float borderSize;
  
  @Accessors
  private float radius;
  
  @Accessors
  private int currentState;
  
  @Accessors
  private float rotate;
  
  @Accessors
  private RectF bounds;
  
  @Accessors
  private boolean clipToBounds = false;
  
  @Accessors
  private LatteView parent;
  
  @Accessors
  private boolean enabled = true;
  
  @Accessors
  private Function0<? extends Boolean> onTap = new Function0<Boolean>() {
    @Override
    public Boolean apply() {
      return Boolean.valueOf(true);
    }
  };
  
  @Accessors
  private Function2<? super Integer, ? super Integer, ? extends Boolean> onTouchDown = new Function2<Integer, Integer, Boolean>() {
    @Override
    public Boolean apply(final Integer x, final Integer y) {
      return Boolean.valueOf(true);
    }
  };
  
  @Accessors
  private Function2<? super Integer, ? super Integer, ? extends Boolean> onTouchUp = new Function2<Integer, Integer, Boolean>() {
    @Override
    public Boolean apply(final Integer x, final Integer y) {
      return Boolean.valueOf(true);
    }
  };
  
  @Accessors
  private Function2<? super Integer, ? super Integer, ? extends Boolean> onTouchMove = new Function2<Integer, Integer, Boolean>() {
    @Override
    public Boolean apply(final Integer x, final Integer y) {
      return Boolean.valueOf(true);
    }
  };
  
  @Accessors
  private Function2<? super Integer, ? super Integer, ? extends Boolean> onDrag = new Function2<Integer, Integer, Boolean>() {
    @Override
    public Boolean apply(final Integer x, final Integer y) {
      return Boolean.valueOf(true);
    }
  };
  
  @Accessors
  private Procedure1<? super Canvas> onDraw = new Procedure1<Canvas>() {
    @Override
    public void apply(final Canvas canvas) {
      LatteView.this.drawView(canvas);
    }
  };
  
  private final Integer[] backgroundColor = { Integer.valueOf(Color.WHITE), null, null, null };
  
  private final Integer[] borderColor = { Integer.valueOf(Color.BLACK), null, null, null };
  
  private final List<LatteView> subViews = new ArrayList<LatteView>();
  
  public final static int ViewStateNormal = 0;
  
  public final static int ViewStateHighlighted = 1;
  
  public final static int ViewStateDisabled = 2;
  
  public final static int ViewStateSelected = 3;
  
  public final static int TouchTypeDown = 0;
  
  public final static int TouchTypeMove = 1;
  
  public final static int TouchTypeUp = 2;
  
  private boolean isTouchInside;
  
  public LatteView(final int x, final int y, final int width, final int height) {
    this.setFrame(x, y, width, height);
  }
  
  public void attachToWindow(final Window window) {
    this.window = window;
    for (final LatteView v : this.subViews) {
      v.attachToWindow(window);
    }
  }
  
  public Integer setBackgroundColor(final int color, final int state) {
    return this.backgroundColor[state] = Integer.valueOf(color);
  }
  
  public Integer setBorderColor(final int color, final int state) {
    return this.borderColor[state] = Integer.valueOf(color);
  }
  
  public Integer getBackgroundColor() {
    Integer color = this.backgroundColor[this.currentState];
    boolean _equals = Objects.equal(color, null);
    if (_equals) {
      Integer _get = this.backgroundColor[LatteView.ViewStateNormal];
      color = _get;
    }
    return color;
  }
  
  public Integer getBorderColor() {
    Integer color = this.borderColor[this.currentState];
    boolean _equals = Objects.equal(color, null);
    if (_equals) {
      Integer _get = this.borderColor[LatteView.ViewStateNormal];
      color = _get;
    }
    return color;
  }
  
  public boolean addSubview(final LatteView child) {
    boolean _xblockexpression = false;
    {
      child.parent = this;
      child.window = this.window;
      _xblockexpression = this.subViews.add(child);
    }
    return _xblockexpression;
  }
  
  public final RectF setFrame(final float x, final float y, final float width, final float height) {
    RectF _xblockexpression = null;
    {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.centerX = (this.x + (this.width / 2));
      this.centerY = (this.y + (this.height / 2));
      RectF _rectF = new RectF(x, y, (x + width), (y + height));
      _xblockexpression = this.bounds = _rectF;
    }
    return _xblockexpression;
  }
  
  public final RectF setCenter(final float x, final float y) {
    RectF _xblockexpression = null;
    {
      this.centerX = x;
      this.centerY = y;
      this.x = (this.centerX - (this.width / 2));
      this.y = (this.centerY - (this.height / 2));
      RectF _rectF = new RectF(this.x, this.y, (this.x + this.width), (this.y + this.height));
      _xblockexpression = this.bounds = _rectF;
    }
    return _xblockexpression;
  }
  
  public void drawView(final Canvas canvas) {
  }
  
  public final boolean _touchTest(final float x, final float y, final int touchType) {
    if ((!this.enabled)) {
      return false;
    }
    for (final LatteView view : this.subViews) {
      boolean __touchTest = view._touchTest(x, y, touchType);
      if (__touchTest) {
        return true;
      }
    }
    RectF _scaleRect = LatteView.scaleRect(this.bounds);
    boolean _contains = _scaleRect.contains(x, y);
    if (_contains) {
      if ((touchType == LatteView.TouchTypeDown)) {
        this.handleTouchDown(x, y);
        this.isTouchInside = true;
      } else {
        if ((touchType == LatteView.TouchTypeMove)) {
          this.handleTouchMove(x, y);
          this.isTouchInside = true;
        } else {
          if ((touchType == LatteView.TouchTypeUp)) {
            this.handleTouchUp(x, y);
          }
        }
      }
      return true;
    } else {
      boolean _and = false;
      if (!this.isTouchInside) {
        _and = false;
      } else {
        _and = (touchType == LatteView.TouchTypeMove);
      }
      if (_and) {
        this.isTouchInside = false;
        this.handleTouchExit(x, y);
      }
    }
    return false;
  }
  
  public void invalidate() {
    this.window.invalidate();
  }
  
  public void handleTouchDown(final float x, final float y) {
    this.currentState = LatteView.ViewStateHighlighted;
    this.invalidate();
  }
  
  public Object handleTouchMove(final float x, final float y) {
    return null;
  }
  
  public void handleTouchExit(final float x, final float y) {
    if ((this.currentState == LatteView.ViewStateHighlighted)) {
      this.currentState = LatteView.ViewStateNormal;
      this.invalidate();
    }
  }
  
  public void handleTouchUp(final float x, final float y) {
    if ((this.currentState == LatteView.ViewStateHighlighted)) {
      this.currentState = LatteView.ViewStateNormal;
      if (this.enabled) {
        this.onTap.apply();
      }
      this.invalidate();
    }
  }
  
  public boolean hasShadow() {
    return ((this.shadowRadius > 0) && (!this.clipToBounds));
  }
  
  public final void _renderView(final Canvas canvas) {
    canvas.save();
    Paint p = new Paint();
    RectF frame = null;
    float _scaledPixel = LatteView.scaledPixel(this.x);
    float _scaledPixel_1 = LatteView.scaledPixel(this.y);
    canvas.translate(_scaledPixel, _scaledPixel_1);
    if ((this.rotate > 0)) {
      float _scaledPixel_2 = LatteView.scaledPixel(this.rotate);
      float _scaledPixel_3 = LatteView.scaledPixel(this.centerX);
      float _scaledPixel_4 = LatteView.scaledPixel(this.x);
      float _minus = (_scaledPixel_3 - _scaledPixel_4);
      float _scaledPixel_5 = LatteView.scaledPixel(this.centerY);
      float _scaledPixel_6 = LatteView.scaledPixel(this.y);
      float _minus_1 = (_scaledPixel_5 - _scaledPixel_6);
      canvas.rotate(_scaledPixel_2, _minus, _minus_1);
    }
    if ((this.borderSize > 0)) {
      RectF _rectF = new RectF();
      frame = _rectF;
      frame.left = (this.borderSize / 2);
      frame.top = (this.borderSize / 2);
      float _width = this.getWidth();
      float _minus_2 = (_width - (this.borderSize / 2));
      frame.right = _minus_2;
      float _height = this.getHeight();
      float _minus_3 = (_height - (this.borderSize / 2));
      frame.bottom = _minus_3;
      boolean _hasShadow = this.hasShadow();
      if (_hasShadow) {
        float _scaledPixel_7 = LatteView.scaledPixel(this.shadowRadius);
        float _scaledPixel_8 = LatteView.scaledPixel(this.shadowDx);
        float _scaledPixel_9 = LatteView.scaledPixel(this.shadowDy);
        p.setShadowLayer(_scaledPixel_7, _scaledPixel_8, _scaledPixel_9, this.shadowColor);
      }
      float _scaledPixel_10 = LatteView.scaledPixel(this.radius);
      boolean _greaterThan = (_scaledPixel_10 > 0);
      p.setAntiAlias(_greaterThan);
      Integer _borderColor = this.getBorderColor();
      p.setColor((_borderColor).intValue());
      p.setStyle(Paint.Style.STROKE);
      p.setStrokeJoin(Paint.Join.MITER);
      float _scaledPixel_11 = LatteView.scaledPixel(this.borderSize);
      p.setStrokeWidth(_scaledPixel_11);
      RectF _scaleRect = LatteView.scaleRect(frame);
      float _scaledPixel_12 = LatteView.scaledPixel(this.radius);
      float _scaledPixel_13 = LatteView.scaledPixel(this.radius);
      canvas.drawRoundRect(_scaleRect, _scaledPixel_12, _scaledPixel_13, p);
    }
    if (this.clipToBounds) {
      RectF bounds = new RectF();
      bounds.left = 0;
      bounds.top = 0;
      bounds.right = this.width;
      bounds.bottom = this.height;
      RectF _scaleRect_1 = LatteView.scaleRect(bounds);
      bounds = _scaleRect_1;
      float _scaledPixel_14 = LatteView.scaledPixel(this.radius);
      boolean _greaterThan_1 = (_scaledPixel_14 > 0);
      if (_greaterThan_1) {
        Path path = new Path();
        float _scaledPixel_15 = LatteView.scaledPixel(this.radius);
        float _scaledPixel_16 = LatteView.scaledPixel(this.radius);
        path.addRoundRect(bounds, _scaledPixel_15, _scaledPixel_16, Path.Direction.CW);
        canvas.clipPath(path, Region.Op.INTERSECT);
      } else {
        canvas.clipRect(bounds.left, bounds.top, bounds.right, bounds.bottom, Region.Op.REPLACE);
      }
    }
    p.reset();
    float _scaledPixel_17 = LatteView.scaledPixel(this.radius);
    boolean _greaterThan_2 = (_scaledPixel_17 > 0);
    p.setAntiAlias(_greaterThan_2);
    Integer _backgroundColor = this.getBackgroundColor();
    p.setColor((_backgroundColor).intValue());
    p.setStyle(Paint.Style.FILL);
    boolean _hasShadow_1 = this.hasShadow();
    if (_hasShadow_1) {
      float _scaledPixel_18 = LatteView.scaledPixel(this.shadowRadius);
      float _scaledPixel_19 = LatteView.scaledPixel(this.shadowDx);
      float _scaledPixel_20 = LatteView.scaledPixel(this.shadowDy);
      p.setShadowLayer(_scaledPixel_18, _scaledPixel_19, _scaledPixel_20, this.shadowColor);
    }
    RectF _rectF_1 = new RectF();
    frame = _rectF_1;
    frame.left = (this.borderSize / 2);
    frame.top = (this.borderSize / 2);
    float _width_1 = this.getWidth();
    float _minus_4 = (_width_1 - (this.borderSize / 2));
    frame.right = _minus_4;
    float _height_1 = this.getHeight();
    float _minus_5 = (_height_1 - (this.borderSize / 2));
    frame.bottom = _minus_5;
    RectF _scaleRect_2 = LatteView.scaleRect(frame);
    float _scaledPixel_21 = LatteView.scaledPixel(this.radius);
    float _scaledPixel_22 = LatteView.scaledPixel(this.radius);
    canvas.drawRoundRect(_scaleRect_2, _scaledPixel_21, _scaledPixel_22, p);
    int saveCount = canvas.save();
    boolean _notEquals = (!Objects.equal(this.onDraw, null));
    if (_notEquals) {
      this.onDraw.apply(canvas);
    } else {
      this.drawView(canvas);
    }
    canvas.restoreToCount(saveCount);
    final Procedure1<LatteView> _function = new Procedure1<LatteView>() {
      @Override
      public void apply(final LatteView v) {
        v._renderView(canvas);
      }
    };
    IterableExtensions.<LatteView>forEach(this.subViews, _function);
    canvas.restore();
  }
  
  @Pure
  public float getShadowRadius() {
    return this.shadowRadius;
  }
  
  public void setShadowRadius(final float shadowRadius) {
    this.shadowRadius = shadowRadius;
  }
  
  @Pure
  public float getShadowDx() {
    return this.shadowDx;
  }
  
  public void setShadowDx(final float shadowDx) {
    this.shadowDx = shadowDx;
  }
  
  @Pure
  public float getShadowDy() {
    return this.shadowDy;
  }
  
  public void setShadowDy(final float shadowDy) {
    this.shadowDy = shadowDy;
  }
  
  @Pure
  public int getShadowColor() {
    return this.shadowColor;
  }
  
  public void setShadowColor(final int shadowColor) {
    this.shadowColor = shadowColor;
  }
  
  @Pure
  public float getCenterX() {
    return this.centerX;
  }
  
  public void setCenterX(final float centerX) {
    this.centerX = centerX;
  }
  
  @Pure
  public float getCenterY() {
    return this.centerY;
  }
  
  public void setCenterY(final float centerY) {
    this.centerY = centerY;
  }
  
  @Pure
  public float getX() {
    return this.x;
  }
  
  public void setX(final float x) {
    this.x = x;
  }
  
  @Pure
  public float getY() {
    return this.y;
  }
  
  public void setY(final float y) {
    this.y = y;
  }
  
  @Pure
  public float getWidth() {
    return this.width;
  }
  
  public void setWidth(final float width) {
    this.width = width;
  }
  
  @Pure
  public float getHeight() {
    return this.height;
  }
  
  public void setHeight(final float height) {
    this.height = height;
  }
  
  @Pure
  public float getBorderSize() {
    return this.borderSize;
  }
  
  public void setBorderSize(final float borderSize) {
    this.borderSize = borderSize;
  }
  
  @Pure
  public float getRadius() {
    return this.radius;
  }
  
  public void setRadius(final float radius) {
    this.radius = radius;
  }
  
  @Pure
  public int getCurrentState() {
    return this.currentState;
  }
  
  public void setCurrentState(final int currentState) {
    this.currentState = currentState;
  }
  
  @Pure
  public float getRotate() {
    return this.rotate;
  }
  
  public void setRotate(final float rotate) {
    this.rotate = rotate;
  }
  
  @Pure
  public RectF getBounds() {
    return this.bounds;
  }
  
  public void setBounds(final RectF bounds) {
    this.bounds = bounds;
  }
  
  @Pure
  public boolean isClipToBounds() {
    return this.clipToBounds;
  }
  
  public void setClipToBounds(final boolean clipToBounds) {
    this.clipToBounds = clipToBounds;
  }
  
  @Pure
  public LatteView getParent() {
    return this.parent;
  }
  
  public void setParent(final LatteView parent) {
    this.parent = parent;
  }
  
  @Pure
  public boolean isEnabled() {
    return this.enabled;
  }
  
  public void setEnabled(final boolean enabled) {
    this.enabled = enabled;
  }
  
  @Pure
  public Function0<? extends Boolean> getOnTap() {
    return this.onTap;
  }
  
  public void setOnTap(final Function0<? extends Boolean> onTap) {
    this.onTap = onTap;
  }
  
  @Pure
  public Function2<? super Integer, ? super Integer, ? extends Boolean> getOnTouchDown() {
    return this.onTouchDown;
  }
  
  public void setOnTouchDown(final Function2<? super Integer, ? super Integer, ? extends Boolean> onTouchDown) {
    this.onTouchDown = onTouchDown;
  }
  
  @Pure
  public Function2<? super Integer, ? super Integer, ? extends Boolean> getOnTouchUp() {
    return this.onTouchUp;
  }
  
  public void setOnTouchUp(final Function2<? super Integer, ? super Integer, ? extends Boolean> onTouchUp) {
    this.onTouchUp = onTouchUp;
  }
  
  @Pure
  public Function2<? super Integer, ? super Integer, ? extends Boolean> getOnTouchMove() {
    return this.onTouchMove;
  }
  
  public void setOnTouchMove(final Function2<? super Integer, ? super Integer, ? extends Boolean> onTouchMove) {
    this.onTouchMove = onTouchMove;
  }
  
  @Pure
  public Function2<? super Integer, ? super Integer, ? extends Boolean> getOnDrag() {
    return this.onDrag;
  }
  
  public void setOnDrag(final Function2<? super Integer, ? super Integer, ? extends Boolean> onDrag) {
    this.onDrag = onDrag;
  }
  
  @Pure
  public Procedure1<? super Canvas> getOnDraw() {
    return this.onDraw;
  }
  
  public void setOnDraw(final Procedure1<? super Canvas> onDraw) {
    this.onDraw = onDraw;
  }
}
