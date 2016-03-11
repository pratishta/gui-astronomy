package gui.astronomy.view;

import java.util.Hashtable;
import java.util.Set;

import gui.astronomy.GUIAstronomy;
import gui.astronomy.GUIAstronomy.Preference;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class SmallPreferencesController {
	
	// Reference to the main application.
    private GUIAstronomy mainApp;
    private String name;
	
	public void setMainApp(GUIAstronomy mainApp, String name) {
        this.mainApp = mainApp;
        this.name = name;
	} 
	
	@FXML
	private void initialize(){
		
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
	private Label pref1;
	@FXML
	private Label pref2;
	@FXML
	private Label pref3;
	
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
	public void changePref() {
		Hashtable<String, Preference> ht = GUIAstronomy.savedPrefs;
		Set<String> names = ht.keySet();
		for (String key: names) {
			System.out.println("heeeeey");
			pref1.setText(key);
		}
		
		//humidityVal.setText(Integer.toString((int)humiditySlider.getValue()));
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
