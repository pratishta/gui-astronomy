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
    
    public String getSunriseTime(int day){
    	FIODaily daily = new FIODaily(this.forecastIO);
    	return daily.getDay(day).sunriseTime().substring(0, 5);
    } 
    
    public String getSunsetTime(int day){
    	FIODaily daily = new FIODaily(this.forecastIO);
    	return daily.getDay(day).sunsetTime().substring(0, 5);
    }
    
    public String[] getLunarPhaseName(int day){
    	FIODaily daily = new FIODaily(this.forecastIO);
    	int index = -1; 
    	String [] h = daily.getDay(day).getFieldsArray();
    	for(int j=0; j<h.length; j++){
    		if (h[j].equals("moonPhase")){
    			index = j;
    			break;
    		}
    	}
    	
    	String[] lunarPhase = new String[2];
    	
    	Double moonPhase= Double.parseDouble(daily.getDay(day).getByKey(h[index]));
    	
    	if (moonPhase >= 0.0625 && moonPhase < 0.1875){
    		lunarPhase[0]="Waxing Crescent";
    		lunarPhase[1]="waxingCrescent";
    	}
    	else if (moonPhase >= 0.1875 && moonPhase < 0.3125){
    		lunarPhase[0]="First Quarter";
    		lunarPhase[1]="firstQuarter";
    	}
    	else if (moonPhase >= 0.3125 && moonPhase < 0.4375){
    		lunarPhase[0]="Waxing Gibbous";
    		lunarPhase[1]="waxingGibbous";
    	}
    	else if (moonPhase >= 0.4375 && moonPhase < 0.5625){
    		lunarPhase[0]="Full Moon";
    		lunarPhase[1]="fullMoon";
    	}
    	else if (moonPhase >= 0.5625 && moonPhase < 0.6875){
    		lunarPhase[0]="Waning Gibbous";
    		lunarPhase[1]="waningGibbous";
    	}
    	else if (moonPhase >= 0.6875 && moonPhase < 0.8125){
    		lunarPhase[0]="Third Quarter";
    		lunarPhase[1]="thirdQuarter";
    	}
    	else if (moonPhase >= 0.8125 && moonPhase < 0.9375){
    		lunarPhase[0]="Waning Crescent";
    		lunarPhase[1]="waningCrescent";
    	}
    	else {
    		lunarPhase[0]="New Moon";
    		lunarPhase[1]="newMoon";
    	}
    	return lunarPhase; 
    }
}
