package io.lattekit.ui.view

import android.R
import android.animation.Animator
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.RippleDrawable
import android.graphics.drawable.ShapeDrawable
import android.os.Build
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.AdapterView
import android.widget.TextView
import io.lattekit.ui.style.Style
import io.lattekit.util.Util
import org.eclipse.xtext.xbase.lib.CollectionLiterals
import org.eclipse.xtext.xbase.lib.Functions
import org.eclipse.xtext.xbase.lib.ObjectExtensions
import org.eclipse.xtext.xbase.lib.Procedures
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import kotlin.jvm.functions.Function0

/**
 * Created by maan on 2/15/16.
 */
open class NativeView : LatteView(), View.OnClickListener, View.OnTouchListener {
    val MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT
    val WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT
    val match_parent = ViewGroup.LayoutParams.MATCH_PARENT
    val wrap_content = ViewGroup.LayoutParams.WRAP_CONTENT

    private val _style = Style()

    private val allStyles = mutableMapOf<String, MutableList<Style>>()
    private val pseudoStyles = mutableMapOf< String, List<Style>>()
    private val computedStyles = mutableMapOf<String, Style>()
    private val currentSelectedPseudos = mutableSetOf("normal")

    private var isAttached = false

    var normalStyle = Style()

    var touchedStyle = ObjectExtensions.operator_doubleArrow(Style(), Procedures.Procedure1<Style> { it -> it.parentStyle = this@NativeView.normalStyle })

    var disabledStyle = ObjectExtensions.operator_doubleArrow<Style>(Style(), object : Procedures.Procedure1<Style> {
        public override fun apply(it: Style) {
            it.setParentStyle(this@NativeView.normalStyle)
        }
    })
    var currentAnimation: Animator? = null

    public var pendingChildAnimations: List<Animator> = CollectionLiterals.newArrayList<Animator>()

    public var shapeDrawable: ShapeDrawable? = null
    public var backgroundDrawable: LayerDrawable? = null

    var nativeViewClass : Class<out View>? = null

    val methodCache = mutableMapOf<String, Method?>()

    var activeStyle : Style? = null
        get() {
            if (androidView != null && !androidView?.isEnabled!! && disabledStyle != null) {
                return disabledStyle
            } else if (currentSelectedPseudos.contains("touched") && touchedStyle != null) {
                return computedStyles.get("touched");
            }
            return computedStyles.get("normal");
        }

    open fun getViewClass() : Class<out View> {
        return if (nativeViewClass != null) {
            nativeViewClass as Class<out View>
        } else {
            View::class.java
        }
    }

    fun renderNative(context : Context) : View {
        return getViewClass().constructors.find{ it.parameterTypes.size == 1 }?.newInstance(context) as View
    }



    fun findSetter(setter : String , valueType: Class<Any>, isFnValue : Boolean) : Method? {
        var myCls = getViewClass();
        var currentCls : Class<*> = myCls;
        var valueCls : Class<*> = valueType;
        var reachedEnd = false;
        var method : Method?;
        while (!reachedEnd) {
            if (isFnValue) {
                method = currentCls.declaredMethods.find{ it.name == setter };
                if (method != null && method.parameterTypes.size == 1) {
                    var listenerInterface : Class<*> = method?.parameterTypes?.get(0)!!;
                    if (listenerInterface.isInterface) {
                        return method;
                    }
                } else {
                    currentCls = currentCls.superclass
                    if (currentCls == Object::class.java) {
                        reachedEnd = true;
                    }
                }
            } else {
                try {
                    method = myCls.getMethod(setter, valueCls);
                    return method;
                } catch(ex : NoSuchMethodException) {
                }
                try {
                    var primitiveType = valueCls.getField("TYPE").get(null) as Class<*>;
                    method = myCls.getMethod(setter, primitiveType);
                    return method;
                } catch(nsfe : NoSuchFieldException ) {
                } catch(ex : NoSuchMethodException ) {
                }
                for(iface in valueCls.interfaces) {
                    try {
                        method = myCls.getMethod(setter, iface);
                        return method;
                    } catch(ex: NoSuchMethodException ) {
                    }
                }
            }
            if (valueCls.superclass == null) {
                reachedEnd = true;
            } else {
                valueCls = valueCls.superclass
            }
        }
        return null;
    }

