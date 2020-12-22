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
		init();

		RequestMain r = new RequestMain(i.getIP(), "ip.txt");
		this.tt.changeCountry(r.getJson().get("countryCode").getAsString());
	}

	/**
	 * IP ONLY Preference
	 * 
	 * @param ip
	 * @throws Exception
	 */
	public UserPreferences(String ip) throws Exception {
		this.ip = ip;
		init();
	}

	private void init() {
		this.tt = new TomTomFlags();
		this.cc = new ClimaCellFlags();

	}

	/**
	 * Returns the ClimaCell Flags
	 * 
	 * @return
	 */
	public ArrayList<String> getCCFlags() {
		return this.cc.getFlags();
	}
	
	/**
	 * Gets false fields
	 * @return
	 */
	public ArrayList<String> ccGetFalse() {
		return this.cc.getFalse();
	}
	
	/**
	 * Gets true fields
	 * @return
	 */
	public ArrayList<String> ccGetTrue() {
		return this.cc.getTrue();
	}
	
	/**
	 * changes units to c param
	 * @param c
	 * @throws Exception
	 */
	public void changeUnits(String c) throws Exception {
		this.cc.changeUnits(c);
	}
	
	/**
	 * removes flags
	 * @param c
	 */
	public void rmField(String[] c) {
		this.cc.rmField(c);
	}
	
	/**
	 * add flags
	 * @param c
	 */
	public void addField(String[] c) {
		this.cc.addField(c);
	}

	/**
	 * Returns TomTom Flags
	 * 
	 * @return
	 */
	public ArrayList<String> getTTFlags() {
		return this.tt.getFlags();
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
		return ("====USER PREFERENCES====\nTomTom Flags: " + getTTFlags() + "\nClimaCell Flags:" + getCCFlags()
				+ "\nIP:" + this.ip + "\n========================");
	}
}
