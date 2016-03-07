package gui.astronomy.view;

import gui.astronomy.GUIAstronomy;
import javafx.fxml.FXML;
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
		mainApp.showWeatherOverview();
	}

}
