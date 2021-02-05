package requests.urlformat;

/*
 * Copyright © 2021, Bill Than
 * IPURL
 */

public class IPURL {

	protected String input;
	protected String output;
	private String url = "http://ip-api.com/json/";

	/**
	 * 
	 * @param input
	 */
	public IPURL(String input) {
		this.input = input;
		parseURL();
	}

	/*
	 * parses the URL to be returned
	 */
	public void parseURL() {
		this.output = url.concat(input);
	}

	/*
	 * returns the parsed URL
	 */
	public String getURL() {
		return this.output;
	}

}
