/**
 */
package io.lattekit.dsl.latteCSS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Size Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.SizeProperty#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getSizeProperty()
 * @model
 * @generated
 */
public interface SizeProperty extends CSSProperty
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
   * @see #setValue(SizeValue)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getSizeProperty_Value()
   * @model containment="true"
   * @generated
   */
  SizeValue getValue();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.SizeProperty#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(SizeValue value);

} // SizeProperty
