package requests.apiRequests.tomtom;

import requests.GeoRequest;
/*
 * Copyright © 2020, Bill Than
 */
import java.io.FileReader;
import org.json.JSONObject;

public class TomTomRequest extends GeoRequest {

	public String key;
	public String URL = "https://api.tomtom.com/search/2/geocode/";
	public String input;

	/**
	 * @Override string input for location
	 * @param input: string input for location
	 */
	public TomTomRequest(String input) {
		this.input = input;
		requestKey();
	}

	/**
	 * @return API key for TomTom API
	 */
	public void requestKey() {
		char[] k = new char[32];
		try {
			FileReader fr = new FileReader("src/apiKeys/tomtom.txt");
			fr.read(k);
			fr.close();
		} catch (Exception e) {
			System.out.println(
					"No TomTom API key installed. Please contact the software developer for more information.");
		}
		this.key = new String(k);
	}
	
	public JSONObject requestObject () {
		return new JSONObject();
	}

}
