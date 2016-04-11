package io.lattekit.transformer

import io.lattekit.css.CssCompiler
import io.lattekit.evaluator.Resolver
import io.lattekit.parser.KotlinParser
import io.lattekit.template.KotlinTemplate
import java.io.File
import java.io.PrintWriter
import java.nio.file.Files
import java.nio.file.Path

class Transformer {

    private var kotlinTransformer: SourceTransformer = SourceTransformer(KotlinParser(), KotlinTemplate())
    private val cssCompiler = CssCompiler()
    private var rootDir: Path? = null
    private var extensions: List<String> = listOf(".css", ".kt")
    var warningLogger : (String)->Unit = {};


    fun transformFile(androidPackageName: String, file: File, outDir: File?, generateSources: Boolean) : List<String> {
        if (this.extensions.filter { it -> file.absolutePath.endsWith(it) }.isEmpty()) {
            return emptyList();
        }
        var generatedFiles = mutableListOf<String>();
        if (file.absolutePath.endsWith(".kt")) {
            val code = String(Files.readAllBytes(file.toPath()))
            println("Processing ${file.absolutePath}")
            val results = this.kotlinTransformer.transform(file.absolutePath, androidPackageName, code);
            if (generateSources && outDir != null) {
                results.warnings.forEach { warningLogger.invoke(it) }
                results.classes.forEach { it ->
                    if (!outDir.exists()) {
                        outDir.mkdirs()
                    }
                    var fileName = outDir.absolutePath + File.separator + it.classNameImpl + ".kt";
                    generatedFiles.add(fileName);
                    val writer = PrintWriter(File(outDir.absolutePath + File.separator + it.classNameImpl + ".kt"), "UTF-8")
                    println("Wrote ${outDir.absolutePath + File.separator + it.classNameImpl + ".kt"}")
                    writer.print(it.generatedSource)
                    writer.close()
                }
            }

        } else if (file.absolutePath.endsWith(".css")) {
            val filePath = file.toPath()
            val fileName = filePath.fileName.toString()

            var packageName = rootDir!!.relativize(filePath).map{it.toString()}.joinToString(".").replace("."+fileName,"")
            val code = String(Files.readAllBytes(file.toPath()))
            if (generateSources && outDir != null) {
                val out = this.cssCompiler.compile(packageName, fileName, code)
                val outFileJava = outDir.absolutePath + File.separator + CssCompiler.toClass(fileName) + ".java"
                if (!outDir.exists()) {
                    outDir.mkdirs()
                }
                val writer = PrintWriter(File(outFileJava), "UTF-8")
                println("Complied " + file.absolutePath + " to " + outFileJava)
                generatedFiles.add(outFileJava)
                writer.print(out)
                writer.close()
            }
        }
        return generatedFiles
    }

    fun transformDir(androidPackageName: String, dir: String, out: String?, generateSources: Boolean) {
        val sourceDir = File(dir)
        if (out != null && sourceDir.absolutePath.contains("generated/source/latte")) {
            return;
        }
        var generatedFiles = mutableListOf<String>();
        sourceDir.listFiles().forEach { it ->
            if (it.isDirectory) {
                transformDir(androidPackageName, it.absolutePath, if (out != null) {
                    out + File.separator + it.name
                } else null, generateSources)
            } else {
                generatedFiles.addAll(this.transformFile(androidPackageName, it.absoluteFile, if (out != null) {
                    File(out + File.separator)
                } else null, generateSources))
            }
        }
        if (out != null) {
            var outDir = File(out);
            if (outDir.exists()) {
                outDir.listFiles().forEach {
                    if (it.isFile && !generatedFiles.contains( it.absolutePath)) {
                        it.delete()
                    }
                }
            }
        }
    }

    fun transform(androidPackageName: String, source: String, srcOut: String?): Set<String> {
        val sourceDir = File(source).toPath()
        this.rootDir = sourceDir
        this.transformDir(androidPackageName, source, srcOut, srcOut != null)
        return this.kotlinTransformer.resourceIds.toSet()
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            if (args.size < 3) {
                println("Usage: java Main PACKAGE_NAME SRC_DIR OUT_DIR")
                return
            }
            Transformer().transform(args[0], args[1], args[2]);
        }
    }
}
