package coinpurse;

/**
 * Created by PaiizZ on 2/18/2017 AD.
 */
public class BankNote implements Valuable {
    /**
     * Next IdBankNote of the nextSerialNumber
     */
    private static long nextSerialNumber = 1000000;
    /**
     * IdBankNote of the serialNumber
     */
    private long serialNumber;
    private double value;
    private String currency;

    public BankNote(double value) {
        this.value = value;
        this.currency = Coin.DEFAULT_CURRENCY;
        this.serialNumber = BankNote.nextSerialNumber;
        BankNote.nextSerialNumber++;
    }

    public BankNote(double value, String currency) {
        this.value = value;
        this.currency = currency;
        this.serialNumber = BankNote.nextSerialNumber;
        BankNote.nextSerialNumber++;
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public String getCurrency() {
        return this.currency;
    }

    public long getSerial() {
        return this.serialNumber;
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (this.getClass() == obj.getClass()) {
                if (this.value == ((BankNote) obj).getValue() && this.currency.equals(((BankNote) obj).getCurrency())) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return String.format("%.2f-%s note [%d]", this.value, this.currency, this.serialNumber);
    }


}
