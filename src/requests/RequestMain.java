package requests;

import java.io.IOException;

import org.json.JSONException;

/*
 * Copyright © 2020, Bill Than
 * RequestMain
 */

public class RequestMain {

	/**
	 * WILL ADD TO CONFIGURATION TXT
	 */
	private final static String[] DSURL = { "https://api.darksky.net/forecast/", "darksky.txt" };
	private final String[] TTURL = { "https://api.tomtom.com/search/2/geocode/", "tomtom.txt" };

	private final int TTchar = 32;
	private final static int DSchar = 34;

	// internal current setting
	private String input;
	private String APIKey;
	private String path;

	/**
	 * 
	 * @param input
	 * @throws Exception
	 */
	public RequestMain(String input, String path) throws Exception {
		this.path = path;
		this.input = input;
		this.APIKey = retKey();
		request();
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private boolean request() throws Exception {
		try {
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
	 * checks for key type
	 * 
	 * @throws Exception
	 */
	private String retKey() throws Exception {
		KeyRequest key = null;
		if (this.path.equalsIgnoreCase("darksky")) {
			key = new KeyRequest(DSchar, DSURL);
		} else if (this.path.equalsIgnoreCase("tomtom")) {
			key = new KeyRequest(TTchar, TTURL);
		} else {
			throw new Exception("Could not find any Keys for specified path. Contact your developer.");
		}
		return key.getKey();
	}

}
