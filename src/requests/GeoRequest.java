package requests;
/*
 * Copyright © 2020, Bill Than
 * GeoRequest abstract
 */

public abstract class GeoRequest {

	public String key;
	public String URL;

	public GeoRequest() {
		key = requestKey();
	}

	public abstract String requestKey();
	

}
