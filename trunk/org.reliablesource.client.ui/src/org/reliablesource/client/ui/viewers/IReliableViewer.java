package org.reliablesource.client.ui.viewers;

import org.eclipse.jface.viewers.IInputSelectionProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.reliablesource.model.core.IDisposable;

/**
 * 
 * IReliableViewer.java<br>
 * Copyright (c) 2007, Reliable Source, Inc. All Rights Reserved<br>
 * <br>
 * 
 * Created on: Apr 19, 2007 <br>
 * <br>
 * 
 * Object instances of this type represent some UI control abstraction.
 * 
 * It is the responsibility of the parent container to call the Lifecycle
 * methods for objects of this type.
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 * @since 1.0.0
 */
public interface IReliableViewer extends IInputSelectionProvider, IDisposable {

	public Control getControl();

	public void refresh();

	public void setInput(Object _input);

	/**
	 * This lifecycle method is called by the container. After the constructor
	 * (0 arg), but before the <code>createViewerControl</code> is called.
	 * 
	 * @category lifecycle
	 */
	public void init();

	/**
	 * 
	 * 
	 * After the init, but before <code>setInput</code>, the Control for this
	 * viewer is created.
	 * 
	 * @param _parent
	 * @category lifecycle
	 */
	public void createViewerControl(Composite _parent);

	/**
	 * 
	 * @return
	 * @category getter
	 */
	public Viewer[] getChildren();

	/**
	 * @return the top-level <code>Viewer</code>
	 * @category getter
	 */
	public Viewer getContentViewer();
}
