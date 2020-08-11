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
	
	//internal current setting
	public final String[] curr;
	public final int currKey;
	public String input;
	public String path;

	/**
	 * 
	 * @param input
	 * @throws Exception 
	 */
	public RequestMain(String input, String path) throws Exception {
		//checks for the current setting
		if (path.equalsIgnoreCase("darksky"))  {
			currKey = DSchar;
			this.curr = DSURL;
		}
		else if (path.equalsIgnoreCase("tomtom")) {
				currKey = TTchar;
				this.curr = TTURL;
		}
		else {
			throw new Exception("Undefined path type. Please contact your developer");
		}
		this.path = path;
		this.input = input;
	}

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {

		RequestMain r = new RequestMain("165A Sheldon Avenue", "darksky");

		GeoRequest g = new GeoRequest(DSchar, DSURL);
		System.out.println("getting Key");
		System.out.println(g.getKey());
		try {
			HTMLRequest h = new HTMLRequest(
					"https://api.darksky.net/forecast/54014a5f81c8b8d34fb16a5f669ba9f1/37.8267,-122.4233");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
