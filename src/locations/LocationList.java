package locations;

import java.util.ArrayList;

import com.google.gson.*;

/*
 * Copyright © 2020, Bill Than
 * Locations
 */

public class LocationList {

	private ArrayList<Coordinate> list = new ArrayList<Coordinate>();
	private String input;

	/**
	 * gets all the locations returned and appends to an ArrayList
	 * @param results
	 * @param input; is the keywords that correspond with results
	 */
	public LocationList(JsonArray results, String input) {
		this.input = input;
		for (JsonElement obj : results) {
			JsonObject address = obj.getAsJsonObject().getAsJsonObject("address");
			JsonObject coord = obj.getAsJsonObject().getAsJsonObject("position");
			this.list.add(new Coordinate(address.get("freeformAddress").getAsString(), coord.get("lat").getAsDouble(),
					coord.get("lon").getAsDouble()));
		}
	}

	/*
	 * string representation of the Location class
	 */
	public String toString() {
		String res = "";
		//reads from the list
		String ret = (this.list.size() + " results found for " + "\'" + this.input + "\'\n");
		for (Coordinate c : this.list) {
			res = res + c.getAddress() + "\n";
		}
		ret = ret + res;
		return ret;
	}

}
