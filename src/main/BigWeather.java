package main;

import java.util.*;

import com.google.gson.*;

import requests.*;

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
		JsonObject ttObj = r.getJson();
		JsonArray results = ttObj.getAsJsonArray("results");
		for (int i = 0; i < results.size(); i++) {
            JsonObject address = results.get(i).getAsJsonObject().getAsJsonObject("address");
            System.out.println(address.get("streetName"));
           
		}
		sc.close();
	}

}
