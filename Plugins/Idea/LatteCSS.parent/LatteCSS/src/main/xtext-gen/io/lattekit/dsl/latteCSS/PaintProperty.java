/**
 */
package io.lattekit.dsl.latteCSS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Paint Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.PaintProperty#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getPaintProperty()
 * @model
 * @generated
 */
public interface PaintProperty extends CSSProperty
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
   * @see #setValue(PaintValue)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getPaintProperty_Value()
   * @model containment="true"
   * @generated
   */
  PaintValue getValue();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.PaintProperty#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(PaintValue value);

} // PaintProperty
