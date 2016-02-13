package io.lattekit.ui.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.BaseAdapter
import android.widget.FrameLayout
import java.lang.reflect.ParameterizedType
import java.util.List
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.xtext.xbase.lib.Functions.Function2
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2
import android.app.Activity
import io.lattekit.util.Util

class ListView extends NativeView implements OnItemClickListener {
		
	var BaseAdapter adapter = new BaseAdapter() {
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



		override getView(int position, View convertView, ViewGroup parent) {
			var type = getItemViewType(position);
			log("Getting item "+getItem(position))
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
			template.parentView = ListView.this
			template.stylesheet = ListView.this.stylesheet
			var lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.WRAP_CONTENT);
			var v = template.buildView(activity,lp)
			v.setTag = template;
			return v;
		}

	}


	def List<?> getData() {
		props.get("data") as List<?>;
	}
	
	
	def getDividerHeight() {
		if (this.props.containsKey("dividerHeight")) {
			return this.props.get("dividerHeight") as Integer
		}
		return 0;
	}

	def isMatch(LatteView template, Object item,int position) {
		var testLambda = template.props.get("when");
		if (testLambda == null) {
			return false;
		}
		if ( (!(testLambda instanceof Function1) && !(testLambda instanceof Function2))
			&& (!(Util.hasKotlin() && testLambda instanceof kotlin.jvm.functions.Function1) && !(Util.hasKotlin() && testLambda instanceof kotlin.jvm.functions.Function2)))
		{
			// TODO: Warn about wrong "when" variable
			return false;
		}
		var isFn2 = testLambda instanceof Function2 || testLambda instanceof kotlin.jvm.functions.Function2
		var isKotlin = Util.hasKotlin() &&  (testLambda instanceof kotlin.jvm.functions.Function2 || testLambda instanceof kotlin.jvm.functions.Function1)
		var modelType = (testLambda.getClass().genericInterfaces.get(0) as ParameterizedType).actualTypeArguments.get(0) as Class

		if (modelType.isAssignableFrom(item.class)) {
			var Class<?> secondParamType;
			if (isFn2) {
				secondParamType =(testLambda.getClass().genericInterfaces.get(0) as ParameterizedType).actualTypeArguments.get(1) as Class;
				if (!secondParamType.isAssignableFrom(Integer)) {
					log("Warning: second parameter's type is "+ secondParamType.name +". It must be an integer which will contain model index")
					return false;
				}
			}
			var isMatch = if (!isFn2) {
				var m = if (isKotlin) testLambda.class.getMethod("invoke",modelType) else testLambda.class.getMethod("apply",modelType);
				m.setAccessible(true);
				m.invoke(testLambda,item) as Boolean;
			} else {
				var m = if (isKotlin) testLambda.class.getMethod("invoke",modelType,typeof(int)) else testLambda.class.getMethod("apply",modelType,secondParamType)
				m.setAccessible(true);
				m.invoke(testLambda,item,position) as Boolean;
			}
			return isMatch;
		} else {
			log("Warning: model of type "+item.class.name +" is not assignable to "+ modelType)
		}
		false;
	}

	def getLatteView(int position) {
		var type = adapter.getItemViewType(position);
		log("Getting item "+ adapter.getItem(position))
		var template = children.get(type);
		template = template.copy();
		template.props.put("modelIndex", position);
		template.props.put("model", adapter.getItem(position));
		template.parentView = ListView.this
		template.stylesheet = ListView.this.stylesheet
		template.buildView(new Activity(),null);
		return template;
	}

	override applyProps() {
		super.applyProps()
		if (RENDER_TARGET == ANDROID) {
			var view = androidView as android.widget.ListView;
			if(dividerHeight != null) {
				view.dividerHeight = dividerHeight;
			}
			if(props.get("onItemClickListener") != null) {
				view.onItemClickListener = props.get("onItemClickListener")  as OnItemClickListener;
			} else {
				view.onItemClickListener = this;
			}

			view.adapter = adapter;
			adapter.notifyDataSetChanged
		} else {
			this.renderedViews = newArrayList();
			this.data.forEach([item, index |
				this.renderedViews += getLatteView(index);
			])
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
			log("Warning "+paramType +" is not the same as "+obj.class)
			return;
		}
		if (handlerLambda instanceof Procedure1) {
			handlerLambda.apply(obj);
		} else if (handlerLambda instanceof Procedure2) {
			handlerLambda.apply(obj, position);
		} else if (handlerLambda instanceof Function1) {
			handlerLambda.apply(obj);
		} else if (handlerLambda instanceof Function2) {
			handlerLambda.apply(obj, position);
		} else if (handlerLambda instanceof kotlin.jvm.functions.Function2) {
			handlerLambda.invoke(obj, position);
		} else if (handlerLambda instanceof kotlin.jvm.functions.Function1) {
			handlerLambda.invoke(obj);
		}  else {
			log("Warning: onItemClick should have parameters ("+paramType+",(optional)int) ")
			// TODO: Warn about wrong "onItemClick" variable
			return;			
		}	
	}
	
	override getViewClass() {
		return android.widget.ListView;
	}

	
}