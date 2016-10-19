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
    private String location;
    private String waterType;
    private String conditionType;
    private int id;
    private String dateTime;
    private ReportDatabase rb = new ReportDatabase();

    /**
     *
     * @param location
     * @param waterType
     * @param conditionType
     */
    public Report(String location, String waterType, String conditionType) {
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
     *
     * @return
     */
    public int getID() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return waterType;
    }

    /**
     *
     * @return
     */
    public String getCondition() {
        return conditionType;
    }

    /**
     *
     * @return
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     *
     * @param waterType
     */
    public void updateWaterType(String waterType) {
        this.waterType = waterType;
        rb.updateWaterType(this);
    }

    /**
     *
     * @param conditionType
     */
    public void updateConditionType(String conditionType) {
        this.conditionType = conditionType;
        rb.updateCondition(this);
    }
}
