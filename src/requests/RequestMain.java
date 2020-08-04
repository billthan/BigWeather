package requests;

import java.io.IOException;

import org.json.JSONException;



/*
 * Copyright © 2020, Bill Than
 * RequestMain
 */

public class RequestMain {

	public final String[] DSURL = { "https://api.darksky.net/forecast/", "darksky.txt" };
	public final String[] TTURL = { "https://api.tomtom.com/search/2/geocode/", "tomtom.txt" };
	public final int TTchar = 32;
	public final int DSchar = 34;
	public static GeoRequest g;

	public String input;

	public RequestMain(String input) {
		this.input = input;
		RequestMain.g = new GeoRequest(DSchar, DSURL);
		System.out.println("getting Key");

	}

	public static void main(String args[]) throws Exception {

		RequestMain r = new RequestMain("165A Sheldon Avenue");
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
