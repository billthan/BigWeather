package main.preferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Copyright © 2020, Bill Than
 * ClimaCellFlags 
 */

public class ClimaCellFlags extends Flags {

	// default UNITS
	private String[] UNITS = { "unit_system=si", "unit_system=us" };

	private String[] fields = { "temp", "feels_like", "dewpoint", "humidity", "wind_speed", "wind_direction",
			"wind_gust", "baro_pressure", "precipitation" };

	private ArrayList<String> FIELDS = new ArrayList<String>();
	private String unit;

	public ClimaCellFlags() {
		this.flags = new ArrayList<String>();
		fillField();
		this.unit = UNITS[0];
	}

	/**
	 * Updates the ArrayList of Fields with all possible fields
	 */
	private void fillField() {
		for (String x : this.fields)
			this.FIELDS.add(x);
	}

	/**
	 * Removes all parameters of c from fields
	 * 
	 * @param c
	 */
	public void rmField(String[] c) {
		for (String x : c)
			this.FIELDS.remove(x);
	}

	/**
	 * checks for valid c input changes the current unit to c
	 * 
	 * @param c
	 * @throws Exception
	 */
	public void changeUnits(String c) throws Exception {
		List<String> valid = Arrays.asList(this.UNITS);
		// valid input
		if (valid.contains(c)) {
			this.unit = c;
		} else {
			throw new Exception("Invalid unit type is selected");
		}
	}

	/**
	 * updates the current flags
	 */
	@Override
	protected void update() {
		this.flags = new ArrayList<String>();
		this.flags.add(unit);
		String f = "fields=";
		int i = 0;
		for (String x : this.FIELDS) {
			if (i == 0) {
				f += x;
				i++;
			} else
				f += "%2C" + x;
		}
		this.flags.add(f);
	}

}
