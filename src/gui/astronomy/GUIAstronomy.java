/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.astronomy;

import java.io.IOException;

import gui.astronomy.api.WeatherAPI;
import gui.astronomy.view.SmallPreferencesController;
import gui.astronomy.view.SmallPreferencesSaveController;
import gui.astronomy.view.SmallWeatherTodayController;
import gui.astronomy.view.SmallWeatherWeekController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author prat
 */
public class GUIAstronomy extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        initRootLayout();
        
        showWeatherToday();
    }
    
	   public void initRootLayout() {
           
           try {
               // Load root layout from fxml file.
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(GUIAstronomy.class.getResource("view/RootLayoutSmall.fxml"));
               rootLayout = (BorderPane) loader.load();
               Scene scene = new Scene(rootLayout);
               
               
               primaryStage.setScene(scene);
               primaryStage.show();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
	   
	   public void showWeatherToday() {
           try {
               // Load person overview.
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(GUIAstronomy.class.getResource("view/WeatherToday-small.fxml"));
               AnchorPane weatherToday = (AnchorPane) loader.load();
               
               // Set person overview into the center of root layout.
               rootLayout.setCenter(weatherToday);
               
               // controller access to main app
               SmallWeatherTodayController controller = loader.getController();
               controller.setMainApp(this);
               
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
	   
	   public void showWeatherWeekView() {
           try {
               // Load person overview.
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(GUIAstronomy.class.getResource("view/WeatherWeek-small.fxml"));
               AnchorPane weatherWeek = (AnchorPane) loader.load();
               
               // Set person overview into the center of root layout.
               rootLayout.setCenter(weatherWeek);
               
               // controller access to main app
               SmallWeatherWeekController controller = loader.getController();
               controller.setMainApp(this);
               
           } catch (IOException e) {
               e.printStackTrace();
           } 
       }
    
    public void showPreferences(){
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GUIAstronomy.class.getResource("view/Preferences-small.fxml"));
            AnchorPane preferences = (AnchorPane) loader.load();
            
            // Set person overview into the center of root layout.
            rootLayout.setCenter(preferences);
            
            // controller access to main app
            SmallPreferencesController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	}
	   
    public void showPreferencesSaveDialog(){
    	try {
           // Load the fxml file and create a new stage for the popup dialog.
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(GUIAstronomy.class.getResource("view/Preferences-smallSaveDialogue.fxml"));
           AnchorPane page = (AnchorPane) loader.load();
           
           // Set person overview into the center of root layout.
           rootLayout.setCenter(page);
            
           // Set the person into the controller.
           SmallPreferencesSaveController controller = loader.getController();
           controller.setMainApp(this);               
               
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
}
