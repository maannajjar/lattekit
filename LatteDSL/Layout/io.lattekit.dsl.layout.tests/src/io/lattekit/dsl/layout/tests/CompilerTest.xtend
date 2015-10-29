package io.lattekit.dsl.layout.tests

import com.google.inject.Inject
import io.lattekit.dsl.layout.LayoutInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(LayoutInjectorProvider)
class CompilerTest {
	
	@Inject extension CompilationTestHelper
	@Inject extension ReflectExtensions
	
	def static void main() {
		
	}
	
//	@Test 
	def void testParseAndCompile_01() {
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		'''
			<!--<< >>-->
			Hello World		
		'''.compile[ 
			System.out.println(it.compiledClasses)
			
		]//		compile(resourceSet(new Pair<String, CharSequence>("test.lxml", '''
//			<!--<< >>-->
//			Hello World		
//		''')), [
//			System.out.println(compiledClass);
//			System.out.println(compiledClass);
//			System.out.println(compiledClass);
//			System.out.println(compiledClass);
//			System.out.println(compiledClass);
//			System.out.println("Hello");
//			
////			val result = compiledClass.newInstance.invoke('generate', null)			
////			System.out.println(result.toString);
//		])
//		
//		
//		'''
//			<!--<< >>-->
//			Hello World
//		'''.replace.compile [
//			val result = compiledClass.newInstance.invoke('generate', null)
//			assertEquals('Hello World',result.toString)
//		]
	}
	
	@Test
	def void testParseAndCompile_02() {
		'''
			<!--<<
				param name = 'Foo'
				param list = #['one', 'two', 'three', 'four']
			>>-->
			<html>
			  <title><<name>></title>
			</html>
		'''.replace.compile [
			val result = compiledClass.newInstance.invoke('generate', null)
			System.out.println(result.toString)
//			assertEquals('''
//				<html>
//				  <title>Foo//</title>
//				      <h1>one</h1>
//				      <h2>two</h2>
//				      <p>three</p>
//				      <p>four</p>
//				</html>'''.toString,result.toString)
		]
	}
	
	def replace(CharSequence s) {
		s.toString.replace('<<','«').replace('>>','»')
	}
}