package requests.tomtom;

import requests.GeoRequest;
/*
 * Copyright © 2020, Bill Than
 */
import java.io.FileReader;

public class TomTomRequest extends GeoRequest {

	public String key;
	public String URL = "https://api.tomtom.com/search/2/geocode/";

	/**
	 * 
	 * @return API key for TomTom API
	 */
	public String requestKey() {
		char[] k = new char[32];
		try {
			FileReader fr = new FileReader("src/apiKeys/tomtom.txt");
			fr.read(k);
			fr.close();
		} catch (Exception e) {
			System.out.println("Something went wrong.");
		}

		return new String(k);
	}

}
