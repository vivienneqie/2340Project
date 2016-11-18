package sample;
import java.sql.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Archie on 11/13/2016.
 */
public class PurityReportTest {
    PurityDatabase db = new PurityDatabase();

    @Before
    public void numberOfEntries() throws Exception {
        try {
            int i = 0;
            db.stmt = db.conn.createStatement();
            String sql = "SELECT * FROM PURITY";
            ResultSet rs = db.stmt.executeQuery(sql);
            while (rs.next()) {
                i++;
            }
            System.out.println("The number of entries in this table are " + i);
        } catch (SQLException e) {
            /** on createStatement, executeQuery **/
            System.out.println("Your database connection might be closed. Try opening it again");
            e.printStackTrace();
        }
    }

    @Test
    public void insertLocation() throws Exception {
        try {
            Location sparta = new Location("Sparta", 23.4, 90.3);
            PurityReport report = new PurityReport(sparta, "Treatable - Muddy", 49.2, 10.2);
            db.stmt = db.conn.createStatement();
            String sql = "SELECT * FROM PURITY WHERE ID =" + report.getID();
            ResultSet set = db.stmt.executeQuery(sql);
            System.out.println(set.getString("LOCATION"));
            System.out.println(set.getDouble("VIRUS"));
            System.out.println(set.getDouble("CONTAMINANT"));
            numberOfEntries();
            db.stmt.close();
            db.conn.close();
        } catch (Exception e) {
            System.out.println("Your database connection might be closed. Try opening it again or look at this stack trace: ");
            e.printStackTrace();
        }
    }

}