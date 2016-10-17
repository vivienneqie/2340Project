package sample;
import java.sql.*;

/**
 * Created by Archie on 10/14/2016.
 */
public class ReportDatabase {
        Connection conn = null;
        Statement stmt = null;

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
            System.out.println("Connected!");
        }

        public void insertEntry(Report r) {
            try {
                stmt = conn.createStatement();
                String sql = "INSERT INTO AVAILABLE (ID,LOCATION,TYPE,CONDITION) " +
                        "VALUES (" + r.getID() +", '"+ r.getLocation() + "', '"+ r.getType() + "', '"+ r.getCondition() + "');";
                stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
                System.out.println("Added entry!");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }

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
}