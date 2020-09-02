package main.searches;

import java.util.Scanner;

import locations.Coordinate;
import locations.LocationList;
import main.preferences.UserPreferences;
import requests.RequestMain;

public class TomTomSearch {
	private UserPreferences userPref;
	public static Scanner sc = new Scanner(System.in); // Create a Scanner object

	public TomTomSearch(UserPreferences userPref) {
		this.userPref = userPref;
	}

	public Coordinate search() throws Exception {
		System.out.println("Search for a location: ");
		String input = sc.nextLine();
		// Read user input
		RequestMain r = new RequestMain(input, "tomtom.txt", userPref.getTTFlags());
		LocationList l = new LocationList(r.getJson().getAsJsonArray("results"), input);
		System.out.println(l + "\nSelect your location preferred:");

		return l.get(Integer.parseInt(sc.nextLine()) - 1);

	}

}
