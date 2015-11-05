/**
 */
package io.lattekit.dsl.latteCSS;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.SimpleSelector#getElement <em>Element</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.SimpleSelector#getId <em>Id</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.SimpleSelector#getPseudoClass <em>Pseudo Class</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.SimpleSelector#getClass_ <em>Class</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getSimpleSelector()
 * @model
 * @generated
 */
public interface SimpleSelector extends EObject
{
  /**
   * Returns the value of the '<em><b>Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' attribute.
   * @see #setElement(String)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getSimpleSelector_Element()
   * @model
   * @generated
   */
  String getElement();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.SimpleSelector#getElement <em>Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' attribute.
   * @see #getElement()
   * @generated
   */
  void setElement(String value);

  /**
   * Returns the value of the '<em><b>Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' containment reference.
   * @see #setId(IdSelector)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getSimpleSelector_Id()
   * @model containment="true"
   * @generated
   */
  IdSelector getId();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.SimpleSelector#getId <em>Id</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' containment reference.
   * @see #getId()
   * @generated
   */
  void setId(IdSelector value);

  /**
   * Returns the value of the '<em><b>Pseudo Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pseudo Class</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pseudo Class</em>' containment reference.
   * @see #setPseudoClass(PseudoClassSelector)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getSimpleSelector_PseudoClass()
   * @model containment="true"
   * @generated
   */
  PseudoClassSelector getPseudoClass();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.SimpleSelector#getPseudoClass <em>Pseudo Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pseudo Class</em>' containment reference.
   * @see #getPseudoClass()
   * @generated
   */
  void setPseudoClass(PseudoClassSelector value);

  /**
   * Returns the value of the '<em><b>Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class</em>' containment reference.
   * @see #setClass(ClassSelector)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getSimpleSelector_Class()
   * @model containment="true"
   * @generated
   */
  ClassSelector getClass_();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.SimpleSelector#getClass_ <em>Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class</em>' containment reference.
   * @see #getClass_()
   * @generated
   */
  void setClass(ClassSelector value);

} // SimpleSelector
