package org.reliablesource.cuttlefish.product.workbench;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	// Actions - important to allocate these only in makeActions, and then use
	// them
	// in the fill methods. This ensures that the actions aren't recreated
	// when fillActionBars is called with FILL_PROXY.
	private IWorkbenchAction exitAction;
	private IWorkbenchAction aboutAction;
	private IWorkbenchAction openPerspectiveAction;
	private IWorkbenchAction showViewAction;
	private IWorkbenchAction resetPerspectiveAction;
	private IWorkbenchAction closePerspectiveAction;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	@Override
	protected void makeActions(final IWorkbenchWindow window) {
		// Creates the actions and registers them.
		// Registering is needed to ensure that key bindings work.
		// The corresponding commands keybindings are defined in the plugin.xml
		// file.
		// Registering also provides automatic disposal of the actions when
		// the window is closed.

		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);

		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);

		showViewAction = ActionFactory.SHOW_VIEW_MENU.create(window);
		register(showViewAction);

		openPerspectiveAction = ActionFactory.OPEN_PERSPECTIVE_DIALOG
				.create(window);
		register(openPerspectiveAction);

		resetPerspectiveAction = ActionFactory.RESET_PERSPECTIVE.create(window);
		register(resetPerspectiveAction);

		closePerspectiveAction = ActionFactory.CLOSE_PERSPECTIVE.create(window);
		register(closePerspectiveAction);
	}

	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager fileMenu = new MenuManager("&File",
				IWorkbenchActionConstants.M_FILE);
		fileMenu.add(exitAction);
		menuBar.add(fileMenu);

		MenuManager editMenu = new MenuManager("&Edit",
				IWorkbenchActionConstants.M_EDIT);
		editMenu.add(exitAction);
		menuBar.add(editMenu);

		MenuManager windowMenu = new MenuManager("&Window",
				IWorkbenchActionConstants.M_WINDOW);
		windowMenu.add(showViewAction);
		windowMenu.add(openPerspectiveAction);
		windowMenu.add(resetPerspectiveAction);
		windowMenu.add(closePerspectiveAction);
		menuBar.add(windowMenu);

		MenuManager helpMenu = new MenuManager("&Help",
				IWorkbenchActionConstants.M_HELP);
		helpMenu.add(aboutAction);
		menuBar.add(helpMenu);

	}

}
