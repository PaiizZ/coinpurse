package coinpurse;

import java.util.Arrays;
import java.util.List;

/**
 * ThaiMoneyFactory is a factory for create an object of Thailand Money.
 *
 * @author Wanchanapon Thanwaranurak
 * @version 2/24/2017 AD.
 */
public class ThaiMoneyFactory extends MoneyFactory {
    /**
     * coinList are contain many kind of small coin in Thailand money.
     */
    List<Double> coinSatangList = Arrays.asList(0.25, 0.50);
    /**
     * coinList are contain many kind of coin in Thailand money.
     */
    List<Double> coinBahtList = Arrays.asList(1.0, 2.0, 5.0, 10.0);
    /**
     * banknoteList are contain many kind of banknote in Thailand money.
     */
    List<Double> banknoteList = Arrays.asList(20.0, 50.0, 100.0, 500.0, 1000.0);
    /**
     * Creating money object of Thailand money.
     * @param value is used to create Thailand money.
     * @return Valuable object is a Thailand money.
     */
    @Override
    public Valuable createMoney(double value) {
        if (coinSatangList.contains(value)) return  new Coin(value*100,"Satang");
        else if (coinBahtList.contains(value)) return new Coin(value, "Baht");
        else if (banknoteList.contains(value)) return new BankNote(value, "Baht");
        throw new IllegalArgumentException();

    }
}
