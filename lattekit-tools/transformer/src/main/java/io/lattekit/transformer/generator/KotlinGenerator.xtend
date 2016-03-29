package io.lattekit.transformer.generator

import io.lattekit.transformer.parser.CodeProp
import io.lattekit.transformer.parser.CodeStatement
import io.lattekit.transformer.parser.DictProp
import io.lattekit.transformer.parser.LambdaProp
import io.lattekit.transformer.parser.Prop
import io.lattekit.transformer.tree.Tag
import io.lattekit.transformer.tree.TextNode
import java.util.List
import java.util.regex.Pattern
import io.lattekit.Reflection

class KotlinGenerator extends BaseGenerator {

    val static TOKENS_RE = Pattern.compile('''(class\s+([^\s]*)\s*(?:(:)\s+([^\n]*)\s*)\{|lxml\(\s*"""((?:(?!""")[\S\s])*)"""\s*\)|("""|'|")(?:(?=(\\?))\7[\S\s])*?\6|(?:override\s*)?fun\s+([^{=]*)\s*(=|\{)\s*|(\/\*)(?:(?=(\\?))\9[\S\s])*?\*\/|\/\/.*|[\S\s])''');

    override getTokensPattern() {
        return TOKENS_RE
    }
    override extendsKeyword() { ":" }

    def String compile(Prop prop) { prop.compileProp }

    def dispatch String compileProp(Prop prop) ''' "«prop.name»",«compilePropStringValue(prop.value)» '''
    def dispatch String compilePropOption(Prop prop) ''' "«prop.name»" to «IF prop.modifier == "@"»io.lattekit.PropOption.WAIT_LAYOUT«ELSE»0«ENDIF» '''

    def dispatch String compileProp(CodeProp prop) ''' "«prop.name»",«prop.value» '''

    def dispatch String compileProp(DictProp prop) ''' "«prop.name»",«prop.value» '''

    def dispatch String compileProp(LambdaProp prop) ''' "«prop.name»", [ «prop.paramList.join(",")» |
            «prop.statements.compileStatements»
        ]'''

    def compileStatements(List<CodeStatement> statements) '''
    «FOR i : 0..<statements.length»
        «statements.get(i).text»
    «ENDFOR»
    '''


