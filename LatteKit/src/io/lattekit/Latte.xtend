package io.lattekit

import io.lattekit.ui.view.LatteView
import java.io.File
import java.io.PrintWriter
import java.util.Arrays
import java.util.Collections
import java.util.Set
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedAnnotationTypes
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic
import javax.tools.JavaFileObject.Kind
import javax.tools.StandardLocation
import javax.tools.ToolProvider

class Latte {
	
	def static compile(String view) {
			
	}
	def static void main(String[] args) {

      var files = getSourceFiles("src") + getSourceFiles("xtend-gen");
      
      var compiler = ToolProvider.getSystemJavaCompiler();	  
      var task = compiler.getTask(new PrintWriter(System.out), null, null, #["-cp","test-libs/android.jar:test-libs/classes","-d","test-out"], null, files);
      task.setProcessors(Arrays.asList(new LatteCompiler()));

      task.call();
		
	}
	
	def static getSourceFiles(String p_path) throws Exception {
     var compiler = ToolProvider.getSystemJavaCompiler();
     var files = compiler.getStandardFileManager(null, null, null);

     files.setLocation(StandardLocation.SOURCE_PATH, Arrays.asList(new File(p_path)));

     var fileKinds = Collections.singleton(Kind.SOURCE);
     return files.list(StandardLocation.SOURCE_PATH, "", fileKinds, true);
   }
}

@SupportedAnnotationTypes("io.lattekit.LatteLayout")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
class LatteCompiler extends AbstractProcessor {
	String[] stream;
	int currentIndex;
	def LatteView compile(String code) {
		
	}
	
	override process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		annotations.forEach[
			var file = processingEnv.getFiler().getResource(StandardLocation.SOURCE_OUTPUT, "",it.asType().toString().replace(".", "/") + ".java");
			processingEnv.messager.printMessage(Diagnostic.Kind.NOTE,"Hmmm "+file.toUri)
		]
		return true
	}
	
}