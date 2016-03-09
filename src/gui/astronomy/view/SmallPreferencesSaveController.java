package gui.astronomy.view;

import gui.astronomy.GUIAstronomy;
import javafx.fxml.FXML;
import javafx.stage.Stage;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SmallPreferencesSaveController {
	
	// Reference to the main application.
    private GUIAstronomy mainApp;
    
    public void setMainApp(GUIAstronomy mainApp) {
        this.mainApp = mainApp;
	} 
    
    @FXML
    private void initialize() {
    }
	
	@FXML
	private TextField PreferenceNameField;
	
	private boolean saveClicked = false;
	
	@FXML
	public void handleCancel(){
		mainApp.showPreferences();
	}
	
	@FXML
	private void handleSave() {
		saveClicked = true;
		mainApp.showPreferences();
	}
	


}
