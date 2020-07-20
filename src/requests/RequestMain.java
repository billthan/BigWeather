package requests;
import requests.apiRequests.darksky.DarkSkyRequest;
import requests.apiRequests.tomtom.TomTomRequest;

/*
 * Copyright © 2020, Bill Than
 * RequestMain
 */

public class RequestMain {

	public static TomTomRequest t;
	public static DarkSkyRequest d;
	public String input;

	public RequestMain(String input) {
		this.input = input;
		RequestMain.t = new TomTomRequest(this.input);
		RequestMain.d = new DarkSkyRequest();
	}

	public static void main(String args[]) {
		RequestMain r = new RequestMain("165A Sheldon Avenue");
		System.out.println("tomtom " + t.key);
		System.out.println("darksky " + d.key);

	}

}
