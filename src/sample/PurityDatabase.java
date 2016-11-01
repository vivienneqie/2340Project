package sample;
import java.sql.*;

/**
 * @author Vivienne
 */
public class PurityDatabase {
    Connection conn = null;
    Statement stmt = null;

    /**
     * Purity report database constructor
     */
    PurityDatabase() {
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
     * @param r PurityReport
     */
    public void insertEntry(PurityReport r) {
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO PURITY (ID,LOCATION,CONDITION,VIRUS,CONTAMINANT,DATE) " +
                    "VALUES ("+ r.getID() +", '"+ r.getLocation() +"', '"+ r.getCondition() +"', '"+ r.getVirusPPM() +"', '"+ r.getContaminantPPM() +"', '"+ r.getDateTime() + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