    def String getTypeName(Class type, boolean addOptional) {
        if (type.name == "java.lang.CharSequence") {
            return "String"+(if (addOptional) "?" else "")
        } else if (type.isPrimitive) {
            return type.name.substring(0,1).toUpperCase() + type.name.substring(1)
        } else {
            return type.name.replaceAll("\\$",".")+(if (addOptional) "?" else "")
        }
    }
    def String compileProp(Prop prop, Class clz) {
        var field = if (prop.name.startsWith("@")) {
            prop.name.substring(1)
        } else prop.name;

        val setter = "set" + field.substring(0, 1).toUpperCase() + field.substring(1)
        var methods = Reflection.findMethods(clz, setter);


        val getterMethods = Reflection.findGetterMethods(clz, "get" + field.substring(0, 1).toUpperCase() + field.substring(1)) + Reflection.findGetterMethods(clz, "is" + field.substring(0, 1).toUpperCase() + field.substring(1));

        val isFn = if (methods.empty) {
            methods = Reflection.findMethods(clz, setter+"Listener");
            true
        } else { false }
        if (methods.empty || setter == "setOnClick" || setter == "setOnTouch") {
            return "";
        }
        return '''if (__propKey == "«prop.name»") {
        '''
            + methods.map['''
            if (__propValue is «IF isFn»Function<*>«ELSE»«getTypeName(it.parameters.get(0).type,true)»«ENDIF»«IF getTypeName(it.parameters.get(0).type,false) == "String"» || __propValue is CharSequence?«ENDIF» «IF getTypeName(it.parameters.get(0).type,false) == "Boolean"»|| __propValue == "true" || __propValue == "false"«ENDIF») {
                «IF isFn»
                    var __listener = io.lattekit.Latte.createLambdaProxyInstance(«getTypeName(it.parameters.get(0).type,false)»::class.java, __propValue as Object) as «getTypeName(it.parameters.get(0).type,true)»
                    __view.«setter»«IF isFn»Listener«ENDIF»(__listener);
                «ELSE»
                    «IF !getterMethods.isEmpty() && (getterMethods.get(0).returnType.isAssignableFrom(it.parameters.get(0).type) || (it.parameters.get(0).type.isAssignableFrom(getterMethods.get(0).returnType)))»
                        var __currentValue = if (__view.«getterMethods.get(0).name»() == null) null else __view.«getterMethods.get(0).name»()«IF getterMethods.get(0).returnType.simpleName == "CharSequence"».toString()«ENDIF»;
                        if (__currentValue != __propValue) {
                            «IF getTypeName(it.parameters.get(0).type,false) == "String"»
                            if (__propValue is CharSequence?) {
                                __view.«setter»((__propValue as CharSequence?)?.toString());
                            } else {
                                __view.«setter»(__propValue as «getTypeName(it.parameters.get(0).type,true)»);
                            }
                            «ELSEIF getTypeName(it.parameters.get(0).type,false) == "Boolean"»
                            if (__propValue == "true") {
                                __view.«setter»(true);
                            } else if (__propValue == "false") {
                                __view.«setter»(false);
                            } else {
                                __view.«setter»(__propValue as «getTypeName(it.parameters.get(0).type,true)» as Boolean);
                            }
                            «ELSE»
                            __view.«setter»(__propValue as «getTypeName(it.parameters.get(0).type,true)»);
                            «ENDIF»
                        }
                    «ELSE»
                            «IF getTypeName(it.parameters.get(0).type,false) == "String"»
                            if (__propValue is CharSequence?) {
                                __view.«setter»((__propValue as CharSequence?)?.toString());
                            } else {
                                __view.«setter»(__propValue as «getTypeName(it.parameters.get(0).type,true)»);
                            }
                            «ELSEIF getTypeName(it.parameters.get(0).type,false) == "Boolean"»
                            if (__propValue == "true") {
                                __view.«setter»(true);
                            } else if (__propValue == "false") {
                                __view.«setter»(false);
                            } else {
                                __view.«setter»(__propValue as «getTypeName(it.parameters.get(0).type,true)» as Boolean);
                            }
                            «ELSE»
                            __view.«setter»(__propValue as «getTypeName(it.parameters.get(0).type,true)»);
                            «ENDIF»
                    «ENDIF»
                «ENDIF»
                __acceptedProps.add("«prop.name»");
            }
        '''].join("else ") +" }"
    }
    def String compileNative(Tag tag, Class clz) {
        '''io.lattekit.Latte.createNative(«clz.name»::class.java, io.lattekit.Latte.props(«tag.props.map[compile].join(",")»),mapOf(«tag.props.map[compilePropOption].join(",")»), { __viewWrapper, __lprops ->
            var __view = __viewWrapper.androidView as «clz.name»;
            var __acceptedProps = mutableListOf<String>();
            __lprops.forEach {
                var __propKey = it.key;
                var __propValue = it.value;
                «FOR prop : tag.props»
                    «compileProp(prop, clz)»
                «ENDFOR»
            }
            __acceptedProps
        }, { it : LatteView ->
                «FOR child : tag.childNodes»
                    «IF child instanceof TextNode»«child.text»«ENDIF»
                    «IF child instanceof Tag»
                        it.addChild(«child.compile»);
                    «ENDIF»
                «ENDFOR»
            })
        '''
    }

    override String compile(Tag tag) {
        var clz = Reflection.lookupClass(tag.name)
        if (clz != null) {
            return compileNative(tag, clz)
        }
        '''io.lattekit.Latte.create(io.lattekit.Latte.lookupClass("«tag.name»"), io.lattekit.Latte.props(«tag.props.map[compile].join(",")»), mapOf(«tag.props.map[compilePropOption].join(",")»),{ it : LatteView ->
            «FOR child : tag.childNodes»
                «IF child instanceof TextNode»«child.text»«ENDIF»
                «IF child instanceof Tag»
                    it.addChild(«child.compile»);
                «ENDIF»
            «ENDFOR»
        })
        '''
    }

}
