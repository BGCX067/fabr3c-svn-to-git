/**
 * Copyright (c) 2007, Reliable Source, Inc. 
 * All Rights Reserved.
 */
package org.reliablesource.cuttlefish.core.model;

import org.reliablesource.model.core.IReliableElementFactory;

/**
 * IEntityFactory.java<br>
 * Created on: Aug 15, 2007<br>
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 * @since 1.0
 * 
 */
public interface IEntityFactory extends IReliableElementFactory {

	public INode createNode(String _id, String _name);

	public INode createNode(String _id);

	public IEntity createEntity();
}
