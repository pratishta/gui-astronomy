package gui.astronomy.view;

import gui.astronomy.GUIAstronomy;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class SmallPreferencesController {
	
	// Reference to the main application.
    private GUIAstronomy mainApp;
	
	public void setMainApp(GUIAstronomy mainApp) {
        this.mainApp = mainApp;
	} 
	
	@FXML
	private void initialize(){
		
	}
	
	@FXML
	public void openSavePreferencesDialog(){
		mainApp.showPreferencesSaveDialog();
	}
	
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
	
}
