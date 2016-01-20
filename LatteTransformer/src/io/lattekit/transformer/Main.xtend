package io.lattekit.transformer

import java.io.File
import java.io.PrintWriter
import java.nio.file.Files

class Main {

	var static compiler = new Transformer();
	var static xtendCompiler = new XtendTransformer();
	def static transformFile(File file,String outFile) {
		if (file.absolutePath.endsWith(".java") || file.absolutePath.endsWith(".xtend")) {
			var code = new String(Files.readAllBytes(file.toPath));
			var out = if (file.absolutePath.endsWith(".xtend")) { new XtendTransformer().transform(code) } else { new Transformer().transform(code) }
			System.out.println(outFile);
			var writer = new PrintWriter( new File(outFile), "UTF-8");
			writer.print(out);
			writer.close();
		}
	}
	
	def static void transformDir(String dir,String out) {
		var outDir = new File(out);
		outDir.mkdirs
		var sourceDir =  new File(dir);
		sourceDir.listFiles().forEach[
			if (isDirectory) {
				transformDir(it.absolutePath,out+File.separator+it.name)
			} else {
				transformFile(it.absoluteFile,out+File.separator+it.name)
			}
		]
		
	}
	
	def static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: java -jar transformer.jar SRC_DIR OUT_DIR");
			return
		}
		var outDir = new File(args.get(1));
		outDir.delete
		transformDir(args.get(0),args.get(1))
	}	
}