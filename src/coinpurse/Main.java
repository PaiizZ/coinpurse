package coinpurse;

/**
 * Main (application) class creates objects and starts the application.
 *
 * @author Wanchanapon Thanwaranurak
 * @version 10/2/2017.
 */
public class Main {
    /**
     * CAPACITY is a maximum size of purse can have.
     */
    private static int CAPACITY = 10;

    /**
     * Configure and start the application.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Purse purse = new Purse(CAPACITY);
        PurseBalanceObserver purseBalanceObserver = new PurseBalanceObserver();
        PurseStatusObserver purseStatusObserver = new PurseStatusObserver();
        purse.addObserver(purseBalanceObserver);
        purse.addObserver(purseStatusObserver);
        ConsoleDialog ui = new ConsoleDialog(purse);
        purseBalanceObserver.run();
        purseStatusObserver.run();
        ui.run();
    }
}
