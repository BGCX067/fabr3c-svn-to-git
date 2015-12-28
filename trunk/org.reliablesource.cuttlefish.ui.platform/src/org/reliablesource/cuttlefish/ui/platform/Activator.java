package org.reliablesource.cuttlefish.ui.platform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.reliablesource.cuttlefish.core.model.EntityFactory;
import org.reliablesource.cuttlefish.core.model.IEntityFactory;
import org.reliablesource.cuttlefish.core.model.INode;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import edu.stanford.ejalbert.BrowserLauncher;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.reliablesource.cuttlefish.ui.platform";

	// The shared instance
	private static Activator plugin;

	static private FacebookRestClient client;

	static private boolean loggedIn = false;

	/**
	 * The constructor
	 */
	public Activator() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	static public void login() {
		String SECRET = "54afce5c860ef71fe98f06fa7d0cf570";
		String API_KEY = "80b929a726d414fa1d5b604e67a3858f";
		// desktop = 1
		client = new FacebookRestClient(API_KEY, SECRET);
		client.setIsDesktop(true);

		// uncomment the line below to get details of each request and respnse
		// printed to System.out.
		client.setDebug(true);
		try {
			String auth = client.auth_createToken();
			// URL _url = new
			// URL("http://www.facebook.com/login.php?v=1.0&api_key="
			// + API_KEY + "&auth_token=" + auth);
			BrowserLauncher browserLauncher = new BrowserLauncher(null);
			browserLauncher
					.openURLinBrowser("http://www.facebook.com/login.php?v=1.0&api_key="
							+ API_KEY + "&auth_token=" + auth);
			// browserLauncher
			// .openURL("http://www.facebook.com/login.php?v=1.0&api_key="
			// + API_KEY + "&auth_token=" + auth);
			System.out.println("hit enter after you have logged into FB");
			System.in.read();
			client.auth_getSession(auth);
			loggedIn = true;
		} catch (Exception _e) {

		}
	}

	static public List<INode> getUsers() throws Exception {

		if (!loggedIn)
			login();

		Document d = null;
		d = client.friends_get();

		List<Integer> _uids = FacebookRestClient.getResultsCollection(d);
		Set<CharSequence> _fields = new HashSet<CharSequence>();
		int _nFields = ProfileField.values().length;

		// Create the request specs
		for (int i = 0; i < _nFields; i++) {
			CharSequence _seq = ProfileField.values()[i].fieldName();
			if (_seq.equals("first_name") || _seq.equals("last_name")
					|| _seq.equals("pic_square"))
				_fields.add(_seq);
		}

		// Invoke data service - fetch.
		d = client.users_getInfo(_uids, _fields);

		IEntityFactory entityFactory = (IEntityFactory) EntityFactory
				.getInstance();

		// Transform raw data to objects.
		NodeList _list = d.getElementsByTagName("user");
		int nNodes = _list.getLength();
		INode _user = null;
		String _firstName = "";
		String _lastName = "";
		String _image = "";
		String _uid = "";
		List _userList = new ArrayList();

		for (int i = 0; i < nNodes; i++) {
			NodeList _attrList = _list.item(i).getChildNodes();
			int nAttr = _attrList.getLength();
			for (int j = 0; j < nAttr; j++) {
				String _attribute = _attrList.item(j).getNodeName();
				NodeList _attrVal = _attrList.item(j).getChildNodes();
				String _value = "";
				if (_attrVal.getLength() > 0)
					_value = _attrVal.item(0).getNodeValue();

				if (_attribute.equals("uid")) {
					_uid = _value;
				} else if (_attribute.equals(ProfileField.PIC_SQUARE
						.fieldName())) {

					_image = _value;
				} else if (_attribute
						.equals(ProfileField.LAST_NAME.fieldName())) {
					_lastName = _value;
				} else if (_attribute.equals(ProfileField.FIRST_NAME
						.fieldName())) {
					_firstName = _value;
				}
			}
			_user = entityFactory
					.createNode(_uid, _firstName + " " + _lastName);
			if (!_image.equals(""))
				_user.setThumbImage(_image);

			_userList.add(_user);
		}

		return _userList;
	}

	static public List<INode> getComments() throws Exception {

		if (!loggedIn)
			login();

		Document d = null;
		d = client.friends_get();

		List<Integer> _uids = FacebookRestClient.getResultsCollection(d);
		Set<CharSequence> _fields = new HashSet<CharSequence>();
		int _nFields = ProfileField.values().length;

		// Create the request specs
		for (int i = 0; i < _nFields; i++) {
			CharSequence _seq = ProfileField.values()[i].fieldName();
			// if (_seq.equals("first_name") || _seq.equals("last_name")
			// || _seq.equals("pic_square"))
			_fields.add(_seq);
		}

		// Invoke data service - fetch.
		d = client.users_getInfo(_uids, _fields);

		IEntityFactory entityFactory = (IEntityFactory) EntityFactory
				.getInstance();

		// Transform raw data to objects.
		// NodeList _list = d.getElementsByTagName("user");
		// int nNodes = _list.getLength();
		// INode _user = null;
		// String _firstName = "";
		// String _lastName = "";
		// String _image = "";
		// String _uid = "";
		List<INode> _userList = new ArrayList<INode>();
		//
		// for (int i = 0; i < nNodes; i++) {
		// NodeList _attrList = _list.item(i).getChildNodes();
		// int nAttr = _attrList.getLength();
		// for (int j = 0; j < nAttr; j++) {
		// String _attribute = _attrList.item(j).getNodeName();
		// NodeList _attrVal = _attrList.item(j).getChildNodes();
		// String _value = "";
		// if (_attrVal.getLength() > 0)
		// _value = _attrVal.item(0).getNodeValue();
		//
		// if (_attribute.equals("uid")) {
		// _uid = _value;
		// } else if (_attribute.equals(ProfileField.PIC_SQUARE.fieldName())) {
		//					
		// _image = _value;
		// } else if (_attribute.equals(ProfileField.LAST_NAME.fieldName())) {
		// _lastName = _value;
		// } else if (_attribute.equals(ProfileField.FIRST_NAME.fieldName())) {
		// _firstName = _value;
		// }
		// }
		// _user = entityFactory
		// .createNode(_uid, _firstName + " " + _lastName);
		// if (!_image.equals(""))
		// _user.setThumbImage(_image);
		//
		// _userList.add(_user);
		// }

		return _userList;
	}

	static public List<INode> getGroups() throws Exception {

		if (!loggedIn)
			login();

		Document d = null;
		d = client.groups_get(client.users_getLoggedInUser(), null);

		// List<Integer> _uids = FacebookRestClient.getResultsCollection(d);
		// Set<CharSequence> _fields = new HashSet<CharSequence>();
		// int _nFields = ProfileField.values().length;
		//
		// // Create the request specs
		// for (int i = 0; i < _nFields; i++) {
		// CharSequence _seq = ProfileField.values()[i].fieldName();
		// // if (_seq.equals("first_name") || _seq.equals("last_name")
		// // || _seq.equals("pic_square"))
		// _fields.add(_seq);
		// }
		//
		// // Invoke data service - fetch.
		// d = client.users_getInfo(_uids, _fields);
		//
		// IEntityFactory entityFactory = (IEntityFactory) EntityFactory
		// .getInstance();

		// Transform raw data to objects.
		// NodeList _list = d.getElementsByTagName("user");
		// int nNodes = _list.getLength();
		// INode _user = null;
		// String _firstName = "";
		// String _lastName = "";
		// String _image = "";
		// String _uid = "";
		List<INode> _userList = new ArrayList<INode>();
		//
		// for (int i = 0; i < nNodes; i++) {
		// NodeList _attrList = _list.item(i).getChildNodes();
		// int nAttr = _attrList.getLength();
		// for (int j = 0; j < nAttr; j++) {
		// String _attribute = _attrList.item(j).getNodeName();
		// NodeList _attrVal = _attrList.item(j).getChildNodes();
		// String _value = "";
		// if (_attrVal.getLength() > 0)
		// _value = _attrVal.item(0).getNodeValue();
		//
		// if (_attribute.equals("uid")) {
		// _uid = _value;
		// } else if (_attribute.equals(ProfileField.PIC_SQUARE.fieldName())) {
		//					
		// _image = _value;
		// } else if (_attribute.equals(ProfileField.LAST_NAME.fieldName())) {
		// _lastName = _value;
		// } else if (_attribute.equals(ProfileField.FIRST_NAME.fieldName())) {
		// _firstName = _value;
		// }
		// }
		// _user = entityFactory
		// .createNode(_uid, _firstName + " " + _lastName);
		// if (!_image.equals(""))
		// _user.setThumbImage(_image);
		//
		// _userList.add(_user);
		// }

		return _userList;
	}

}
