package sample;


/**
 * Created by b on 10/15/16.
 */
public class Location {
    private String name;
    private double longitude;
    private double latitude;

    /**
     * Location constructor
     * @param name String name of location
     * @param longitude double longitude of location
     * @param latitude double latitude of location
     */
    public Location(String name, double longitude, double latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
//        position = new LatLong(longitude, latitude);
    }

    /**
     * A getter method for location name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * A getter method for location name
     * @return name
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * A getter method for longitude
     * @return longitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * A setter method to reset coordinates
     * @param latitude double latitude of location
     * @param longitude double longitude of location
     */
    public void setLatLong(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return name;
    }
    }
