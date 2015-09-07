package io.lattekit.view

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.graphics.Region
import io.lattekit.device.Window
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

class LatteView {

	val static int SIMULATED_WIDTH = 320;

	var static float xScale = -1;

	var static float REAL_WIDTH;
	var static float REAL_HEIGHT;
	
	public var Window window;
	
	def final static initDeviceConfig(int width, int height) {
		REAL_WIDTH = width;
		REAL_HEIGHT = height;
	}

	def static void updateRatios() {
		xScale = REAL_WIDTH / SIMULATED_WIDTH;
	}

	def static float scaledPixel(float x) {
		if (xScale == -1) {
			updateRatios();
		}
		return x * xScale;
	}
	
	def static float abstractPixel(float x) {
		if (xScale == -1) {
			updateRatios();
		}
		return x / xScale;
	}
	
	

	def static RectF scaleRect(RectF rectf) {
		if (xScale == -1) {
			updateRatios();
		}
		
		var rect = new RectF();
		rect.left = rectf.left.scaledPixel;
		rect.top = rectf.top.scaledPixel;
		rect.right = rectf.right.scaledPixel;
		rect.bottom = rectf.bottom.scaledPixel;
		return rect;
	}

	@Accessors float shadowRadius;
	@Accessors float shadowDx;
	@Accessors float shadowDy;
	@Accessors int shadowColor;

	@Accessors float centerX;
	@Accessors float centerY;

	@Accessors float x;
	@Accessors float y;
	@Accessors float width;
	@Accessors float height;
	@Accessors float borderSize;
	@Accessors float radius
	@Accessors int currentState;

	@Accessors float rotate;
	@Accessors RectF bounds;

	@Accessors boolean clipToBounds = false;
	@Accessors LatteView parent;
	@Accessors boolean enabled = true;
	@Accessors var ()=>boolean onTap = [ true];
	@Accessors var (int,int)=>boolean onTouchDown = [int x, int y|true];
	@Accessors var (int,int)=>boolean onTouchUp = [int x, int y|true];
	@Accessors var (int,int)=>boolean onTouchMove = [int x, int y|true];
	@Accessors var (int,int)=>boolean onDrag = [int x, int y|true];
	@Accessors var (Canvas)=>void onDraw = [Canvas canvas|drawView(canvas);];

	val Integer[] backgroundColor = #[Color.WHITE, null, null, null];
	val Integer[] borderColor = #[Color.BLACK, null, null, null];
	val List<LatteView> subViews = new ArrayList<LatteView>();

	public static val ViewStateNormal = 0;
	public static val ViewStateHighlighted = 1;
	public static val ViewStateDisabled = 2;
	public static val ViewStateSelected = 3;
	
	public static val TouchTypeDown = 0;
	public static val TouchTypeMove = 1;
	public static val TouchTypeUp = 2;
	
	private boolean isTouchInside;

	new(int x, int y, int width, int height) {
		setFrame(x, y, width, height);
	}
	
	def void attachToWindow(Window window) {
		this.window = window;
		for (LatteView v : subViews) {
			v.attachToWindow(window);
		}
	}

	def setBackgroundColor(int color, int state) {
		backgroundColor.set(state, color);
	}

	def setBorderColor(int color, int state) {
		borderColor.set(state, color);
	}

	def getBackgroundColor() {
		var color = backgroundColor.get(currentState);
		if (color == null) {
			color = backgroundColor.get(ViewStateNormal)
		}
		return color;
	}

	def getBorderColor() {
		var color = borderColor.get(currentState);
		if (color == null) {
			color = borderColor.get(ViewStateNormal)
		}
		return color;
	}

	def addSubview(LatteView child) {
		child.parent = this;
		child.window = this.window;
		subViews.add(child);

	}

	def final setFrame(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.centerX = this.x + this.width / 2;
		this.centerY = this.y + this.height / 2;
		this.bounds = new RectF(x,y,x+width,y+height)
	}

	def final setCenter(float x, float y) {
		this.centerX = x;
		this.centerY = y;
		this.x = this.centerX - this.width / 2;
		this.y = this.centerY - this.height / 2;
		this.bounds = new RectF(this.x,this.y,this.x+this.width,this.y+this.height)
	}

	def void drawView(Canvas canvas) {
	}
	
