package main.preferences;

import java.util.ArrayList;

public class TomTomFlags extends Flags {
	private String country;
	private String limit;

	public TomTomFlags() {
		this.flags = new ArrayList<String>();
		// default
		this.country = "countrySet=CA";
		this.limit = "limit=5";

	}

	public void changeLimit(String c) {
		this.limit = "limit=" + c;

	}

	public void changeCountry(String c) {
		this.country = "countrySet=" + c;
	}

	@Override
	protected void update() {
		this.flags = new ArrayList<String>();
		this.flags.add(this.limit);
		this.flags.add(this.country);
	}

}
