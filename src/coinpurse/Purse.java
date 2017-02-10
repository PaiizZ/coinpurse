package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A coin purse contains coins.
 * You can insert coins, withdraw money, check the balance,
 * and check if the purse is full.
 * When you withdraw money, the coin purse decides which
 * coins to remove.
 *
 * @author Wanchanapon Thanwaranurak
 * @version 10/2/2017.
 */
public class Purse {
    /**
     * Capacity is maximum number of coins the purse can hold.
     * Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    /**
     * Collection of objects in the purse.
     */
    List<Coin> money;

    /**
     * Create a purse with a specified capacity.
     *
     * @param capacity is maximum number of coins you can put in purse.
     */
    public Purse(int capacity) {
        money = new ArrayList<>();
        this.capacity = capacity;
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     *
     * @return the number of coins in the purse
     */
    public int count() {
        return money.size();
    }

    /**
     * Get the total value of all items in the purse.
     *
     * @return the total value of items in the purse.
     */
    public double getBalance() {
        double balance = 0;
        for (Coin i : this.money) {
            balance += i.getValue();
        }
        return balance;
    }

    /**
     * Return the capacity of the coin purse.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Test whether the purse is full.
     * The purse is full if number of items in purse equals
     * or greater than the purse capacity.
     *
     * @return true if purse is full.
     */
    public boolean isFull() {
        if (this.money.size() == this.capacity) return true;
        return false;
    }

    /**
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     *
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert(Coin coin) {
        if (!isFull() && coin.getValue() > 0) {
            this.money.add(coin);
            return true;
        }
        return false;
    }

    /**
     * Withdraw the requested amount of money.
     * Return an array of Coins withdrawn from purse,
     * or return null if cannot withdraw the amount requested.
     *
     * @param amount is the amount to withdraw
     * @return array of Coin objects for money withdrawn,
     * or null if cannot withdraw requested amount.
     */
    public Coin[] withdraw(double amount) {
        Collections.sort(money);
        Collections.reverse(money);

        List<Coin> templist = new ArrayList<>(this.capacity);
        double num = 0, total = amount;
        if (this.getBalance() >= total) {
            for (int i = 0; num < total && i < money.size(); i++) {
                if (money.get(i).getValue() <= amount) {
                    templist.add(money.get(i));
                    num += money.get(i).getValue();
                    amount -= money.get(i).getValue();
                }

            }
            if (num == total) {
                for (int i = 0; i < templist.size(); i++) {
                    money.remove(templist.get(i));
                }
                Coin[] array = new Coin[templist.size()]; // create the array
                templist.toArray(array); // copy to array
                return array;
            } else {
                return null;
            }
        }
        return null;

    }

    /**
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
        return this.count() + " Coins with value " + this.getBalance();
    }

}
