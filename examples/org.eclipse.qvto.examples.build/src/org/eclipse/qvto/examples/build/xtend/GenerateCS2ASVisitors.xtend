/**
 * <copyright>
 *
 * Copyright (c) 2013 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvto.examples.build.xtend

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.jdt.annotation.NonNull
import java.util.List
import java.util.ArrayListimport org.eclipse.ocl.examples.xtext.base.cs2as.Continuation
import org.eclipse.ocl.examples.pivot.Element
import org.eclipse.ocl.examples.build.xtend.MergeWriter
import org.eclipse.ocl.examples.build.xtend.GenerateCSVisitors
import org.eclipse.emf.ecore.EOperation


// TODO non-derived visitor is not supported, since currently 
// the root CS2AS are not generated but manually coded. 
public class GenerateCS2ASVisitors extends GenerateCSVisitors
{
	override void generateVisitors(EPackage csPackage) {
		super.generateVisitors(csPackage);
		if (isDerived()) {
			generateContainmentVisitor(csPackage);
			generatePreOrderVisitor(csPackage);
			generatePostOrderVisitor(csPackage);
			generateLeft2RightVisitor(csPackage);
		}
	}
	
	protected def void generateContainmentVisitor(@NonNull EPackage csPackage) {
		var String visitorVariant = "Containment";
		var String resultTypeName =  "Continuation<?>";
		var String abstractVisitorClassName = "Abstract" + projectPrefix + visitorVariant + "Visitor";
		var String abstractExtendedClass = superProjectPrefix + visitorVariant + "Visitor";
		//		var String extendedClass = if (superVisitorClassName.length() == 0) {
//				"AbstractExtending" + visitableClassName;
//			} else {
//				visitorPrefix + superVisitorClassName;
//			}
		var String interfaceName =  visitorClassName +'<'+resultTypeName+'>';
		var List<String> additionalImports = new ArrayList();
		additionalImports.add(typeof(Continuation).getName());
		csPackage.generateContextfulAbstractExtendingVisitor(abstractVisitorClassName, abstractExtendedClass, 
			interfaceName,  resultTypeName, additionalImports);
			
		var String variantVisitorClassName = projectPrefix + visitorVariant + "Visitor";
		csPackage.generateContainmentVisitor(variantVisitorClassName, abstractVisitorClassName, resultTypeName, additionalImports);
	}
	

	
	protected def void generatePreOrderVisitor(@NonNull EPackage csPackage) {
		
		var String visitorVariant = "PreOrder";
		var String resultTypeName =  "Continuation<?>";
		var String className = "Abstract" + projectPrefix + visitorVariant + "Visitor";
		var String extendedClass = superProjectPrefix + visitorVariant + "Visitor";
		var String interfaceName =  visitorClassName +'<'+resultTypeName+'>';
		var List<String> additionalImports = new ArrayList();
		additionalImports.add(typeof(Continuation).getName());
		csPackage.generateContextfulAbstractExtendingVisitor(className, extendedClass, 
			interfaceName, resultTypeName, additionalImports);
	}
	
	protected def void generatePostOrderVisitor(@NonNull EPackage csPackage) {
		
		var String visitorVariant = "PostOrder";
		var String resultTypeName =  "Continuation<?>";
		var String className = "Abstract" + projectPrefix + visitorVariant + "Visitor";
		var String extendedClass = superProjectPrefix + visitorVariant + "Visitor";
		var String interfaceName =  visitorClassName +'<'+resultTypeName+'>';
		var List<String> additionalImports = new ArrayList();
		additionalImports.add(typeof(Continuation).getName());
		csPackage.generateContextfulAbstractExtendingVisitor(className, extendedClass, 
			interfaceName,  resultTypeName, additionalImports);
	}
	
	protected def void generateLeft2RightVisitor(@NonNull EPackage csPackage) {
		var String visitorVariant = "Left2Right";
		var String resultTypeName =  "Element";
		var String className = "Abstract" + projectPrefix + visitorVariant + "Visitor";
		var String extendedClass = superProjectPrefix + visitorVariant + "Visitor";
		var String interfaceName =  visitorClassName +'<'+resultTypeName+'>';
		var List<String> additionalImports = new ArrayList();
		additionalImports.add(typeof(Element).getName());
		csPackage.generateContextfulAbstractExtendingVisitor(className, extendedClass, 
			interfaceName,  resultTypeName, additionalImports);
	}
	
	/**
	 * Assumptions to be considered:
	 * - the package of the extended visitor of generated visitors need to be qualified as follows:
	 *    <code> «superProjectName».cs2as </code>
	 */
	protected def void generateContextfulAbstractExtendingVisitor(@NonNull EPackage ePackage, 
		@NonNull String className, @NonNull String extendedClassName, @NonNull String interfaceName,
		@NonNull String resultTypeName, @NonNull List<String> additionalImports) {
		var MergeWriter writer = new MergeWriter(outputFolder + className + ".java");
		writer.append('''
			«ePackage.generateHeader(visitorPackageName)»
			
			import org.eclipse.jdt.annotation.NonNull;
			import org.eclipse.jdt.annotation.Nullable;
			import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
			import «superProjectName».cs2as.«extendedClassName»;
			«FOR addtionalImport : additionalImports»
			import «addtionalImport»;
			«ENDFOR»
			
			/**
			 * An «className» provides a default implementation for each
			 * visitXxx method that delegates to the visitYyy method of the first
			 * super class, (or transitively its first super class first super class
			 * until a non-interface super-class is found). In the absence of any
			 * suitable first super class, the method delegates to visiting().
			 */
			public abstract class «className»
				extends «extendedClassName»
				implements «interfaceName»
			{
				/**
				 * Initializes me with an initial value for my result.
				 * 
				 * @param context my initial result value
				 */
				protected «className»(@NonNull CS2PivotConversion context) {
					super(context);
				}
				«FOR eClass : getSortedEClasses(ePackage)»
				«var EClass firstSuperClass = eClass.firstSuperClass(eClass)»
			
				public @Nullable «resultTypeName» visit«eClass.name»(@NonNull «modelPackageName».«eClass.name» csElement) {
					«IF firstSuperClass == eClass»
					return visiting(csElement);
					«ELSE»
					return visit«firstSuperClass.name»(csElement);
					«ENDIF»
				}
				«ENDFOR»
			}
		''');
		writer.close();
	}
	
	/**
	 * TODO When fully generation is achieved, visitAbstractConcept method needs to be qualified as follows:
	 *     visitAbstractElement(Abstract object) {
	 *       throw new UnsupportedOperationException();
	 *     }  
	 */
	protected def void generateContainmentVisitor(@NonNull EPackage ePackage, 
		@NonNull String className, @NonNull String extendedClassName, @NonNull String resultTypeName, 
		@NonNull List<String> additionalImports) {
		var MergeWriter writer = new MergeWriter(outputFolder + className + ".java");
		writer.append('''
			«ePackage.generateHeader(visitorPackageName)»
			
			import org.eclipse.jdt.annotation.NonNull;
			import org.eclipse.jdt.annotation.Nullable;
			import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
			«FOR additionalImport : additionalImports»
			import «additionalImport»;
			«ENDFOR»
			
			/**
			 *
			 */
			public class «className»
				extends «extendedClassName»
			{
				/**
				 * Initializes me with an initial value for my result.
				 * 
				 * @param context my initial result value
				 */
				public «className»(@NonNull CS2PivotConversion context) {
					super(context);
				}
				«FOR eClass : getSortedEClasses(ePackage)»
				«IF (eClass.hasAstOperation())»
				
				public @Nullable «resultTypeName» visit«eClass.name»(@NonNull «modelPackageName».«eClass.name» csElement) {
					«eClass.generateContainmentVisit()»
				}
				«ENDIF»
				«ENDFOR»
			}
		''');
		writer.close();
	}
	
	private def boolean hasAstOperation(EClass eclass)	{
		for (EOperation operation : eclass.EOperations) {
			if (operation.name == "ast") {
				return true;
			}
		}
		return false;
	}
	
	private def String generateContainmentVisit(EClass eClass) {
		// TODO
		return "return null;";
	}
}
