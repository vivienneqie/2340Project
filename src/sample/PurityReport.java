package sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author Vivienne
 */
public class PurityReport {
    private Location location;
    private String conditionType;
    private int id;
    private String dateTime;
    private double virusPPM;
    private double contaminantPPM;
    //private ReportDatabase rb = new ReportDatabase();

    /**
     * Purity report constructor
     * @param location location of water
     * @param conditionType overall condition
     * @param virusPPM virus parts/million
     * @param contaminantPPM contaminant parts/million
     */
    public PurityReport(Location location, String conditionType, double virusPPM, double contaminantPPM) {
        Random r = new Random();
        id = r.nextInt() * 7 + 11;
        this.location = location;
        this.virusPPM = virusPPM;
        this.contaminantPPM = contaminantPPM;
        this.conditionType = conditionType;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        dateTime = dateFormat.format(date);
        //rb.insertEntry(this);
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
     * Getter method for virus PPM
     * @return double
     */
    public double getVirusPPM() {
        return virusPPM;
    }

    /**
     * Getter method for contaminant PPM
     * @return double
     */
    public double getContaminantPPM() {
        return contaminantPPM;
    }

    /**
     * Method to update the condition of water locally and in the database
     * @param conditionType String
     */
    public void updateConditionType(String conditionType) {
        this.conditionType = conditionType;
        //rb.updateCondition(this);
    }
}
