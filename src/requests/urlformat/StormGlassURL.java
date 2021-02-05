package requests.urlformat;

import java.util.ArrayList;

import requests.*;

/*
 * Copyright © 2021, Bill Than
 * DarkSkyURL
 */

public class StormGlassURL extends URLAbstract {

	/**
	 * SAMPLE API CALL
	 * https://api.stormglass.io/v2/weather/point?lat=58.7984&lng=17.8081&params=waveHeight,airTemperature&source=noaa&key=8d81c360-4e23-11eb-a422-0242ac130002-8d81c40a-4e23-11eb-a422-0242ac130002
	 */
	private String flag = "";
	private final String path = "stormglass.txt";
	private final int keyLen = 73;
	private String url = "https://api.stormglass.io/v2/weather/point?source=noaa&";

	/**
	 * 
	 * @param key
	 * @param input
	 */
	public StormGlassURL(String input, ArrayList<String> flags) {
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
		return ("key=" + k.getKey());
	}

	@Override
	/**
	 * Concatenates key to URL and input
	 */
	public void parseURL() {
		this.input = this.input.trim();
		String[] points = this.input.split("\\s*[,]\\s*");
		this.output = this.url + "lat=" + points[0] + "&lng=" + points[1] + this.flag + "&" + this.key;
	}

	@Override
	/**
	 * returns output
	 */
	public String getURL() {
		return this.output;
	}

}
