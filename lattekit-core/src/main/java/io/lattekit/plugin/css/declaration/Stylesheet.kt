package io.lattekit.plugin.css.declaration

import com.google.common.base.CaseFormat
import java.util.*

/**
 * Created by maan on 2/22/16.
 */

open class Stylesheet {

    companion object {
        var stylesheets = mutableMapOf<String, Stylesheet>()

        @JvmStatic
        fun register(fileName : String , stylesheet : Stylesheet ) {
            stylesheets.put(fileName, stylesheet)
        }

        @JvmStatic
        fun getStylesheet( fileName: String) :Stylesheet{
            var parts = fileName.split("/");
            var clsName = CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL,parts.last().replace(".css",""))+"Stylesheet";
            var packageName = parts.get(0);
            return Class.forName(packageName+"."+clsName).constructors.get(0).newInstance() as Stylesheet;
        }
    }

    var ruleSets  = mutableListOf<RuleSet>()
    var classesRules : MutableMap<String, MutableList<RuleSet>> = mutableMapOf();
    var idsRules : MutableMap<String, MutableList<RuleSet>> = mutableMapOf();

    fun addRuleSet(ruleSet : RuleSet) {
        ruleSet.selectors.forEach {
            if (it[0].startsWith(".")) {
                classesRules.getOrPut(it[0], { mutableListOf() }).add(ruleSet)
            }
        }
        ruleSets.add(ruleSet)
    }


}

