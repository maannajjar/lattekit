package databinding.util

import android.databinding.tool.util.GenerationalClassUtil
import java.io.Serializable
import java.util.*

/**
 * Created by maan on 4/27/16.
 */

object AndroidSetterStore {
    var store = IntermediateV2()

    fun init() {
        val stores = GenerationalClassUtil.loadObjects<Serializable>(GenerationalClassUtil.ExtensionFilter.SETTER_STORE)
        for (intermediate in stores) {
            var intermediate = readObject(intermediate) as IntermediateV2;
            merge(store, intermediate);
        }
    }


    fun readObject(fromObject: Any) : Any {
        if (fromObject is java.util.Map<*, *>) {
            var map = fromObject as Map<*,*>;
            var outMap = fromObject.javaClass.newInstance() as java.util.Map<Any, Any>;
            map.forEach { e ->  var (key, value) = e;
                outMap.put(readObject(key!!), readObject(value!!))
            }
            return outMap;
        } else if (fromObject is String) {
            return fromObject
        } else if (fromObject is Integer) {
            return fromObject
        }

        var realCls = fromObject.javaClass
        var outCls = Class.forName(this.javaClass.`package`.name+"."+realCls.simpleName);
        var outObject = outCls.newInstance()
        (outObject.javaClass.declaredFields+outObject.javaClass.superclass.declaredFields).forEach {
            var fromField = realCls.getField(it.name);
            fromField.isAccessible = true;
            it.isAccessible = true;
            if (fromField.type.isArray) {
                var outArray = it.get(outObject) as MutableList<Any>
                var fromArray = fromField.get(fromObject) as Array<Any>
                fromArray.forEachIndexed { i, any ->
                    outArray.add(readObject(any));
                }

            } else if (!fromField.type.isPrimitive) {
                var fromValue = fromField.get(fromObject);
                if (fromValue != null) {
                    it.set(outObject, readObject(fromField.get(fromObject)))
                }
            } else {
                it.set(outObject, fromField.get(fromObject))
            }
        }
        return outObject
    }


    private fun merge(store: IntermediateV2, dumpStore: IntermediateV2) {
        merge(store.adapterMethods, dumpStore.adapterMethods)
        merge(store.renamedMethods, dumpStore.renamedMethods)
        merge(store.conversionMethods, dumpStore.conversionMethods)
        store.multiValueAdapters.putAll(dumpStore.multiValueAdapters)
        store.untaggableTypes.putAll(dumpStore.untaggableTypes)
        merge<String, AccessorKey, InverseDescription>(store.inverseAdapters, dumpStore.inverseAdapters)
        merge<String, String, InverseDescription>(store.inverseMethods, dumpStore.inverseMethods)
    }

    private fun <K, V, D> merge(first: HashMap<K, HashMap<V, D>>, second: HashMap<K, HashMap<V, D>>) {
        for (key in second.keys) {
            val firstVals = first[key]
            val secondVals = second[key]
            if (firstVals == null) {
                first.put(key, secondVals!!)
            } else {
                for (key2 in secondVals!!.keys) {
                    if (!firstVals.containsKey(key2)) {
                        firstVals.put(key2, secondVals[key2]!!)
                    }
                }
            }
        }
    }

}

class IntermediateV2 {
    val adapterMethods = HashMap<String, HashMap<AccessorKey, MethodDescription>>()
    val renamedMethods = HashMap<String, HashMap<String, MethodDescription>>()
    val conversionMethods = HashMap<String, HashMap<String, MethodDescription>>()
    val untaggableTypes = HashMap<String, String>()
    val multiValueAdapters = HashMap<MultiValueAdapterKey, MethodDescription>()
    val inverseAdapters = HashMap<String, HashMap<AccessorKey, InverseDescription>>()
    val inverseMethods = HashMap<String, HashMap<String, InverseDescription>>()
}
class AccessorKey() {
    val viewType : String? = null;
    val valueType : String? = null
    override fun toString(): String {
        return "AK($viewType, $valueType)"
    }
}

class MultiValueAdapterKey() {
    val requireAll: Boolean? = null;
    val viewType: String? = null;
    var attributes: MutableList<String> = mutableListOf();
    var parameterTypes: MutableList<String> = mutableListOf();
    var attributeIndices = TreeMap<String, Int>()

    override fun equals(obj: Any?): Boolean {
        if (obj !is MultiValueAdapterKey) {
            return false
        }
        if (this.viewType != obj.viewType ||
                this.attributes.size != obj.attributes.size ||
                this.attributeIndices.keys != obj.attributeIndices.keys) {
            return false
        }

        for (i in this.attributes.indices) {
            val thatIndex = obj.attributeIndices[this.attributes[i]]
            val thisParameter = parameterTypes[i]
            val thatParameter = obj.parameterTypes[thatIndex!!]
            if (thisParameter != thatParameter) {
                return false
            }
        }
        return true
    }

}
open class MethodDescription() {
    val type: String? = null;
    val method: String? = null;
    val requiresOldValue: Boolean? = false;
    val isStatic: Boolean? = null;
    val componentClass: String? = null;
    override fun toString(): String {
        return "$type.$method()"
    }

}


class InverseDescription : MethodDescription() {
    val event: String? = null;
    override fun equals(obj: Any?): Boolean {
        if (!super.equals(obj) || obj !is InverseDescription) {
            return false
        }
        return event == obj.event
    }
    override fun hashCode(): Int {
        return mergedHashCode(type!!, method!!, event!!)
    }
    private fun mergedHashCode(vararg objects: Any): Int {
        return Arrays.hashCode(objects)
    }
}
