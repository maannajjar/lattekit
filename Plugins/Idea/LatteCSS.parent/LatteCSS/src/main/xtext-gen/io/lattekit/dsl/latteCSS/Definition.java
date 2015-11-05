/**
 */
package io.lattekit.dsl.latteCSS;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.Definition#getSelector <em>Selector</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.Definition#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getDefinition()
 * @model
 * @generated
 */
public interface Definition extends EObject
{
  /**
   * Returns the value of the '<em><b>Selector</b></em>' containment reference list.
   * The list contents are of type {@link io.lattekit.dsl.latteCSS.Selector}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Selector</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Selector</em>' containment reference list.
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getDefinition_Selector()
   * @model containment="true"
   * @generated
   */
  EList<Selector> getSelector();

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link io.lattekit.dsl.latteCSS.CSSProperty}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getDefinition_Properties()
   * @model containment="true"
   * @generated
   */
  EList<CSSProperty> getProperties();

} // Definition
