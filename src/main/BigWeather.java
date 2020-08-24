package main;

import java.util.*;
import requests.*;
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
		//getIPLocation();
		searchDarkSky();
		sc.close();
	}

	private static void getIPLocation() throws Exception {
		System.out.println("Returning info for IP at " + userPref.getIP());
		RequestMain r = new RequestMain(userPref.getIP(), "ip.txt");

	}
/**
	private static void searchTomTomLocation() throws Exception {
		System.out.println("Search for a location: ");
		String input = sc.nextLine(); // Read user input
		RequestMain r = new RequestMain(input, "tomtom.txt");
		LocationList l = new LocationList(r.getJson().getAsJsonArray("results"), input);
		System.out.println(l);
	}**/

	private static void searchDarkSky() throws Exception {
		System.out.println("Enter lon");
		String lon = sc.nextLine(); // Read user input
		System.out.println("Enter lat");
		String lat = sc.nextLine(); // Read user input
		lon = lon + "," + lat;
		RequestMain r = new RequestMain(lon, "darksky.txt");
		
		double lond =Double.parseDouble(lon);
		double latd = Double.parseDouble(lat);
		Location l = new Location("Name", latd, lond);
		
		
	}

}
