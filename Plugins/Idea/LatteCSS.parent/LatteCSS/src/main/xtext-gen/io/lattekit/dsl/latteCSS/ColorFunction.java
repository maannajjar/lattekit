/**
 */
package io.lattekit.dsl.latteCSS;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Color Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.ColorFunction#getOrig <em>Orig</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.ColorFunction#getMod <em>Mod</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.ColorFunction#getStopNumbers <em>Stop Numbers</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.ColorFunction#getStopColors <em>Stop Colors</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getColorFunction()
 * @model
 * @generated
 */
public interface ColorFunction extends EObject
{
  /**
   * Returns the value of the '<em><b>Orig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Orig</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Orig</em>' containment reference.
   * @see #setOrig(ColorValue)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getColorFunction_Orig()
   * @model containment="true"
   * @generated
   */
  ColorValue getOrig();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.ColorFunction#getOrig <em>Orig</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Orig</em>' containment reference.
   * @see #getOrig()
   * @generated
   */
  void setOrig(ColorValue value);

  /**
   * Returns the value of the '<em><b>Mod</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mod</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mod</em>' attribute.
   * @see #setMod(String)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getColorFunction_Mod()
   * @model
   * @generated
   */
  String getMod();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.ColorFunction#getMod <em>Mod</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mod</em>' attribute.
   * @see #getMod()
   * @generated
   */
  void setMod(String value);

  /**
   * Returns the value of the '<em><b>Stop Numbers</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stop Numbers</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stop Numbers</em>' attribute list.
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getColorFunction_StopNumbers()
   * @model unique="false"
   * @generated
   */
  EList<String> getStopNumbers();

  /**
   * Returns the value of the '<em><b>Stop Colors</b></em>' containment reference list.
   * The list contents are of type {@link io.lattekit.dsl.latteCSS.ColorValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stop Colors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stop Colors</em>' containment reference list.
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getColorFunction_StopColors()
   * @model containment="true"
   * @generated
   */
  EList<ColorValue> getStopColors();

} // ColorFunction
