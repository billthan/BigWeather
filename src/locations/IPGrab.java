package locations;

package locations;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/*
 * Copyright © 2020, Bill Than
 * IPGrab
 * Credits to https://www.geeksforgeeks.org/java-program-find-ip-address-computer/
 */

class IPGrab {
	public static void main(String args[]) throws Exception {

		String ip = "";
		try {
			URL url_name = new URL("http://bot.whatismyipaddress.com");
			BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));
			// reads system IPAddress
			ip = sc.readLine().trim();
		} catch (Exception e) {
			throw new Exception("Could not find IP");
		}
		System.out.println("Public IP Address: " + ip + "\n");
	}
}