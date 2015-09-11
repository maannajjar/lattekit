package io.lattekit

import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.charset.StandardCharsets
import java.util.List
import java.util.Map
import java.util.Stack
import java.util.regex.Pattern
import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.macro.AbstractMethodProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.xml.sax.Attributes
import org.xml.sax.SAXException
import org.xml.sax.helpers.DefaultHandler

@Active(typeof(LayoutProcessor))
annotation Layout {
	String[] imports = #[]
}
class LayoutProcessor extends AbstractMethodProcessor {
	
	override doTransform(MutableMethodDeclaration annotatedMethod, extension TransformationContext context) {
		super.doTransform(annotatedMethod, context)

		val layoutStr = annotatedMethod.body.toString
		annotatedMethod.markAsRead
		
		var importList = newArrayList("io.lattekit.ui");
		var importListParam = annotatedMethod.annotations.findFirst[ a|
			a.annotationTypeDeclaration == Layout.newTypeReference().type
		].getStringArrayValue("imports")
		
		if (importListParam.size > 0) {
			importList += importListParam 
		}
		
		val layoutParser = new LayoutParser();
		val layoutSource = layoutStr.substring(3,layoutStr.length-3);
		layoutParser.parseLayout(context, annotatedMethod.declaringType,  importList, layoutSource);
		
		annotatedMethod.returnType = findTypeGlobally("io.lattekit.ui.LatteView").newTypeReference;
		annotatedMethod.body = '''
			«layoutParser.renderBody»
		''';
	

	}
	
	
}

class LayoutParser extends DefaultHandler {
	
	@Accessors var String renderBody;
	TransformationContext context;
	var Stack<Map<String,Object>> elStack = new Stack<Map<String,Object>>();
	var List<String> errorList = newArrayList();
	var List<String> warningList = newArrayList();
	var List<String> importList = newArrayList();
	
	var StringBuilder currentProc = null;
	var Map<String,Object> currentEl = null;
	MutableTypeDeclaration declaringType;
	
	var tagsIncrement = 0;
	
	def String translateCode(String code) {
		var regex = '''@([_a-z]\w*)'''
		var p = Pattern.compile(regex);
		var matcher = p.matcher(code);
		var List<List> replaces = newArrayList();
		val newSource = new StringBuffer(code);		
		while (matcher.find) { 
			var propName = matcher.group(1);
			replaces += #[matcher.start(0),matcher.end(0),"get"+propName.substring(0,1).toUpperCase()+propName.substring(1)+"()"];
		}
		replaces.reverse.forEach[
			newSource.replace(it.get(0) as Integer ,it.get(1) as Integer , it.get(2) as String);
		]
		return newSource.toString;
	}
	
	def findViewType( extension TransformationContext context, String view, List<String> importList) {
		return importList.map[ findTypeGlobally(it+"."+view) ].findFirst[ it != null ]
	}
	
	def Iterable<? extends TypeReference> findDeclaringClasses(extension TransformationContext context, TypeReference classRef, String methodName) {
		var classes = classRef.declaredSuperTypes.filter[
			var methods = declaredResolvedMethods.filter[
				declaration.simpleName == methodName;
			]
			!methods.isEmpty
		]
		
		if (classes.isEmpty) {
			var upstreamClasses = classRef.declaredSuperTypes.map[ context.findDeclaringClasses(it, methodName)]
			return upstreamClasses.flatten
		}
		return classes
	}
	
	def getProcedureType(extension TransformationContext context, TypeReference type) {
		var procs = #[Procedures.Procedure0,Procedures.Procedure1,Procedures.Procedure2,Procedures.Procedure3,Procedures.Procedure4,Procedures.Procedure5,Procedures.Procedure6]
		procs.findFirst[ newTypeReference().isAssignableFrom(type) ]
	}
	

