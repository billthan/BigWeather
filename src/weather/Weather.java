package weather;

import com.google.gson.JsonArray;

import locations.*;
/*
 * Copyright © 2020, Bill Than
 * Weather
 */


public class Weather {
	private Location l;

	public Weather(Location l, JsonArray results) {
		this.l = l;
	}
	
	public String toString() {
		return "";
	}

}
