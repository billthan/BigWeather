package locations;

import java.util.ArrayList;

import com.google.gson.*;

/*
 * Copyright © 2020, Bill Than
 * Locations
 */

public class Locations {

	private ArrayList<Coordinate> list = new ArrayList<Coordinate>();
	private String input;

	/**
	 * 
	 * @param results
	 */
	public Locations(JsonArray results, String input) {
		this.input = input;
		for (JsonElement obj : results) {
			JsonObject address = obj.getAsJsonObject().getAsJsonObject("address");
			JsonObject coord = obj.getAsJsonObject().getAsJsonObject("position");
			this.list.add(new Coordinate(address.get("freeformAddress").getAsString(), coord.get("lat").getAsDouble(),
					coord.get("lon").getAsDouble()));
		}
	}

	public String toString() {
		String res = "";
		String ret = (this.list.size() + " results found for " + "\'" + this.input + "\'\n");
		for (Coordinate c : this.list) {
			res = res + c.getAddress() + "\n";
		}
		ret = ret + res;
		return ret;
	}

}
