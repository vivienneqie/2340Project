package sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author Brittany
 * @author Arshiya
 * @author Vivienne
 */
public class Report {
    //TODO: Change to Location type after implementing GMaps
    private Location location;
    private String waterType;
    private String conditionType;
    private int id;
    private String dateTime;
    private ReportDatabase rb = new ReportDatabase();

    /**
     * Report constructor
     * @param location location of water
     * @param waterType type of water
     * @param conditionType condition of water
     */
    public Report(Location location, String waterType, String conditionType) {
        Random r = new Random();
        id = r.nextInt() * 7 + 11;
        this.location = location;
        this.waterType = waterType;
        this.conditionType = conditionType;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        dateTime = dateFormat.format(date);
        rb.insertEntry(this);
    }

    /**
     * Getter method for report ID
     * @return int
     */
    public int getID() {
        return id;
    }

    /**
     * Getter method for location
     * @return String
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Getter method for type of water
     * @return String
     */
    public String getType() {
        return waterType;
    }

    /**
     * Getter method for condition of water
     * @return String
     */
    public String getCondition() {
        return conditionType;
    }

    /**
     * Getter method for date and time
     * @return String
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Method to update the water type locally and in the database
     * @param waterType String
     */
    public void updateWaterType(String waterType) {
        this.waterType = waterType;
        rb.updateWaterType(this);
    }

    /**
     * Method to update the condition of water locally and in the database
     * @param conditionType String
     */
    public void updateConditionType(String conditionType) {
        this.conditionType = conditionType;
        rb.updateCondition(this);
    }
}
