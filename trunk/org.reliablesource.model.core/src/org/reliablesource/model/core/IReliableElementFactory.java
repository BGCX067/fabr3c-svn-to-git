/**
 * Copyright (c) 2007, Reliable Source, Inc. 
 * All Rights Reserved.
 */
package org.reliablesource.model.core;

import java.io.Serializable;

/**
 * IReliableElementFactory.java<br>
 * Created on: Aug 16, 2007<br>
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 * @since 1.0
 * @category singleton, factory
 * @model
 * 
 */
public abstract interface IReliableElementFactory extends Cloneable,
		Serializable {

	/**
	 * 
	 * @param _type
	 * @return
	 * @model
	 */
	public IReliableElement createElement(final String _type);

}
