package io.lattekit.parser

import io.lattekit.css.CssDefinition
import io.lattekit.css.CssProperty

/**
 * Created by maan on 4/3/16.
 */

class CssParser {
    var BLOCKS_REGEX = Regex("""([^\{]+)\s*\{([^\}]+)\}""").toPattern()

    fun acceptDefinition(selector: String , body: String) : CssDefinition {
        val definition = CssDefinition(selector, body)
        definition.selector = selector;
        body.split(Regex("\r?\n|;")).forEach { line ->
            var trimmedLine = line.trim();
            if (trimmedLine.endsWith(";")) {
                trimmedLine = trimmedLine.substring(0, trimmedLine.length - 1)
            }
            var property = CssProperty();
            var split = trimmedLine.split(":")
            if (split.size > 1) {
                property.name = split.get(0).trim();
                property.value = split.get(1).trim();
                definition.childNodes.add(property);
            }
        }

        return definition;
    }


    fun  parse(source: String ) : List<CssDefinition>{
        var blocksMatcher = BLOCKS_REGEX.matcher(source);
        var  results = mutableListOf<CssDefinition>();
        while(blocksMatcher.find()) {
            results.add(acceptDefinition(blocksMatcher.group(1).trim(),blocksMatcher.group(2)));
        }
        return results;
    }
}