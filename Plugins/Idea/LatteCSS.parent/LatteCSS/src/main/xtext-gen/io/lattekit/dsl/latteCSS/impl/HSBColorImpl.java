/**
 */
package io.lattekit.dsl.latteCSS.impl;

import io.lattekit.dsl.latteCSS.HSBColor;
import io.lattekit.dsl.latteCSS.LatteCSSPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HSB Color</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.HSBColorImpl#getHue <em>Hue</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.HSBColorImpl#getSaturation <em>Saturation</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.HSBColorImpl#getBrightness <em>Brightness</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.HSBColorImpl#getAlpha <em>Alpha</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HSBColorImpl extends MinimalEObjectImpl.Container implements HSBColor
{
  /**
   * The default value of the '{@link #getHue() <em>Hue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHue()
   * @generated
   * @ordered
   */
  protected static final String HUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getHue() <em>Hue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHue()
   * @generated
   * @ordered
   */
  protected String hue = HUE_EDEFAULT;

  /**
   * The default value of the '{@link #getSaturation() <em>Saturation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSaturation()
   * @generated
   * @ordered
   */
  protected static final String SATURATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSaturation() <em>Saturation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSaturation()
   * @generated
   * @ordered
   */
  protected String saturation = SATURATION_EDEFAULT;

  /**
   * The default value of the '{@link #getBrightness() <em>Brightness</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBrightness()
   * @generated
   * @ordered
   */
  protected static final String BRIGHTNESS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBrightness() <em>Brightness</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBrightness()
   * @generated
   * @ordered
   */
  protected String brightness = BRIGHTNESS_EDEFAULT;

  /**
   * The default value of the '{@link #getAlpha() <em>Alpha</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlpha()
   * @generated
   * @ordered
   */
  protected static final String ALPHA_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAlpha() <em>Alpha</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlpha()
   * @generated
   * @ordered
   */
  protected String alpha = ALPHA_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HSBColorImpl()
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
    return LatteCSSPackage.Literals.HSB_COLOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getHue()
  {
    return hue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHue(String newHue)
  {
    String oldHue = hue;
    hue = newHue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.HSB_COLOR__HUE, oldHue, hue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSaturation()
  {
    return saturation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSaturation(String newSaturation)
  {
    String oldSaturation = saturation;
    saturation = newSaturation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.HSB_COLOR__SATURATION, oldSaturation, saturation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBrightness()
  {
    return brightness;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBrightness(String newBrightness)
  {
    String oldBrightness = brightness;
    brightness = newBrightness;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.HSB_COLOR__BRIGHTNESS, oldBrightness, brightness));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAlpha()
  {
    return alpha;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAlpha(String newAlpha)
  {
    String oldAlpha = alpha;
    alpha = newAlpha;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.HSB_COLOR__ALPHA, oldAlpha, alpha));
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
      case LatteCSSPackage.HSB_COLOR__HUE:
        return getHue();
      case LatteCSSPackage.HSB_COLOR__SATURATION:
        return getSaturation();
      case LatteCSSPackage.HSB_COLOR__BRIGHTNESS:
        return getBrightness();
      case LatteCSSPackage.HSB_COLOR__ALPHA:
        return getAlpha();
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
      case LatteCSSPackage.HSB_COLOR__HUE:
        setHue((String)newValue);
        return;
      case LatteCSSPackage.HSB_COLOR__SATURATION:
        setSaturation((String)newValue);
        return;
      case LatteCSSPackage.HSB_COLOR__BRIGHTNESS:
        setBrightness((String)newValue);
        return;
      case LatteCSSPackage.HSB_COLOR__ALPHA:
        setAlpha((String)newValue);
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
      case LatteCSSPackage.HSB_COLOR__HUE:
        setHue(HUE_EDEFAULT);
        return;
      case LatteCSSPackage.HSB_COLOR__SATURATION:
        setSaturation(SATURATION_EDEFAULT);
        return;
      case LatteCSSPackage.HSB_COLOR__BRIGHTNESS:
        setBrightness(BRIGHTNESS_EDEFAULT);
        return;
      case LatteCSSPackage.HSB_COLOR__ALPHA:
        setAlpha(ALPHA_EDEFAULT);
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
      case LatteCSSPackage.HSB_COLOR__HUE:
        return HUE_EDEFAULT == null ? hue != null : !HUE_EDEFAULT.equals(hue);
      case LatteCSSPackage.HSB_COLOR__SATURATION:
        return SATURATION_EDEFAULT == null ? saturation != null : !SATURATION_EDEFAULT.equals(saturation);
      case LatteCSSPackage.HSB_COLOR__BRIGHTNESS:
        return BRIGHTNESS_EDEFAULT == null ? brightness != null : !BRIGHTNESS_EDEFAULT.equals(brightness);
      case LatteCSSPackage.HSB_COLOR__ALPHA:
        return ALPHA_EDEFAULT == null ? alpha != null : !ALPHA_EDEFAULT.equals(alpha);
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
    result.append(" (hue: ");
    result.append(hue);
    result.append(", saturation: ");
    result.append(saturation);
    result.append(", brightness: ");
    result.append(brightness);
    result.append(", alpha: ");
    result.append(alpha);
    result.append(')');
    return result.toString();
  }

} //HSBColorImpl
