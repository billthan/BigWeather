package weather;

import com.google.gson.JsonArray;

import locations.*;
/*
 * Copyright © 2020, Bill Than
 * Weather
 */

public class Weather {
	private Coordinate l;
	private long time;
	private String summary;
	private String icon;
	private double precipIntensity;
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

	public Weather(Coordinate l, JsonArray results) {
		this.l = l;
	}

	public String toString() {
		return "";
	}

}
