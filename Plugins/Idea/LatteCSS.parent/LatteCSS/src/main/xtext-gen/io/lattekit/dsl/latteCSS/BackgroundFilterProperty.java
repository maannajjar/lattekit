/**
 */
package io.lattekit.dsl.latteCSS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Background Filter Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.BackgroundFilterProperty#getColor <em>Color</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.BackgroundFilterProperty#getFilter <em>Filter</em>}</li>
 * </ul>
 *
 * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getBackgroundFilterProperty()
 * @model
 * @generated
 */
public interface BackgroundFilterProperty extends CSSProperty
{
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
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getBackgroundFilterProperty_Color()
   * @model containment="true"
   * @generated
   */
  ColorValue getColor();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.BackgroundFilterProperty#getColor <em>Color</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Color</em>' containment reference.
   * @see #getColor()
   * @generated
   */
  void setColor(ColorValue value);

  /**
   * Returns the value of the '<em><b>Filter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Filter</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Filter</em>' attribute.
   * @see #setFilter(String)
   * @see io.lattekit.dsl.latteCSS.LatteCSSPackage#getBackgroundFilterProperty_Filter()
   * @model
   * @generated
   */
  String getFilter();

  /**
   * Sets the value of the '{@link io.lattekit.dsl.latteCSS.BackgroundFilterProperty#getFilter <em>Filter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Filter</em>' attribute.
   * @see #getFilter()
   * @generated
   */
  void setFilter(String value);

} // BackgroundFilterProperty
