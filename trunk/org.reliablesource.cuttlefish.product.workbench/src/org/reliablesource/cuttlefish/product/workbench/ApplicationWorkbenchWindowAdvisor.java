package org.reliablesource.cuttlefish.product.workbench;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public static final String SECRET = "54afce5c860ef71fe98f06fa7d0cf570";
	public static final String API_KEY = "80b929a726d414fa1d5b604e67a3858f";

	public ApplicationWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	@Override
	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	@Override
	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(800, 600));
		configurer.setShowCoolBar(true);
		configurer.setShowStatusLine(true);
		configurer.setShowPerspectiveBar(true);

		configurer.setShowFastViewBars(true);

	}

	protected void login() throws Exception {

		// // desktop = 1
		// client = new FacebookRestClient(API_KEY, SECRET);
		// client.setIsDesktop(true);
		//
		// // uncomment the line below to get details of each request and
		// respnse
		// // printed to System.out.
		// client.setDebug(true);
		//
		// String auth = client.auth_createToken();
		// BrowserLauncher browserLauncher = new BrowserLauncher(null);
		// browserLauncher
		// .openURLinBrowser("http://www.facebook.com/login.php?v=1.0"
		// + "&api_key=" + API_KEY + "&auth_token=" + auth);
		// // System.out.println("hit enter after you have logged into FB");
		// // System.in.read();
		// // Thread.sleep(5000); // in ms
		//
		// client.auth_getSession(auth);
	}

	@Override
	public void postWindowOpen() {
		super.postWindowOpen();
		// try {
		// login();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}
}
