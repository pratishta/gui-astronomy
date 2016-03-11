/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.astronomy;

import java.io.IOException;
import java.util.Hashtable;

import gui.astronomy.view.LargeWeatherTodayController;
import gui.astronomy.view.LargeWeatherWeekController;
import gui.astronomy.view.SmallPreferencesController;
import gui.astronomy.view.SmallPreferencesSaveController;
import gui.astronomy.view.SmallWeatherTodayController;
import gui.astronomy.view.SmallWeatherWeekController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 *
 * @author prat
 */
public class GUIAstronomy extends Application {

	public static Hashtable<String, Preferences> savedPrefs = new Hashtable<String, Preferences>();

    private Stage primaryStage;
    private BorderPane rootLayoutSmall;
    private BorderPane rootLayoutLarge;
    private Scene sceneSmall;
    private Scene sceneLarge;
    
    
    public void addPreference(Preferences p, String name) {
    	savedPrefs.put(name, p);
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        primaryStage.setTitle("Astromate");
        primaryStage.getIcons().add(new Image("resources/images/icon.png"));

        initRootLayout();
        
        showWeatherToday(savedPrefs.get("Default"));
        showWeatherTodayL();
    }
    
	   public void initRootLayout() {
           
           try {
        	   savedPrefs.put("Default", new Preferences(0, 0, 0, 0, 0));
               // Load root layout from fxml file.
        	   FXMLLoader loader = new FXMLLoader();
               loader.setLocation(GUIAstronomy.class.getResource("view/RootLayoutSmall.fxml"));
               rootLayoutSmall = (BorderPane) loader.load();
               sceneSmall = new Scene(rootLayoutSmall);
               
               FXMLLoader loader2 = new FXMLLoader();
               loader2.setLocation(GUIAstronomy.class.getResource("view/RootLayoutLarge.fxml"));
               rootLayoutLarge = (BorderPane) loader2.load();
               sceneLarge = new Scene(rootLayoutLarge);
               
               sceneSmall.setOnKeyPressed(new EventHandler<KeyEvent>(){
            	   public void handle(KeyEvent ke) {
            		   if (ke.getCode().toString().equals("SHIFT")){
            			   primaryStage.setScene(sceneLarge);
                           primaryStage.show();
            		   }
            	   }
               });
               
               sceneLarge.setOnKeyPressed(new EventHandler<KeyEvent>(){
            	   public void handle(KeyEvent ke) {
            		   if (ke.getCode().toString().equals("SHIFT")){
            			   primaryStage.setScene(sceneSmall);
                           primaryStage.show();
            		   }
            	   }
               });
                   
               primaryStage.setScene(sceneSmall);
               primaryStage.show();
               Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
               primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 4);
               primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 8);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
	   
	   public void showWeatherToday(Preferences p) {
           try {
               // Load person overview.
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(GUIAstronomy.class.getResource("view/WeatherToday-small.fxml"));
               AnchorPane weatherToday = (AnchorPane) loader.load();
               
               // Set person overview into the center of root layout.
               rootLayoutSmall.setCenter(weatherToday);
               
               // controller access to main app
               SmallWeatherTodayController controller = loader.getController();
               controller.setMainApp(this, p);
               
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
	   
	   public void showWeatherTodayL() {
           try {
               // Load person overview.
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(GUIAstronomy.class.getResource("view/WeatherToday-large.fxml"));
               AnchorPane weatherToday = (AnchorPane) loader.load();
               
               // Set person overview into the center of root layout.
               rootLayoutLarge.setCenter(weatherToday);
               
               // controller access to main app
               LargeWeatherTodayController controller = loader.getController();
               controller.setMainApp(this);
               
           } catch (IOException e) {
               e.printStackTrace();
           } 
       }
	   
	   public void showWeatherWeekView(Preferences p) {
           try {
               // Load person overview.
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(GUIAstronomy.class.getResource("view/WeatherWeek-small.fxml"));
               AnchorPane weatherWeek = (AnchorPane) loader.load();
               
               // Set person overview into the center of root layout.
               rootLayoutSmall.setCenter(weatherWeek);
               
               // controller access to main app
               SmallWeatherWeekController controller = loader.getController();
               controller.setMainApp(this, p);
               
           } catch (IOException e) {
               e.printStackTrace();
           } 
       }
	   
	   public void showWeatherWeekViewL() {
           try {
               // Load person overview.
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(GUIAstronomy.class.getResource("view/WeatherWeek-large.fxml"));
               AnchorPane weatherWeek = (AnchorPane) loader.load();
               
               // Set person overview into the center of root layout.
               rootLayoutLarge.setCenter(weatherWeek);
               
               // controller access to main app
               LargeWeatherWeekController controller = loader.getController();
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
            rootLayoutSmall.setCenter(preferences);
            
            // controller access to main app
            SmallPreferencesController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	}
	   
    public void showPreferencesSaveDialog(int c, int v, int t, int w, int h){
    	
    	try {
    		// Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GUIAstronomy.class.getResource("view/Preferences-smallSaveDialogue.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
           
            // Set person overview into the center of root layout.
            rootLayoutSmall.setCenter(page);
           
            
           // Set the person into the controller.
            SmallPreferencesSaveController controller = loader.getController();
           // controller.takePrefs(c, v, t, w, h);
           
            controller.setMainApp(this, c, v, t, w, h);
               
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
