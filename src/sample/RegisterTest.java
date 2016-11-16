package sample;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.TIMEOUT;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

/**
 * Created by b on 11/16/16.
 */
public class RegisterTest {

    private List<User> users;
    private static final int TIMEOUT = 200;

    @Before
    public void setUp() {
        users = new ArrayList<>();
        addUsers();
    }

    @Test(timeout = TIMEOUT)
    public void testNullUser() {
        User user = new User();
        assertNotNull(user);
        assertNull(user.getUsername());
    }

    @Test(timeout = TIMEOUT)
    public void testUserInvalidEmail() {
        String email = "!#$%";
        User user = new User("username", "password", email, "first", "last");
        assertTrue(user.getEmail().contains("@"));
    }

    @Test(timeout = TIMEOUT)
    public void testUserInvalidAccountType() {
        User user = new User("a", "g", "wefsd@d.com", "wec", "lkj");
        assertNotNull(user);
        assertNull(user.getAccType());
    }

    @Test(timeout = TIMEOUT)
    public void testDuplicateUsername() {
        String username = "user";
        User user = new User(username, "s", "w1@oi.com", "j", "qiuwh");
        boolean duplicate = true;
        while (duplicate) {
            for (User u : users) {
                if (u.getUsername().equals(user.getUsername())) {
                    duplicate = false;
                }
            }
        }
        assertFalse(duplicate);
    }

    @Test(timeout = TIMEOUT)
    public void testInvalidPhoneNumber() {
        String notYourNumber = "911";
        Random rand = new Random();
        int index = rand.nextInt(users.size());
        User user = users.get(index);
        try {
            user.setPhoneNumber(notYourNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNull(user.getPhoneNumber());
    }

    private void addUsers() {
        users.add(new User("user", "pass", "email@email.com", "first", "last"));
        users.add(new User("a", "b", "c@d.com", "e", "f"));
        users.add(new User("lol", "lol", "lol@lol.com", "lol", "lol"));
        users.add(new User("dank", "memes", "dat@boi.com", "rip", "harambe"));
        users.add(new User("i", "want", "to@eat.com", "eggs", "yum"));
    }

}
