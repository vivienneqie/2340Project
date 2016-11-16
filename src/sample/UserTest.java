package sample;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vivienne
 */
public class UserTest {

    @Test
    public void testEquals() {
        String username1 = "vivienneqie";
        String username2 = "vqie3";
        String email1 = "qievi@gatech.edu";
        String email2 = "vqie3@gatech.edu";

        User user1 = new User(username1, "password", email1, "Vivienne", "Qie");
        User user2 = new User(username1, "pass", email1, "V", "Q");

        User user = null;

        // Testing null user
        Assert.assertFalse(user1.equals(user));

        // Testing class equality
        Assert.assertTrue(user1.getClass() == user2.getClass());

        // Testing 2 users with same username and email
        Assert.assertTrue(user1.equals(user2));

        User user3 = new User(username2, "password", email2, "Vivienne", "Qie");

        // Testing 2 users with different username and email
        Assert.assertFalse(user1.equals(user3));

    }

}