    fun createLambdaProxyInstance(receiverClass : Class<*> , value: Object ) : Any {
        var instance = Proxy.newProxyInstance(receiverClass.getClassLoader(), arrayOf(receiverClass),
                { any, invokedMethod, arrayOfAnys ->
                    if (value is Procedures.Procedure0) {
                        value.apply()
                    } else if (value is Functions.Function0<*>) {
                        value.apply()
                    } else if ( Util.hasKotlin() && value is Function0<*>) {
                        value.invoke()
                    } else {
                        null
                    }
                })
        return instance;
    }


    open fun applyProps() {
        applyProps(false);
    }

    fun applyProps(onlyDelayed : Boolean ) {
        if (androidView != null) {
            // Default clickable to false
            this.androidView?.isClickable = false
            val myCls = getViewClass()
            props.forEach { entry ->
                var it = entry.key
                if (it == "id") {
                    this.androidView?.id = if (this.props.get("id")!! is String) Util.makeResId("latte", "id", this.props.get("id") as String) else this.props.get("id") as Int
                } else if (it.startsWith("@") && !isAttached) {
                } else if (onlyDelayed && !it.startsWith("@")) {
                } else {
                    val value = props.get(it);
                    var field = if (it.startsWith("@")) {
                        it.substring(1)
                    } else it;
                    var isFn = value is Procedures.Procedure0
                            || value is Functions.Function0<*>
                            || (Util.hasKotlin() && value is Function0<*>)
                    var setter = "set" + field.substring(0, 1).toUpperCase() + field.substring(1) + (if (isFn) "Listener" else "")
                    if (value == null) {
                    } else {
                        var valueCls = value.javaClass

                        var methodKey = myCls.toString() + ":" + field + ":" + value.javaClass
                        var method = methodCache.get(methodKey);
                        if (!methodCache.containsKey(methodKey)) {
                            // This is the first time we look
                            method = findSetter(setter, valueCls, isFn)
                            if (method == null) {
                                setter = field;
                                method = findSetter(setter, valueCls, isFn)
                            }
                            methodCache.put(methodKey, method);
                        }
                        if (method != null) {
                            method.invoke(androidView, if (isFn) createLambdaProxyInstance(method.parameterTypes.get(0), value as Object) else value);
                        }
                    }
                }

            }


        }
    }
//
    override fun onPropsUpdated(oldProps :Map<String, Any?>) : Boolean {
        if (props.get("cls") != oldProps.get("cls")) {
            // TODO: UPDATING STYLES IS BUGGY
//            updateStyles(true, true)
        }
        applyProps();
        return false
    }

    override fun onViewMounted() {
        if (androidView != null) {
            computeAllStyles();
            createBackgroundDrawable();
            updateTextColorDrawable();

            _style.cloneFrom(activeStyle);
            //TODO FIX STYLE
            _style.applyToView(this);

            androidView?.layoutParams?.width = _style.width.inPixelsInt(androidView?.context);
            androidView?.layoutParams?.height = _style.height.inPixelsInt(androidView?.context)

            if (!(androidView is AdapterView<*>)) {
                androidView?.setOnClickListener(this)
            }
            androidView?.setOnTouchListener(this);

            if (normalStyle._computedX == null) {
                watchTree();
            }
            applyProps()
        }
    }

