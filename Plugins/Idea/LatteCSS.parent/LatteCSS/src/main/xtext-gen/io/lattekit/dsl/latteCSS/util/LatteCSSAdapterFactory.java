/**
 */
package io.lattekit.dsl.latteCSS.util;

import io.lattekit.dsl.latteCSS.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage
 * @generated
 */
public class LatteCSSAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static LatteCSSPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LatteCSSAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = LatteCSSPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LatteCSSSwitch<Adapter> modelSwitch =
    new LatteCSSSwitch<Adapter>()
    {
      @Override
      public Adapter caseCSS(CSS object)
      {
        return createCSSAdapter();
      }
      @Override
      public Adapter caseDefinition(Definition object)
      {
        return createDefinitionAdapter();
      }
      @Override
      public Adapter caseSelector(Selector object)
      {
        return createSelectorAdapter();
      }
      @Override
      public Adapter caseSimpleSelector(SimpleSelector object)
      {
        return createSimpleSelectorAdapter();
      }
      @Override
      public Adapter caseIdSelector(IdSelector object)
      {
        return createIdSelectorAdapter();
      }
      @Override
      public Adapter caseClassSelector(ClassSelector object)
      {
        return createClassSelectorAdapter();
      }
      @Override
      public Adapter casePseudoClassSelector(PseudoClassSelector object)
      {
        return createPseudoClassSelectorAdapter();
      }
      @Override
      public Adapter caseCSSProperty(CSSProperty object)
      {
        return createCSSPropertyAdapter();
      }
      @Override
      public Adapter caseFontFamilyProperty(FontFamilyProperty object)
      {
        return createFontFamilyPropertyAdapter();
      }
      @Override
      public Adapter caseFontStyleProperty(FontStyleProperty object)
      {
        return createFontStylePropertyAdapter();
      }
      @Override
      public Adapter caseViewSizeProperty(ViewSizeProperty object)
      {
        return createViewSizePropertyAdapter();
      }
      @Override
      public Adapter caseShorthandSizeProperty(ShorthandSizeProperty object)
      {
        return createShorthandSizePropertyAdapter();
      }
      @Override
      public Adapter caseBorderRadiusProperty(BorderRadiusProperty object)
      {
        return createBorderRadiusPropertyAdapter();
      }
      @Override
      public Adapter caseSizeProperty(SizeProperty object)
      {
        return createSizePropertyAdapter();
      }
      @Override
      public Adapter casePaintProperty(PaintProperty object)
      {
        return createPaintPropertyAdapter();
      }
      @Override
      public Adapter caseTransitionProperty(TransitionProperty object)
      {
        return createTransitionPropertyAdapter();
      }
      @Override
      public Adapter caseTransitionValue(TransitionValue object)
      {
        return createTransitionValueAdapter();
      }
      @Override
      public Adapter caseDrawableProperty(DrawableProperty object)
      {
        return createDrawablePropertyAdapter();
      }
      @Override
      public Adapter caseBackgroundRepeatProperty(BackgroundRepeatProperty object)
      {
        return createBackgroundRepeatPropertyAdapter();
      }
      @Override
      public Adapter caseBorderProperty(BorderProperty object)
      {
        return createBorderPropertyAdapter();
      }
      @Override
      public Adapter caseBackgroundFilterProperty(BackgroundFilterProperty object)
      {
        return createBackgroundFilterPropertyAdapter();
      }
      @Override
      public Adapter caseBackgroundGravityProperty(BackgroundGravityProperty object)
      {
        return createBackgroundGravityPropertyAdapter();
      }
      @Override
      public Adapter caseBackgroundFilterTypeProperty(BackgroundFilterTypeProperty object)
      {
        return createBackgroundFilterTypePropertyAdapter();
      }
      @Override
      public Adapter caseShorthandColorProperty(ShorthandColorProperty object)
      {
        return createShorthandColorPropertyAdapter();
      }
      @Override
      public Adapter caseColorProperty(ColorProperty object)
      {
        return createColorPropertyAdapter();
      }
      @Override
      public Adapter caseAlignmentProperty(AlignmentProperty object)
      {
        return createAlignmentPropertyAdapter();
      }
      @Override
      public Adapter caseTimeValue(TimeValue object)
      {
        return createTimeValueAdapter();
      }
      @Override
      public Adapter caseViewSizeValue(ViewSizeValue object)
      {
        return createViewSizeValueAdapter();
      }
      @Override
      public Adapter caseSizeValue(SizeValue object)
      {
        return createSizeValueAdapter();
      }
      @Override
      public Adapter casePaintValue(PaintValue object)
      {
        return createPaintValueAdapter();
      }
      @Override
      public Adapter caseLinearGradient(LinearGradient object)
      {
        return createLinearGradientAdapter();
      }
      @Override
      public Adapter caseRadialGradient(RadialGradient object)
      {
        return createRadialGradientAdapter();
      }
      @Override
      public Adapter caseStopValue(StopValue object)
      {
        return createStopValueAdapter();
      }
      @Override
      public Adapter caseColorValue(ColorValue object)
      {
        return createColorValueAdapter();
      }
      @Override
      public Adapter caseRGBColor(RGBColor object)
      {
        return createRGBColorAdapter();
      }
      @Override
      public Adapter caseHSBColor(HSBColor object)
      {
        return createHSBColorAdapter();
      }
      @Override
      public Adapter caseColorFunction(ColorFunction object)
      {
        return createColorFunctionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.CSS <em>CSS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.CSS
   * @generated
   */
  public Adapter createCSSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.Definition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.Definition
   * @generated
   */
  public Adapter createDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.Selector <em>Selector</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.Selector
   * @generated
   */
  public Adapter createSelectorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.SimpleSelector <em>Simple Selector</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.SimpleSelector
   * @generated
   */
  public Adapter createSimpleSelectorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.IdSelector <em>Id Selector</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.IdSelector
   * @generated
   */
  public Adapter createIdSelectorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.ClassSelector <em>Class Selector</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.ClassSelector
   * @generated
   */
  public Adapter createClassSelectorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.PseudoClassSelector <em>Pseudo Class Selector</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.PseudoClassSelector
   * @generated
   */
  public Adapter createPseudoClassSelectorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.CSSProperty <em>CSS Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.CSSProperty
   * @generated
   */
  public Adapter createCSSPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.FontFamilyProperty <em>Font Family Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.FontFamilyProperty
   * @generated
   */
  public Adapter createFontFamilyPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.FontStyleProperty <em>Font Style Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.FontStyleProperty
   * @generated
   */
  public Adapter createFontStylePropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.ViewSizeProperty <em>View Size Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.ViewSizeProperty
   * @generated
   */
  public Adapter createViewSizePropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.ShorthandSizeProperty <em>Shorthand Size Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.ShorthandSizeProperty
   * @generated
   */
  public Adapter createShorthandSizePropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.BorderRadiusProperty <em>Border Radius Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.BorderRadiusProperty
   * @generated
   */
  public Adapter createBorderRadiusPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.SizeProperty <em>Size Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.SizeProperty
   * @generated
   */
  public Adapter createSizePropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.PaintProperty <em>Paint Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.PaintProperty
   * @generated
   */
  public Adapter createPaintPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.TransitionProperty <em>Transition Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.TransitionProperty
   * @generated
   */
  public Adapter createTransitionPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.TransitionValue <em>Transition Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.TransitionValue
   * @generated
   */
  public Adapter createTransitionValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.DrawableProperty <em>Drawable Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.DrawableProperty
   * @generated
   */
  public Adapter createDrawablePropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.BackgroundRepeatProperty <em>Background Repeat Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.BackgroundRepeatProperty
   * @generated
   */
  public Adapter createBackgroundRepeatPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.BorderProperty <em>Border Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.BorderProperty
   * @generated
   */
  public Adapter createBorderPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.BackgroundFilterProperty <em>Background Filter Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.BackgroundFilterProperty
   * @generated
   */
  public Adapter createBackgroundFilterPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.BackgroundGravityProperty <em>Background Gravity Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.BackgroundGravityProperty
   * @generated
   */
  public Adapter createBackgroundGravityPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.BackgroundFilterTypeProperty <em>Background Filter Type Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.BackgroundFilterTypeProperty
   * @generated
   */
  public Adapter createBackgroundFilterTypePropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.ShorthandColorProperty <em>Shorthand Color Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.ShorthandColorProperty
   * @generated
   */
  public Adapter createShorthandColorPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.ColorProperty <em>Color Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.ColorProperty
   * @generated
   */
  public Adapter createColorPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.AlignmentProperty <em>Alignment Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.AlignmentProperty
   * @generated
   */
  public Adapter createAlignmentPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.TimeValue <em>Time Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.TimeValue
   * @generated
   */
  public Adapter createTimeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.ViewSizeValue <em>View Size Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.ViewSizeValue
   * @generated
   */
  public Adapter createViewSizeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.SizeValue <em>Size Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.SizeValue
   * @generated
   */
  public Adapter createSizeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.PaintValue <em>Paint Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.PaintValue
   * @generated
   */
  public Adapter createPaintValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.LinearGradient <em>Linear Gradient</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.LinearGradient
   * @generated
   */
  public Adapter createLinearGradientAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.RadialGradient <em>Radial Gradient</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.RadialGradient
   * @generated
   */
  public Adapter createRadialGradientAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.StopValue <em>Stop Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.StopValue
   * @generated
   */
  public Adapter createStopValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.ColorValue <em>Color Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.ColorValue
   * @generated
   */
  public Adapter createColorValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.RGBColor <em>RGB Color</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.RGBColor
   * @generated
   */
  public Adapter createRGBColorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.HSBColor <em>HSB Color</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.HSBColor
   * @generated
   */
  public Adapter createHSBColorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link io.lattekit.dsl.latteCSS.ColorFunction <em>Color Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see io.lattekit.dsl.latteCSS.ColorFunction
   * @generated
   */
  public Adapter createColorFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //LatteCSSAdapterFactory
