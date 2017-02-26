package coinpurse;

import java.util.ResourceBundle;

/**
 * Main factory for choose which country factory to create money.
 *
 * @author Wanchanapon Thanwaranurak
 * @version 2/24/2017 AD.
 */
public abstract class MoneyFactory {
    /**
     * moneyFactory use to keep object of MoneyFactory class.
     */
    private static MoneyFactory moneyFactory = null;

    /**
     * Getting an instance of MoneyFactory.
     *
     * @return an object of subclass (Thai or Malay)
     */

    public static MoneyFactory getInstance() {
        if (moneyFactory == null)
            setMoneyFactory();
        return moneyFactory;
    }

    /**
     * Selecting country factory to create an object of Valuable by reading in purse.properties.
     */
    public static void setMoneyFactory() {
        ResourceBundle bundle = ResourceBundle.getBundle("purse");
        String classfactory = bundle.getString("moneyfactory");
        try {
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

    /**
     * Creating money object type valuable ,input value(double type)
     *
     * @param value of create an object money
     * @return valuable object is created
     * @throws IllegalAccessException if value is invalid of selected country factory.
     */
    abstract public Valuable createMoney(double value) throws IllegalAccessException;

    /**
     * Creating money object type valuable ,input value(String type)
     * if input value is String, so call this method.
     *
     * @param value for create an object money
     * @return valuable object is created
     * @throws IllegalAccessException if value is invalid of selected country factory.
     */
    public Valuable createMoney(String value) throws IllegalAccessException {
        return createMoney(Double.parseDouble(value));
    }
}