    fun watchTree() {
        androidView?.viewTreeObserver?.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                isAttached = true;
                normalStyle._computedX = androidView?.x
                normalStyle._computedY = androidView?.y
                androidView?.viewTreeObserver?.removeOnGlobalLayoutListener(this)
                applyProps(true);
            }
        })
    }

    fun getMeasuredSize() : Point {
        return getMeasuredSize(computedStyles?.get("normal")!!);
    }

    fun getWindowWidth() : Int {
        return androidView?.context?.getResources()?.getDisplayMetrics()?.widthPixels!!
    }

    fun getWindowHeight() : Int {
        return androidView?.context?.getResources()?.getDisplayMetrics()?.heightPixels!!
    }

    fun getMeasuredSize(forStyle : Style) : Point {
        // Temporarily apply style to accurately measure size
        // TODO: only apply props that affect size
        forStyle.applyToView(this);

        var widthMeasureSpec = if (forStyle.width.inPixelsInt(androidView?.context) == ViewGroup.LayoutParams.MATCH_PARENT) {
            var parentWidth : Int= if (getNonVirtualParent() != null) {
                getNonVirtualParent()!!.getMeasuredSize().x - forStyle.marginLeft.inPixelsInt(androidView?.context) - forStyle.marginRight.inPixelsInt(androidView?.context);
            } else getWindowWidth();
            View.MeasureSpec.makeMeasureSpec(parentWidth, View.MeasureSpec.EXACTLY);
        } else if (forStyle.width.inPixelsInt(androidView?.context) == ViewGroup.LayoutParams.WRAP_CONTENT) {
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        } else {
            View.MeasureSpec.makeMeasureSpec(forStyle.width.inPixelsInt(androidView?.context), View.MeasureSpec.EXACTLY);
        }

        var heightMeasureSpec = if (forStyle.height.inPixelsInt(androidView?.context) == ViewGroup.LayoutParams.MATCH_PARENT) {
            var parentHeight = if (getNonVirtualParent() != null) {
                getNonVirtualParent()!!.getMeasuredSize().y - forStyle.marginTop.inPixelsInt(androidView?.context) - forStyle.marginBottom.inPixelsInt(androidView?.context);
            } else getWindowHeight();
            View.MeasureSpec.makeMeasureSpec(parentHeight, View.MeasureSpec.EXACTLY);
        } else if (forStyle.height.inPixelsInt(androidView?.context) == ViewGroup.LayoutParams.WRAP_CONTENT) {
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        } else {
            View.MeasureSpec.makeMeasureSpec(forStyle.height.inPixelsInt(androidView?.context), View.MeasureSpec.EXACTLY);
        }
        androidView?.measure(widthMeasureSpec, heightMeasureSpec);
        // Go back to current style;
//        _style.applyToView(this);
        return Point(androidView?.measuredWidth!!, androidView?.measuredHeight!!);
    }

    fun createBackgroundDrawable() {
        if (backgroundDrawable == null) {
            backgroundDrawable = LayerDrawable(arrayOf(ColorDrawable(), ColorDrawable(), ColorDrawable()))
            backgroundDrawable?.setId(0,0)
            backgroundDrawable?.setId(1,1)
            backgroundDrawable?.setId(2,2)
            //TODO FIX STYLE
            shapeDrawable = ShapeDrawable(computedStyles.get("touched")?.getShape(this));
            var rippleColor = ColorStateList(arrayOf(intArrayOf()), intArrayOf(Style.asColor(computedStyles.get("touched")!!.rippleColor)));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                androidView?.background = RippleDrawable(rippleColor, backgroundDrawable, shapeDrawable);
            } else {
                androidView?.background =  codetail.graphics.drawables.RippleDrawable(rippleColor,backgroundDrawable, this.shapeDrawable);
            }
        }
    }

    fun updateTextColorDrawable() {
        var colorStates : MutableList<IntArray> = mutableListOf()
        var colorList : MutableList<Int>  = mutableListOf()
        if (touchedStyle != null) {
            colorStates.add(intArrayOf( R.attr.state_enabled, R.attr.state_pressed))
            colorList.add(Style.asColor(touchedStyle?.textColor))
        }
        colorStates.add(intArrayOf(R.attr.state_enabled, -R.attr.state_pressed ))
        colorList.add(Style.asColor(normalStyle.textColor))

        if (disabledStyle != null) {
            colorStates.add(intArrayOf( -R.attr.state_enabled))
            colorList.add(Style.asColor(disabledStyle.textColor))
        }
        if (androidView is TextView) {
            (androidView as TextView).setTextColor(ColorStateList(colorStates.toTypedArray(), colorList.toIntArray()))
        }
    }
//
    override fun onTouch(v : View, e : MotionEvent) : Boolean {
        if (pseudoStyles.get("touched")?.isEmpty()!! /*&& onTouch == null  */) {
            // No need to handle touch here
            return false;
        }

        var handled = false;
        if (/*onTouch != null && */e.action == MotionEvent.ACTION_DOWN) {
            //            handled = onTouch.apply(this,e);
        }
        if (v.isEnabled) {
            if (e.action == MotionEvent.ACTION_DOWN) {
                currentSelectedPseudos += "touched";
                updateStyles(true,true);
            } else if (e.action == MotionEvent.ACTION_UP) {
                //TODO: THIS IS DONE TO TEMPORARILY WORK AROUND ONCLICK EXECUTING AFTER THIS
                // PLEASE FIND BETTER WAY
                currentSelectedPseudos -= "touched";
                updateStyles(true,true)
            }
        }
        if (/*onTouch != null && */ e.action == MotionEvent.ACTION_UP) {
            //            handled = onTouch.apply(this,e);
        }
        return handled;
    }
