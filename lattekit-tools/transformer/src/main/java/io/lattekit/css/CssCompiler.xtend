package io.lattekit.css

import com.google.common.base.CaseFormat
import java.util.List
import java.util.regex.Matcher
import java.util.regex.Pattern

class CssCompiler {
    var STRING_RE = Pattern.compile('''^(["'])(?:(?=(\\?))\2.)*?\1$''')
    var NUM_RE = Pattern.compile('''^(\d+(?:\.\d+)?)(ms|px|dp|dip|pt|sp|sip|mm|in)$''')

    var static valueTypes = #{
        "PX" -> 0,
        "DP" -> 1,
        "DIP"->1,
        "SP"->2,
        "SIP"->2,
        "PT"->3,
        "IN"->4,
        "MM"->5
    }


    def static String toClass(String file) {
        return file.split(".css").get(0).toFirstUpper+"Stylesheet"
    }

    def toSetter(String property) {
        CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL,"set-"+property)
    }

    def String toJava(String va) {
        var value = va.trim()
        var Matcher matcher;
        if (value.matches(STRING_RE.pattern)) {
            return value
        } else if ( (matcher = NUM_RE.matcher(value)).find) {
            if (matcher.group(2) == "ms") {
                return matcher.group(1);
            }
            return '''new NumberValue(«matcher.group(1)»,«valueTypes.get(matcher.group(2).toUpperCase)»)'''
        } else if (value.trim().toLowerCase == "match_parent") {
            return '''new NumberValue(Style.MATCH_PARENT, 0)'''
        } else if (value.trim().toLowerCase == "wrap_content") {
            return '''new NumberValue(Style.WRAP_CONTENT, 0)'''
        } else if (value.split(",").length > 1) {
            '''Arrays.asList(«value.split(",").map['''Arrays.<Object>asList(«toJava»)'''].join(",")»)'''
        } else if (value.split(" ").length > 1) {
            return value.split(" ").map[toJava].join(",")
        } else {
            return '''"«value»"'''
        }
    }

    def compile(CssProperty property) '''
        _style.«property.name.toSetter»(«property.value.toJava»);
    '''

    def compile(String packageName, String fileName, List<CssDefinition> definitions) '''
        package «packageName»;
        import io.lattekit.ui.style.NumberValue;
        import io.lattekit.ui.style.Style;
        import android.graphics.Color;
        import java.util.ArrayList;
        import java.util.Map;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Arrays;
        import io.lattekit.ui.style.Stylesheet;

        public class «fileName.toClass» extends Stylesheet {

            static {
                new «fileName.toClass»();
            }

            public «fileName.toClass»() {
                Stylesheet.registerStylesheet("«fileName»",this);
            }

            @Override
            public Map<String,Map<String,String>> getRuleSets() {
                Map<String,Map<String,String>> ruleSets = new HashMap<>();
                Map<String,String> ruleSet;
                «FOR definition: definitions»
                    ruleSet = new HashMap<>();
                    «FOR child: definition.childNodes»
                        ruleSet.put("«child.name»",«IF child.value.startsWith('"') && child.value.endsWith('"')»«child.value»«ELSE»"«child.value»"«ENDIF»);
                    «ENDFOR»
                    ruleSets.put("«definition.selector»",ruleSet);
                «ENDFOR»
                return ruleSets;
            }

            @Override
            public void apply(Stylesheet stylesheet) {
                Style _style;
                «FOR definition: definitions»

                    _style = new Style();
                    «FOR child: definition.childNodes»
                        «compile(child)»
                    «ENDFOR»
                    stylesheet.registerStyle("«definition.selector»",_style);
                «ENDFOR»

            }
        }
    '''

    def compile(String packageName, String fileName, String source) {
        return compile(packageName,fileName,new CssParser().parse(source))
    }


}