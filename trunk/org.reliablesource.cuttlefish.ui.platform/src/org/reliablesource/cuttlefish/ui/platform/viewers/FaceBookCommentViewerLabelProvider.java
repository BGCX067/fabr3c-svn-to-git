package org.reliablesource.cuttlefish.ui.platform.viewers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.reliablesource.cuttlefish.core.model.INode;
import org.reliablesource.model.core.IReliableElement;

/**
 * 
 * ContributorLabelProvider.java<br>
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
public class FaceBookCommentViewerLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		if (element instanceof INode)
			return ((INode) element).getName();
		return super.getText(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(final Object _element) {
		if (_element != null) {
			if (_element instanceof IReliableElement) {
				IReliableElement _elt = (IReliableElement) _element;
				Image _img = null;

				try {
					_img = new Image(Display.getDefault(), _elt.getThumbImage()
							.toURL().openStream());
				} catch (Exception _e) {
					_e.printStackTrace();
				}
				return _img;
			}
		}

		return super.getImage(_element);
	}
}
