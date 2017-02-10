package coinpurse;

/**
 * a coin with a monetary value and currency
 *
 * @author Wanchanapon Thanwaranurak
 */
//TODO declare that Coin implements Comparable<Coin>
public class Coin implements Comparable<Coin> {
    public static final String DEFAULT_CURRENCY = "Baht";
    /**
     * Value of the coin.
     */
    private final double value;
    /**
     * The currency, of course.
     */
    private final String currency;

    /**
     * A coin with given value using the default currency.
     *
     * @param value
     */
    public Coin(double value) {
        this.value = value;
        this.currency = DEFAULT_CURRENCY;
    }

    /**
     * A coin with given value and currency.
     *
     * @param value
     * @param currency
     */
    public Coin(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    //TODO Write a getValue() method and javadoc.
    public double getValue() {
        return this.value;
    }

    //TODO Write a getCurrency() method and javadoc.
    public String getCurrency() {
        return this.currency;
    }

    //TODO Write an equals(Object) method.
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

//TODO Write a compareTo method and implement Comparable.

    //TODO write a toString() method. See labsheet for what to return.
    public String toString() {
        return this.value + " " + this.currency;
    }

    @Override
    public int compareTo(Coin o) {
        if (this.value < o.getValue()) {
            return -1;
        } else if (this.value > o.getValue()) {
            return 1;
        }
        return 0;
    }

}
