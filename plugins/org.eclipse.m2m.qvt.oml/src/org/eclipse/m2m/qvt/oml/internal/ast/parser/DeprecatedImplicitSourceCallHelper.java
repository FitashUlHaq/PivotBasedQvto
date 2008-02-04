/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.internal.ast.parser;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalFileEnv;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.expressions.CallExp;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;

/**
 * Used to perform validation checks on obsolete usage of calls on implicit source object.
 */
class DeprecatedImplicitSourceCallHelper {

	/**
	 * Checks the given call expression if it does not used obsolete calls to
	 * implicit source object.
	 * <p>
	 * <li/> <code>self</code> is not allowed to be implicitly resolved within
	 * the contextual operation scope.
	 * <li/> <code>this</code> is not allowed to be implicitly resolved when calling non-module owned
	 * operation/property
	 * 
	 * @param callExpCS
	 *            CST node representing the call, can be {@link VariableExpCS}
	 *            or {@link CallExpCS}
	 * @param resultAST
	 *            AST representation of the call expression
	 * @param env
	 *            the environment to receive validation problems
	 */
	static void validateCallExp(OCLExpressionCS callExpCS, CallExp<EClassifier> resultAST, QvtOperationalEnv env) {
	
		CSTNode causeNode = null;
		if(callExpCS instanceof CallExpCS) {
			CallExpCS actualCallExpCS = (CallExpCS) callExpCS;
			if(actualCallExpCS.getSource() != null) {
				return;
			}
			
			causeNode = (actualCallExpCS.getSimpleNameCS() != null) ? actualCallExpCS.getSimpleNameCS() : callExpCS;
		} 
		else if(callExpCS instanceof VariableExpCS && resultAST instanceof PropertyCallExp) {
			// property call using implicit source
			causeNode = callExpCS;
		}
		
		if(causeNode != null) {
			// call performed on implicit source
			if(resultAST instanceof CallExp) {
				CallExp<EClassifier> call = (CallExp<EClassifier>) resultAST;
				if(call.getSource() instanceof VariableExp) {
					VariableExp<EClassifier, EParameter> varExp = (VariableExp<EClassifier, EParameter>) call.getSource();     				
					Variable<EClassifier, EParameter> refVar = varExp.getReferredVariable();
					
					if(refVar != null && refVar.getName() != null) {
						String refVarName = refVar.getName();
						if(QvtOperationalEnv.SELF_VARIABLE_NAME.equals(refVarName)) {
							env.reportWarning(ValidationMessages.DeprecatedImplicitSourceCall_contextualImplicitCall, causeNode);
						} 
						else if(refVarName != null && refVarName.endsWith(QvtOperationalFileEnv.THIS_VAR_QNAME_SUFFIX)) {
							if(resultAST instanceof OperationCallExp) {
								OperationCallExp<EClassifier, EOperation> operCall = (OperationCallExp<EClassifier, EOperation>)resultAST;
								EOperation referredOperation = operCall.getReferredOperation();
								
								if(referredOperation != null && !isModuleOperation(referredOperation, env)) {
		    						env.reportWarning(ValidationMessages.DeprecatedImplicitSourceCall_moduleScopeImplicitCall, 
		    								causeNode);
								}
							} else if(resultAST instanceof PropertyCallExp) {
					        	PropertyCallExp<EClassifier, EStructuralFeature> propCall = (PropertyCallExp<EClassifier, EStructuralFeature>) resultAST;					        	
								EStructuralFeature referredProperty = propCall.getReferredProperty();
								
								if(referredProperty != null && !isModuleProperty(referredProperty, env)) {
		    						env.reportWarning(ValidationMessages.DeprecatedImplicitSourceCall_moduleScopeImplicitCall, 
		    								causeNode);
								}    				        	
							}    						    						
						}						
					}
					
				}
			}
		}
	}

	private static boolean isModuleOperation(EOperation operation, QvtOperationalEnv env) {
		EClassifier owningClassifier = env.getUMLReflection().getOwningClassifier(operation);
		return owningClassifier instanceof Module;
	}

	private static boolean isModuleProperty(EStructuralFeature feature, QvtOperationalEnv env) {
		return env.getUMLReflection().getOwningClassifier(feature) instanceof Module;
	}	
}
