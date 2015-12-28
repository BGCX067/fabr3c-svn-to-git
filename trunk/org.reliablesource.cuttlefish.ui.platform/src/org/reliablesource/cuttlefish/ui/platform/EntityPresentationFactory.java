/**
 * Copyright (c) 2007, Reliable Source, Inc. 
 * All Rights Reserved.
 */
package org.reliablesource.cuttlefish.ui.platform;


/**
 * EntityPresentationFactory.java<br>
 * Created on: Aug 23, 2007<br>
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 * @since 1.0
 * 
 */
public class EntityPresentationFactory {
	/**
	 * 
	 */
	private static final long serialVersionUID = 73671746445475887L;

	private EntityPresentationFactory() {
		super();
	}

	private static EntityPresentationFactory instance = new EntityPresentationFactory();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElementFactory#getInstance()
	 */
	public static synchronized EntityPresentationFactory getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElementFactory#createElement(java.lang.String)
	 */
	// public Image getUserImage(String userId) {
	// try {
	// List<Integer> _uidList = new ArrayList<Integer>();
	// _uidList.add(Integer.parseInt(userId));
	// return Activator.getDefault().getUsersImage(_uidList);
	// } catch (Exception e) {
	// e.printStackTrace();
	// return null;
	// }
	//
	// }
}
