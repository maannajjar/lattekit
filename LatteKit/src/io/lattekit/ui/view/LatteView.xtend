package io.lattekit.ui.view

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import io.lattekit.ui.LatteActivity
import io.lattekit.ui.style.Stylesheet
import java.util.ArrayList
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

public class LatteView {
    
    static Map<String,LatteView> SAVED_OBJECTS = newHashMap();
    
    public final static int MATCH_PARENT = LayoutParams.MATCH_PARENT;
    public final static int WRAP_CONTENT = LayoutParams.WRAP_CONTENT;
    public final static int match_parent = LayoutParams.MATCH_PARENT;
    public final static int wrap_content = LayoutParams.WRAP_CONTENT;
        
    @Accessors String viewType;
    @Accessors List<LatteView> renderedViews = newArrayList()
    @Accessors View androidView;
    
        
    // Generic Props
    public Map<String,Object> props = newHashMap();
    
    @Accessors public LatteView parentView;
    // This contains current active children
    @Accessors public List<LatteView> children = newArrayList;
    
    @Accessors private Stylesheet stylesheet = new Stylesheet();
    
    public Context activity;
    
    protected ChildrenProc childrenProc;
    private boolean isMounted = false;

    
    def static getSavedObject(String id) {
        return SAVED_OBJECTS.get(id);
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
        return this.rootAndroidView;        
    }
    
    def void handleStateChanged() {    	
		this.renderTree() 
		this.buildAndroidViewTree(activity,rootAndroidView.layoutParams);
    }
        
    def static sameView(LatteView leftView, LatteView rightView) {
        if (leftView.class == rightView.class && leftView.viewType == rightView.viewType) {
            return true;
        }
        return false;
    }    
    
    def static createLayout(String viewType, Map<String,Object> props, ChildrenProc childrenProc) {
    	var cls = if (viewType.startsWith("android")) {
    		"io.lattekit.ui.view.NativeView"
    	} else {
    		viewType
    	}
    	var layout = Class.forName(cls).newInstance as LatteView
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
            if (this.androidView == null) {
            	this.androidView = (this as NativeView).renderNative(a);
            } 
        	if (this.androidView.layoutParams == null) {
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
}

interface ChildrenProc {
	def List<LatteView> apply();
}