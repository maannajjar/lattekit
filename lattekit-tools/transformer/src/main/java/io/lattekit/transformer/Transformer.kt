package io.lattekit.transformer

import com.google.common.base.Objects
import io.lattekit.css.CssCompiler
import java.io.File
import java.io.PrintWriter
import java.nio.file.FileSystem
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.WatchEvent
import java.nio.file.WatchKey
import java.nio.file.WatchService
import java.util.Collections
import java.util.function.Consumer
import org.eclipse.xtext.xbase.lib.CollectionLiterals
import org.eclipse.xtext.xbase.lib.Conversions
import org.eclipse.xtext.xbase.lib.Exceptions
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.xtext.xbase.lib.InputOutput
import org.eclipse.xtext.xbase.lib.IterableExtensions

@SuppressWarnings("all")
class Transformer {

    private var kotlinCompiler: KotlinTransformer2? = null

    private val cssCompiler = CssCompiler()

    private var rootDir: Path? = null

    private var extensions: List<String>? = null


    fun transformFile(androidPackageName: String, file: File, outDir: File?, generateSources: Boolean) {
        val _function = Function1<kotlin.String, kotlin.Boolean> { it ->
            val _absolutePath = file.absolutePath
            java.lang.Boolean.valueOf(_absolutePath.endsWith(it))
        }
        val _filter = IterableExtensions.filter(this.extensions, _function)
        val _isEmpty = IterableExtensions.isEmpty(_filter)
        if (_isEmpty) {
            return
        }
        var _or = false
        var _or_1 = false
        val _absolutePath = file.absolutePath
        val _endsWith = _absolutePath.endsWith(".java")
        if (_endsWith) {
            _or_1 = true
        } else {
            val _absolutePath_1 = file.absolutePath
            val _endsWith_1 = _absolutePath_1.endsWith(".xtend")
            _or_1 = _endsWith_1
        }
        if (_or_1) {
            _or = true
        } else {
            val _absolutePath_2 = file.absolutePath
            val _endsWith_2 = _absolutePath_2.endsWith(".kt")
            _or = _endsWith_2
        }
        if (_or) {
            val _path = file.toPath()
            val _readAllBytes = Files.readAllBytes(_path)
            val code = String(_readAllBytes)

            if (file.absolutePath.endsWith(".kt")) {
                println("Processing ${file.absolutePath}")
                val results = this.kotlinCompiler!!.transform(code)
                if (generateSources && outDir != null) {
                    println("Hmm classes ? " + results.classes.size)
                    results.classes.forEach { it ->
                        if (!outDir.exists()) {
                            outDir.mkdirs()
                        }
                        val writer = PrintWriter(File(outDir.absolutePath + File.separator + it.classNameImpl + ".kt"), "UTF-8")
                        println("Wrote ${outDir.absolutePath + File.separator + it.classNameImpl + ".kt"}")

                        writer.print(it.generatedSource)
                        writer.close()
                    }
                }
            }
        } else {
            val _absolutePath_5 = file.absolutePath
            val _endsWith_5 = _absolutePath_5.endsWith(".css")
            if (_endsWith_5) {
                val filePath = file.toPath()
                val _fileName = filePath.fileName
                val fileName = _fileName.toString()
                val _relativize = this.rootDir!!.relativize(filePath)
                val _function_2 = Function1<java.nio.file.Path, kotlin.String> { it -> it.toString() }
                val _map = IterableExtensions.map(_relativize, _function_2)
                val _join = IterableExtensions.join(_map, ".")
                val packageName = _join.replace("." + fileName, "")
                val _path_1 = file.toPath()
                val _readAllBytes_1 = Files.readAllBytes(_path_1)
                val code_1 = String(_readAllBytes_1)

                if (generateSources && outDir != null) {
                    val out = this.cssCompiler.compile(packageName, fileName, code_1)
                    val _absolutePath_6 = outDir.absolutePath
                    val _plus = _absolutePath_6 + File.separator
                    val _class = CssCompiler.toClass(fileName)
                    val _plus_1 = _plus + _class
                    val outFileJava = _plus_1 + ".java"
                    val _exists = outDir.exists()
                    val _not = !_exists
                    if (_not) {
                        outDir.mkdirs()
                    }
                    val _file = File(outFileJava)
                    val writer = PrintWriter(_file, "UTF-8")
                    val _absolutePath_7 = file.absolutePath
                    val _plus_2 = "Complied " + _absolutePath_7
                    val _plus_3 = _plus_2 + " to "
                    val _plus_4 = _plus_3 + outFileJava
                    InputOutput.println(_plus_4)
                    writer.print(out)
                    writer.close()
                }
            }
        }

    }

    fun transformDir(androidPackageName: String, dir: String, out: String?, watcher: WatchService, generateSources: Boolean) {
        val sourceDir = File(dir)
        val dirPath = sourceDir.toPath()
        val _listFiles = sourceDir.listFiles()
        (Conversions.doWrapArray(_listFiles) as List<File>).forEach { it ->
            val _isDirectory = it.isDirectory
            if (_isDirectory) {
                val _absolutePath = it.absolutePath
                this@Transformer.transformDir(androidPackageName, _absolutePath, if (out != null) {  out + File.separator + it.name } else null, watcher, generateSources)
            } else {
                var _xifexpression_1: File? = null
                val _notEquals_1 = !Objects.equal(out, null)

                val outDir = _xifexpression_1
                val _absoluteFile = it.absoluteFile
                this@Transformer.transformFile(androidPackageName, _absoluteFile, if (out != null) {  File(out + File.separator)  } else null, generateSources)
            }
        }
    }

    fun transform(androidPackageName: String, source: String, srcOut: String?, vararg extensions: String): Set<String> {
        try {
            var _xifexpression: List<String>? = null
            val _isEmpty = (Conversions.doWrapArray(extensions) as List<String>).isEmpty()
            if (_isEmpty) {
                _xifexpression = Collections.unmodifiableList(CollectionLiterals.newArrayList(".css", ".kt"))
            } else {
                _xifexpression = Conversions.doWrapArray(extensions) as List<String>
            }
            this.extensions = _xifexpression
            val _notEquals = !Objects.equal(srcOut, null)
            if (_notEquals) {
                val outDir = File(srcOut)
                outDir.delete()
            }
            val _file = File(source)
            val sourceDir = _file.toPath()
            this.rootDir = sourceDir
            val _fileSystem = sourceDir.fileSystem
            val watcher = _fileSystem.newWatchService()
            val _kotlinTransformer = KotlinTransformer2(androidPackageName)
            this.kotlinCompiler = _kotlinTransformer
            this.transformDir(androidPackageName, source, srcOut, watcher, srcOut != null)
            val _resourceIds = this.kotlinCompiler!!.resourceIds
            return IterableExtensions.toSet(_resourceIds)
        } catch (_e: Throwable) {
            throw Exceptions.sneakyThrow(_e)
        }

    }

    companion object {

        fun <T : Any> cast(event: WatchEvent<*>): WatchEvent<T> {
            return event as WatchEvent<T>
        }

        @JvmStatic fun main(args: Array<String>) {
            val _length = args.size
            val _lessThan = _length < 2
            if (_lessThan) {
                println("Usage: java Main SRC_DIR OUT_DIR")
                return
            }
            val _transformer = Transformer()
            val _get = args[0]
            val _get_1 = args[1]
            _transformer.transform(_get, _get_1, ".java", ".xtend", ".css")
        }
    }
}
