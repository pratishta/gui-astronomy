package gui.astronomy;

import java.io.IOException;
import gui.astronomy.api.WeatherAPI;
import gui.astronomy.view.SmallPreferencesController;
import gui.astronomy.view.SmallPreferencesSaveController;
import gui.astronomy.view.SmallWeatherTodayController;
import gui.astronomy.view.SmallWeatherWeekController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
