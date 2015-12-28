package org.reliablesource.client.ui.workbench.views;

import org.eclipse.ui.IViewPart;
import org.reliablesource.client.ui.viewers.IReliableViewer;

/**
 *
 *  IReliableViewPart.java<br>
 *  Copyright (c) 2007, Reliable Source, Inc. All Rights Reserved<br><br>
 *
 *	Created on: May 12, 2007 <br><br>
 *  @author Dennis Park 
 *<a href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 *
 * @since 1.0.0
 */
public interface IReliableViewPart extends IViewPart {

	public IReliableViewer getViewer();
	public void setFocus();
}
