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
package org.eclipse.m2m.internal.qvt.oml.common.ui.wizards;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.messages"; //$NON-NLS-1$

    private Messages() {
    }

    public static String SelectFolderPage_BrowseFolder;
    public static String SelectFolderPage_LocationFolder;
    public static String SelectFolderPage_BrowseButtonLabel;
    public static String SelectFolderPage_MissingDestFolderMessage;
    public static String SelectFolderPage_ContainerNotInWorkspaceMessage;
    
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

}
