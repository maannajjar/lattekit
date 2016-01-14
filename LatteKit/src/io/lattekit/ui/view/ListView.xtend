package io.lattekit.ui.view

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.BaseAdapter
import android.widget.FrameLayout
import java.lang.reflect.ParameterizedType
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.xtext.xbase.lib.Functions.Function2
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2
import java.util.Map

class ListView extends NativeView implements OnItemClickListener {
	
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
				if (child.props.get("defaultView") == true || child.props.get("defaultView") == "true") {
					defaultView = i;
				}
			}
			
			if (defaultView == -1) {
				throw new Exception("Couldn't find template matching for item "+position);
			}
			return defaultView;
		}
		
		def isMatch(LatteView template, Object item,int position) {
			var testLambda = template.props.get("when");
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
			Log.d("Latte","Getting item "+getItem(position))
			var template = children.get(type);
			if (convertView != null) {
				template = convertView.getTag() as LatteView;
				template.props.put("model", getItem(position));
				template.props.put("modelIndex", position);
				template.onStateChanged();
				return convertView;
			}
			
			template = template.copy();
			template.props.put("modelIndex", position);
			template.props.put("model", getItem(position));
			var lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT); 
			var v = template.buildView(activity,lp)
			v.setTag = template;
			return v;
		}

	}
			
	def List<?> getData() {
		props.get("data") as List<?>;
	}
	

	override applyProps() {
		super.applyProps()
		var view = androidView as android.widget.ListView;
		if (dividerHeight != null) {
			view.dividerHeight = dividerHeight;	
		}
		if (props.get("onItemClickListener") != null) {
			view.onItemClickListener = props.get("onItemClickListener")  as OnItemClickListener;
		} else {
			view.onItemClickListener = this;	
		}
	}
	
	override onItemClick(AdapterView<?> parent, View view, int position, long id) {
		var handlerLambda = props.get("onItemClick");
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
	
	override View renderNative(Context a) {
		return new android.widget.ListView(a);
	}

	override onViewMounted() {
		super.onViewMounted()
		(androidView as android.widget.ListView).adapter = adapter;
		adapter.notifyDataSetChanged
	}
	
	override onWillReceiveProps(Map<String, Object> props) {
		adapter.notifyDataSetChanged
	}
	
	
}