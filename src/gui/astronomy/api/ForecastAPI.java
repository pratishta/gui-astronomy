//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package gui.astronomy.api;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import gui.astronomy.Preferences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ForecastAPI {
    //Creates a new forecastIO object using the our Forecast.io api key
    private ForecastIO forecastIO = new ForecastIO("bc0133119392bffecb344ea72c863a4c");
    private String DEFAULT_LAT = "51";
    private String DEFAULT_LON = "0";
    private ObservableList<Data> columnsHourly;
    private ObservableList<Data> columnsDaily;

    //Constructor to get initial data and set the units
    public ForecastAPI() {
        forecastIO.getForecast(DEFAULT_LAT, DEFAULT_LON);
        forecastIO.setUnits(ForecastIO.UNITS_SI);
    }

    //Sets the location of the forecast
    //Gets the coordinates from the Location Api
    public void setLocation(String location) {
        LatLong latLong = LocationAPI.getCoords(location);
        forecastIO.getForecast(latLong.getLat(), latLong.getLon());
    }

    //Gets the hourly data for the next 24 hours
    //adds data objects to observable list used to display weather data
    public ObservableList<Data> getHourly() {
        FIOHourly hourly = new FIOHourly(this.forecastIO);
        columnsHourly = FXCollections.observableArrayList();

        for (int i = 0; i < 25 && i < hourly.hours(); ++i) {
            FIODataPoint dataPoint = hourly.getHour(i);
            Data data = this.convertDataPoint(dataPoint);
            columnsHourly.add(data);
        }

        return columnsHourly;
    }

    //get the daily data for the next 7 days
    //adds data objects to observable list used to display weather data
    public ObservableList<Data> getDaily() {
        FIODaily daily = new FIODaily(this.forecastIO);
        columnsDaily = FXCollections.observableArrayList();

        for (int i = 0; i < 7 && i < daily.days(); ++i) {
            FIODataPoint dataPoint = daily.getDay(i);
            Data data = this.convertDataPoint(dataPoint);
            columnsDaily.add(data);
        }
        return columnsDaily;
    }

    //converts the dataPoint results into usable formats
    private Data convertDataPoint(FIODataPoint dataPoint) {
        String cloud, vis, temp, wind, humid, time, date;
        int i;
        try {
            i = (int) (dataPoint.cloudCover() * 100);
            cloud = String.valueOf(i);
        } catch (Exception e) {
            cloud = "N/A";
        }
        try {
            i = dataPoint.visibility().intValue();
            vis = String.valueOf(i);
        } catch (Exception e) {
            vis = "N/A";
        }
        try {
            temp = dataPoint.temperature().toString();
        } catch (Exception e) {
            temp = "N/A";
        }
        try {
            wind = dataPoint.windSpeed().toString();
        } catch (Exception e) {
            wind = "N/A";
        }
        try {
            i = (int) (dataPoint.humidity() * 100);
            humid = String.valueOf(i);
        } catch (Exception e) {
            humid = "N/A";
        }
        try {
            time = dataPoint.time().substring(11, 13);
        } catch (Exception e) {
            time = "ERR";
        }
        try {
            date = dataPoint.time().substring(0, 5).replace("-", "/");
        } catch (Exception e) {
            date = "ERR";
        }
        return new Data(cloud, vis, temp, wind, humid, time, date);
    }

    public String getSunriseTime(int day) {
        FIODaily daily = new FIODaily(this.forecastIO);
        return daily.getDay(day).sunriseTime().substring(0, 5);
    }

    public String getSunsetTime(int day) {
        FIODaily daily = new FIODaily(this.forecastIO);
        return daily.getDay(day).sunsetTime().substring(0, 5);
    }

    public String[] getLunarPhaseName(int day) {
        FIODaily daily = new FIODaily(this.forecastIO);
        int index = -1;
        String[] h = daily.getDay(day).getFieldsArray();
        for (int j = 0; j < h.length; j++) {
            if (h[j].equals("moonPhase")) {
                index = j;
                break;
            }
        }

        String[] lunarPhase = new String[3];

        Double moonPhase = Double.parseDouble(daily.getDay(day).getByKey(h[index]));
        lunarPhase[2] = String.valueOf(moonPhase * 100);

        if (moonPhase >= 0.0625 && moonPhase < 0.1875) {
            lunarPhase[0] = "Waxing Crescent";
            lunarPhase[1] = "waxingCrescent";
        } else if (moonPhase >= 0.1875 && moonPhase < 0.3125) {
            lunarPhase[0] = "First Quarter";
            lunarPhase[1] = "firstQuarter";
        } else if (moonPhase >= 0.3125 && moonPhase < 0.4375) {
            lunarPhase[0] = "Waxing Gibbous";
            lunarPhase[1] = "waxingGibbous";
        } else if (moonPhase >= 0.4375 && moonPhase < 0.5625) {
            lunarPhase[0] = "Full Moon";
            lunarPhase[1] = "fullMoon";
        } else if (moonPhase >= 0.5625 && moonPhase < 0.6875) {
            lunarPhase[0] = "Waning Gibbous";
            lunarPhase[1] = "waningGibbous";
        } else if (moonPhase >= 0.6875 && moonPhase < 0.8125) {
            lunarPhase[0] = "Third Quarter";
            lunarPhase[1] = "thirdQuarter";
        } else if (moonPhase >= 0.8125 && moonPhase < 0.9375) {
            lunarPhase[0] = "Waning Crescent";
            lunarPhase[1] = "waningCrescent";
        } else {
            lunarPhase[0] = "New Moon";
            lunarPhase[1] = "newMoon";
        }
        return lunarPhase;
    }

    //This calculates which the best hour is according the users preferences
    public int caculateBestHour(Preferences preferences) {
        double clouds = preferences.getClouds();
        double visibility = preferences.getVisibility();
        double temp = preferences.getTemp();
        double wind = preferences.getWind();
        double humidity = preferences.getHumidity();

        int[] scores = new int[7];


        double tempValue;
        for (int i = 0; i < 7; i++) {
            Data data = columnsHourly.get(i);
            try {
                tempValue = Double.valueOf(data.getCloudCoverage());
            } catch (Exception e) {
                tempValue = clouds;
            }
            scores[i] += Math.abs(clouds - (tempValue));
            try {
                tempValue = Double.valueOf(data.getVisibility());
            } catch (Exception e) {
                tempValue = visibility;
            }
            scores[i] += Math.abs(visibility - tempValue);
            try {
                tempValue = Double.valueOf(data.getTemperature());
            } catch (Exception e) {
                tempValue = temp;
            }
            scores[i] += Math.abs(temp - Double.valueOf(data.getTemperature()));
            try {
                tempValue = Double.valueOf(data.getWind());
            } catch (Exception e) {
                tempValue = wind;
            }
            scores[i] += Math.abs(wind - Double.valueOf(data.getWind()));
            try {
                tempValue = Double.valueOf(data.getHumidity());
            } catch (Exception e) {
                tempValue = humidity;
            }
            scores[i] += Math.abs(humidity - Double.valueOf(data.getHumidity()));
        }
        int smallestDiff = scores[0];
        int bestHour = 0;
        for (int i = 1; i < 7; i++) {
            if (smallestDiff > scores[i]) {
                smallestDiff = scores[i];
                bestHour = i;
            }
        }
        return bestHour;
    }


}
