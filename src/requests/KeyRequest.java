package requests;
/*
 * Copyright © 2021, Bill Than
 * KeyRequest 
 */

import java.io.FileReader;

public class KeyRequest {

	public String key;
	public String txtfile;
	public int keylen;

	/**
	 * 
	 * @param keylen, length of key
	 * @param path, path of key
	 */
	public KeyRequest(int keylen, String path) {
		this.keylen = keylen;
		this.txtfile = "src/apiKeys/" + path;
		// requests from key file
		requestKey();
	}

	/**
	 * Reads key from file
	 */
	public void requestKey() {
		char[] k = new char[keylen];
		try {
			FileReader fr = new FileReader(txtfile);
			fr.read(k);
			fr.close();
		} catch (Exception e) {
			// API key failure
			System.out.println("No API key installed at " + this.txtfile
					+ ". Please contact the software developer for more information.");
		}
		//saves key to local key
		this.key = new String(k);
	}

	/**
	 * 
	 * @return key of API
	 */
	public String getKey() {
		return this.key;
	}

}
