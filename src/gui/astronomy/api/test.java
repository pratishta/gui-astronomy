package gui.astronomy.api;

import gui.astronomy.GUIAstronomy;
import gui.astronomy.Preferences;
import gui.astronomy.view.SmallWeatherTodayController;
import javafx.collections.ObservableList;

/**
 * Created by alici on 10/03/2016.
 */
public class test {
    public static void main(String[] args) {
        ForecastAPI forecastAPI = new ForecastAPI();
        ObservableList<Data> dataObservableList = forecastAPI.getHourly();
        System.out.print(dataObservableList.get(0).getTime());
        SmallWeatherTodayController smallWeatherTodayController = new SmallWeatherTodayController();
        smallWeatherTodayController.setMainApp(new GUIAstronomy(), new Preferences(12, 32,34,44,43));
        smallWeatherTodayController.highLightBestTime(new Preferences(50, 5, 20, 30, 34));
        forecastAPI.getHourly();
        forecastAPI.caculateBestDay(new Preferences(10,12,12,21,23));
    }
}
