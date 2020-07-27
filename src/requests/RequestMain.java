package requests;

import java.io.IOException;

import org.json.JSONException;

import requests.apiRequests.darksky.DarkSkyRequest;
import requests.apiRequests.tomtom.TomTomRequest;

/*
 * Copyright © 2020, Bill Than
 * RequestMain
 */

public class RequestMain {

	public static TomTomRequest t;
	public static DarkSkyRequest d;
	public String input;

	public RequestMain(String input) {
		this.input = input;
		RequestMain.t = new TomTomRequest(this.input);
		RequestMain.d = new DarkSkyRequest();
	}

	public static void main(String args[]) throws JSONException, IOException {
		/**
		 * RequestMain r = new RequestMain("165A Sheldon Avenue");
		 * System.out.println("tomtom " + t.key); System.out.println("darksky " +
		 * d.key);
		 **/

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
