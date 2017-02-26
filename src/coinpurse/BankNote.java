package coinpurse;

/**
 * BankNote is a banknote with a monetary value and currency.
 *
 * @author Wanchanapon Thanwaranurak.
 * @version 18/2/2017 AD.
 */
public class BankNote extends AbstractValuable {

    /**
     * Unique serial number starting from 1,000,000
     */
    private static long nextSerialNumber = 1000000;

    /**
     * The unique serial number
     */
    private long serialNumber;

    /**
     * Initialize a BankNote with given value.
     *
     * @param value is a value of the banknote.
     */
    public BankNote(double value) {
        super(value, Coin.DEFAULT_CURRENCY);
        BankNote.nextSerialNumber++;
        this.serialNumber = BankNote.nextSerialNumber;
    }

    /**
     * Initialize a BankNote with given value and currency.
     *
     * @param value    is a value of the banknote.
     * @param currency is a currency of the banknote.
     */
    public BankNote(double value, String currency) {
        super(value, currency);
        BankNote.nextSerialNumber++;
        this.serialNumber = BankNote.nextSerialNumber;
    }

    /**
     * Get serial number from a banknote.
     *
     * @return the serial number of the banknote.
     */
    public long getSerial() {
        return this.serialNumber;
    }


    /**
     * Get a string representation of this Banknote.
     *
     * @return a string representation of the value, currency and serial number of the banknote.
     */
    public String toString() {
        return String.format("%.0f-%s note [%d]", super.getValue(), super.getCurrency(), this.getSerial());
    }


}
