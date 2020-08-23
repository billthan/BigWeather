package main;

import java.util.ArrayList;

import locations.IPGrab;
import requests.RequestMain;

/*
 * Copyright © 2020, Bill Than 
 * UserPreferences
 */
public class UserPreferences {
	private char[] UNITS = { 'C', 'F' };
	private char units;
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
		this.units = UNITS[0];
		RequestMain r = new RequestMain(i.getIP(), "ip.txt");
		this.country = new ArrayList<String>();
		this.country.add(r.getJson().get("countryCode").getAsString());
	}

	/*
	 * changes unit iff c in UNITS
	 */
	public void changeUnits(char c) throws Exception {
		if (c == UNITS[0] || c == UNITS[1]) {
			this.units = c;
		} else {
			throw new Exception("Invalid Unit type");
		}
	}

	/*
	 * returns current unit type
	 */
	public char getUnit() {
		return this.units;
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
	 * gives string representation of user current preferences
	 */
	public String toString() {
		return ("====USER PREFERENCES====\nRegions: " + this.country + "\nIP:" + this.ip + "\nUnits: " + this.units
				+ "\n========================");
	}
}
