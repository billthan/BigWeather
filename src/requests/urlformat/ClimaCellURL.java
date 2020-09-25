package requests.urlformat;

import java.util.ArrayList;

import requests.*;

/*
 * Copyright © 2020, Bill Than
 * DarkSkyURL
 */

public class ClimaCellURL extends URLAbstract {

	/**
	 * SAMPLE API CALL
	 * https://api.climacell.co/v3/weather/realtime?lat=42.30&lon=-71.17&unit_system=si&fields=wind_gust&apikey=APIKEY
	 */
	private String flag = "";
	private final String path = "climacell.txt";
	private final int keyLen = 32;
	private String url = "https://api.climacell.co/v3/weather/realtime?";

	/**
	 * 
	 * @param key
	 * @param input
	 */
	public ClimaCellURL(String input, ArrayList<String> flags) {
		super(input);
		for (String s : flags) {
			System.out.println("FLAG " + s);
			this.flag = this.flag + "&" + s;
		}
		parseURL();
	}

	@Override
	/**
	 * returns key by using KeyRequest
	 */
	public String getKey() {
		KeyRequest k = new KeyRequest(this.keyLen, this.path);
		return ("apikey=" + k.getKey());
	}

	@Override
	/**
	 * Concatenates key to URL and input
	 */
	public void parseURL() {
		this.input = this.input.trim();
		String[] points = this.input.split("\\s*[,]\\s*");
		this.output = this.url + "lat=" + points[0] + "&lon=" + points[1] + this.flag + "&" + this.key;
	}

	@Override
	/**
	 * returns output
	 */
	public String getURL() {
		return this.output;
	}

}
