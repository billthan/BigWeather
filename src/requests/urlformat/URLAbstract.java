package requests.urlformat;


/*
 * Copyright � 2020, Bill Than URLAbstract
 */

abstract class URLAbstract {
	  String key;
	protected String input;
	protected String output;

	/**
	 * 
	 * @param key
	 * @param input
	 */
	public URLAbstract(String input) {
		this.key = getKey();
		this.input = input;
	}

	public abstract void parseURL(); // Parses URL

	public abstract String getURL(); // returns URL

	public abstract String getKey(); // gets API key

}
