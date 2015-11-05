/**
 */
package io.lattekit.dsl.latteCSS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Radial Gradient</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.RadialGradient#getCx <em>Cx</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.RadialGradient#getCy <em>Cy</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.RadialGradient#getRadius <em>Radius</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.RadialGradient#getFx <em>Fx</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.RadialGradient#getFy <em>Fy</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.RadialGradient#getStops <em>Stops</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getRadialGradient()
 * @model
 * @generated
 */
public interface RadialGradient extends PaintValue
{
  /**
   * Returns the value of the '<em><b>Cx</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cx</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cx</em>' containment reference.
   * @see #setCx(SizeValue)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getRadialGradient_Cx()
   * @model containment="true"
   * @generated
   */
  SizeValue getCx();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.RadialGradient#getCx <em>Cx</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cx</em>' containment reference.
   * @see #getCx()
   * @generated
   */
  void setCx(SizeValue value);

  /**
   * Returns the value of the '<em><b>Cy</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cy</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cy</em>' containment reference.
   * @see #setCy(SizeValue)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getRadialGradient_Cy()
   * @model containment="true"
   * @generated
   */
  SizeValue getCy();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.RadialGradient#getCy <em>Cy</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cy</em>' containment reference.
   * @see #getCy()
   * @generated
   */
  void setCy(SizeValue value);

  /**
   * Returns the value of the '<em><b>Radius</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Radius</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Radius</em>' containment reference.
   * @see #setRadius(SizeValue)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getRadialGradient_Radius()
   * @model containment="true"
   * @generated
   */
  SizeValue getRadius();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.RadialGradient#getRadius <em>Radius</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Radius</em>' containment reference.
   * @see #getRadius()
   * @generated
   */
  void setRadius(SizeValue value);

  /**
   * Returns the value of the '<em><b>Fx</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fx</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fx</em>' containment reference.
   * @see #setFx(SizeValue)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getRadialGradient_Fx()
   * @model containment="true"
   * @generated
   */
  SizeValue getFx();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.RadialGradient#getFx <em>Fx</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fx</em>' containment reference.
   * @see #getFx()
   * @generated
   */
  void setFx(SizeValue value);

  /**
   * Returns the value of the '<em><b>Fy</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fy</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fy</em>' containment reference.
   * @see #setFy(SizeValue)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getRadialGradient_Fy()
   * @model containment="true"
   * @generated
   */
  SizeValue getFy();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.RadialGradient#getFy <em>Fy</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fy</em>' containment reference.
   * @see #getFy()
   * @generated
   */
  void setFy(SizeValue value);

  /**
   * Returns the value of the '<em><b>Stops</b></em>' containment reference list.
   * The list contents are of type {@link io.lattekit.dsl.latteCSS.StopValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stops</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stops</em>' containment reference list.
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getRadialGradient_Stops()
   * @model containment="true"
   * @generated
   */
  EList<StopValue> getStops();

} // RadialGradient
