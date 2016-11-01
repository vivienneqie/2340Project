package sample;
import java.sql.*;

/**
 * Created by Archie on 10/14/2016.
 */
public class ReportDatabase {
    Connection conn = null;
    Statement stmt = null;

    /**
     * Report database constructor
     */
    ReportDatabase() {
        try {
            //Register JDBC driver
            Class.forName("org.sqlite.JDBC");
            //Open the connection
            conn = DriverManager.getConnection("jdbc:sqlite:reports.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Method to insert an report into the database
     * @param r Report
     */
    public void insertEntry(Report r) {
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO AVAILABLE (ID,LOCATION,TYPE,CONDITION,DATE) " +
                    "VALUES ("+ r.getID() +", '"+ r.getLocation() +"', '"+ r.getType() + "', '"+ r.getCondition() +"', '" + r.getDateTime() + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Method to update the water type in a report
     * @param r Report
     */
    public void updateWaterType(Report r) {
        try{
            stmt = conn.createStatement();
            String sql = "UPDATE AVAILABLE set TYPE = " + r.getType() + "where ID=" + r.getID() + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            System.out.println("Updated water type with " + r.getType());
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Method to update the condition of the water in a report
     * @param r Report
     */
    public void updateCondition(Report r) {
        try{
            stmt = conn.createStatement();
            String sql = "UPDATE AVAILABLE set CONDITION = " + r.getCondition() + "where ID=" + r.getID() + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            System.out.println("Updated water condition with " + r.getType());
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Method to update the user in a report
     * @param u User
     * @param attribute String
     */
    public void updateUser(User u, String attribute) {
        try{
            stmt = conn.createStatement();
            String attrCaps = attribute.toUpperCase();
            //find attribute method
            //String sql = "UPDATE USER set" + attrCaps + " = " + r.whateverMethod() + "where = " + attrCaps + ";";
            //stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}