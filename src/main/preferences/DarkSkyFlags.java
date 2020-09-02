package main.preferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DarkSkyFlags extends Flags {

	private String[] UNITS = { "units=auto", "units=ca", "units=uk2", "units=us", "units=si" };

	private String unit;

	public DarkSkyFlags() {
		this.flags = new ArrayList<String>();
		this.unit = UNITS[1];
	}

	public void changeUnits(String c) throws Exception {
		List<String> valid = Arrays.asList(this.UNITS);
		// valid input
		if (valid.contains(c)) {
			this.unit = c;
		} else {
			throw new Exception("Invalid unit type is selected");
		}
	}

	@Override
	protected void update() {
		this.flags = new ArrayList<String>();
		this.flags.add(unit);
	}

}
