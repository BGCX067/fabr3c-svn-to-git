/**
 * Copyright (c) 2007, Reliable Source, Inc. 
 * All Rights Reserved.
 */
package org.reliablesource.cuttlefish.core.model.internal;

import org.reliablesource.cuttlefish.core.model.INode;
import org.reliablesource.model.core.ReliableNode;

/**
 * CuttleFishNode.java<br>
 * Created on: Aug 16, 2007<br>
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 * @since 1.0
 * 
 */
public class CuttleFishNode extends ReliableNode implements INode {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6483828505529444733L;

	/**
	 * Creates a new CMPElement object.
	 * 
	 * @param _id
	 * @param _name
	 * @category constructor
	 */
	public CuttleFishNode(final String _id) {
		this(_id, "");
	}

	/**
	 * Creates a new CMPElement object.
	 * 
	 * @param _id
	 * @param _name
	 * @category constructor
	 */
	public CuttleFishNode(final String _id, final String _name) {
		super(_id, _name);
	}
}
