/**
 */
package io.lattekit.dsl.latteCSS.impl;

import io.lattekit.dsl.latteCSS.LatteCSSPackage;
import io.lattekit.dsl.latteCSS.RGBColor;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RGB Color</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.RGBColorImpl#getHex <em>Hex</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.RGBColorImpl#getR <em>R</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.RGBColorImpl#getG <em>G</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.RGBColorImpl#getB <em>B</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.RGBColorImpl#getAlpha <em>Alpha</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RGBColorImpl extends MinimalEObjectImpl.Container implements RGBColor
{
  /**
   * The default value of the '{@link #getHex() <em>Hex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHex()
   * @generated
   * @ordered
   */
  protected static final String HEX_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getHex() <em>Hex</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHex()
   * @generated
   * @ordered
   */
  protected String hex = HEX_EDEFAULT;

  /**
   * The default value of the '{@link #getR() <em>R</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getR()
   * @generated
   * @ordered
   */
  protected static final String R_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getR() <em>R</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getR()
   * @generated
   * @ordered
   */
  protected String r = R_EDEFAULT;

  /**
   * The default value of the '{@link #getG() <em>G</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getG()
   * @generated
   * @ordered
   */
  protected static final String G_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getG() <em>G</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getG()
   * @generated
   * @ordered
   */
  protected String g = G_EDEFAULT;

  /**
   * The default value of the '{@link #getB() <em>B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getB()
   * @generated
   * @ordered
   */
  protected static final String B_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getB() <em>B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getB()
   * @generated
   * @ordered
   */
  protected String b = B_EDEFAULT;

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
  protected RGBColorImpl()
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
    return LatteCSSPackage.Literals.RGB_COLOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getHex()
  {
    return hex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHex(String newHex)
  {
    String oldHex = hex;
    hex = newHex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RGB_COLOR__HEX, oldHex, hex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getR()
  {
    return r;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setR(String newR)
  {
    String oldR = r;
    r = newR;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RGB_COLOR__R, oldR, r));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getG()
  {
    return g;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setG(String newG)
  {
    String oldG = g;
    g = newG;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RGB_COLOR__G, oldG, g));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getB()
  {
    return b;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setB(String newB)
  {
    String oldB = b;
    b = newB;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RGB_COLOR__B, oldB, b));
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
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RGB_COLOR__ALPHA, oldAlpha, alpha));
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
      case LatteCSSPackage.RGB_COLOR__HEX:
        return getHex();
      case LatteCSSPackage.RGB_COLOR__R:
        return getR();
      case LatteCSSPackage.RGB_COLOR__G:
        return getG();
      case LatteCSSPackage.RGB_COLOR__B:
        return getB();
      case LatteCSSPackage.RGB_COLOR__ALPHA:
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
      case LatteCSSPackage.RGB_COLOR__HEX:
        setHex((String)newValue);
        return;
      case LatteCSSPackage.RGB_COLOR__R:
        setR((String)newValue);
        return;
      case LatteCSSPackage.RGB_COLOR__G:
        setG((String)newValue);
        return;
      case LatteCSSPackage.RGB_COLOR__B:
        setB((String)newValue);
        return;
      case LatteCSSPackage.RGB_COLOR__ALPHA:
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
      case LatteCSSPackage.RGB_COLOR__HEX:
        setHex(HEX_EDEFAULT);
        return;
      case LatteCSSPackage.RGB_COLOR__R:
        setR(R_EDEFAULT);
        return;
      case LatteCSSPackage.RGB_COLOR__G:
        setG(G_EDEFAULT);
        return;
      case LatteCSSPackage.RGB_COLOR__B:
        setB(B_EDEFAULT);
        return;
      case LatteCSSPackage.RGB_COLOR__ALPHA:
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
      case LatteCSSPackage.RGB_COLOR__HEX:
        return HEX_EDEFAULT == null ? hex != null : !HEX_EDEFAULT.equals(hex);
      case LatteCSSPackage.RGB_COLOR__R:
        return R_EDEFAULT == null ? r != null : !R_EDEFAULT.equals(r);
      case LatteCSSPackage.RGB_COLOR__G:
        return G_EDEFAULT == null ? g != null : !G_EDEFAULT.equals(g);
      case LatteCSSPackage.RGB_COLOR__B:
        return B_EDEFAULT == null ? b != null : !B_EDEFAULT.equals(b);
      case LatteCSSPackage.RGB_COLOR__ALPHA:
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
    result.append(" (hex: ");
    result.append(hex);
    result.append(", r: ");
    result.append(r);
    result.append(", g: ");
    result.append(g);
    result.append(", b: ");
    result.append(b);
    result.append(", alpha: ");
    result.append(alpha);
    result.append(')');
    return result.toString();
  }

} //RGBColorImpl
