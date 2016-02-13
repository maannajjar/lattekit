package io.lattekit.ui.view

import android.support.v4.app.FragmentPagerAdapter
import java.util.List
import android.support.v4.app.Fragment
import java.util.Map
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.xtext.xbase.lib.Functions.Function2
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2
import java.lang.reflect.ParameterizedType
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.support.v4.app.FragmentActivity
import io.lattekit.util.Util
import android.widget.TextView

/**
 * Created by maan on 2/7/16.
 */
class ViewPager extends NativeView {

    var FragmentPagerAdapter adapter;

    def List<?> getData() {
        props.get("data") as List<?>;
    }

    override applyProps() {
        super.applyProps()
        if (RENDER_TARGET == ANDROID) {
            adapter.notifyDataSetChanged
        }
    }

    override getViewClass() {
        return android.support.v4.view.ViewPager
    }

    override onViewMounted() {
        androidView.id = Util.makeResId("io.lattekit","id","viewPager")

        adapter = new FragmentPagerAdapter((activity as FragmentActivity).getSupportFragmentManager()) {
            override getCount() { data.size }
            override getItem(int position) {
                var item = data.get(position)

                var int defaultView = -1;
                var int selectedTemplate = -1
                for (i : 0..<children.size) {
                    var child = children.get(i);
                    if (isMatch(child, item,position)) {
                        selectedTemplate = i;
                    }
                    if (child.props.get("defaultView") == true || child.props.get("defaultView") == "true") {
                        defaultView = i;
                    }
                }

                if (defaultView == -1 && selectedTemplate == -1) {
                    throw new Exception("Couldn't find template for psoition "+position);
                } else if (selectedTemplate == -1)  {
                    selectedTemplate = defaultView;
                }

                var template = children.get(selectedTemplate).copy();
                template.props.put("modelIndex", position);
                template.props.put("model", item);
                template.parentView = ViewPager.this
                template.stylesheet = ViewPager.this.stylesheet

                return PagerFragment.newInstance(template);
            }

        }

        var view = androidView as android.support.v4.view.ViewPager;
        view.adapter = adapter;
        adapter.notifyDataSetChanged
        super.onViewMounted()
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
                    log("Warning: second parameter's type is "+ secondParamType.name +". It must be an integer which will contain model index")
                    return false;
                }
            }
            var isMatch = if (!isFn2) {
                var m = testLambda.class.getMethod("apply",modelType);
                m.setAccessible(true);
                m.invoke(testLambda,item) as Boolean;
            } else {
                var m = testLambda.class.getMethod("apply",modelType,secondParamType)
                m.setAccessible(true);
                m.invoke(testLambda,item,position) as Boolean;
            }
            return isMatch;
        } else {
            log("Warning: model of type "+item.class.name +" is not assignable to "+ modelType)
        }
        false;
    }

    static class PagerFragment extends Fragment {
        static Map<String,LatteView> SAVED_OBJECTS = newHashMap();
        LatteView templateView;

        def static newInstance(LatteView template) {
            var myId = ""+Math.random()+System.currentTimeMillis()
            var args = new Bundle();
            args.putString("_LATTE_KIT_OBJ_ID",myId)
            SAVED_OBJECTS.put(myId,template)
            var instance = new PagerFragment();
            instance.setArguments(args);
            return instance;
        }


        override onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            templateView = SAVED_OBJECTS.get(getArguments().getString("_LATTE_KIT_OBJ_ID"));
        }
        override onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            var lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);
            return templateView.buildView(activity,lp);
        }

    }
}