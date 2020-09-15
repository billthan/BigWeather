package main.preferences;

import java.util.ArrayList;

/*
 * Copyright © 2020, Bill Than
 * Flags abstract
 */
public abstract class Flags {
	protected ArrayList<String> flags;

	abstract protected void update();

	/**
	 * Updates the flags and returns current flags
	 * @return
	 */
	public ArrayList<String> getFlags() {
		update();
		return this.flags;
	}

}
