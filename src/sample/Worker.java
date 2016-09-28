package sample;

import java.util.Objects;

public class Worker {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String title;
    private String homeAddress;

    /**
     * Empty constructor with default title
     */
    public Worker() {
        title = "Worker";
    }

    /**
     * Worker constructor
     * @param username Worker's user name
     * @param password Worker's password
     * @param email Worker's email address
     * @param firstName Worker's first name
     * @param lastName Worker's last name
     */
    public Worker(String username, String password, String email,
                  String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        title = "Worker";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Worker worker = (Worker) o;
        return Objects.equals(username, worker.username)
                && Objects.equals(email, worker.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email);
    }

    /**
     * Getter function for Worker's title
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
     * @param username Worker's username
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
     * @param password Worker's password
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
     * @param email Worker's email
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
     * @param firstName Worker's first name
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
     * @param lastName Worker's last name
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
     * @param phoneNumber Worker's phone number
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
     * @param homeAddress Worker's home address
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
}
