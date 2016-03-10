package gui.astronomy.view;

import gui.astronomy.GUIAstronomy;
import gui.astronomy.api.Data;
import gui.astronomy.api.ForecastAPI;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
    
    @FXML 
    private ScrollPane scrollPane;
    
    @FXML
    private Label clouds1;
    @FXML
    private Label clouds2;
    @FXML
    private Label clouds3;
    @FXML
    private Label clouds4;
    @FXML
    private Label clouds5;
    @FXML
    private Label clouds6;
    @FXML
    private Label clouds7;
    @FXML
    private Label clouds8;
    @FXML
    private Label clouds9;
    @FXML
    private Label clouds10;
    @FXML
    private Label clouds11;
    @FXML
    private Label clouds12;
    @FXML
    private Label clouds13;
    @FXML
    private Label clouds14;
    @FXML
    private Label clouds15;
    @FXML
    private Label clouds16;
    @FXML
    private Label clouds17;
    @FXML
    private Label clouds18;
    @FXML
    private Label clouds19;
    @FXML
    private Label clouds20;
    @FXML
    private Label clouds21;
    @FXML
    private Label clouds22;
    @FXML
    private Label clouds23;
    @FXML
    private Label clouds24;
    @FXML
    private Label visibility1;
    @FXML
    private Label visibility2;
    @FXML
    private Label visibility3;
    @FXML
    private Label visibility4;
    @FXML
    private Label visibility5;
    @FXML
    private Label visibility6;
    @FXML
    private Label visibility7;
    @FXML
    private Label visibility8;
    @FXML
    private Label visibility9;
    @FXML
    private Label visibility10;
    @FXML
    private Label visibility11;
    @FXML
    private Label visibility12;
    @FXML
    private Label visibility13;
    @FXML
    private Label visibility14;
    @FXML
    private Label visibility15;
    @FXML
    private Label visibility16;
    @FXML
    private Label visibility17;
    @FXML
    private Label visibility18;
    @FXML
    private Label visibility19;
    @FXML
    private Label visibility20;
    @FXML
    private Label visibility21;
    @FXML
    private Label visibility22;
    @FXML
    private Label visibility23;
    @FXML
    private Label visibility24;
    @FXML
    private Label temperature1;
    @FXML
    private Label temperature2;
    @FXML
    private Label temperature3;
    @FXML
    private Label temperature4;
    @FXML
    private Label temperature5;
    @FXML
    private Label temperature6;
    @FXML
    private Label temperature7;
    @FXML
    private Label temperature8;
    @FXML
    private Label temperature9;
    @FXML
    private Label temperature10;
    @FXML
    private Label temperature11;
    @FXML
    private Label temperature12;
    @FXML
    private Label temperature13;
    @FXML
    private Label temperature14;
    @FXML
    private Label temperature15;
    @FXML
    private Label temperature16;
    @FXML
    private Label temperature17;
    @FXML
    private Label temperature18;
    @FXML
    private Label temperature19;
    @FXML
    private Label temperature20;
    @FXML
    private Label temperature21;
    @FXML
    private Label temperature22;
    @FXML
    private Label temperature23;
    @FXML
    private Label temperature24;
    @FXML
    private Label wind1;
    @FXML
    private Label wind2;
    @FXML
    private Label wind3;
    @FXML
    private Label wind4;
    @FXML
    private Label wind5;
    @FXML
    private Label wind6;
    @FXML
    private Label wind7;
    @FXML
    private Label wind8;
    @FXML
    private Label wind9;
    @FXML
    private Label wind10;
    @FXML
    private Label wind11;
    @FXML
    private Label wind12;
    @FXML
    private Label wind13;
    @FXML
    private Label wind14;
    @FXML
    private Label wind15;
    @FXML
    private Label wind16;
    @FXML
    private Label wind17;
    @FXML
    private Label wind18;
    @FXML
    private Label wind19;
    @FXML
    private Label wind20;
    @FXML
    private Label wind21;
    @FXML
    private Label wind22;
    @FXML
    private Label wind23;
    @FXML
    private Label wind24;
    @FXML
    private Label humidity1;
    @FXML
    private Label humidity2;
    @FXML
    private Label humidity3;
    @FXML
    private Label humidity4;
    @FXML
    private Label humidity5;
    @FXML
    private Label humidity6;
    @FXML
    private Label humidity7;
    @FXML
    private Label humidity8;
    @FXML
    private Label humidity9;
    @FXML
    private Label humidity10;
    @FXML
    private Label humidity11;
    @FXML
    private Label humidity12;
    @FXML
    private Label humidity13;
    @FXML
    private Label humidity14;
    @FXML
    private Label humidity15;
    @FXML
    private Label humidity16;
    @FXML
    private Label humidity17;
    @FXML
    private Label humidity18;
    @FXML
    private Label humidity19;
    @FXML
    private Label humidity20;
    @FXML
    private Label humidity21;
    @FXML
    private Label humidity22;
    @FXML
    private Label humidity23;
    @FXML
    private Label humidity24;
    
    
    
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
        
        showWeatherData("London");
        
     // Handle changes in Location 
        locationSelection.getItems().addAll("London", "Dublin", "Edinburgh", "Berlin", "Brussels", "Copenhagen",
            "Barcelona", "Paris", "Madrid", "Rome", "Florence");
        locationSelection.setEditable(true); 
        locationSelection.getSelectionModel().selectFirst();
        locationSelection.valueProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue ov, String oldValue, String newValue){
                showWeatherData(newValue);
            }
        });
        
        handleLunarPhases();
        
        viewLayoutSelection.getItems().addAll("Today","This Week");
        viewLayoutSelection.getSelectionModel().selectFirst();
        viewLayoutSelection.getSelectionModel().selectedIndexProperty().addListener( (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> handleChoiceBox(newValue));
    
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
    }
      
    private void showWeatherData(String location) {
        forecast = new ForecastAPI();
        forecast.setLocation(location);
        ObservableList<Data> hourData = forecast.getHourly();
        
        Label cloudCover[] = {clouds1, clouds2, clouds3, clouds4, clouds5, clouds6,clouds7, clouds8, clouds9, clouds10, clouds11, clouds12,clouds13, clouds14, clouds15, clouds16, clouds17, clouds18,clouds19, clouds20, clouds21, clouds22, clouds23, clouds24};
        Label visibility[] = {visibility1, visibility2, visibility3, visibility4, visibility5, visibility6,visibility7, visibility8, visibility9, visibility10, visibility11, visibility12,visibility13, visibility14, visibility15, visibility16, visibility17, visibility18,visibility19, visibility20, visibility21, visibility22, visibility23, visibility24};
        Label temperature[] = {temperature1, temperature2, temperature3, temperature4, temperature5, temperature6,temperature7, temperature8, temperature9, temperature10, temperature11, temperature12,temperature13, temperature14, temperature15, temperature16, temperature17, temperature18,temperature19, temperature20, temperature21, temperature22, temperature23, temperature24};
        Label wind[] = {wind1, wind2, wind3, wind4, wind5, wind6,wind7, wind8, wind9, wind10, wind11, wind12,wind13, wind14, wind15, wind16, wind17, wind18,wind19, wind20, wind21, wind22, wind23, wind24};
        Label humidity[] = {humidity1, humidity2, humidity3, humidity4, humidity5, humidity6,humidity7, humidity8, humidity9, humidity10, humidity11, humidity12,humidity13, humidity14, humidity15, humidity16, humidity17, humidity18,humidity19, humidity20, humidity21, humidity22, humidity23, humidity24};
           for (int i = 0; i < 24; i++){
        	cloudCover[i].setText(hourData.get(i).getCloudCoverage());
            visibility[i].setText(hourData.get(i).getVisibility());
            temperature[i].setText(hourData.get(i).getTemperature());
            wind[i].setText(hourData.get(i).getWind());
            humidity[i].setText(hourData.get(i).getHumidity());
           }
        } 
    
    private void handleLunarPhases(){
    	lunarCycle.setText(forecast.getLunarPhaseName(0)[0]);
    	
    	Image image = new Image(getClass().getResource("/resources/images/"+forecast.getLunarPhaseName(0)[1]+".png").toExternalForm());
    	lunarPic.setImage(image);
    	
    	lunarPercentage.setText(forecast.getLunarPhaseName(0)[2]+"%");
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