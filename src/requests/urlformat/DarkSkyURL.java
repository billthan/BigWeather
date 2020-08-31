package requests.urlformat;

import java.util.ArrayList;

import requests.*;

/*
 * Copyright © 2020, Bill Than
 * DarkSkyURL
 */

public class DarkSkyURL extends URLAbstract {

	/**
	 * SAMPLE API CALL
	 * https://api.darksky.net/forecast/54014a5f81c8b8d34fb16a5f669ba9f1/37.8267,-122.4233
	 */
	private String flag = "";
	private final String path = "darksky.txt";
	private final int keyLen = 32;
	private String url = "https://api.darksky.net/forecast/";

	/**
	 * 
	 * @param key
	 * @param input
	 */
	public DarkSkyURL(String input, ArrayList<String> flags) {
		super(input);
		for (String s : flags) {
			System.out.println("FLAG " + s);
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
		this.output = this.url + this.key + "/" + this.input.trim() + this.flag;
	}

	@Override
	/**
	 * returns output
	 */
	public String getURL() {
		return this.output;
	}

}
