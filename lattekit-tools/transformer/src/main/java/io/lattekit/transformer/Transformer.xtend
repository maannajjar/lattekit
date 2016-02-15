package io.lattekit.transformer

import io.lattekit.css.CssCompiler
import java.io.File
import java.io.PrintWriter
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardWatchEventKinds
import java.nio.file.WatchEvent
import java.nio.file.WatchKey
import java.nio.file.WatchService
import java.util.List
import java.util.Map
import io.lattekit.transformer.generator.JavaGenerator
import io.lattekit.transformer.generator.XtendGenerator
import io.lattekit.transformer.generator.KotlinGenerator

class Transformer {


    var compiler = new JavaGenerator();
    var xtendCompiler = new XtendGenerator();
    var kotlinCompiler = new KotlinGenerator();
    var cssCompiler = new CssCompiler();
    var Path rootDir;
    var List<String> extensions;

    var Map<WatchKey, Path> keys = newHashMap()
    var Map<WatchKey, File> keysOut = newHashMap()


    def void transformFile(String androidPackageName, File file, File outDir) {
        if (extensions.filter[file.absolutePath.endsWith(it)].empty) {
            return;
        }

        if (file.absolutePath.endsWith(".java") || file.absolutePath.endsWith(".xtend")  || file.absolutePath.endsWith(".kt")) {

            var code = new String(Files.readAllBytes(file.toPath));
            val ext =  if (file.absolutePath.endsWith(".xtend")) ".xtend" else if (file.absolutePath.endsWith(".kt"))  ".kt" else  ".java";
            var results = if (file.absolutePath.endsWith(".xtend")) {
                xtendCompiler.transform(androidPackageName, code)
            } else if (file.absolutePath.endsWith(".kt")) {
                kotlinCompiler.transform(androidPackageName,code)
            } else {
                compiler.transform(androidPackageName,code)
            }
            results.forEach[
                if (!outDir.exists()) {
                    outDir.mkdirs()
                }
                var writer = new PrintWriter(new File(outDir.absolutePath+File.separator+it.name+ext), "UTF-8");
                writer.print(toString);
                writer.close();
            ]

        } else if (file.absolutePath.endsWith(".css")) {

            var filePath = file.toPath;
            var fileName = filePath.fileName.toString
            var packageName = rootDir.relativize(filePath).map[toString].join(".").replace("."+fileName,"")
            var code = new String(Files.readAllBytes(file.toPath));
            var out = cssCompiler.compile(packageName,fileName, code)
            var outFileJava = outDir.absolutePath+File.separator+CssCompiler.toClass(fileName)+".java";
            if (!outDir.exists()) {
                outDir.mkdirs()
            }

            var writer = new PrintWriter(new File(outFileJava), "UTF-8");
            println("Complied "+ file.absolutePath +" to "+outFileJava)
            writer.print(out);
            writer.close();

        }
    }

    def void transformDir(String androidPackageName, String dir, String out, WatchService watcher) {
        val outDir = new File(out+File.separator);
        var sourceDir = new File(dir);
        var dirPath = sourceDir.toPath
        var key = dirPath.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
        StandardWatchEventKinds.ENTRY_DELETE);
        keys.put(key, dirPath)
        keysOut.put(key, outDir)
        sourceDir.listFiles().forEach [
            if (isDirectory) {
                transformDir(androidPackageName,it.absolutePath, out + File.separator + it.name, watcher)
            } else {
                transformFile(androidPackageName,it.absoluteFile, outDir)
            }
        ]

    }

    def static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return event as WatchEvent<T>
    }


    def void transform(String androidPackageName, String source, String out, String... extensions) {
        this.extensions = if (extensions.empty) {
            #[".css",".xtend",".kt", ".java"]
        } else {
            extensions
        }

        var outDir = new File(out);
        outDir.delete
        var sourceDir = new File(source).toPath();
        rootDir = sourceDir;
        var WatchService watcher = sourceDir.getFileSystem().newWatchService();
        transformDir(androidPackageName,source, out, watcher)

    }

    def static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main SRC_DIR OUT_DIR");
            return
        }

        new Transformer().transform(args.get(0),args.get(1),".java",".xtend",".css")

    }
}
