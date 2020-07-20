package requests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Copyright © 2020, Bill Than
 * RequestMain
 */

public class htmlRequest {

	public String url;

	public htmlRequest(String url) {
		this.url = url;
	}

	public void getJSON() {
		try {

			URL urlObj = new URL(this.url);
			HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");
			// add request header
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			
			/**
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);			
			**/
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));			
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

		} catch (Exception e) {
			System.out.println("There was an error with parsing the API JSON data.");
			e.printStackTrace();
		}
	}

}
