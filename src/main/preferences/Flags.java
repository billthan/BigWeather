package main.preferences;

import java.util.ArrayList;

public abstract class Flags {
	protected ArrayList<String> flags;

	abstract protected void update();

	public ArrayList<String> getFlags() {
		update();
		return this.flags;
	}

}
