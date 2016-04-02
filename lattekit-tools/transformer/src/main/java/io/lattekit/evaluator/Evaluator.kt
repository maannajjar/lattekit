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
            it.layoutFunctions.forEach { evaluateLayoutFunction(it); }
        }
    }
    fun evaluateLayoutFunction(layoutFunction: LayoutFunction) {
        layoutFunction.children.forEach {
            evaluateLayoutNode(it)
        }
    }

    fun evaluateXmlTag(tag : XmlTag) {
        tag.nativeClass = Reflection.lookupClass(tag.tagName)
        if (tag.nativeClass != null) {
            tag.props.forEach {
                evaluateProperty(it, tag)
            }
        }
        tag.children.forEach { evaluateLayoutNode(it) }
    }

    fun evaluateProperty(prop : Prop, tag: XmlTag) {

    }

    fun evaluateLayoutNode(node : LayoutNode) {
        if (node is XmlTag) {
            evaluateXmlTag(node)
        }
    }
}