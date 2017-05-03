package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;

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
public class Purse extends Observable {
	/**
	 * Capacity is maximum number of coins the purse can hold.
	 * Capacity is set when the purse is created and cannot be changed.
	 */
	private final int capacity;
	/**
	 * Collection of objects in the purse.
	 */
	private List<Valuable> money;
	/** 
	 * withdraw with differ strategy.
	 */
	private WithdrawStrategy strategy;

	/**
	 * Create a purse with a specified capacity.
	 *
	 * @param capacity is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		money = new ArrayList<>();
		this.capacity = capacity;
		setWithdrawStrategy(new RecursiveWithdraw());
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
		for (Valuable i : this.money) {
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
	 * @param value is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable value) {
		if (value == null) return false;
		if (isFull() || value.getValue() <= 0) return false;
		money.add(value);
		setChanged();
		notifyObservers();
		return true;
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
	public Valuable[] withdraw(double amount) {
		List<Valuable> list = this.strategy.withdraw(amount, money); // store money to list
		if( list != null){
			for (Valuable x : list) {
				money.remove(x);
			}
			Valuable[] array = new Valuable[list.size()]; // create the array
			list.toArray(array); // copy to array
			setChanged();
			notifyObservers("withdraw");
			return array;
		}
		return null;

	}

	/**
	 * set new strategy type.
	 * @param strategy type that want to set.
	 */
	public void setWithdrawStrategy(WithdrawStrategy strategy){
		this.strategy = strategy ;
	}
	/**
	 * toString returns a string description of the purse contents.
	 * It can return whatever is a useful description.
	 */
	public String toString() {
		return this.count() + " Coins with value " + this.getBalance();
	}

}
