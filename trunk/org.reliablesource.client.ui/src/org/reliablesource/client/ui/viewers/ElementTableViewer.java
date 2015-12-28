package org.reliablesource.client.ui.viewers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

/**
 * 
 * ElementTableViewer.java<br>
 * Copyright (c) 2007, Reliable Source, Inc. All Rights Reserved<br>
 * <br>
 * 
 * Created on: Apr 19, 2007 <br>
 * <br>
 * 
 * @author Dennis Park <a
 *         href="mailto:dennis.park@gmail.com">dennis.park@gmail.com</a>
 * 
 */
abstract public class ElementTableViewer extends ReliableViewer {

	protected Map<String, TreeColumn> COLUMN_MAP;

	public ElementTableViewer() {
		super();
	}

	@Override
	public void createViewerControl(Composite _parent) {
		contentViewer = new TreeViewer(_parent, SWT.FULL_SELECTION
				| SWT.H_SCROLL | SWT.V_SCROLL);
		Tree _content = ((TreeViewer) contentViewer).getTree();
		// TableLayout _layout = new TableLayout();
		// _content.setLayout(_layout);

		Tree _content2 = ((TreeViewer) contentViewer).getTree();
		_content2.addTreeListener(new TreeListener() {

			public void treeCollapsed(TreeEvent e) {
				resizeAndLayout();
			}

			public void treeExpanded(TreeEvent e) {
				resizeAndLayout();
			}

		});

		_content.setHeaderVisible(true);
		_content.setLinesVisible(true);

		String[] _columns = getColumns();
		int _nCols = _columns.length;
		for (int i = 0; i < _nCols; i++) {
			TreeColumn _tblCol = new TreeColumn(_content, SWT.NULL);
			_tblCol.setText(_columns[i]);
			COLUMN_MAP.put(_columns[i], _tblCol);
		}

		contentComposite = _content;
	}

	abstract public String[] getColumns();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.reliablesource.client.ui.viewers.ReliableViewer#init()
	 */
	@Override
	public void init() {
		super.init();
		COLUMN_MAP = new HashMap<String, TreeColumn>();
	}

	public void resizeAndLayout() {
		contentComposite.setRedraw(false);
		Iterator<String> _it = COLUMN_MAP.keySet().iterator();
		while (_it.hasNext()) {
			TreeColumn _col = COLUMN_MAP.get(_it.next());
			_col.pack();

			int _width = _col.getWidth();
			_width += Math.ceil(_width * .3333);
			_col.setWidth(_width);
		}
		contentComposite.layout();
		contentComposite.setRedraw(true);
	}
}
