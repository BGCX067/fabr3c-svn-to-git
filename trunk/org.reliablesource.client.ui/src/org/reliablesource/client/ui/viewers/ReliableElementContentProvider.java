package org.reliablesource.client.ui.viewers;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.reliablesource.model.core.IReliableElement;
import org.reliablesource.model.core.IReliableNode;

/**
 * 
 * ReliableElementContentProvider.java<br>
 * Copyright (c) 2007, Reliable Source, Inc. All Rights Reserved<br>
 * <br>
 * 
 * Created on: Apr 19, 2007 <br>
 * <br>
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 * @since 1.0.0
 */
public class ReliableElementContentProvider extends ArrayContentProvider
		implements ISelectionChangedListener, ITreeContentProvider {

	Object[] EMPTY_OBJECT = new Object[0];

	protected IStructuredSelection currentSelection;

	public void selectionChanged(SelectionChangedEvent event) {
		currentSelection = (IStructuredSelection) event.getSelection();
	}

	/**
	 * Returns the elements in the input, which must be either an array or a
	 * <code>Collection</code>.
	 */
	@Override
	public Object[] getElements(Object _element) {
		if (_element instanceof IReliableNode)
			return ((IReliableNode) _element).getChildren();
		return super.getElements(_element);
	}

	public Object[] getChildren(Object _parentElement) {
		if (_parentElement instanceof IReliableNode)
			return ((IReliableNode) _parentElement).getChildren();
		return EMPTY_OBJECT;
	}

	public Object getParent(Object element) {
		if (element instanceof IReliableElement)
			return ((IReliableElement) element).getParent();
		return EMPTY_OBJECT;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof IReliableNode)
			return ((IReliableNode) element).hasChildren();
		return false;
	}

}
