package weather;

import java.util.Date;
import java.util.HashMap;

/*
 * Copyright © 2021, Bill Than
 * HourlyWeather
 */

public class HourlyWeather {
	private Date date;
	private HashMap<String, Double> hm;

	/**
	 * 
	 * @param hm
	 * @param date
	 */
	public HourlyWeather(HashMap<String, Double> hm, Date date) {
		this.date = date;
		this.hm = hm;

	}
	
	/**
	 * 
	 * @param key
	 * @return hashmap key value
	 */
	public double get(String key) {
		return hm.get(key);
	}

}
