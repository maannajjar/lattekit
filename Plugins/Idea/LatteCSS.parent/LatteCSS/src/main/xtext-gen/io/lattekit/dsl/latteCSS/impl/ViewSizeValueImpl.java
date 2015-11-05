/**
 */
package io.lattekit.dsl.latteCSS.impl;

import io.lattekit.dsl.latteCSS.LatteCSSPackage;
import io.lattekit.dsl.latteCSS.SizeValue;
import io.lattekit.dsl.latteCSS.ViewSizeValue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Size Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.ViewSizeValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.ViewSizeValueImpl#getDynamic <em>Dynamic</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewSizeValueImpl extends MinimalEObjectImpl.Container implements ViewSizeValue
{
  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected SizeValue value;

  /**
   * The default value of the '{@link #getDynamic() <em>Dynamic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDynamic()
   * @generated
   * @ordered
   */
  protected static final String DYNAMIC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDynamic() <em>Dynamic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDynamic()
   * @generated
   * @ordered
   */
  protected String dynamic = DYNAMIC_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ViewSizeValueImpl()
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
    return LatteCSSPackage.Literals.VIEW_SIZE_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SizeValue getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(SizeValue newValue, NotificationChain msgs)
  {
    SizeValue oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.VIEW_SIZE_VALUE__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(SizeValue newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.VIEW_SIZE_VALUE__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.VIEW_SIZE_VALUE__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.VIEW_SIZE_VALUE__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDynamic()
  {
    return dynamic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDynamic(String newDynamic)
  {
    String oldDynamic = dynamic;
    dynamic = newDynamic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.VIEW_SIZE_VALUE__DYNAMIC, oldDynamic, dynamic));
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
      case LatteCSSPackage.VIEW_SIZE_VALUE__VALUE:
        return basicSetValue(null, msgs);
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
      case LatteCSSPackage.VIEW_SIZE_VALUE__VALUE:
        return getValue();
      case LatteCSSPackage.VIEW_SIZE_VALUE__DYNAMIC:
        return getDynamic();
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
      case LatteCSSPackage.VIEW_SIZE_VALUE__VALUE:
        setValue((SizeValue)newValue);
        return;
      case LatteCSSPackage.VIEW_SIZE_VALUE__DYNAMIC:
        setDynamic((String)newValue);
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
      case LatteCSSPackage.VIEW_SIZE_VALUE__VALUE:
        setValue((SizeValue)null);
        return;
      case LatteCSSPackage.VIEW_SIZE_VALUE__DYNAMIC:
        setDynamic(DYNAMIC_EDEFAULT);
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
      case LatteCSSPackage.VIEW_SIZE_VALUE__VALUE:
        return value != null;
      case LatteCSSPackage.VIEW_SIZE_VALUE__DYNAMIC:
        return DYNAMIC_EDEFAULT == null ? dynamic != null : !DYNAMIC_EDEFAULT.equals(dynamic);
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
    result.append(" (dynamic: ");
    result.append(dynamic);
    result.append(')');
    return result.toString();
  }

} //ViewSizeValueImpl
