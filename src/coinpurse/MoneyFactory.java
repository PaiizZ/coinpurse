package coinpurse;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by PaiizZ on 2/24/2017 AD.
 */
public abstract class MoneyFactory {
    private static MoneyFactory moneyFactory = null;

    public static MoneyFactory getInstance() {
        if (moneyFactory == null)
            try {
                setMoneyFactory();
            } catch (IOException io) {
                System.out.println(io.getMessage());
            }

        return moneyFactory;
    }

    public static void setMoneyFactory() throws IOException {
        FileInputStream file = new FileInputStream("/Users/PaiizZ/Documents/workspace/OOP2/CoinPurse/src/coinpurse/purse.properties");
        ResourceBundle bundle = new PropertyResourceBundle(file);
        String classfactory = bundle.getString("moneyfactory");
        try {
            Object o = Class.forName(classfactory).newInstance();
            moneyFactory = (MoneyFactory) Class.forName(classfactory).newInstance();
        } catch (ClassNotFoundException cce) {
            // the object could not be cast to type MoneyFactory
            System.out.println(cce.getMessage() + " in not type MoneyFactory");
        } catch (Exception ex) {
            // any other exception means we could not create an object
            moneyFactory = new MalayMoneyFactory();
            System.out.println("Error creating MoneyFactory " + ex.getMessage());
        }
        // if no factory then quit
        if (moneyFactory == null) System.exit(1);
    }

    abstract public Valuable createMoney(double value);

    public Valuable createMoney(String value) {
        return createMoney(Double.parseDouble(value));
    }
}
