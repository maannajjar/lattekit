package io.lattekit.ui.view

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import java.lang.reflect.ParameterizedType
import java.util.List
import org.eclipse.xtext.xbase.lib.Functions.Function1

class ListView extends LatteView<android.widget.ListView>  {
	
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
				if (isMatch(child, item)) {
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
		
		def isMatch(LatteView<?> template, Object item) {
			var testLambda = template.attributes.get("when");
			if (testLambda == null) {
				return false;
			}
			if (!(testLambda instanceof Function1)) {
				// TODO: Warn about wrong "when" variable
				return false;
			}
			var modelType = (testLambda.getClass().genericInterfaces.get(0) as ParameterizedType).actualTypeArguments.get(0) as Class
			if (modelType.isAssignableFrom(item.class)) {
				var isMatch = testLambda.class.getMethod("apply",modelType).invoke(testLambda,item) as Boolean;
				Log.d("Latte","Results = "+isMatch)
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
				template.render();
				template.handleStateChanged();
				return convertView;
			}
			template = template.copy();
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