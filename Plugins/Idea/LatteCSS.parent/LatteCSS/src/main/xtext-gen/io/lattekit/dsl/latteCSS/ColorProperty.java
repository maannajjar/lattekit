/**
 */
package io.lattekit.dsl.latteCSS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Color Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.ColorProperty#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getColorProperty()
 * @model
 * @generated
 */
public interface ColorProperty extends CSSProperty
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(ColorValue)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getColorProperty_Value()
   * @model containment="true"
   * @generated
   */
  ColorValue getValue();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.ColorProperty#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ColorValue value);

} // ColorProperty
