package io.lattekit

import sun.rmi.rmic.iiop.ClassPathLoader
import java.io.File
import java.net.URLClassLoader
import java.util.*

/**
 * Created by maan on 3/19/16.
 */

object Reflection {
    var JARS = ArrayList<ClassPathLoader>();

    fun loadJar(filePath : String) {
        var file = File(filePath)
        var child = URLClassLoader(file.toURL(), this.);

    }
}