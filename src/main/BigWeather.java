package main;

import java.util.*;

import requests.*;
import weather.Weather;
import locations.*;

/*
 * Copyright © 2020, Bill Than
 * BigWeather main
 */

public class BigWeather {

	public static Scanner sc = new Scanner(System.in); // Create a Scanner object
	public static UserPreferences userPref; // stores user information

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		BigWeather.userPref = new UserPreferences();
		System.out.println(userPref);
		searchDarkSky(searchTomTomLocation());
		sc.close();
	}

	/**
	 * Gets tomtom location and returns instance of Coordinates selected.
	 * @return
	 * @throws Exception
	 */
	private static Coordinate searchTomTomLocation() throws Exception {
		System.out.println("Search for a location: ");
		String input = sc.nextLine();
		// Read user input
		RequestMain r = new RequestMain(input, "tomtom.txt");
		LocationList l = new LocationList(r.getJson().getAsJsonArray("results"), input);
		System.out.println(l);
		System.out.println("Select your location preferred:");
		int num = Integer.parseInt(sc.nextLine()) - 1;
		return l.get(num);
	}

	private static void searchDarkSky(Coordinate c) throws Exception {

		RequestMain r = new RequestMain(c.getString(), "darksky.txt");
		Weather w = new Weather(c, r.getJson(), userPref.getUnit());
		ArrayList<Weather> wList = w.getArray();
		System.out.println("Current Weather:");
		System.out.println(w);

		for (Weather d : wList) {
			System.out.println(d);
		}

	}

}
