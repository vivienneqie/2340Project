package sample;

import java.util.Random;

/**
 * Created by b on 10/14/16.
 */
public class Report {
    //TODO: Change to Location type after implementing GMaps
    private String location;
    private String waterType;
    private String conditionType;
    private int id;
    private ReportDatabase rb = new ReportDatabase();

    public Report(String location, String waterType, String conditionType) {
        Random r = new Random();
        id = r.nextInt() * 7 + 11;
        this.location = location;
        this.waterType = waterType;
        this.conditionType = conditionType;
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

    public void updateWaterType(String waterType) {
        this.waterType = waterType;
        rb.updateWaterType(this);
    }

    public void updateConditionType(String conditionType) {
        this.conditionType = conditionType;
        rb.updateCondition(this);
    }
}
