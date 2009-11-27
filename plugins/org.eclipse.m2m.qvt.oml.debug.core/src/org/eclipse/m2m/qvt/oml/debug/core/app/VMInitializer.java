package org.eclipse.m2m.qvt.oml.debug.core.app;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;
import org.eclipse.m2m.qvt.oml.debug.core.vm.IQVTOVirtualMachineShell;
import org.eclipse.m2m.qvt.oml.debug.core.vm.QVTOVirtualMachine;
import org.eclipse.osgi.util.NLS;

class VMInitializer implements VMProvider {

	public static final int INITIALIZE_TIMEOUT = 60 * 1000;

	private final DebugTransformationRunner fRunner;
	private final Object fLock = new Object();
	
	private Diagnostic fInitDiagnostic;
	private Thread fInitThread;
	private IQVTOVirtualMachineShell fVM;
	
	public VMInitializer(DebugTransformationRunner runner) {
		if(runner == null) {
			throw new IllegalArgumentException();
		}
		
		this.fRunner = runner;
	}

	public IQVTOVirtualMachineShell getVM() throws CoreException {

		joinInitialization(INITIALIZE_TIMEOUT);

		synchronized (fLock) {
			if(fVM == null) {
				// error condition
				throw new CoreException(BasicDiagnostic.toIStatus(fInitDiagnostic));
			}
		}

		return fVM;
	}

	public void startBackgrouInitialization() throws IllegalStateException {
		synchronized (fLock) {
			if(fInitThread != null) {
				throw new IllegalStateException("Initialization already started"); //$NON-NLS-1$
			}
			
			fInitThread = new Thread(new Runnable() {				
				public void run() {
					doInitialize();
				}
			});
		}

		fInitThread.start();		
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.qvt.oml.debug.core.app.VMProvider#joinInitialization(long)
	 */
	public void joinInitialization(long timeoutMilisec) throws CoreException {
		synchronized (fLock) {
			if(fInitThread == null) {
				throw new IllegalStateException("Initialization not started"); //$NON-NLS-1$
			}
		}

		try {			
			fInitThread.join(timeoutMilisec);
		} catch (InterruptedException e) {
			// nobody should interrupt us by contract;
			QVTODebugCore.log(e); //$NON-NLS-1$
		}

		if(fInitThread.isAlive()) {
			throw new CoreException(QVTODebugCore.createStatus(IStatus.ERROR,
					NLS.bind("QVTO VM initialization not finished in ({0}) ms",
							timeoutMilisec)));
		}
	}

	private void doInitialize() {		
		Diagnostic diagnostic;
		IQVTOVirtualMachineShell vm = null;
		try {
			diagnostic = fRunner.initialize();
			
			if(QvtPlugin.isSuccess(diagnostic)) {
				vm = new QVTOVirtualMachine(fRunner.createDebugableAdapter()); 
			}
			
		} catch(Throwable e) {
			diagnostic = QvtPlugin.createErrorDiagnostic("Unexpected exception caught", e);
		}

		synchronized (fLock) {
			fInitDiagnostic = diagnostic;
			fVM = vm;
		}		
	}
}
