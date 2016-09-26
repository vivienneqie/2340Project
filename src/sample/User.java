package sample;

public class User {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String title;

    /**
     * Empty constructor with default title
     */
    public User() {
        title = "User";
    }

    /**
     * User constructor
     * @param username User's user name
     * @param password User's password
     * @param email User's email address
     * @param firstName User's first name
     * @param lastName User's last name
     * @param phoneNumber User's phone number
     */
    public User(String username, String password, String email,
                String firstName, String lastName, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        title = "User";
    }

    /**
     * Getter function for User's title
     * @return String title
     */
    public String getTitle() {
        return title;
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
    }
}