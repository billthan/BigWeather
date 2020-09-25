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
	private double precipitation;

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
		this.feels_like = (curr.getAsJsonObject("feels_like")).get("value").getAsDouble();
		this.dewpoint = (curr.getAsJsonObject("dewpoint")).get("value").getAsDouble();
		this.wind_speed = (curr.getAsJsonObject("wind_speed")).get("value").getAsDouble();
		this.wind_gust = (curr.getAsJsonObject("wind_gust")).get("value").getAsDouble();
		this.baro_pressure = (curr.getAsJsonObject("baro_pressure")).get("value").getAsDouble();
		this.humidity = (curr.getAsJsonObject("humidity")).get("value").getAsDouble();
		this.wind_direction = (curr.getAsJsonObject("wind_direction")).get("value").getAsDouble();
		this.precipitation = (curr.getAsJsonObject("precipitation")).get("value").getAsDouble();

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
