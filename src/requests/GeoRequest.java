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

	public GeoRequest(int keylen, String[] str) {
		this.keylen = keylen;
		this.URL = str[0];
		this.txtfile = "src/apiKeys/"+ str[1];
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
			System.out.println(
					"No API key installed at " + this.txtfile + ". Please contact the software developer for more information.");
		}

		this.key= new String(k);
	}
	
	/**
	 * 
	 * @return key of API
	 */
	public String getKey() {
		return this.key;
	}
	

}
