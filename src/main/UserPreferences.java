package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import locations.IPGrab;
import requests.RequestMain;

/*
 * Copyright © 2020, Bill Than 
 * UserPreferences
 */
public class UserPreferences {
	// units, see DarkSky API Documentation
	private String[] UNITS = { "units=auto", "units=ca", "units=uk2", "units=us", "units=si" };
	private ArrayList<String> flags;
	private String unit;
	private String country;
	private String ip;

	/**
	 * 
	 * @param c
	 * @throws Exception
	 */
	public UserPreferences() throws Exception {
		IPGrab i = new IPGrab();
		this.ip = i.getIP();
		this.flags = new ArrayList<String>();
		RequestMain r = new RequestMain(i.getIP(), "ip.txt");
		this.country = r.getJson().get("countryCode").getAsString();
		this.unit = UNITS[1]; // default unit=ca for testing purposes
		this.flags.add(this.unit);
	}

	/**
	 * checks if c is a valid UNIT
	 * 
	 * @param c
	 */
	public void changeUnits(String c) throws Exception {
		List<String> valid = Arrays.asList(this.UNITS);
		// valid input
		if (valid.contains(c)) {
			int i = 0;
			// iterates thru flags
			for (String f : this.flags) {
				String[] s = f.split("=");
				// checks flags
				if (s[0].equalsIgnoreCase("units")) {
					this.unit = c;
					this.flags.set(i, c);
				}
				i++;
			}
		} else {
			throw new Exception("Invalid unit type is selected");
		}
	}

	/**
	 * 
	 * @return flags stored
	 */
	public ArrayList<String> getFlags() {
		return this.flags;
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
		return ("====USER PREFERENCES====\nRegions: " + this.country + "\nIP:" + this.ip + "\nUnits: " + this.unit
				+ "\n========================");
	}
}
