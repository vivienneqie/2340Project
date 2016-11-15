package sample;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mitchell on 11/15/16.
 */
public class LocationTest {
    @Test
    public void createWithSameName() {
        Location a1 = new Location("A place", 100, 100);
        Assert.assertNotNull(new Location("A place", 111, 111));
    }
}
