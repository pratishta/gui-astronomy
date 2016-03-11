package gui.astronomy.view;

import gui.astronomy.GUIAstronomy;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class SmallWeatherWeekController {
    
    private GUIAstronomy mainApp;
    
    @FXML
    private ChoiceBox<String> viewLayoutSelection;
    
    @FXML
    private void initialize(){
        
        viewLayoutSelection.getItems().addAll("This Week","Today");
        viewLayoutSelection.getSelectionModel().selectFirst();
        viewLayoutSelection.getSelectionModel().selectedIndexProperty().addListener( (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> handleChoiceBox(newValue));
    }
    
    private void handleChoiceBox(Number value){
        if (value.intValue() == 1){
            mainApp.showWeatherToday();
        }
    }
    
    public void setMainApp(GUIAstronomy mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    public void openPreferences(){
        mainApp.showPreferences();
    }
    
}