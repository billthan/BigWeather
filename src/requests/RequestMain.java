package requests;

import requests.urlformat.*;
import java.io.IOException;
import org.json.JSONException;

/*
 * Copyright � 2020, Bill Than
 * RequestMain
 */

public class RequestMain {
	// internal current setting
	private String input;
	private String path;
	private String url;

	/**
	 * 
	 * @param input
	 * @throws Exception
	 */
	public RequestMain(String input, String path) throws Exception {
		this.input = input;
		this.path = path;
		this.url = getURL();
		request(this.url);
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private boolean request(String url) throws Exception {
		try {
			HTMLRequest h = new HTMLRequest(url);
		} catch (JSONException e) {
			System.out.println("JSON Exception Error, contact the developer.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception Error, contact the developer.");
			e.printStackTrace();
		}
		return true;
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
		}
		return ret;
	}

}
