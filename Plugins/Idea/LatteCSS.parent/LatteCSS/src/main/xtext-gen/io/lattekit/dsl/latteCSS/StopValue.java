/**
 */
package io.lattekit.dsl.latteCSS;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stop Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.StopValue#getPos <em>Pos</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.StopValue#getColor <em>Color</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getStopValue()
 * @model
 * @generated
 */
public interface StopValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Pos</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pos</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pos</em>' containment reference.
   * @see #setPos(SizeValue)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getStopValue_Pos()
   * @model containment="true"
   * @generated
   */
  SizeValue getPos();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.StopValue#getPos <em>Pos</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pos</em>' containment reference.
   * @see #getPos()
   * @generated
   */
  void setPos(SizeValue value);

  /**
   * Returns the value of the '<em><b>Color</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Color</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Color</em>' containment reference.
   * @see #setColor(ColorValue)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getStopValue_Color()
   * @model containment="true"
   * @generated
   */
  ColorValue getColor();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.StopValue#getColor <em>Color</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Color</em>' containment reference.
   * @see #getColor()
   * @generated
   */
  void setColor(ColorValue value);

} // StopValue
