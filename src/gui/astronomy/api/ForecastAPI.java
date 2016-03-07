package gui.astronomy.api;


import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.ForecastIO;

public class ForecastAPI {
    public static void main(String[] args) {
        ForecastIO forecastIO = new ForecastIO("bc0133119392bffecb344ea72c863a4c");
        forecastIO.setUnits(ForecastIO.UNITS_UK);
        forecastIO.getForecast("0", "0");
        FIOCurrently currently = new FIOCurrently(forecastIO);
        String[] f = currently.get().getFieldsArray();
        for (int i =0; i<f.length; i++)
            System.out.println(f[i] + ": " + currently.get().getByKey(f[i]));
    }
}
