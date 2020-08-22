package main;

import java.util.ArrayList;

import locations.IPGrab;
import requests.RequestMain;

/*
 * Copyright © 2020, Bill Than 
 * UserPreferences
 */
public class UserPreferences {
	private ArrayList<String> country;
	private String ip;

	/**
	 * 
	 * @param c
	 * @throws Exception
	 */
	public UserPreferences() throws Exception {
		IPGrab i = new IPGrab();
		this.ip = i.getIP();
		RequestMain r = new RequestMain(i.getIP(), "ip.txt");
		this.country = new ArrayList<String>();
		this.country.add(r.getJson().get("countryCode").getAsString());
	}

	/*
	 * checks if country already added, other wise will add to the arraylist
	 */
	public void add(String c) {
		if (!country.contains(c)) {
			this.country.add(c);
		}
	}

	/*
	 * returns stored IP address
	 */
	public String getIP() {
		return this.ip;
	}

	/*
	 * 
	 */
	public String toString() {
		return ("====USER PREFERENCES====\nRegions " + this.country + "\nIP:" + this.ip);
	}
}
