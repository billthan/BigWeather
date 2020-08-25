package requests.urlformat;

import requests.*;

/*
 * Copyright © 2020, Bill Than
 * DarkSkyURL
 */

public class DarkSkyURL extends URLAbstract {
	
	/** SAMPLE API CALL
	 * https://api.darksky.net/forecast/54014a5f81c8b8d34fb16a5f669ba9f1/37.8267,-122.4233
	 */
	
	private final String path = "darksky.txt";
	private final int keyLen = 32;
	private String url = "https://api.darksky.net/forecast/";

	/**
	 * 
	 * @param key
	 * @param input
	 */
	public DarkSkyURL(String input) {
		super(input);
		parseURL();
	}

	@Override
	/**
	 * returns key by using KeyRequest
	 */
	public String getKey() {
		KeyRequest k = new KeyRequest(this.keyLen, this.path);
		return k.getKey();
	}

	@Override
	/**
	 * Concatenates key to URL and input
	 */
	public void parseURL() {
		this.output = url.concat(key).concat("/").concat(input.trim()).concat("/");
	}

	@Override
	/**
	 * returns output
	 */
	public String getURL() {
		return this.output;
	}

}
