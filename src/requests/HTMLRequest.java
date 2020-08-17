package requests;

import com.google.gson.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Copyright © 2020, Bill Than
 * HTMLRequest
 */

public class HTMLRequest {

	// connection establishment
	public HttpURLConnection con;
	public JsonObject result = null;

	/**
	 * 
	 * @param url
	 * @throws Exception 
	 */
	public HTMLRequest(String url) throws Exception {
		// opens new URL Request
		URL urlObj = new URL(url);
		this.con = (HttpURLConnection) urlObj.openConnection();
		// optional default is GET
		this.con.setRequestMethod("GET");
		// add request header
		this.con.setRequestProperty("User-Agent", "Mozilla/5.0");

		this.result = getJSON();
		//prints pretty result
		//printPretty(result);
	}

	/**
	 * 
	 * @return JSONObject of the returned request
	 * @throws Exception 
	 */
	public JsonObject getJSON() throws Exception {
		 JsonObject jsonObject = null;

		try {	
			errorCode(con.getResponseCode());
			System.out.println("Getting JSON");
			String json = getBuffer().toString();
			jsonObject = new Gson().fromJson(json, JsonObject.class);
		} catch (Exception e) {
			System.out.println("There was an error with parsing the API JSON data.");
			e.printStackTrace();
		}
		if (jsonObject != null) {
		return jsonObject;
		}
		throw new Exception("JSON Object could not be created. Please contact the developer with this error.");
	}

	/**
	 * 
	 * @return bufferString of the input
	 * @throws IOException
	 */
	public String getBuffer() throws IOException {
		StringBuffer response = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}

	/**
	 * Throws new exception if code 200 not returned
	 * @param e, code for API request
	 * @throws Exception ,
	 */
	private void errorCode(int e) throws Exception {
		System.out.println("Code " + e);
		if (e != 200) {
			throw new Exception("An error code " + e + " was thrown");
		}
	}
	
	/**
	 * prints out a pretty version of the JsonObject using Gson library
	 * @param j
	 */
	@SuppressWarnings("unused")
	private void printPretty(JsonObject j) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
	    System.out.println(gson.toJson(j));
	}
	
	/**
	 * 
	 * @return Object of JSON
	 */
	public JsonObject retJSON() {
		return this.result;
	}


}