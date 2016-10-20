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
    }
}
