package main.preferences;

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

	private String ip;
	private DarkSkyFlags ds;
	private ClimaCellFlags cc;
	private TomTomFlags tt;

	/**
	 * 
	 * @param c
	 * @throws Exception
	 */
	public UserPreferences() throws Exception {
		IPGrab i = new IPGrab();
		this.ip = i.getIP();
		// default flags
		this.ds = new DarkSkyFlags();
		this.tt = new TomTomFlags();
		this.cc = new ClimaCellFlags();

		RequestMain r = new RequestMain(i.getIP(), "ip.txt");

		this.tt.changeCountry(r.getJson().get("countryCode").getAsString());
	}

	public ArrayList<String> getCCFlags() {
		return this.cc.getFlags();
	}

	public ArrayList<String> getTTFlags() {
		return this.tt.getFlags();
	}

	/**
	 * 
	 * @return flags stored
	 */
	public ArrayList<String> getDSFlags() {
		return this.ds.getFlags();
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
		return ("====USER PREFERENCES====\nTomTom Flags: " + getTTFlags() + "\nDarkSky flags: " + getDSFlags() + "\nIP:"
				+ this.ip + "\n========================");
	}
}
