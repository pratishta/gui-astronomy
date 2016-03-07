package gui.astronomy.view;

import gui.astronomy.GUIAstronomy;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmallWeatherTodayController {
    
    private GUIAstronomy mainApp;
    
    @FXML
    private Label Date;
    
    @FXML
    private ChoiceBox<String> viewLayoutSelection;
    
    //@FXML
    //private ComboBox<String> location;
    
    public SmallWeatherTodayController(){
    }
    
    @FXML
    private void initialize(){
        
        Format formatter = new SimpleDateFormat("MMM d");
        Date.setText(formatter.format(new Date()));
        
        //	location.getItems().add("London");
        
        viewLayoutSelection.getItems().addAll("TODAY","THIS WEEK");
        viewLayoutSelection.getSelectionModel().selectFirst();
        viewLayoutSelection.getSelectionModel().selectedIndexProperty().addListener( (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> handleChoiceBox(newValue));
    }
    
    private void handleChoiceBox(Number value){
        if (value.intValue() == 1){
            mainApp.showWeatherWeekView();
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