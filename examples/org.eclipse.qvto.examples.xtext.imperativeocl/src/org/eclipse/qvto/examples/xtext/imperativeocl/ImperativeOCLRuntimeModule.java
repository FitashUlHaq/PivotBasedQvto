/*
 * generated by Xtext
 */
package org.eclipse.qvto.examples.xtext.imperativeocl;

import org.eclipse.qvto.examples.xtext.imperativeocl.utilities.ImperativeOCLCSResource;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class ImperativeOCLRuntimeModule extends org.eclipse.qvto.examples.xtext.imperativeocl.AbstractImperativeOCLRuntimeModule {

	
	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return ImperativeOCLCSResource.class;
	}
}
