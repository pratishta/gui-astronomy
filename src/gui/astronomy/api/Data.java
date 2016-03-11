package gui.astronomy.api;

/**
 * This class hold weather data per datapoint (hour or day)
 */

public class Data {
    private String cloudCoverage;
    private String visibility;
    private String temperature;
    private String wind;
    private String humidity;
    private String time;
    private String date;

    public Data(String cloudCoverage, String visibility, String temperature, String wind, String humidity, String time, String date) {
        this.cloudCoverage = cloudCoverage;
        this.visibility = visibility;
        this.temperature = temperature;
        this.wind = wind;
        this.humidity = humidity;
        this.time = time;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getCloudCoverage() {
        return this.cloudCoverage;
    }

    public String getVisibility() {
        return this.visibility;
    }

    public String getTemperature() {
        return this.temperature;
    }

    public String getWind() {
        return this.wind;
    }

    public String getHumidity() {
        return this.humidity;
    }
}
