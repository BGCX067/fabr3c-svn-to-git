/**
 * Copyright (c) 2007, Reliable Source, Inc. 
 * All Rights Reserved.
 */
package org.reliablesource.model.core;

import java.util.ArrayList;
import java.util.List;

/**
 * ReliableNode.java<br>
 * Created on: Aug 16, 2007<br>
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 * @since 1.0
 * 
 */
public class ReliableNode extends ReliableElement implements IReliableNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7073054752689168491L;

	final protected List<IReliableElement> children;

	/**
	 * Default constructor.
	 * 
	 * @category constructor
	 */
	public ReliableNode() {
		super();
		children = new ArrayList<IReliableElement>();
	}

	/**
	 * Creates a new CMPElement object.
	 * 
	 * @param _id
	 * @param _name
	 * @category constructor
	 */
	public ReliableNode(final String _id, final String _name) {
		this();
		setId(_id);
		setName(_name);
	}

	/**
	 * Creates a new CMPElement object.
	 * 
	 * @param _id
	 * @param _name
	 * @param _parent
	 * @category constructor
	 */
	public ReliableNode(final String _id, final String _name,
			final IReliableElement _parent) {
		this(_id, _name);
		setParent(_parent);
		propertyMap.put(IReliableNode.CHILDREN, children);
	}

	/**
	 * Creates a new CMPElement object.
	 * 
	 * @param _id
	 * @param _name
	 * @param _parent
	 * @param _children
	 * @category constructor
	 */
	public ReliableNode(final String _id, final String _name,
			final IReliableElement _parent,
			final List<IReliableElement> _children) {
		this(_id, _name, _parent);
		children.addAll(_children);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#hasChildren()
	 */
	public boolean hasChildren() {
		return children.size() > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#getChildren()
	 */
	public final IReliableElement[] getChildren() {
		return children.toArray(new IReliableElement[children.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#getChild(int)
	 */
	public final IReliableElement getChild(int _idx) {
		if (_idx < children.size()) {
			return children.get(_idx);
		}

		return (IReliableElement) ReliableCoreActivator.EMPTY_OBJECT[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#getChild(org.reliablesource.model.core.IReliableElement)
	 */
	public final IReliableElement getChild(final IReliableElement _child) {
		if (null != _child)
			if (children.contains(_child))
				return getChild(children.indexOf(_child));
		return (IReliableElement) ReliableCoreActivator.EMPTY_OBJECT[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#addChild(org.reliablesource.model.core.IReliableElement)
	 */
	public final boolean addChild(final IReliableElement _object) {
		if (null == _object)
			return false;
		if (!propertyMap.containsKey(IReliableNode.CHILDREN))
			propertyMap.put(IReliableNode.CHILDREN, children);

		if (children.contains(_object))
			return false;

		children.add(_object);
		setChanged();
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#removeChild(org.reliablesource.model.core.IReliableElement)
	 */
	public final boolean removeChild(final IReliableElement _removeChild) {

		if (null == _removeChild)
			return false;

		if (!children.contains(_removeChild))
			return false;

		children.remove(_removeChild);
		setChanged();
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#containsChild(org.reliablesource.model.core.IReliableElement)
	 */
	public boolean containsChild(final IReliableElement _child) {
		if (null == _child)
			return false;
		return children.contains(_child);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#getChild(java.lang.String)
	 */
	public IReliableElement getChild(final String _id) {
		if (null == _id)
			return ReliableCoreActivator.EMPTY_PARENT;
		return ReliableCoreActivator.EMPTY_PARENT;
	}
}
