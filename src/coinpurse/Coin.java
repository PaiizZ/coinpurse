package coinpurse;

/**
 * a coin with a monetary value and currency
 *
 * @author Wanchanapon Thanwaranurak
 * @version 10/2/2017.
 */
public class Coin extends AbstractValuable {
    public static final String DEFAULT_CURRENCY = "Baht";

    /**
     * A coin with given value using the default currency.
     *
     * @param value of the coin.
     */
    public Coin(double value) {
        super(value, DEFAULT_CURRENCY);
    }

    /**
     * A coin with given value and currency.
     *
     * @param value    of the coin.
     * @param currency of coin.
     */
    public Coin(double value, String currency) {
        super(value, currency);
    }

    /**
     * Print of the value of coin.
     *
     * @return word of value of the coin.
     */
    public String toString() {
        return super.getValue() + " " + super.getCurrency();
    }


}
