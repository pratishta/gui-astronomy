package gui.astronomy.view;

import gui.astronomy.GUIAstronomy;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class SmallWeatherWeekController {
    
    private GUIAstronomy mainApp;
    
    @FXML
    private Label date1;
    @FXML
    private Label date2;
    @FXML
    private Label date3;
    @FXML
    private Label date4;
    @FXML
    private Label date5;
    @FXML
    private Label date6;
    @FXML
    private Label day2;
    @FXML
    private Label day3;
    @FXML
    private Label day4;
    @FXML
    private Label day5;
    @FXML
    private Label day6;
    
    @FXML
    private ChoiceBox<String> viewLayoutSelection;
    
    @FXML
    private ComboBox<String> locationSelection;
    
    @FXML
    private void initialize(){
    	
    	// Displays dates and days of the week
    	Format dateFormat = new SimpleDateFormat("MMM d");
    	Date today = new Date();
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(today);
    	int year = cal.get(Calendar.YEAR);
    	int month = cal.get(Calendar.MONTH);
    	int day = cal.get(Calendar.DATE);
    	
    	date1.setText(dateFormat.format(today));
    	date2.setText(dateFormat.format(new GregorianCalendar(year, month, day+1).getTime()));
    	date3.setText(dateFormat.format(new GregorianCalendar(year, month, day+2).getTime()));
    	date4.setText(dateFormat.format(new GregorianCalendar(year, month, day+3).getTime()));
    	date5.setText(dateFormat.format(new GregorianCalendar(year, month, day+4).getTime()));
    	date6.setText(dateFormat.format(new GregorianCalendar(year, month, day+5).getTime()));
        
        viewLayoutSelection.getItems().addAll("This Week","Today");
        viewLayoutSelection.getSelectionModel().selectFirst();
        viewLayoutSelection.getSelectionModel().selectedIndexProperty().addListener( (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> handleChoiceBox(newValue));
        
        // Handle changes in Location 
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