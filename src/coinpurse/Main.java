package coinpurse;

/**
 * Main (application) class creates objects and starts the application.
 *
 * @author Wanchanapon Thanwaranurak
 *
 */
public class Main {
    /**
     * CAPACITY is a maximum size of purse.
     */
    private static int CAPACITY = 10;

    /**
     * Configure and start the application.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Purse purse = new Purse(CAPACITY);
        ConsoleDialog ui = new ConsoleDialog(purse);
        ui.run();
    }
}
