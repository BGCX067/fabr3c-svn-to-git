/*
  +---------------------------------------------------------------------------+
  | Facebook Development Platform Java Client                                 |
  +---------------------------------------------------------------------------+
  | Copyright (c) 2007 Facebook, Inc.                                         |
  | All rights reserved.                                                      |
  |                                                                           |
  | Redistribution and use in source and binary forms, with or without        |
  | modification, are permitted provided that the following conditions        |
  | are met:                                                                  |
  |                                                                           |
  | 1. Redistributions of source code must retain the above copyright         |
  |    notice, this list of conditions and the following disclaimer.          |
  | 2. Redistributions in binary form must reproduce the above copyright      |
  |    notice, this list of conditions and the following disclaimer in the    |
  |    documentation and/or other materials provided with the distribution.   |
  |                                                                           |
  | THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR      |
  | IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES |
  | OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.   |
  | IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,          |
  | INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT  |
  | NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, |
  | DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY     |
  | THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT       |
  | (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF  |
  | THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.         |
  +---------------------------------------------------------------------------+
  | For help with this library, contact developers-help@facebook.com          |
  +---------------------------------------------------------------------------+
 */

package org.reliablesource.cuttlefish.ui.platform;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.w3c.dom.Document;

import edu.stanford.ejalbert.BrowserLauncher;
import edu.stanford.ejalbert.exception.BrowserLaunchingExecutionException;
import edu.stanford.ejalbert.exception.BrowserLaunchingInitializingException;
import edu.stanford.ejalbert.exception.UnsupportedOperatingSystemException;

public class ExampleClient {
	public static final String CONFIG_FILE = "settings.conf";
	public static final String REPLACE_MESSAGE = "Please enter both your API key and secret in the "
			+ CONFIG_FILE
			+ " configuration file. Your API key and secret can be found at "
			+ "http://developers.facebook.com/account.php";

	/**
	 * Test main method, just try to get an auth token, which doesn't require a
	 * web browser for the user to log in or anything.
	 */
	public static void main(String[] args) throws Exception {
		FacebookRestClient client;
		FileInputStream fis = new FileInputStream(CONFIG_FILE);
		Properties props = new Properties();
		props.load(fis);

		String api_key = props.getProperty("api_key");
		String secret = props.getProperty("secret");
		if ("<your_api_key>".equals(api_key) || "<your_secret>".equals(secret)) {
			System.out.println(REPLACE_MESSAGE);
		}

		client = new FacebookRestClient(props.getProperty("api_key"), props
				.getProperty("secret"));
		String desktop = props.getProperty("desktop");
		if (null != desktop && !"0".equals(desktop))
			client.setIsDesktop(true);

		// uncomment the line below to get details of each request and respnse
		// printed to System.out.
		client.setDebug(true);

		String auth = client.auth_createToken();
		BrowserLauncher browserLauncher = new BrowserLauncher(null);
		browserLauncher.openURLinBrowser(props.getProperty("login_url")
				+ "&api_key=" + props.getProperty("api_key") + "&auth_token="
				+ auth);
		// System.out.println("hit enter after you have logged into FB");
		// System.in.read();
		// Thread.sleep(5000); // in ms

		client.auth_getSession(auth);

		// get friends - uid list
		Document d = client.friends_get();
		// FacebookRestClient.printDom(d, " ");

		List<Integer> _uids = FacebookRestClient.getResultsCollection(d);
		Set<CharSequence> _fields = new HashSet<CharSequence>();
		int _nFields = ProfileField.values().length;
		for (int i = 0; i < _nFields; i++) {
			CharSequence _seq = ProfileField.values()[i].fieldName();
			_fields.add(_seq);

		}

		// get friends' entity info
		d = client.users_getInfo(_uids, _fields);

		// FacebookRestClient.printDom(d, " ");

	}

	protected void login() throws FileNotFoundException, IOException,
			FacebookException, BrowserLaunchingInitializingException,
			BrowserLaunchingExecutionException,
			UnsupportedOperatingSystemException {

	}
}
