package gui.astronomy.view;

import gui.astronomy.GUIAstronomy;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

public class LargeWeatherWeekController {
	private GUIAstronomy mainApp;
	
	@FXML
    private ChoiceBox<String> viewLayoutSelection;
    
    @FXML
    private ComboBox<String> locationSelection;
	
	@FXML
    private void initialize(){
		
        viewLayoutSelection.getItems().addAll("This Week","Today");
        viewLayoutSelection.getSelectionModel().selectFirst();
        viewLayoutSelection.getSelectionModel().selectedIndexProperty().addListener( (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> handleChoiceBox(newValue));	
	
        locationSelection.getItems().add("London");
        locationSelection.setEditable(true); 
        locationSelection.getSelectionModel().selectFirst();
        locationSelection.valueProperty().addListener(new ChangeListener<String>(){
        	public void changed(ObservableValue ov, String oldValue, String newValue){
        		
        	}
        });	
	}
	
	private void handleChoiceBox(Number value){
        if (value.intValue() == 1){
            mainApp.showWeatherTodayL();
        }
    }
	
	public void setMainApp(GUIAstronomy mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    public void openPreferences(){
       // mainApp.showPreferences();
    }

}
