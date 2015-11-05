/**
 */
package io.lattekit.dsl.latteCSS.impl;

import io.lattekit.dsl.latteCSS.LatteCSSPackage;
import io.lattekit.dsl.latteCSS.LinearGradient;
import io.lattekit.dsl.latteCSS.SizeValue;
import io.lattekit.dsl.latteCSS.StopValue;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linear Gradient</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.LinearGradientImpl#getX1 <em>X1</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.LinearGradientImpl#getY1 <em>Y1</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.LinearGradientImpl#getX2 <em>X2</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.LinearGradientImpl#getY2 <em>Y2</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.LinearGradientImpl#getStops <em>Stops</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LinearGradientImpl extends PaintValueImpl implements LinearGradient
{
  /**
   * The cached value of the '{@link #getX1() <em>X1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX1()
   * @generated
   * @ordered
   */
  protected SizeValue x1;

  /**
   * The cached value of the '{@link #getY1() <em>Y1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getY1()
   * @generated
   * @ordered
   */
  protected SizeValue y1;

  /**
   * The cached value of the '{@link #getX2() <em>X2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getX2()
   * @generated
   * @ordered
   */
  protected SizeValue x2;

  /**
   * The cached value of the '{@link #getY2() <em>Y2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getY2()
   * @generated
   * @ordered
   */
  protected SizeValue y2;

  /**
   * The cached value of the '{@link #getStops() <em>Stops</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStops()
   * @generated
   * @ordered
   */
  protected EList<StopValue> stops;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LinearGradientImpl()
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
    return LatteCSSPackage.Literals.LINEAR_GRADIENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SizeValue getX1()
  {
    return x1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX1(SizeValue newX1, NotificationChain msgs)
  {
    SizeValue oldX1 = x1;
    x1 = newX1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.LINEAR_GRADIENT__X1, oldX1, newX1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX1(SizeValue newX1)
  {
    if (newX1 != x1)
    {
      NotificationChain msgs = null;
      if (x1 != null)
        msgs = ((InternalEObject)x1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.LINEAR_GRADIENT__X1, null, msgs);
      if (newX1 != null)
        msgs = ((InternalEObject)newX1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.LINEAR_GRADIENT__X1, null, msgs);
      msgs = basicSetX1(newX1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.LINEAR_GRADIENT__X1, newX1, newX1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SizeValue getY1()
  {
    return y1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetY1(SizeValue newY1, NotificationChain msgs)
  {
    SizeValue oldY1 = y1;
    y1 = newY1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.LINEAR_GRADIENT__Y1, oldY1, newY1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setY1(SizeValue newY1)
  {
    if (newY1 != y1)
    {
      NotificationChain msgs = null;
      if (y1 != null)
        msgs = ((InternalEObject)y1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.LINEAR_GRADIENT__Y1, null, msgs);
      if (newY1 != null)
        msgs = ((InternalEObject)newY1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.LINEAR_GRADIENT__Y1, null, msgs);
      msgs = basicSetY1(newY1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.LINEAR_GRADIENT__Y1, newY1, newY1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SizeValue getX2()
  {
    return x2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetX2(SizeValue newX2, NotificationChain msgs)
  {
    SizeValue oldX2 = x2;
    x2 = newX2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.LINEAR_GRADIENT__X2, oldX2, newX2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setX2(SizeValue newX2)
  {
    if (newX2 != x2)
    {
      NotificationChain msgs = null;
      if (x2 != null)
        msgs = ((InternalEObject)x2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.LINEAR_GRADIENT__X2, null, msgs);
      if (newX2 != null)
        msgs = ((InternalEObject)newX2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.LINEAR_GRADIENT__X2, null, msgs);
      msgs = basicSetX2(newX2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.LINEAR_GRADIENT__X2, newX2, newX2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SizeValue getY2()
  {
    return y2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetY2(SizeValue newY2, NotificationChain msgs)
  {
    SizeValue oldY2 = y2;
    y2 = newY2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.LINEAR_GRADIENT__Y2, oldY2, newY2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setY2(SizeValue newY2)
  {
    if (newY2 != y2)
    {
      NotificationChain msgs = null;
      if (y2 != null)
        msgs = ((InternalEObject)y2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.LINEAR_GRADIENT__Y2, null, msgs);
      if (newY2 != null)
        msgs = ((InternalEObject)newY2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.LINEAR_GRADIENT__Y2, null, msgs);
      msgs = basicSetY2(newY2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.LINEAR_GRADIENT__Y2, newY2, newY2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StopValue> getStops()
  {
    if (stops == null)
    {
      stops = new EObjectContainmentEList<StopValue>(StopValue.class, this, LatteCSSPackage.LINEAR_GRADIENT__STOPS);
    }
    return stops;
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
      case LatteCSSPackage.LINEAR_GRADIENT__X1:
        return basicSetX1(null, msgs);
      case LatteCSSPackage.LINEAR_GRADIENT__Y1:
        return basicSetY1(null, msgs);
      case LatteCSSPackage.LINEAR_GRADIENT__X2:
        return basicSetX2(null, msgs);
      case LatteCSSPackage.LINEAR_GRADIENT__Y2:
        return basicSetY2(null, msgs);
      case LatteCSSPackage.LINEAR_GRADIENT__STOPS:
        return ((InternalEList<?>)getStops()).basicRemove(otherEnd, msgs);
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
      case LatteCSSPackage.LINEAR_GRADIENT__X1:
        return getX1();
      case LatteCSSPackage.LINEAR_GRADIENT__Y1:
        return getY1();
      case LatteCSSPackage.LINEAR_GRADIENT__X2:
        return getX2();
      case LatteCSSPackage.LINEAR_GRADIENT__Y2:
        return getY2();
      case LatteCSSPackage.LINEAR_GRADIENT__STOPS:
        return getStops();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case LatteCSSPackage.LINEAR_GRADIENT__X1:
        setX1((SizeValue)newValue);
        return;
      case LatteCSSPackage.LINEAR_GRADIENT__Y1:
        setY1((SizeValue)newValue);
        return;
      case LatteCSSPackage.LINEAR_GRADIENT__X2:
        setX2((SizeValue)newValue);
        return;
      case LatteCSSPackage.LINEAR_GRADIENT__Y2:
        setY2((SizeValue)newValue);
        return;
      case LatteCSSPackage.LINEAR_GRADIENT__STOPS:
        getStops().clear();
        getStops().addAll((Collection<? extends StopValue>)newValue);
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
      case LatteCSSPackage.LINEAR_GRADIENT__X1:
        setX1((SizeValue)null);
        return;
      case LatteCSSPackage.LINEAR_GRADIENT__Y1:
        setY1((SizeValue)null);
        return;
      case LatteCSSPackage.LINEAR_GRADIENT__X2:
        setX2((SizeValue)null);
        return;
      case LatteCSSPackage.LINEAR_GRADIENT__Y2:
        setY2((SizeValue)null);
        return;
      case LatteCSSPackage.LINEAR_GRADIENT__STOPS:
        getStops().clear();
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
      case LatteCSSPackage.LINEAR_GRADIENT__X1:
        return x1 != null;
      case LatteCSSPackage.LINEAR_GRADIENT__Y1:
        return y1 != null;
      case LatteCSSPackage.LINEAR_GRADIENT__X2:
        return x2 != null;
      case LatteCSSPackage.LINEAR_GRADIENT__Y2:
        return y2 != null;
      case LatteCSSPackage.LINEAR_GRADIENT__STOPS:
        return stops != null && !stops.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //LinearGradientImpl
