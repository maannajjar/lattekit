/**
 */
package io.lattekit.dsl.latteCSS;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.Selector#getSimpleSelector <em>Simple Selector</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getSelector()
 * @model
 * @generated
 */
public interface Selector extends EObject
{
  /**
   * Returns the value of the '<em><b>Simple Selector</b></em>' containment reference list.
   * The list contents are of type {@link io.lattekit.dsl.latteCSS.SimpleSelector}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Simple Selector</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Simple Selector</em>' containment reference list.
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getSelector_SimpleSelector()
   * @model containment="true"
   * @generated
   */
  EList<SimpleSelector> getSimpleSelector();

} // Selector
