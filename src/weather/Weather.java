package weather;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

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

	private ArrayList<Weather> hourly;

	public Weather(Coordinate l, JsonElement e, char pref) {
		this.pref = pref;
		this.l = l;
		init(e.getAsJsonObject());

	}

	public Weather(Coordinate l, JsonObject j, char pref) {
		this.pref = pref;
		this.hourly = new ArrayList<Weather>();
		init(j.getAsJsonObject("currently"));
		this.l = l;

		JsonArray jHourly = ((JsonObject) (j.get("hourly"))).get("data").getAsJsonArray();

		for (JsonElement e : jHourly) {
			init(e.getAsJsonObject());
			this.hourly.add(new Weather(this.l, e, pref));
		}

		for (Weather w : this.hourly) {
			System.out.println(w);
		}
	}

	public void init(JsonObject curr) {
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
			this.temperature = convertCToF(this.temperature);
		}
	}

	private double convertCToF(double f) {
		DecimalFormat df = new DecimalFormat("#.#");
		return Double.parseDouble(df.format(((5 * (f - 32.0)) / 9.0)));
	}

	public String toString() {
		LocalDateTime dateTime = LocalDateTime.ofEpochSecond(this.time, 0, ZoneOffset.UTC);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy h:mm, a", Locale.ENGLISH);

		return "coord: " + this.l + "\ntime: " + dateTime.format(formatter) + "\ntemp: " + this.temperature + "\n";
	}

	public long getTime() {
		return time;
	}

	public double getPrecipProbability() {
		return precipProbability;
	}

	public double getTemperature() {
		return temperature;
	}

	public double getApparentTemperature() {
		return apparentTemperature;
	}

	public double getDewPoint() {
		return dewPoint;
	}

	public double getHumidity() {
		return humidity;
	}

	public double getPressure() {
		return pressure;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public double getWindGust() {
		return windGust;
	}

	public double getWindBearing() {
		return windBearing;
	}

	public double getCloudCover() {
		return cloudCover;
	}

	public int getUvIndex() {
		return uvIndex;
	}

	public int getVisibility() {
		return visibility;
	}

	public double getOzone() {
		return ozone;
	}

	public String getSummary() {
		return summary;
	}

	public String getIcon() {
		return icon;
	}
}
