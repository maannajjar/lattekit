/**
 */
package io.lattekit.dsl.latteCSS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.TransitionProperty#getTransitions <em>Transitions</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getTransitionProperty()
 * @model
 * @generated
 */
public interface TransitionProperty extends CSSProperty
{
  /**
   * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
   * The list contents are of type {@link io.lattekit.dsl.latteCSS.TransitionValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transitions</em>' containment reference list.
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getTransitionProperty_Transitions()
   * @model containment="true"
   * @generated
   */
  EList<TransitionValue> getTransitions();

} // TransitionProperty
