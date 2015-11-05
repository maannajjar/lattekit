/**
 */
package io.lattekit.dsl.latteCSS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Border Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.BorderProperty#getWidth <em>Width</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.BorderProperty#getStyle <em>Style</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.BorderProperty#getColor <em>Color</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getBorderProperty()
 * @model
 * @generated
 */
public interface BorderProperty extends CSSProperty
{
  /**
   * Returns the value of the '<em><b>Width</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Width</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Width</em>' containment reference.
   * @see #setWidth(SizeValue)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getBorderProperty_Width()
   * @model containment="true"
   * @generated
   */
  SizeValue getWidth();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.BorderProperty#getWidth <em>Width</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Width</em>' containment reference.
   * @see #getWidth()
   * @generated
   */
  void setWidth(SizeValue value);

  /**
   * Returns the value of the '<em><b>Style</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Style</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Style</em>' attribute.
   * @see #setStyle(String)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getBorderProperty_Style()
   * @model
   * @generated
   */
  String getStyle();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.BorderProperty#getStyle <em>Style</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Style</em>' attribute.
   * @see #getStyle()
   * @generated
   */
  void setStyle(String value);

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
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getBorderProperty_Color()
   * @model containment="true"
   * @generated
   */
  ColorValue getColor();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.BorderProperty#getColor <em>Color</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Color</em>' containment reference.
   * @see #getColor()
   * @generated
   */
  void setColor(ColorValue value);

} // BorderProperty
