package io.lattekit.evaluator

import io.lattekit.parser.*
import io.lattekit.transformer.Reflection

/**
 * Created by maan on 4/2/16.
 */
class Evaluator(var androidPackage: String) {

    fun evaluate(file : LatteFile) {
        file.androidPackageName = androidPackage;
        file.classes.forEach {
            it.classNameImpl = it.className+"Impl"
            it.layoutFunctions.forEach { evaluateLayoutFunction(it); }
        }
    }
    fun evaluateLayoutFunction(layoutFunction: LayoutFunction) {
        layoutFunction.children.forEach {
            evaluateLayoutNode(it)
        }
    }

    fun evaluateXmlTag(tag : XmlTag) {
        tag.viewClass = Reflection.lookupClass(tag.tagName)
        if (tag.viewClass != null) {
            tag.isNativeView = true;
            tag.props.forEach {
                evaluateProperty(it, tag)
            }
        }
        tag.children.forEach { evaluateLayoutNode(it) }
    }


    fun getKotlinTypeName( type : Class<*>) : String{
        if (type.name == "java.lang.CharSequence") {
            return "String"
        } else if (type.isPrimitive) {
            return type.name.substring(0,1).toUpperCase() + type.name.substring(1)
        } else {
            return type.name.replace(Regex("\\$"),".")
        }
    }

    fun evaluateProperty(prop : Prop, tag: XmlTag) {

        var propName = prop.propName;
        var field = if (propName.startsWith("@")) {
            propName.substring(1)
        } else propName;

        var setter = "set" + field.substring(0, 1).toUpperCase() + field.substring(1)
        var getter =  "get" + field.substring(0, 1).toUpperCase() + field.substring(1)
        var getterBoolean =  "is"+ field.substring(0, 1).toUpperCase() + field.substring(1);
        var setterMethods = Reflection.findMethods(tag.viewClass, setter);

        if (setterMethods.isEmpty() && field != "onClick" && field != "onTouch") {
            setter += "Listener";
            getter += "Listener";
            setterMethods = Reflection.findMethods(tag.viewClass, setter);
            prop.isListenerProp = setterMethods.isNotEmpty()
        }

        val getterMethods = Reflection.findGetterMethods(tag.viewClass,getter) + Reflection.findGetterMethods(tag.viewClass, getterBoolean);
        setterMethods.forEach { setterMethod ->
            var propSetter = PropSetter();
            propSetter.paramType = setterMethod.parameters[0].type
            propSetter.paramTypeName = getKotlinTypeName(setterMethod.parameters[0].type)
            propSetter.isPrimitiveType = setterMethod.parameters[0].type.isPrimitive;
            if (setterMethod.parameters[0].type == String::class.java || setterMethod.parameters[0].type == CharSequence::class.java) {
                prop.isHasStringSetter = true;
            }
            var getter = getterMethods.find { it.name == setterMethod.name && ( (it.returnType.isAssignableFrom(propSetter.paramType) || propSetter.paramType.isAssignableFrom(it.returnType))) }
            if (getter != null) {
                propSetter.isHasGetter = true;
            }
            prop.propSetters.add(propSetter);
        }
        if (setterMethods.isEmpty()) {
            // TODO: Warn no setter for property
            println("Warning: couldn't recognized property $propName for ${tag.tagName}");
        }

    }
    fun evaluateLayoutNode(node : LayoutNode) {
        if (node is XmlTag) {
            evaluateXmlTag(node)
        }
    }
}
