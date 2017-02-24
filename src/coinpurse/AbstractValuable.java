package coinpurse;

/**
 * Created by PaiizZ on 2/24/2017 AD.
 */
public abstract class AbstractValuable implements Valuable {
    private double value;
    private String currency;

    public AbstractValuable(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public int compareTo(Valuable valuable) {
        if (this.value < valuable.getValue()) {
            return -1;
        } else if (this.value > valuable.getValue()) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        if (this.value == ((AbstractValuable) obj).getValue() && this.currency.equals(((AbstractValuable) obj).getCurrency()))
            return true;
        return false;
    }

    public String getCurrency() {
        return this.currency;
    }

    public double getValue() {
        return this.value;
    }
}
