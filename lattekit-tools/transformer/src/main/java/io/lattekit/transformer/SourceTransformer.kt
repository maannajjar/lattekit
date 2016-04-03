package io.lattekit.transformer

import io.lattekit.evaluator.Evaluator
import io.lattekit.parser.AstVisitor
import io.lattekit.parser.KotlinParser
import io.lattekit.parser.LatteFile
import io.lattekit.template.KotlinTemplate

/**
 * Created by maan on 4/3/16.
 */
class SourceTransformer(var parser : AstVisitor, var template: KotlinTemplate) {
    var resourceIds = mutableListOf<String>()

    fun transform( androidPackageId: String, source : String ) : LatteFile {
        var latteFile = KotlinParser().parseSource(source)
        Evaluator(androidPackageId).evaluate(latteFile);
        latteFile.classes.forEach {
            it.generatedSource = template.renderClass(it, latteFile).toString()
        }
        resourceIds.addAll(latteFile.resourceIds)
        return latteFile;
    }
}
