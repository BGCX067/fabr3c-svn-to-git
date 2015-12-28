package org.reliablesource.model.core;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;

/**
 * 
 * ReliableElement.java<br>
 * Copyright (c) 2007, Reliable Source, Inc. All Rights Reserved<br>
 * <br>
 * 
 * Created on: Apr 19, 2007 <br>
 * <br>
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 * @model
 */
public class ReliableElement extends Observable implements IAdaptable,
		Serializable, Cloneable, IReliableElement {

	private static final long serialVersionUID = 8168090298170433074L;

	final public static String NO_NAME = Messages.ReliableElement_0;
	final public static String NO_ID = Messages.ReliableElement_1;
	final public static String NO_DESCRIPTION = Messages.ReliableElement_2;

	final static protected String version = Messages.ReliableElement_3;

	final protected Map<String, Object> propertyMap;
	protected IReliableElement parent;

	final protected StringBuffer description;
	protected StringBuffer id;
	protected StringBuffer name;
	protected URI thumbImage;

	/**
	 * Default constructor.
	 * 
	 * @category constructor
	 */
	public ReliableElement() {
		super();
		id = new StringBuffer();
		name = new StringBuffer();
		description = new StringBuffer();

		propertyMap = new TreeMap<String, Object>();
		propertyMap.put(IReliableElement.VERSION, version);
	}

	/**
	 * Creates a new CMPElement object.
	 * 
	 * @param _id
	 * @param _name
	 * @category constructor
	 */
	public ReliableElement(final String _id, final String _name) {
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
	 * @param _children
	 * @category constructor
	 */
	public ReliableElement(final String _id, final String _name,
			final IReliableElement _parent,
			final List<IReliableElement> _children) {
		this(_id, _name, _parent);
	}

	/**
	 * Creates a new ReliableElement object.
	 * 
	 * @param _id
	 * @param _name
	 * @param _parent
	 * @category constructor
	 */
	public ReliableElement(final String _id, final String _name,
			final IReliableElement _parent) {
		this(_id, _name);
		setParent(_parent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#getId()
	 */
	public final String getId() {
		return id.toString().trim();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#getName()
	 */
	public String getName() {
		return name.toString().trim();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#getParent()
	 */
	public final IReliableElement getParent() {
		return parent;
	}

	/**
	 * @category setter
	 */
	public final void setParent(IReliableElement _parent) {
		if (null == _parent)
			_parent = ReliableCoreActivator.EMPTY_PARENT;

		parent = _parent;
		propertyMap.put(IReliableElement.PARENT, parent);
		setChanged();
	}

	/**
	 * @category setter
	 */
	public final void setName(String _name) {

		// @ check params for invalid values.
		if (null == _name || _name.length() < 1)
			_name = NO_NAME;

		if (name.toString().trim().equals(_name.trim()))
			return;

		// @ set the current value to the param's value.
		name.delete(0, getName().length());
		name.append(_name.trim());

		// @ update the object's property mapping.
		propertyMap.put(IReliableElement.NAME, getName());

		// @ flag that object has changed it's state.
		setChanged();
	}

	/**
	 * @category setter
	 */
	public void setId(String _id) {
		if (null == _id || _id.length() < 1)
			_id = NO_ID;

		if (id.toString().trim().equals(_id.trim()))
			return;

		id.delete(0, getId().length());
		id.append(_id.trim());

		propertyMap.put(IReliableElement.ID, getId());

		setChanged();
	}

	/**
	 * @see org.reliablesource.model.core.IReliableElement#getProperty(java.lang.String)
	 * @param _propKey -
	 *            property's attribute look up key
	 * @category getter
	 */
	public final Object getProperty(final String _propKey) {

		// @ Check the param points to a valid reference
		if (null != _propKey)

			// @ Check to see if object has the requested property.
			if (propertyMap.containsKey(_propKey.trim()))
				return propertyMap.get(_propKey.trim());

		return ReliableCoreActivator.EMPTY_STRING;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#getAvailableProperties()
	 */
	final public List<String> getAvailableProperties() {
		final List<String> propKeyList = new ArrayList<String>();

		propKeyList.addAll(propertyMap.keySet());

		return propKeyList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public final Object getAdapter(final Class _adapter) {
		if (null == _adapter)
			return ReliableCoreActivator.EMPTY_OBJECT[0];

		return Platform.getAdapterManager().getAdapter(this, _adapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#getDescription()
	 */
	public final String getDescription() {
		return description.toString().trim();
	}

	/**
	 * @category setter
	 */
	public final void setDescription(String _description) {

		if (null == _description)
			_description = NO_DESCRIPTION;

		description.delete(0, getDescription().length());
		description.append(_description);

		if (!propertyMap.containsKey(IReliableElement.DESCRIPTION)) {
			propertyMap.put(IReliableElement.DESCRIPTION, description);
		}
		setChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#getPropertyValue(java.lang.Object)
	 */
	public Object getPropertyValue(Object _id) {
		if (null == _id || !(_id instanceof String))
			return ReliableCoreActivator.EMPTY_OBJECT[0];

		return propertyMap.get(_id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#isPropertySet(java.lang.Object)
	 */
	public boolean isPropertySet(final String _id) {
		if (null == _id || _id.length() < 1)
			return false;
		return propertyMap.containsKey(_id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#setPropertyValue(java.lang.String,
	 *      java.lang.Object)
	 */
	public void setPropertyValue(String _id, Object _value) {

		if (null == _id || null == _value)
			return;

		if (propertyMap.containsKey(_id)) {
			propertyMap.put(_id, _value);
			setChanged();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#isRoot()
	 */
	public boolean isRoot() {
		return false;
	}

	public void dispose() {
		deleteObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#getVersion()
	 */
	public String getVersion() {
		return version;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public void init() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#getThumbImage()
	 */
	public URI getThumbImage() {
		return thumbImage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.model.core.IReliableElement#setThumbImage(java.net.URL)
	 */
	public void setThumbImage(String _imageUrl) throws URISyntaxException {
		thumbImage = new URI(_imageUrl);
		setChanged();
	}
}
