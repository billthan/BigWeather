package locations;

/*
 * Copyright � 2021, Bill Than
 * Coordinate
 */

public class Coordinate {
	private double lat;
	private double lon;
	private String address;

	/**
	 * 
	 * @param address
	 * @param lat
	 * @param lon
	 */
	public Coordinate(String address, double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
		this.address = address;
	}

	/*
	 * returns lat
	 */
	public double getLat() {
		return this.lat;
	}

	/*
	 * returns lon
	 */
	public double getLon() {
		return this.lon;
	}

	/*
	 * returns address
	 */
	public String getAddress() {
		return this.address;
	}

	/*
	 * returns stylized form of Coordinate
	 */
	public String toString() {
		return (this.address + "\n" + "(" + this.lat + "," + this.lon + ")");

	}

	public String getString() {
		return (this.lat + "," + this.lon);

	}

}
