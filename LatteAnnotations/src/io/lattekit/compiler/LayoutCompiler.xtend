package io.lattekit.compiler

import io.lattekit.compiler.LatteLayoutCompiler.ContextAdapter
import io.lattekit.compiler.LatteXtendParser.BlockBodyContext
import io.lattekit.compiler.LatteXtendParser.BlockStatementContext
import io.lattekit.compiler.LatteXtendParser.ExpressionContext
import io.lattekit.compiler.LatteXtendParser.ExpressionListContext
import io.lattekit.compiler.LatteXtendParser.ForControlContext
import io.lattekit.compiler.LatteXtendParser.LocalVariableDeclarationContext
import io.lattekit.compiler.LatteXtendParser.LocalVariableDeclarationStatementContext
import io.lattekit.compiler.LatteXtendParser.PrimaryContext
import io.lattekit.compiler.LatteXtendParser.StatementContext
import io.lattekit.compiler.LatteXtendParser.TypeContext
import io.lattekit.compiler.LatteXtendParser.XmlElementContext
import java.io.StringReader
import java.lang.reflect.Field
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.lang.reflect.ParameterizedType
import java.util.HashMap
import java.util.List
import java.util.Map
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference

import static org.reflections.ReflectionUtils.*
import io.lattekit.compiler.LatteXtendParser.StyleMapLiteralBodyContext

class LayoutCompiler {

	def static compileLayout( extension TransformationContext context, String input, MutableClassDeclaration myClass, String attachToObjectName,List<String> importList) {
		var lexer = new LatteXtendLexer(new ANTLRInputStream(new StringReader(input)));
    	var parser = new LatteXtendParser(new CommonTokenStream(lexer));
		var walker = new LatteLayoutCompiler;
		walker.myClass = myClass
		walker.transformationContext = context;
		walker.myTypeReference = myClass.newTypeReference()
		walker.attachToObject = attachToObjectName
		walker.importList = importList;
		var node = walker.visit(parser.blockBody);
		return node.generatedCode
	}
	
	def getOut() {
		return System.out
	}
	
}

class CompiledExpression {
	@Accessors ParserRuleContext context;
	@Accessors String generatedCode;
	@Accessors Type type;
	@Accessors List<CompiledExpression> children = newArrayList();
	
	// For Identifier expressions
	@Accessors FieldDeclaration mutableField
	@Accessors Iterable<? extends MethodDeclaration> mutableSetterMethods
	@Accessors Iterable<? extends MethodDeclaration> mutableAllMethods
	@Accessors MethodDeclaration mutableGetterMethod

	@Accessors Field field
	@Accessors Iterable<Method> setterMethods
	@Accessors Iterable<Method> allMethods
	@Accessors Method getterMethod
	
	@Accessors String preferredAccess;
	@Accessors String prefix;
	@Accessors String generatedVariableName;
	
}

class Type {

	public String typeName;
	public Class<?> clazz;
	public ClassDeclaration xtendClazz;
	public Field field;
	public FieldDeclaration xtendField;
	public Package pkg;
	public boolean isNull;
	public boolean isLayout;
	public boolean isPrimitive;
	public boolean isArray;
	public boolean isArrayLiteral;
	public boolean isPackageRef;
	public boolean isClassRef;
	public boolean isBoxed;
	public int arrayDimensions;
	public Type arrayChildType;
	
	new() {}
	new(boolean isNull) { this.isNull = isNull;}
	def static Type newBuiltInType(String typeName,boolean isPrimitive, boolean isBoxed) {
		var t = new Type();
		t.typeName = typeName;
		t.isPrimitive = isPrimitive
		t.isBoxed = isBoxed;
		try {
			t.clazz = Class.forName(typeName);
		} catch (Exception ex) {}
		return t;
		
	}
	def static Type newBuiltInType(String typeName,boolean isPrimitive) {
		var t = new Type();
		t.typeName = typeName;
		t.isPrimitive = isPrimitive
		try {
			t.clazz = Class.forName(typeName);
		} catch (Exception ex) {}
		return t;
	}
	
	def static Type packageRef(Package pkg) {
		var type = new Type();
		type.pkg = pkg;
		type.isPackageRef = true;
		type.typeName = pkg.name
		return type;
	}
	
	def static Type classRef(Class<?> clz) {
		var type = new Type();
		type.clazz = clz;
		type.isClassRef = true;
		type.typeName = clz.name
		return type;
	}
	
	def static Type classRef(TypeReference tr,MutableClassDeclaration clazz) {
		var type = new Type();
		type.xtendClazz = clazz;
		type.isClassRef = true;
		type.typeName = tr.name
		return type;
	}
	def static Type arrayLiteralWithType(Type childrenType) {
		var type = new Type();
		type.arrayChildType = childrenType;
		type.isArrayLiteral = true;
		return type;
	}
	def static Type fromField(Field field) {	
		var type = fromClass(field.type)
		type.field = field;
		return type
	}
	
	def static Type fromClass(Class<?> clazz) {
		if (builtInTypes.get(clazz.name) != null) {
			return builtInTypes.get(clazz.name)
		}
		
		var type = new Type();
		type.clazz = clazz;
		type.isPrimitive = clazz.isPrimitive;
		type.typeName = clazz.name
		type.isArray = clazz.isArray
		return type;
	}
	
	def static Type fromTypeReference(TypeReference typeReference, ClassDeclaration clazz) {
		var type = new Type();
		type.xtendClazz = clazz;
		type.isPrimitive = typeReference.isPrimitive;		
		type.typeName = typeReference.name
		type.isArray = typeReference.isArray
		return type;
	}	
	
