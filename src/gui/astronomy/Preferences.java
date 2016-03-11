package gui.astronomy;



public class Preferences {
	int clouds;
	int visibility;
	int temp;
	int wind;
	int humidity;
	
	public Preferences(int clouds, int visibility, int temp, int wind, int humidity) {
		this.clouds = clouds;
		this.visibility = visibility;
		this.temp = temp;
		this.wind = wind;
		this.humidity = humidity;
	}

	public int getClouds() {
		return clouds;
	}

	public int getVisibility() {
		return visibility;
	}

	public int getTemp() {
		return temp;
	}

	public int getWind() {
		return wind;
	}

	public int getHumidity() {
		return humidity;
	}
}
