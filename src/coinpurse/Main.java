package coinpurse;

/**
 * Main (application) class creates objects and starts the application.
 *
 * @author your name
 */
public class Main {
    /**
     *
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
