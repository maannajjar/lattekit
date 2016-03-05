package io.lattekit.ui.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.common.base.Objects;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import io.lattekit.util.Util;

/**
 * Created by maan on 2/7/16.
 */
@SuppressWarnings("all")
public class ViewPager extends NativeView {
    public static class PagerFragment extends Fragment {
        private static Map<String, LatteView> SAVED_OBJECTS = CollectionLiterals.<String, LatteView>newHashMap();

        private LatteView templateView;

        public static ViewPager.PagerFragment newInstance(final LatteView template) {
            double _random = Math.random();
            String _plus = ("" + Double.valueOf(_random));
            long _currentTimeMillis = System.currentTimeMillis();
            String myId = (_plus + Long.valueOf(_currentTimeMillis));
            Bundle args = new Bundle();
            args.putString("_LATTE_KIT_OBJ_ID", myId);
            ViewPager.PagerFragment.SAVED_OBJECTS.put(myId, template);
            ViewPager.PagerFragment instance = new ViewPager.PagerFragment();
            instance.setArguments(args);
            return instance;
        }

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle _arguments = this.getArguments();
            String _string = _arguments.getString("_LATTE_KIT_OBJ_ID");
            LatteView _get = ViewPager.PagerFragment.SAVED_OBJECTS.get(_string);
            this.templateView = _get;
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
            FragmentActivity _activity = this.getActivity();
            return this.templateView.buildView(_activity, lp);
        }
    }

    private FragmentPagerAdapter adapter;

    public List<?> getData() {
        Object _get = this.getProps().get("data");
        return ((List<?>) _get);
    }


    @Override
    public void applyProps(@NotNull Map<String, ? extends Object> applyTo) {
        super.applyProps(applyTo);
    }

    @Override
    public Class<? extends View> getViewClass() {
        return android.support.v4.view.ViewPager.class;
    }

    @Override
    public void onViewMounted() {
        View _androidView = this.getAndroidView();
        int _makeResId = Util.makeResId("io.lattekit", "id", "viewPager");
        _androidView.setId(_makeResId);
        FragmentManager _supportFragmentManager = ((FragmentActivity) this.getActivity()).getSupportFragmentManager();
        this.adapter = new FragmentPagerAdapter(_supportFragmentManager) {
            @Override
            public int getCount() {
                List<?> _data = ViewPager.this.getData();
                return _data.size();
            }

            @Override
            public Fragment getItem(final int position) {
                try {
                    List<?> _data = ViewPager.this.getData();
                    Object item = _data.get(position);
                    int defaultView = (-1);
                    int selectedTemplate = (-1);
                    int _size = ViewPager.this.getChildren().size();
                    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
                    for (final Integer i : _doubleDotLessThan) {
                        {
                            LatteView child = ViewPager.this.getChildren().get((i).intValue());
                            Boolean _isMatch = ViewPager.this.isMatch(child, item, position);
                            if ((_isMatch).booleanValue()) {
                                selectedTemplate = (i).intValue();
                            }
                            boolean _or = false;
                            Object _get = child.getProps().get("defaultView");
                            boolean _equals = Objects.equal(_get, Boolean.valueOf(true));
                            if (_equals) {
                                _or = true;
                            } else {
                                Object _get_1 = child.getProps().get("defaultView");
                                boolean _equals_1 = Objects.equal(_get_1, "true");
                                _or = _equals_1;
                            }
                            if (_or) {
                                defaultView = (i).intValue();
                            }
                        }
                    }
                    if (((defaultView == (-1)) && (selectedTemplate == (-1)))) {
                        throw new Exception(("Couldn\'t find template for psoition " + Integer.valueOf(position)));
                    } else {
                        if ((selectedTemplate == (-1))) {
                            selectedTemplate = defaultView;
                        }
                    }
                    LatteView _get = ViewPager.this.getChildren().get(selectedTemplate);
                    LatteView template = _get.copy();
                    template.getProps().put("modelIndex", Integer.valueOf(position));
                    template.getProps().put("model", item);
                    template.setParentView(ViewPager.this);
                    return ViewPager.PagerFragment.newInstance(template);
                } catch (Throwable _e) {
                    throw Exceptions.sneakyThrow(_e);
                }
            }
        };
        View _androidView_1 = this.getAndroidView();
        android.support.v4.view.ViewPager view = ((android.support.v4.view.ViewPager) _androidView_1);
        view.setAdapter(this.adapter);
        this.adapter.notifyDataSetChanged();
        super.onViewMounted();
    }

    public Boolean isMatch(final LatteView template, final Object item, final int position) {
        try {
            boolean _xblockexpression = false;
            {
                Object testLambda = template.getProps().get("when");
                boolean _equals = Objects.equal(testLambda, null);
                if (_equals) {
                    return Boolean.valueOf(false);
                }
                if (((!(testLambda instanceof Function1)) && (!(testLambda instanceof Function2)))) {
                    return Boolean.valueOf(false);
                }
                boolean isFn2 = (testLambda instanceof Function2);
                Class<?> _class = testLambda.getClass();
                Type[] _genericInterfaces = _class.getGenericInterfaces();
                Type _get = _genericInterfaces[0];
                Type[] _actualTypeArguments = ((ParameterizedType) _get).getActualTypeArguments();
                Type _get_1 = _actualTypeArguments[0];
                Class modelType = ((Class) _get_1);
                Class<?> _class_1 = item.getClass();
                boolean _isAssignableFrom = modelType.isAssignableFrom(_class_1);
                if (_isAssignableFrom) {
                    Class<?> secondParamType = null;
                    if (isFn2) {
                        Class<?> _class_2 = testLambda.getClass();
                        Type[] _genericInterfaces_1 = _class_2.getGenericInterfaces();
                        Type _get_2 = _genericInterfaces_1[0];
                        Type[] _actualTypeArguments_1 = ((ParameterizedType) _get_2).getActualTypeArguments();
                        Type _get_3 = _actualTypeArguments_1[1];
                        secondParamType = ((Class) _get_3);
                        boolean _isAssignableFrom_1 = secondParamType.isAssignableFrom(Integer.class);
                        boolean _not = (!_isAssignableFrom_1);
                        if (_not) {
                            String _name = secondParamType.getName();
                            String _plus = ("Warning: second parameter\'s type is " + _name);
                            String _plus_1 = (_plus + ". It must be an integer which will contain model index");
                            LatteView.log(_plus_1);
                            return Boolean.valueOf(false);
                        }
                    }
                    Boolean _xifexpression = null;
                    if ((!isFn2)) {
                        Boolean _xblockexpression_1 = null;
                        {
                            Class<?> _class_3 = testLambda.getClass();
                            Method m = _class_3.getMethod("apply", modelType);
                            m.setAccessible(true);
                            Object _invoke = m.invoke(testLambda, item);
                            _xblockexpression_1 = ((Boolean) _invoke);
                        }
                        _xifexpression = _xblockexpression_1;
                    } else {
                        Boolean _xblockexpression_2 = null;
                        {
                            Class<?> _class_3 = testLambda.getClass();
                            Method m = _class_3.getMethod("apply", modelType, secondParamType);
                            m.setAccessible(true);
                            Object _invoke = m.invoke(testLambda, item, Integer.valueOf(position));
                            _xblockexpression_2 = ((Boolean) _invoke);
                        }
                        _xifexpression = _xblockexpression_2;
                    }
                    Boolean isMatch = _xifexpression;
                    return isMatch;
                } else {
                    Class<?> _class_3 = item.getClass();
                    String _name_1 = _class_3.getName();
                    String _plus_2 = ("Warning: model of type " + _name_1);
                    String _plus_3 = (_plus_2 + " is not assignable to ");
                    String _plus_4 = (_plus_3 + modelType);
                    LatteView.log(_plus_4);
                }
                _xblockexpression = false;
            }
            return Boolean.valueOf(_xblockexpression);
        } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
        }
    }
}
