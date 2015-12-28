package org.reliablesource.cuttlefish.ui.platform.perspectives;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.reliablesource.cuttlefish.ui.platform.views.GroupsView;
import org.reliablesource.cuttlefish.ui.platform.views.View;
import org.reliablesource.cuttlefish.ui.platform.views.WallView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		layout.setFixed(false);

		layout.addView(View.ID, IPageLayout.LEFT, 1.0f,
				editorArea);
		layout.addView(WallView.ID, IPageLayout.BOTTOM, 1.0f,
				editorArea);	
		
		layout.addView(GroupsView.ID, IPageLayout.BOTTOM, 1.0f,
				editorArea);	
	}

}
