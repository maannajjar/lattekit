package io.lattekit.plugin.css

import io.lattekit.plugin.css.declaration.RuleSet
import io.lattekit.plugin.css.declaration.Stylesheet

/**
 * Created by maan on 4/4/16.
 */


object CssParser {
    var BLOCKS_REGEX = Regex("""([^\{]+)\s*\{([^\}]+)\}""").toPattern()

    fun acceptRuleSet(selector: String , body: String) : RuleSet {
        val ruleSet = RuleSet(selector)
        body.split(Regex("\r?\n|;")).forEach { line ->
            var trimmedLine = line.trim();
            if (trimmedLine.endsWith(";")) {
                trimmedLine = trimmedLine.substring(0, trimmedLine.length - 1)
            }
            var split = trimmedLine.split(":")
            if (split.size > 1) {
                ruleSet.add(split.get(0).trim(),split.get(1).trim())
            }
        }

        return ruleSet;
    }


    fun parse(source: String ) : Stylesheet {
        var stylesheet = Stylesheet()

        var blocksMatcher = BLOCKS_REGEX.matcher(source);
        while(blocksMatcher.find()) {
            stylesheet.addRuleSet(acceptRuleSet(blocksMatcher.group(1).trim(),blocksMatcher.group(2)))
        }

        return stylesheet
    }
}