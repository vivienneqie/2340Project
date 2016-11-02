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
            String sql = "INSERT INTO AVAILABLE (ID,LOCATION,TYPE,CONDITION,DATE,LATITUDE,LONGITUDE) "
                    + "VALUES ("+ r.getID() +", '"+ r.getLocation() +"', '"+ r.getType()
                    + "', '"+ r.getCondition() +"', '" + r.getDateTime() +"', '" + r.getLocation().getLatitude()
                    + "', '" + r.getLocation().getLongitude() +"');";
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
     * Method to insert the user in the database
     * @param u User
     */
    public void insertUser(User u) {
        try{
            stmt = conn.createStatement();
            String sql = "INSERT INTO USER (id,username,password,email,firstName,lastName,phoneNumber,homeAddress,accType) " +
                    "VALUES ("+ u.getID() +", '"+ u.getUsername() +"', '"+ u.getPassword() + "', '"+ u.getEmail() +"', '" + u.getFirstName() + "', '" + u.getLastName() + "', '" + u.getPhoneNumber() + "', '" + u.getHomeAddress() + "', '" + u.getAccType() + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * updates username of user
     * @param u user
     */
    public void updateUserName(User u) {
        try{
            stmt = conn.createStatement();
            String sql = "UPDATE USER SET username = '" + u.getUsername() + "' WHERE ID = " + u.getID() + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * updates password of user
     * @param u user
     */
    public void updateUserPass(User u) {
        try{
            stmt = conn.createStatement();
            String sql = "UPDATE USER SET password = '" + u.getPassword() + "' WHERE ID = " + u.getID() + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * updates email of user
     * @param u user
     */
    public void updateUserEmail(User u) {
        try{
            stmt = conn.createStatement();
            String sql = "UPDATE USER SET email = '" + u.getEmail() + "' WHERE ID = " + u.getID() + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * updates first name of user
     * @param u user
     */
    public void updateUserFirst(User u) {
        try{
            stmt = conn.createStatement();
            String sql = "UPDATE USER SET firstName = '" + u.getFirstName() + "' WHERE ID = " + u.getID() + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * updates last name of user
     * @param u user
     */
    public void updateUserLast(User u) {
        try{
            stmt = conn.createStatement();
            String sql = "UPDATE USER SET lastName = '" + u.getLastName() + "' WHERE ID = " + u.getID() + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * updates phone number of user
     * @param u user
     */
    public void updateUserPhone(User u) {
        try{
            stmt = conn.createStatement();
            String sql = "UPDATE USER SET phoneNumber = '" + u.getPhoneNumber() + "' WHERE ID = " + u.getID() + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * updates email of user
     * @param u user
     */
    public void updateUserHome(User u) {
        try{
            stmt = conn.createStatement();
            String sql = "UPDATE USER SET homeAddress = '" + u.getHomeAddress() + "' WHERE ID = " + u.getID() + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}