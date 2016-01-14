package io.lattekit

import com.google.common.base.Charsets
import com.google.common.hash.Hashing
import io.lattekit.compiler.LayoutCompiler
import java.io.IOException
import java.io.PrintWriter
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Date
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration

@Target(/*ElementType.FIELD,*/ ElementType.METHOD)
@Active(typeof(LayoutProcessor))
annotation Layout {
	String[] imports = #[]
}

class LayoutProcessor implements TransformationParticipant<MutableMemberDeclaration> {
	static Map<String,String> cachedCode = newHashMap();
	
	def static String byteArrayToHexString(byte[] b) {
	  var result = "";
	  for (var i=0; i < b.length; i++) {
	    result +=
	          Integer.toString( ( b.get(i).bitwiseAnd(0xff) ) + 0x100, 16).substring( 1 );
	  }
	  return result;
	}
			
	def static String readFile(String path, Charset encoding) throws IOException  {
	  var encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
			
	override doTransform(List<? extends MutableMemberDeclaration> elements, extension TransformationContext context) {
		elements.forEach[transform(context)]
	}
			
	def dispatch void transform(MutableFieldDeclaration annotatedMethod, extension TransformationContext context) {
	}			
	def dispatch void transform(MutableMethodDeclaration annotatedMethod, extension TransformationContext context) {
		val layoutStr = annotatedMethod.body.toString
		annotatedMethod.markAsRead
		
		val latteViewTR = findTypeGlobally("io.lattekit.ui.view.LatteView").newTypeReference();
		
		var importList = newArrayList("io.lattekit.ui.view","android.webkit", "android.widget","android.support.v4.widget","android.support.v7.widget","android.support.v13.widget");
		var importListParam = annotatedMethod.annotations.findFirst[ a|
			a.annotationTypeDeclaration == Layout.newTypeReference().type
		].getStringArrayValue("imports")
		
		if (importListParam.size > 0) {
			importList += importListParam 
		}
		

		val isAdHoc = annotatedMethod.simpleName != "render" || !latteViewTR.isAssignableFrom(annotatedMethod.declaringType.newTypeReference());
		val layoutSource = layoutStr.substring(3,layoutStr.length-3);
		var hash = importList.join(",")+layoutSource.replaceAll(" ","").replaceAll("\t","").replaceAll("\n","");
		if (isAdHoc) {
			annotatedMethod.returnType = latteViewTR;
			hash+=":adhoc";
		}
		hash  = Hashing.sha1().hashString(hash,Charsets.UTF_8).toString;
		
		var String cachedCompiled = null;
		var isCached = false;
		
//		try {
//			cachedCompiled = readFile("/tmp/"+hash+".lattekit",Charset.defaultCharset());
//			isCached = true;
//		} catch(IOException ioex) {
//			
//		}
		
		var layoutCode = if (cachedCompiled != null) {
			isCached = true
			"// Using cached compilation\n"+cachedCompiled
		} else if (isAdHoc) { 
			"/* Recompiled j"+ hash+" "+ new Date().toLocaleString +" " + cachedCode.size +" */ "
			+LayoutCompiler.compileLayout(context,layoutSource,annotatedMethod.declaringType as MutableClassDeclaration,"null",importList);
		} else {
			"/* Recompiled "+ hash+" "+ new Date().toLocaleString +" " + cachedCode.size +" */ "
			+LayoutCompiler.compileLayout(context,layoutSource,annotatedMethod.declaringType as MutableClassDeclaration,"this",importList);
		}
		if (!isCached) {
			try {
				var pw = new PrintWriter("/tmp/"+hash+".lattekit");
				pw.print(layoutCode);
				pw.flush
				pw.close
			} catch(IOException ioex) {
				layoutCode = "/** "+ioex+ "**/ \n"+ layoutCode
			}				
		}
		val lc = layoutCode;
		annotatedMethod.body = '''
			«IF !isAdHoc»
				return «lc»
			«ELSE»
				return «lc»
			«ENDIF»
		''';

	}
	
}


@Active(typeof(LayoutFieldProcessor))
annotation Latte {
	String[] imports = #[]
}

class LayoutFieldProcessor extends AbstractFieldProcessor {
	
	override doTransform(MutableFieldDeclaration annotatedField, extension TransformationContext context) {
		super.doTransform(annotatedField, context)

		val layoutStr = annotatedField.initializer.toString
		annotatedField.markAsRead
		
		val latteViewTR = findTypeGlobally("io.lattekit.ui.view.LatteView").newTypeReference();
		
		var importList = newArrayList("io.lattekit.ui.view", "android.widget","android.support.v4.widget","android.support.v7.widget","android.support.v13.widget");
		var importListParam = annotatedField.annotations.findFirst[ a|
			a.annotationTypeDeclaration == Latte.newTypeReference().type
		].getStringArrayValue("imports")
		
		if (importListParam.size > 0) {
			importList += importListParam 
		}
		val layoutSource = layoutStr.substring(3,layoutStr.length-3);
		val layoutCode = LayoutCompiler.compileLayout(context,layoutSource,annotatedField.declaringType as MutableClassDeclaration,"this",importList);

		annotatedField.type = latteViewTR;
		annotatedField.initializer = ''' 
			new io.lattekit.ui.view.LatteView() {
				public void render() {
					«layoutCode»
					«IF annotatedField.declaringType.findDeclaredField("latteCss") != null»
						myView.loadStylesheets(«annotatedField.declaringType.simpleName».this.latteCss);
					«ENDIF»
				}
			};
		''';

	}
	
	
}


