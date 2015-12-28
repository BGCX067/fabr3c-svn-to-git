package org.reliablesource.client.ui.workbench.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.reliablesource.client.ui.viewers.IReliableViewer;

/**
 * 
 * ReliableViewPart.java<br>
 * Copyright (c) 2007, Reliable Source, Inc. All Rights Reserved<br>
 * <br>
 * 
 * Created on: May 12, 2007 <br>
 * <br>
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 * @since 1.0.0
 */
abstract public class ReliableViewPart extends ViewPart implements
		IReliableViewPart {

	protected IReliableViewer viewer;

	@Override
	public void createPartControl(Composite parent) {
		viewer = createViewer();
		viewer.init();
		viewer.createViewerControl(parent);
	}

	@Override
	public void setFocus() {
		if (null != viewer)
			if (null != viewer.getControl())
				viewer.getControl().setFocus();
	}

	public IReliableViewer getViewer() {
		return viewer;
	}

	/**
	 * @return
	 * @category lifecycle
	 */
	abstract protected IReliableViewer createViewer();

	/**
	 * 
	 */
	protected void setInput(final Object _input) {
		viewer.setInput(_input);
	}
}
