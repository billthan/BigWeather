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

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		getIPLocation();
		sc.close();

	}

	private static void getIPLocation() throws Exception {
		System.out.println("Searching for a enter IP address: ");
		IPGrab i = new IPGrab();
		RequestMain r = new RequestMain(i.getIP(), "ip.txt");

	}

	private static void searchTomTomLocation() throws Exception {
		System.out.println("Searching for a location: ");
		String input = sc.nextLine(); // Read user input
		RequestMain r = new RequestMain(input, "tomtom.txt");
		Locations l = new Locations(r.getJson().getAsJsonArray("results"), input);
		System.out.println(l);

	}

}
