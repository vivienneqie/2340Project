package sample;

import java.util.Objects;

import static sample.AccountTypes.MANAGER;

public class Manager extends User {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String title;
    private String homeAddress;
    private AccountTypes accType;

    /**
     * Empty constructor with default title
     */
    public Manager() {
        title = "Manager";
        accType = MANAGER;
    }

    /**
     * Manager constructor
     * @param username Manager's user name
     * @param password Manager's password
     * @param email Manager's email address
     * @param firstName Manager's first name
     * @param lastName Manager's last name
     */
    public Manager(String username, String password, String email,
                   String firstName, String lastName) {
        super(username, password, email, firstName, lastName, MANAGER);
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.firstName = firstName;
//        this.lastName = lastName;
        title = "Manager";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Manager manager = (Manager) o;
        return Objects.equals(username, manager.username)
                && Objects.equals(email, manager.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email);
    }

    /**
     * Getter function for Manager's title
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
     * @param username Manager's username
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
     * @param password Manager's password
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
     * @param email Manager's email
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
     * @param firstName Manager's first name
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
     * @param lastName Manager's last name
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
     * @param phoneNumber Manager's phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
     * @param homeAddress Manager's home address
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
}