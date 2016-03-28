package io.lattekit.css

import java.util.List
import java.util.regex.Matcher
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class CssDefinition  {
    new(String selector,String body) {
        this.selector = selector;
        this.body = body;
    }
    String selector;
    String body;
    List<CssProperty> childNodes = newArrayList()
}

@Accessors
class CssProperty  {
    String name;
    String value;
}

class CssParser {
    var BLOCKS_REGEX = Pattern.compile('''([^\{]+)\s*\{([^\}]+)\}''')
    var TOKENS = Pattern.compile(
            // Group 1:captures selectors
            '''((?:(?:\.|#)?[^,> \n]+)(?:\s*[,> ]\s*(?:\.|#)?[^,> \n]+)*)\s+(?=\{)'''
            // Group 2: captures {
            +'''|(\{)'''
            // Group 3: captures property name
            // Group 4: captures property value
            +'''|\s*([^\n:]+):\s*([^\n;]+)(?:;|\s*\n\s*(?=\}))'''
            // Group 5: captures }
            +'''|(\})''')


    def acceptDefinition(String selector, String body) {
        val definition = new CssDefinition(selector,body)
        definition.selector = selector;

        body.split("\r?\n").forEach [  line |
            var trimmedLine = line.trim();
            if (trimmedLine.endsWith(";")) {
                trimmedLine = trimmedLine.substring(0,trimmedLine.length-1)
            }
            var property = new CssProperty();
            var split = trimmedLine.split(":")
            if (split.length > 1) {
                property.name = split.get(0).trim();
                property.value = split.get(1).trim();
                definition.childNodes += property;
            }
        ]

        return definition;
    }


    def List<CssDefinition> parse(String source) {
        var blocksMatcher = BLOCKS_REGEX.matcher(source);
        var List<CssDefinition> results = newArrayList();
        while(blocksMatcher.find()) {
            results += acceptDefinition(blocksMatcher.group(1).trim(),blocksMatcher.group(2));
        }
        return results;
    }

    def compile(List<CssDefinition> tree) {

    }

}