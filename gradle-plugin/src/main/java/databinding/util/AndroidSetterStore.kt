//package databinding.util
//
//import android.databinding.tool.reflection.ModelClass
//import android.databinding.tool.store.SetterStore
//import android.databinding.tool.util.GenerationalClassUtil
//import databinding.java.JavaAnalyzer
//import io.lattekit.parser.Prop
//import io.lattekit.transformer.Reflection
//import java.io.Serializable
//import java.util.*
//
///**
// * Created by maan on 4/27/16.
// */
//object AndroidSetterStore {
//    var store = IntermediateV2()
//    var classAnalyzer = JavaAnalyzer(Reflection.CLASSLOADER)
//    fun init() {
//        val stores = GenerationalClassUtil.loadObjects<Serializable>(GenerationalClassUtil.ExtensionFilter.SETTER_STORE)
//        var i = 0;
//        for (intermediate in stores) {
//            var intermediate = readObject(intermediate) as IntermediateV1;
//            merge(store, intermediate);
//        }
//    }
//
//
//
//    fun readObject(fromObject: Any) : Any {
//        if (fromObject is java.util.Map<*, *>) {
//            var map = fromObject as Map<*,*>;
//            var outMap = fromObject.javaClass.newInstance() as java.util.Map<Any, Any>;
//            map.forEach { e ->  var (key, value) = e;
//                outMap.put(readObject(key!!), readObject(value!!))
//            }
//            return outMap;
//        } else if (fromObject is String) {
//            return fromObject
//        } else if (fromObject is Integer) {
//            return fromObject
//        }
//
//        var realCls = fromObject.javaClass
//        var outCls = Class.forName(this.javaClass.`package`.name+"."+realCls.simpleName);
//        var outObject = outCls.newInstance()
//        (outObject.javaClass.declaredFields+outObject.javaClass.superclass.declaredFields).forEach {
//            var fromField = realCls.getField(it.name);
//            fromField.isAccessible = true;
//            it.isAccessible = true;
//            if (fromField.type.isArray) {
//                var outArray = it.get(outObject) as MutableList<Any>
//                var fromArray = fromField.get(fromObject) as Array<Any>
//                fromArray.forEachIndexed { i, any ->
//                    outArray.add(readObject(any));
//                }
//
//            } else if (!fromField.type.isPrimitive) {
//                var fromValue = fromField.get(fromObject);
//                if (fromValue != null) {
//                    it.set(outObject, readObject(fromField.get(fromObject)))
//                }
//            } else {
//                it.set(outObject, fromField.get(fromObject))
//            }
//        }
//        return outObject
//    }
//
//
//    private fun merge(store: IntermediateV1, dumpStore: IntermediateV1) {
//        merge(store.adapterMethods, dumpStore.adapterMethods)
//        merge(store.renamedMethods, dumpStore.renamedMethods)
//        merge(store.conversionMethods, dumpStore.conversionMethods)
//        store.multiValueAdapters.putAll(dumpStore.multiValueAdapters)
//        store.untaggableTypes.putAll(dumpStore.untaggableTypes)
//        if (store is IntermediateV2 && dumpStore is IntermediateV2) {
//            merge<String, AccessorKey, InverseDescription>(store.inverseAdapters, dumpStore.inverseAdapters)
//            merge<String, String, InverseDescription>(store.inverseMethods, dumpStore.inverseMethods)
//        }
//    }
//
//    private fun <K, V, D> merge(first: HashMap<K, HashMap<V, D>>, second: HashMap<K, HashMap<V, D>>) {
//        for (key in second.keys) {
//            val firstVals = first[key]
//            val secondVals = second[key]
//            if (firstVals == null) {
//                first.put(key, secondVals!!)
//            } else {
//                for (key2 in secondVals!!.keys) {
//                    if (!firstVals.containsKey(key2)) {
//                        println("First values doesn't contain $key2");
//                        println(firstVals.keys)
//                        firstVals.put(key2, secondVals[key2]!!)
//                    }
//                }
//            }
//        }
//    }
//
//
//    fun getMatchingMultiAttributeSetters(props: Array<Prop>, viewType : ModelClass) : List<MultiSetter>{
//
//        val results = mutableListOf<MultiSetter>()
//        for ( adapter in store.multiValueAdapters.keys) {
//            if (adapter.requireAll!! && adapter.attributes.size > props.size) {
//                continue;
//            }
//            var viewClass = classAnalyzer.findClass(adapter.viewType, null);
//            if (viewClass.isGeneric()) {
//                viewClass = viewClass.erasure();
//            }
//            if (!viewClass.isAssignableFrom(viewType)) {
//                continue;
//            }
//
//            var matchingAttributes = mutableListOf<String>();
//            var matchingProps = mutableListOf<Prop>()
//            var attrPropMapping = mutableMapOf<String,Prop>();
//            for (prop in props) {
//                var matchingAttribute = adapter.attributes.find { it == prop.namespace+":"+prop.propName || (prop.namespace == null && it.startsWith("android:") && it.substring("android:".length) == prop.propName) }
//                if (matchingAttribute != null) {
//                    matchingAttributes.add(matchingAttribute)
//                    matchingProps.add(prop);
//                    attrPropMapping.put(matchingAttribute, prop)
//                }
//            }
//            if ((adapter.requireAll && matchingAttributes.size == adapter.attributes.size) || (!adapter.requireAll && !matchingAttributes.isEmpty())) {
//                val method = store.multiValueAdapters.get(adapter);
//                var attrsTypes = matchingAttributes.map { adapter.parameterTypes[adapter.attributeIndices[it]!!] }
//                var result = MultiSetter(matchingAttributes,attrsTypes,matchingProps,attrPropMapping,adapter,method!!);
//                results.add(result);
//            }
//        }
//        return results;
//    }
//
//
//    fun getMatchingSetters(prop: Prop, viewType : ModelClass) : List<SingleSetter> {
//        var matchingAttributes = store.adapterMethods.filterKeys {  it == prop.namespace+":"+prop.propName || (prop.namespace == null && it.startsWith("android:") && it.substring("android:".length) == prop.propName) }
//        return matchingAttributes.map { var (attrName, adapters) = it;
//            var matchingAdapters = adapters.filterKeys {
//                var viewClass = classAnalyzer.findClass(it.viewType, null);
//                if (viewClass.isGeneric()) {
//                    viewClass = viewClass.erasure();
//                }
//                viewClass.isAssignableFrom(viewType)
//            }
//            matchingAdapters.map { SingleSetter(it.key,it.value, prop) }
//        }.flatten()
//    }
//}
//
//
//data class SingleSetter(val accessorKey: AccessorKey,
//                   val method: MethodDescription, var prop : Prop) {
//    var variable : String? = null;
//}
//
//
//data class MultiSetter(val matchingAttrs : List<String>,
//                       val attrTypes : List<String>,
//                       val matchingProps : List<Prop>,
//                       val attrPropsMapping : Map<String,Prop>,
//                        val adapterKey : MultiValueAdapterKey,
//                        val method: MethodDescription) {
//}
//
//interface Intermediate {
//
//}
//open class IntermediateV1 : Intermediate {
//    val adapterMethods = HashMap<String, HashMap<AccessorKey, MethodDescription>>()
//    val renamedMethods = HashMap<String, HashMap<String, MethodDescription>>()
//    val conversionMethods = HashMap<String, HashMap<String, MethodDescription>>()
//    val untaggableTypes = HashMap<String, String>()
//    val multiValueAdapters = HashMap<MultiValueAdapterKey, MethodDescription>()
//}
//class IntermediateV2 : IntermediateV1() {
//    val inverseAdapters = HashMap<String, HashMap<AccessorKey, InverseDescription>>()
//    val inverseMethods = HashMap<String, HashMap<String, InverseDescription>>()
//}
//class AccessorKey() {
//    var viewType : String? = null;
//    var valueType : String? = null
//
//    override fun toString(): String {
//        return "AK($viewType, $valueType)"
//    }
//
//    override fun hashCode(): Int {
//        return mergedHashCode(viewType!!, valueType!!)
//    }
//
//    override fun equals(other: Any?): Boolean {
//        if (other is AccessorKey) {
//            return viewType == other.viewType && valueType == other.valueType;
//        } else {
//            return false;
//        }
//    }
//
//
//}
//
//class MultiValueAdapterKey() {
//    val requireAll: Boolean? = null;
//    val viewType: String? = null;
//    var attributes: MutableList<String> = mutableListOf();
//    var parameterTypes: MutableList<String> = mutableListOf();
//    var attributeIndices = TreeMap<String, Int>()
//
//    override fun equals(obj: Any?): Boolean {
//        if (obj !is MultiValueAdapterKey) {
//            return false
//        }
//        if (this.viewType != obj.viewType ||
//                this.attributes.size != obj.attributes.size ||
//                this.attributeIndices.keys != obj.attributeIndices.keys) {
//            return false
//        }
//
//        for (i in this.attributes.indices) {
//            val thatIndex = obj.attributeIndices[this.attributes[i]]
//            val thisParameter = parameterTypes[i]
//            val thatParameter = obj.parameterTypes[thatIndex!!]
//            if (thisParameter != thatParameter) {
//                return false
//            }
//        }
//        return true
//    }
//
//    override fun hashCode(): Int {
//        return Arrays.hashCode(arrayOf<Any>(this.viewType!!, this.attributeIndices.keys))
//    }
//
//}
//open class MethodDescription() {
//    val type: String? = null;
//    val method: String? = null;
//    val requiresOldValue: Boolean? = false;
//    val isStatic: Boolean? = null;
//    val componentClass: String? = null;
//    override fun toString(): String {
//        return "$type.$method() requiresOldValue=$requiresOldValue, isStatic=$isStatic, componentClass=$componentClass"
//    }
//
//    override fun equals(other: Any?): Boolean {
//        if (other is MethodDescription) {
//            return other.type.equals(this.type) && other.method.equals(this.method);
//        } else {
//            return false;
//        }
//
//    }
//
//    override fun hashCode(): Int {
//        return mergedHashCode(type!!, method!!);
//    }
//}
//
//class InverseDescription : MethodDescription() {
//    val event: String? = null;
//    override fun equals(obj: Any?): Boolean {
//        if (!super.equals(obj) || obj !is InverseDescription) {
//            return false
//        }
//        return event == obj.event
//    }
//    override fun hashCode(): Int {
//        return mergedHashCode(type!!, method!!, event!!)
//    }
//}
//
//fun mergedHashCode(vararg objects: Any): Int {
//    return Arrays.hashCode(objects)
//}
