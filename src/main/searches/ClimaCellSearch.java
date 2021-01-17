package main.searches;

import locations.Coordinate;
import main.preferences.UserPreferences;
import requests.RequestMain;
import weather.Weather;

/*
 * Copyright � 2020, Bill Than
 * DarkSkySearch 
 */
public class ClimaCellSearch {
	private Coordinate c;
	private UserPreferences userPref;

	public ClimaCellSearch(Coordinate c, UserPreferences userPref) {
		this.c = c;
		this.userPref = userPref;
	}

	/**
	 * Searches current weather and prints
	 * 
	 * @throws Exception
	 */
	public void search() throws Exception {
		RequestMain r = new RequestMain(c.getString(), "climacell.txt", userPref.getCCFlags());
		//Weather w = new Weather(c, r.getJson());System.out.println(w);
	
	}

}
