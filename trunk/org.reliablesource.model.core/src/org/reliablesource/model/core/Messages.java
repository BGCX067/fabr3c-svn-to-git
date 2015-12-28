package org.reliablesource.model.core;

import org.eclipse.osgi.util.NLS;

/**
 * 
 * Messages.java<br>
 * Copyright (c) 2007, Reliable Source, Inc. All Rights Reserved<br>
 * <br>
 * 
 * Created on: May 12, 2007 <br>
 * <br>
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 * @since 1.0.0
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.reliablesource.model.core.messages"; //$NON-NLS-1$

	public static String ReliableElement_0;

	public static String ReliableElement_1;

	public static String ReliableElement_2;

	public static String ReliableElement_3;

	public static String ReliableModel_0;

	public static String ReliableModel_1;

	public static String ReliableModel_2;

	public static String ReliableModel_3;

	public static String ReliableModel_4;

	public static String ReliableModel_5;

	public static String ReliableModel_6;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
