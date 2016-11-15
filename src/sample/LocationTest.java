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
    @Test
    public void createWithSameCoords() {
        Location b1 = new Location("aaa", 9, 9);
        Assert.assertNotNull(new Location("bbb", 9, 9));
    }
    @Test
    public void toStringName() {
        String name = "Antarctica";
        Location c1 = new Location(name, 999, 999);
        Assert.assertEquals(name, c1.toString());
    }
}
