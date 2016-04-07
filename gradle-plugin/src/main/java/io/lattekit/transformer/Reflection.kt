package io.lattekit.transformer

import com.google.common.base.Objects
import com.google.common.collect.Iterables
import org.eclipse.xtext.xbase.lib.*
import java.io.File
import java.lang.reflect.Method
import java.net.URL
import java.net.URLClassLoader
import java.util.*

/**
 * Created by maan on 4/1/16.
 */
@SuppressWarnings("all")
object Reflection {
    private val LOOKUP_CACHE = HashMap<String, Class<*>>()

    private var CLASSLOADER: URLClassLoader? = null

    fun loadJar(filePath: String) {
        if (CLASSLOADER == null) {
            CLASSLOADER =  URLClassLoader(emptyArray(), Reflection::class.java.classLoader)
        }
        var file = File(filePath)
        try {
            var method = URLClassLoader::class.java.getDeclaredMethod("addURL", URL::class.java);
            method.setAccessible(true);
            method.invoke(CLASSLOADER, file.toURL());
        } catch ( t : Throwable) {
            t.printStackTrace();
        }
    }

    fun lookupClass(@Extension loader: ClassLoader, className: String): Class<*>? {
        var _xifexpression: Class<*>? = null
        val _contains = className.contains(".")
        if (_contains) {
            var _xtrycatchfinallyexpression: Class<*>? = null
            try {
                var _xblockexpression: Class<*>? = null
                run {
                    val cls = Class.forName(className, false, loader)
                    Reflection.LOOKUP_CACHE.put(className, cls)
                    _xblockexpression = cls
                }
                _xtrycatchfinallyexpression = _xblockexpression
            } catch (_t: Throwable) {
                if (_t is ClassNotFoundException) {
                    return null
                } else {
                    throw Exceptions.sneakyThrow(_t)
                }
            }

            _xifexpression = _xtrycatchfinallyexpression
        } else {
            var _xblockexpression_1: Class<*>? = null
            run {
                var _xifexpression_1: String? = null
                val _equals = Objects.equal(className, "View")
                if (_equals) {
                    _xifexpression_1 = "android.view.View"
                } else {
                    _xifexpression_1 = "android.widget." + className
                }
                val fullClass = _xifexpression_1
                var _xtrycatchfinallyexpression_1: Class<*>? = null
                try {
                    var _xblockexpression_2: Class<*>? = null
                    run {
                        val cls = Class.forName(fullClass, false, loader)
                        Reflection.LOOKUP_CACHE.put(className, cls)
                        _xblockexpression_2 = cls
                    }
                    _xtrycatchfinallyexpression_1 = _xblockexpression_2
                } catch (_t_1: Throwable) {
                    if (_t_1 is ClassNotFoundException) {
                        return null
                    } else {
                        throw Exceptions.sneakyThrow(_t_1)
                    }
                }

                _xblockexpression_1 = _xtrycatchfinallyexpression_1
            }
            _xifexpression = _xblockexpression_1
        }
        val clazz = _xifexpression
        return clazz
    }

    fun loadAndroidSdk(path: String, version: String)  {
        println("LOADING $path/platforms/$version/android.jar")
        Reflection.loadJar("$path/platforms/$version/android.jar")
        Reflection.loadJar(path + "/extras/android/support/v4/android-support-v4.jar")
        Reflection.loadJar(path + "/extras/android/support/v7/recyclerview/libs/android-support-v7-recyclerview.jar")
        Reflection.loadJar(path + "/extras/android/support/v7/appcompat/libs/android-support-v7-appcompat.jar")
    }

    fun lookupClass(className: String): Class<*>? {
        val cachedCls = Reflection.LOOKUP_CACHE[className]
        if (cachedCls != null) {
            return cachedCls
        }
        val cls = Reflection.lookupClass(Reflection.CLASSLOADER!!, className)
        if (cls != null) {
            return cls
        }
        return null
    }

    fun findGetterMethods(clazz: Class<*>, fnName: String): List<Method> {
        var reachedEnd = false
        var currentCls: Class<*> = clazz
        val results = ArrayList<Method>()
        while (!reachedEnd) {
            run {
                val _declaredMethods = currentCls.declaredMethods
                val _function = Functions.Function1<java.lang.reflect.Method, kotlin.Boolean> { it ->
                    var _and = false
                    val _name = it.name
                    val _equals = Objects.equal(_name, fnName)
                    if (!_equals) {
                        _and = false
                    } else {
                        val _parameterCount = it.parameterCount
                        val _equals_1 = _parameterCount == 0
                        _and = _equals_1
                    }
                    java.lang.Boolean.valueOf(_and)
                }
                val _filter = IterableExtensions.filter(Conversions.doWrapArray(_declaredMethods) as Iterable<Method>, _function)
                Iterables.addAll(results, _filter)
                val _superclass = currentCls.superclass
                currentCls = _superclass
                val _equals = Objects.equal(currentCls, Any::class.java)
                if (_equals) {
                    reachedEnd = true
                }
            }
        }
        return results
    }

    fun findMethods(clazz: Class<*>, fnName: String): List<Method> {
        var reachedEnd = false
        var currentCls: Class<*> = clazz
        val results = ArrayList<Method>()
        while (!reachedEnd) {
            run {
                val _declaredMethods = currentCls.declaredMethods
                val _function = Functions.Function1<java.lang.reflect.Method, kotlin.Boolean> { it ->
                    var _and = false
                    val _name = it.name
                    val _equals = Objects.equal(_name, fnName)
                    if (!_equals) {
                        _and = false
                    } else {
                        val _parameterCount = it.parameterCount
                        val _equals_1 = _parameterCount == 1
                        _and = _equals_1
                    }
                    java.lang.Boolean.valueOf(_and)
                }
                val _filter = IterableExtensions.filter(Conversions.doWrapArray(_declaredMethods) as Iterable<Method>, _function)
                Iterables.addAll(results, _filter)
                val _superclass = currentCls.superclass
                currentCls = _superclass
                val _equals = Objects.equal(currentCls, Any::class.java)
                if (_equals) {
                    reachedEnd = true
                }
            }
        }
        return results
    }
}
