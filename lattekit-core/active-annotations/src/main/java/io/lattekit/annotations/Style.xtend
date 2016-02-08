package io.lattekit.annotations

import com.google.common.base.CaseFormat
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.Modifier
import org.eclipse.xtend.lib.macro.declaration.Visibility

@Active(typeof(StylePropertyProcessor))
annotation StyleProperty {
	String[] shorthands = #[];
	boolean animatable = true;
}

class StylePropertyProcessor extends AbstractFieldProcessor {
	
	def getShorthandValue(MutableFieldDeclaration annotatedField) {
		return annotatedField.annotations.findFirst[annotationTypeDeclaration.simpleName=="StyleProperty"].getValue("shorthands") as String[];
	}
	
	def getAnimatableValue(MutableFieldDeclaration annotatedField) {
		return annotatedField.annotations.findFirst[annotationTypeDeclaration.simpleName=="StyleProperty"].getValue("animatable") as Boolean;
	}
	def removeUnderscore(String prop) {
		if (prop.startsWith("_")) prop.substring(1) else prop
	}
	
	def toCamelCase(String hyphenString) {
		return CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL,hyphenString)		
	}
	override doTransform(MutableFieldDeclaration annotatedField, extension TransformationContext context) {
		super.doTransform(annotatedField, context)
		val fieldName = annotatedField.simpleName;
		val rawType = annotatedField.type;

		val capiatlized = fieldName.substring(0, 1).toUpperCase + fieldName.substring(1);
		val rawName = fieldName;//"_state" + capiatlized;
		annotatedField.simpleName = "_"+rawName;
		annotatedField.addAnnotation(SuppressWarnings.newAnnotationReference [
			setStringValue("value","all")
		]);
		
		if (annotatedField.declaringType.findDeclaredField("PROPERTIES") == null) {
			val properties = annotatedField.declaringType.declaredFields.filter[!annotations.filter[annotationTypeDeclaration.simpleName=="StyleProperty"].empty];
			val propertyNames = properties.map[it.simpleName]
			annotatedField.declaringType.addField("PROPERTIES") [
				type = List.newTypeReference(String.newTypeReference());
				visibility = Visibility.PUBLIC
				initializer = '''
				java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(«propertyNames.map['''"«if (it.startsWith("_")) it.substring(1) else it»"'''].join(",")»))
				'''			
			]
					
			annotatedField.declaringType.addField("UNANIMATED_PROPERTIES") [
				type = List.newTypeReference(String.newTypeReference());
				initializer = '''
				java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(«properties.filter[!animatableValue].map['''"«if (simpleName.startsWith("_")) simpleName.substring(1) else simpleName»"'''].join(",")»))
				'''			
			]
					

			val Map<String,List<String>>shorthands = newHashMap();
			properties.forEach[ prop |
				prop.shorthandValue.forEach[ shortProp |
					val it = shortProp.toCamelCase;
					var expandList = if (shorthands.containsKey(it)) {
						shorthands.get(it);
					} else {
						var list = newArrayList();
						shorthands.put(it,list);
						list;					
					}
					expandList += prop.simpleName;				
				]
			]
			annotatedField.declaringType.addMethod("expandShorthands") [
				addParameter("currentList", Set.newTypeReference(String.newTypeReference()))
				returnType = Set.newTypeReference(String.newTypeReference());
				body = '''
					final Set<String> expandedProperties = new java.util.HashSet<String>();
					for (String prop: currentList) {
						«FOR shortProperty: shorthands.keySet»
							if ("«shortProperty»".equals(prop)) {
								«FOR expand : shorthands.get(shortProperty)»expandedProperties.add("«expand.removeUnderscore»");
								«ENDFOR»;
							} else «ENDFOR» {
								expandedProperties.add(prop);
							}			
					}
					return expandedProperties;
				'''
			]
					
			annotatedField.declaringType.addMethod("overrideWithStyle") [
				addParameter("overridingStyle", annotatedField.declaringType.newTypeReference())
		
				body = '''
					«FOR property: properties»
						if (overridingStyle.«property.simpleName» != null) {
							«property.simpleName» = overridingStyle.«property.simpleName»;
						}
					«ENDFOR»
				'''
			]
			
			annotatedField.declaringType.addMethod("cloneFrom") [
				addParameter("copyStyle", annotatedField.declaringType.newTypeReference())
				body = '''
					«FOR property: properties»
						«property.simpleName» = copyStyle.«property.simpleName»;
					«ENDFOR»
				'''
			]
			
						
			
						
			annotatedField.declaringType.addMethod("setProperty") [
				addParameter("key", String.newTypeReference())
				addParameter("value", Object.newTypeReference())
				val allSetters = new StringBuffer();
				properties.forEach[
					val name = if (it.simpleName.startsWith("_")) it.simpleName.substring(1) else it.simpleName;
					if (it.type.name == "io.lattekit.ui.style.NumberValue") {
						allSetters.append('''if (propertyName.equals("«name»") && value instanceof io.lattekit.ui.style.NumberValue) { set«name.substring(0,1).toUpperCase+name.substring(1)»((io.lattekit.ui.style.NumberValue)value); return; }
						''');				
						allSetters.append('''if (propertyName.equals("«name»") && value instanceof String) { set«name.substring(0,1).toUpperCase+name.substring(1)»((String)value); return; }
						''');														
					} else {
						allSetters.append('''if (propertyName.equals("«name»")) { set«name.substring(0,1).toUpperCase+name.substring(1)»((«it.type.name»)value); return; }
					''');						
					}
				];
				body = '''
					String propertyName = key;
					if (!PROPERTIES.contains(key)) {
						propertyName = com.google.common.base.CaseFormat.LOWER_HYPHEN.to(com.google.common.base.CaseFormat.LOWER_CAMEL,key);
					}
					«allSetters.toString»
				'''
			]
			
			annotatedField.declaringType.addMethod("getProperty") [
				addParameter("propertyName", String.newTypeReference())
				returnType = Object.newTypeReference
				val allGetters = new StringBuffer();
				properties.forEach[
					val name = if (it.simpleName.startsWith("_")) it.simpleName.substring(1) else it.simpleName;
					allGetters.append('''if (propertyName.equals("«name»")) { return get«name.substring(0,1).toUpperCase+name.substring(1)»(); }
					''');
				];
				body = '''
					«allGetters.toString»
					return null;
				'''
			]			
		} 
		
		annotatedField.markAsRead
		
		
		val initilizer = annotatedField.initializer;
		annotatedField.declaringType.addMethod("get" + capiatlized) [
			returnType = rawType
			if (initilizer != null) {
				body = '''
					if (_«rawName» == null) {
						if (parentStyle == null) {
							return «initilizer»;
						} else {
							return parentStyle.get«capiatlized»();
						}
					}
					return _«rawName»;
				'''	
			} else {
				body = '''
					if (_«rawName» == null && parentStyle != null) {
						return parentStyle.get«capiatlized»();
					}				
					return _«rawName»;
				'''
			}
		];
		
		if (rawType.simpleName == "NumberValue") {
			
			annotatedField.declaringType.addMethod("set"+capiatlized) [
				addParameter("value", Integer.newTypeReference())
				body = '''
					_«rawName» = new NumberValue(value,0);
				'''
			]
			
			annotatedField.declaringType.addMethod("set"+capiatlized) [
				addParameter("value", String.newTypeReference())
				body = '''
					if (value.toLowerCase().equals("match_parent") || value.toLowerCase().equals("fill_parent")) {
						_«rawName» = new NumberValue(Style.MATCH_PARENT,0);
					} else if (value.toLowerCase().equals("wrap_content")) {
						_«rawName» = new NumberValue(Style.WRAP_CONTENT,0);
					} else {
						int unitType = android.util.TypedValue.COMPLEX_UNIT_PX;
						if (value.indexOf("dp")  != -1) {
							unitType = android.util.TypedValue.COMPLEX_UNIT_DIP;
						} else if (value.indexOf("sp") != -1) {
							unitType = android.util.TypedValue.COMPLEX_UNIT_SP;
						} else if (value.indexOf("pt")  != -1) {
							unitType = android.util.TypedValue.COMPLEX_UNIT_PT;
						}
						_«rawName» = new NumberValue(Integer.parseInt(value.replaceAll("[^0-9]", "")),unitType);
					}
				'''
			]
			
		}

		annotatedField.declaringType.addMethod("set" + capiatlized) [
			addParameter("newValue", rawType)
			body = '''
				_«rawName» = newValue;
			'''
		];
		annotatedField.initializer = '''null;''';
	}

}