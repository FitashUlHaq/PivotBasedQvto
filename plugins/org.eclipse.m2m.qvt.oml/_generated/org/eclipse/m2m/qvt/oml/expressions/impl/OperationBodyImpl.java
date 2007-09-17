/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.expressions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.qvt.oml.expressions.ExtendedVisitor;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.expressions.OperationBody;

import org.eclipse.ocl.expressions.OCLExpression;

import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.OperationBodyImpl#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.OperationBodyImpl#getEndPosition <em>End Position</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.OperationBodyImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.OperationBodyImpl#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationBodyImpl extends EObjectImpl implements OperationBody {
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #getStartPosition() <em>Start Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStartPosition()
     * @generated
     * @ordered
     */
	protected static final int START_POSITION_EDEFAULT = -1;

	/**
     * The cached value of the '{@link #getStartPosition() <em>Start Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStartPosition()
     * @generated
     * @ordered
     */
	protected int startPosition = START_POSITION_EDEFAULT;

	/**
     * The default value of the '{@link #getEndPosition() <em>End Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEndPosition()
     * @generated
     * @ordered
     */
	protected static final int END_POSITION_EDEFAULT = -1;

	/**
     * The cached value of the '{@link #getEndPosition() <em>End Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEndPosition()
     * @generated
     * @ordered
     */
	protected int endPosition = END_POSITION_EDEFAULT;

	/**
     * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getContent()
     * @generated
     * @ordered
     */
	protected EList<OCLExpression<EClassifier>> content;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected OperationBodyImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.OPERATION_BODY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getStartPosition() {
        return startPosition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setStartPosition(int newStartPosition) {
        int oldStartPosition = startPosition;
        startPosition = newStartPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OPERATION_BODY__START_POSITION, oldStartPosition, startPosition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getEndPosition() {
        return endPosition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEndPosition(int newEndPosition) {
        int oldEndPosition = endPosition;
        endPosition = newEndPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OPERATION_BODY__END_POSITION, oldEndPosition, endPosition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ImperativeOperation getOperation() {
        if (eContainerFeatureID != ExpressionsPackage.OPERATION_BODY__OPERATION) return null;
        return (ImperativeOperation)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOperation(ImperativeOperation newOperation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperation, ExpressionsPackage.OPERATION_BODY__OPERATION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOperation(ImperativeOperation newOperation) {
        if (newOperation != eInternalContainer() || (eContainerFeatureID != ExpressionsPackage.OPERATION_BODY__OPERATION && newOperation != null)) {
            if (EcoreUtil.isAncestor(this, newOperation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperation != null)
                msgs = ((InternalEObject)newOperation).eInverseAdd(this, ExpressionsPackage.IMPERATIVE_OPERATION__BODY, ImperativeOperation.class, msgs);
            msgs = basicSetOperation(newOperation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OPERATION_BODY__OPERATION, newOperation, newOperation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<OCLExpression<EClassifier>> getContent() {
        if (content == null) {
            content = new EObjectContainmentEList<OCLExpression<EClassifier>>(OCLExpression.class, this, ExpressionsPackage.OPERATION_BODY__CONTENT);
        }
        return content;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
        return ((ExtendedVisitor<T, ?, ?, ?, ?>) v).visitOperationBody(this);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.OPERATION_BODY__OPERATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperation((ImperativeOperation)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.OPERATION_BODY__OPERATION:
                return basicSetOperation(null, msgs);
            case ExpressionsPackage.OPERATION_BODY__CONTENT:
                return ((InternalEList<?>)getContent()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID) {
            case ExpressionsPackage.OPERATION_BODY__OPERATION:
                return eInternalContainer().eInverseRemove(this, ExpressionsPackage.IMPERATIVE_OPERATION__BODY, ImperativeOperation.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExpressionsPackage.OPERATION_BODY__START_POSITION:
                return new Integer(getStartPosition());
            case ExpressionsPackage.OPERATION_BODY__END_POSITION:
                return new Integer(getEndPosition());
            case ExpressionsPackage.OPERATION_BODY__OPERATION:
                return getOperation();
            case ExpressionsPackage.OPERATION_BODY__CONTENT:
                return getContent();
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
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ExpressionsPackage.OPERATION_BODY__START_POSITION:
                setStartPosition(((Integer)newValue).intValue());
                return;
            case ExpressionsPackage.OPERATION_BODY__END_POSITION:
                setEndPosition(((Integer)newValue).intValue());
                return;
            case ExpressionsPackage.OPERATION_BODY__OPERATION:
                setOperation((ImperativeOperation)newValue);
                return;
            case ExpressionsPackage.OPERATION_BODY__CONTENT:
                getContent().clear();
                getContent().addAll((Collection<? extends OCLExpression<EClassifier>>)newValue);
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
	public void eUnset(int featureID) {
        switch (featureID) {
            case ExpressionsPackage.OPERATION_BODY__START_POSITION:
                setStartPosition(START_POSITION_EDEFAULT);
                return;
            case ExpressionsPackage.OPERATION_BODY__END_POSITION:
                setEndPosition(END_POSITION_EDEFAULT);
                return;
            case ExpressionsPackage.OPERATION_BODY__OPERATION:
                setOperation((ImperativeOperation)null);
                return;
            case ExpressionsPackage.OPERATION_BODY__CONTENT:
                getContent().clear();
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
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ExpressionsPackage.OPERATION_BODY__START_POSITION:
                return startPosition != START_POSITION_EDEFAULT;
            case ExpressionsPackage.OPERATION_BODY__END_POSITION:
                return endPosition != END_POSITION_EDEFAULT;
            case ExpressionsPackage.OPERATION_BODY__OPERATION:
                return getOperation() != null;
            case ExpressionsPackage.OPERATION_BODY__CONTENT:
                return content != null && !content.isEmpty();
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == ASTNode.class) {
            switch (derivedFeatureID) {
                case ExpressionsPackage.OPERATION_BODY__START_POSITION: return UtilitiesPackage.AST_NODE__START_POSITION;
                case ExpressionsPackage.OPERATION_BODY__END_POSITION: return UtilitiesPackage.AST_NODE__END_POSITION;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == ASTNode.class) {
            switch (baseFeatureID) {
                case UtilitiesPackage.AST_NODE__START_POSITION: return ExpressionsPackage.OPERATION_BODY__START_POSITION;
                case UtilitiesPackage.AST_NODE__END_POSITION: return ExpressionsPackage.OPERATION_BODY__END_POSITION;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (startPosition: "); //$NON-NLS-1$
        result.append(startPosition);
        result.append(", endPosition: "); //$NON-NLS-1$
        result.append(endPosition);
        result.append(')');
        return result.toString();
    }

} //OperationBodyImpl
