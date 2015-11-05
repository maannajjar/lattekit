/**
 */
package io.lattekit.dsl.latteCSS.impl;

import io.lattekit.dsl.latteCSS.AlignmentProperty;
import io.lattekit.dsl.latteCSS.BackgroundFilterProperty;
import io.lattekit.dsl.latteCSS.BackgroundFilterTypeProperty;
import io.lattekit.dsl.latteCSS.BackgroundGravityProperty;
import io.lattekit.dsl.latteCSS.BackgroundRepeatProperty;
import io.lattekit.dsl.latteCSS.BorderProperty;
import io.lattekit.dsl.latteCSS.BorderRadiusProperty;
import io.lattekit.dsl.latteCSS.CSSProperty;
import io.lattekit.dsl.latteCSS.ClassSelector;
import io.lattekit.dsl.latteCSS.ColorFunction;
import io.lattekit.dsl.latteCSS.ColorProperty;
import io.lattekit.dsl.latteCSS.ColorValue;
import io.lattekit.dsl.latteCSS.Definition;
import io.lattekit.dsl.latteCSS.DrawableProperty;
import io.lattekit.dsl.latteCSS.FontFamilyProperty;
import io.lattekit.dsl.latteCSS.FontStyleProperty;
import io.lattekit.dsl.latteCSS.HSBColor;
import io.lattekit.dsl.latteCSS.IdSelector;
import io.lattekit.dsl.latteCSS.LatteCSSFactory;
import io.lattekit.dsl.latteCSS.LatteCSSPackage;
import io.lattekit.dsl.latteCSS.LinearGradient;
import io.lattekit.dsl.latteCSS.PaintProperty;
import io.lattekit.dsl.latteCSS.PaintValue;
import io.lattekit.dsl.latteCSS.PseudoClassSelector;
import io.lattekit.dsl.latteCSS.RGBColor;
import io.lattekit.dsl.latteCSS.RadialGradient;
import io.lattekit.dsl.latteCSS.Selector;
import io.lattekit.dsl.latteCSS.ShorthandColorProperty;
import io.lattekit.dsl.latteCSS.ShorthandSizeProperty;
import io.lattekit.dsl.latteCSS.SimpleSelector;
import io.lattekit.dsl.latteCSS.SizeProperty;
import io.lattekit.dsl.latteCSS.SizeValue;
import io.lattekit.dsl.latteCSS.StopValue;
import io.lattekit.dsl.latteCSS.TimeValue;
import io.lattekit.dsl.latteCSS.TransitionProperty;
import io.lattekit.dsl.latteCSS.TransitionValue;
import io.lattekit.dsl.latteCSS.ViewSizeProperty;
import io.lattekit.dsl.latteCSS.ViewSizeValue;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LatteCSSPackageImpl extends EPackageImpl implements LatteCSSPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cssEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass definitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass selectorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleSelectorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass idSelectorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classSelectorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pseudoClassSelectorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cssPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fontFamilyPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fontStylePropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass viewSizePropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shorthandSizePropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass borderRadiusPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sizePropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paintPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass drawablePropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass backgroundRepeatPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass borderPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass backgroundFilterPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass backgroundGravityPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass backgroundFilterTypePropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shorthandColorPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass colorPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass alignmentPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass viewSizeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sizeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paintValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass linearGradientEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass radialGradientEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stopValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass colorValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rgbColorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass hsbColorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass colorFunctionEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private LatteCSSPackageImpl()
  {
    super(eNS_URI, LatteCSSFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link LatteCSSPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static LatteCSSPackage init()
  {
    if (isInited) return (LatteCSSPackage)EPackage.Registry.INSTANCE.getEPackage(LatteCSSPackage.eNS_URI);

    // Obtain or create and register package
    LatteCSSPackageImpl theLatteCSSPackage = (LatteCSSPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LatteCSSPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LatteCSSPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theLatteCSSPackage.createPackageContents();

    // Initialize created meta-data
    theLatteCSSPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theLatteCSSPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(LatteCSSPackage.eNS_URI, theLatteCSSPackage);
    return theLatteCSSPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCSS()
  {
    return cssEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCSS_Definitions()
  {
    return (EReference)cssEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefinition()
  {
    return definitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefinition_Selector()
  {
    return (EReference)definitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefinition_Properties()
  {
    return (EReference)definitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSelector()
  {
    return selectorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSelector_SimpleSelector()
  {
    return (EReference)selectorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleSelector()
  {
    return simpleSelectorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleSelector_Element()
  {
    return (EAttribute)simpleSelectorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSimpleSelector_Id()
  {
    return (EReference)simpleSelectorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSimpleSelector_PseudoClass()
  {
    return (EReference)simpleSelectorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSimpleSelector_Class()
  {
    return (EReference)simpleSelectorEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdSelector()
  {
    return idSelectorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdSelector_Id()
  {
    return (EAttribute)idSelectorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassSelector()
  {
    return classSelectorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassSelector_Class()
  {
    return (EAttribute)classSelectorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPseudoClassSelector()
  {
    return pseudoClassSelectorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPseudoClassSelector_Value()
  {
    return (EAttribute)pseudoClassSelectorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCSSProperty()
  {
    return cssPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCSSProperty_Property()
  {
    return (EAttribute)cssPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFontFamilyProperty()
  {
    return fontFamilyPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFontFamilyProperty_Value()
  {
    return (EAttribute)fontFamilyPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFontStyleProperty()
  {
    return fontStylePropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFontStyleProperty_Value()
  {
    return (EAttribute)fontStylePropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getViewSizeProperty()
  {
    return viewSizePropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getViewSizeProperty_Value()
  {
    return (EReference)viewSizePropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShorthandSizeProperty()
  {
    return shorthandSizePropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShorthandSizeProperty_Values()
  {
    return (EReference)shorthandSizePropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBorderRadiusProperty()
  {
    return borderRadiusPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBorderRadiusProperty_Values()
  {
    return (EReference)borderRadiusPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSizeProperty()
  {
    return sizePropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSizeProperty_Value()
  {
    return (EReference)sizePropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPaintProperty()
  {
    return paintPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPaintProperty_Value()
  {
    return (EReference)paintPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionProperty()
  {
    return transitionPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionProperty_Transitions()
  {
    return (EReference)transitionPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionValue()
  {
    return transitionValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransitionValue_PropertyName()
  {
    return (EAttribute)transitionValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionValue_Duration()
  {
    return (EReference)transitionValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransitionValue_TimingFunction()
  {
    return (EAttribute)transitionValueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionValue_Delay()
  {
    return (EReference)transitionValueEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDrawableProperty()
  {
    return drawablePropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDrawableProperty_Value()
  {
    return (EAttribute)drawablePropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBackgroundRepeatProperty()
  {
    return backgroundRepeatPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBackgroundRepeatProperty_Values()
  {
    return (EAttribute)backgroundRepeatPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBorderProperty()
  {
    return borderPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBorderProperty_Width()
  {
    return (EReference)borderPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBorderProperty_Style()
  {
    return (EAttribute)borderPropertyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBorderProperty_Color()
  {
    return (EReference)borderPropertyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBackgroundFilterProperty()
  {
    return backgroundFilterPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBackgroundFilterProperty_Color()
  {
    return (EReference)backgroundFilterPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBackgroundFilterProperty_Filter()
  {
    return (EAttribute)backgroundFilterPropertyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBackgroundGravityProperty()
  {
    return backgroundGravityPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBackgroundGravityProperty_Values()
  {
    return (EAttribute)backgroundGravityPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBackgroundFilterTypeProperty()
  {
    return backgroundFilterTypePropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBackgroundFilterTypeProperty_Value()
  {
    return (EAttribute)backgroundFilterTypePropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShorthandColorProperty()
  {
    return shorthandColorPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShorthandColorProperty_Values()
  {
    return (EReference)shorthandColorPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getColorProperty()
  {
    return colorPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getColorProperty_Value()
  {
    return (EReference)colorPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlignmentProperty()
  {
    return alignmentPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAlignmentProperty_Value()
  {
    return (EAttribute)alignmentPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimeValue()
  {
    return timeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeValue_Time()
  {
    return (EAttribute)timeValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeValue_Unit()
  {
    return (EAttribute)timeValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getViewSizeValue()
  {
    return viewSizeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getViewSizeValue_Value()
  {
    return (EReference)viewSizeValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getViewSizeValue_Dynamic()
  {
    return (EAttribute)viewSizeValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSizeValue()
  {
    return sizeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSizeValue_Value()
  {
    return (EAttribute)sizeValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSizeValue_Dimension()
  {
    return (EAttribute)sizeValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPaintValue()
  {
    return paintValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLinearGradient()
  {
    return linearGradientEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinearGradient_X1()
  {
    return (EReference)linearGradientEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinearGradient_Y1()
  {
    return (EReference)linearGradientEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinearGradient_X2()
  {
    return (EReference)linearGradientEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinearGradient_Y2()
  {
    return (EReference)linearGradientEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinearGradient_Stops()
  {
    return (EReference)linearGradientEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRadialGradient()
  {
    return radialGradientEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRadialGradient_Cx()
  {
    return (EReference)radialGradientEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRadialGradient_Cy()
  {
    return (EReference)radialGradientEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRadialGradient_Radius()
  {
    return (EReference)radialGradientEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRadialGradient_Fx()
  {
    return (EReference)radialGradientEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRadialGradient_Fy()
  {
    return (EReference)radialGradientEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRadialGradient_Stops()
  {
    return (EReference)radialGradientEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStopValue()
  {
    return stopValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStopValue_Pos()
  {
    return (EReference)stopValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStopValue_Color()
  {
    return (EReference)stopValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getColorValue()
  {
    return colorValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getColorValue_NamedColor()
  {
    return (EAttribute)colorValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getColorValue_Rgb()
  {
    return (EReference)colorValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRGBColor()
  {
    return rgbColorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRGBColor_Hex()
  {
    return (EAttribute)rgbColorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRGBColor_R()
  {
    return (EAttribute)rgbColorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRGBColor_G()
  {
    return (EAttribute)rgbColorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRGBColor_B()
  {
    return (EAttribute)rgbColorEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRGBColor_Alpha()
  {
    return (EAttribute)rgbColorEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHSBColor()
  {
    return hsbColorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHSBColor_Hue()
  {
    return (EAttribute)hsbColorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHSBColor_Saturation()
  {
    return (EAttribute)hsbColorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHSBColor_Brightness()
  {
    return (EAttribute)hsbColorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHSBColor_Alpha()
  {
    return (EAttribute)hsbColorEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getColorFunction()
  {
    return colorFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getColorFunction_Orig()
  {
    return (EReference)colorFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getColorFunction_Mod()
  {
    return (EAttribute)colorFunctionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getColorFunction_StopNumbers()
  {
    return (EAttribute)colorFunctionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getColorFunction_StopColors()
  {
    return (EReference)colorFunctionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LatteCSSFactory getLatteCSSFactory()
  {
    return (LatteCSSFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    cssEClass = createEClass(CSS);
    createEReference(cssEClass, CSS__DEFINITIONS);

    definitionEClass = createEClass(DEFINITION);
    createEReference(definitionEClass, DEFINITION__SELECTOR);
    createEReference(definitionEClass, DEFINITION__PROPERTIES);

    selectorEClass = createEClass(SELECTOR);
    createEReference(selectorEClass, SELECTOR__SIMPLE_SELECTOR);

    simpleSelectorEClass = createEClass(SIMPLE_SELECTOR);
    createEAttribute(simpleSelectorEClass, SIMPLE_SELECTOR__ELEMENT);
    createEReference(simpleSelectorEClass, SIMPLE_SELECTOR__ID);
    createEReference(simpleSelectorEClass, SIMPLE_SELECTOR__PSEUDO_CLASS);
    createEReference(simpleSelectorEClass, SIMPLE_SELECTOR__CLASS);

    idSelectorEClass = createEClass(ID_SELECTOR);
    createEAttribute(idSelectorEClass, ID_SELECTOR__ID);

    classSelectorEClass = createEClass(CLASS_SELECTOR);
    createEAttribute(classSelectorEClass, CLASS_SELECTOR__CLASS);

    pseudoClassSelectorEClass = createEClass(PSEUDO_CLASS_SELECTOR);
    createEAttribute(pseudoClassSelectorEClass, PSEUDO_CLASS_SELECTOR__VALUE);

    cssPropertyEClass = createEClass(CSS_PROPERTY);
    createEAttribute(cssPropertyEClass, CSS_PROPERTY__PROPERTY);

    fontFamilyPropertyEClass = createEClass(FONT_FAMILY_PROPERTY);
    createEAttribute(fontFamilyPropertyEClass, FONT_FAMILY_PROPERTY__VALUE);

    fontStylePropertyEClass = createEClass(FONT_STYLE_PROPERTY);
    createEAttribute(fontStylePropertyEClass, FONT_STYLE_PROPERTY__VALUE);

    viewSizePropertyEClass = createEClass(VIEW_SIZE_PROPERTY);
    createEReference(viewSizePropertyEClass, VIEW_SIZE_PROPERTY__VALUE);

    shorthandSizePropertyEClass = createEClass(SHORTHAND_SIZE_PROPERTY);
    createEReference(shorthandSizePropertyEClass, SHORTHAND_SIZE_PROPERTY__VALUES);

    borderRadiusPropertyEClass = createEClass(BORDER_RADIUS_PROPERTY);
    createEReference(borderRadiusPropertyEClass, BORDER_RADIUS_PROPERTY__VALUES);

    sizePropertyEClass = createEClass(SIZE_PROPERTY);
    createEReference(sizePropertyEClass, SIZE_PROPERTY__VALUE);

    paintPropertyEClass = createEClass(PAINT_PROPERTY);
    createEReference(paintPropertyEClass, PAINT_PROPERTY__VALUE);

    transitionPropertyEClass = createEClass(TRANSITION_PROPERTY);
    createEReference(transitionPropertyEClass, TRANSITION_PROPERTY__TRANSITIONS);

    transitionValueEClass = createEClass(TRANSITION_VALUE);
    createEAttribute(transitionValueEClass, TRANSITION_VALUE__PROPERTY_NAME);
    createEReference(transitionValueEClass, TRANSITION_VALUE__DURATION);
    createEAttribute(transitionValueEClass, TRANSITION_VALUE__TIMING_FUNCTION);
    createEReference(transitionValueEClass, TRANSITION_VALUE__DELAY);

    drawablePropertyEClass = createEClass(DRAWABLE_PROPERTY);
    createEAttribute(drawablePropertyEClass, DRAWABLE_PROPERTY__VALUE);

    backgroundRepeatPropertyEClass = createEClass(BACKGROUND_REPEAT_PROPERTY);
    createEAttribute(backgroundRepeatPropertyEClass, BACKGROUND_REPEAT_PROPERTY__VALUES);

    borderPropertyEClass = createEClass(BORDER_PROPERTY);
    createEReference(borderPropertyEClass, BORDER_PROPERTY__WIDTH);
    createEAttribute(borderPropertyEClass, BORDER_PROPERTY__STYLE);
    createEReference(borderPropertyEClass, BORDER_PROPERTY__COLOR);

    backgroundFilterPropertyEClass = createEClass(BACKGROUND_FILTER_PROPERTY);
    createEReference(backgroundFilterPropertyEClass, BACKGROUND_FILTER_PROPERTY__COLOR);
    createEAttribute(backgroundFilterPropertyEClass, BACKGROUND_FILTER_PROPERTY__FILTER);

    backgroundGravityPropertyEClass = createEClass(BACKGROUND_GRAVITY_PROPERTY);
    createEAttribute(backgroundGravityPropertyEClass, BACKGROUND_GRAVITY_PROPERTY__VALUES);

    backgroundFilterTypePropertyEClass = createEClass(BACKGROUND_FILTER_TYPE_PROPERTY);
    createEAttribute(backgroundFilterTypePropertyEClass, BACKGROUND_FILTER_TYPE_PROPERTY__VALUE);

    shorthandColorPropertyEClass = createEClass(SHORTHAND_COLOR_PROPERTY);
    createEReference(shorthandColorPropertyEClass, SHORTHAND_COLOR_PROPERTY__VALUES);

    colorPropertyEClass = createEClass(COLOR_PROPERTY);
    createEReference(colorPropertyEClass, COLOR_PROPERTY__VALUE);

    alignmentPropertyEClass = createEClass(ALIGNMENT_PROPERTY);
    createEAttribute(alignmentPropertyEClass, ALIGNMENT_PROPERTY__VALUE);

    timeValueEClass = createEClass(TIME_VALUE);
    createEAttribute(timeValueEClass, TIME_VALUE__TIME);
    createEAttribute(timeValueEClass, TIME_VALUE__UNIT);

    viewSizeValueEClass = createEClass(VIEW_SIZE_VALUE);
    createEReference(viewSizeValueEClass, VIEW_SIZE_VALUE__VALUE);
    createEAttribute(viewSizeValueEClass, VIEW_SIZE_VALUE__DYNAMIC);

    sizeValueEClass = createEClass(SIZE_VALUE);
    createEAttribute(sizeValueEClass, SIZE_VALUE__VALUE);
    createEAttribute(sizeValueEClass, SIZE_VALUE__DIMENSION);

    paintValueEClass = createEClass(PAINT_VALUE);

    linearGradientEClass = createEClass(LINEAR_GRADIENT);
    createEReference(linearGradientEClass, LINEAR_GRADIENT__X1);
    createEReference(linearGradientEClass, LINEAR_GRADIENT__Y1);
    createEReference(linearGradientEClass, LINEAR_GRADIENT__X2);
    createEReference(linearGradientEClass, LINEAR_GRADIENT__Y2);
    createEReference(linearGradientEClass, LINEAR_GRADIENT__STOPS);

    radialGradientEClass = createEClass(RADIAL_GRADIENT);
    createEReference(radialGradientEClass, RADIAL_GRADIENT__CX);
    createEReference(radialGradientEClass, RADIAL_GRADIENT__CY);
    createEReference(radialGradientEClass, RADIAL_GRADIENT__RADIUS);
    createEReference(radialGradientEClass, RADIAL_GRADIENT__FX);
    createEReference(radialGradientEClass, RADIAL_GRADIENT__FY);
    createEReference(radialGradientEClass, RADIAL_GRADIENT__STOPS);

    stopValueEClass = createEClass(STOP_VALUE);
    createEReference(stopValueEClass, STOP_VALUE__POS);
    createEReference(stopValueEClass, STOP_VALUE__COLOR);

    colorValueEClass = createEClass(COLOR_VALUE);
    createEAttribute(colorValueEClass, COLOR_VALUE__NAMED_COLOR);
    createEReference(colorValueEClass, COLOR_VALUE__RGB);

    rgbColorEClass = createEClass(RGB_COLOR);
    createEAttribute(rgbColorEClass, RGB_COLOR__HEX);
    createEAttribute(rgbColorEClass, RGB_COLOR__R);
    createEAttribute(rgbColorEClass, RGB_COLOR__G);
    createEAttribute(rgbColorEClass, RGB_COLOR__B);
    createEAttribute(rgbColorEClass, RGB_COLOR__ALPHA);

    hsbColorEClass = createEClass(HSB_COLOR);
    createEAttribute(hsbColorEClass, HSB_COLOR__HUE);
    createEAttribute(hsbColorEClass, HSB_COLOR__SATURATION);
    createEAttribute(hsbColorEClass, HSB_COLOR__BRIGHTNESS);
    createEAttribute(hsbColorEClass, HSB_COLOR__ALPHA);

    colorFunctionEClass = createEClass(COLOR_FUNCTION);
    createEReference(colorFunctionEClass, COLOR_FUNCTION__ORIG);
    createEAttribute(colorFunctionEClass, COLOR_FUNCTION__MOD);
    createEAttribute(colorFunctionEClass, COLOR_FUNCTION__STOP_NUMBERS);
    createEReference(colorFunctionEClass, COLOR_FUNCTION__STOP_COLORS);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    fontFamilyPropertyEClass.getESuperTypes().add(this.getCSSProperty());
    fontStylePropertyEClass.getESuperTypes().add(this.getCSSProperty());
    viewSizePropertyEClass.getESuperTypes().add(this.getCSSProperty());
    shorthandSizePropertyEClass.getESuperTypes().add(this.getCSSProperty());
    borderRadiusPropertyEClass.getESuperTypes().add(this.getCSSProperty());
    sizePropertyEClass.getESuperTypes().add(this.getCSSProperty());
    paintPropertyEClass.getESuperTypes().add(this.getCSSProperty());
    transitionPropertyEClass.getESuperTypes().add(this.getCSSProperty());
    drawablePropertyEClass.getESuperTypes().add(this.getCSSProperty());
    backgroundRepeatPropertyEClass.getESuperTypes().add(this.getCSSProperty());
    borderPropertyEClass.getESuperTypes().add(this.getCSSProperty());
    backgroundFilterPropertyEClass.getESuperTypes().add(this.getCSSProperty());
    backgroundGravityPropertyEClass.getESuperTypes().add(this.getCSSProperty());
    backgroundFilterTypePropertyEClass.getESuperTypes().add(this.getCSSProperty());
    shorthandColorPropertyEClass.getESuperTypes().add(this.getCSSProperty());
    colorPropertyEClass.getESuperTypes().add(this.getCSSProperty());
    alignmentPropertyEClass.getESuperTypes().add(this.getCSSProperty());
    linearGradientEClass.getESuperTypes().add(this.getPaintValue());
    radialGradientEClass.getESuperTypes().add(this.getPaintValue());
    colorValueEClass.getESuperTypes().add(this.getPaintValue());

    // Initialize classes and features; add operations and parameters
    initEClass(cssEClass, io.lattekit.dsl.latteCSS.CSS.class, "CSS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCSS_Definitions(), this.getDefinition(), null, "definitions", null, 0, -1, io.lattekit.dsl.latteCSS.CSS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(definitionEClass, Definition.class, "Definition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDefinition_Selector(), this.getSelector(), null, "selector", null, 0, -1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDefinition_Properties(), this.getCSSProperty(), null, "properties", null, 0, -1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(selectorEClass, Selector.class, "Selector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSelector_SimpleSelector(), this.getSimpleSelector(), null, "simpleSelector", null, 0, -1, Selector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleSelectorEClass, SimpleSelector.class, "SimpleSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleSelector_Element(), ecorePackage.getEString(), "element", null, 0, 1, SimpleSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSimpleSelector_Id(), this.getIdSelector(), null, "id", null, 0, 1, SimpleSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSimpleSelector_PseudoClass(), this.getPseudoClassSelector(), null, "pseudoClass", null, 0, 1, SimpleSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSimpleSelector_Class(), this.getClassSelector(), null, "class", null, 0, 1, SimpleSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(idSelectorEClass, IdSelector.class, "IdSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIdSelector_Id(), ecorePackage.getEString(), "id", null, 0, 1, IdSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classSelectorEClass, ClassSelector.class, "ClassSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getClassSelector_Class(), ecorePackage.getEString(), "class", null, 0, 1, ClassSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pseudoClassSelectorEClass, PseudoClassSelector.class, "PseudoClassSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPseudoClassSelector_Value(), ecorePackage.getEString(), "value", null, 0, 1, PseudoClassSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(cssPropertyEClass, CSSProperty.class, "CSSProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCSSProperty_Property(), ecorePackage.getEString(), "property", null, 0, 1, CSSProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fontFamilyPropertyEClass, FontFamilyProperty.class, "FontFamilyProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFontFamilyProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, FontFamilyProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fontStylePropertyEClass, FontStyleProperty.class, "FontStyleProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFontStyleProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, FontStyleProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(viewSizePropertyEClass, ViewSizeProperty.class, "ViewSizeProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getViewSizeProperty_Value(), this.getViewSizeValue(), null, "value", null, 0, 1, ViewSizeProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(shorthandSizePropertyEClass, ShorthandSizeProperty.class, "ShorthandSizeProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getShorthandSizeProperty_Values(), this.getSizeValue(), null, "values", null, 0, -1, ShorthandSizeProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(borderRadiusPropertyEClass, BorderRadiusProperty.class, "BorderRadiusProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBorderRadiusProperty_Values(), this.getSizeValue(), null, "values", null, 0, -1, BorderRadiusProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sizePropertyEClass, SizeProperty.class, "SizeProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSizeProperty_Value(), this.getSizeValue(), null, "value", null, 0, 1, SizeProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(paintPropertyEClass, PaintProperty.class, "PaintProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPaintProperty_Value(), this.getPaintValue(), null, "value", null, 0, 1, PaintProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionPropertyEClass, TransitionProperty.class, "TransitionProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransitionProperty_Transitions(), this.getTransitionValue(), null, "transitions", null, 0, -1, TransitionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionValueEClass, TransitionValue.class, "TransitionValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransitionValue_PropertyName(), ecorePackage.getEString(), "propertyName", null, 0, 1, TransitionValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionValue_Duration(), this.getTimeValue(), null, "duration", null, 0, 1, TransitionValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransitionValue_TimingFunction(), ecorePackage.getEString(), "timingFunction", null, 0, 1, TransitionValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionValue_Delay(), this.getTimeValue(), null, "delay", null, 0, 1, TransitionValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(drawablePropertyEClass, DrawableProperty.class, "DrawableProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDrawableProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, DrawableProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(backgroundRepeatPropertyEClass, BackgroundRepeatProperty.class, "BackgroundRepeatProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBackgroundRepeatProperty_Values(), ecorePackage.getEString(), "values", null, 0, -1, BackgroundRepeatProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(borderPropertyEClass, BorderProperty.class, "BorderProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBorderProperty_Width(), this.getSizeValue(), null, "width", null, 0, 1, BorderProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBorderProperty_Style(), ecorePackage.getEString(), "style", null, 0, 1, BorderProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBorderProperty_Color(), this.getColorValue(), null, "color", null, 0, 1, BorderProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(backgroundFilterPropertyEClass, BackgroundFilterProperty.class, "BackgroundFilterProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBackgroundFilterProperty_Color(), this.getColorValue(), null, "color", null, 0, 1, BackgroundFilterProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBackgroundFilterProperty_Filter(), ecorePackage.getEString(), "filter", null, 0, 1, BackgroundFilterProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(backgroundGravityPropertyEClass, BackgroundGravityProperty.class, "BackgroundGravityProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBackgroundGravityProperty_Values(), ecorePackage.getEString(), "values", null, 0, -1, BackgroundGravityProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(backgroundFilterTypePropertyEClass, BackgroundFilterTypeProperty.class, "BackgroundFilterTypeProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBackgroundFilterTypeProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, BackgroundFilterTypeProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(shorthandColorPropertyEClass, ShorthandColorProperty.class, "ShorthandColorProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getShorthandColorProperty_Values(), this.getColorValue(), null, "values", null, 0, -1, ShorthandColorProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(colorPropertyEClass, ColorProperty.class, "ColorProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getColorProperty_Value(), this.getColorValue(), null, "value", null, 0, 1, ColorProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(alignmentPropertyEClass, AlignmentProperty.class, "AlignmentProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAlignmentProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, AlignmentProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timeValueEClass, TimeValue.class, "TimeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTimeValue_Time(), ecorePackage.getEString(), "time", null, 0, 1, TimeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTimeValue_Unit(), ecorePackage.getEString(), "unit", null, 0, 1, TimeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(viewSizeValueEClass, ViewSizeValue.class, "ViewSizeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getViewSizeValue_Value(), this.getSizeValue(), null, "value", null, 0, 1, ViewSizeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getViewSizeValue_Dynamic(), ecorePackage.getEString(), "dynamic", null, 0, 1, ViewSizeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sizeValueEClass, SizeValue.class, "SizeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSizeValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, SizeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSizeValue_Dimension(), ecorePackage.getEString(), "dimension", null, 0, 1, SizeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(paintValueEClass, PaintValue.class, "PaintValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(linearGradientEClass, LinearGradient.class, "LinearGradient", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLinearGradient_X1(), this.getSizeValue(), null, "x1", null, 0, 1, LinearGradient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLinearGradient_Y1(), this.getSizeValue(), null, "y1", null, 0, 1, LinearGradient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLinearGradient_X2(), this.getSizeValue(), null, "x2", null, 0, 1, LinearGradient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLinearGradient_Y2(), this.getSizeValue(), null, "y2", null, 0, 1, LinearGradient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLinearGradient_Stops(), this.getStopValue(), null, "stops", null, 0, -1, LinearGradient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(radialGradientEClass, RadialGradient.class, "RadialGradient", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRadialGradient_Cx(), this.getSizeValue(), null, "cx", null, 0, 1, RadialGradient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRadialGradient_Cy(), this.getSizeValue(), null, "cy", null, 0, 1, RadialGradient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRadialGradient_Radius(), this.getSizeValue(), null, "radius", null, 0, 1, RadialGradient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRadialGradient_Fx(), this.getSizeValue(), null, "fx", null, 0, 1, RadialGradient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRadialGradient_Fy(), this.getSizeValue(), null, "fy", null, 0, 1, RadialGradient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRadialGradient_Stops(), this.getStopValue(), null, "stops", null, 0, -1, RadialGradient.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stopValueEClass, StopValue.class, "StopValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStopValue_Pos(), this.getSizeValue(), null, "pos", null, 0, 1, StopValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStopValue_Color(), this.getColorValue(), null, "color", null, 0, 1, StopValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(colorValueEClass, ColorValue.class, "ColorValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getColorValue_NamedColor(), ecorePackage.getEString(), "namedColor", null, 0, 1, ColorValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getColorValue_Rgb(), this.getRGBColor(), null, "rgb", null, 0, 1, ColorValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rgbColorEClass, RGBColor.class, "RGBColor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRGBColor_Hex(), ecorePackage.getEString(), "hex", null, 0, 1, RGBColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRGBColor_R(), ecorePackage.getEString(), "r", null, 0, 1, RGBColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRGBColor_G(), ecorePackage.getEString(), "g", null, 0, 1, RGBColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRGBColor_B(), ecorePackage.getEString(), "b", null, 0, 1, RGBColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRGBColor_Alpha(), ecorePackage.getEString(), "alpha", null, 0, 1, RGBColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(hsbColorEClass, HSBColor.class, "HSBColor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getHSBColor_Hue(), ecorePackage.getEString(), "hue", null, 0, 1, HSBColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHSBColor_Saturation(), ecorePackage.getEString(), "saturation", null, 0, 1, HSBColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHSBColor_Brightness(), ecorePackage.getEString(), "brightness", null, 0, 1, HSBColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHSBColor_Alpha(), ecorePackage.getEString(), "alpha", null, 0, 1, HSBColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(colorFunctionEClass, ColorFunction.class, "ColorFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getColorFunction_Orig(), this.getColorValue(), null, "orig", null, 0, 1, ColorFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getColorFunction_Mod(), ecorePackage.getEString(), "mod", null, 0, 1, ColorFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getColorFunction_StopNumbers(), ecorePackage.getEString(), "stopNumbers", null, 0, -1, ColorFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getColorFunction_StopColors(), this.getColorValue(), null, "stopColors", null, 0, -1, ColorFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //LatteCSSPackageImpl
