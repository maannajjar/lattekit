package io.lattekit.ui.view

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import io.lattekit.ui.LatteActivity
import io.lattekit.ui.style.Stylesheet
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import android.util.Log
import org.eclipse.xtend.lib.annotations.Accessors

public class LatteView {
    
    static Map<String,LatteView> SAVED_OBJECTS = newHashMap();
    public final static int ANDROID = 1;
    public final static int WEB = 2
    public static int RENDER_TARGET = ANDROID;

    @Accessors String viewType;
    @Accessors List<LatteView> renderedViews = newArrayList()
    @Accessors View androidView;
    
    // Generic Props
    public Map<String,Object> props = newHashMap();
    
    @Accessors public LatteView parentView;
    // This contains current active children
    @Accessors public List<LatteView> children = newArrayList;
    
    @Accessors private Stylesheet stylesheet = new Stylesheet();

    String objectId;
    
    public Context activity;
    
    protected ChildrenProc childrenProc;
    private boolean isMounted = false;

    private static Map<String,Class> LOOKUP_CACHE = newHashMap(
        "View" -> android.view.View,
        "TextView" -> android.widget.TextView,
        "ImageView"-> ImageView,
        "ListView"-> ListView,
        "LinearLayout" -> LinearLayout,
        "RelativeLayout" -> RelativeLayout,
        "SwipeRefreshLayout" -> SwipeRefreshLayout
    );

    def static getSavedObject(String id) {
        return SAVED_OBJECTS.get(id);
    }

    def String getObjectId() {
        if (objectId == null) {
            objectId =  System.currentTimeMillis+"";
        }
        return objectId;
    }
    def show(LatteView caller) {
        var myId = System.currentTimeMillis+"";
        var intent = new Intent(caller.rootAndroidView.context, LatteActivity);
        intent.putExtra("_LATTE_KIT_OBJ_ID",myId)
        LatteView.SAVED_OBJECTS.put(myId,this)
        caller.rootAndroidView.context.startActivity(intent);
    }

    def onStateChanged() {
        handleStateChanged
    }

    def View buildView(Context context,LayoutParams lp) {
        activity = context;
        this.renderTree()
        this.buildAndroidViewTree(activity,lp); 
        return if (RENDER_TARGET == WEB) null else this.rootAndroidView;
    }
    
    def void handleStateChanged() {
		this.renderTree() 
		this.buildAndroidViewTree(activity, if (RENDER_TARGET == ANDROID) rootAndroidView.layoutParams else null);
    }
        
