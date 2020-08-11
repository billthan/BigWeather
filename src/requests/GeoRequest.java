package requests;
/*
 * Copyright © 2020, Bill Than
 * GeoRequest abstract
 */

import java.io.FileReader;

public class GeoRequest {

	public String key;
	public String URL;
	public String txtfile;
	public int keylen;

	/**
	 * 
	 * @param keylen, length of key
	 * @param str,    str[0]: path of key; str[1] key URL call
	 */
	public GeoRequest(int keylen, String[] str) {
		this.keylen = keylen;
		this.URL = str[0];
		this.txtfile = "src/apiKeys/" + str[1];
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
