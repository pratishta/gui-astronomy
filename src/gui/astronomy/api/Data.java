package gui.astronomy.api;

public class Data {
    private String cloudCoverage;
    private String visibility;
    private String temperature;
    private String wind;
    private String humidity;

    public Data(String cloudCoverage, String visibility, String temperature, String wind, String humidity) {
        this.cloudCoverage = cloudCoverage;
        this.visibility = visibility;
        this.temperature = temperature;
        this.wind = wind;
        this.humidity = humidity;
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
