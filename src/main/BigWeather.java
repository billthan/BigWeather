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
		String input = sc.nextLine(); // Read user input
		RequestMain r = new RequestMain(input, "tomtom.txt");
		Locations l = new Locations(r.getJson().getAsJsonArray("results"), input);
		System.out.println(l);
		sc.close();
	}

}
