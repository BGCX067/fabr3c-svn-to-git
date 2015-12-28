/**
 * Copyright (c) 2007, Reliable Source, Inc. 
 * All Rights Reserved.
 */
package org.reliablesource.cuttlefish.core.model;

import org.reliablesource.cuttlefish.core.model.internal.CuttleFishEntity;
import org.reliablesource.cuttlefish.core.model.internal.CuttleFishNode;
import org.reliablesource.model.core.IReliableElement;
import org.reliablesource.model.core.IReliableElementFactory;

/**
 * EntityFactory.java<br>
 * Created on: Aug 15, 2007<br>
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 * @since 1.0
 * 
 */
public class EntityFactory implements IEntityFactory {
	/**
	 * 
	 */
	private static final long serialVersionUID = 73671746445475887L;

	private EntityFactory() {
		super();
	}

	private static IReliableElementFactory instance = new EntityFactory();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElementFactory#getInstance()
	 */
	public static synchronized IReliableElementFactory getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElementFactory#createElement(java.lang.String)
	 */
	public IReliableElement createElement(String _type) {
		return createEntity();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.cuttlefish.core.model.IEntityFactory#createEntity()
	 */
	public IEntity createEntity() {
		return new CuttleFishEntity();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.cuttlefish.core.model.IEntityFactory#createNode()
	 */
	public INode createNode(String _id, String _name) {
		return new CuttleFishNode(_id, _name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.cuttlefish.core.model.IEntityFactory#createNode(java.lang.String)
	 */
	public INode createNode(String _id) {
		return new CuttleFishNode(_id);
	}
}
