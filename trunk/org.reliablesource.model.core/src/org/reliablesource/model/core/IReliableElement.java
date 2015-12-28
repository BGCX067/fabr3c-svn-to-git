package org.reliablesource.model.core;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * 
 * IReliableElement.java<br>
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
 * 
 */
public interface IReliableElement extends Cloneable, Serializable, IDisposable {
	// NOTE: String constants used dually as mapKey and Screen output.
	final public static String NAME = Messages.ReliableModel_0;

	final public static String PARENT = Messages.ReliableModel_1;

	final public static String ID = Messages.ReliableModel_2;

	final public static String DESCRIPTION = Messages.ReliableModel_4;

	final public static String VERSION = Messages.ReliableModel_5;
	final public static String THUMB_IMAGE = Messages.ReliableModel_6;

	final public static String[] PROPERTIES = { NAME, PARENT, ID, DESCRIPTION,
			VERSION };

	final public static int NAME_IDX = 0;

	final public static int PARENT_IDX = 1;

	final public static int ID_IDX = 2;

	final public static int DESC_IDX = 3;

	final public static int VERSION_IDX = 4;

	final public static int[] PROP_TABLE_IDX = { NAME_IDX, PARENT_IDX, ID_IDX,
			DESC_IDX, VERSION_IDX };

	/**
	 * 
	 * @return
	 * @category getter
	 * @model
	 */
	public String getName();

	/**
	 * 
	 * @return
	 * @category getter
	 * @model
	 */
	public IReliableElement getParent();

	/**
	 * 
	 * @return
	 * @category getter
	 * @model
	 */
	public String getId();

	/**
	 * 
	 * 
	 * @return
	 * @category getter
	 * @model
	 */
	public String getDescription();

	/**
	 * 
	 * 
	 * @param _prop
	 * 
	 * @return
	 * @category getter
	 * @model
	 */
	public Object getProperty(final String _prop);

	/**
	 * 
	 * @return
	 * @category getter
	 * @model
	 */
	public List<String> getAvailableProperties();

	/**
	 * 
	 * @param id -
	 *            the property's id
	 * 
	 * @return <code>true</code> if the property is set, otherwise
	 *         <code>false</code>.
	 * @category helper
	 */
	public boolean isPropertySet(final String _id);

	/**
	 * 
	 * 
	 * @param id
	 * @param value
	 * @category setter
	 */
	public void setPropertyValue(String _id, Object _value);

	/**
	 * @return <code>true</code> if element is root, otherwise
	 *         <code>false</code>. An element is root if it is its own
	 *         parent.
	 * @category helper
	 */
	public boolean isRoot();

	/**
	 * @see org.reliablesource.model.core.IDisposable#dispose()
	 */
	public void dispose();

	/**
	 * @return the String literal build version.
	 * @category getter
	 */
	public String getVersion();

	/**
	 * 
	 * @category lifecycle
	 */
	public void init();

	public URI getThumbImage();

	public void setThumbImage(String _imageUrl) throws URISyntaxException;
}
