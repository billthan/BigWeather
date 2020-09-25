package weather;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import com.google.gson.*;

import locations.*;
/*
 * Copyright © 2020, Bill Than
 * Weather
 */

public class Weather {

	private Coordinate coord;
	private double temp;
	private double feels_like;
	private double dewpoint;
	private double wind_speed;
	private double wind_gust;
	private double baro_pressure;
	private double humidity;
	private double wind_direction;
	private double percipitation;

	/**
	 * Parent Constructor, takes JsonObject
	 * 
	 * @param l
	 * @param jObject
	 * @param pref
	 */
	public Weather(Coordinate coord, JsonObject jObject) {
		this.coord = coord;
		init(jObject);
	}

	/**
	 * Sets the attributes to their respective variables
	 * 
	 * @param curr
	 */
	public void init(JsonObject curr) {
		this.temp = (curr.getAsJsonObject("temp")).get("value").getAsDouble();
		this.feels_like= (curr.getAsJsonObject("feels_like")).get("value").getAsDouble();
		this.dewpoint = (curr.getAsJsonObject("dewpoint")).get("value").getAsDouble();
		this.temp = (curr.getAsJsonObject("temp")).get("value").getAsDouble();
		this.temp	 = (curr.getAsJsonObject("temp")).get("value").getAsDouble();

	}

	/**
	 * returns string representation of a weather of a specific date
	 */
	public String toString() {

		String ret = "\n==============================================\n";
		ret += "temp: " + this.temp;

		return ret;
	}

}
