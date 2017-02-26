package coinpurse;

/**
 * An AbstractValuable class is the parent of Coin and BankNote Class.
 * Can use by other kinds of money.
 *
 * @author Wanchanapon Thanwaranurak
 * @version 2/24/2017 AD.
 */
public abstract class AbstractValuable implements Valuable {
    /**
     * value is a value of Valuable.
     */
    private double value;
    /**
     * currency is a currency of Valuable
     */
    private String currency;

    /**
     * A valuable object with given value and currency.
     *
     * @param value is a value of valuable.
     * @param currency is a currency of valuable.
     */
    public AbstractValuable(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    /**
     * Compare 2 valuable objects that who more than one.
     *
     * @param valuable is a another valuable object.
     * @return 1 if object more than another one.
     *        -1 if object less than another one.
     *         0 if 2 objects are equals.
     */
    public int compareTo(Valuable valuable) {
        if (this.currency.equals(valuable.getCurrency()))
            return (this.value + "").compareTo(valuable.getValue() + "");
        else
            return this.currency.compareTo(valuable.getCurrency());
    }

    /**
     * Two valuable are equal if they have the same value and currency.
     *
     * @param obj is another valuable object to compare to this one.
     * @return true if value and currency is same, false otherwise.
     */
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        if (this.value == ((AbstractValuable) obj).getValue() && this.currency.equals(((AbstractValuable) obj).getCurrency()))
            return true;
        return false;
    }

    /**
     * Get currency of valuable object.
     *
     * @return currency is a currency of valuable object.
     */
    public String getCurrency() {
        return this.currency;
    }

    /**
     * Get value of valuable object.
     *
     * @return value is a value of valuable object.
     */
    public double getValue() {
        return this.value;
    }
}
