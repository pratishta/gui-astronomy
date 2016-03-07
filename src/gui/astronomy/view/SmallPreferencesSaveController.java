package gui.astronomy.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SmallPreferencesSaveController {
	
	@FXML
	private TextField PreferenceNameField;
	
	private Stage dialogStage;
	private boolean saveClicked = false;
	
	@FXML
    private void initialize() {
    }
	
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
	public boolean isOkClicked() {
        return saveClicked;
    }

	
	@FXML
	private void handleSave() {
		saveClicked = true;
		dialogStage.close(); 
	}
	
	@FXML
    private void handleCancel() {
        dialogStage.close();
    }

}
