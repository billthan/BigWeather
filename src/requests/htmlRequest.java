package requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

/*
 * Copyright © 2020, Bill Than
 * HTMLRequest
 */

public class HTMLRequest {
	
	//connection establishment
	public HttpURLConnection con;

	/**
	 * 
	 * @param url
	 * @throws JSONException
	 * @throws IOException
	 */
	public HTMLRequest(String url) throws JSONException, IOException {
		// opens new URL Request
		URL urlObj = new URL(url);
		this.con = (HttpURLConnection) urlObj.openConnection();
		// optional default is GET
		this.con.setRequestMethod("GET");
		// add request header
		this.con.setRequestProperty("User-Agent", "Mozilla/5.0");

		getJSON();
	}

	/**
	 * 
	 * @return JSONObject of the returned request
	 * @throws JSONException
	 */
	public JSONObject getJSON() throws JSONException {
		try {
			errorCode(con.getResponseCode());
			getBuffer();
		} catch (Exception e) {
			System.out.println("There was an error with parsing the API JSON data.");
			e.printStackTrace();
		}
		// this.response.toString()
		return new JSONObject();

	}

	/**
	 * 
	 * @return bufferString of the input
	 * @throws IOException
	 */
	public StringBuffer getBuffer() throws IOException {
		StringBuffer response = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response;
	}

	/**
	 * 
	 * @param e, code for API request
	 * @throws Exception ,
	 */
	private void errorCode(int e) throws Exception {
		if (e != 200) {
			throw new Exception("An error code " + e + " was thrown");
		}
	}

}
