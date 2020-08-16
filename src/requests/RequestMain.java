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

	/**
	 * 
	 * @param input
	 * @throws Exception
	 */
	public RequestMain(String input, String path) throws Exception {
		this.input = input;
		this.path = path;
		request();
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private boolean request() throws Exception {
		String url = getURL();

		try {
			//create new URL
			// HTMLRequest h = new HTMLRequest(url);
			HTMLRequest h = new HTMLRequest(
					"https://api.darksky.net/forecast/54014a5f81c8b8d34fb16a5f669ba9f1/37.8267,-122.4233"); 
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
		//requests new URL based on path type.
		switch (this.path) {
		case "darksky.txt":
			DarkSkyURL ds = new DarkSkyURL(this.input);
			ret = ds.getURL();
			break;
		case "tomtom.txt":
			TomURL tt = new TomURL(this.input);
			ret = tt.getURL();
			break;
		}
		return ret;
	}

}
