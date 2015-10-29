package io.lattekit.dsl.layout

import com.google.inject.Injector
import java.io.ByteArrayInputStream
import java.io.InputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator

class LayoutCompilerUtil {

//	 @Inject XtextResourceSet resourceSet;
//	 @Inject JvmModelGenerator generator;
	def compileLayout(String layoutCode, (String)=>void result) {
//		new StandaloneSetup().setPlatformUri("../");
		var Injector injector = new LayoutStandaloneSetup().createInjectorAndDoEMFRegistration();

		if (!EPackage.Registry.INSTANCE.containsKey("http://www.lattekit.io/dsl/layout/Layout")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/xtext/xbase/Xbase", XbasePackage.eINSTANCE);
		}

		var XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet);
//		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		var Resource resource = resourceSet.createResource(URI.createURI("dummy:/example.lxml"));
		var InputStream in = new ByteArrayInputStream(layoutCode.getBytes());
		resource.load(in, resourceSet.getLoadOptions());
		var generator = injector.getInstance(JvmModelGenerator);


		var fsa = new IFileSystemAccess() {
			override deleteFile(String fileName) {
			}

			override generateFile(String fileName, CharSequence contents) {
				System.out.println("-----------------");
				System.out.println("GENERATING FILE " + fileName);
//				System.out.println(contents);
				result.apply(contents.toString);
			}

			override generateFile(String fileName, String outputConfigurationName, CharSequence contents) {
//				System.out.println("-----------------X");
//				System.out.println("GENERATING FILE " + fileName);
//				System.out.println(contents);
				result.apply(contents.toString);
			}
		}
		
		generator.doGenerate(resource, fsa);		

	}
//
//	static def void main(String... args) {
//		LayoutCompilerUtil.compileLayout('''
//			<RelativeLayout>
//				System.out.println("Hello");
//			</RelativeLayout>
//			
//		''') [
//			var i = it.indexOf("// START MARKER")+"// START MARKER".length;
//			var e = it.lastIndexOf("// END MARKER");
//			println(it.substring(i,e));
//		]
//	}

}
