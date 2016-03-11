package gui.astronomy.view;

import java.util.Hashtable;
import java.util.Set;

import gui.astronomy.GUIAstronomy;
import gui.astronomy.GUIAstronomy.Preference;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SmallPreferencesSaveController {
	
	// Reference to the main application.
    private GUIAstronomy mainApp;
    public Preference currPref;
   
    
    public void setMainApp(GUIAstronomy mainApp, int c, int v, int t, int w, int h) {
        this.mainApp = mainApp;
        this.currPref = mainApp.new Preference (c, v, t, w, h);
	} 
    
    @FXML
    private void initialize() {
    }
	
	@FXML
	private TextField prefName;
		
	@FXML
	public void sendName(Preference p, String name){
		mainApp.addPreference(p, name);
	}
	
	
	@FXML
	public void handleCancel(){
		mainApp.showPreferences();
	}
	
	
	
	@FXML
	public void handleSave() {
		String name = prefName.getText();  //"hello"; //prefName.getCharacters().toString(); 
		Hashtable<String, Preference> ht = GUIAstronomy.savedPrefs;
		ht.put(name, currPref);
		//sendName(currPref, name);
		mainApp.showPreferences();
	}

//	@FXML
//	public void takePrefs(int c, int v, int t, int w, int h) {
//		System.out.println("here is cloud in takeprefs " + c);
//		Preference p = mainApp.new Preference(c, v, t, w, h);// TODO Auto-generated method stub
//	}
	
	


}