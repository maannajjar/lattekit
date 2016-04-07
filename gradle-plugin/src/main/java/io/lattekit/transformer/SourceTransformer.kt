package io.lattekit.transformer

import io.lattekit.evaluator.Resolver
import io.lattekit.parser.AstVisitor
import io.lattekit.parser.KotlinParser
import io.lattekit.parser.LatteFile
import io.lattekit.template.KotlinTemplate

/**
 * Created by maan on 4/3/16.
 */
class TransformerException(var filePath: String, var errors: List<String>) : Exception();
class SourceTransformer(var parser : AstVisitor, var template: KotlinTemplate) {
    var resourceIds = mutableListOf<String>()

    fun transform( filePath: String, androidPackageId: String, source : String ) : LatteFile {
        var parser = KotlinParser();
        var latteFile = parser.parseSource(source)
        if (!parser.errors.isEmpty()) {
            throw TransformerException(filePath, parser.errors)
        }
        Resolver(androidPackageId).evaluate(latteFile);
        latteFile.classes.forEach {
            it.generatedSource = template.renderClass(it, latteFile).toString()
        }
        resourceIds.addAll(latteFile.resourceIds)
        return latteFile;
    }
}
