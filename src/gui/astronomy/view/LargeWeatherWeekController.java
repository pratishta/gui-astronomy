package gui.astronomy.view;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import gui.astronomy.GUIAstronomy;
import gui.astronomy.api.Data;
import gui.astronomy.api.ForecastAPI;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class LargeWeatherWeekController {
	private GUIAstronomy mainApp;
	private ForecastAPI forecast;
	
	@FXML
    private Label date1, date2, date3, date4, date5, date6;
    @FXML
    private Label day2, day3, day4, day5, day6;
    @FXML
    private Label lunar1, lunar2, lunar3, lunar4, lunar5, lunar6;
    @FXML
    private Label clouds1, clouds2, clouds3, clouds4, clouds5, clouds6;
    @FXML
    private Label visibility1, visibility2, visibility3, visibility4, visibility5, visibility6;
    @FXML
    private Label temperature1, temperature2, temperature3, temperature4, temperature5, temeprature6;
    @FXML
    private Label wind1, wind2, wind3, wind4, wind5, wind6;
    @FXML
    private Label humidity1, humidity2, humidity3, humidity4, humidity5, humidity6;
	
	@FXML
    private ChoiceBox<String> viewLayoutSelection;
    
    @FXML
    private ComboBox<String> locationSelection;
    
    @FXML
    private AnchorPane navList;
    @FXML
    private AnchorPane saveDialogPane;
    
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
	
	@FXML
	public void openSavePreferencesDialog(){
		saveDialogPane.setTranslateX(820);
	}
	
	@FXML
    public void settings(){
    	TranslateTransition openNav=new TranslateTransition(new Duration(350), navList);
        openNav.setToX(820);
        TranslateTransition closeNav=new TranslateTransition(new Duration(350), navList);
      
            if(navList.getTranslateX()!=820){
                openNav.play();
            }else{
                closeNav.setToX(1024+(navList.getWidth()));
                closeNav.play();
            } 
    }
	
	@FXML
	public void handleCancel(){
		saveDialogPane.setTranslateX(1470);
	}
	
	@FXML
	private void handleSave() {
		saveDialogPane.setTranslateX(1470);
	}
	
	@FXML
    private void initialize(){
		
		// Displays dates and days of the week
        Format dateFormat = new SimpleDateFormat("MMM d");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);
        
        Label dates[] = {date1, date2, date3, date4, date5, date6};
        for(int i = 0; i < 6; i++) {
            dates[i].setText(dateFormat.format(new GregorianCalendar(year, month, day+i).getTime()));
        }
        
        Format dayFormat = new SimpleDateFormat("EE");
        Label days[] = {day2, day3, day4, day5, day6};
        for(int i = 0; i < 5; i++) {
            days[i].setText(dayFormat.format(new GregorianCalendar(year, month, day+i+1).getTime()));
        }
        
        showWeatherData("London");
		
        viewLayoutSelection.getItems().addAll("This Week","Today");
        viewLayoutSelection.getSelectionModel().selectFirst();
        viewLayoutSelection.getSelectionModel().selectedIndexProperty().addListener( (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> handleChoiceBox(newValue));	
	
        locationSelection.getItems().addAll("London", "Dublin", "Edinburgh", "Berlin", "Brussels", "Copenhagen",
                "Barcelona", "Paris", "Madrid", "Rome", "Florence");
        locationSelection.setEditable(true); 
        locationSelection.getSelectionModel().selectFirst();
        locationSelection.valueProperty().addListener(new ChangeListener<String>(){
        	public void changed(ObservableValue ov, String oldValue, String newValue){
        		showWeatherData(newValue);
        	}
        });	
	}
	
	private void showWeatherData(String location) {
        forecast = new ForecastAPI();
        forecast.setLocation(location);
        ObservableList<Data> weekData = forecast.getDaily();
        
        Label lunarPhases[] = {lunar1, lunar2, lunar3, lunar4, lunar5, lunar6};
        Label cloudsCover[] = {clouds1, clouds2, clouds3, clouds4, clouds5, clouds6};
        Label visibility[] = {visibility1, visibility2, visibility3, visibility4, visibility5, visibility6};
        for(int i = 0; i < 6; i++) {
            lunarPhases[i].setText(forecast.getLunarPhaseName(i)[2].substring(0, forecast.getLunarPhaseName(i)[2].indexOf(".")));
            cloudsCover[i].setText(weekData.get(i).getCloudCoverage());
            visibility[i].setText(weekData.get(i).getVisibility());
        }   
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
