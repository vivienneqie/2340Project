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
    public void setUp() {
        int i = 0;
        try {
            db.stmt = db.conn.createStatement();
            String sql = "SELECT * FROM PURITY";
            ResultSet rs = db.stmt.executeQuery(sql);
            int count = rs.getMetaData().getColumnCount();
            while (i < (count + 1)) {
                i += rs.getRow();
            }
            db.stmt.close();
            db.conn.close();
            if (i == count) {
                System.out.println("The number of entries in this table are " + i);
            } else {
                System.out.println("It seems that you have missed counting some entries!");
            }
        } catch (SQLException e) {
            /** on createStatement, executeQuery **/
            System.out.println("Your database connection might be closed. Try opening it again");
        }
    }

    @Test
    public void insertLocation() throws Exception {
        Location sparta = new Location("Sparta", 23.4, 90.3);
        PurityReport report = new PurityReport(sparta, "Treatable - Muddy", 49.2, 10.2);
        db.stmt = db.conn.createStatement();
        String sql = "SELECT LOCATION=" + report.getLocation() + " FROM PURITY WHERE ID=" + report.getID();
        ResultSet set = db.stmt.executeQuery(sql);
        System.out.println(set.getDouble("LATITUDE"));
    }

}