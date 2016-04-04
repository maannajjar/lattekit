package io.lattekit.template

import io.lattekit.parser.LatteClass
import io.lattekit.parser.LatteFile
import io.lattekit.parser.NativeCode
import io.lattekit.parser.XmlTag
import io.lattekit.parser.LayoutNode
import io.lattekit.parser.Prop
import io.lattekit.parser.PropSetter

/**
 * Created by maan on 4/2/16.
 */
class KotlinTemplate {
    def renderClass(LatteClass cls, LatteFile file) '''

    package «file.packageName»;

    «IF !file.imports.contains("io.lattekit.Latte")»
    import io.lattekit.Latte;
    «ENDIF»
    «IF !file.imports.contains("io.lattekit.plugin.css.declaration.select")»
    import io.lattekit.plugin.css.declaration.select;
    «ENDIF»
    «IF !file.imports.contains("io.lattekit.plugin.css.declaration.css")»
    import io.lattekit.plugin.css.declaration.css;
    «ENDIF»

    «FOR importCls : file.imports»
    import «importCls»
    «ENDFOR»

    class «cls.classNameImpl» : «cls.className»() {

        «FOR cssFn: cls.cssFunctions»
            override fun «cssFn.functionName»«cssFn.functionParams» {
                css {
                    «FOR definition: cssFn.definitions»
                        select("«definition.selector»") {
                            «FOR child: definition.childNodes»
                                add("«child.name»", «IF child.value.startsWith('"') && child.value.endsWith('"')»«child.value»«ELSE»"«child.value»"«ENDIF»);
                            «ENDFOR»
                        }
                    «ENDFOR»
                }
            }
        «ENDFOR»

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
    def renderPropOptions(XmlTag node) '''mutableMapOf(«FOR prop : node.props SEPARATOR ','» "«prop.propName»" to «IF prop.propModifier == "@"»Latte.PropOption.WAIT_LAYOUT«ELSE»Latte.PropOption.NO_OPTIONS«ENDIF»«ENDFOR»)'''

    def renderVirtualNode(XmlTag node) '''
        __current.addChild(Latte.create(Latte.lookupClass("«node.tagName»"), «renderPropsMap(node)», «renderPropOptions(node)», { __it : LatteView ->
            «FOR child : node.children»
            __current = __it;
            «renderLayoutNode(child)»
            «ENDFOR»
        }))
    '''

    def renderNativeNode(XmlTag node) '''
        __current.addChild(Latte.createNative(«node.viewClass.name»::class.java,  «renderPropsMap(node)», «renderPropOptions(node)», { __viewWrapper, __lprops ->
            var __view = __viewWrapper.androidView as «node.viewClass.name»
            var __acceptedProps = mutableListOf<String>();
            __lprops.forEach {
                var __propKey = it.key;
                var __propValue = it.value;
                var __valueAccepted = false;

                «FOR prop : node.props»
                «renderPropSetters(prop)»
                «ENDFOR»
                if (__valueAccepted) {
                    __acceptedProps.add(__propKey);
                }
            }
            __acceptedProps
        }, { __it : LatteView ->
            «FOR child : node.children»
            __current = __it;
            «renderLayoutNode(child)»
            «ENDFOR»
        }))
    '''

    def renderPropSetters(Prop prop) '''
        «IF !prop.propSetters.empty»
            if (__propKey == "«prop.propName»") {
                «FOR propSetter : prop.propSetters»
                    «IF prop.isListenerProp»
                        if (__propValue is «propSetter.kotlinTypeName») {
                            var __listener = Latte.createLambdaProxyInstance(«propSetter.kotlinTypeName»::class.java, __propValue as Object) as «propSetter.kotlinTypeName»
                            __view.«propSetter.setterMethod.name»(__listener);
                        }
                    «ELSE»
                        if (!__valueAccepted  && __propValue is «propSetter.kotlinTypeName»«IF !propSetter.primitiveType»?«ENDIF» ) {
                            «IF propSetter.hasGetter»
                            var __currentValue = if (__view.«propSetter.getterMethod.name»() != null) __view.«propSetter.getterMethod.name»()«IF propSetter.getterMethod.returnType.simpleName == "CharSequence"».toString()«ENDIF» else null;
                            «ENDIF»
                            «IF propSetter.hasGetter»if (__currentValue != __propValue) {«ENDIF»
                            __view.«propSetter.setterMethod.name»(__propValue as «propSetter.kotlinTypeName»«IF !propSetter.primitiveType»?«ENDIF»);
                            __valueAccepted = true;
                            «IF propSetter.hasGetter»}«ENDIF»
                        } «IF propSetter.isPrimitiveType && !prop.hasStringSetter» else if (!__valueAccepted &&  __propValue != null && __propValue is String) {
                            try {
                                var castValue = __propValue.to«propSetter.kotlinTypeName»();
                                «IF propSetter.hasGetter»
                                var __currentValue = if (__view.«propSetter.getterMethod.name»() != null) __view.«propSetter.getterMethod.name»()«IF propSetter.getterMethod.returnType.simpleName == "CharSequence"».toString()«ENDIF» else null;
                                if (__currentValue != castValue) {
                                    __view.«propSetter.setterMethod.name»(castValue);
                                }
                                «ELSE»
                                __view.«propSetter.setterMethod.name»(castValue);
                                «ENDIF»
                                __valueAccepted = true;
                            } catch (e : Exception) {}
                        }
                        «ENDIF»

                    «ENDIF»
                «ENDFOR»
            }
        «ENDIF»
    '''

    def renderPropSetterInvocation(PropSetter propSetter, Prop prop) '''

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

    def renderPropsMap(XmlTag node) '''mutableMapOf(«FOR prop : node.props SEPARATOR ","»"«prop.propName»" to «getPropValue(prop)»«ENDFOR»)'''

    def getKotlinTypeName(PropSetter propSetter) {
        if (propSetter.paramType.name == "java.lang.CharSequence") {
            return "CharSequence"
        } else if (propSetter.paramType.isPrimitive) {
            return propSetter.paramType.name.substring(0,1).toUpperCase() + propSetter.paramType.name.substring(1)
        } else {
            return propSetter.paramType.name.replaceAll("\\$",".")
        }
    }

}