	def static Type fromFieldTypeReference(TypeReference typeReference, FieldDeclaration field) {
		var type = new Type();
//		type.xtendClazz = field.type as ClassDeclaration;
		type.xtendField = field
		type.isPrimitive = typeReference.isPrimitive;		
		type.typeName = typeReference.name
		type.isArray = typeReference.isArray
		return type;
	}	
	
	def getBoxed() {
		if (isPrimitive) {
			return boxedTypes.get(typeName)
		} else {
			return this;
		}
	}
	
	def getTypeParameter() {
		if (xtendField != null) {
			if (xtendField.type.inferred) {
			//	TODO: Compile initializer and infer type
			//				return xtendField.initializer.toString
			} else {
				return xtendField.type.actualTypeArguments.get(0).simpleName
			}
		}
		return (field.genericType as ParameterizedType).actualTypeArguments.get(0).typeName
	}
	
	public val static NULL = new Type(true)
	public val static VOID = newBuiltInType("void", true)		
	public val static BOOLEAN = newBuiltInType("boolean", true)
	public val static FLOAT = newBuiltInType("float", true)
	public val static DOUBLE = newBuiltInType("double", true)
	public val static LONG = newBuiltInType("long", true)
	public val static INTEGER = newBuiltInType("int", true)
	public val static CHAR = newBuiltInType("char", true)	
	public val static STRING = newBuiltInType("java.lang.String", false)
	
	public val static builtInTypes = #{
		'void' -> VOID,
		'boolean'-> BOOLEAN,
		'float'-> FLOAT,
		'double'-> DOUBLE,
		'long'-> LONG,
		'int'-> INTEGER,
		'char'-> CHAR,
		'java.lang.String'-> STRING
	}
	public val static boxedTypes = #{
		'boolean'-> newBuiltInType("java.lang.Boolean", false,true),
		'float'-> newBuiltInType("java.lang.Float", false,true),
		'double'-> newBuiltInType("java.lang.Double", false,true),
		'long'-> newBuiltInType("java.lang.Long", false,true),
		'int'-> newBuiltInType("java.lang.Integer", false,true),
		'char'-> newBuiltInType("java.lang.Char", false,true),
		'java.lang.String'-> STRING
	}
	
}


class LatteLayoutCompiler extends LatteXtendBaseVisitor<CompiledExpression> {
	
	interface ContextAdapter {
		def Class<?> findClass(String typeName)
		def Package findPackage(String typeName)		
		def TypeReference getMyTypeReference()
		def MutableClassDeclaration getMyClass()
	}
	
	@Accessors MutableClassDeclaration myClass;
	@Accessors TypeReference myTypeReference
	@Accessors String attachToObject;
	@Accessors TransformationContext transformationContext;
	List<Map<String,Type>> scope = newArrayList();
	List<String> viewStack = newArrayList();
	@Accessors List<String> importList;
	
	int viewCounter = 0;
	
	

	ContextAdapter jvmContext = new ContextAdapter() {
		override findClass(String typeName) {
			
			var imports = #["", "java.lang"];
			var results = imports.map[
				try { 
					Class.forName(if (it != "") it+"."+typeName else typeName);
				} catch (Exception ex) {
					null;
				}
			].filterNull.toList			
			if (results.length > 0) results.get(0) else null;
		}
		
		override findPackage(String typeName) {
			Package.getPackage(typeName)
		}
		
		override getMyTypeReference() {
			return myTypeReference
		}
		
		override getMyClass() {
			return myClass
		}
		
	}
	
	override visitBlockStatement(BlockStatementContext ctx) {
		var compiled = new CompiledExpression();
		compiled.type = Type.NULL;
		compiled.context = ctx;
		var type = 0;
		if (ctx.localVariableDeclarationStatement != null) {
			var compiledDeclaration = visit(ctx.localVariableDeclarationStatement);
			compiled.children += compiledDeclaration;
			compiled.type = compiledDeclaration.type;
			compiled.generatedCode = compiledDeclaration.generatedCode

		} else if (ctx.statement != null) {
			var compiledStatement = visit(ctx.statement);
			compiled.children += compiledStatement;
			compiled.type = compiledStatement.type;
			compiled.generatedCode = compiledStatement.generatedCode
			
		} 
		
		return compiled
	}
	
	override visitStatement(StatementContext ctx) {
		var compiled = new CompiledExpression();
		if (ctx.xblock != null) {
			compiled = this.visitBlockBody(ctx.xblock.blockBody);
			compiled.generatedCode = '''
			{
				«compiled.generatedCode»
			}
			'''
		} else  if (ctx.xif != null) {
			var stmt = visit(ctx.stmt)
			compiled.type = stmt.type
			compiled.generatedCode = '''if «visit(ctx.parExpression).generatedCode» «stmt.generatedCode»'''
			if (ctx.xelse != null) {
				var e_stmt = visit(ctx.e_stmt)
				// TODO: handle primitives
				if (e_stmt.type.clazz.isAssignableFrom(stmt.type.clazz)) {
					compiled.type = e_stmt.type;
				} else if (stmt.type.clazz.isAssignableFrom(e_stmt.type.clazz)) {
					compiled.type = stmt.type;
				} else {
					// TODO: Find first common ancestor
					compiled.type = Type.fromClass(Object)
				}
				compiled.generatedCode = compiled.generatedCode + " else "+e_stmt.generatedCode
				
			}
		} else if (ctx.xfor != null) {
			
			var HashMap<String,Type> forScope = newHashMap();
			scope.add(forScope); 
			var forControl = visit(ctx.forControl);
			var stmt = if (ctx.stmt.block != null) { 
				// This insures variables declared in for control are included in the current scope
				visitBlockBody(ctx.stmt.block.blockBody,forScope);
			} else {
				visit(ctx.stmt);
			}

			compiled.type = stmt.type
			compiled.generatedCode = '''
			for «forControl.generatedCode» {
				«stmt.generatedCode»
			}
			'''
		} else if (ctx.xwhile != null) {
			var stmt = visit(ctx.stmt)
			compiled.type = stmt.type
			compiled.generatedCode = '''while «visit(ctx.parExpression).generatedCode» «stmt.generatedCode»'''
		} else if (ctx.xexpr != null) {
			var expr = visit(ctx.xexpr)
			compiled.type = expr.type
			compiled.generatedCode = expr.generatedCode
		} else {
			compiled.generatedCode = ctx.text;
		}
		return compiled;
		
	}
	
