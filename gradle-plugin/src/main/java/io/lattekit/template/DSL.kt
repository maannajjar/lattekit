package io.lattekit.template

import kotlin.reflect.KClass

/**
 * Created by maan on 4/28/16.
 */

open class KotlinElement( var parent : KotlinElement?) {

    var children = mutableListOf<KotlinElement>()
    var outputString : String? = null;

    var currentContext : KotlinElement = this;
        get() = if (field != this) field.currentContext else field;

    fun checkContext(element : String) {
        if (currentContext.javaClass != this.javaClass) {
            throw Exception("Cannot do \"$element\" from ${currentContext.javaClass.simpleName}")
        }
    }

    open fun build(sourceBuilder : SourceBuilder) {
    }

    override fun toString(): String {
        if (outputString == null) {
            var sourceBuilder : SourceBuilder = SourceBuilder()
            build(sourceBuilder)
            outputString = sourceBuilder.toString();
        }
        return outputString!!
    }


    fun S(str : String) {
        var kotlinStmt = KotlinBlock(this,methodName=null,str=str,isBlock = false);
        this.children.add(kotlinStmt)
    }

    fun BLOCK(str : String,block: KotlinBlock.() -> Unit) {
        var kotlinStmt = KotlinBlock(this,methodName=null,str=str,isBlock = true);
        kotlinStmt.block()
        this.children.add(kotlinStmt)
    }

}

class KotlinTopLevel : KotlinElement(null) {

    var packageName : String? = null;
    var imports = mutableListOf<String>()

    fun IMPORT(i: String) {
        checkContext("import");
        imports.add(i);
    }

    fun PACKAGE(pkg: String) {
        checkContext("package");
        packageName = pkg;
    }

    fun CLASS(className: String, extends: List<String> = emptyList(), body: KotlinClass.() -> Unit) {
        var kotlinClass = KotlinClass(this,className,extends)
        this.currentContext = kotlinClass;
        this.children.add(kotlinClass);
        kotlinClass.body()
        this.currentContext = this;
    }

    override fun build(sourceBuilder: SourceBuilder) {
        sourceBuilder.append("package $packageName;\n")
        imports.forEach {
            sourceBuilder.append("import $packageName;\n")
        }
        children.forEach { it.build(sourceBuilder) }
    }
}

class KotlinClass(var topLevel : KotlinTopLevel,var className : String, var extendList: List<String>) : KotlinElement(topLevel) {

    fun METHOD(methodName: String, body: KotlinBlock.() -> Unit) {
        checkContext("method")
        var method = KotlinBlock(this,methodName);
        this.currentContext = method;
        this.children.add(method);
        method.body()
        this.currentContext = this;
    }



    override fun build(sourceBuilder: SourceBuilder) {
        if (!extendList.isEmpty()) {
            sourceBuilder.append("class $className : ${extendList.joinToString(",")} {")
            sourceBuilder.indent()
        } else {
            sourceBuilder.append("class $className {")
            sourceBuilder.indent()
        }
        children.forEach {
            it.build(sourceBuilder);
        }
        sourceBuilder.unindent()
        sourceBuilder.append("}")

    }

}


open class KotlinBlock(kotlinClass : KotlinElement, var methodName : String? = null, var str: String? = null,var isBlock : Boolean = true) : KotlinElement(kotlinClass) {
    var paramList : MutableList<Pair<String,String>> = mutableListOf();
    var modifiers : MutableList<String> = mutableListOf();
    private var returnType : String? = null;

    fun param(param : String,paramType : String) {
        this.paramList.add(param to paramType);
    }

    fun modifiers(vararg m : String) {
        modifiers.addAll(m)
    }
    fun returnType(returnType : String) {
        this.returnType = returnType;
    }

    fun IF(condition: String, body: KotlinBlock.() -> Unit) : KotlinIf{
        checkContext("if")
        var ifEl = KotlinIf(this,condition);
        this.currentContext = ifEl;
        ifEl.body()
        this.children.add(ifEl);
        this.currentContext = this;
        return ifEl;
    }


    fun FOR(condition: String, body: KotlinBlock.() -> Unit) {
        checkContext("for")
        BLOCK("for ($condition)",body)
    }

    override fun build(sourceBuilder: SourceBuilder) {
        if (isBlock) {
            if (methodName != null) {
                if (!modifiers.isEmpty()) {
                    sourceBuilder.append("${modifiers.joinToString(" ")} fun $methodName", newLine = false)
                } else {
                    sourceBuilder.append("fun $methodName", newLine = false)
                }

                sourceBuilder.append("(${paramList.map { it.component1() + " : " + it.component2() }.joinToString(", ")})", addIndent = false, newLine = false)
                if (returnType != null) {
                    sourceBuilder.append(" : $returnType {", addIndent = false, newLine = true)
                } else {
                    sourceBuilder.append(" {", addIndent = false, newLine = true)
                }
            } else {
                sourceBuilder.append(str!! +" {");
            }
            sourceBuilder.indent()
            children.forEach {
                it.build(sourceBuilder);
            }
            sourceBuilder.unindent()
            sourceBuilder.append("}")
        } else if (str != null) {
            sourceBuilder.append(str!!);
        }
    }

}


fun KotlinSource(init: KotlinTopLevel.() -> Unit) : KotlinElement {
    var str = KotlinTopLevel();
    str.init();
    return str;
}


class KotlinIf(parent : KotlinElement,var condition : String) : KotlinBlock(parent,methodName = null,str=null) {
    var elseBranches = mutableListOf<Pair<String,KotlinIf>>();
    var isElseBranch = false;
    var rootIf : KotlinIf? = null;
    infix fun ELSE(elseIf : KotlinIf) : KotlinIf {
        // Remove this branch from the actual parent since we will attach it here;
        elseIf.parent?.children?.remove(elseIf);
        elseIf.rootIf = this.rootIf ?: this;
        elseIf.isElseBranch = true;
        elseIf.rootIf?.elseBranches?.add(elseIf.condition to elseIf)
        return this
    }

    infix fun ELSE( body: KotlinIf.() -> Unit) : KotlinIf {
        var elseEl = KotlinIf(this,"");
        elseEl.body()
        elseEl.isElseBranch = true;
        elseEl.rootIf = this.rootIf ?: this;
        elseEl.rootIf?.elseBranches?.add("" to elseEl)
        return this
    }

    override fun build(sourceBuilder: SourceBuilder) {
        if (isElseBranch) {
            if (condition == "") {
                sourceBuilder.append(" else {", addIndent = false)
            } else {
                sourceBuilder.append(" else if ($condition) {",addIndent = false)
            }
        } else {
            sourceBuilder.append("if ($condition) {")
        }

        sourceBuilder.indent()
        children.forEach {
            it.build(sourceBuilder);
        }
        sourceBuilder.unindent()
        sourceBuilder.append("}",newLine = false)
        elseBranches.forEach {
            var (cond,ifEl) = it
            ifEl.build(sourceBuilder);
        }
        if (this.rootIf == null) {
            sourceBuilder.append("",addIndent = false)
        }
    }

}

