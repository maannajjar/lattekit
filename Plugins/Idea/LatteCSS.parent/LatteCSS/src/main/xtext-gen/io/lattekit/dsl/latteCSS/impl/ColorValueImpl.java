/**
 */
package io.lattekit.dsl.latteCSS.impl;

import io.lattekit.dsl.latteCSS.ColorValue;
import io.lattekit.dsl.latteCSS.LatteCSSPackage;
import io.lattekit.dsl.latteCSS.RGBColor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Color Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.ColorValueImpl#getNamedColor <em>Named Color</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.ColorValueImpl#getRgb <em>Rgb</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ColorValueImpl extends PaintValueImpl implements ColorValue
{
  /**
   * The default value of the '{@link #getNamedColor() <em>Named Color</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamedColor()
   * @generated
   * @ordered
   */
  protected static final String NAMED_COLOR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNamedColor() <em>Named Color</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamedColor()
   * @generated
   * @ordered
   */
  protected String namedColor = NAMED_COLOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getRgb() <em>Rgb</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRgb()
   * @generated
   * @ordered
   */
  protected RGBColor rgb;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ColorValueImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return LatteCSSPackage.Literals.COLOR_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNamedColor()
  {
    return namedColor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNamedColor(String newNamedColor)
  {
    String oldNamedColor = namedColor;
    namedColor = newNamedColor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.COLOR_VALUE__NAMED_COLOR, oldNamedColor, namedColor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RGBColor getRgb()
  {
    return rgb;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRgb(RGBColor newRgb, NotificationChain msgs)
  {
    RGBColor oldRgb = rgb;
    rgb = newRgb;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.COLOR_VALUE__RGB, oldRgb, newRgb);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRgb(RGBColor newRgb)
  {
    if (newRgb != rgb)
    {
      NotificationChain msgs = null;
      if (rgb != null)
        msgs = ((InternalEObject)rgb).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.COLOR_VALUE__RGB, null, msgs);
      if (newRgb != null)
        msgs = ((InternalEObject)newRgb).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.COLOR_VALUE__RGB, null, msgs);
      msgs = basicSetRgb(newRgb, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.COLOR_VALUE__RGB, newRgb, newRgb));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case LatteCSSPackage.COLOR_VALUE__RGB:
        return basicSetRgb(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case LatteCSSPackage.COLOR_VALUE__NAMED_COLOR:
        return getNamedColor();
      case LatteCSSPackage.COLOR_VALUE__RGB:
        return getRgb();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case LatteCSSPackage.COLOR_VALUE__NAMED_COLOR:
        setNamedColor((String)newValue);
        return;
      case LatteCSSPackage.COLOR_VALUE__RGB:
        setRgb((RGBColor)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case LatteCSSPackage.COLOR_VALUE__NAMED_COLOR:
        setNamedColor(NAMED_COLOR_EDEFAULT);
        return;
      case LatteCSSPackage.COLOR_VALUE__RGB:
        setRgb((RGBColor)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case LatteCSSPackage.COLOR_VALUE__NAMED_COLOR:
        return NAMED_COLOR_EDEFAULT == null ? namedColor != null : !NAMED_COLOR_EDEFAULT.equals(namedColor);
      case LatteCSSPackage.COLOR_VALUE__RGB:
        return rgb != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (namedColor: ");
    result.append(namedColor);
    result.append(')');
    return result.toString();
  }

} //ColorValueImpl
