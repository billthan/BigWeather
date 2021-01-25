package weather;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;

import com.google.gson.*;

import locations.*;
import main.preferences.UserPreferences;
/*
 * Copyright © 2020, Bill Than
 * Weather
 */

public class Weather {

	private Date date = new Date(System.currentTimeMillis());
	private ArrayList<HourlyWeather> hourly;
	private DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_DATE_TIME;

	private Coordinate coord;
	private ArrayList<String> flags;

	/**
	 * Parent Constructor, takes JsonObject
	 * 
	 * @param l
	 * @param jObject
	 * @param pref
	 */
	public Weather(Coordinate coord, JsonObject jObject, UserPreferences uP) {
		this.coord = coord;
		this.flags = uP.sgGetTrue();
		System.out.println(this.flags);
		init(jObject);
	}

	/**
	 * Sets the attributes to their respective variables
	 * 
	 * @param curr
	 */

	public void init(JsonObject curr) {
		JsonArray time = curr.getAsJsonArray("hours");

		for (JsonElement x : time) {
			HashMap<String, Double> retMap = new HashMap<String, Double>();
			JsonObject ob = x.getAsJsonObject();

			TemporalAccessor accessor = timeFormatter.parse(ob.get("time").getAsString());
			Date date = Date.from(Instant.from(accessor));
			System.out.println(date);

			for (String f : flags)
				retMap.put(f, ob.getAsJsonObject(f).get("noaa").getAsDouble());

			System.out.println(Arrays.asList(retMap));

		}

	}

	/**
	 * returns string representation of a weather of a specific date
	 */
	// public String toString() {

	// }

}
