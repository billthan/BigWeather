package weather;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
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

	Date date = new Date(System.currentTimeMillis());
	SimpleDateFormat sdf;

	private Coordinate coord;
	private ArrayList<String> flags;
	private double temp;
	private double feels_like;
	private double dewpoint;
	private double wind_speed;
	private double wind_gust;
	private double baro_pressure;
	private double humidity;
	private double wind_direction;
	private double precipitation;

	/**
	 * Parent Constructor, takes JsonObject
	 * 
	 * @param l
	 * @param jObject
	 * @param pref
	 */
	public Weather(Coordinate coord, JsonObject jObject, UserPreferences uP) {
		this.coord = coord;
		init(jObject);
		this.flags = uP.getSGFlags();
	}

	/**
	 * Sets the attributes to their respective variables
	 * 
	 * @param curr
	 */

	public void init(JsonObject curr) {
		JsonArray time = curr.getAsJsonArray("hours");

		for (JsonElement x : time) {
			JsonObject b = x.getAsJsonObject();

			DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_DATE_TIME;
			TemporalAccessor accessor = timeFormatter.parse(b.get("time").getAsString());

			Date date = Date.from(Instant.from(accessor));
			System.out.println(date);

		}

	}

	/**
	 * returns string representation of a weather of a specific date
	 */
	public String toString() {

		String ret = "\n==============================================\n";
		ret += "temp: " + this.temp;
		ret += "\nfeels like: " + this.feels_like;
		ret += "\ndewpoint: " + this.dewpoint;
		ret += "\nwind_speed: " + this.wind_speed;
		ret += "\nbaro_pressure: " + this.baro_pressure;
		ret += "\nhumidity: " + this.humidity;
		ret += "\nwind_direction: " + this.wind_direction;
		ret += "\nwind_gust: " + this.wind_gust;
		ret += "\nprecipitation: " + this.precipitation;

		return ret;
	}

}
