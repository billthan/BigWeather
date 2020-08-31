package main.searches;

import java.util.Scanner;

import locations.Coordinate;
import locations.LocationList;
import requests.RequestMain;

public class TomTomSearch {
	public static Scanner sc = new Scanner(System.in); // Create a Scanner object

	public Coordinate search() throws Exception {
		System.out.println("Search for a location: ");
		String input = sc.nextLine();
		// Read user input
		RequestMain r = new RequestMain(input, "tomtom.txt");
		LocationList l = new LocationList(r.getJson().getAsJsonArray("results"), input);
		System.out.println(l + "\nSelect your location preferred:");

		return l.get(Integer.parseInt(sc.nextLine()) - 1);

	}

}
