package requests;

import requests.urlformat.*;
import com.google.gson.JsonObject;

/*
 * Copyright © 2020, Bill Than
 * RequestMain
 */

public class RequestMain {
	// internal current setting
	private String input;
	private String path;
	private String url;
	private JsonObject obj;

	/**
	 * 
	 * @param input
	 * @throws Exception
	 */
	public RequestMain(String input, String path) throws Exception {
		this.input = input;
		this.path = path;
		this.url = getURL();
		request();
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private void request() throws Exception {
		HTMLRequest h = new HTMLRequest(this.url);
		this.obj = h.retJSON();
	}

	/**
	 * 
	 * @return String URL
	 */
	private String getURL() {
		String ret = null;
		// requests new URL based on path type.
		switch (this.path) {
		case "darksky.txt":
			DarkSkyURL ds = new DarkSkyURL(this.input);
			ret = ds.getURL();
			System.out.println("Requested JSON at " + ret);
			break;
		case "tomtom.txt":
			TomURL tt = new TomURL(this.input);
			ret = tt.getURL();
			System.out.println("Requested JSON at " + ret);
			break;
		case "ip.txt":
			IPURL ip = new IPURL(this.input);
			ret = ip.getURL();
			System.out.println("Requested JSON at " + ret);
			break;
		}
		return ret;
	}

	/**
	 * 
	 * @return obj of json
	 */
	public JsonObject getJson() {
		return this.obj;
	}

}
