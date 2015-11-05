/**
 */
package io.lattekit.dsl.latteCSS;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see io.lattekit.dsl.latteCSS.LatteCSSFactory
 * @model kind="package"
 * @generated
 */
public interface LatteCSSPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "latteCSS";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.lattekit.io/dsl/LatteCSS";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "latteCSS";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LatteCSSPackage eINSTANCE = io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl.init();

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.CSSImpl <em>CSS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.CSSImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getCSS()
   * @generated
   */
  int CSS = 0;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CSS__DEFINITIONS = 0;

  /**
   * The number of structural features of the '<em>CSS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CSS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.DefinitionImpl <em>Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.DefinitionImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getDefinition()
   * @generated
   */
  int DEFINITION = 1;

  /**
   * The feature id for the '<em><b>Selector</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__SELECTOR = 0;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__PROPERTIES = 1;

  /**
   * The number of structural features of the '<em>Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.SelectorImpl <em>Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.SelectorImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getSelector()
   * @generated
   */
  int SELECTOR = 2;

  /**
   * The feature id for the '<em><b>Simple Selector</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTOR__SIMPLE_SELECTOR = 0;

  /**
   * The number of structural features of the '<em>Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.SimpleSelectorImpl <em>Simple Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.SimpleSelectorImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getSimpleSelector()
   * @generated
   */
  int SIMPLE_SELECTOR = 3;

  /**
   * The feature id for the '<em><b>Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SELECTOR__ELEMENT = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SELECTOR__ID = 1;

  /**
   * The feature id for the '<em><b>Pseudo Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SELECTOR__PSEUDO_CLASS = 2;

  /**
   * The feature id for the '<em><b>Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SELECTOR__CLASS = 3;

  /**
   * The number of structural features of the '<em>Simple Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SELECTOR_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.IdSelectorImpl <em>Id Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.IdSelectorImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getIdSelector()
   * @generated
   */
  int ID_SELECTOR = 4;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_SELECTOR__ID = 0;

  /**
   * The number of structural features of the '<em>Id Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_SELECTOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.ClassSelectorImpl <em>Class Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.ClassSelectorImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getClassSelector()
   * @generated
   */
  int CLASS_SELECTOR = 5;

  /**
   * The feature id for the '<em><b>Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_SELECTOR__CLASS = 0;

  /**
   * The number of structural features of the '<em>Class Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_SELECTOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.PseudoClassSelectorImpl <em>Pseudo Class Selector</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.PseudoClassSelectorImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getPseudoClassSelector()
   * @generated
   */
  int PSEUDO_CLASS_SELECTOR = 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PSEUDO_CLASS_SELECTOR__VALUE = 0;

  /**
   * The number of structural features of the '<em>Pseudo Class Selector</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PSEUDO_CLASS_SELECTOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.CSSPropertyImpl <em>CSS Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.CSSPropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getCSSProperty()
   * @generated
   */
  int CSS_PROPERTY = 7;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CSS_PROPERTY__PROPERTY = 0;

  /**
   * The number of structural features of the '<em>CSS Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CSS_PROPERTY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.FontFamilyPropertyImpl <em>Font Family Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.FontFamilyPropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getFontFamilyProperty()
   * @generated
   */
  int FONT_FAMILY_PROPERTY = 8;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT_FAMILY_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT_FAMILY_PROPERTY__VALUE = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Font Family Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT_FAMILY_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.FontStylePropertyImpl <em>Font Style Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.FontStylePropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getFontStyleProperty()
   * @generated
   */
  int FONT_STYLE_PROPERTY = 9;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT_STYLE_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT_STYLE_PROPERTY__VALUE = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Font Style Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FONT_STYLE_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.ViewSizePropertyImpl <em>View Size Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.ViewSizePropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getViewSizeProperty()
   * @generated
   */
  int VIEW_SIZE_PROPERTY = 10;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEW_SIZE_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEW_SIZE_PROPERTY__VALUE = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>View Size Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEW_SIZE_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.ShorthandSizePropertyImpl <em>Shorthand Size Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.ShorthandSizePropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getShorthandSizeProperty()
   * @generated
   */
  int SHORTHAND_SIZE_PROPERTY = 11;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORTHAND_SIZE_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORTHAND_SIZE_PROPERTY__VALUES = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Shorthand Size Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORTHAND_SIZE_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.BorderRadiusPropertyImpl <em>Border Radius Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.BorderRadiusPropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getBorderRadiusProperty()
   * @generated
   */
  int BORDER_RADIUS_PROPERTY = 12;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BORDER_RADIUS_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BORDER_RADIUS_PROPERTY__VALUES = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Border Radius Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BORDER_RADIUS_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.SizePropertyImpl <em>Size Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.SizePropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getSizeProperty()
   * @generated
   */
  int SIZE_PROPERTY = 13;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIZE_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIZE_PROPERTY__VALUE = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Size Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIZE_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.PaintPropertyImpl <em>Paint Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.PaintPropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getPaintProperty()
   * @generated
   */
  int PAINT_PROPERTY = 14;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAINT_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAINT_PROPERTY__VALUE = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Paint Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAINT_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.TransitionPropertyImpl <em>Transition Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.TransitionPropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getTransitionProperty()
   * @generated
   */
  int TRANSITION_PROPERTY = 15;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_PROPERTY__TRANSITIONS = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Transition Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.TransitionValueImpl <em>Transition Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.TransitionValueImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getTransitionValue()
   * @generated
   */
  int TRANSITION_VALUE = 16;

  /**
   * The feature id for the '<em><b>Property Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_VALUE__PROPERTY_NAME = 0;

  /**
   * The feature id for the '<em><b>Duration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_VALUE__DURATION = 1;

  /**
   * The feature id for the '<em><b>Timing Function</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_VALUE__TIMING_FUNCTION = 2;

  /**
   * The feature id for the '<em><b>Delay</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_VALUE__DELAY = 3;

  /**
   * The number of structural features of the '<em>Transition Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_VALUE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.DrawablePropertyImpl <em>Drawable Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.DrawablePropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getDrawableProperty()
   * @generated
   */
  int DRAWABLE_PROPERTY = 17;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DRAWABLE_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DRAWABLE_PROPERTY__VALUE = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Drawable Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DRAWABLE_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.BackgroundRepeatPropertyImpl <em>Background Repeat Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.BackgroundRepeatPropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getBackgroundRepeatProperty()
   * @generated
   */
  int BACKGROUND_REPEAT_PROPERTY = 18;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BACKGROUND_REPEAT_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BACKGROUND_REPEAT_PROPERTY__VALUES = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Background Repeat Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BACKGROUND_REPEAT_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.BorderPropertyImpl <em>Border Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.BorderPropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getBorderProperty()
   * @generated
   */
  int BORDER_PROPERTY = 19;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BORDER_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Width</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BORDER_PROPERTY__WIDTH = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Style</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BORDER_PROPERTY__STYLE = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Color</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BORDER_PROPERTY__COLOR = CSS_PROPERTY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Border Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BORDER_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.BackgroundFilterPropertyImpl <em>Background Filter Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.BackgroundFilterPropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getBackgroundFilterProperty()
   * @generated
   */
  int BACKGROUND_FILTER_PROPERTY = 20;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BACKGROUND_FILTER_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Color</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BACKGROUND_FILTER_PROPERTY__COLOR = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Filter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BACKGROUND_FILTER_PROPERTY__FILTER = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Background Filter Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BACKGROUND_FILTER_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.BackgroundGravityPropertyImpl <em>Background Gravity Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.BackgroundGravityPropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getBackgroundGravityProperty()
   * @generated
   */
  int BACKGROUND_GRAVITY_PROPERTY = 21;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BACKGROUND_GRAVITY_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BACKGROUND_GRAVITY_PROPERTY__VALUES = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Background Gravity Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BACKGROUND_GRAVITY_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.BackgroundFilterTypePropertyImpl <em>Background Filter Type Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.BackgroundFilterTypePropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getBackgroundFilterTypeProperty()
   * @generated
   */
  int BACKGROUND_FILTER_TYPE_PROPERTY = 22;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BACKGROUND_FILTER_TYPE_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BACKGROUND_FILTER_TYPE_PROPERTY__VALUE = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Background Filter Type Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BACKGROUND_FILTER_TYPE_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.ShorthandColorPropertyImpl <em>Shorthand Color Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.ShorthandColorPropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getShorthandColorProperty()
   * @generated
   */
  int SHORTHAND_COLOR_PROPERTY = 23;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORTHAND_COLOR_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORTHAND_COLOR_PROPERTY__VALUES = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Shorthand Color Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHORTHAND_COLOR_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.ColorPropertyImpl <em>Color Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.ColorPropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getColorProperty()
   * @generated
   */
  int COLOR_PROPERTY = 24;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_PROPERTY__VALUE = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Color Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.AlignmentPropertyImpl <em>Alignment Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.AlignmentPropertyImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getAlignmentProperty()
   * @generated
   */
  int ALIGNMENT_PROPERTY = 25;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIGNMENT_PROPERTY__PROPERTY = CSS_PROPERTY__PROPERTY;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIGNMENT_PROPERTY__VALUE = CSS_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Alignment Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIGNMENT_PROPERTY_FEATURE_COUNT = CSS_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.TimeValueImpl <em>Time Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.TimeValueImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getTimeValue()
   * @generated
   */
  int TIME_VALUE = 26;

  /**
   * The feature id for the '<em><b>Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_VALUE__TIME = 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_VALUE__UNIT = 1;

  /**
   * The number of structural features of the '<em>Time Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_VALUE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.ViewSizeValueImpl <em>View Size Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.ViewSizeValueImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getViewSizeValue()
   * @generated
   */
  int VIEW_SIZE_VALUE = 27;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEW_SIZE_VALUE__VALUE = 0;

  /**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEW_SIZE_VALUE__DYNAMIC = 1;

  /**
   * The number of structural features of the '<em>View Size Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEW_SIZE_VALUE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.SizeValueImpl <em>Size Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.SizeValueImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getSizeValue()
   * @generated
   */
  int SIZE_VALUE = 28;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIZE_VALUE__VALUE = 0;

  /**
   * The feature id for the '<em><b>Dimension</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIZE_VALUE__DIMENSION = 1;

  /**
   * The number of structural features of the '<em>Size Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIZE_VALUE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.PaintValueImpl <em>Paint Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.PaintValueImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getPaintValue()
   * @generated
   */
  int PAINT_VALUE = 29;

  /**
   * The number of structural features of the '<em>Paint Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAINT_VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.LinearGradientImpl <em>Linear Gradient</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.LinearGradientImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getLinearGradient()
   * @generated
   */
  int LINEAR_GRADIENT = 30;

  /**
   * The feature id for the '<em><b>X1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINEAR_GRADIENT__X1 = PAINT_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Y1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINEAR_GRADIENT__Y1 = PAINT_VALUE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>X2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINEAR_GRADIENT__X2 = PAINT_VALUE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Y2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINEAR_GRADIENT__Y2 = PAINT_VALUE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Stops</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINEAR_GRADIENT__STOPS = PAINT_VALUE_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Linear Gradient</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINEAR_GRADIENT_FEATURE_COUNT = PAINT_VALUE_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.RadialGradientImpl <em>Radial Gradient</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.RadialGradientImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getRadialGradient()
   * @generated
   */
  int RADIAL_GRADIENT = 31;

  /**
   * The feature id for the '<em><b>Cx</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RADIAL_GRADIENT__CX = PAINT_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Cy</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RADIAL_GRADIENT__CY = PAINT_VALUE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Radius</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RADIAL_GRADIENT__RADIUS = PAINT_VALUE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Fx</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RADIAL_GRADIENT__FX = PAINT_VALUE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Fy</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RADIAL_GRADIENT__FY = PAINT_VALUE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Stops</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RADIAL_GRADIENT__STOPS = PAINT_VALUE_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Radial Gradient</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RADIAL_GRADIENT_FEATURE_COUNT = PAINT_VALUE_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.StopValueImpl <em>Stop Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.StopValueImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getStopValue()
   * @generated
   */
  int STOP_VALUE = 32;

  /**
   * The feature id for the '<em><b>Pos</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STOP_VALUE__POS = 0;

  /**
   * The feature id for the '<em><b>Color</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STOP_VALUE__COLOR = 1;

  /**
   * The number of structural features of the '<em>Stop Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STOP_VALUE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.ColorValueImpl <em>Color Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.ColorValueImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getColorValue()
   * @generated
   */
  int COLOR_VALUE = 33;

  /**
   * The feature id for the '<em><b>Named Color</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_VALUE__NAMED_COLOR = PAINT_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rgb</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_VALUE__RGB = PAINT_VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Color Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_VALUE_FEATURE_COUNT = PAINT_VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.RGBColorImpl <em>RGB Color</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.RGBColorImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getRGBColor()
   * @generated
   */
  int RGB_COLOR = 34;

  /**
   * The feature id for the '<em><b>Hex</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB_COLOR__HEX = 0;

  /**
   * The feature id for the '<em><b>R</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB_COLOR__R = 1;

  /**
   * The feature id for the '<em><b>G</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB_COLOR__G = 2;

  /**
   * The feature id for the '<em><b>B</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB_COLOR__B = 3;

  /**
   * The feature id for the '<em><b>Alpha</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB_COLOR__ALPHA = 4;

  /**
   * The number of structural features of the '<em>RGB Color</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RGB_COLOR_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.HSBColorImpl <em>HSB Color</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.HSBColorImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getHSBColor()
   * @generated
   */
  int HSB_COLOR = 35;

  /**
   * The feature id for the '<em><b>Hue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HSB_COLOR__HUE = 0;

  /**
   * The feature id for the '<em><b>Saturation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HSB_COLOR__SATURATION = 1;

  /**
   * The feature id for the '<em><b>Brightness</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HSB_COLOR__BRIGHTNESS = 2;

  /**
   * The feature id for the '<em><b>Alpha</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HSB_COLOR__ALPHA = 3;

  /**
   * The number of structural features of the '<em>HSB Color</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HSB_COLOR_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link io.lattekit.dsl.latteCSS.impl.ColorFunctionImpl <em>Color Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see io.lattekit.dsl.latteCSS.impl.ColorFunctionImpl
   * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getColorFunction()
   * @generated
   */
  int COLOR_FUNCTION = 36;

  /**
   * The feature id for the '<em><b>Orig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_FUNCTION__ORIG = 0;

  /**
   * The feature id for the '<em><b>Mod</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_FUNCTION__MOD = 1;

  /**
   * The feature id for the '<em><b>Stop Numbers</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_FUNCTION__STOP_NUMBERS = 2;

  /**
   * The feature id for the '<em><b>Stop Colors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_FUNCTION__STOP_COLORS = 3;

  /**
   * The number of structural features of the '<em>Color Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLOR_FUNCTION_FEATURE_COUNT = 4;


  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.CSS <em>CSS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CSS</em>'.
   * @see io.lattekit.dsl.latteCSS.CSS
   * @generated
   */
  EClass getCSS();

  /**
   * Returns the meta object for the containment reference list '{@link io.lattekit.dsl.latteCSS.CSS#getDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definitions</em>'.
   * @see io.lattekit.dsl.latteCSS.CSS#getDefinitions()
   * @see #getCSS()
   * @generated
   */
  EReference getCSS_Definitions();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.Definition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definition</em>'.
   * @see io.lattekit.dsl.latteCSS.Definition
   * @generated
   */
  EClass getDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link io.lattekit.dsl.latteCSS.Definition#getSelector <em>Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Selector</em>'.
   * @see io.lattekit.dsl.latteCSS.Definition#getSelector()
   * @see #getDefinition()
   * @generated
   */
  EReference getDefinition_Selector();

  /**
   * Returns the meta object for the containment reference list '{@link io.lattekit.dsl.latteCSS.Definition#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see io.lattekit.dsl.latteCSS.Definition#getProperties()
   * @see #getDefinition()
   * @generated
   */
  EReference getDefinition_Properties();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.Selector <em>Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selector</em>'.
   * @see io.lattekit.dsl.latteCSS.Selector
   * @generated
   */
  EClass getSelector();

  /**
   * Returns the meta object for the containment reference list '{@link io.lattekit.dsl.latteCSS.Selector#getSimpleSelector <em>Simple Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Simple Selector</em>'.
   * @see io.lattekit.dsl.latteCSS.Selector#getSimpleSelector()
   * @see #getSelector()
   * @generated
   */
  EReference getSelector_SimpleSelector();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.SimpleSelector <em>Simple Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Selector</em>'.
   * @see io.lattekit.dsl.latteCSS.SimpleSelector
   * @generated
   */
  EClass getSimpleSelector();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.SimpleSelector#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Element</em>'.
   * @see io.lattekit.dsl.latteCSS.SimpleSelector#getElement()
   * @see #getSimpleSelector()
   * @generated
   */
  EAttribute getSimpleSelector_Element();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.SimpleSelector#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Id</em>'.
   * @see io.lattekit.dsl.latteCSS.SimpleSelector#getId()
   * @see #getSimpleSelector()
   * @generated
   */
  EReference getSimpleSelector_Id();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.SimpleSelector#getPseudoClass <em>Pseudo Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Pseudo Class</em>'.
   * @see io.lattekit.dsl.latteCSS.SimpleSelector#getPseudoClass()
   * @see #getSimpleSelector()
   * @generated
   */
  EReference getSimpleSelector_PseudoClass();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.SimpleSelector#getClass_ <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Class</em>'.
   * @see io.lattekit.dsl.latteCSS.SimpleSelector#getClass_()
   * @see #getSimpleSelector()
   * @generated
   */
  EReference getSimpleSelector_Class();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.IdSelector <em>Id Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Id Selector</em>'.
   * @see io.lattekit.dsl.latteCSS.IdSelector
   * @generated
   */
  EClass getIdSelector();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.IdSelector#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see io.lattekit.dsl.latteCSS.IdSelector#getId()
   * @see #getIdSelector()
   * @generated
   */
  EAttribute getIdSelector_Id();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.ClassSelector <em>Class Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Selector</em>'.
   * @see io.lattekit.dsl.latteCSS.ClassSelector
   * @generated
   */
  EClass getClassSelector();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.ClassSelector#getClass_ <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Class</em>'.
   * @see io.lattekit.dsl.latteCSS.ClassSelector#getClass_()
   * @see #getClassSelector()
   * @generated
   */
  EAttribute getClassSelector_Class();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.PseudoClassSelector <em>Pseudo Class Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pseudo Class Selector</em>'.
   * @see io.lattekit.dsl.latteCSS.PseudoClassSelector
   * @generated
   */
  EClass getPseudoClassSelector();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.PseudoClassSelector#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see io.lattekit.dsl.latteCSS.PseudoClassSelector#getValue()
   * @see #getPseudoClassSelector()
   * @generated
   */
  EAttribute getPseudoClassSelector_Value();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.CSSProperty <em>CSS Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>CSS Property</em>'.
   * @see io.lattekit.dsl.latteCSS.CSSProperty
   * @generated
   */
  EClass getCSSProperty();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.CSSProperty#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property</em>'.
   * @see io.lattekit.dsl.latteCSS.CSSProperty#getProperty()
   * @see #getCSSProperty()
   * @generated
   */
  EAttribute getCSSProperty_Property();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.FontFamilyProperty <em>Font Family Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Font Family Property</em>'.
   * @see io.lattekit.dsl.latteCSS.FontFamilyProperty
   * @generated
   */
  EClass getFontFamilyProperty();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.FontFamilyProperty#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see io.lattekit.dsl.latteCSS.FontFamilyProperty#getValue()
   * @see #getFontFamilyProperty()
   * @generated
   */
  EAttribute getFontFamilyProperty_Value();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.FontStyleProperty <em>Font Style Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Font Style Property</em>'.
   * @see io.lattekit.dsl.latteCSS.FontStyleProperty
   * @generated
   */
  EClass getFontStyleProperty();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.FontStyleProperty#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see io.lattekit.dsl.latteCSS.FontStyleProperty#getValue()
   * @see #getFontStyleProperty()
   * @generated
   */
  EAttribute getFontStyleProperty_Value();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.ViewSizeProperty <em>View Size Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>View Size Property</em>'.
   * @see io.lattekit.dsl.latteCSS.ViewSizeProperty
   * @generated
   */
  EClass getViewSizeProperty();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.ViewSizeProperty#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see io.lattekit.dsl.latteCSS.ViewSizeProperty#getValue()
   * @see #getViewSizeProperty()
   * @generated
   */
  EReference getViewSizeProperty_Value();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.ShorthandSizeProperty <em>Shorthand Size Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Shorthand Size Property</em>'.
   * @see io.lattekit.dsl.latteCSS.ShorthandSizeProperty
   * @generated
   */
  EClass getShorthandSizeProperty();

  /**
   * Returns the meta object for the containment reference list '{@link io.lattekit.dsl.latteCSS.ShorthandSizeProperty#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see io.lattekit.dsl.latteCSS.ShorthandSizeProperty#getValues()
   * @see #getShorthandSizeProperty()
   * @generated
   */
  EReference getShorthandSizeProperty_Values();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.BorderRadiusProperty <em>Border Radius Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Border Radius Property</em>'.
   * @see io.lattekit.dsl.latteCSS.BorderRadiusProperty
   * @generated
   */
  EClass getBorderRadiusProperty();

  /**
   * Returns the meta object for the containment reference list '{@link io.lattekit.dsl.latteCSS.BorderRadiusProperty#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see io.lattekit.dsl.latteCSS.BorderRadiusProperty#getValues()
   * @see #getBorderRadiusProperty()
   * @generated
   */
  EReference getBorderRadiusProperty_Values();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.SizeProperty <em>Size Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Size Property</em>'.
   * @see io.lattekit.dsl.latteCSS.SizeProperty
   * @generated
   */
  EClass getSizeProperty();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.SizeProperty#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see io.lattekit.dsl.latteCSS.SizeProperty#getValue()
   * @see #getSizeProperty()
   * @generated
   */
  EReference getSizeProperty_Value();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.PaintProperty <em>Paint Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Paint Property</em>'.
   * @see io.lattekit.dsl.latteCSS.PaintProperty
   * @generated
   */
  EClass getPaintProperty();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.PaintProperty#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see io.lattekit.dsl.latteCSS.PaintProperty#getValue()
   * @see #getPaintProperty()
   * @generated
   */
  EReference getPaintProperty_Value();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.TransitionProperty <em>Transition Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Property</em>'.
   * @see io.lattekit.dsl.latteCSS.TransitionProperty
   * @generated
   */
  EClass getTransitionProperty();

  /**
   * Returns the meta object for the containment reference list '{@link io.lattekit.dsl.latteCSS.TransitionProperty#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see io.lattekit.dsl.latteCSS.TransitionProperty#getTransitions()
   * @see #getTransitionProperty()
   * @generated
   */
  EReference getTransitionProperty_Transitions();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.TransitionValue <em>Transition Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Value</em>'.
   * @see io.lattekit.dsl.latteCSS.TransitionValue
   * @generated
   */
  EClass getTransitionValue();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.TransitionValue#getPropertyName <em>Property Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property Name</em>'.
   * @see io.lattekit.dsl.latteCSS.TransitionValue#getPropertyName()
   * @see #getTransitionValue()
   * @generated
   */
  EAttribute getTransitionValue_PropertyName();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.TransitionValue#getDuration <em>Duration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Duration</em>'.
   * @see io.lattekit.dsl.latteCSS.TransitionValue#getDuration()
   * @see #getTransitionValue()
   * @generated
   */
  EReference getTransitionValue_Duration();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.TransitionValue#getTimingFunction <em>Timing Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Timing Function</em>'.
   * @see io.lattekit.dsl.latteCSS.TransitionValue#getTimingFunction()
   * @see #getTransitionValue()
   * @generated
   */
  EAttribute getTransitionValue_TimingFunction();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.TransitionValue#getDelay <em>Delay</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Delay</em>'.
   * @see io.lattekit.dsl.latteCSS.TransitionValue#getDelay()
   * @see #getTransitionValue()
   * @generated
   */
  EReference getTransitionValue_Delay();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.DrawableProperty <em>Drawable Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Drawable Property</em>'.
   * @see io.lattekit.dsl.latteCSS.DrawableProperty
   * @generated
   */
  EClass getDrawableProperty();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.DrawableProperty#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see io.lattekit.dsl.latteCSS.DrawableProperty#getValue()
   * @see #getDrawableProperty()
   * @generated
   */
  EAttribute getDrawableProperty_Value();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.BackgroundRepeatProperty <em>Background Repeat Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Background Repeat Property</em>'.
   * @see io.lattekit.dsl.latteCSS.BackgroundRepeatProperty
   * @generated
   */
  EClass getBackgroundRepeatProperty();

  /**
   * Returns the meta object for the attribute list '{@link io.lattekit.dsl.latteCSS.BackgroundRepeatProperty#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Values</em>'.
   * @see io.lattekit.dsl.latteCSS.BackgroundRepeatProperty#getValues()
   * @see #getBackgroundRepeatProperty()
   * @generated
   */
  EAttribute getBackgroundRepeatProperty_Values();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.BorderProperty <em>Border Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Border Property</em>'.
   * @see io.lattekit.dsl.latteCSS.BorderProperty
   * @generated
   */
  EClass getBorderProperty();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.BorderProperty#getWidth <em>Width</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Width</em>'.
   * @see io.lattekit.dsl.latteCSS.BorderProperty#getWidth()
   * @see #getBorderProperty()
   * @generated
   */
  EReference getBorderProperty_Width();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.BorderProperty#getStyle <em>Style</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Style</em>'.
   * @see io.lattekit.dsl.latteCSS.BorderProperty#getStyle()
   * @see #getBorderProperty()
   * @generated
   */
  EAttribute getBorderProperty_Style();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.BorderProperty#getColor <em>Color</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Color</em>'.
   * @see io.lattekit.dsl.latteCSS.BorderProperty#getColor()
   * @see #getBorderProperty()
   * @generated
   */
  EReference getBorderProperty_Color();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.BackgroundFilterProperty <em>Background Filter Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Background Filter Property</em>'.
   * @see io.lattekit.dsl.latteCSS.BackgroundFilterProperty
   * @generated
   */
  EClass getBackgroundFilterProperty();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.BackgroundFilterProperty#getColor <em>Color</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Color</em>'.
   * @see io.lattekit.dsl.latteCSS.BackgroundFilterProperty#getColor()
   * @see #getBackgroundFilterProperty()
   * @generated
   */
  EReference getBackgroundFilterProperty_Color();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.BackgroundFilterProperty#getFilter <em>Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Filter</em>'.
   * @see io.lattekit.dsl.latteCSS.BackgroundFilterProperty#getFilter()
   * @see #getBackgroundFilterProperty()
   * @generated
   */
  EAttribute getBackgroundFilterProperty_Filter();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.BackgroundGravityProperty <em>Background Gravity Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Background Gravity Property</em>'.
   * @see io.lattekit.dsl.latteCSS.BackgroundGravityProperty
   * @generated
   */
  EClass getBackgroundGravityProperty();

  /**
   * Returns the meta object for the attribute list '{@link io.lattekit.dsl.latteCSS.BackgroundGravityProperty#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Values</em>'.
   * @see io.lattekit.dsl.latteCSS.BackgroundGravityProperty#getValues()
   * @see #getBackgroundGravityProperty()
   * @generated
   */
  EAttribute getBackgroundGravityProperty_Values();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.BackgroundFilterTypeProperty <em>Background Filter Type Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Background Filter Type Property</em>'.
   * @see io.lattekit.dsl.latteCSS.BackgroundFilterTypeProperty
   * @generated
   */
  EClass getBackgroundFilterTypeProperty();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.BackgroundFilterTypeProperty#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see io.lattekit.dsl.latteCSS.BackgroundFilterTypeProperty#getValue()
   * @see #getBackgroundFilterTypeProperty()
   * @generated
   */
  EAttribute getBackgroundFilterTypeProperty_Value();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.ShorthandColorProperty <em>Shorthand Color Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Shorthand Color Property</em>'.
   * @see io.lattekit.dsl.latteCSS.ShorthandColorProperty
   * @generated
   */
  EClass getShorthandColorProperty();

  /**
   * Returns the meta object for the containment reference list '{@link io.lattekit.dsl.latteCSS.ShorthandColorProperty#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see io.lattekit.dsl.latteCSS.ShorthandColorProperty#getValues()
   * @see #getShorthandColorProperty()
   * @generated
   */
  EReference getShorthandColorProperty_Values();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.ColorProperty <em>Color Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Color Property</em>'.
   * @see io.lattekit.dsl.latteCSS.ColorProperty
   * @generated
   */
  EClass getColorProperty();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.ColorProperty#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see io.lattekit.dsl.latteCSS.ColorProperty#getValue()
   * @see #getColorProperty()
   * @generated
   */
  EReference getColorProperty_Value();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.AlignmentProperty <em>Alignment Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alignment Property</em>'.
   * @see io.lattekit.dsl.latteCSS.AlignmentProperty
   * @generated
   */
  EClass getAlignmentProperty();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.AlignmentProperty#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see io.lattekit.dsl.latteCSS.AlignmentProperty#getValue()
   * @see #getAlignmentProperty()
   * @generated
   */
  EAttribute getAlignmentProperty_Value();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.TimeValue <em>Time Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Value</em>'.
   * @see io.lattekit.dsl.latteCSS.TimeValue
   * @generated
   */
  EClass getTimeValue();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.TimeValue#getTime <em>Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Time</em>'.
   * @see io.lattekit.dsl.latteCSS.TimeValue#getTime()
   * @see #getTimeValue()
   * @generated
   */
  EAttribute getTimeValue_Time();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.TimeValue#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see io.lattekit.dsl.latteCSS.TimeValue#getUnit()
   * @see #getTimeValue()
   * @generated
   */
  EAttribute getTimeValue_Unit();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.ViewSizeValue <em>View Size Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>View Size Value</em>'.
   * @see io.lattekit.dsl.latteCSS.ViewSizeValue
   * @generated
   */
  EClass getViewSizeValue();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.ViewSizeValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see io.lattekit.dsl.latteCSS.ViewSizeValue#getValue()
   * @see #getViewSizeValue()
   * @generated
   */
  EReference getViewSizeValue_Value();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.ViewSizeValue#getDynamic <em>Dynamic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dynamic</em>'.
   * @see io.lattekit.dsl.latteCSS.ViewSizeValue#getDynamic()
   * @see #getViewSizeValue()
   * @generated
   */
  EAttribute getViewSizeValue_Dynamic();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.SizeValue <em>Size Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Size Value</em>'.
   * @see io.lattekit.dsl.latteCSS.SizeValue
   * @generated
   */
  EClass getSizeValue();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.SizeValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see io.lattekit.dsl.latteCSS.SizeValue#getValue()
   * @see #getSizeValue()
   * @generated
   */
  EAttribute getSizeValue_Value();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.SizeValue#getDimension <em>Dimension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dimension</em>'.
   * @see io.lattekit.dsl.latteCSS.SizeValue#getDimension()
   * @see #getSizeValue()
   * @generated
   */
  EAttribute getSizeValue_Dimension();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.PaintValue <em>Paint Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Paint Value</em>'.
   * @see io.lattekit.dsl.latteCSS.PaintValue
   * @generated
   */
  EClass getPaintValue();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.LinearGradient <em>Linear Gradient</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Linear Gradient</em>'.
   * @see io.lattekit.dsl.latteCSS.LinearGradient
   * @generated
   */
  EClass getLinearGradient();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.LinearGradient#getX1 <em>X1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>X1</em>'.
   * @see io.lattekit.dsl.latteCSS.LinearGradient#getX1()
   * @see #getLinearGradient()
   * @generated
   */
  EReference getLinearGradient_X1();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.LinearGradient#getY1 <em>Y1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Y1</em>'.
   * @see io.lattekit.dsl.latteCSS.LinearGradient#getY1()
   * @see #getLinearGradient()
   * @generated
   */
  EReference getLinearGradient_Y1();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.LinearGradient#getX2 <em>X2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>X2</em>'.
   * @see io.lattekit.dsl.latteCSS.LinearGradient#getX2()
   * @see #getLinearGradient()
   * @generated
   */
  EReference getLinearGradient_X2();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.LinearGradient#getY2 <em>Y2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Y2</em>'.
   * @see io.lattekit.dsl.latteCSS.LinearGradient#getY2()
   * @see #getLinearGradient()
   * @generated
   */
  EReference getLinearGradient_Y2();

  /**
   * Returns the meta object for the containment reference list '{@link io.lattekit.dsl.latteCSS.LinearGradient#getStops <em>Stops</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Stops</em>'.
   * @see io.lattekit.dsl.latteCSS.LinearGradient#getStops()
   * @see #getLinearGradient()
   * @generated
   */
  EReference getLinearGradient_Stops();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.RadialGradient <em>Radial Gradient</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Radial Gradient</em>'.
   * @see io.lattekit.dsl.latteCSS.RadialGradient
   * @generated
   */
  EClass getRadialGradient();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.RadialGradient#getCx <em>Cx</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cx</em>'.
   * @see io.lattekit.dsl.latteCSS.RadialGradient#getCx()
   * @see #getRadialGradient()
   * @generated
   */
  EReference getRadialGradient_Cx();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.RadialGradient#getCy <em>Cy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cy</em>'.
   * @see io.lattekit.dsl.latteCSS.RadialGradient#getCy()
   * @see #getRadialGradient()
   * @generated
   */
  EReference getRadialGradient_Cy();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.RadialGradient#getRadius <em>Radius</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Radius</em>'.
   * @see io.lattekit.dsl.latteCSS.RadialGradient#getRadius()
   * @see #getRadialGradient()
   * @generated
   */
  EReference getRadialGradient_Radius();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.RadialGradient#getFx <em>Fx</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fx</em>'.
   * @see io.lattekit.dsl.latteCSS.RadialGradient#getFx()
   * @see #getRadialGradient()
   * @generated
   */
  EReference getRadialGradient_Fx();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.RadialGradient#getFy <em>Fy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fy</em>'.
   * @see io.lattekit.dsl.latteCSS.RadialGradient#getFy()
   * @see #getRadialGradient()
   * @generated
   */
  EReference getRadialGradient_Fy();

  /**
   * Returns the meta object for the containment reference list '{@link io.lattekit.dsl.latteCSS.RadialGradient#getStops <em>Stops</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Stops</em>'.
   * @see io.lattekit.dsl.latteCSS.RadialGradient#getStops()
   * @see #getRadialGradient()
   * @generated
   */
  EReference getRadialGradient_Stops();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.StopValue <em>Stop Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stop Value</em>'.
   * @see io.lattekit.dsl.latteCSS.StopValue
   * @generated
   */
  EClass getStopValue();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.StopValue#getPos <em>Pos</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Pos</em>'.
   * @see io.lattekit.dsl.latteCSS.StopValue#getPos()
   * @see #getStopValue()
   * @generated
   */
  EReference getStopValue_Pos();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.StopValue#getColor <em>Color</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Color</em>'.
   * @see io.lattekit.dsl.latteCSS.StopValue#getColor()
   * @see #getStopValue()
   * @generated
   */
  EReference getStopValue_Color();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.ColorValue <em>Color Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Color Value</em>'.
   * @see io.lattekit.dsl.latteCSS.ColorValue
   * @generated
   */
  EClass getColorValue();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.ColorValue#getNamedColor <em>Named Color</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Named Color</em>'.
   * @see io.lattekit.dsl.latteCSS.ColorValue#getNamedColor()
   * @see #getColorValue()
   * @generated
   */
  EAttribute getColorValue_NamedColor();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.ColorValue#getRgb <em>Rgb</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rgb</em>'.
   * @see io.lattekit.dsl.latteCSS.ColorValue#getRgb()
   * @see #getColorValue()
   * @generated
   */
  EReference getColorValue_Rgb();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.RGBColor <em>RGB Color</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RGB Color</em>'.
   * @see io.lattekit.dsl.latteCSS.RGBColor
   * @generated
   */
  EClass getRGBColor();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.RGBColor#getHex <em>Hex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Hex</em>'.
   * @see io.lattekit.dsl.latteCSS.RGBColor#getHex()
   * @see #getRGBColor()
   * @generated
   */
  EAttribute getRGBColor_Hex();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.RGBColor#getR <em>R</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>R</em>'.
   * @see io.lattekit.dsl.latteCSS.RGBColor#getR()
   * @see #getRGBColor()
   * @generated
   */
  EAttribute getRGBColor_R();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.RGBColor#getG <em>G</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>G</em>'.
   * @see io.lattekit.dsl.latteCSS.RGBColor#getG()
   * @see #getRGBColor()
   * @generated
   */
  EAttribute getRGBColor_G();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.RGBColor#getB <em>B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>B</em>'.
   * @see io.lattekit.dsl.latteCSS.RGBColor#getB()
   * @see #getRGBColor()
   * @generated
   */
  EAttribute getRGBColor_B();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.RGBColor#getAlpha <em>Alpha</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Alpha</em>'.
   * @see io.lattekit.dsl.latteCSS.RGBColor#getAlpha()
   * @see #getRGBColor()
   * @generated
   */
  EAttribute getRGBColor_Alpha();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.HSBColor <em>HSB Color</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>HSB Color</em>'.
   * @see io.lattekit.dsl.latteCSS.HSBColor
   * @generated
   */
  EClass getHSBColor();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.HSBColor#getHue <em>Hue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Hue</em>'.
   * @see io.lattekit.dsl.latteCSS.HSBColor#getHue()
   * @see #getHSBColor()
   * @generated
   */
  EAttribute getHSBColor_Hue();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.HSBColor#getSaturation <em>Saturation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Saturation</em>'.
   * @see io.lattekit.dsl.latteCSS.HSBColor#getSaturation()
   * @see #getHSBColor()
   * @generated
   */
  EAttribute getHSBColor_Saturation();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.HSBColor#getBrightness <em>Brightness</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Brightness</em>'.
   * @see io.lattekit.dsl.latteCSS.HSBColor#getBrightness()
   * @see #getHSBColor()
   * @generated
   */
  EAttribute getHSBColor_Brightness();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.HSBColor#getAlpha <em>Alpha</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Alpha</em>'.
   * @see io.lattekit.dsl.latteCSS.HSBColor#getAlpha()
   * @see #getHSBColor()
   * @generated
   */
  EAttribute getHSBColor_Alpha();

  /**
   * Returns the meta object for class '{@link io.lattekit.dsl.latteCSS.ColorFunction <em>Color Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Color Function</em>'.
   * @see io.lattekit.dsl.latteCSS.ColorFunction
   * @generated
   */
  EClass getColorFunction();

  /**
   * Returns the meta object for the containment reference '{@link io.lattekit.dsl.latteCSS.ColorFunction#getOrig <em>Orig</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Orig</em>'.
   * @see io.lattekit.dsl.latteCSS.ColorFunction#getOrig()
   * @see #getColorFunction()
   * @generated
   */
  EReference getColorFunction_Orig();

  /**
   * Returns the meta object for the attribute '{@link io.lattekit.dsl.latteCSS.ColorFunction#getMod <em>Mod</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mod</em>'.
   * @see io.lattekit.dsl.latteCSS.ColorFunction#getMod()
   * @see #getColorFunction()
   * @generated
   */
  EAttribute getColorFunction_Mod();

  /**
   * Returns the meta object for the attribute list '{@link io.lattekit.dsl.latteCSS.ColorFunction#getStopNumbers <em>Stop Numbers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Stop Numbers</em>'.
   * @see io.lattekit.dsl.latteCSS.ColorFunction#getStopNumbers()
   * @see #getColorFunction()
   * @generated
   */
  EAttribute getColorFunction_StopNumbers();

  /**
   * Returns the meta object for the containment reference list '{@link io.lattekit.dsl.latteCSS.ColorFunction#getStopColors <em>Stop Colors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Stop Colors</em>'.
   * @see io.lattekit.dsl.latteCSS.ColorFunction#getStopColors()
   * @see #getColorFunction()
   * @generated
   */
  EReference getColorFunction_StopColors();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  LatteCSSFactory getLatteCSSFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.CSSImpl <em>CSS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.CSSImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getCSS()
     * @generated
     */
    EClass CSS = eINSTANCE.getCSS();

    /**
     * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CSS__DEFINITIONS = eINSTANCE.getCSS_Definitions();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.DefinitionImpl <em>Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.DefinitionImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getDefinition()
     * @generated
     */
    EClass DEFINITION = eINSTANCE.getDefinition();

    /**
     * The meta object literal for the '<em><b>Selector</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINITION__SELECTOR = eINSTANCE.getDefinition_Selector();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINITION__PROPERTIES = eINSTANCE.getDefinition_Properties();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.SelectorImpl <em>Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.SelectorImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getSelector()
     * @generated
     */
    EClass SELECTOR = eINSTANCE.getSelector();

    /**
     * The meta object literal for the '<em><b>Simple Selector</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTOR__SIMPLE_SELECTOR = eINSTANCE.getSelector_SimpleSelector();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.SimpleSelectorImpl <em>Simple Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.SimpleSelectorImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getSimpleSelector()
     * @generated
     */
    EClass SIMPLE_SELECTOR = eINSTANCE.getSimpleSelector();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_SELECTOR__ELEMENT = eINSTANCE.getSimpleSelector_Element();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_SELECTOR__ID = eINSTANCE.getSimpleSelector_Id();

    /**
     * The meta object literal for the '<em><b>Pseudo Class</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_SELECTOR__PSEUDO_CLASS = eINSTANCE.getSimpleSelector_PseudoClass();

    /**
     * The meta object literal for the '<em><b>Class</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_SELECTOR__CLASS = eINSTANCE.getSimpleSelector_Class();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.IdSelectorImpl <em>Id Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.IdSelectorImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getIdSelector()
     * @generated
     */
    EClass ID_SELECTOR = eINSTANCE.getIdSelector();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ID_SELECTOR__ID = eINSTANCE.getIdSelector_Id();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.ClassSelectorImpl <em>Class Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.ClassSelectorImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getClassSelector()
     * @generated
     */
    EClass CLASS_SELECTOR = eINSTANCE.getClassSelector();

    /**
     * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_SELECTOR__CLASS = eINSTANCE.getClassSelector_Class();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.PseudoClassSelectorImpl <em>Pseudo Class Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.PseudoClassSelectorImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getPseudoClassSelector()
     * @generated
     */
    EClass PSEUDO_CLASS_SELECTOR = eINSTANCE.getPseudoClassSelector();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PSEUDO_CLASS_SELECTOR__VALUE = eINSTANCE.getPseudoClassSelector_Value();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.CSSPropertyImpl <em>CSS Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.CSSPropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getCSSProperty()
     * @generated
     */
    EClass CSS_PROPERTY = eINSTANCE.getCSSProperty();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CSS_PROPERTY__PROPERTY = eINSTANCE.getCSSProperty_Property();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.FontFamilyPropertyImpl <em>Font Family Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.FontFamilyPropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getFontFamilyProperty()
     * @generated
     */
    EClass FONT_FAMILY_PROPERTY = eINSTANCE.getFontFamilyProperty();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FONT_FAMILY_PROPERTY__VALUE = eINSTANCE.getFontFamilyProperty_Value();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.FontStylePropertyImpl <em>Font Style Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.FontStylePropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getFontStyleProperty()
     * @generated
     */
    EClass FONT_STYLE_PROPERTY = eINSTANCE.getFontStyleProperty();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FONT_STYLE_PROPERTY__VALUE = eINSTANCE.getFontStyleProperty_Value();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.ViewSizePropertyImpl <em>View Size Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.ViewSizePropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getViewSizeProperty()
     * @generated
     */
    EClass VIEW_SIZE_PROPERTY = eINSTANCE.getViewSizeProperty();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VIEW_SIZE_PROPERTY__VALUE = eINSTANCE.getViewSizeProperty_Value();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.ShorthandSizePropertyImpl <em>Shorthand Size Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.ShorthandSizePropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getShorthandSizeProperty()
     * @generated
     */
    EClass SHORTHAND_SIZE_PROPERTY = eINSTANCE.getShorthandSizeProperty();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHORTHAND_SIZE_PROPERTY__VALUES = eINSTANCE.getShorthandSizeProperty_Values();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.BorderRadiusPropertyImpl <em>Border Radius Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.BorderRadiusPropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getBorderRadiusProperty()
     * @generated
     */
    EClass BORDER_RADIUS_PROPERTY = eINSTANCE.getBorderRadiusProperty();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BORDER_RADIUS_PROPERTY__VALUES = eINSTANCE.getBorderRadiusProperty_Values();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.SizePropertyImpl <em>Size Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.SizePropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getSizeProperty()
     * @generated
     */
    EClass SIZE_PROPERTY = eINSTANCE.getSizeProperty();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIZE_PROPERTY__VALUE = eINSTANCE.getSizeProperty_Value();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.PaintPropertyImpl <em>Paint Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.PaintPropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getPaintProperty()
     * @generated
     */
    EClass PAINT_PROPERTY = eINSTANCE.getPaintProperty();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PAINT_PROPERTY__VALUE = eINSTANCE.getPaintProperty_Value();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.TransitionPropertyImpl <em>Transition Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.TransitionPropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getTransitionProperty()
     * @generated
     */
    EClass TRANSITION_PROPERTY = eINSTANCE.getTransitionProperty();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_PROPERTY__TRANSITIONS = eINSTANCE.getTransitionProperty_Transitions();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.TransitionValueImpl <em>Transition Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.TransitionValueImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getTransitionValue()
     * @generated
     */
    EClass TRANSITION_VALUE = eINSTANCE.getTransitionValue();

    /**
     * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION_VALUE__PROPERTY_NAME = eINSTANCE.getTransitionValue_PropertyName();

    /**
     * The meta object literal for the '<em><b>Duration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_VALUE__DURATION = eINSTANCE.getTransitionValue_Duration();

    /**
     * The meta object literal for the '<em><b>Timing Function</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION_VALUE__TIMING_FUNCTION = eINSTANCE.getTransitionValue_TimingFunction();

    /**
     * The meta object literal for the '<em><b>Delay</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_VALUE__DELAY = eINSTANCE.getTransitionValue_Delay();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.DrawablePropertyImpl <em>Drawable Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.DrawablePropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getDrawableProperty()
     * @generated
     */
    EClass DRAWABLE_PROPERTY = eINSTANCE.getDrawableProperty();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DRAWABLE_PROPERTY__VALUE = eINSTANCE.getDrawableProperty_Value();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.BackgroundRepeatPropertyImpl <em>Background Repeat Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.BackgroundRepeatPropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getBackgroundRepeatProperty()
     * @generated
     */
    EClass BACKGROUND_REPEAT_PROPERTY = eINSTANCE.getBackgroundRepeatProperty();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BACKGROUND_REPEAT_PROPERTY__VALUES = eINSTANCE.getBackgroundRepeatProperty_Values();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.BorderPropertyImpl <em>Border Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.BorderPropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getBorderProperty()
     * @generated
     */
    EClass BORDER_PROPERTY = eINSTANCE.getBorderProperty();

    /**
     * The meta object literal for the '<em><b>Width</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BORDER_PROPERTY__WIDTH = eINSTANCE.getBorderProperty_Width();

    /**
     * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BORDER_PROPERTY__STYLE = eINSTANCE.getBorderProperty_Style();

    /**
     * The meta object literal for the '<em><b>Color</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BORDER_PROPERTY__COLOR = eINSTANCE.getBorderProperty_Color();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.BackgroundFilterPropertyImpl <em>Background Filter Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.BackgroundFilterPropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getBackgroundFilterProperty()
     * @generated
     */
    EClass BACKGROUND_FILTER_PROPERTY = eINSTANCE.getBackgroundFilterProperty();

    /**
     * The meta object literal for the '<em><b>Color</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BACKGROUND_FILTER_PROPERTY__COLOR = eINSTANCE.getBackgroundFilterProperty_Color();

    /**
     * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BACKGROUND_FILTER_PROPERTY__FILTER = eINSTANCE.getBackgroundFilterProperty_Filter();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.BackgroundGravityPropertyImpl <em>Background Gravity Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.BackgroundGravityPropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getBackgroundGravityProperty()
     * @generated
     */
    EClass BACKGROUND_GRAVITY_PROPERTY = eINSTANCE.getBackgroundGravityProperty();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BACKGROUND_GRAVITY_PROPERTY__VALUES = eINSTANCE.getBackgroundGravityProperty_Values();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.BackgroundFilterTypePropertyImpl <em>Background Filter Type Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.BackgroundFilterTypePropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getBackgroundFilterTypeProperty()
     * @generated
     */
    EClass BACKGROUND_FILTER_TYPE_PROPERTY = eINSTANCE.getBackgroundFilterTypeProperty();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BACKGROUND_FILTER_TYPE_PROPERTY__VALUE = eINSTANCE.getBackgroundFilterTypeProperty_Value();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.ShorthandColorPropertyImpl <em>Shorthand Color Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.ShorthandColorPropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getShorthandColorProperty()
     * @generated
     */
    EClass SHORTHAND_COLOR_PROPERTY = eINSTANCE.getShorthandColorProperty();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHORTHAND_COLOR_PROPERTY__VALUES = eINSTANCE.getShorthandColorProperty_Values();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.ColorPropertyImpl <em>Color Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.ColorPropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getColorProperty()
     * @generated
     */
    EClass COLOR_PROPERTY = eINSTANCE.getColorProperty();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLOR_PROPERTY__VALUE = eINSTANCE.getColorProperty_Value();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.AlignmentPropertyImpl <em>Alignment Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.AlignmentPropertyImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getAlignmentProperty()
     * @generated
     */
    EClass ALIGNMENT_PROPERTY = eINSTANCE.getAlignmentProperty();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALIGNMENT_PROPERTY__VALUE = eINSTANCE.getAlignmentProperty_Value();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.TimeValueImpl <em>Time Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.TimeValueImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getTimeValue()
     * @generated
     */
    EClass TIME_VALUE = eINSTANCE.getTimeValue();

    /**
     * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_VALUE__TIME = eINSTANCE.getTimeValue_Time();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_VALUE__UNIT = eINSTANCE.getTimeValue_Unit();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.ViewSizeValueImpl <em>View Size Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.ViewSizeValueImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getViewSizeValue()
     * @generated
     */
    EClass VIEW_SIZE_VALUE = eINSTANCE.getViewSizeValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VIEW_SIZE_VALUE__VALUE = eINSTANCE.getViewSizeValue_Value();

    /**
     * The meta object literal for the '<em><b>Dynamic</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VIEW_SIZE_VALUE__DYNAMIC = eINSTANCE.getViewSizeValue_Dynamic();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.SizeValueImpl <em>Size Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.SizeValueImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getSizeValue()
     * @generated
     */
    EClass SIZE_VALUE = eINSTANCE.getSizeValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIZE_VALUE__VALUE = eINSTANCE.getSizeValue_Value();

    /**
     * The meta object literal for the '<em><b>Dimension</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIZE_VALUE__DIMENSION = eINSTANCE.getSizeValue_Dimension();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.PaintValueImpl <em>Paint Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.PaintValueImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getPaintValue()
     * @generated
     */
    EClass PAINT_VALUE = eINSTANCE.getPaintValue();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.LinearGradientImpl <em>Linear Gradient</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.LinearGradientImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getLinearGradient()
     * @generated
     */
    EClass LINEAR_GRADIENT = eINSTANCE.getLinearGradient();

    /**
     * The meta object literal for the '<em><b>X1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINEAR_GRADIENT__X1 = eINSTANCE.getLinearGradient_X1();

    /**
     * The meta object literal for the '<em><b>Y1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINEAR_GRADIENT__Y1 = eINSTANCE.getLinearGradient_Y1();

    /**
     * The meta object literal for the '<em><b>X2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINEAR_GRADIENT__X2 = eINSTANCE.getLinearGradient_X2();

    /**
     * The meta object literal for the '<em><b>Y2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINEAR_GRADIENT__Y2 = eINSTANCE.getLinearGradient_Y2();

    /**
     * The meta object literal for the '<em><b>Stops</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINEAR_GRADIENT__STOPS = eINSTANCE.getLinearGradient_Stops();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.RadialGradientImpl <em>Radial Gradient</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.RadialGradientImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getRadialGradient()
     * @generated
     */
    EClass RADIAL_GRADIENT = eINSTANCE.getRadialGradient();

    /**
     * The meta object literal for the '<em><b>Cx</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RADIAL_GRADIENT__CX = eINSTANCE.getRadialGradient_Cx();

    /**
     * The meta object literal for the '<em><b>Cy</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RADIAL_GRADIENT__CY = eINSTANCE.getRadialGradient_Cy();

    /**
     * The meta object literal for the '<em><b>Radius</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RADIAL_GRADIENT__RADIUS = eINSTANCE.getRadialGradient_Radius();

    /**
     * The meta object literal for the '<em><b>Fx</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RADIAL_GRADIENT__FX = eINSTANCE.getRadialGradient_Fx();

    /**
     * The meta object literal for the '<em><b>Fy</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RADIAL_GRADIENT__FY = eINSTANCE.getRadialGradient_Fy();

    /**
     * The meta object literal for the '<em><b>Stops</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RADIAL_GRADIENT__STOPS = eINSTANCE.getRadialGradient_Stops();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.StopValueImpl <em>Stop Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.StopValueImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getStopValue()
     * @generated
     */
    EClass STOP_VALUE = eINSTANCE.getStopValue();

    /**
     * The meta object literal for the '<em><b>Pos</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STOP_VALUE__POS = eINSTANCE.getStopValue_Pos();

    /**
     * The meta object literal for the '<em><b>Color</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STOP_VALUE__COLOR = eINSTANCE.getStopValue_Color();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.ColorValueImpl <em>Color Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.ColorValueImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getColorValue()
     * @generated
     */
    EClass COLOR_VALUE = eINSTANCE.getColorValue();

    /**
     * The meta object literal for the '<em><b>Named Color</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLOR_VALUE__NAMED_COLOR = eINSTANCE.getColorValue_NamedColor();

    /**
     * The meta object literal for the '<em><b>Rgb</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLOR_VALUE__RGB = eINSTANCE.getColorValue_Rgb();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.RGBColorImpl <em>RGB Color</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.RGBColorImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getRGBColor()
     * @generated
     */
    EClass RGB_COLOR = eINSTANCE.getRGBColor();

    /**
     * The meta object literal for the '<em><b>Hex</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RGB_COLOR__HEX = eINSTANCE.getRGBColor_Hex();

    /**
     * The meta object literal for the '<em><b>R</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RGB_COLOR__R = eINSTANCE.getRGBColor_R();

    /**
     * The meta object literal for the '<em><b>G</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RGB_COLOR__G = eINSTANCE.getRGBColor_G();

    /**
     * The meta object literal for the '<em><b>B</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RGB_COLOR__B = eINSTANCE.getRGBColor_B();

    /**
     * The meta object literal for the '<em><b>Alpha</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RGB_COLOR__ALPHA = eINSTANCE.getRGBColor_Alpha();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.HSBColorImpl <em>HSB Color</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.HSBColorImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getHSBColor()
     * @generated
     */
    EClass HSB_COLOR = eINSTANCE.getHSBColor();

    /**
     * The meta object literal for the '<em><b>Hue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HSB_COLOR__HUE = eINSTANCE.getHSBColor_Hue();

    /**
     * The meta object literal for the '<em><b>Saturation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HSB_COLOR__SATURATION = eINSTANCE.getHSBColor_Saturation();

    /**
     * The meta object literal for the '<em><b>Brightness</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HSB_COLOR__BRIGHTNESS = eINSTANCE.getHSBColor_Brightness();

    /**
     * The meta object literal for the '<em><b>Alpha</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HSB_COLOR__ALPHA = eINSTANCE.getHSBColor_Alpha();

    /**
     * The meta object literal for the '{@link io.lattekit.dsl.latteCSS.impl.ColorFunctionImpl <em>Color Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see io.lattekit.dsl.latteCSS.impl.ColorFunctionImpl
     * @see io.lattekit.dsl.latteCSS.impl.LatteCSSPackageImpl#getColorFunction()
     * @generated
     */
    EClass COLOR_FUNCTION = eINSTANCE.getColorFunction();

    /**
     * The meta object literal for the '<em><b>Orig</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLOR_FUNCTION__ORIG = eINSTANCE.getColorFunction_Orig();

    /**
     * The meta object literal for the '<em><b>Mod</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLOR_FUNCTION__MOD = eINSTANCE.getColorFunction_Mod();

    /**
     * The meta object literal for the '<em><b>Stop Numbers</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COLOR_FUNCTION__STOP_NUMBERS = eINSTANCE.getColorFunction_StopNumbers();

    /**
     * The meta object literal for the '<em><b>Stop Colors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLOR_FUNCTION__STOP_COLORS = eINSTANCE.getColorFunction_StopColors();

  }

} //LatteCSSPackage
