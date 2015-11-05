/**
 */
package io.lattekit.dsl.latteCSS;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.TransitionValue#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.TransitionValue#getDuration <em>Duration</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.TransitionValue#getTimingFunction <em>Timing Function</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.TransitionValue#getDelay <em>Delay</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getTransitionValue()
 * @model
 * @generated
 */
public interface TransitionValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Property Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Name</em>' attribute.
   * @see #setPropertyName(String)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getTransitionValue_PropertyName()
   * @model
   * @generated
   */
  String getPropertyName();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.TransitionValue#getPropertyName <em>Property Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property Name</em>' attribute.
   * @see #getPropertyName()
   * @generated
   */
  void setPropertyName(String value);

  /**
   * Returns the value of the '<em><b>Duration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Duration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Duration</em>' containment reference.
   * @see #setDuration(TimeValue)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getTransitionValue_Duration()
   * @model containment="true"
   * @generated
   */
  TimeValue getDuration();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.TransitionValue#getDuration <em>Duration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Duration</em>' containment reference.
   * @see #getDuration()
   * @generated
   */
  void setDuration(TimeValue value);

  /**
   * Returns the value of the '<em><b>Timing Function</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timing Function</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timing Function</em>' attribute.
   * @see #setTimingFunction(String)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getTransitionValue_TimingFunction()
   * @model
   * @generated
   */
  String getTimingFunction();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.TransitionValue#getTimingFunction <em>Timing Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timing Function</em>' attribute.
   * @see #getTimingFunction()
   * @generated
   */
  void setTimingFunction(String value);

  /**
   * Returns the value of the '<em><b>Delay</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Delay</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Delay</em>' containment reference.
   * @see #setDelay(TimeValue)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getTransitionValue_Delay()
   * @model containment="true"
   * @generated
   */
  TimeValue getDelay();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.TransitionValue#getDelay <em>Delay</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Delay</em>' containment reference.
   * @see #getDelay()
   * @generated
   */
  void setDelay(TimeValue value);

} // TransitionValue
