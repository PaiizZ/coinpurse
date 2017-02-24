package coinpurse;

import java.util.Arrays;
import java.util.List;

/**
 * Created by PaiizZ on 2/24/2017 AD.
 */
public class ThaiMoneyFactory extends MoneyFactory {
    @Override
    public Valuable createMoney(double value) {
        List<Double> coinList = Arrays.asList(1.0, 2.0, 5.0, 10.0);
        List<Double> banknoteList = Arrays.asList(20.0, 50.0, 100.0, 500.0, 1000.0);
        if (coinList.contains(value)) return new Coin(value, "Baht");
        else if (banknoteList.contains(value)) return new BankNote(value, "Baht");
        throw new IllegalArgumentException();

    }
}
