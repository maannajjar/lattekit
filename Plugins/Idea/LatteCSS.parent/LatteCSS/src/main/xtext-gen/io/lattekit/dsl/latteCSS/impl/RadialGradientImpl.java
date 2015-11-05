/**
 */
package io.lattekit.dsl.latteCSS.impl;

import io.lattekit.dsl.latteCSS.LatteCSSPackage;
import io.lattekit.dsl.latteCSS.RadialGradient;
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
 * An implementation of the model object '<em><b>Radial Gradient</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.RadialGradientImpl#getCx <em>Cx</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.RadialGradientImpl#getCy <em>Cy</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.RadialGradientImpl#getRadius <em>Radius</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.RadialGradientImpl#getFx <em>Fx</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.RadialGradientImpl#getFy <em>Fy</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.RadialGradientImpl#getStops <em>Stops</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RadialGradientImpl extends PaintValueImpl implements RadialGradient
{
  /**
   * The cached value of the '{@link #getCx() <em>Cx</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCx()
   * @generated
   * @ordered
   */
  protected SizeValue cx;

  /**
   * The cached value of the '{@link #getCy() <em>Cy</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCy()
   * @generated
   * @ordered
   */
  protected SizeValue cy;

  /**
   * The cached value of the '{@link #getRadius() <em>Radius</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRadius()
   * @generated
   * @ordered
   */
  protected SizeValue radius;

  /**
   * The cached value of the '{@link #getFx() <em>Fx</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFx()
   * @generated
   * @ordered
   */
  protected SizeValue fx;

  /**
   * The cached value of the '{@link #getFy() <em>Fy</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFy()
   * @generated
   * @ordered
   */
  protected SizeValue fy;

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
  protected RadialGradientImpl()
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
    return LatteCSSPackage.Literals.RADIAL_GRADIENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SizeValue getCx()
  {
    return cx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCx(SizeValue newCx, NotificationChain msgs)
  {
    SizeValue oldCx = cx;
    cx = newCx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RADIAL_GRADIENT__CX, oldCx, newCx);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCx(SizeValue newCx)
  {
    if (newCx != cx)
    {
      NotificationChain msgs = null;
      if (cx != null)
        msgs = ((InternalEObject)cx).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.RADIAL_GRADIENT__CX, null, msgs);
      if (newCx != null)
        msgs = ((InternalEObject)newCx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.RADIAL_GRADIENT__CX, null, msgs);
      msgs = basicSetCx(newCx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RADIAL_GRADIENT__CX, newCx, newCx));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SizeValue getCy()
  {
    return cy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCy(SizeValue newCy, NotificationChain msgs)
  {
    SizeValue oldCy = cy;
    cy = newCy;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RADIAL_GRADIENT__CY, oldCy, newCy);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCy(SizeValue newCy)
  {
    if (newCy != cy)
    {
      NotificationChain msgs = null;
      if (cy != null)
        msgs = ((InternalEObject)cy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.RADIAL_GRADIENT__CY, null, msgs);
      if (newCy != null)
        msgs = ((InternalEObject)newCy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.RADIAL_GRADIENT__CY, null, msgs);
      msgs = basicSetCy(newCy, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RADIAL_GRADIENT__CY, newCy, newCy));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SizeValue getRadius()
  {
    return radius;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRadius(SizeValue newRadius, NotificationChain msgs)
  {
    SizeValue oldRadius = radius;
    radius = newRadius;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RADIAL_GRADIENT__RADIUS, oldRadius, newRadius);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRadius(SizeValue newRadius)
  {
    if (newRadius != radius)
    {
      NotificationChain msgs = null;
      if (radius != null)
        msgs = ((InternalEObject)radius).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.RADIAL_GRADIENT__RADIUS, null, msgs);
      if (newRadius != null)
        msgs = ((InternalEObject)newRadius).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.RADIAL_GRADIENT__RADIUS, null, msgs);
      msgs = basicSetRadius(newRadius, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RADIAL_GRADIENT__RADIUS, newRadius, newRadius));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SizeValue getFx()
  {
    return fx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFx(SizeValue newFx, NotificationChain msgs)
  {
    SizeValue oldFx = fx;
    fx = newFx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RADIAL_GRADIENT__FX, oldFx, newFx);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFx(SizeValue newFx)
  {
    if (newFx != fx)
    {
      NotificationChain msgs = null;
      if (fx != null)
        msgs = ((InternalEObject)fx).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.RADIAL_GRADIENT__FX, null, msgs);
      if (newFx != null)
        msgs = ((InternalEObject)newFx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.RADIAL_GRADIENT__FX, null, msgs);
      msgs = basicSetFx(newFx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RADIAL_GRADIENT__FX, newFx, newFx));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SizeValue getFy()
  {
    return fy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFy(SizeValue newFy, NotificationChain msgs)
  {
    SizeValue oldFy = fy;
    fy = newFy;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RADIAL_GRADIENT__FY, oldFy, newFy);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFy(SizeValue newFy)
  {
    if (newFy != fy)
    {
      NotificationChain msgs = null;
      if (fy != null)
        msgs = ((InternalEObject)fy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.RADIAL_GRADIENT__FY, null, msgs);
      if (newFy != null)
        msgs = ((InternalEObject)newFy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.RADIAL_GRADIENT__FY, null, msgs);
      msgs = basicSetFy(newFy, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.RADIAL_GRADIENT__FY, newFy, newFy));
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
      stops = new EObjectContainmentEList<StopValue>(StopValue.class, this, LatteCSSPackage.RADIAL_GRADIENT__STOPS);
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
      case LatteCSSPackage.RADIAL_GRADIENT__CX:
        return basicSetCx(null, msgs);
      case LatteCSSPackage.RADIAL_GRADIENT__CY:
        return basicSetCy(null, msgs);
      case LatteCSSPackage.RADIAL_GRADIENT__RADIUS:
        return basicSetRadius(null, msgs);
      case LatteCSSPackage.RADIAL_GRADIENT__FX:
        return basicSetFx(null, msgs);
      case LatteCSSPackage.RADIAL_GRADIENT__FY:
        return basicSetFy(null, msgs);
      case LatteCSSPackage.RADIAL_GRADIENT__STOPS:
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
      case LatteCSSPackage.RADIAL_GRADIENT__CX:
        return getCx();
      case LatteCSSPackage.RADIAL_GRADIENT__CY:
        return getCy();
      case LatteCSSPackage.RADIAL_GRADIENT__RADIUS:
        return getRadius();
      case LatteCSSPackage.RADIAL_GRADIENT__FX:
        return getFx();
      case LatteCSSPackage.RADIAL_GRADIENT__FY:
        return getFy();
      case LatteCSSPackage.RADIAL_GRADIENT__STOPS:
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
      case LatteCSSPackage.RADIAL_GRADIENT__CX:
        setCx((SizeValue)newValue);
        return;
      case LatteCSSPackage.RADIAL_GRADIENT__CY:
        setCy((SizeValue)newValue);
        return;
      case LatteCSSPackage.RADIAL_GRADIENT__RADIUS:
        setRadius((SizeValue)newValue);
        return;
      case LatteCSSPackage.RADIAL_GRADIENT__FX:
        setFx((SizeValue)newValue);
        return;
      case LatteCSSPackage.RADIAL_GRADIENT__FY:
        setFy((SizeValue)newValue);
        return;
      case LatteCSSPackage.RADIAL_GRADIENT__STOPS:
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
      case LatteCSSPackage.RADIAL_GRADIENT__CX:
        setCx((SizeValue)null);
        return;
      case LatteCSSPackage.RADIAL_GRADIENT__CY:
        setCy((SizeValue)null);
        return;
      case LatteCSSPackage.RADIAL_GRADIENT__RADIUS:
        setRadius((SizeValue)null);
        return;
      case LatteCSSPackage.RADIAL_GRADIENT__FX:
        setFx((SizeValue)null);
        return;
      case LatteCSSPackage.RADIAL_GRADIENT__FY:
        setFy((SizeValue)null);
        return;
      case LatteCSSPackage.RADIAL_GRADIENT__STOPS:
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
      case LatteCSSPackage.RADIAL_GRADIENT__CX:
        return cx != null;
      case LatteCSSPackage.RADIAL_GRADIENT__CY:
        return cy != null;
      case LatteCSSPackage.RADIAL_GRADIENT__RADIUS:
        return radius != null;
      case LatteCSSPackage.RADIAL_GRADIENT__FX:
        return fx != null;
      case LatteCSSPackage.RADIAL_GRADIENT__FY:
        return fy != null;
      case LatteCSSPackage.RADIAL_GRADIENT__STOPS:
        return stops != null && !stops.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RadialGradientImpl
