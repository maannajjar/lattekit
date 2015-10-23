package io.lattekit

import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.charset.StandardCharsets
import java.util.List
import java.util.Map
import java.util.Stack
import java.util.concurrent.atomic.AtomicInteger
import java.util.regex.Pattern
import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.AbstractMethodProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.Type
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.xml.sax.Attributes
import org.xml.sax.SAXException
import org.xml.sax.helpers.DefaultHandler

import static org.reflections.ReflectionUtils.*
import io.lattekit.compiler.LayoutCompiler
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

@Active(typeof(LayoutProcessor))
annotation Layout {
	String[] imports = #[]
}

class LayoutProcessor extends AbstractMethodProcessor {
	
	override doTransform(MutableMethodDeclaration annotatedMethod, extension TransformationContext context) {
		super.doTransform(annotatedMethod, context)

		val layoutStr = annotatedMethod.body.toString
		annotatedMethod.markAsRead
		
		val latteViewTR = findTypeGlobally("io.lattekit.ui.LatteView").newTypeReference();
		
		var importList = newArrayList("io.lattekit.ui", "android.widget","android.support.v4.widget","android.support.v7.widget","android.support.v13.widget");
		var importListParam = annotatedMethod.annotations.findFirst[ a|
			a.annotationTypeDeclaration == Layout.newTypeReference().type
		].getStringArrayValue("imports")
		
		if (importListParam.size > 0) {
			importList += importListParam 
		}

		val isAdHoc = !(annotatedMethod.simpleName == "render" && latteViewTR.isAssignableFrom(annotatedMethod.declaringType.newTypeReference()));
		
		
		
		val layoutParser = new LayoutParserOld(isAdHoc);
		
		val layoutSource = layoutStr.substring(3,layoutStr.length-3);
		val StringBuffer output = new StringBuffer();

//		layoutParser.parseLayout(context, annotatedMethod.declaringType,  importList, layoutSource);
		if (isAdHoc) {
			annotatedMethod.returnType = latteViewTR;
		}
		
		val myClass = annotatedMethod.declaringType.newTypeReference();
		val layoutCode = if (isAdHoc) { 
			LayoutCompiler.compileLayout(context,layoutSource,annotatedMethod.declaringType as MutableClassDeclaration,"null");
		} else {
			LayoutCompiler.compileLayout(context,layoutSource,annotatedMethod.declaringType as MutableClassDeclaration,"this");
		}
		
		annotatedMethod.body = '''
			«IF !isAdHoc»
				«layoutCode»
			«ELSE»
				«layoutCode»
				«IF annotatedMethod.declaringType.findDeclaredField("latteCss") != null»
					myView.loadStylesheets(this.latteCss);
				«ENDIF»
				return myView;
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
		
		val latteViewTR = findTypeGlobally("io.lattekit.ui.LatteView").newTypeReference();
		
		var importList = newArrayList("io.lattekit.ui", "android.widget","android.support.v4.widget","android.support.v7.widget","android.support.v13.widget");
		var importListParam = annotatedField.annotations.findFirst[ a|
			a.annotationTypeDeclaration == Latte.newTypeReference().type
		].getStringArrayValue("imports")
		
		if (importListParam.size > 0) {
			importList += importListParam 
		}
		val isAdHoc = true;
		val layoutParser = new LayoutParserOld(isAdHoc);
		val layoutSource = layoutStr.substring(3,layoutStr.length-3);
//		layoutParser.parseLayout(context, annotatedField.declaringType,  importList, layoutSource);
		val layoutCode = LayoutCompiler.compileLayout(context,layoutSource,annotatedField.declaringType as MutableClassDeclaration,"this");

		annotatedField.type = latteViewTR;
		annotatedField.initializer = ''' 
		
			
			new io.lattekit.ui.LatteView() {
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

class LayoutParserOld extends DefaultHandler {
	
	@Accessors var String renderBody;
	@Accessors var boolean isAdHoc = false;
	
	TransformationContext context;
	var Stack<Map<String,Object>> elStack = new Stack<Map<String,Object>>();
	var List<String> errorList = newArrayList();
	var List<String> warningList = newArrayList();
	var List<String> importList = newArrayList();
	
	var StringBuilder currentProc = null;
	var Map<String,Object> currentEl = null;
	MutableTypeDeclaration declaringType;
	
	var tagsIncrement = 0;
	
	new(boolean isAdHoc) {
		this.isAdHoc = isAdHoc;
	}
	
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
	
	def getFunctionType(extension TransformationContext context, TypeReference type) {
		
		var procs = #[Functions.Function0,Functions.Function1,Functions.Function2,Functions.Function3,Functions.Function4,Functions.Function5,Functions.Function6]
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
	   var androidCreator = "";
	   var isAndroidView = false;
	   var Type androidViewType = null; 
	   // Find Fully Qualified name
		var findViewType = context.findViewType(elName,importList);
		if (findViewType == null) {
			errorList += "Couldn't find view with type "+ elName;
		} else {
			elName = findViewType.qualifiedName
			var androidView = context.findTypeGlobally("android.view.View");
			if (androidView.isAssignableFrom(findViewType)) {
				isAndroidView = true;
				androidViewType = findViewType;
				findViewType = context.findTypeGlobally("io.lattekit.ui.LatteView");
				androidCreator = '''
				it.setOnCreateAndroidView(new org.eclipse.xtext.xbase.lib.Functions.Function1<android.content.Context,android.view.View>() {
					public «androidViewType.qualifiedName» apply(android.content.Context context) {
							return new «elName»(context);
					}
				});'''
				elName = "io.lattekit.ui.LatteView"
			}
		}
		val viewType = findViewType;
		
		

	   var attrsProc = "";
	   var androidAttrsProc = "";
	   for ( i : 0..< attributes.length) {
			var attrName = attributes.getQName(i)
            if (attrName == null || attrName == "") {
               attrName = attributes.getQName(i);
            }
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

			val procClosureSetter = setterMethods.findFirst[
				context.getProcedureType(parameters.findFirst[true].type) != null
			];	
			
			val fnClosureSetter = setterMethods.findFirst[
				context.getFunctionType(parameters.findFirst[true].type) != null
			];	
			
			
			
			var hasSetter = !setterMethods.isEmpty
			
			var value = if (isJavaCode) {
				attrValue.replaceAll("&quot;",'''"''');	
			} else {
				'"' + attrValue.replaceAll("&quot;",'''\"''') + '"';
			}
			var processed = false;
			if (!hasSetter && isAndroidView) {
				// Try Regular Setter:
				var androidViewClass =  try { Class.forName(androidViewType.qualifiedName) } catch (Exception ex) { null };
				var allMethods = getAllMethods(androidViewClass);
				var regularSetter = allMethods.findFirst[name == propertySetter && parameterCount == 1];
				if (regularSetter != null) {
					processed = true;
					var typedValue = if (regularSetter.parameters.get(0).type == String || regularSetter.parameters.get(0).type == CharSequence) {
						value
					} else value
					
					androidAttrsProc += '''
						myView.«regularSetter.name»(«typedValue»);
					'''
				} else if (isJavaCode) {
					
					val androidListenerSetter = propertySetter +"Listener";
					var listenerSetter = allMethods.findFirst[name == androidListenerSetter && parameterCount == 1]
					if (listenerSetter != null) {
						processed = true;
						var listenerClass = listenerSetter.parameters.get(0).type
						androidAttrsProc += '''
	
							 myView.«listenerSetter.name»( new «listenerClass.name.replace("$",".")»() { 
								«FOR method: listenerClass.declaredMethods»
									«val AtomicInteger paramCount = new AtomicInteger(-1)»
									 public «method.returnType.name» «method.name»(«method.parameters.map[type.name +" $"+paramCount.incrementAndGet; ].join(",")») {
										 «value»«if (!isJavaCode) /*TODO ADD PARAM*/"()" else ""»;
									}
								«ENDFOR»
							});
						
						'''
					}
				
				}
			} 
			if (!processed && (procClosureSetter != null || fnClosureSetter != null)) { 
				val closureSetter = if (procClosureSetter != null ) procClosureSetter else fnClosureSetter; 
				var closureType = if (procClosureSetter != null ) {
					context.getProcedureType(closureSetter.parameters.findFirst[true].type).canonicalName
				} else {
					context.getFunctionType(closureSetter.parameters.findFirst[true].type).canonicalName
				}
				val returnType = if (procClosureSetter != null ) {
					"void"
				} else {
					closureSetter.parameters.findFirst[true].type.actualTypeArguments.findLast[true].upperBound.name
				}
				val typeList = closureSetter.parameters.findFirst[true].type.actualTypeArguments.map[
						if (lowerBound.name == "java.lang.Object") { upperBound.name } else { lowerBound.name }
					]
				val paramsTypeList = if (procClosureSetter != null ) {
					closureSetter.parameters.findFirst[true].type.actualTypeArguments.map[
						if (lowerBound.name == "java.lang.Object") { upperBound.name } else { lowerBound.name }
					]
				} else {
					var paramTypes = closureSetter.parameters.findFirst[true].type.actualTypeArguments 
					paramTypes.subList(0,paramTypes.length-1).map[
						if (lowerBound.name == "java.lang.Object") { upperBound.name } else { lowerBound.name }
					]
					
				}
				
				val List<String> paramList = newArrayList()
				for (index : 0..<paramsTypeList.size) {
					paramList += '''final «paramsTypeList.get(index)» $«index»''';
				}
									
				attrsProc += '''final «closureType»<«typeList.join(",")»> _«property»_handler = new «closureType»<«typeList.join(",")»>() {
						public «returnType» apply(«paramList.join(",")») {
							«context.newSelfTypeReference(declaringType)» self =  «declaringType.simpleName».this;
							«value»«if (!isJavaCode) /*TODO ADD PARAM*/"()" else ""»;
						} 
					};
					it.«propertySetter»(_«property»_handler);
					
				''';
				attrsProc += '''it.addNewProperty("«property»",_«property»_handler);'''+"\n";
			} else if (hasSetter) {
				attrsProc += '''it.«propertySetter»(«value»);'''+"\n";
				attrsProc += '''it.addNewProperty("«property»",«value»);'''+"\n";
			} else if (!processed) {
				attrsProc += '''it.setAttribute("«property»",«value»);'''+"\n";
				attrsProc += '''it.addNewProperty("«property»",«value»);'''+"\n";
			}
			
	   }
	   
	   currentProc = new StringBuilder();
	   currentProc.append('''
			final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<«elName»> «attrProcName» = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<«elName»>() {
			public void apply(final «elName» it) {
					«androidCreator»
				«IF isAndroidView»					
					it.setOnApplyAttributes(new Runnable() {
						public void run() {
							«androidViewType.qualifiedName» myView = («androidViewType.qualifiedName»)it.getAndroidView();
							«androidAttrsProc»
						}
					});
				«ENDIF»
					«attrsProc»
				}
			};
			
			final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<«elName»> «childProcName» = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<«elName»>() {
			public void apply(final «elName» it) {
	   ''');
	   
	   if (currentEl != null) {
			elStack.push(currentEl);
	   }		       
	   currentEl = newHashMap( 
		"name" -> if (isAndroidView)  "io.lattekit.ui.LatteView" else elName,
		"simpleName" -> if (isAndroidView)  "LatteView" else tagSimpleName,
		"tagSimpleName" -> tagSimpleName,
		"childrenProcBody"-> currentProc,
		"attrProcBody" -> "",
		"childrenProcName" -> childProcName,
		"attrProcName" -> attrProcName,
		"childCount" -> 0
	   );
	     				
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
			var currentChildCount = currentEl.get("childCount") as Integer;
			currentProc.append(myProc);
			currentProc.append('''
				«myEl.get('name')» subView«myEl.get('tagSimpleName')»_«currentChildCount» = new «myEl.get('name')»();
    			subView«myEl.get('tagSimpleName')»_«currentChildCount».processNode(it,«myEl.get('attrProcName')»,«myEl.get('childrenProcName')»);
				
			''');
			currentEl.put("childCount",currentChildCount+1);
//			currentProc.append('''«myEl.get('name')».«myEl.get('simpleName')»(it, «myEl.get('attrProcName')», «myEl.get('childrenProcName')»);''')
		} else {
			currentProc.append('''
    			«currentEl.get('name')» myView = new «currentEl.get('name')»();
    			myView.processNode(«if (isAdHoc) "null" else "this"»,«currentEl.get('attrProcName')»,«currentEl.get('childrenProcName')»);
    			«IF !this.isAdHoc»
					this.addChild(0,myView);
				«ENDIF»
			''')
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
