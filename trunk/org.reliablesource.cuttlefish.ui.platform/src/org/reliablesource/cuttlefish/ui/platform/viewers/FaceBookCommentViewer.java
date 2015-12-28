/**
 * Copyright (c) 2007, Reliable Source, Inc. 
 * All Rights Reserved.
 */
package org.reliablesource.cuttlefish.ui.platform.viewers;

import java.util.List;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;
import org.reliablesource.client.ui.viewers.ReliableViewer;
import org.reliablesource.cuttlefish.core.model.INode;
import org.reliablesource.cuttlefish.ui.platform.Activator;

/**
 * FaceBookFriendsViewer.java<br>
 * Created on: Aug 16, 2007<br>
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 * @since 1.0
 * 
 */
public class FaceBookCommentViewer extends ReliableViewer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.client.ui.viewers.ReliableViewer#createViewerControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createViewerControl(Composite _parent) {
		contentViewer = new TableViewer(_parent);
		contentViewer.setContentProvider(new FaceBookCommentViewerContentProvider());
		contentViewer.setLabelProvider(new FaceBookCommentViewerLabelProvider());

		try {
			List<INode> _users = Activator.getComments();
			contentViewer.setInput(_users);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
