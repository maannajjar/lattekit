/**
 */
package io.lattekit.dsl.latteCSS.impl;

import io.lattekit.dsl.latteCSS.ClassSelector;
import io.lattekit.dsl.latteCSS.IdSelector;
import io.lattekit.dsl.latteCSS.LatteCSSPackage;
import io.lattekit.dsl.latteCSS.PseudoClassSelector;
import io.lattekit.dsl.latteCSS.SimpleSelector;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.SimpleSelectorImpl#getElement <em>Element</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.SimpleSelectorImpl#getId <em>Id</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.SimpleSelectorImpl#getPseudoClass <em>Pseudo Class</em>}</li>
 *   <li>{@link io.lattekit.dsl.latteCSS.impl.SimpleSelectorImpl#getClass_ <em>Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleSelectorImpl extends MinimalEObjectImpl.Container implements SimpleSelector
{
  /**
   * The default value of the '{@link #getElement() <em>Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected static final String ELEMENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected String element = ELEMENT_EDEFAULT;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected IdSelector id;

  /**
   * The cached value of the '{@link #getPseudoClass() <em>Pseudo Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPseudoClass()
   * @generated
   * @ordered
   */
  protected PseudoClassSelector pseudoClass;

  /**
   * The cached value of the '{@link #getClass_() <em>Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClass_()
   * @generated
   * @ordered
   */
  protected ClassSelector class_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SimpleSelectorImpl()
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
    return LatteCSSPackage.Literals.SIMPLE_SELECTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElement(String newElement)
  {
    String oldElement = element;
    element = newElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.SIMPLE_SELECTOR__ELEMENT, oldElement, element));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdSelector getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetId(IdSelector newId, NotificationChain msgs)
  {
    IdSelector oldId = id;
    id = newId;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.SIMPLE_SELECTOR__ID, oldId, newId);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(IdSelector newId)
  {
    if (newId != id)
    {
      NotificationChain msgs = null;
      if (id != null)
        msgs = ((InternalEObject)id).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.SIMPLE_SELECTOR__ID, null, msgs);
      if (newId != null)
        msgs = ((InternalEObject)newId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.SIMPLE_SELECTOR__ID, null, msgs);
      msgs = basicSetId(newId, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.SIMPLE_SELECTOR__ID, newId, newId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PseudoClassSelector getPseudoClass()
  {
    return pseudoClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPseudoClass(PseudoClassSelector newPseudoClass, NotificationChain msgs)
  {
    PseudoClassSelector oldPseudoClass = pseudoClass;
    pseudoClass = newPseudoClass;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.SIMPLE_SELECTOR__PSEUDO_CLASS, oldPseudoClass, newPseudoClass);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPseudoClass(PseudoClassSelector newPseudoClass)
  {
    if (newPseudoClass != pseudoClass)
    {
      NotificationChain msgs = null;
      if (pseudoClass != null)
        msgs = ((InternalEObject)pseudoClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.SIMPLE_SELECTOR__PSEUDO_CLASS, null, msgs);
      if (newPseudoClass != null)
        msgs = ((InternalEObject)newPseudoClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.SIMPLE_SELECTOR__PSEUDO_CLASS, null, msgs);
      msgs = basicSetPseudoClass(newPseudoClass, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.SIMPLE_SELECTOR__PSEUDO_CLASS, newPseudoClass, newPseudoClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassSelector getClass_()
  {
    return class_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClass(ClassSelector newClass, NotificationChain msgs)
  {
    ClassSelector oldClass = class_;
    class_ = newClass;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LatteCSSPackage.SIMPLE_SELECTOR__CLASS, oldClass, newClass);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClass(ClassSelector newClass)
  {
    if (newClass != class_)
    {
      NotificationChain msgs = null;
      if (class_ != null)
        msgs = ((InternalEObject)class_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.SIMPLE_SELECTOR__CLASS, null, msgs);
      if (newClass != null)
        msgs = ((InternalEObject)newClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LatteCSSPackage.SIMPLE_SELECTOR__CLASS, null, msgs);
      msgs = basicSetClass(newClass, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LatteCSSPackage.SIMPLE_SELECTOR__CLASS, newClass, newClass));
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
      case LatteCSSPackage.SIMPLE_SELECTOR__ID:
        return basicSetId(null, msgs);
      case LatteCSSPackage.SIMPLE_SELECTOR__PSEUDO_CLASS:
        return basicSetPseudoClass(null, msgs);
      case LatteCSSPackage.SIMPLE_SELECTOR__CLASS:
        return basicSetClass(null, msgs);
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
      case LatteCSSPackage.SIMPLE_SELECTOR__ELEMENT:
        return getElement();
      case LatteCSSPackage.SIMPLE_SELECTOR__ID:
        return getId();
      case LatteCSSPackage.SIMPLE_SELECTOR__PSEUDO_CLASS:
        return getPseudoClass();
      case LatteCSSPackage.SIMPLE_SELECTOR__CLASS:
        return getClass_();
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
      case LatteCSSPackage.SIMPLE_SELECTOR__ELEMENT:
        setElement((String)newValue);
        return;
      case LatteCSSPackage.SIMPLE_SELECTOR__ID:
        setId((IdSelector)newValue);
        return;
      case LatteCSSPackage.SIMPLE_SELECTOR__PSEUDO_CLASS:
        setPseudoClass((PseudoClassSelector)newValue);
        return;
      case LatteCSSPackage.SIMPLE_SELECTOR__CLASS:
        setClass((ClassSelector)newValue);
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
      case LatteCSSPackage.SIMPLE_SELECTOR__ELEMENT:
        setElement(ELEMENT_EDEFAULT);
        return;
      case LatteCSSPackage.SIMPLE_SELECTOR__ID:
        setId((IdSelector)null);
        return;
      case LatteCSSPackage.SIMPLE_SELECTOR__PSEUDO_CLASS:
        setPseudoClass((PseudoClassSelector)null);
        return;
      case LatteCSSPackage.SIMPLE_SELECTOR__CLASS:
        setClass((ClassSelector)null);
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
      case LatteCSSPackage.SIMPLE_SELECTOR__ELEMENT:
        return ELEMENT_EDEFAULT == null ? element != null : !ELEMENT_EDEFAULT.equals(element);
      case LatteCSSPackage.SIMPLE_SELECTOR__ID:
        return id != null;
      case LatteCSSPackage.SIMPLE_SELECTOR__PSEUDO_CLASS:
        return pseudoClass != null;
      case LatteCSSPackage.SIMPLE_SELECTOR__CLASS:
        return class_ != null;
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
    result.append(" (element: ");
    result.append(element);
    result.append(')');
    return result.toString();
  }

} //SimpleSelectorImpl
