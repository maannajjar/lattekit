package io.lattekit.ui.view

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import io.lattekit.ui.LatteActivity
import io.lattekit.ui.style.Stylesheet
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

public  class LatteView {
    
    static Map<String,LatteView> SAVED_OBJECTS = newHashMap();
    
    public final static int MATCH_PARENT = LayoutParams.MATCH_PARENT;
    public final static int WRAP_CONTENT = LayoutParams.WRAP_CONTENT;
    public final static int match_parent = LayoutParams.MATCH_PARENT;
    public final static int wrap_content = LayoutParams.WRAP_CONTENT;
        
    String viewType;
    @Accessors LatteView renderedView;
    @Accessors View androidView;
    
        
    // Generic Props
    public Map<String,Object> props = newHashMap();
    
    @Accessors public LatteView parentView;
    // This contains current active children
    @Accessors public List<LatteView> children = newArrayList;
    
    @Accessors private Stylesheet stylesheet = new Stylesheet();
    
    public Context activity;
    
    protected ChildrenProc childrenProc;
    private boolean isRendering = false;
    private boolean isMounted = false;

    
    def static getSavedObject(String id) {
        return SAVED_OBJECTS.get(id);
    }
    
        
    def show(LatteView object) {
        var myId = System.currentTimeMillis+"";
        var intent = new Intent(rootAndroidView.context, LatteActivity);
        intent.putExtra("_LATTE_KIT_OBJ_ID",myId)
        LatteView.SAVED_OBJECTS.put(myId,object)
        rootAndroidView.context.startActivity(intent);
    }

    def onStateChanged() {
        handleStateChanged
    }
    def void doRender() {
    	if (this.childrenProc != null) {
    		this.childrenProc.apply(this);
    	}
    	this.renderedView = this.render()
    	if (this.renderedView != null) {
    		this.renderedView.stylesheet = this.stylesheet;
    		this.renderedView.doRender();
    	}
    }
    def View buildView(Context context,LayoutParams lp) {
        activity = context;
        this.doRender();
        this.buildAndroidViewTree(activity,lp); 
        return this.rootAndroidView;        
    }
    
    def void handleStateChanged() {    	
        var newView = this.render();
        newView.doRender()
        this.renderedView = reconcile(this.renderedView,newView)
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
    	return layout
    }
    
    def static LatteView reconcile(LatteView previous, LatteView newView) {
    	if (previous == null) {
    		return newView;
    	}
    	if (sameView(previous,newView)) {  
    		Log.d("Latte", previous +" is same as "+ newView);
    		Log.d("Latte", previous.children.size +" VS "+ newView.children.size);
			previous.onWillReceiveProps(newView.props);    		              
			previous.props = newView.props;
			if (previous.renderedView != null && newView.renderedView != null) {
				Log.d("Latte", previous.renderedView +" RECONCILING WITH  "+ newView.renderedView);
				previous.renderedView.reconcile(newView.renderedView)
			} else if (newView.renderedView != null) {
				previous.renderedView = newView.renderedView
			}
			for (var i =0 ; i < newView.children.size; i++) {
	            var newChild = newView.children.get(i);
	            Log.d("Latte", previous.children.get(i) +" RECONCILING WITH  "+ newChild);
    	        previous.reconcileChild(i,newChild);
	        }
			return previous;
         }
         return newView;
    }
        
    def void onWillReceiveProps(Map<String,Object> props) {
    	
    }
    def reconcileChild(int index, LatteView newChild) {
        // Compare child with existing subview
        // If accepted then just call render in existing subview after transferring properties
        // If not, then add new subview
        Log.d("Latte",this +" adding child to"+ newChild)
        if (index < children.size) {
            children.set(index,reconcile(children.get(index),newChild))
        } else {
            children.add(index,newChild);
        }
        children.get(index).stylesheet = this.stylesheet
        if (!(this instanceof ListView)) {
        	children.get(index).doRender()
        }

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
        } else if (this.renderedView != null) {
    		return this.renderedView.rootAndroidView;
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
            Log.d("Latte", this+" Created "+this.androidView)
        	if (this.androidView.layoutParams == null) {
        		this.androidView.layoutParams = lp;
        	}
        	if (!isMounted) {
            	isMounted = true;
            	onViewMounted();
        	}
            return this.androidView
        } else {
            // If we don't have native android view, then we are virtual node
            Log.d("Latte", this +" : asking "+this.renderedView +" To build view itself");
            var subAndroid =  this.renderedView.buildAndroidViewTree(a, lp);
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
    
    
    def LatteView copy() {
        val copy = this.class.newInstance
        copy.props = props;
        copy.childrenProc = childrenProc;
        copy.viewType = viewType
        return copy;
    }
    
    def String getId() {
    	return props.get("id") as String
    }
    
}

interface ChildrenProc {
	def void apply(LatteView view);
}