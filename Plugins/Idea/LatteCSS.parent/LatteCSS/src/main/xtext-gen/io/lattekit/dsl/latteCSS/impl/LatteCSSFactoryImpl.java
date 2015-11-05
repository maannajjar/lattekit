/**
 */
package io.lattekit.dsl.latteCSS.impl;

import io.lattekit.dsl.latteCSS.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LatteCSSFactoryImpl extends EFactoryImpl implements LatteCSSFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LatteCSSFactory init()
  {
    try
    {
      LatteCSSFactory theLatteCSSFactory = (LatteCSSFactory)EPackage.Registry.INSTANCE.getEFactory(LatteCSSPackage.eNS_URI);
      if (theLatteCSSFactory != null)
      {
        return theLatteCSSFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LatteCSSFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LatteCSSFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case LatteCSSPackage.CSS: return createCSS();
      case LatteCSSPackage.DEFINITION: return createDefinition();
      case LatteCSSPackage.SELECTOR: return createSelector();
      case LatteCSSPackage.SIMPLE_SELECTOR: return createSimpleSelector();
      case LatteCSSPackage.ID_SELECTOR: return createIdSelector();
      case LatteCSSPackage.CLASS_SELECTOR: return createClassSelector();
      case LatteCSSPackage.PSEUDO_CLASS_SELECTOR: return createPseudoClassSelector();
      case LatteCSSPackage.CSS_PROPERTY: return createCSSProperty();
      case LatteCSSPackage.FONT_FAMILY_PROPERTY: return createFontFamilyProperty();
      case LatteCSSPackage.FONT_STYLE_PROPERTY: return createFontStyleProperty();
      case LatteCSSPackage.VIEW_SIZE_PROPERTY: return createViewSizeProperty();
      case LatteCSSPackage.SHORTHAND_SIZE_PROPERTY: return createShorthandSizeProperty();
      case LatteCSSPackage.BORDER_RADIUS_PROPERTY: return createBorderRadiusProperty();
      case LatteCSSPackage.SIZE_PROPERTY: return createSizeProperty();
      case LatteCSSPackage.PAINT_PROPERTY: return createPaintProperty();
      case LatteCSSPackage.TRANSITION_PROPERTY: return createTransitionProperty();
      case LatteCSSPackage.TRANSITION_VALUE: return createTransitionValue();
      case LatteCSSPackage.DRAWABLE_PROPERTY: return createDrawableProperty();
      case LatteCSSPackage.BACKGROUND_REPEAT_PROPERTY: return createBackgroundRepeatProperty();
      case LatteCSSPackage.BORDER_PROPERTY: return createBorderProperty();
      case LatteCSSPackage.BACKGROUND_FILTER_PROPERTY: return createBackgroundFilterProperty();
      case LatteCSSPackage.BACKGROUND_GRAVITY_PROPERTY: return createBackgroundGravityProperty();
      case LatteCSSPackage.BACKGROUND_FILTER_TYPE_PROPERTY: return createBackgroundFilterTypeProperty();
      case LatteCSSPackage.SHORTHAND_COLOR_PROPERTY: return createShorthandColorProperty();
      case LatteCSSPackage.COLOR_PROPERTY: return createColorProperty();
      case LatteCSSPackage.ALIGNMENT_PROPERTY: return createAlignmentProperty();
      case LatteCSSPackage.TIME_VALUE: return createTimeValue();
      case LatteCSSPackage.VIEW_SIZE_VALUE: return createViewSizeValue();
      case LatteCSSPackage.SIZE_VALUE: return createSizeValue();
      case LatteCSSPackage.PAINT_VALUE: return createPaintValue();
      case LatteCSSPackage.LINEAR_GRADIENT: return createLinearGradient();
      case LatteCSSPackage.RADIAL_GRADIENT: return createRadialGradient();
      case LatteCSSPackage.STOP_VALUE: return createStopValue();
      case LatteCSSPackage.COLOR_VALUE: return createColorValue();
      case LatteCSSPackage.RGB_COLOR: return createRGBColor();
      case LatteCSSPackage.HSB_COLOR: return createHSBColor();
      case LatteCSSPackage.COLOR_FUNCTION: return createColorFunction();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CSS createCSS()
  {
    CSSImpl css = new CSSImpl();
    return css;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Definition createDefinition()
  {
    DefinitionImpl definition = new DefinitionImpl();
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Selector createSelector()
  {
    SelectorImpl selector = new SelectorImpl();
    return selector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleSelector createSimpleSelector()
  {
    SimpleSelectorImpl simpleSelector = new SimpleSelectorImpl();
    return simpleSelector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdSelector createIdSelector()
  {
    IdSelectorImpl idSelector = new IdSelectorImpl();
    return idSelector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassSelector createClassSelector()
  {
    ClassSelectorImpl classSelector = new ClassSelectorImpl();
    return classSelector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PseudoClassSelector createPseudoClassSelector()
  {
    PseudoClassSelectorImpl pseudoClassSelector = new PseudoClassSelectorImpl();
    return pseudoClassSelector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CSSProperty createCSSProperty()
  {
    CSSPropertyImpl cssProperty = new CSSPropertyImpl();
    return cssProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FontFamilyProperty createFontFamilyProperty()
  {
    FontFamilyPropertyImpl fontFamilyProperty = new FontFamilyPropertyImpl();
    return fontFamilyProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FontStyleProperty createFontStyleProperty()
  {
    FontStylePropertyImpl fontStyleProperty = new FontStylePropertyImpl();
    return fontStyleProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ViewSizeProperty createViewSizeProperty()
  {
    ViewSizePropertyImpl viewSizeProperty = new ViewSizePropertyImpl();
    return viewSizeProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShorthandSizeProperty createShorthandSizeProperty()
  {
    ShorthandSizePropertyImpl shorthandSizeProperty = new ShorthandSizePropertyImpl();
    return shorthandSizeProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BorderRadiusProperty createBorderRadiusProperty()
  {
    BorderRadiusPropertyImpl borderRadiusProperty = new BorderRadiusPropertyImpl();
    return borderRadiusProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SizeProperty createSizeProperty()
  {
    SizePropertyImpl sizeProperty = new SizePropertyImpl();
    return sizeProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PaintProperty createPaintProperty()
  {
    PaintPropertyImpl paintProperty = new PaintPropertyImpl();
    return paintProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionProperty createTransitionProperty()
  {
    TransitionPropertyImpl transitionProperty = new TransitionPropertyImpl();
    return transitionProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionValue createTransitionValue()
  {
    TransitionValueImpl transitionValue = new TransitionValueImpl();
    return transitionValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DrawableProperty createDrawableProperty()
  {
    DrawablePropertyImpl drawableProperty = new DrawablePropertyImpl();
    return drawableProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BackgroundRepeatProperty createBackgroundRepeatProperty()
  {
    BackgroundRepeatPropertyImpl backgroundRepeatProperty = new BackgroundRepeatPropertyImpl();
    return backgroundRepeatProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BorderProperty createBorderProperty()
  {
    BorderPropertyImpl borderProperty = new BorderPropertyImpl();
    return borderProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BackgroundFilterProperty createBackgroundFilterProperty()
  {
    BackgroundFilterPropertyImpl backgroundFilterProperty = new BackgroundFilterPropertyImpl();
    return backgroundFilterProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BackgroundGravityProperty createBackgroundGravityProperty()
  {
    BackgroundGravityPropertyImpl backgroundGravityProperty = new BackgroundGravityPropertyImpl();
    return backgroundGravityProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BackgroundFilterTypeProperty createBackgroundFilterTypeProperty()
  {
    BackgroundFilterTypePropertyImpl backgroundFilterTypeProperty = new BackgroundFilterTypePropertyImpl();
    return backgroundFilterTypeProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShorthandColorProperty createShorthandColorProperty()
  {
    ShorthandColorPropertyImpl shorthandColorProperty = new ShorthandColorPropertyImpl();
    return shorthandColorProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ColorProperty createColorProperty()
  {
    ColorPropertyImpl colorProperty = new ColorPropertyImpl();
    return colorProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlignmentProperty createAlignmentProperty()
  {
    AlignmentPropertyImpl alignmentProperty = new AlignmentPropertyImpl();
    return alignmentProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeValue createTimeValue()
  {
    TimeValueImpl timeValue = new TimeValueImpl();
    return timeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ViewSizeValue createViewSizeValue()
  {
    ViewSizeValueImpl viewSizeValue = new ViewSizeValueImpl();
    return viewSizeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SizeValue createSizeValue()
  {
    SizeValueImpl sizeValue = new SizeValueImpl();
    return sizeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PaintValue createPaintValue()
  {
    PaintValueImpl paintValue = new PaintValueImpl();
    return paintValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinearGradient createLinearGradient()
  {
    LinearGradientImpl linearGradient = new LinearGradientImpl();
    return linearGradient;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RadialGradient createRadialGradient()
  {
    RadialGradientImpl radialGradient = new RadialGradientImpl();
    return radialGradient;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StopValue createStopValue()
  {
    StopValueImpl stopValue = new StopValueImpl();
    return stopValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ColorValue createColorValue()
  {
    ColorValueImpl colorValue = new ColorValueImpl();
    return colorValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RGBColor createRGBColor()
  {
    RGBColorImpl rgbColor = new RGBColorImpl();
    return rgbColor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HSBColor createHSBColor()
  {
    HSBColorImpl hsbColor = new HSBColorImpl();
    return hsbColor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ColorFunction createColorFunction()
  {
    ColorFunctionImpl colorFunction = new ColorFunctionImpl();
    return colorFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LatteCSSPackage getLatteCSSPackage()
  {
    return (LatteCSSPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LatteCSSPackage getPackage()
  {
    return LatteCSSPackage.eINSTANCE;
  }

} //LatteCSSFactoryImpl
