package coinpurse;

/**
 * A specification needs documentation so that otherrs can use it.
 *
 * @author Wanchanapon Thanwaranurak
 * @version 2/18/2017 AD.
 */
public interface Valuable extends Comparable<Valuable>{
    /**
     * Get the monetary value of this object, in its own currency.
     *
     * @return the value of this object.
     */
    public double getValue();

    /**
     * Get the monetary currency of this object.
     *
     * @return the currency of this object.
     */
    public String getCurrency();

}
