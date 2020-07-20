package requests;
import requests.tomtom.DarkSkyRequest;
import requests.tomtom.TomTomRequest;

public class mainTest {

	public static void main(String args[]) {
		TomTomRequest t = new TomTomRequest();
		DarkSkyRequest d = new DarkSkyRequest();
		System.out.println("tomtom "+t.requestKey());
		System.out.println("darksky "+d.requestKey());

	}
}
