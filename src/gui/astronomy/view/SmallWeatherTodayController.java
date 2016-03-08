package gui.astronomy.view;

import gui.astronomy.GUIAstronomy;
import gui.astronomy.api.ForecastAPI;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmallWeatherTodayController {
    
    private GUIAstronomy mainApp;
    private ForecastAPI forecast;
    
    @FXML
    private Label Date;
    @FXML
    private Label sunriseTime; 
    @FXML
    private Label sunsetTime; 
    
    @FXML
    private ImageView lunarPic;
    @FXML
    private Label lunarCycle;
    @FXML
    private Label lunarPercentage; 
    
    @FXML
    private ChoiceBox<String> viewLayoutSelection;
    
    @FXML
    private ComboBox<String> locationSelection;
    
    public SmallWeatherTodayController(){
    }
    
    @FXML
    private void initialize(){
        
        Format formatter = new SimpleDateFormat("MMM d");
        Date.setText(formatter.format(new Date()));
        
        // Handle Forecast heading info 
        forecast = new ForecastAPI(); 
        sunriseTime.setText(forecast.getSunriseTime(0));
        sunsetTime.setText(forecast.getSunsetTime(0));
        
        
        // Handle changes in Location 
        locationSelection.getItems().add("London");
        locationSelection.setEditable(true); 
        locationSelection.getSelectionModel().selectFirst();
        locationSelection.valueProperty().addListener(new ChangeListener<String>(){
        	public void changed(ObservableValue ov, String oldValue, String newValue){
        		
        	}
        });
        
        handleLunarPhases();
        
        viewLayoutSelection.getItems().addAll("Today","This Week");
        viewLayoutSelection.getSelectionModel().selectFirst();
        viewLayoutSelection.getSelectionModel().selectedIndexProperty().addListener( (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> handleChoiceBox(newValue));
    }
    
    private void handleLunarPhases(){
    	lunarCycle.setText(forecast.getLunarPhaseName(0)[0]);
    	
    	Image image = new Image(getClass().getResource("/resources/images/"+forecast.getLunarPhaseName(0)[1]+".png").toExternalForm());
    	lunarPic.setImage(image);
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