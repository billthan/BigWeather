package requests.urlformat;

@SuppressWarnings("unused")

/*
 * Copyright © 2020, Bill Than URLAbstract
 */

abstract class URLAbstract {
	private String key;
	private String url;
	private String input;

	/**
	 * 
	 * @param key
	 * @param url
	 * @param input
	 */
	public URLAbstract(String key, String url, String input) {
		this.key = key;
		this.url = url;
		this.input = input;
	}

	abstract void parseURL(); // Parses URL

	abstract String getURL(); // returns URL

}
