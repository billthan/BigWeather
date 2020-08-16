package main;

import java.util.*;

import requests.*;

/*
 * Copyright � 2020, Bill Than
 * HTMLRequest
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
		
		sc.close();
	}

}
