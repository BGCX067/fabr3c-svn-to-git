package org.reliablesource.cuttlefish.ui.platform.viewers;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.reliablesource.client.ui.viewers.ReliableElementContentProvider;
import org.reliablesource.cuttlefish.core.model.INode;

/**
 * 
 * ContributorContentProvider.java<br>
 * Copyright (c) 2007, Reliable Source, Inc. All Rights Reserved<br>
 * <br>
 * 
 * Created on: May 16, 2007 <br>
 * <br>
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 * @since 1.0.0
 */
public class FaceBookCommentViewerContentProvider extends
		ReliableElementContentProvider {

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		currentSelection = (IStructuredSelection) event.getSelection();
	}

	/**
	 * Returns the elements in the input, which must be either an array or a
	 * <code>Collection</code>.
	 */
	@Override
	public Object[] getElements(Object _element) {
		return super.getElements(_element);
	}

	@Override
	public Object[] getChildren(Object _parentElement) {
		return super.getChildren(_parentElement);
	}

	@Override
	public Object getParent(Object element) {
		return super.getParent(element);
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof INode) {
			// ((INode)element).g
		}
		return super.hasChildren(element);
	}
}
