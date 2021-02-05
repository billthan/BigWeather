package requests.urlformat;

import java.util.ArrayList;

import requests.KeyRequest;

/*
 * Copyright © 2021, Bill Than
 * TomURL
 */

public class TomURL extends URLAbstract {

	/**
	 * SAMPLE API CALL
	 * https://api.tomtom.com/search/2/geocode/165a%20sheldon%20ave.json?countrySet=CA&key=*****
	 */

	private String flag = "";
	private final String path = "tomtom.txt";
	private final int keyLen = 32;
	private String url = "https://api.tomtom.com/search/2/geocode/";
	private String param = ".json";

	/**
	 * 
	 * @param key
	 * @param input
	 */
	public TomURL(String input, ArrayList<String> flags) {
		super(input);
		this.input = this.input.replaceAll("\\s+", "%20");
		for (String s : flags) {
			this.flag = this.flag + "?" + s;
		}
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
		this.output = this.url + this.input + this.param + this.flag + "&key=" + this.key;
	}

	@Override
	/**
	 * returns output
	 */
	public String getURL() {
		return this.output;
	}

}
