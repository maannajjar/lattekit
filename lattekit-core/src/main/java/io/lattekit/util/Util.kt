package io.lattekit.util


import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import java.io.Serializable

import java.util.HashMap

object Util {

    private var HAS_KOTLIN: Boolean? = null

    fun makeResId(packageName: String, type: String, entryName: String): Int {
        val x = 0
        return packageName.hashCode() + 1 shl 24 or (type.hashCode() + 1 and 0xFF shl 16) or (entryName.hashCode() and 0xFFFF)
    }

    fun props(vararg objects: Any): Map<String, Any> {
        val map = HashMap<String, Any>(objects.size / 2)
        var i = 0
        while (i < objects.size) {
            map.put(objects[i] as String, objects[i + 1])
            i += 2
        }
        return map
    }

    fun hasKotlin(): Boolean {
        if (HAS_KOTLIN != null) {
            return HAS_KOTLIN!!
        }
        try {
            Class.forName("kotlin.jvm.functions.Function0")
            HAS_KOTLIN = true
        } catch (cnfe: ClassNotFoundException) {
            HAS_KOTLIN = false
        }

        return HAS_KOTLIN!!
    }

    fun toBundle(map: Map<String, *>, out: Bundle): Boolean {
        val bundle = out
        var hasInvalidValues = false;
        map.forEach { var (key, value) = it
            if (value is Boolean) {
                bundle.putBoolean(key,value)
            } else if (value is String?) {
                bundle.putString(key,value)
            } else if (value is Int) {
                bundle.putInt(key,value)
            } else if (value is Byte) {
                bundle.putByte(key,value)
            } else if (value is Short) {
                bundle.putShort(key,value)
            } else if (value is Long) {
                bundle.putLong(key,value)
            } else if (value is Double) {
                bundle.putDouble(key,value)
            } else if (value is Char) {
                bundle.putChar(key,value)
            } else if (value is CharArray?) {
                bundle.putCharArray(key,value)
            } else if (value is Float) {
                bundle.putFloat(key,value)
            } else if (value is Parcelable?) {
                bundle.putParcelable(key,value)
            } else if (value is Serializable?) {
                bundle.putSerializable(key,value)
            } else {
                hasInvalidValues = true;
                Log.d("Latte","${key} cannot be serialized")
            }
        }
        return hasInvalidValues
    }

    fun toMap(bundle :Bundle) : MutableMap<String,Any?> {
        var map = mutableMapOf<String,Any?>();
        for (key in bundle.keySet()) {
            map.put(key, bundle.get(key));
        }
        return map;
    }
}
