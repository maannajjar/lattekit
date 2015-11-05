/**
 */
package io.lattekit.dsl.latteCSS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shorthand Color Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.ShorthandColorProperty#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getShorthandColorProperty()
 * @model
 * @generated
 */
public interface ShorthandColorProperty extends CSSProperty
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link io.lattekit.dsl.latteCSS.ColorValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getShorthandColorProperty_Values()
   * @model containment="true"
   * @generated
   */
  EList<ColorValue> getValues();

} // ShorthandColorProperty
