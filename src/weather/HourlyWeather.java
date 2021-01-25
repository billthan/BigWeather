package weather;

public class HourlyWeather {

	private double windSpeed;
	private double windDirection;
	private double airTemperature;
	private double precipitation;
	private double gust;
	private double cloudCover;
	private double humidity;
	private double pressure;
	private double visibility;
	private double currentSpeed;
	private double currentDirection;
	private double iceCover;
	private double snowDepth;
	private double seaLevel;

	public HourlyWeather(double windSpeed, double windDirection, double airTemperature, double precipitation,
			double gust, double cloudCover, double humidity, double pressure, double visibility, double currentSpeed,
			double currentDirection, double iceCover, double snowDepth, double seaLevel) {

	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(double windDirection) {
		this.windDirection = windDirection;
	}

	public double getAirTemperature() {
		return airTemperature;
	}

	public void setAirTemperature(double airTemperature) {
		this.airTemperature = airTemperature;
	}

	public double getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(double precipitation) {
		this.precipitation = precipitation;
	}

	public double getGust() {
		return gust;
	}

	public void setGust(double gust) {
		this.gust = gust;
	}

	public double getCloudCover() {
		return cloudCover;
	}

	public void setCloudCover(double cloudCover) {
		this.cloudCover = cloudCover;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getVisibility() {
		return visibility;
	}

	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}

	public double getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(double currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public double getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(double currentDirection) {
		this.currentDirection = currentDirection;
	}

	public double getIceCover() {
		return iceCover;
	}

	public void setIceCover(double iceCover) {
		this.iceCover = iceCover;
	}

	public double getSnowDepth() {
		return snowDepth;
	}

	public void setSnowDepth(double snowDepth) {
		this.snowDepth = snowDepth;
	}

	public double getSeaLevel() {
		return seaLevel;
	}

	public void setSeaLevel(double seaLevel) {
		this.seaLevel = seaLevel;
	}
}
