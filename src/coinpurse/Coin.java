package coinpurse;

/**
 * a coin with a monetary value and currency
 *
 * @author Wanchanapon Thanwaranurak
 * @version 10/2/2017.
 */
public class Coin implements Comparable<Coin> {
    public static final String DEFAULT_CURRENCY = "Baht";
    /**
     * Value of the coin.
     */
    private final double value;
    /**
     * The currency, of coin.
     */
    private final String currency;

    /**
     * A coin with given value using the default currency.
     *
     * @param value of the coin.
     */
    public Coin(double value) {
        this.value = value;
        this.currency = DEFAULT_CURRENCY;
    }

    /**
     * A coin with given value and currency.
     *
     * @param value    of the coin.
     * @param currency of coin.
     */
    public Coin(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    /**
     * Return the value of the coin.
     *
     * @return the value of the coin.
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Return the currency of coin.
     *
     * @return currency of coin.
     */
    public String getCurrency() {
        return this.currency;
    }

    /**
     * Check between 2 things that are same.
     *
     * @param obj is a some object.
     * @return true when equals, false when on equals.
     */
    public boolean equals(Object obj) {
        if (obj != null) {
            if (this.getClass() == obj.getClass()) {
                if (this.value == ((Coin) obj).getValue() && this.currency.equals(((Coin) obj).getCurrency())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Compare between 2 value that who more than.
     *
     * @param c is a coin.
     * @return -1 if less than c , 1 if more than c and 0 if equal c
     */
    @Override
    public int compareTo(Coin c) {
        if (this.value < c.getValue()) {
            return -1;
        } else if (this.value > c.getValue()) {
            return 1;
        }
        return 0;
    }

    /**
     * Print of the value of coin.
     *
     * @return word of value of the coin.
     */
    public String toString() {
        return this.value + " " + this.currency;
    }


}
