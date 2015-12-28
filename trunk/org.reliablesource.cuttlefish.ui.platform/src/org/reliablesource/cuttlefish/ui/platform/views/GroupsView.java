/**
 * Copyright (c) 2007, Reliable Source, Inc. 
 * All Rights Reserved.
 */
package org.reliablesource.cuttlefish.ui.platform.views;

import org.reliablesource.client.ui.viewers.IReliableViewer;
import org.reliablesource.client.ui.workbench.views.ReliableViewPart;
import org.reliablesource.cuttlefish.ui.platform.viewers.GroupsViewer;

/**
 * GroupsView.java<br> 
 * Created on: Sep 5, 2007<br>
 *
 * @author Dennis Park 
 * 		<a href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 *
 * @since 1.0
 *
 */
public class GroupsView extends ReliableViewPart {

	public static String ID = "org.reliablesource.cuttlefish.ui.platform.views.GroupsView";
	
	/* (non-Javadoc)
	 * @see org.reliablesource.client.ui.workbench.views.ReliableViewPart#createViewer()
	 */
	@Override
	protected IReliableViewer createViewer() {
		return new GroupsViewer();
	}

}
