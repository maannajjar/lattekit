package io.lattekit.parser

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import java.lang.reflect.Method
import java.util.Set
import io.lattekit.css.CssDefinition

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
    String classNameImpl;
    List<LayoutFunction> layoutFunctions = newArrayList();
    List<CssFunction> cssFunctions = newArrayList();

    String generatedSource;
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
class CssFunction {
    LatteClass latteClass;
    List<String> functionModifiers;
    String functionName;
    String functionParams;
    List<CssDefinition> definitions = newArrayList();
}

@Accessors
class LayoutNode { }

@Accessors
class XmlTag extends LayoutNode {
    String tagName;
    List<Prop> props = newArrayList();
    List<LayoutNode> children = newArrayList();
    boolean nativeView;
    Class<?> viewClass;
}

@Accessors
class NativeCode extends LayoutNode {
    String code = "";
}

@Accessors
class Prop {
    enum ValueType {
        LITERAL, INLINE_CODE, RESOURCE_REF
    }
    ValueType valueType;
    String propModifier;
    String namespace;
    String propName;
    String value;

    // When valueType is RESOURCE_RF
    String resourcePackage;
    String resourceType;
    String resourceName;

    boolean listenerProp;
    boolean hasStringSetter;
    List<PropSetter> propSetters = newArrayList();
}

@Accessors
class PropSetter {
    var Class paramType;
    var Method setterMethod;
    var Method getterMethod;
    var boolean primitiveType;
    var boolean hasGetter;
}