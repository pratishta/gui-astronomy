package gui.astronomy.view;

import java.util.Hashtable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.Set;

import gui.astronomy.GUIAstronomy;
import gui.astronomy.GUIAstronomy.Preference;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class SmallPreferencesController {
	
	// Reference to the main application.
    private GUIAstronomy mainApp;
    private String name;
    
    @FXML
	private ChoiceBox<String> viewSavedPreferences;

	
	public void setMainApp(GUIAstronomy mainApp) {
        this.mainApp = mainApp;
        this.name = name;
	} 
	
	@FXML
	public void changePref() {
		
//		//System.out.println("here is the name " + name);
//		for (String key: names) {
//			System.out.println("heeeeey "+  key);
//			
//		}
		

	}
	
	@FXML
	private void initialize(){
		Hashtable<String, Preference> ht = GUIAstronomy.savedPrefs;
		Set<String> names = ht.keySet();
		for (String key: names) {
			System.out.println("heeeeey "+  key);
			viewSavedPreferences.getItems().add(key);
			}
		
		//handleBack();
		// Handle changes in Location 
		
	//	viewSavedPreferences.setEditable(true); 
		viewSavedPreferences.getSelectionModel().selectFirst();
//		viewSavedPreferences.valueProperty().addListener(new ChangeListener<String>(){
//        	public void changed(Preference p, String oldValue, String newValue){
//        		handleBack();
//        	}
//
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				// TODO Auto-generated method stub
//				
//			}
//        });
		
		
//		viewSavedPreferences.getItems().addAll("yo", "pls");
//		viewSavedPreferences.getSelectionModel().selectFirst();
		
	}
	
//	@FXML
//	public void openSavePreferencesDialog(){
//		mainApp.showPreferencesSaveDialog();
//	}
	
	@FXML
	public void handleBack(){
		mainApp.showWeatherToday();
	}
	
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
