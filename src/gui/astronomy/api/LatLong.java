package gui.astronomy.api;

/**
 * Simple class to store coordinates
 */

public class LatLong {
    private String lat;
    private String lon;

    public LatLong(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public String getLat() {
        return this.lat;
    }

    public String getLon() {
        return this.lon;
    }
}
