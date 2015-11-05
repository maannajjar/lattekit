/**
 */
package io.lattekit.dsl.latteCSS.impl;

import io.lattekit.dsl.latteCSS.LatteCSSPackage;
import io.lattekit.dsl.latteCSS.TimeValue;
import io.lattekit.dsl.latteCSS.TransitionValue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.TransitionValueImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.TransitionValueImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.TransitionValueImpl#getTimingFunction <em>Timing Function</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.TransitionValueImpl#getDelay <em>Delay</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionValueImpl extends MinimalEObjectImpl.Container implements TransitionValue
{
  /**
   * The default value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyName()
   * @generated
   * @ordered
   */
  protected static final String PROPERTY_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropertyName()
   * @generated
   * @ordered
   */
  protected String propertyName = PROPERTY_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getDuration() <em>Duration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDuration()
   * @generated
   * @ordered
   */
  protected TimeValue duration;

  /**
   * The default value of the '{@link #getTimingFunction() <em>Timing Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimingFunction()
   * @generated
   * @ordered
   */
  protected static final String TIMING_FUNCTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTimingFunction() <em>Timing Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimingFunction()
   * @generated
   * @ordered
   */
  protected String timingFunction = TIMING_FUNCTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getDelay() <em>Delay</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDelay()
   * @generated
   * @ordered
   */
  protected TimeValue delay;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionValueImpl()
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
    return LatteCSSPackage.Literals.TRANSITION_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPropertyName()
  {
    return propertyName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPropertyName(String newPropertyName)
  {
    String oldPropertyName = propertyName;
    propertyName = newPropertyName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.TRANSITION_VALUE__PROPERTY_NAME, oldPropertyName, propertyName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeValue getDuration()
  {
    return duration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDuration(TimeValue newDuration, NotificationChain msgs)
  {
    TimeValue oldDuration = duration;
    duration = newDuration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.TRANSITION_VALUE__DURATION, oldDuration, newDuration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDuration(TimeValue newDuration)
  {
    if (newDuration != duration)
    {
      NotificationChain msgs = null;
      if (duration != null)
        msgs = ((InternalEObject)duration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.TRANSITION_VALUE__DURATION, null, msgs);
      if (newDuration != null)
        msgs = ((InternalEObject)newDuration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.TRANSITION_VALUE__DURATION, null, msgs);
      msgs = basicSetDuration(newDuration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.TRANSITION_VALUE__DURATION, newDuration, newDuration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTimingFunction()
  {
    return timingFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimingFunction(String newTimingFunction)
  {
    String oldTimingFunction = timingFunction;
    timingFunction = newTimingFunction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.TRANSITION_VALUE__TIMING_FUNCTION, oldTimingFunction, timingFunction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeValue getDelay()
  {
    return delay;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDelay(TimeValue newDelay, NotificationChain msgs)
  {
    TimeValue oldDelay = delay;
    delay = newDelay;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.TRANSITION_VALUE__DELAY, oldDelay, newDelay);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDelay(TimeValue newDelay)
  {
    if (newDelay != delay)
    {
      NotificationChain msgs = null;
      if (delay != null)
        msgs = ((InternalEObject)delay).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.TRANSITION_VALUE__DELAY, null, msgs);
      if (newDelay != null)
        msgs = ((InternalEObject)newDelay).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.TRANSITION_VALUE__DELAY, null, msgs);
      msgs = basicSetDelay(newDelay, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.TRANSITION_VALUE__DELAY, newDelay, newDelay));
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
      case LatteCSSPackage.TRANSITION_VALUE__DURATION:
        return basicSetDuration(null, msgs);
      case LatteCSSPackage.TRANSITION_VALUE__DELAY:
        return basicSetDelay(null, msgs);
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
      case LatteCSSPackage.TRANSITION_VALUE__PROPERTY_NAME:
        return getPropertyName();
      case LatteCSSPackage.TRANSITION_VALUE__DURATION:
        return getDuration();
      case LatteCSSPackage.TRANSITION_VALUE__TIMING_FUNCTION:
        return getTimingFunction();
      case LatteCSSPackage.TRANSITION_VALUE__DELAY:
        return getDelay();
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
      case LatteCSSPackage.TRANSITION_VALUE__PROPERTY_NAME:
        setPropertyName((String)newValue);
        return;
      case LatteCSSPackage.TRANSITION_VALUE__DURATION:
        setDuration((TimeValue)newValue);
        return;
      case LatteCSSPackage.TRANSITION_VALUE__TIMING_FUNCTION:
        setTimingFunction((String)newValue);
        return;
      case LatteCSSPackage.TRANSITION_VALUE__DELAY:
        setDelay((TimeValue)newValue);
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
      case LatteCSSPackage.TRANSITION_VALUE__PROPERTY_NAME:
        setPropertyName(PROPERTY_NAME_EDEFAULT);
        return;
      case LatteCSSPackage.TRANSITION_VALUE__DURATION:
        setDuration((TimeValue)null);
        return;
      case LatteCSSPackage.TRANSITION_VALUE__TIMING_FUNCTION:
        setTimingFunction(TIMING_FUNCTION_EDEFAULT);
        return;
      case LatteCSSPackage.TRANSITION_VALUE__DELAY:
        setDelay((TimeValue)null);
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
      case LatteCSSPackage.TRANSITION_VALUE__PROPERTY_NAME:
        return PROPERTY_NAME_EDEFAULT == null ? propertyName != null : !PROPERTY_NAME_EDEFAULT.equals(propertyName);
      case LatteCSSPackage.TRANSITION_VALUE__DURATION:
        return duration != null;
      case LatteCSSPackage.TRANSITION_VALUE__TIMING_FUNCTION:
        return TIMING_FUNCTION_EDEFAULT == null ? timingFunction != null : !TIMING_FUNCTION_EDEFAULT.equals(timingFunction);
      case LatteCSSPackage.TRANSITION_VALUE__DELAY:
        return delay != null;
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
    result.append(" (propertyName: ");
    result.append(propertyName);
    result.append(", timingFunction: ");
    result.append(timingFunction);
    result.append(')');
    return result.toString();
  }

} //TransitionValueImpl
