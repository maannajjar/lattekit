/**
 */
package io.lattekit.dsl.latteCSS.util;

import io.lattekit.dsl.latteCSS.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage
 * @generated
 */
public class LatteCSSSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static LatteCSSPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LatteCSSSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = LatteCSSPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case LatteCSSPackage.CSS:
      {
        CSS css = (CSS)theEObject;
        T result = caseCSS(css);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.DEFINITION:
      {
        Definition definition = (Definition)theEObject;
        T result = caseDefinition(definition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.SELECTOR:
      {
        Selector selector = (Selector)theEObject;
        T result = caseSelector(selector);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.SIMPLE_SELECTOR:
      {
        SimpleSelector simpleSelector = (SimpleSelector)theEObject;
        T result = caseSimpleSelector(simpleSelector);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.ID_SELECTOR:
      {
        IdSelector idSelector = (IdSelector)theEObject;
        T result = caseIdSelector(idSelector);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.CLASS_SELECTOR:
      {
        ClassSelector classSelector = (ClassSelector)theEObject;
        T result = caseClassSelector(classSelector);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.PSEUDO_CLASS_SELECTOR:
      {
        PseudoClassSelector pseudoClassSelector = (PseudoClassSelector)theEObject;
        T result = casePseudoClassSelector(pseudoClassSelector);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.CSS_PROPERTY:
      {
        CSSProperty cssProperty = (CSSProperty)theEObject;
        T result = caseCSSProperty(cssProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.FONT_FAMILY_PROPERTY:
      {
        FontFamilyProperty fontFamilyProperty = (FontFamilyProperty)theEObject;
        T result = caseFontFamilyProperty(fontFamilyProperty);
        if (result == null) result = caseCSSProperty(fontFamilyProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.FONT_STYLE_PROPERTY:
      {
        FontStyleProperty fontStyleProperty = (FontStyleProperty)theEObject;
        T result = caseFontStyleProperty(fontStyleProperty);
        if (result == null) result = caseCSSProperty(fontStyleProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.VIEW_SIZE_PROPERTY:
      {
        ViewSizeProperty viewSizeProperty = (ViewSizeProperty)theEObject;
        T result = caseViewSizeProperty(viewSizeProperty);
        if (result == null) result = caseCSSProperty(viewSizeProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.SHORTHAND_SIZE_PROPERTY:
      {
        ShorthandSizeProperty shorthandSizeProperty = (ShorthandSizeProperty)theEObject;
        T result = caseShorthandSizeProperty(shorthandSizeProperty);
        if (result == null) result = caseCSSProperty(shorthandSizeProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.BORDER_RADIUS_PROPERTY:
      {
        BorderRadiusProperty borderRadiusProperty = (BorderRadiusProperty)theEObject;
        T result = caseBorderRadiusProperty(borderRadiusProperty);
        if (result == null) result = caseCSSProperty(borderRadiusProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.SIZE_PROPERTY:
      {
        SizeProperty sizeProperty = (SizeProperty)theEObject;
        T result = caseSizeProperty(sizeProperty);
        if (result == null) result = caseCSSProperty(sizeProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.PAINT_PROPERTY:
      {
        PaintProperty paintProperty = (PaintProperty)theEObject;
        T result = casePaintProperty(paintProperty);
        if (result == null) result = caseCSSProperty(paintProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.TRANSITION_PROPERTY:
      {
        TransitionProperty transitionProperty = (TransitionProperty)theEObject;
        T result = caseTransitionProperty(transitionProperty);
        if (result == null) result = caseCSSProperty(transitionProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.TRANSITION_VALUE:
      {
        TransitionValue transitionValue = (TransitionValue)theEObject;
        T result = caseTransitionValue(transitionValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.DRAWABLE_PROPERTY:
      {
        DrawableProperty drawableProperty = (DrawableProperty)theEObject;
        T result = caseDrawableProperty(drawableProperty);
        if (result == null) result = caseCSSProperty(drawableProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.BACKGROUND_REPEAT_PROPERTY:
      {
        BackgroundRepeatProperty backgroundRepeatProperty = (BackgroundRepeatProperty)theEObject;
        T result = caseBackgroundRepeatProperty(backgroundRepeatProperty);
        if (result == null) result = caseCSSProperty(backgroundRepeatProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.BORDER_PROPERTY:
      {
        BorderProperty borderProperty = (BorderProperty)theEObject;
        T result = caseBorderProperty(borderProperty);
        if (result == null) result = caseCSSProperty(borderProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.BACKGROUND_FILTER_PROPERTY:
      {
        BackgroundFilterProperty backgroundFilterProperty = (BackgroundFilterProperty)theEObject;
        T result = caseBackgroundFilterProperty(backgroundFilterProperty);
        if (result == null) result = caseCSSProperty(backgroundFilterProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.BACKGROUND_GRAVITY_PROPERTY:
      {
        BackgroundGravityProperty backgroundGravityProperty = (BackgroundGravityProperty)theEObject;
        T result = caseBackgroundGravityProperty(backgroundGravityProperty);
        if (result == null) result = caseCSSProperty(backgroundGravityProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.BACKGROUND_FILTER_TYPE_PROPERTY:
      {
        BackgroundFilterTypeProperty backgroundFilterTypeProperty = (BackgroundFilterTypeProperty)theEObject;
        T result = caseBackgroundFilterTypeProperty(backgroundFilterTypeProperty);
        if (result == null) result = caseCSSProperty(backgroundFilterTypeProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.SHORTHAND_COLOR_PROPERTY:
      {
        ShorthandColorProperty shorthandColorProperty = (ShorthandColorProperty)theEObject;
        T result = caseShorthandColorProperty(shorthandColorProperty);
        if (result == null) result = caseCSSProperty(shorthandColorProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.COLOR_PROPERTY:
      {
        ColorProperty colorProperty = (ColorProperty)theEObject;
        T result = caseColorProperty(colorProperty);
        if (result == null) result = caseCSSProperty(colorProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.ALIGNMENT_PROPERTY:
      {
        AlignmentProperty alignmentProperty = (AlignmentProperty)theEObject;
        T result = caseAlignmentProperty(alignmentProperty);
        if (result == null) result = caseCSSProperty(alignmentProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.TIME_VALUE:
      {
        TimeValue timeValue = (TimeValue)theEObject;
        T result = caseTimeValue(timeValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.VIEW_SIZE_VALUE:
      {
        ViewSizeValue viewSizeValue = (ViewSizeValue)theEObject;
        T result = caseViewSizeValue(viewSizeValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.SIZE_VALUE:
      {
        SizeValue sizeValue = (SizeValue)theEObject;
        T result = caseSizeValue(sizeValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.PAINT_VALUE:
      {
        PaintValue paintValue = (PaintValue)theEObject;
        T result = casePaintValue(paintValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.LINEAR_GRADIENT:
      {
        LinearGradient linearGradient = (LinearGradient)theEObject;
        T result = caseLinearGradient(linearGradient);
        if (result == null) result = casePaintValue(linearGradient);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.RADIAL_GRADIENT:
      {
        RadialGradient radialGradient = (RadialGradient)theEObject;
        T result = caseRadialGradient(radialGradient);
        if (result == null) result = casePaintValue(radialGradient);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.STOP_VALUE:
      {
        StopValue stopValue = (StopValue)theEObject;
        T result = caseStopValue(stopValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.COLOR_VALUE:
      {
        ColorValue colorValue = (ColorValue)theEObject;
        T result = caseColorValue(colorValue);
        if (result == null) result = casePaintValue(colorValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.RGB_COLOR:
      {
        RGBColor rgbColor = (RGBColor)theEObject;
        T result = caseRGBColor(rgbColor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.HSB_COLOR:
      {
        HSBColor hsbColor = (HSBColor)theEObject;
        T result = caseHSBColor(hsbColor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LatteCSSPackage.COLOR_FUNCTION:
      {
        ColorFunction colorFunction = (ColorFunction)theEObject;
        T result = caseColorFunction(colorFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CSS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CSS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCSS(CSS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefinition(Definition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Selector</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Selector</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelector(Selector object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Selector</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Selector</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleSelector(SimpleSelector object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Id Selector</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Id Selector</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIdSelector(IdSelector object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Selector</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Selector</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassSelector(ClassSelector object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pseudo Class Selector</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pseudo Class Selector</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePseudoClassSelector(PseudoClassSelector object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CSS Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CSS Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCSSProperty(CSSProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Font Family Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Font Family Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFontFamilyProperty(FontFamilyProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Font Style Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Font Style Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFontStyleProperty(FontStyleProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>View Size Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>View Size Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseViewSizeProperty(ViewSizeProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Shorthand Size Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Shorthand Size Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseShorthandSizeProperty(ShorthandSizeProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Border Radius Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Border Radius Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBorderRadiusProperty(BorderRadiusProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Size Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Size Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSizeProperty(SizeProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Paint Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Paint Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePaintProperty(PaintProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transition Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransitionProperty(TransitionProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transition Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransitionValue(TransitionValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Drawable Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Drawable Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDrawableProperty(DrawableProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Background Repeat Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Background Repeat Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBackgroundRepeatProperty(BackgroundRepeatProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Border Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Border Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBorderProperty(BorderProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Background Filter Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Background Filter Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBackgroundFilterProperty(BackgroundFilterProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Background Gravity Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Background Gravity Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBackgroundGravityProperty(BackgroundGravityProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Background Filter Type Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Background Filter Type Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBackgroundFilterTypeProperty(BackgroundFilterTypeProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Shorthand Color Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Shorthand Color Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseShorthandColorProperty(ShorthandColorProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Color Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Color Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseColorProperty(ColorProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alignment Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alignment Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlignmentProperty(AlignmentProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Time Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Time Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTimeValue(TimeValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>View Size Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>View Size Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseViewSizeValue(ViewSizeValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Size Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Size Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSizeValue(SizeValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Paint Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Paint Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePaintValue(PaintValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Linear Gradient</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Linear Gradient</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLinearGradient(LinearGradient object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Radial Gradient</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Radial Gradient</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRadialGradient(RadialGradient object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stop Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stop Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStopValue(StopValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Color Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Color Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseColorValue(ColorValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>RGB Color</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RGB Color</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRGBColor(RGBColor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>HSB Color</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>HSB Color</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHSBColor(HSBColor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Color Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Color Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseColorFunction(ColorFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //LatteCSSSwitch
