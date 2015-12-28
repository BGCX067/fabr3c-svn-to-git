package org.reliablesource.model.core;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ReliableCoreActivator extends Plugin {

	final public static Object [] EMPTY_OBJECT = new Object[ 0 ];
    final public static String    EMPTY_STRING = new String( "" ); //$NON-NLS-1$
    final public static IReliableElement EMPTY_PARENT = 
    		new ReliableElement(ReliableElement.NO_ID, 
    				ReliableElement.NO_NAME);
    
	// The plug-in ID
	public static final String PLUGIN_ID = "org.reliablesource.model.core"; //$NON-NLS-1$

	// The shared instance
	private static ReliableCoreActivator plugin;
	
	/**
	 * The constructor
	 */
	public ReliableCoreActivator() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ReliableCoreActivator getDefault() {
		return plugin;
	}

}