    def static sameView(LatteView leftView, LatteView rightView) {
        if (leftView.class == rightView.class && leftView.viewType == rightView.viewType) {
            return true;
        }
        return false;
    }    
    def static createLayout(String viewType, Map<String,Object> props) {
        return createLayout(#[], viewType,props,[
            return #[]
        ])
    }    
    def static createLayout(String viewType, Map<String,Object> props, ChildrenProc childrenProc) {
    	return createLayout(#[], viewType,props,childrenProc)
    }
    def static createLayout(List<String> imports, String vT, Map<String,Object> props, ChildrenProc childrenProc) {
    	var LatteView layout = null;
    	var viewType = vT;
        var Class cachedCls;
        var clazz = if ( (cachedCls = LOOKUP_CACHE.get(vT)) != null ) {
            cachedCls
        } else if (vT.contains(".")) {
            var cls =  try {
                Class.forName(vT+"Impl")
            } catch (ClassNotFoundException ex){
                Class.forName(vT)
            }
            LOOKUP_CACHE.put(vT,cls);
            cls
        } else {
            var cls = Class.forName("android.widget."+vT);
            LOOKUP_CACHE.put(vT,cls);
            cls
        }
        log("Found class "+ clazz)
        if (ViewGroup.isAssignableFrom(clazz)) {
            layout = new NativeViewGroup();
            (layout as NativeViewGroup).nativeViewClass = clazz
            viewType = clazz.name
        } else if (View.isAssignableFrom(clazz)) {
            layout = new NativeView();
            (layout as NativeView).nativeViewClass = clazz
            viewType = clazz.name
        } else {
            layout = clazz.newInstance as LatteView;
            viewType = clazz.name
        }

    	layout.viewType = viewType;
    	layout.props = props;
    	layout.childrenProc = childrenProc;
    	layout.children = layout.childrenProc.apply()
    	
    	return layout
    }
    
    
    def void renderTree() {
    	var List<LatteView> newRenderedViews = newArrayList()
    	var renderMe = this.render()
    	if (renderMe != null) {
    		renderMe.stylesheet = this.stylesheet
    		newRenderedViews += renderMe
    	} 
    	if (this instanceof NativeViewGroup) {
	    	for (child: children) {
	    		newRenderedViews += child
	    	}
	    }
	    
		for (var i =0;i<newRenderedViews.length;i++) {
			var newView = newRenderedViews.get(i);
			if (i < renderedViews.length) {
				var oldView = renderedViews.get(i)
				if (sameView(oldView, newView)) {
					var oldProps = oldView.props
					oldView.children = newView.children
					oldView.props = newView.props
					if (oldView.onPropsUpdated(oldProps)) {
						oldView.renderTree()	
					}
					newRenderedViews.set(i, oldView)
				} else {
					newView.renderTree()
				}
			} else {
	    		newView.parentView = this
	    		newView.stylesheet = this.stylesheet
	    		newView.renderTree()			
			}
		}

		this.renderedViews = newRenderedViews;
    }
    

    def boolean onPropsUpdated(Map<String,Object> props) {
    	return true;
    }
    

    def LatteView render() {
       	return null;
    }
    
	def void loadStylesheet(Stylesheet... stylesheets) {
		stylesheets.forEach[ it.apply(this.stylesheet) ];
	}
    
    def View getRootAndroidView() {
        if (this.androidView != null) {
        	 return this.androidView
        } else if (this.renderedViews.get(0) != null) {
    		return this.renderedViews.get(0).rootAndroidView;
    	}
    }
    
    def void onViewMounted() {
    }
   	
    def View buildAndroidViewTree(Context a, ViewGroup.LayoutParams lp) {
        // First build my view
        this.activity = a;
        if (this instanceof NativeView) {
            if (RENDER_TARGET == ANDROID && this.androidView == null) {
            	this.androidView = (this as NativeView).renderNative(a);
            } 
        	if (RENDER_TARGET == ANDROID && this.androidView.layoutParams == null) {
        		this.androidView.layoutParams = lp;
        	}
        	if (!isMounted) {
            	isMounted = true;
            	onViewMounted();
        	}			
        	
			if (this instanceof NativeViewGroup) {
				(this as NativeViewGroup).mountChildren()
			}
            return this.androidView
        } else {
            // If we don't have native android view, then we are virtual node
            var subAndroid =  this.renderedViews.get(0).buildAndroidViewTree(a, lp);
            if (!isMounted) {
                isMounted = true;
                onViewMounted();
            }
            return subAndroid;
        }
    }
    
    def boolean isMounted() {
        return this.isMounted
    }

    def NativeView getNonVirtualParent() {
        if (parentView == null) {
            return null;
        }
        if (parentView instanceof NativeView) {
            return parentView as NativeView;
        }
        return parentView.nonVirtualParent
    }
    
    def LatteView copy() {
        val copy = this.class.newInstance
        copy.props = props;
        copy.children = new ArrayList<LatteView>()
        children.forEach[ copy.children += it.copy() ]
        copy.viewType = viewType
        copy.stylesheet = stylesheet;
        return copy;
    }
    
    def String getId() {
    	return props.get("id") as String
    }
    def LatteView $() {
    	return null
    }
	def static Map<String,Object> props(Object...objects) {
		var HashMap<String,Object> map = new HashMap<String,Object>(objects.length/2);
		for (var i = 0; i< objects.length;i+=2) {
			map.put(objects.get(i) as String, objects.get(i+1));
		}
		return map;
	}

    def static void log(String message) {
        Log.d("Latte",message)
    }
}

interface ChildrenProc {
	def List<LatteView> apply();
}