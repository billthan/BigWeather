package main.preferences;

import java.util.*;

/*
 * Copyright © 2020, Bill Than
 * ClimaCellFlags 
 */

public class StormGlassFlags extends Flags {

	private String[] fields = { "windSpeed", "windDirection", "airTemperature", "precipitation", "gust", "cloudCover",
			"humidity", "pressure", "visibility", "iceCover" };

	private ArrayList<String> trueList = new ArrayList<String>();
	private ArrayList<String> falseList = new ArrayList<String>();

	private ArrayList<String> FIELDS = new ArrayList<String>();
	protected String unit;

	public StormGlassFlags() {
		this.flags = new ArrayList<String>();
		fillField();
		updateLists();
	}

	/**
	 * Updates the ArrayList of Fields with all possible fields
	 */
	private void fillField() {
		for (String x : this.fields) {
			this.FIELDS.add(x);
		}
	}

	/**
	 * updates true and false lists
	 */
	public void updateLists() {
		this.trueList.clear();
		this.falseList.clear();
		for (String x : this.fields) {
			if (this.FIELDS.contains(x)) {
				this.trueList.add(x);
			} else {
				this.falseList.add(x);
			}
		}
	}

	/**
	 * gets all flags not applied
	 * 
	 * @return
	 */
	public ArrayList<String> getFalse() {
		return this.falseList;
	}

	/**
	 * gets all flags applied
	 * 
	 * @return
	 */
	public ArrayList<String> getTrue() {
		return this.trueList;
	}

	/**
	 * Removes all parameters of c from fields
	 * 
	 * @param c
	 */
	public void rmField(String[] c) {
		for (String x : c)
			this.FIELDS.remove(x);
		updateLists();
	}

	/**
	 * Add all parameters c to fields
	 * 
	 * @param c
	 */
	public void addField(String[] c) {
		for (String x : c) {
			if (!this.FIELDS.contains(x))
				this.FIELDS.add(x);
		}
		updateLists();
	}

	/**
	 * updates the current flags
	 */
	@Override
	protected void update() {
		this.flags = new ArrayList<String>();
		String f = "params=";
		int i = 0;
		for (String x : this.FIELDS) {
			if (i == 0) {
				f += x;
				i++;
			} else
				f += "," + x;
		}
		System.out.println("ARRAY " + this.flags);
		this.flags.add(f);
	}

}
