package sample;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static sample.AccountTypes.USER;

/**
 * @author Brittany
 * @author Vivienne
 * @author Arshiya
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String homeAddress;
    private AccountTypes accType;
    private static Map<String, User> userDB = new HashMap<>();

    /**
     * Empty constructor with default title
     */
    public User() {
        accType = USER;
    }

    /**
     * Constructor with no account type
     * @param username User's user name
     * @param password User's password
     * @param email User's email address
     * @param firstName User's first name
     * @param lastName User's last name
     */
    public User(String username, String password, String email,
                String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * User constructor
     * @param username User's user name
     * @param password User's password
     * @param email User's email address
     * @param firstName User's first name
     * @param lastName User's last name
     */
    public User(String username, String password, String email,
                String firstName, String lastName, AccountTypes accType) {
        Random r = new Random();
        this.id = r.nextInt() * 7 + 11;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accType = accType;
        ReportDatabase rb = new ReportDatabase();
        rb.insertUser(this);
    }

    /**
     * Equals method
     * @param o object to compare
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(username, user.username)
                && Objects.equals(email, user.email);
    }

    /**
     * Hash code method
     * @return int hash code of username and email
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, email);
    }

    /**
     * Getter function for ID
     * @return int user id
     */
    public int getID() {
        return id;
    }

    /**
     * Getter function for username
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter function for username
     * @param username User's username
     */
    public void setUsername(String username) {
        this.username = username;
        //rb.updateUserName(this);
    }

    /**
     * Getter function for password
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter function for password
     * @param password User's password
     */
    public void setPassword(String password) {
        this.password = password;
        //rb.updateUserPass(this);
    }

    /**
     * Getter function for email
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter function for email
     * @param email User's email
     */
    public void setEmail(String email) {
        this.email = email;
        //rb.updateUserEmail(this);
    }

    /**
     * Getter function for first name
     * @return String first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter function for first name
     * @param firstName User's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        //rb.updateUserFirst(this);
    }

    /**
     * Getter function for last name
     * @return String last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter function for last name
     * @param lastName User's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
        //rb.updateUserLast(this);
    }

    /**
     * Getter function for phone number
     * @return String phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter function for phone number
     * @param phoneNumber User's phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        //rb.updateUserPhone(this);
    }

    /**
     * Getter function for home address
     * @return String home address
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * Setter function for home address
     * @param homeAddress home address
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
        //rb.updateUserHome(this);
    }

    /**
     * Getter function for accType
     */
    public AccountTypes getAccType() {
        return accType;
    }

    /**
     *
     * @param un User's username
     * @param user The User
     */
    public static void addToDatabase(String un, User user) {
        userDB.put(un, user);
    }

    /**
     * Getter function for the database of users
     * @return user database
     */
    public static Map<String, User> getUserDB() {
        return userDB;
    }

    /**
     *
     * @param file The file that contains user data
     * @throws FileNotFoundException file not found exception
     */
    public static void populateUserDB(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.contains("$")) {
                StringTokenizer token = new StringTokenizer(line, "$");
                String un = token.nextToken();
                String json = token.nextToken();
                Gson gson = new Gson();
                User u = gson.fromJson(json, User.class);
                userDB.put(un, u);
            }
        }
        scan.close();
    }

}