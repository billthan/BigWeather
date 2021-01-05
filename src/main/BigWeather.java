package main;

import main.preferences.UserPreferences;
import main.searches.*;

/*
 * Copyright � 2020, Bill Than
 * BigWeather main
 */

public class BigWeather {

	public static UserPreferences userPref; // stores user information

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {

		BigWeather.userPref = new UserPreferences();
		System.out.println(userPref);
		
		
		TomTomSearch ts = new TomTomSearch(userPref);
		//ClimaCellSearch cc = new ClimaCellSearch(ts.search(), userPref);
		//cc.search();
		StormGlassSearch sg = new StormGlassSearch(ts.search(), userPref);
		sg.search();
	}

}