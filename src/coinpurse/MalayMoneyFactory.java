package coinpurse;

import java.util.Arrays;
import java.util.List;

/**
 * MalayMoneyFactory is a factory for create an object of Malaysia money.
 *
 * @author Wanchanapon Thanwaranurak
 * @version  2/24/2017 AD.
 */
public class MalayMoneyFactory extends MoneyFactory {
    /**
     * coinList are contain many kind of coin in Malaysia money.
     */
    List<Double> coinList = Arrays.asList(0.05, 0.10, 0.20, 0.50);
    /**
     * banknoteList are contain many kind of banknote in Malaysia money.
     */
    List<Double> banknoteList = Arrays.asList(1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0);
    /**
     * Creating money object of Malaysia money.
     * @param value is used to create Malaysian money.
     * @return Valuable object is a Malaysia money.
     */
    @Override
    public Valuable createMoney(double value) {
        if (coinList.contains(value)) return new Coin(value*100,"Sen");
        else if (banknoteList.contains(value)) return new BankNote(value,"Ringgit");
        throw new IllegalArgumentException();
    }

}
