package org.reliablesource.client.ui.viewers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.reliablesource.model.core.IDisposable;

/**
 * 
 * ReliableViewer.java<br>
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
abstract public class ReliableViewer extends ContentViewer implements
		IReliableViewer {

	protected ContentViewer contentViewer;
	protected List<ContentViewer> children;
	protected Composite contentComposite;
	protected StructuredSelection currentSelection = StructuredSelection.EMPTY;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.Viewer#getControl()
	 */
	@Override
	public Control getControl() {
		return contentComposite;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.Viewer#getSelection()
	 */
	@Override
	public ISelection getSelection() {
		return currentSelection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.Viewer#refresh()
	 */
	@Override
	public void refresh() {
		contentViewer.refresh();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.Viewer#setSelection(org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setSelection(ISelection _selection) {
		setSelection(_selection, false);
	}

	public void init() {
		children = new LinkedList<ContentViewer>();
	}

	abstract public void createViewerControl(Composite _parent);

	/**
	 * @return the children
	 */
	public Viewer[] getChildren() {
		return children.toArray(new Viewer[children.size()]);
	}

	public boolean addChild(ContentViewer _child) {
		if (null != _child)
			if (!children.contains(_child))
				return children.add(_child);
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.Viewer#setSelection(org.eclipse.jface.viewers.ISelection,
	 *      boolean)
	 */
	@Override
	public void setSelection(ISelection _selection, boolean _reveal) {
		if (null == _selection)
			_selection = StructuredSelection.EMPTY;

		if (_selection.equals(currentSelection))
			return;

		currentSelection = (StructuredSelection) _selection;
		contentViewer.setSelection(currentSelection, _reveal);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 */
	public void dispose() {
		Iterator<ContentViewer> _it = children.iterator();
		while (_it.hasNext()) {
			Viewer _child = _it.next();
			if (_child instanceof IDisposable)
				((IDisposable) _child).dispose();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.reliablesource.client.ui.viewers.IReliableViewer#getContentViewer()
	 */
	public Viewer getContentViewer() {
		return contentViewer;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ContentViewer#setContentProvider(org.eclipse.jface.viewers.IContentProvider)
	 */
	@Override
	public void setContentProvider(IContentProvider contentProvider) {
		super.setContentProvider(contentProvider);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ContentViewer#setLabelProvider(org.eclipse.jface.viewers.IBaseLabelProvider)
	 */
	@Override
	public void setLabelProvider(IBaseLabelProvider labelProvider) {
		super.setLabelProvider(labelProvider);
	}
}
