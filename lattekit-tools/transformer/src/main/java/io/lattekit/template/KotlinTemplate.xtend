package io.lattekit.template

import io.lattekit.parser.LatteClass
import io.lattekit.parser.LatteFile
import io.lattekit.parser.NativeCode
import io.lattekit.parser.XmlTag
import io.lattekit.parser.LayoutNode
import io.lattekit.parser.Prop

/**
 * Created by maan on 4/2/16.
 */
class KotlinTemplate {
    def renderClass(LatteClass cls, LatteFile file) '''

    package «file.packageName»;

    «IF !file.imports.contains("io.lattekit.Latte")»
    import io.lattekit.Latte;
    «ENDIF»
    «FOR importCls : file.imports»
    import «importCls»
    «ENDFOR»

    class «cls.classNameImpl» : «cls.className»() {
        «FOR layoutFn: cls.layoutFunctions»
            override fun «layoutFn.functionName»«layoutFn.functionParams» {
                «FOR child : layoutFn.children»
                «renderLayoutNode(child)»
                «ENDFOR»
            }
        «ENDFOR»
    }
    '''

    def renderLayoutNode(LayoutNode node) {
        if (node instanceof NativeCode) {
            return (node as NativeCode).code
        } else {
            var xmlNode = node as XmlTag;
            if (xmlNode.isNativeView) {
                return renderNativeNode(xmlNode);
            } else {
                return renderVirtualNode(xmlNode);
            }
        }
    }

    def renderVirtualNode(XmlTag node) '''
        __current.addChild(Latte.create(Latte.lookupClass("«node.tagName»"), «renderPropsMap(node)», mutableMapOf(), { it : LatteView ->
            ${ if (ctx.layoutBody() != null) ctx.layoutBody()?.children?.map { "\n__current = __it\n"  + visit(it)  }?.joinToString("") else ""}
        }))
    '''

    def renderNativeNode(XmlTag node) '''
        __current.addChild(Latte.create(Latte.lookupClass("«node.tagName»"), «renderPropsMap(node)», mutableMapOf(), { it : LatteView ->
            ${ if (ctx.layoutBody() != null) ctx.layoutBody()?.children?.map { "\n__current = __it\n"  + visit(it)  }?.joinToString("") else ""}
        }))

    '''


    def getPropValue(Prop prop) {
        if (prop.valueType == Prop.ValueType.RESOURCE_REF) {
            return '''«prop.resourcePackage».R.«prop.resourceType».«prop.resourceName»'''
        } else  if (prop.valueType == Prop.ValueType.LITERAL){
            return prop.value
        } else {
            return "("+prop.value+")"
        }
    }

    def renderPropsMap(XmlTag node) '''
    mutableMapOf(«FOR prop : node.props SEPARATOR ","»"«prop.propName»" to «getPropValue(prop)»«ENDFOR»})
    '''
}