	override visitExpressionList(ExpressionListContext ctx) {
		val compiled = new CompiledExpression();
		compiled.generatedCode = ctx.expression.map[expr | var c = visit(expr); compiled.children += c;c.generatedCode ].reduce([c1, c2 | c1 +"," + c2])
		return compiled;
	}
		
	override visitForControl(ForControlContext ctx) {
		super.visitForControl(ctx)
		var compiled = new CompiledExpression();
		if (ctx.enhancedForControl != null)  {
			compiled.generatedCode = "(final ";
			var compiledExpr = visit(ctx.enhancedForControl.expression)
			var xType = Type.NULL;  
			if (ctx.enhancedForControl.type != null) {
				compiled.generatedCode = compiled.generatedCode + ctx.enhancedForControl.type
				xType = lookupType(ctx.enhancedForControl.type);
			} else {
				// TODO: infer type from ctx.expression
				if (compiledExpr.type.isArrayLiteral) {
					xType = compiledExpr.type.arrayChildType
				} else {
					xType = lookupType(compiledExpr.type.typeParameter)
				}
				compiled.generatedCode = compiled.generatedCode + xType.typeName
				
			}
			compiled.generatedCode = compiled.generatedCode + " "+ ctx.enhancedForControl.variableDeclaratorId.text +" : "+compiledExpr.generatedCode +") "
			scope.last.put(ctx.enhancedForControl.variableDeclaratorId.text,xType);
		} else {
			var compiledInit =  if (ctx.forInit.localVariableDeclaration != null) {
				visitLocalVariableDeclaration(ctx.forInit.localVariableDeclaration)
			} else {
				visitExpressionList(ctx.forInit.expressionList);
			}
			var compiledTestExpr = if (ctx.expression != null) visit(ctx.expression) else null
			var compiledUpdate = if (ctx.forUpdate?.expressionList != null) visit(ctx.forUpdate.expressionList) else null;
			compiled.generatedCode = "("+compiledInit.generatedCode
			if (compiledTestExpr != null) compiled.generatedCode = compiled.generatedCode + compiledTestExpr.generatedCode 
			else compiled.generatedCode  = compiled.generatedCode +";"
			compiled.generatedCode = compiled.generatedCode +";"
			if (compiledUpdate != null) compiled.generatedCode = compiled.generatedCode + compiledUpdate.generatedCode
			compiled.generatedCode = compiled.generatedCode+ ")"
		}
		
		return compiled
	}
	
	def visitBlockBody(BlockBodyContext ctx, Map<String,Type> blockScope) {
		if (blockScope == null) {
			scope.add(new HashMap<String,Type>());			
		}
		
		val compiled = new CompiledExpression();
		compiled.type = Type.NULL;
		compiled.context = ctx;
		compiled.generatedCode = ""
		ctx.blockStatement.forEach[ child, index |
			var compiledChild = visit(child);
			compiled.children += compiledChild;
			compiled.generatedCode = compiled.generatedCode + "\n" + compiledChild.generatedCode
			if (!compiledChild.generatedCode.replace("\n","").trim().endsWith("}") && !compiledChild.generatedCode.replace("\n","").trim().endsWith(";")) { 
				compiled.generatedCode =  compiled.generatedCode+ ";";
			}
			if (index == ctx.blockStatement.size-1) {
				compiled.type = compiledChild.type;
			} 
		]
		scope.remove(scope.last)
		return compiled;		
	}	
	
