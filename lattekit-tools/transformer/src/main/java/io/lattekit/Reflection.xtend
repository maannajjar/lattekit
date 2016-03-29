package io.lattekit

import java.io.File
import java.util.HashMap
import java.util.ArrayList
import java.net.URLClassLoader
import java.util.List
import java.lang.reflect.Method
import java.net.URL

/**
 * Created by maan on 3/19/16.
 */
public class Reflection {
    static var LOOKUP_CACHE = new HashMap<String, Class>();
    static var URLClassLoader CLASSLOADER;

    static def loadJar(String filePath) {
        if (CLASSLOADER == null) {
            CLASSLOADER = new URLClassLoader(#[], Reflection.classLoader)
        }
        var file = new File(filePath)
        try {
            var method = URLClassLoader.getDeclaredMethod("addURL", #[URL]);
            method.setAccessible(true);
            method.invoke(CLASSLOADER, #[file.toURL()]);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    static def Class lookupClass(extension ClassLoader loader, String className) {
        var clazz = if (className.contains("."))  {
            try {
                var cls = Class.forName(className,false,loader)
                LOOKUP_CACHE.put(className, cls);
                cls
            } catch (ClassNotFoundException cnfe) {
                return null;
            }

        } else {
            var fullClass = if (className == "View") {
                "android.view.View"
            } else {
                "android.widget." + className
            }
            try {
                var cls = Class.forName(fullClass,false,loader)
                LOOKUP_CACHE.put(className, cls);
                cls
            } catch (ClassNotFoundException cnfe) {
                return null;
            }
        }
        return clazz
    }

    static def loadAndroidSdk(String path, String version) {
        loadJar(path+"/platforms/"+version+"/android.jar")
        loadJar(path+"/extras/android/support/v4/android-support-v4.jar")
        loadJar(path+"/extras/android/support/v7/recyclerview/libs/android-support-v7-recyclerview.jar")
        loadJar(path+"/extras/android/support/v7/appcompat/libs/android-support-v7-appcompat.jar")
    }

    static def Class lookupClass(String className) {
        var cachedCls = LOOKUP_CACHE.get(className);
        if (cachedCls != null) {
            return cachedCls;
        }
        var cls = CLASSLOADER.lookupClass(className)
        if (cls != null) {
            return cls;
        }
        return null;
    }

    static def List<Method> findGetterMethods(Class clazz, String fnName) {
        var reachedEnd = false;
        var currentCls = clazz;
        val results = new ArrayList<Method>()
        while(!reachedEnd) {
            results += currentCls.declaredMethods.filter[ name == fnName  && it.parameterCount == 0]
            currentCls = currentCls.superclass
            if (currentCls == Object) {
                reachedEnd = true;
            }
        }
        return results;
    }


    static def List<Method> findMethods(Class clazz, String fnName) {
        var reachedEnd = false;
        var currentCls = clazz;
        val results = new ArrayList<Method>()
        while(!reachedEnd) {
            results += currentCls.declaredMethods.filter[ name == fnName  && it.parameterCount == 1]
            currentCls = currentCls.superclass
            if (currentCls == Object) {
                reachedEnd = true;
            }
        }
        return results;
    }

}