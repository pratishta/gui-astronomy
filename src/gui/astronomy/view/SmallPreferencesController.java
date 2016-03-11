package gui.astronomy.view;

import java.util.Hashtable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.Set;

import gui.astronomy.GUIAstronomy;
import gui.astronomy.Preferences;
import gui.astronomy.api.ForecastAPI;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class SmallPreferencesController {
	
	// Reference to the main application.
    private GUIAstronomy mainApp;
    private ForecastAPI forecast;

    
    @FXML
	private ChoiceBox<String> viewSavedPreferences;
    @FXML
    private Slider cloudSlider;
	@FXML
	private Slider visibilitySlider;
	@FXML
	private Slider tempSlider;
	@FXML
	private Slider windSlider;
	@FXML
	private Slider humiditySlider;
	
	@FXML
	private Label cloudVal;
	@FXML
	private Label visibilityVal;
	@FXML
	private Label tempVal;
	@FXML
	private Label windVal;
	@FXML
	private Label humidityVal;

	
	public void setMainApp(GUIAstronomy mainApp) {
        this.mainApp = mainApp;
	} 
	

	@FXML
	private void initialize(){
		
		forecast = new ForecastAPI(); 
		
		Hashtable<String, Preferences> ht = GUIAstronomy.savedPrefs;
		Set<String> names = ht.keySet();
		for (String key: names) {
			viewSavedPreferences.getItems().add(key);
		}
		viewSavedPreferences.getSelectionModel().selectFirst();
		viewSavedPreferences.valueProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue ov, String oldValue, String newValue){
            	Preferences p = ht.get(newValue);
                cloudSlider.adjustValue(p.getClouds());
                visibilitySlider.adjustValue(p.getVisibility());
                tempSlider.adjustValue(p.getTemp());
                windSlider.adjustValue(p.getWind());
                humiditySlider.adjustValue(p.getHumidity());
            
            }
        });
		
		
	}
	
	
	@FXML
	public void handleBack(){
		mainApp.showWeatherToday();
	}
	
	
	
	@FXML
	public void showPreferenceWeather(String pref) {
		mainApp.showWeatherToday();
	}
	
	@FXML
	public void changeCloud() {
		cloudVal.setText(Integer.toString((int)cloudSlider.getValue()));
	}

	@FXML
	public void changeVisibility() {
		visibilityVal.setText(Integer.toString((int)visibilitySlider.getValue()));
	}
	
	@FXML
	public void changeTemp() {
		tempVal.setText(Integer.toString((int)tempSlider.getValue()));
	}
	
	@FXML
	public void changeWind() {
		windVal.setText(Integer.toString((int)windSlider.getValue()));
	}
	
	@FXML
	public void changeHumidity() {
		humidityVal.setText(Integer.toString((int)humiditySlider.getValue()));
	}
	
	
	
	
	@FXML
	public void openSavePreferencesDialog(){
		int c = Integer.parseInt(cloudVal.getText());
		System.out.println("here is cloud " + c);
		int v = Integer.parseInt(visibilityVal.getText());
		int t = Integer.parseInt(tempVal.getText());
		int w = Integer.parseInt(windVal.getText());
		int h = Integer.parseInt(humidityVal.getText());
		mainApp.showPreferencesSaveDialog(c, v, t, w, h);
	}
	
}
