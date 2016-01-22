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

class LatteTransformer {
	var compiler = new Transformer();
	var xtendCompiler = new XtendTransformer();
	var cssCompiler = new CssCompiler();
	var Path rootDir;
	var List<String> extensions;
	
	var Map<WatchKey, Path> keys = newHashMap()
	var Map<WatchKey, File> keysOut = newHashMap()
	
	
	def void transformFile(File file, String outFile) {
		if (extensions.filter[file.absolutePath.endsWith(it)].empty) {
			return;
		}
		
		if (file.absolutePath.endsWith(".java") || file.absolutePath.endsWith(".xtend")) {
			var code = new String(Files.readAllBytes(file.toPath));
			var out = if (file.absolutePath.endsWith(".xtend")) {
					xtendCompiler.transform(code)
				} else {
					compiler.transform(code)
				}
			var writer = new PrintWriter(new File(outFile), "UTF-8");
			writer.print(out);
			writer.close();
		} else if (file.absolutePath.endsWith(".css")) {
			
			var filePath = file.toPath;
			var fileName = filePath.fileName.toString
			var packageName = rootDir.relativize(filePath).map[toString].join(".").replace("."+fileName,"")
			var code = new String(Files.readAllBytes(file.toPath));
			var out = cssCompiler.compile(packageName,fileName, code)
			var outFileJava = outFile.replace(fileName,CssCompiler.toClass(fileName)+".java");
			var writer = new PrintWriter(new File(outFileJava), "UTF-8");
			println("Complied "+ file.absolutePath +" to "+outFileJava)
			writer.print(out);
			writer.close();
			
		}
	}

	def void transformDir(String dir, String out, WatchService watcher) {
		var outDir = new File(out);
		outDir.mkdirs
		var sourceDir = new File(dir);
		var dirPath = sourceDir.toPath
		var key = dirPath.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
			StandardWatchEventKinds.ENTRY_DELETE);
		keys.put(key, dirPath)
		keysOut.put(key, outDir)
		sourceDir.listFiles().forEach [
			if (isDirectory) {
				transformDir(it.absolutePath, out + File.separator + it.name, watcher)
			} else {
				transformFile(it.absoluteFile, out + File.separator + it.name)
			}
		]

	}

	def static <T> WatchEvent<T> cast(WatchEvent<?> event) {
		return event as WatchEvent<T>
	}
	
	
	def void transform(String source, String out, String... extensions) {
		this.extensions = if (extensions.empty) {
			#[".css",".xtend",".java"]
		} else {
			extensions
		}
		
		var outDir = new File(out);
		outDir.delete
		var sourceDir = new File(source).toPath();
		rootDir = sourceDir;
		var WatchService watcher = sourceDir.getFileSystem().newWatchService();
		transformDir(source, out, watcher)
		
		/*
		try {
			for (;;) {
				var watckKey = watcher.take();
				var Path dir = keys.get(watckKey);
				var File dirOut = keysOut.get(watckKey);
				var events = watckKey.pollEvents();
				for (event : events) {
					var WatchEvent<Path> ev = cast(event);
					var Path name = ev.context();
					var Path child = dir.resolve(name);

					if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
						System.out.println("Created: " + child);
						if (Files.isDirectory(child)) {
							transformDir(child.toFile.absolutePath, dirOut + File.separator + name, watcher)
						}
					}
					if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
						System.out.println("Delete: " + child);
					}
					if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
						if (!Files.isDirectory(child)) {
							transformFile(child.toFile, dirOut + File.separator + name)
						}

					}
				}
			}
		} catch (Exception ex) {
		}
		* 
		*/
	}	
	
}
