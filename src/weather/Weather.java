package weather;

import java.text.DecimalFormat;
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
	
	private char pref;
	private Coordinate l;
	private long time;
	private String summary;
	private String icon;
	private double precipProbability;
	private double temperature;
	private double apparentTemperature;
	private double dewPoint;
	private double humidity;
	private double pressure;
	private double windSpeed;
	private double windGust;
	private double windBearing;
	private double cloudCover;
	private int uvIndex;
	private int visibility;
	private double ozone;
	SimpleDateFormat jdf = new SimpleDateFormat("EEEE MMMM, dd, YYYY HH:mm:ss");
	private ArrayList<Weather> hourly;
	
	/**
	 * Parent Constructor, takes JsonObject
	 * @param l
	 * @param j
	 * @param pref
	 */
	public Weather(Coordinate l, JsonObject j, char pref) {
		this.pref = pref;
		this.hourly = new ArrayList<Weather>();
		init(j.getAsJsonObject("currently"));
		this.l = l;
		JsonArray jHourly = ((JsonObject) (j.get("hourly"))).get("data").getAsJsonArray();
		for (JsonElement e : jHourly) {
			this.hourly.add(new Weather(this.l, e, pref));
		}
	}

	/**
	 * Child Constructor, takes JsonElement
	 * @param l
	 * @param e 
	 * @param pref
	 */
	public Weather(Coordinate l, JsonElement e, char pref) {
		this.pref = pref;
		this.l = l;
		init(e.getAsJsonObject());
		this.hourly = null;
	}

	/**
	 * Sets the attributes to their respective variables
	 * @param curr
	 */
	public void init(JsonObject curr) {
		this.summary = curr.get("summary").getAsString();
		this.time = curr.get("time").getAsLong();
		this.icon = curr.get("icon").getAsString();
		this.precipProbability = curr.get("precipProbability").getAsDouble();
		this.temperature = curr.get("temperature").getAsDouble();
		this.apparentTemperature = curr.get("apparentTemperature").getAsDouble();
		this.dewPoint = curr.get("dewPoint").getAsDouble();
		this.humidity = curr.get("humidity").getAsDouble();
		this.pressure = curr.get("pressure").getAsDouble();
		this.windSpeed = curr.get("windSpeed").getAsDouble();
		this.windGust = curr.get("windGust").getAsDouble();
		this.windBearing = curr.get("windBearing").getAsDouble();
		this.cloudCover = curr.get("cloudCover").getAsDouble();
		this.uvIndex = curr.get("uvIndex").getAsInt();
		this.visibility = curr.get("visibility").getAsInt();
		this.ozone = curr.get("ozone").getAsDouble();
		if (this.pref == 'C') {
			this.temperature = fToC(this.temperature);
		}
	}

	/**
	 * converts fahrenheit to celsius
	 * 
	 * @param f
	 * @return
	 */
	private double fToC(double f) {
		DecimalFormat df = new DecimalFormat("#.#");
		return Double.parseDouble(df.format(((5 * (f - 32.0)) / 9.0)));
	}

	/**
	 * returns string representation of a weather of a specific date
	 */
	public String toString() {
		Date date = new Date(this.time * 1000L);
		jdf.setTimeZone(TimeZone.getTimeZone("GMT-5"));

		String ret = "\n==============================================\n";
		ret += "time: " + jdf.format(date);
		ret += "\nsummary: " + summary;
		ret += "\nicon: " + icon;
		ret += "\nprecipProbability: " + precipProbability;
		ret += "\ntemperature: " + temperature;
		ret += "\napparentTemperature: " + apparentTemperature;
		ret += "\ndewPoint: " + dewPoint;
		ret += "\nhumidity: " + humidity;
		ret += "\npressure: " + pressure;
		ret += "\nwindSpeed: " + windSpeed;
		ret += "\nwindGust: " + windGust;
		ret += "\nwindBearing: " + windBearing;
		ret += "\ncloudCover: " + cloudCover;
		ret += "\nuvIndex: " + uvIndex;
		ret += "\nvisibility: " + visibility;
		ret += "\nozone: " + ozone;
		return ret;
	}
	
	/**
	 * return array of Weathers 
	 * This only exists in the case that the Weather has children.
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Weather> getArray() throws Exception {
		if (this.hourly != null)
			return this.hourly;
		throw new Exception("Not a child of Weather, invalid call was made.");
	}

}