//
    fun applySubviewStyles() {
        children.forEach { it : LatteView ->
            //TODO FIX STYLE
            (it as NativeView).activeStyle?.applyToView(it as NativeView);
        }
    }
//
//
    fun getSelectedStyles() : List<Style>{
        return  allStyles.filter {e -> currentSelectedPseudos?.contains(e.key) }.flatMap { allStyles.get(it.key)!! }
    }
//
    fun findDirectChildrenStyles(selectors : List<String>, outList : MutableList<Style>) {
        getSelectedStyles().forEach { style ->
             selectors.forEach {  selector ->
                 if (style.directChildrenStyles.containsKey(selector)) {
                     outList.add(style.directChildrenStyles.get(selector)!!);
                 }
             }
        }
    }
//
    fun findDesecendantStyles(selectors: List<String> , outList: MutableList<Style> ) {
        if (getNonVirtualParent() != null) {
            getNonVirtualParent()?.findDesecendantStyles(selectors,outList);
        }

        getSelectedStyles().forEach { style ->
            selectors.forEach { selector ->
                if (style.descendantStyles.containsKey(selector)) {
                    outList.add(style.descendantStyles.get(selector)!!);
                }
            }
        }
    }
    fun getCls() : String? {
        return props.get("cls") as String?
    }
//
    fun computeStyle(pseudo : String ) : List<Style> {
        // TODO: re-use previous computed style and just reset it
        val targetStyle = Style();
        val mySelectors = mutableListOf("View");
        if (getCls() != null) {
            getCls()?.split(" ")?.forEach {
                mySelectors += "." + it;
            }
        }
        var selectedStyles = mutableListOf<Style>();
        if (pseudo != "normal") {
            mySelectors += mySelectors.map {it+":"+pseudo};
        }
        selectedStyles.addAll(mySelectors.map{ stylesheet.getStyle(it) }.filter { it != null })
        if (getNonVirtualParent() != null) {
            getNonVirtualParent()?.findDesecendantStyles(mySelectors, selectedStyles)
            getNonVirtualParent()?.findDirectChildrenStyles(mySelectors, selectedStyles);
        }
        selectedStyles.forEach {
            targetStyle.overrideWithStyle(it);
        }
        targetStyle.overrideWithStyle(normalStyle);
        if ( pseudo == "touched") {
            targetStyle.overrideWithStyle(touchedStyle);
        }

        if (pseudo == "normal") {
            allStyles.put("normal", selectedStyles);
            pseudoStyles.put("normal", selectedStyles);
        } else {
            allStyles.put(pseudo, selectedStyles);
            // In order for this to work properly, computeStyle for normal should be called always before
            pseudoStyles.put(pseudo, selectedStyles.filter { !allStyles.get("normal")?.contains(it)!! }.toList());
        }
        computedStyles.put(pseudo, targetStyle);

        return selectedStyles

    }
//
    fun computeAllStyles() {
        computeStyle("normal");
        computeStyle("touched");
    }
//
    fun computeActiveStyles() {
        currentSelectedPseudos.forEach { pseudo -> computeStyle(pseudo)  }
    }
//
    fun updateStyles(shouldTransition : Boolean, shouldUpdateChildren : Boolean) {

        if (shouldTransition) {
            transitionStyle();
        }
        // TODO: Only update lower levels if we really need to
        if (shouldUpdateChildren) {
            children.forEach { computeActiveStyles(); updateStyles(shouldTransition, shouldUpdateChildren) }
        }
    }
//
    fun transitionStyle() {
        if (androidView != null) {
            var oldAnim = currentAnimation;
            //TODO FIX STYLE
            currentAnimation = activeStyle?.createAnimatorFrom(_style, this, false)
            if (oldAnim != null) {
                oldAnim.cancel();
            }
            currentAnimation?.start()
        }
    }

    override fun onClick(p0: View?) {


    }
}