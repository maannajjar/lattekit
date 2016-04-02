package io.lattekit.parser

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import java.lang.reflect.Method
import java.util.Set

/**
 * Created by maan on 4/2/16.
 */
interface AstVisitor {
    def LatteFile parseSource(String source);
}

@Accessors
class LatteFile {
    String androidPackageName;
    String packageName;
    Set<String> imports = newHashSet();
    List<LatteClass> classes = newArrayList();
    List<String> resourceIds = newArrayList();
}

@Accessors
class LatteClass {
    LatteFile latteFile;
    String className;
    List<LayoutFunction> layoutFunctions = newArrayList();
}

@Accessors
class LayoutFunction {
    LatteClass latteClass;
    List<String> functionModifiers;
    String functionName;
    String functionParams;
    List<LayoutNode> children = newArrayList();
}

@Accessors
class LayoutNode { }

@Accessors
class XmlTag extends LayoutNode {
    String tagName;
    List<Prop> props = newArrayList();
    List<LayoutNode> children = newArrayList();
    Class<?> nativeClass;
}

@Accessors
class NativeCode extends LayoutNode {
    String code = "";
}

@Accessors
class Prop {
    enum ValueType {
        LITERAL, INLINE_CODE
    }
    ValueType valueType;
    String propName;
    String value;

    List<Method> setterMethods;
    List<Method> getterMethods;
}