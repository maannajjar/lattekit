/**
 */
package io.lattekit.dsl.latteCSS;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Size Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.ViewSizeValue#getValue <em>Value</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.ViewSizeValue#getDynamic <em>Dynamic</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getViewSizeValue()
 * @model
 * @generated
 */
public interface ViewSizeValue extends EObject
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
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getViewSizeValue_Value()
   * @model containment="true"
   * @generated
   */
  SizeValue getValue();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.ViewSizeValue#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(SizeValue value);

  /**
   * Returns the value of the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dynamic</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dynamic</em>' attribute.
   * @see #setDynamic(String)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getViewSizeValue_Dynamic()
   * @model
   * @generated
   */
  String getDynamic();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.ViewSizeValue#getDynamic <em>Dynamic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dynamic</em>' attribute.
   * @see #getDynamic()
   * @generated
   */
  void setDynamic(String value);

} // ViewSizeValue
