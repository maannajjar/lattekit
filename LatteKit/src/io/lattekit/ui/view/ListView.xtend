package io.lattekit.ui.view

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.BaseAdapter
import java.lang.reflect.ParameterizedType
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.xtext.xbase.lib.Functions.Function2
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2

class ListView extends LatteView<android.widget.ListView> implements OnItemClickListener {
	
	@Accessors Integer dividerHeight;
	
	
	var adapter = new BaseAdapter() {
		
		override getCount() { data.size }		
		override getItem(int position) { data.get(position); }
		override getItemId(int position) { position }
		override getViewTypeCount() { children.size }
		
		override getItemViewType(int position) {
			var item = getItem(position);
			
			var int defaultView = -1;
			for (i : 0..<children.size) {
				var child = children.get(i);
				if (isMatch(child, item,position)) {
					return i;
				}
				if (child.attributes.get("defaultView") == true || child.attributes.get("defaultView") == "true") {
					defaultView = i;
				}
			}
			
			if (defaultView == -1) {
				throw new Exception("Couldn't find template matching for item "+position);
			}
			return defaultView;
		}
		
		def isMatch(LatteView<?> template, Object item,int position) {
			var testLambda = template.attributes.get("when");
			if (testLambda == null) {
				return false;
			}
			
			if (!(testLambda instanceof Function1) && !(testLambda instanceof Function2)) {
				// TODO: Warn about wrong "when" variable
				return false;
			}
			var isFn2 = testLambda instanceof Function2 
			var modelType = (testLambda.getClass().genericInterfaces.get(0) as ParameterizedType).actualTypeArguments.get(0) as Class
			
			if (modelType.isAssignableFrom(item.class)) {
				var Class<?> secondParamType;
				if (isFn2) {
					secondParamType =(testLambda.getClass().genericInterfaces.get(0) as ParameterizedType).actualTypeArguments.get(1) as Class;
					if (!secondParamType.isAssignableFrom(Integer)) {
						Log.d("Latte", "Warning: second parameter's type is "+ secondParamType.name +". It must be an integer which will contain model index")
						return false;
					}
				}	
				var isMatch = if (!isFn2) {
					testLambda.class.getMethod("apply",modelType).invoke(testLambda,item) as Boolean;
				} else {
					testLambda.class.getMethod("apply",modelType,secondParamType).invoke(testLambda,item,position) as Boolean;
				}
				return isMatch;
			} else {
				Log.d("Latte", "Warning: model of type "+item.class.name +" is not assignable to "+ modelType)
			}
			false;
		}
		
		override getView(int position, View convertView, ViewGroup parent) {
			var type = getItemViewType(position);
			var template = children.get(type);
			if (convertView != null) {
				template = convertView.getTag() as LatteView;
				template.setAttribute("model", getItem(position));
				template.setAttribute("modelIndex", position);
				template.onStateChanged();
				return convertView;
			}
			template = template.copy();
			template.setAttribute("modelIndex", position);
			template.setAttribute("model", getItem(position));
			template.render();
			var v = template.buildView(activity)
			v.setTag = template;
			return v;
		}

	}
	
	override void renderChildren() {
		// Do nothing. Children here are just used for templates and not rendering real views
	}
	
	
	def void setData(List<?> data) {
		attributes.put("data",data);
		if (isMounted()) {
			adapter.notifyDataSetChanged
		}
	}
	
	def List<?> getData() {
		attributes.get("data") as List<?>;
	}
	

	override applyAttributes() {
		super.applyAttributes()
		var view = androidView as android.widget.ListView;
		if (dividerHeight != null) {
			view.dividerHeight = dividerHeight;	
		}
		if (attributes.get("onItemClickListener") != null) {
			view.onItemClickListener = attributes.get("onItemClickListener")  as OnItemClickListener;
		} else {
			view.onItemClickListener = this;	
		}
	}
	
	override onItemClick(AdapterView<?> parent, View view, int position, long id) {
		var handlerLambda = attributes.get("onItemClick");
		if (handlerLambda == null) {
			return
		}
		var obj = adapter.getItem(position);
		var paramType = (handlerLambda.getClass().genericInterfaces.get(0) as ParameterizedType).actualTypeArguments.get(0) as Class
		if (!paramType.isAssignableFrom(obj.class)) {
			// TODO: warn about wrong param type
			return;
		}
		if (handlerLambda instanceof Procedure1) {
			handlerLambda.apply(obj);
		} else if (handlerLambda instanceof Procedure2) {
			handlerLambda.apply(obj, position);
		} else {
			// TODO: Warn about wrong "onItemClick" variable
			return;			
		}
		
		
	}
	
	override View createAndroidView(Context a) {
		return new android.widget.ListView(a);
	}
	
	override createLayoutParams(int width, int height) {
		null;
	}
	
	override onViewRendered() {
		adapter.notifyDataSetChanged
	}
	
	override onViewMounted() {
		nativeView.adapter = adapter;
	}
	
}