	override visitBlockBody(BlockBodyContext ctx) {
		return visitBlockBody(ctx,null);
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
	
	override visitStyleMapLiteralBody(StyleMapLiteralBodyContext ctx) {
		var compiled = new CompiledExpression();
		var styleType = transformationContext.findTypeGlobally("io.lattekit.ui.style.Style")
		compiled.type = Type.fromTypeReference(transformationContext.newTypeReference(styleType), styleType as ClassDeclaration);
		
		compiled.generatedCode = "io.lattekit.ui.style.Style.newStyle("+ctx.styleMapLiteralElement.map[
			var valueCode = if (value != null) {
				value.visit.generatedCode
			} else if (sizeLiteral != null) {
				switch (sizeLiteral.text) {
					case "fill_parent": "new io.lattekit.ui.style.NumberValue(io.lattekit.ui.view.LatteView.MATCH_PARENT,0)"
					case "match_parent": "new io.lattekit.ui.style.NumberValue(io.lattekit.ui.view.LatteView.MATCH_PARENT,0)"
					case "wrap_content": "new io.lattekit.ui.style.NumberValue(io.lattekit.ui.view.LatteView.WRAP_CONTENT,0)"
				}
				
			}
			if (Identifier != null) {
				'"'+Identifier.text + "\","+ valueCode
			} else {
				key.visit.generatedCode + ","+ valueCode
			}
		].join(",")+")"
		return compiled
	}
	
	override visitXmlElement(XmlElementContext ctx) {
		val compiled = new CompiledExpression();
		compiled.type = Type.VOID
		compiled.type.typeName = "XMLLAYOUT";
		compiled.type.isLayout = true;
		val variableName = if (viewStack.empty) "myView"  else "subView"+ viewCounter++;
		compiled.generatedVariableName = variableName;
		viewStack += variableName 
		var rootView = viewStack.length == 1
		var latteViewType = "io.lattekit.ui.view.LatteView";
		
		var imports = importList + newArrayList("io.lattekit.ui.view", "android.widget","android.support.v4.widget","android.support.v7.widget","android.support.v13.widget", "android.view");
		
				
		var isNativeView = false;
		var androidViewType = "";
		var androidCreator = "";
		val List<String> androidAttrsProc = newArrayList();
		var findViewType = transformationContext.findViewType(ctx.el.text,imports.toList);
		if (findViewType == null) {
			// TODO :Error
		}  else {
			var androidView = transformationContext.findTypeGlobally("android.view.View");
			if (androidView.isAssignableFrom(findViewType)) {
				isNativeView = true
				androidViewType = findViewType.qualifiedName
				androidCreator = '''
				it.setOnCreateAndroidView(new org.eclipse.xtext.xbase.lib.Functions.Function1<android.content.Context,android.view.View>() {
					public «findViewType.qualifiedName» apply(android.content.Context context) {
							return new «findViewType.qualifiedName»(context);
					}
				});'''
			} else {
				latteViewType = findViewType.qualifiedName
			}
		}

		val List<String> attrCode = newArrayList()
		val mutableType = transformationContext.findTypeGlobally(latteViewType);
		val viewType = Type.fromTypeReference(transformationContext.newTypeReference(mutableType),mutableType as ClassDeclaration)
		compiled.type = viewType;
		compiled.generatedCode = "// "+ mutableType.simpleName
		
		val isAndroidView = isNativeView;
		val androidViewTypeName = androidViewType
		ctx.xmlAttribute.forEach[ attr |
			val propertySetter = "set"+attr.Identifier.text.substring(0,1).toUpperCase+attr.Identifier.text.substring(1)
			var compiledExpr = new CompiledExpression();
			findReferencedMember(compiledExpr,viewType,attr.Identifier.text, false);
			
			
			var List<MethodDeclaration> setterMethods = newArrayList();						
			var currentClass = mutableType as ClassDeclaration
			var methods = currentClass.declaredMethods.filter[
				simpleName == propertySetter && parameters.size == 1
			]
			setterMethods += methods
			var declaringClasses = transformationContext.findDeclaringClasses(transformationContext.newTypeReference(currentClass),propertySetter)
			var upstreamMethods = declaringClasses.map[ declaredResolvedMethods ].flatten.map[ declaration ]
			setterMethods += upstreamMethods.filter[
				simpleName == propertySetter && parameters.size == 1
			]

//			val procClosureSetter = setterMethods.findFirst[
//				transformationContext.getProcedureType(parameters.findFirst[true].type) != null
//			];	
//			
//			val fnClosureSetter = setterMethods.findFirst[
//				transformationContext.getFunctionType(parameters.findFirst[true].type) != null
//			];	
			
			var hasSetter = !setterMethods.isEmpty
									
			var code = "";
			var value = "";
			if (attr.Identifier.text == "style"  && attr.styleMapLiteralBody != null) {
				// TODO: Handle regular map literal body (not style)
				var valueExpr = visit(attr.styleMapLiteralBody);
				value = valueExpr.generatedCode;
				code = '''it.setStyle(«value»);'''
				
			} else if (compiledExpr.preferredAccess == null && !hasSetter) {
				if (isAndroidView) {
					if (attr.expression !=null) {
						// JavaCode
						value = visit(attr.expression).generatedCode
						code = '''it.setAttribute("«attr.Identifier.text»", «value»);'''
					} else {
						value = attr.StringLiteral.text
						code = '''it.setAttribute("«attr.Identifier.text»", «value»);'''
					}									
					// Try Regular Setter:
					var androidViewClass =  try { Class.forName(androidViewTypeName) } catch (Exception ex) { null };
					var allMethods = getAllMethods(androidViewClass);
					var regularSetter = allMethods.findFirst[name == propertySetter && parameterCount == 1];
					if (regularSetter != null) {
						var typedValue = if (regularSetter.parameters.get(0).type == String || regularSetter.parameters.get(0).type == CharSequence) {
							value
						} else value
						
						androidAttrsProc += '''
							myView.«regularSetter.name»(«typedValue»);
						'''
					}
				} else {
					if (attr.expression !=null) {
						// JavaCode
						value = visit(attr.expression).generatedCode
						code = '''it.setAttribute("«attr.Identifier.text»", «value»);'''
					} else {
						value = attr.StringLiteral.text
						code = '''it.setAttribute("«attr.Identifier.text»", «value»);'''
					}									
					
				}
			} else if (hasSetter) {
				if (viewType.xtendClazz != null) {
//					code = "it."+compiledExpr.mutableSetterMethods.get(0).simpleName+"(";
					code = "it."+propertySetter+"(";
				} else {
					code = "it."+propertySetter+"(";
				}			
				if (attr.expression !=null) {
					// JavaCode
					value = visit(attr.expression).generatedCode
					code += value+");"
				} else {
					value = attr.StringLiteral.text
					code += value+");";
				}
			}
			code += '''it.addNewProperty("«attr.Identifier.text»",«value»);'''
			attrCode += code;
			
		]

		var xmlAttributesProc = '''
		final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<«latteViewType»> «variableName»_attrsProc = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<«latteViewType»>() {
			public void apply(final «latteViewType» it) {
				«FOR c: attrCode»
					«c»
				«ENDFOR»
				«IF isNativeView»					
					«androidCreator»
					it.setOnApplyAttributes(new Runnable() {
						public void run() {
							«androidViewType» myView = («androidViewType»)it.getAndroidView();
							«FOR c : androidAttrsProc»
								«c»
							«ENDFOR»
						}
					});
				«ENDIF»
			}
		};
		'''
		var childCode = ctx.blockStatement.map[
			visit.generatedCode
		]
		

		val isLatteSubclass = jvmContext.myTypeReference.isAssignableFrom(transformationContext.newTypeReference(transformationContext.findTypeGlobally(latteViewType)));
		var childrenProc = '''
		final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<«latteViewType»> «variableName»_childrenProc = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<«latteViewType»>() {
			public void apply(final «latteViewType» it) {
				«FOR child: childCode»
					«child»
				«ENDFOR»
			}
		};
		'''		
		compiled.generatedCode = '''
		«latteViewType» «variableName» = new «latteViewType»();
		«xmlAttributesProc»
		«childrenProc»
		«IF rootView»
			«variableName».processNode(«attachToObject», «variableName»_attrsProc, «variableName»_childrenProc); 
			«IF attachToObject != "null"»this.addChild(0,«variableName»);«ENDIF»
		«ELSE»
			«variableName».processNode(it, «variableName»_attrsProc, «variableName»_childrenProc);
		«ENDIF»
		
		''' 
		return compiled;
	}
	
	
	def lookupLocalVariableType(String variableName) {
		return scope.findLast[ containsKey(variableName) ]?.get(variableName)
	}
	
	def Type lookupType(String typeName) {
		var type = transformationContext.findTypeGlobally(typeName)
		var typeReference = transformationContext.newTypeReference(type);
		Type.fromTypeReference(typeReference,null);
		
	}
	def Type lookupType(TypeContext typeContext) {
		if (typeContext.classOrInterfaceType != null) {
			var String className = typeContext.classOrInterfaceType.Identifier.map[text].reduce[p1, p2| p1+"."+p2];
			var myType = new Type();
			myType.clazz = jvmContext.findClass(className)
			myType.typeName = myType.clazz.simpleName
			if (typeContext.arrayType != null) {
				myType.isArray = typeContext.arrayType.length > 0
				myType.arrayDimensions = typeContext.arrayType.length;
			}
			return myType
		} else if (typeContext.primitiveType != null) {
			var myType = new Type();
			myType.typeName = typeContext.primitiveType.text
			myType.isPrimitive = true;
			if (typeContext.arrayType != null) {
				myType.isArray = typeContext.arrayType.length > 0
				myType.arrayDimensions = typeContext.arrayType.length;
			}
			return myType
			
		}
	}
	
	override visitLocalVariableDeclarationStatement(LocalVariableDeclarationStatementContext ctx) {
		return visitLocalVariableDeclaration(ctx.localVariableDeclaration)
	}
	
	override visitLocalVariableDeclaration(LocalVariableDeclarationContext ctx) {
		val compiled = new CompiledExpression();
			compiled.generatedCode = ""
			if (ctx.mod.text == "val") {
				compiled.generatedCode = "final ";
			}
		
		if (ctx.type != null) {
			compiled.type = lookupType(ctx.type);
			compiled.generatedCode = compiled.generatedCode + ctx.type.text
		} else {
			// Infer type from expression
			var compiledRHS = visit(ctx.variableDeclarator.variableInitializer) 
			compiled.children += compiledRHS;
			compiled.type = compiledRHS.type;
			compiled.generatedCode = compiled.generatedCode + compiled.type.typeName
		}
		
		// TODO: arrayInitializer
		var initializer = visit(ctx.variableDeclarator.variableInitializer.expression)
		compiled.generatedCode = compiled.generatedCode + " "+ ctx.variableDeclarator.variableDeclaratorId.text
		compiled.generatedCode = compiled.generatedCode +" = "+initializer.generatedCode
		if (!compiled.generatedCode.endsWith(";")) {
			compiled.generatedCode = compiled.generatedCode +";";
		}
		scope.last.put(ctx.variableDeclarator.variableDeclaratorId.text, compiled.type);
		return compiled;
	}
	
	
	override visitExpression(ExpressionContext ctx) {
		val compiled = new CompiledExpression();
		compiled.context = ctx;
		if (ctx.xmlElement != null) {
			return visit(ctx.xmlElement);
		} else if (ctx.op_math != null) {
			var leftCompiled = this.visit(ctx.left)
			var rightCompiled = this.visit(ctx.right)
			var typeNumbers = #[ "java.lang.String", "double", "float", "long", "int", "char"]
			// TODO: Check incompatible types
			var leftNum = typeNumbers.indexOf(leftCompiled.type.typeName);
			var rightNum = typeNumbers.indexOf(rightCompiled.type.typeName);			
			if (leftNum < rightNum) {
				compiled.type = leftCompiled.type
			}  else {
				compiled.type = rightCompiled.type
			}
			compiled.children += leftCompiled;
			compiled.children += rightCompiled;
			compiled.generatedCode = leftCompiled.generatedCode + ctx.op_math.text + rightCompiled.generatedCode
			
			return compiled
		} else if (ctx.logical_op != null) {
			compiled.type = Type.BOOLEAN
			// TODO: Type checking
			var left = this.visit(ctx.left);
			var right = this.visit(ctx.right);
			compiled.children += left
			compiled.children += right
			compiled.generatedCode = left.generatedCode + ctx.logical_op.text + right.generatedCode 	
			return compiled
		} else if (ctx.assign_op != null) {
			// TODO: Type checking
			var left = this.visit(ctx.left);
			var right = this.visit(ctx.right); 
			compiled.type = left.type
			compiled.children += left;
			compiled.children += right			
			if (right.generatedVariableName != null) {
				compiled.generatedCode =  right.generatedCode +"\n" +left.generatedCode  + ctx.assign_op.text + right.generatedVariableName+";"
			} else {
				compiled.generatedCode = left.generatedCode + ctx.assign_op.text + right.generatedCode
			}
			return compiled
		} else if (ctx.instanceof_op != null) {
			// TODO: Type checking			
			compiled.type = Type.BOOLEAN
			compiled.children +=  this.visit(ctx.left)
			compiled.children += this.visit(ctx.right)
			return compiled
		} else if (ctx.instanceof_op != null) {
			compiled.type = Type.BOOLEAN
			compiled.children +=  this.visit(ctx.left)
			compiled.children += this.visit(ctx.right)
			return compiled;
		} else if (ctx.as_op != null) {
			compiled.type = lookupType(ctx.type);
			compiled.children +=  this.visit(ctx.left)
		} else if (ctx.postfix_op != null || ctx.prefix_op != null) {
			var expr = visit(ctx.expr); 
			compiled.type =  expr.type;
			if (ctx.postfix_op != null) {
				compiled.generatedCode = expr.generatedCode + ctx.postfix_op.text
			} else {
				compiled.generatedCode = ctx.prefix_op.text + expr.generatedCode 
			}
		} else if (ctx.range_op != null) {
			
			var left = this.visit(ctx.left);
			var right = this.visit(ctx.right); 
			var typeNumbers = #[ "double", "float", "long", "int", "char"]
			// TODO: Check incompatible types
			var leftNum = typeNumbers.indexOf(left.type.typeName);
			var rightNum = typeNumbers.indexOf(right.type.typeName);
			var type =  (if (leftNum < rightNum) left.type else  right.type).boxed
			compiled.type = Type.arrayLiteralWithType(type) /* TODO: FIND COMMON ANCESRTOR */
			compiled.type.typeName = '''org.eclipse.xtext.xbase.lib.«type.typeName.replace("java.lang.","")»Range''';
			compiled.generatedCode = '''new org.eclipse.xtext.xbase.lib.«type.typeName.replace("java.lang.","")»Range(«left.generatedCode»,«right.generatedCode»)'''
			
		} else if (ctx.arrayLiteral != null || ctx.newArrayList != null) {
			var immutable = ctx.arrayLiteral != null;
			var compiledExpressions = ctx.expressionList.expression.map[expr | 
				var c = visit(expr); 
				compiled.children += c;
				return c
			];
			
			val childType = compiledExpressions.map[type.boxed].reduce([c1, c2 | return c1 ])
			compiled.type = Type.arrayLiteralWithType(childType) /* TODO: FIND COMMON ANCESRTOR */
			var compiledList = compiledExpressions.map[
				if (childType.isBoxed) {
					childType.typeName+".valueOf("+generatedCode+")"
				} else {
					generatedCode
				}
			].reduce([c1, c2 |
				c1 +"," + c2
			])
			
			compiled.generatedCode = '''org.eclipse.xtext.xbase.lib.CollectionLiterals.<«childType.typeName»>newArrayList(«compiledList»)'''
			if (immutable) compiled.generatedCode = '''Collections.<«childType.typeName»>unmodifiableList(«compiled.generatedCode»)''';
			
		} else if (ctx.dot != null && ctx.member != null) {
			var left = visit(ctx.left)
			var Class<?> staticInner;

			if (left.type.isPackageRef) {
				// Look for either a package or class under me
				var qualifiedName = left.type.typeName+"."+ctx.member;		
				var cls = jvmContext.findClass(qualifiedName)
				if (cls != null) {
					compiled.type = Type.classRef(cls);
				} else {
					var pkg = jvmContext.findPackage(qualifiedName)
					if (pkg != null) {
						compiled.type = Type.packageRef(pkg);
					} else {
						// Name under package not found. Assume it's package for now
						compiled.type = new Type();
						compiled.type.isPackageRef = true;
						compiled.type.typeName = ctx.Identifier.text;
						
					}
				}
				compiled.generatedCode = left.generatedCode +"."+ctx.member.text;
				
			} else if (left.type.isClassRef) {
				// Look for either static member or inner class
				// Or "this"
				if (ctx.member.text == "this") {
					if (jvmContext.myClass == left.type.clazz) {
						compiled.type = Type.fromTypeReference(jvmContext.myTypeReference, jvmContext.myClass);
						compiled.preferredAccess = "this";
						compiled.prefix = left.generatedCode;
					} else {
						// TODO: This not accepted in this context
					}
					compiled.generatedCode = left.generatedCode +".this";
				} else if ((staticInner = jvmContext.findClass(left.type.typeName+"$"+ctx.member)) != null ) {
					compiled.type = Type.classRef(staticInner);
					compiled.generatedCode = left.generatedCode +"."+ctx.member
				} else  {
					findReferencedMember(compiled, left.type, ctx.member.text, true);
					// Since we don't know if this dot reference is for get or set access, we set a prefix
					// When we evaluate the whole expression we can only then generate the code
					compiled.prefix = left.generatedCode;
				}
				
			} else {
				// Referencing member from an instance
				// TODO: lookup non-static inner classes
				if (left.preferredAccess == "this") {
					left.generatedCode = (if (left.prefix!=null) left.prefix+ "." else"")+"this";
				} else if (left.preferredAccess == "getterMethod") {
					left.generatedCode = (if (left.prefix!=null) left.prefix+ "." else"")+left.getterMethod.name+"()";
				} else if (left.preferredAccess == "mutableGetterMethod") {
					left.generatedCode = (if (left.prefix!=null) left.prefix+ "." else"")+left.mutableGetterMethod.simpleName+"()";
				} else if (left.preferredAccess == "mutableField") {
					left.generatedCode = (if (left.prefix!=null) left.prefix+ "." else"")+left.mutableField.simpleName+"()";
				}  else {
					left.generatedCode =(if (left.prefix!=null) left.prefix+"." else"")+left.field.name
				}
				// Since we don't know if this dot reference is for get or set access, we set a prefix
				// When we evaluate the whole expression we can only then generate the code				
				compiled.prefix = left.generatedCode;
				findReferencedMember(compiled, left.type, ctx.member.text, false);
			}
			return compiled;
		} else if (ctx.method_call_expr != null) {
			var left = visit(ctx.method_call_expr)
			val List<CompiledExpression> paramsList = newArrayList();// ctx.invocation_parameters.expression.map[ visit ].toList
			ctx.invocation_parameters.expression.forEach[
				paramsList += it.visit
			]
			
			var targetMethod = left.allMethods.filter[
				if (parameterCount != paramsList.length) return false;
				for (var i =0;i<parameterCount;i++) {
					if (it.parameters.get(i).type.isPrimitive && paramsList.get(i).type.isPrimitive 
						&& it.parameters.get(i).type.name == paramsList.get(i).type.typeName) {
					} else if (paramsList.get(i).type.clazz != null && it.parameters.get(i).type.isAssignableFrom(paramsList.get(i).type.clazz))  {
					} else {
						return false;
					}
				}
				true
			].last //TODO: Better determine most specific Class (find first common ancestor)
			
			if (targetMethod != null) {
				compiled.type = Type.fromClass(targetMethod.returnType)

				compiled.generatedCode = (if (left.prefix != null) left.prefix+"." else "") +targetMethod.name+"(" + paramsList.map[generatedCode].join(",")+")";
			}
			return compiled;
		} 
		if (ctx.primaryExpression != null) {
			return this.visit(ctx.primaryExpression);
		}
		super.visitExpression(ctx); 
		return compiled
	}
	
	def findReferencedMember(CompiledExpression compiled, Type left, String memberName, boolean onlyStatic) {
		if (left.xtendClazz != null) {
			findReferencedMemberXtend(compiled,left,memberName,onlyStatic)
		} else {
			findReferencedMemberJVM(compiled,left,memberName,onlyStatic)
		}
	}
	
	def findReferencedMemberXtend(CompiledExpression compiled, Type left, String memberName, boolean onlyStatic) {
		val packageAccessible = true; // TODO: Check access
		val protectedAccessible = true; //left.type.clazz;
		val privateAccessible = true; //left.type.clazz;
		var Type myType = null;
		
		compiled.mutableField = left.xtendClazz.declaredFields.findFirst[
			it.simpleName == memberName
			&& ( modifiers.isEmpty ||  modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.PUBLIC)|| 
			   ( modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.PRIVATE) && protectedAccessible) ||
			   ( modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.PACKAGE) && privateAccessible)	||
			   packageAccessible				
			)
			&& (!onlyStatic || modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.STATIC))
		]
		
		compiled.mutableGetterMethod = left.xtendClazz.declaredMethods.findFirst[
			it.simpleName == "get"+memberName.substring(0,1).toUpperCase + memberName.substring(1)
			&& parameters.length == 0
			&& ( modifiers.isEmpty ||  modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.PUBLIC)|| 
			   ( modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.PRIVATE) && protectedAccessible) ||
			   ( modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.PACKAGE) && privateAccessible)	||
			   packageAccessible				
			)
			&& (!onlyStatic || modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.STATIC))
		];
		
		compiled.mutableSetterMethods = left.xtendClazz.declaredMethods.filter[ 
			it.simpleName == "set"+memberName.substring(0,1).toUpperCase + memberName.substring(1)
			&& parameters.length == 1
			&& ( modifiers.isEmpty || modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.PUBLIC)|| 
			   ( modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.PRIVATE) && protectedAccessible) ||
			   ( modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.PACKAGE) && privateAccessible)	||
			   packageAccessible				
			)
			&& (!onlyStatic || modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.STATIC))
		];

		compiled.mutableAllMethods  = left.xtendClazz.declaredMethods.filter[
			it.simpleName == memberName
			&& ( modifiers.isEmpty ||  modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.PUBLIC)|| 
			   ( modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.PRIVATE) && protectedAccessible) ||
			   ( modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.PACKAGE) && privateAccessible)	||
			   packageAccessible				
			)
			&& (!onlyStatic || modifiers.contains(org.eclipse.xtend.lib.macro.declaration.Modifier.STATIC))
		];

		if (compiled.mutableGetterMethod != null) {
			compiled.preferredAccess = "mutableGetterMethod"
			myType = Type.fromTypeReference(compiled.mutableGetterMethod.returnType, null)
		}	
		if (compiled.mutableField != null && (myType == null || left.xtendClazz == jvmContext.myClass)) {
			compiled.preferredAccess = "mutableField"
			myType = Type.fromFieldTypeReference(compiled.mutableField.type,compiled.mutableField)
		}
		compiled.type = myType;
	}
	
	
	def findReferencedMemberJVM(CompiledExpression compiled, Type left, String memberName, boolean onlyStatic) {
		val packageAccessible = true; // TODO: Check access
		val protectedAccessible = true; //left.type.clazz;
		val privateAccessible = true; //left.type.clazz;
		var Type myType = null;
		
		compiled.field = left.clazz.declaredFields.findFirst[
			it.name == memberName
			&& ( Modifier.isPublic(it.modifiers) || 
			   ( Modifier.isProtected(it.modifiers) && protectedAccessible) ||
			   ( Modifier.isPrivate(it.modifiers) && privateAccessible)	||
			   packageAccessible				
			)
			&& (!onlyStatic || Modifier.isStatic(it.modifiers))
		]
		
		compiled.getterMethod = left.clazz.declaredMethods.findFirst[
			it.name == "get"+memberName.substring(0,1).toUpperCase + memberName.substring(1)
			&& parameterCount == 0
			&& ( Modifier.isPublic(it.modifiers) || 
			   ( Modifier.isProtected(it.modifiers) && protectedAccessible) ||
			   ( Modifier.isPrivate(it.modifiers) && privateAccessible)	||
			   packageAccessible				
			)
			&& (!onlyStatic || Modifier.isStatic(it.modifiers))
		];
		
		compiled.setterMethods = left.clazz.declaredMethods.filter[
			it.name == "set"+memberName.substring(0,1).toUpperCase + memberName.substring(1)
			&& parameterCount == 1
			&& ( Modifier.isPublic(it.modifiers) || 
			   ( Modifier.isProtected(it.modifiers) && protectedAccessible) ||
			   ( Modifier.isPrivate(it.modifiers) && privateAccessible)	||
			   packageAccessible				
			)
			&& (!onlyStatic || Modifier.isStatic(it.modifiers))
		];

		compiled.allMethods = left.clazz.declaredMethods.filter[
			it.name == memberName
			&& ( Modifier.isPublic(it.modifiers) || 
			   ( Modifier.isProtected(it.modifiers) && protectedAccessible) ||
			   ( Modifier.isPrivate(it.modifiers) && privateAccessible)	||
			   packageAccessible				
			)
			&& (!onlyStatic || Modifier.isStatic(it.modifiers))
		];

		if (compiled.getterMethod != null) {
			compiled.preferredAccess = "getterMethod"
			myType = Type.fromClass(compiled.getterMethod.returnType)
		}	
		if (compiled.field != null && (myType == null || left.clazz == jvmContext.myClass)) {
			compiled.preferredAccess = "field"
			myType = Type.fromField(compiled.field)
		}
		compiled.type = myType;		
	}
	
	
	override visitPrimary(PrimaryContext ctx) {
		var compiled = new CompiledExpression();
		compiled.context = ctx;
		
		
		if (ctx.expression != null) {
			var compiledSub = visit(ctx.expression) 
			compiled.type = compiledSub.type;
			compiled.children += compiledSub;
			compiled.generatedCode = "("+compiledSub.generatedCode+")";
		} else if (ctx.text == "this") {
			
			compiled.generatedCode = "this"
			compiled.prefix = "this"
			compiled.preferredAccess = "this";
			try {
				var cls = jvmContext.findClass(ctx.Identifier.text)		
				compiled.type = Type.fromClass(cls);
			} catch(Exception e) {}
	
		} else if (ctx.text == "super") {
			// TODO: Lookup "this" class
//			compiled.type = Type.fromClass(jvmContext.getMyClass.superclass)
		} else if (ctx.literal != null) {
			compiled.generatedCode = ctx.literal.text;			
			if (ctx.literal.IntegerLiteral != null) {
				compiled.type = Type.INTEGER
				if (ctx.literal.text.toUpperCase.endsWith("L")) compiled.type = Type.LONG	
			} else if (ctx.literal.FloatingPointLiteral != null) {
				compiled.type = Type.DOUBLE
				if (ctx.literal.text.toUpperCase.endsWith("F")) compiled.type = Type.FLOAT 
			} else if (ctx.literal.CharacterLiteral != null) {
				compiled.type = Type.CHAR
			} else if (ctx.literal.StringLiteral != null) {
				compiled.type = Type.STRING
			} else if (ctx.literal.BooleanLiteral != null) {
				compiled.type = Type.BOOLEAN
			} else if (ctx.literal.text == "null") {
				compiled.type = Type.NULL;
			}
		} else if (ctx.Identifier != null) {			
			compiled.type = lookupLocalVariableType(ctx.Identifier.text)

			if (compiled.type == null) {
				findReferencedMember(compiled,Type.fromTypeReference(jvmContext.myTypeReference, jvmContext.myClass),ctx.Identifier.text,false)
				if (compiled.type == null) {
					
					var cls = jvmContext.findClass(ctx.Identifier.text)
					if (cls != null) {
						compiled.type = Type.classRef(cls);
					} else {
						if (jvmContext.myClass.simpleName == ctx.Identifier.text) {
							compiled.type = Type.classRef(jvmContext.myTypeReference, jvmContext.myClass);
						} else {
							var pkg = jvmContext.findPackage(ctx.Identifier.text)
							if (pkg != null) {
								compiled.type = Type.packageRef(pkg);
							} else {
								compiled.type = new Type();
								compiled.type.isPackageRef = true;
								compiled.type.typeName = ctx.Identifier.text;
							}
						}
					} 
					compiled.generatedCode = ctx.Identifier.text
				} else {
					// TODO: Check whether should use method or identifier directly
					var prefix = jvmContext.myClass.simpleName+".this.";
					if (compiled.preferredAccess == "getterMethod") {
						compiled.generatedCode = prefix +compiled.getterMethod.name+"()";
					} else if (compiled.preferredAccess == "mutableGetterMethod") {
						compiled.generatedCode = prefix +compiled.mutableGetterMethod.simpleName+"()";
					} else if (compiled.preferredAccess == "mutableField") {
						compiled.generatedCode = prefix +compiled.mutableField.simpleName;
					}  else {
						compiled.generatedCode = prefix +compiled.field.name
					}
				}
			} else {
				compiled.generatedCode = ctx.Identifier.text
			}
			
		}
		
		return compiled;
	}
	
	
	
}

