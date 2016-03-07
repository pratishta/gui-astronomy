package gui.astronomy.view;

import gui.astronomy.GUIAstronomy;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmallWeatherTodayController {
	
	 private GUIAstronomy mainApp;
	
	@FXML
	private Label Date;
	
	public SmallWeatherTodayController(){
	}
	
	@FXML
	private void initialize(){

		Format formatter = new SimpleDateFormat("MMM d");
		Date.setText(formatter.format(new Date())); 
		
	}
	
	public void setMainApp(GUIAstronomy mainApp) {
        this.mainApp = mainApp;
    }
	
	@FXML
	public void openPreferences(){
		mainApp.showPreferences();
	}
	

}