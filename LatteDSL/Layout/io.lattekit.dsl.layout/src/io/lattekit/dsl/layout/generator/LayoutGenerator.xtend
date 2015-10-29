package io.lattekit.dsl.layout.generator

import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator

class LayoutGenerator extends JvmModelGenerator {
	
	override CharSequence generateType(JvmDeclaredType type, GeneratorConfig config) {
		val importManager = new ImportManager(true, type)
		val bodyAppendable = createAppendable(type, importManager, config)
		bodyAppendable.openScope
		bodyAppendable.assignThisAndSuper(type, config)
		generateBody(type, bodyAppendable, config)
		bodyAppendable.closeScope
		val importAppendable = createAppendable(type, importManager, config)
        generateFileHeader(type, importAppendable, config)
//		if (type.packageName != null) {
//			importAppendable.append("package ").append(type.packageName).append(";");
//			importAppendable.newLine.newLine
//		}
		for(i: importManager.imports) {
			importAppendable.append("import ").append(i).append(";").newLine
		}
		if (!importManager.imports.empty)
			importAppendable.newLine
		importAppendable.append(bodyAppendable)
		return importAppendable
	}	
}