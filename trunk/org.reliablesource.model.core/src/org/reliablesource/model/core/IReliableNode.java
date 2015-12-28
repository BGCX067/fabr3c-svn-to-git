/**
 * Copyright (c) 2007, Reliable Source, Inc. 
 * All Rights Reserved.
 */
package org.reliablesource.model.core;

/**
 * IReliableNode.java<br>
 * Created on: Aug 16, 2007<br>
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 * @since 1.0
 * @model
 * 
 */
public interface IReliableNode extends IReliableElement {

	final public static String CHILDREN = Messages.ReliableModel_3;
	final public static int CHILDREN_IDX = PROP_TABLE_IDX.length + 1;
	final public static String[] PROPERTIES = { CHILDREN };

	/**
	 * 
	 * 
	 * @return
	 * @category getter
	 * @model type="IReliableElement" containment="true"
	 */
	public IReliableElement[] getChildren();

	/**
	 * 
	 * 
	 * @param index
	 * 
	 * @return
	 * @category getter
	 * @model type="IReliableElement" containment="true"
	 */
	public IReliableElement getChild(int index);

	/**
	 * 
	 * 
	 * @param _child
	 * 
	 * @return
	 * @category getter
	 * @model type="IReliableElement" containment="true"
	 */
	public IReliableElement getChild(IReliableElement _child);

	/**
	 * 
	 * 
	 * @param _child
	 * 
	 * @return <code>true</code> if added, otherwise <code>false</code>.
	 * @model
	 */
	public boolean addChild(IReliableElement _child);

	/**
	 * 
	 * 
	 * @param _child
	 * 
	 * @return
	 * @model
	 */
	public boolean removeChild(IReliableElement _child);

	/**
	 * 
	 * 
	 * @param _id
	 * @return
	 * @category getter
	 * @model type="IReliableElement" containment="true"
	 */
	public IReliableElement getChild(String _id);

	/**
	 * 
	 * 
	 * @param _child
	 * @category helper
	 * @model
	 */
	public boolean containsChild(IReliableElement _child);

	/**
	 * @return <code>true</code> if element has children, otherwise
	 *         <code>false</code>.
	 * @category helper
	 * @model
	 */
	public boolean hasChildren();
}
