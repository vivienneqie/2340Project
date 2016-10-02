package sample;

/**
 * Created by Mitchell on 10/1/2016.
 */
public class Actor {
    private String password;
    private String username;
    private String name;
    private AccountTypes accountType;

    public Actor(String aUse, String aPass, String aName, AccountTypes acc) {
        password = aPass;
        username = aUse;
        name = aName;
        accountType = acc;
    }

    public String getName() {
        return name;
    }
}
