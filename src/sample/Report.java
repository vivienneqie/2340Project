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
    public int getID() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return waterType;
    }

    public String getCondition() {
        return conditionType;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void updateWaterType(String waterType) {
        this.waterType = waterType;
        rb.updateWaterType(this);
    }

    public void updateConditionType(String conditionType) {
        this.conditionType = conditionType;
        rb.updateCondition(this);
    }
}
