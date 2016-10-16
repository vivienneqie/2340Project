package sample;

/**
 * Created by b on 10/14/16.
 */
public class Report {
    //TODO: Change to Location type after implementing GMaps
    private String location;
    private String waterType;
    private String conditionType;

    public Report(String location, String waterType, String conditionType) {
        this.location = location;
        this.waterType = waterType;
        this.conditionType = conditionType;
    }

    public void updateWaterType(String waterType) {
        this.waterType = waterType;
    }

    public void updateConditionType(String conditionType) {
        this.conditionType = conditionType;
    }
}
