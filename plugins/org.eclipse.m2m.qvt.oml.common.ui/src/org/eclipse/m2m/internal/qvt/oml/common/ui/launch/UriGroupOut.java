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
 package org.eclipse.m2m.internal.qvt.oml.common.ui.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.window.Window;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.qvt.oml.common.ui.IModelParameterInfo;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IChooser;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IDestinationChooser;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author sboyko
 *
 */
public class UriGroupOut extends BaseUriGroup {
	
	public UriGroupOut(Composite parent, String name) {
		super(parent, SWT.NONE);
		
		myData = new TargetUriData(""); //$NON-NLS-1$
		myUpdating = false;
		
		setLayout(new GridLayout(3, false));
		
		{
			createLabel(name, 1);
			
			myUriText = TransformationControls.createText(this, 1);
			myUriText.addModifyListener(MODIFY_LISTENER);

			myUriButton = TransformationControls.createButton(this, Messages.TargetUriSelector_Browse);
			myUriButton.addSelectionListener(new SelectionAdapter(){
	            @Override
				public void widgetSelected(SelectionEvent e) {
	                if (myActiveListener != null) {
	                    myActiveListener.widgetSelected(e);
	                }
	            }
			});
		}
		
		{
			createLabel(Messages.TargetUriSelector_Feature, 1);
		
			myFeatureText = TransformationControls.createText(this, 1);
			myFeatureText.addModifyListener(MODIFY_LISTENER);
			
			myFeatureButton = TransformationControls.createButton(this, Messages.TargetUriSelector_Select);
			myFeatureButton.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {
					if (myObject == null) {
						throw new RuntimeException("No object"); //$NON-NLS-1$
					}

					EStructuralFeature feature = myObject.eClass().getEStructuralFeature(myData.getFeature());
					EReference initRef = feature instanceof EReference ? (EReference)feature : null;
					ReferenceSelectionDialog dialog = new ReferenceSelectionDialog(myObject.eClass(), initRef, getShell());
					if (dialog.open() == Window.OK) {
						EReference ref = dialog.getReference();
						myFeatureText.setText(ref.getName());
					}
				}
			});
		}
		
		{
			createLabel("", 1); //$NON-NLS-1$

			myClearContentsCheckbox = new Button(this, SWT.CHECK);
			myClearContentsCheckbox.setText(Messages.TargetUriSelector_ClearContents);
			myClearContentsCheckbox.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					updateData();
				}
			});
			
			GridData gridData = new GridData();
			gridData.horizontalSpan = 1;
			myClearContentsCheckbox.setLayoutData(gridData);
		}
		
		initializeFrom(myData);
	}
	
	public void initializeFrom(TargetUriData targetData) {
		myUpdating = true;
		try {
			myUriText.setText(targetData.getUriString() == null ? "" : targetData.getUriString()); //$NON-NLS-1$
			myFeatureText.setText(targetData.getFeature() == null ? "" : targetData.getFeature()); //$NON-NLS-1$
			myClearContentsCheckbox.setSelection(targetData.isClearContents());
		}
		finally {
			myUpdating = false;
		}
		
		updateData();
	}
	
	@Override
	public TargetUriData getData() {
		return myData;
	}
	
	private void updateData() {
		if (myUpdating) {
			return;
		}
		
		try {
			boolean isUriExisted = isUriExisted(getText());

            TargetUriData oldData = new TargetUriData(myData);
			EObject oldObject = myObject;
			
			myObject = null;
			
			TargetType targetType = isUriExisted ? TargetType.EXISTING_CONTAINER : TargetType.NEW_MODEL;
			myData = new TargetUriData(targetType,
					myUriText.getText().trim(),
					myFeatureText.getText(),
					myClearContentsCheckbox.getSelection());
			
			switch(myData.getTargetType()) {
				case NEW_MODEL: { 
					myFeatureText.setEnabled(false);
					myFeatureButton.setEnabled(false);
					myClearContentsCheckbox.setEnabled(false);
					myUriText.setEnabled(true);
					myUriButton.setEnabled(true);
					break;
				}
				
				case EXISTING_CONTAINER: {
					try {
						myObject = getEObject(oldData.getUriString(), oldObject);
					}
					finally {
						myFeatureText.setEnabled(myObject != null);
						myFeatureButton.setEnabled(myObject != null);
						myClearContentsCheckbox.setEnabled(myObject != null);
					}
					break;
				}
			}
		}
		finally {
			fireModified();
		}
	}
	
	private boolean isUriExisted(String textUri) {
        URI destUri = EmfUtil.makeUri(textUri);
        if (destUri != null) {
            IFile file = org.eclipse.m2m.qvt.oml.emf.util.URIUtils.getFile(destUri);
            if (file != null && file.exists()) {
            	return true;
            }
        }
        return false;
	}
	
	private EObject getEObject(String oldUri, EObject oldObject) {
		boolean sameUri = oldUri == null ? myData.getUriString() == null : oldUri.equals(myData.getUriString());
		EObject  obj;
		if(sameUri && oldObject != null) {
			obj = oldObject;
		}
		else {
			URI uri = null;
            try {
                uri = URI.createURI(myData.getUriString());
            } catch (IllegalArgumentException e) {                
            }
            
			if(uri == null) {
				return null;
			}
			
			try {
				obj = EmfUtil.loadModel(uri);
			}
			catch(Exception e) {
				obj = null;
			}
		}
		
		return obj;
	}
	
    public String getText() {
        return myUriText.getText();
    }
    
    public Text getUriText() {
    	return myUriText;
    }

	public void update(String uri, String baseName, String extension, Shell shell) {
        if (uri == null) {
        	myUriText.setEnabled(false);
        	myUriButton.setEnabled(false);
            myActiveListener = null;
        }
        else {
            IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(uri);
            if (handler == null) {
                throw new RuntimeException("No handler for URI " + uri); //$NON-NLS-1$
            }
            else {
                IChooser chooser = handler.getDestinationChooser();
                ((IDestinationChooser) chooser).initNewName(baseName, extension);
                
                myActiveListener = new UriChooserListener(myUriText, chooser, shell);
            	myUriText.setEnabled(true);
            	myUriButton.setEnabled(true);
            }
        }
    }
	
	public IValidator getValidator() {
		return myValidator;
	}

	
	private TargetUriData myData;
	private boolean myUpdating;
	private EObject myObject;

	private final Text myUriText;
	private final Button myUriButton;
    private SelectionListener myActiveListener;
	private final Text myFeatureText;
	private final Button myFeatureButton;
	
	private final Button myClearContentsCheckbox;
	
	private final ModifyListener MODIFY_LISTENER = new ModifyListener() {
		public void modifyText(ModifyEvent e) {
			updateData();
		}
	};

    private final IValidator myValidator = new Validator();

	private class Validator implements IValidator {

		public IStatus validate(IModelParameterInfo paramInfo) {
			return StatusUtil.makeOkStatus();
		}

		public void update(IModelParameterInfo paramInfo, Shell shell) {
			UriGroupOut.this.update("/", "", "", shell);
		}
		
	}
    
}
