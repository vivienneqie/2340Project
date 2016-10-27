package sample;

/**
 * Created by b on 10/27/16.
 */
public class Facade {
    private static final Facade instance = new Facade();

    /**
     * A static getter method to get facade instance
     * @return facade instance
     */
    public static Facade getInstance() {
        return instance;
    }

    private Facade() {
        Location l = new Location("gatech", 33.46, 84.24);

    }
}
