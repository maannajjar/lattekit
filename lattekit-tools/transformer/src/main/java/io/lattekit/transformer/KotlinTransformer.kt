package io.lattekit.transformer
import io.lattekit.evaluator.Evaluator
import io.lattekit.parser.*
import io.lattekit.template.KotlinTemplate
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.TerminalNode

/**
 * Created by maan on 4/1/16.
 */
class KotlinTransformer() {
    var resourceIds = mutableListOf<String>()

    fun transform( androidPackageId: String, source : String ) :  LatteFile {
        var parsed = KotlinParser().parseSource(source)
        Evaluator(androidPackageId).evaluate(parsed);
        var template = KotlinTemplate()
        parsed.classes.forEach {
            it.generatedSource = template.renderClass(it, parsed).toString()
        }
        resourceIds.addAll(parsed.resourceIds)
        return parsed;
    }
}
