/**
 */
package io.lattekit.dsl.latteCSS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Color Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.ColorValue#getNamedColor <em>Named Color</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.ColorValue#getRgb <em>Rgb</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getColorValue()
 * @model
 * @generated
 */
public interface ColorValue extends PaintValue
{
  /**
   * Returns the value of the '<em><b>Named Color</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Named Color</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Named Color</em>' attribute.
   * @see #setNamedColor(String)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getColorValue_NamedColor()
   * @model
   * @generated
   */
  String getNamedColor();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.ColorValue#getNamedColor <em>Named Color</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Named Color</em>' attribute.
   * @see #getNamedColor()
   * @generated
   */
  void setNamedColor(String value);

  /**
   * Returns the value of the '<em><b>Rgb</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rgb</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rgb</em>' containment reference.
   * @see #setRgb(RGBColor)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getColorValue_Rgb()
   * @model containment="true"
   * @generated
   */
  RGBColor getRgb();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.ColorValue#getRgb <em>Rgb</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rgb</em>' containment reference.
   * @see #getRgb()
   * @generated
   */
  void setRgb(RGBColor value);

} // ColorValue
