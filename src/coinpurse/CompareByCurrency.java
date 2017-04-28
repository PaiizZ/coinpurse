package coinpurse;

import java.util.Comparator;

/**
 * Class for comparing two Coins by currency.
 */
public class CompareByCurrency implements Comparator<Valuable> {

    /**
     * Compare two coins by currency.
     *
     * @param c1 is the first Coin.
     * @param c2 is the second Coin.
     * @return positive integer if c1 more than c2, negative integer if less than, else 0.
     */
    @Override
    public int compare(Valuable c1, Valuable c2) {
        return c1.getCurrency().compareTo(c2.getCurrency());
    }
}