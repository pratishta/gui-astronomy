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
        
        showWeatherOverview();
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
    
    public void showWeatherOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GUIAstronomy.class.getResource("view/WeatherToday-small.fxml"));
            AnchorPane weatherOverview = (AnchorPane) loader.load();
            
            // Set person overview into the center of root layout.
            rootLayout.setCenter(weatherOverview);
            
            // controller access to main app
            SmallWeatherTodayController controller = loader.getController();
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
	   
	   public boolean showPreferencesSaveDialog(){
           try {
               // Load the fxml file and create a new stage for the popup dialog.
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(GUIAstronomy.class.getResource("view/PreferencesSaveDialog.fxml"));
               AnchorPane page = (AnchorPane) loader.load();
               
               Stage dialogStage = new Stage();
               dialogStage.initModality(Modality.WINDOW_MODAL);
               dialogStage.initOwner(primaryStage);
               Scene scene = new Scene(page);
               dialogStage.setScene(scene);
               
               // Set the person into the controller.
               SmallPreferencesSaveController controller = loader.getController();
               controller.setDialogStage(dialogStage);
               
               // Show the dialog and wait until the user closes it
               dialogStage.showAndWait();
               
               return controller.isOkClicked();
           } catch (IOException e) {
               e.printStackTrace();
               return false;
           }
       }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
