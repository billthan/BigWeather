package requests.urlformat;

import requests.KeyRequest;

/*
 * Copyright © 2020, Bill Than
 * TomURL
 */

public class TomURL extends URLAbstract {

	/**
	 * SAMPLE API CALL
	 * https://api.tomtom.com/search/2/geocode/165a%20sheldon%20ave.json?countrySet=CA&key=*****
	 */

	private final String path = "tomtom.txt";
	private final int keyLen = 32;
	private String url = "https://api.tomtom.com/search/2/r/";
	private String param = ".json?limit=5&countrySet=CA&";

	/**
	 * 
	 * @param key
	 * @param input
	 */
	public TomURL(String input) {
		super(input);
		this.input = this.input.replaceAll("\\s+", "%20");
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
		this.output = url.concat(input).concat(param).concat("key=").concat(key);
	}

	@Override
	/**
	 * returns output
	 */
	public String getURL() {
		return this.output;
	}

}