	def final boolean _touchTest(float x, float y, int touchType) {
		if (!this.enabled) return false;
		for (view: subViews) {
			if (view._touchTest(x,y, touchType)) {
				return true;
			}
		}
		
		if (this.bounds.scaleRect.contains(x, y)) {
			if (touchType == TouchTypeDown) {
				handleTouchDown(x,y);
				isTouchInside = true;
			} else if (touchType == TouchTypeMove) {
				handleTouchMove(x,y);
				isTouchInside = true;				
			} else if (touchType == TouchTypeUp) {
				handleTouchUp(x,y);				
			}
			return true;
		} else if (isTouchInside && touchType == TouchTypeMove) {
			isTouchInside = false;
			handleTouchExit(x,y);				
		}
		return false;
	}
	
	def void invalidate() {
		window.invalidate();

//		if (parent != null) {
//			parent.invalidate;
//		} else {
//			// This is root
//			window.invalidate();
//		}
	}
	
	def handleTouchDown(float x, float y) {
		this.currentState = ViewStateHighlighted;
		invalidate
	}
	
	def handleTouchMove(float x, float y) {
	}
	
	def handleTouchExit(float x, float y) {
		if (this.currentState == ViewStateHighlighted ) {
			this.currentState = ViewStateNormal;
			invalidate
		}
	}
	
	def handleTouchUp(float x, float y) {
		if (this.currentState == ViewStateHighlighted ) {
			this.currentState = ViewStateNormal;
			
			if (enabled)  {
				onTap.apply();
			}
			invalidate
		}
	}
	
	def boolean hasShadow() {
		this.shadowRadius > 0 && !this.clipToBounds;
	} 
		
	final def void _renderView(Canvas canvas) {
		canvas.save();

		var Paint p = new Paint();

		var RectF frame;

		
		// Translate to origin
		canvas.translate(this.x.scaledPixel, this.y.scaledPixel);
//		val Canvas canvas = new Canvas();
		if (this.rotate > 0) {
			canvas.rotate(this.rotate.scaledPixel, this.centerX.scaledPixel - this.x.scaledPixel, this.centerY.scaledPixel - this.y.scaledPixel);
		}

		if (this.borderSize > 0) {
			frame = new RectF();
			frame.left = this.borderSize / 2;
			frame.top = this.borderSize / 2;
			frame.right = getWidth() - this.borderSize / 2;
			frame.bottom = getHeight() - this.borderSize / 2;
			if (hasShadow) {
				p.setShadowLayer(this.shadowRadius.scaledPixel, this.shadowDx.scaledPixel, this.shadowDy.scaledPixel, this.shadowColor);
			}
			p.setAntiAlias(this.radius.scaledPixel > 0);
			p.setColor(getBorderColor());
			p.setStyle(Paint.Style.STROKE);
			p.setStrokeJoin(Paint.Join.MITER);
			p.setStrokeWidth(this.borderSize.scaledPixel);
			canvas.drawRoundRect(frame.scaleRect, this.radius.scaledPixel, this.radius.scaledPixel, p);
		}

		if (clipToBounds) {
			var bounds = new RectF();
			bounds.left = 0;
			bounds.top = 0;
			bounds.right = width;
			bounds.bottom = height;
			bounds = bounds.scaleRect;

			if (this.radius.scaledPixel > 0) {
				var Path path = new Path();
				path.addRoundRect(bounds, this.radius.scaledPixel, this.radius.scaledPixel, Path.Direction.CW);
				canvas.clipPath(path, Region.Op.INTERSECT);
			} else {
				canvas.clipRect(bounds.left, bounds.top, bounds.right, bounds.bottom, Region.Op.REPLACE);
			}

		}

		p.reset;
		p.setAntiAlias(this.radius.scaledPixel > 0);
		p.setColor(getBackgroundColor());
		p.setStyle(Paint.Style.FILL);

		if (hasShadow) {
			p.setShadowLayer(this.shadowRadius.scaledPixel, this.shadowDx.scaledPixel, this.shadowDy.scaledPixel, this.shadowColor);
		}

		frame = new RectF();
		frame.left = this.borderSize / 2;
		frame.top = this.borderSize / 2;
		frame.right = getWidth() - this.borderSize / 2;
		frame.bottom = getHeight() - this.borderSize / 2;

		canvas.drawRoundRect(frame.scaleRect, this.radius.scaledPixel, this.radius.scaledPixel, p);

		// Draw content
		var saveCount = canvas.save();
		if (onDraw != null) {
			onDraw.apply(canvas);
		} else {
			drawView(canvas);
		}
		canvas.restoreToCount(saveCount);
		
		subViews.forEach [v |
			v._renderView(canvas);
		];
		canvas.restore();


		
	}

}
