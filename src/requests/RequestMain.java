package requests;

import requests.urlformat.*;

import java.util.ArrayList;

import com.google.gson.JsonObject;

/*
 * Copyright © 2021, Bill Than
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
		this.url = getURL(null);
		request();
	}

	public RequestMain(String input, String path, ArrayList<String> flags) throws Exception {
		this.input = input;
		this.path = path;
		this.url = getURL(flags);
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
	private String getURL(ArrayList<String> flags) {
		String ret = null;
		// requests new URL based on path type.
		switch (this.path) {
		case "tomtom.txt":
			TomURL tt = new TomURL(this.input, flags);
			ret = tt.getURL();
			break;
		case "ip.txt":
			IPURL ip = new IPURL(this.input);
			ret = ip.getURL();
			break;
		case "stormglass.txt":
			StormGlassURL sg = new StormGlassURL(this.input, flags);
			ret = sg.getURL();
		}
		System.out.println("Requested JSON at " + ret);
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
