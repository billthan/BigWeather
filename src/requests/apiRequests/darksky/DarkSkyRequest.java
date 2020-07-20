package requests.apiRequests.darksky;

import requests.GeoRequest;
/*
 * Copyright © 2020, Bill Than
 */
import java.io.FileReader;

public class DarkSkyRequest extends GeoRequest {

	public String key;
	public String URL = "https://api.darksky.net/forecast/";

	/**
	 * 
	 * @return API key for TomTom API
	 */
	public void requestKey() {
		char[] k = new char[34];
		try {
			FileReader fr = new FileReader("src/apiKeys/darksky.txt");
			fr.read(k);
			fr.close();
		} catch (Exception e) {
			System.out.println(
					"No DarkSky API key installed. Please contact the software developer for more information.");
		}

		this.key= new String(k);
	}

}
