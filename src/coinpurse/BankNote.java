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
//    /**
//     * Value of the bank note.
//     */
//    private double value;
    /**
     * The unique serial number
     */
    private long serialNumber;
//    /**
//     * The currency, of bank note.
//     */
//    private String currency;

    /**
     * Initialize a BankNote with given value.
     *
     * @param value is a value of the banknote.
     */
    public BankNote(double value) {
        super(value, Coin.DEFAULT_CURRENCY);
        this.serialNumber = BankNote.nextSerialNumber;
        BankNote.nextSerialNumber++;
    }

    /**
     * Initialize a BankNote with given value and currency.
     *
     * @param value    is a value of the banknote.
     * @param currency is a currency of the banknote.
     */
    public BankNote(double value, String currency) {
        super(value, currency);
        this.serialNumber = BankNote.nextSerialNumber;
        BankNote.nextSerialNumber++;
    }

//    /**
//     * Get a value from banknote.
//     *
//     * @return the vale of the banknote.
//     */
//    public double getValue() {
//        return this.value;
//    }
//
//    /**
//     * Get a currency from banknote.
//     *
//     * @return the currency of the banknote.
//     */
//    public String getCurrency() {
//        return this.currency;
//    }

    /**
     * Get serial number from a banknote.
     *
     * @return the serial number of the banknote.
     */
    public long getSerial() {
        return this.serialNumber;
    }

//    /**
//     * Two banknote are equal if they have the same value and currency.
//     *
//     * @param obj is another Object to compare to this one.
//     * @return true if value and currency is same, false otherwise.
//     */
//    public boolean equals(Object obj) {
//        if (obj != null) {
//            if (this.getClass() == obj.getClass()) {
//                if (this.value == ((BankNote) obj).getValue() && this.currency.equals(((BankNote) obj).getCurrency())) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    /**
     * Get a string representation of this Banknote.
     *
     * @return a string representation of the value, currency and serial number of the banknote.
     */
    public String toString() {
        return String.format("%.0f-%s note [%d]", super.getValue(), super.getCurrency(), this.serialNumber);
    }


}
