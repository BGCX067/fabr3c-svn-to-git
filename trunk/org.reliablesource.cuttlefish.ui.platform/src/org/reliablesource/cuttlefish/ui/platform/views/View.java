package org.reliablesource.cuttlefish.ui.platform.views;

import org.reliablesource.client.ui.viewers.IReliableViewer;
import org.reliablesource.client.ui.workbench.views.ReliableViewPart;
import org.reliablesource.cuttlefish.ui.platform.viewers.FaceBookFriendsViewer;

public class View extends ReliableViewPart {
	public static final String ID = "org.reliablesource.cuttlefish.ui.platform.views.View";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.client.ui.workbench.views.ReliableViewPart#createViewer()
	 */
	@Override
	protected IReliableViewer createViewer() {
		return new FaceBookFriendsViewer();
	}
}