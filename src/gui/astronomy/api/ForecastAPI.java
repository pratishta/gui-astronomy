//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package gui.astronomy.api;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import gui.astronomy.api.Data;
import gui.astronomy.api.LatLong;
import gui.astronomy.api.LocationAPI;
import gui.astronomy.api.Units;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ForecastAPI {
    private ForecastIO forecastIO = new ForecastIO("bc0133119392bffecb344ea72c863a4c");
    private String DEFAULT_LAT = "51";
    private String DEFAULT_LON = "0";

    public ForecastAPI() {
        this.forecastIO.getForecast(this.DEFAULT_LAT, this.DEFAULT_LON);
    }

    public void setLocation(String location) {
        LatLong latLong = LocationAPI.getCoords(location);
        System.out.print(this.forecastIO.getForecast(latLong.getLat(), latLong.getLon()));
    }

    public void setUnits(Units unit) {
        if(unit == Units.UK) {
            this.forecastIO.setUnits("uk");
        } else {
            this.forecastIO.setUnits("us");
        }

    }

    public ObservableList<Data> getHourly() {
        FIOHourly hourly = new FIOHourly(this.forecastIO);
        ObservableList columns = FXCollections.observableArrayList();

        for(int i = 0; i < 25 && i < hourly.hours(); ++i) {
            FIODataPoint dataPoint = hourly.getHour(i);

            try {
                Data data = this.convertDataPoint(dataPoint);
                columns.add(data);
            } catch (Exception var6) {
                ;
            }
        }

        return columns;
    }

    public ObservableList<Data> getDaily() {
        FIODaily daily = new FIODaily(this.forecastIO);
        ObservableList columns = FXCollections.observableArrayList();

        for(int i = 0; i < 7 && i < daily.days(); ++i) {
            FIODataPoint dataPoint = daily.getDay(i);

            try {
                Data data = this.convertDataPoint(dataPoint);
                columns.add(data);
            } catch (Exception var6) {
                ;
            }
        }

        return columns;
    }

    private Data convertDataPoint(FIODataPoint dataPoint) {
        return new Data(dataPoint.cloudCover().toString(), dataPoint.visibility().toString(), dataPoint.temperature().toString(), dataPoint.windSpeed().toString(), dataPoint.humidity().toString());
    }
}