	def static preprocess(String sourceStr) {
		var source = sourceStr.replaceAll("< ","&lt; ").replaceAll("<=","&lt;=")
		var regex = '''([a-zA-Z0-9]+)=(\{(\\\}|[^\}])+\})'''
		var p = Pattern.compile(regex);
		var matcher = p.matcher(source);
		var List<List> replaces = newArrayList();
		val newSource = new StringBuffer(source);
		
		while (matcher.find) {
			var replaceAttr = #[matcher.start(1),matcher.end(1),"__x__"+matcher.group(1)]
			replaces += replaceAttr;
			var content = matcher.group(2);
			var contentCode = content.substring(1,content.length-1);
			var newVal = '''"«contentCode.replaceAll('''"''','''&quot;''').replaceAll('''\}''','''}''')»"'''
			var replaceVal = #[matcher.start(2),matcher.end(2),newVal]
			replaces += replaceVal
		}
		
		replaces.reverse.forEach[
			newSource.replace(it.get(0) as Integer ,it.get(1) as Integer , it.get(2) as String);
		]
		return newSource.toString;
				
	}		
	
	override startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		tagsIncrement++;
	   var childProcName = '''_createChildren_«tagsIncrement»''';
	   var attrProcName = '''_createAttributes_«tagsIncrement»''';
	   var elName = qName;
	   var tagSimpleName = elName;
	   
	   // Find Fully Qualified name
		val viewType = context.findViewType(elName,importList);
		if (viewType == null) {
			errorList += "Couldn't find view with type "+ elName;
		} else {
			elName = viewType.qualifiedName
		}

	   var attrsProc = "";
	   for ( i : 0..< attributes.length) {
			var attrName = attributes.getLocalName(i)
			var attrValue = attributes.getValue(i);
			var isJavaCode = attrName.startsWith("__x__");
			
			val property = if (attrName.startsWith("__x__")) {  attrName.substring("__x__".length); } else { attrName  }			
			val propertySetter = "set"+property.substring(0,1).toUpperCase+property.substring(1)
			
			attrsProc += '''// «propertySetter»'''+"\n";
			var List<MethodDeclaration> setterMethods = newArrayList();						
			var currentClass = viewType as ClassDeclaration
			var methods = currentClass.declaredMethods.filter[
				simpleName == propertySetter && parameters.size == 1
			]
			setterMethods += methods
			var declaringClasses = context.findDeclaringClasses(context.newTypeReference(currentClass),propertySetter)
			var upstreamMethods = declaringClasses.map[ declaredResolvedMethods ].flatten.map[ declaration ]
			setterMethods += upstreamMethods.filter[
				simpleName == propertySetter && parameters.size == 1
			]

			val closureSetter = setterMethods.findFirst[
				context.getProcedureType(parameters.findFirst[true].type) != null
			];	
			var hasSetter = !setterMethods.isEmpty
			var value = if (isJavaCode) {
				attrValue.replaceAll("&quot;",'''"''');	
			} else {
				'"' + attrValue.replaceAll("&quot;",'''\"''') + '"';
			}
			if (closureSetter != null) { 
				var closureType = context.getProcedureType(closureSetter.parameters.findFirst[true].type).canonicalName
				val typeList = closureSetter.parameters.findFirst[true].type.actualTypeArguments.map[
					lowerBound.name
				]
				val List<String> paramList = newArrayList()
				for (index : 0..<typeList.size) {
					paramList += '''final «typeList.get(index)» $«index»''';
				}
									
				attrsProc += '''final «closureType»<«typeList.join(",")»> _«property»_handler = new «closureType»<«typeList.join(",")»>() {
						public void apply(«paramList.join(",")») {
							«context.newSelfTypeReference(declaringType)» self =  «declaringType.simpleName».this;
							«value»«if (!isJavaCode) /*TODO ADD PARAM*/"()" else ""»;
						} 
					};
					it.«propertySetter»(_«property»_handler);
					
				''';
			} else if (hasSetter) {
				attrsProc += '''it.«propertySetter»(«value»);'''+"\n";
			} else {
				attrsProc += '''it.setAttribute("«property»",«value»);'''+"\n";
			}
	   }
	   
	   currentProc = new StringBuilder();
	   currentProc.append('''
			final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<«elName»> «attrProcName» = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<«elName»>() {
			public void apply(final «elName» it) {
					«attrsProc»
				}
			};
			
			final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<«elName»> «childProcName» = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<«elName»>() {
			public void apply(final «elName» it) {
			
	   ''');
	   
	   if (currentEl != null) {
			elStack.push(currentEl);
	   }		       
	   currentEl = #{ 
		"name" -> elName,
		"simpleName" -> tagSimpleName,
		"childrenProcBody"-> currentProc,
		"attrProcBody" -> "",
		"childrenProcName" -> childProcName,
		"attrProcName" -> attrProcName
	   };
	     				
	}
	
	override characters(char[] ch, int start, int length) throws SAXException {
		currentProc.append(String.copyValueOf(ch, start, length).trim())
	}
	
	override endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName)
		currentProc.append('''
			}
		};
		''')
		if (!elStack.isEmpty) { 
			var myEl = currentEl;
			var myProc = currentProc;		   			
			currentEl = elStack.pop();
			currentProc = currentEl.get("childrenProcBody") as StringBuilder;
			currentProc.append(myProc);
			currentProc.append('''«myEl.get('name')».«myEl.get('simpleName')»(it, «myEl.get('attrProcName')», «myEl.get('childrenProcName')»);''')
		} else {
			currentProc.append("return ");
			currentProc.append('''«currentEl.get('name')».«currentEl.get('simpleName')»(this, «currentEl.get('attrProcName')», «currentEl.get('childrenProcName')»);''')
			renderBody = translateCode(currentProc.toString);		   			
		}
		
				
	}
	
	def parseLayout(extension TransformationContext context,MutableTypeDeclaration declaringType, List importList, String layoutStr) {
		this.context = context;
		this.importList = importList;
		this.declaringType = declaringType
		
		var source = preprocess(layoutStr);


    	var SAXParserFactory parserFactor = SAXParserFactory.newInstance();
    	var SAXParser parser = parserFactor.newSAXParser();
    	var InputStream stream = new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8));
		parser.parse(stream, this)
		var Stack<Map<String,Object>> elStack = new Stack<Map<String,Object>>();
	}
	
}
