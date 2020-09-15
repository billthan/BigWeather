package main.searches;

import java.util.ArrayList;
import locations.Coordinate;
import main.preferences.UserPreferences;
import requests.RequestMain;
import weather.Weather;

/*
 * Copyright © 2020, Bill Than
 * DarkSkySearch 
 */
public class DarkSkySearch {
	private Coordinate c;
	private UserPreferences userPref;

	public DarkSkySearch(Coordinate c, UserPreferences userPref) {
		this.c = c;
		this.userPref = userPref;
	}

	/**
	 * Searches current weather and prints
	 * @throws Exception
	 */
	public void search() throws Exception {
		RequestMain r = new RequestMain(c.getString(), "darksky.txt", userPref.getDSFlags());
		Weather w = new Weather(c, r.getJson());
		ArrayList<Weather> wList = w.getArray();
		System.out.println("Current Weather:");
		System.out.println(w);

		for (Weather d : wList) {
			System.out.println(d);
		}
	}

}
