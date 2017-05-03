package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import coinpurse.Valuable;
import coinpurse.CompareByCurrency;

/**
 *  A GreedyWithdraw is withdraw the valuable with greedy algorithm.
 *  
 *  @author Wanchanapon Thanwaranurak
 */
public class GreedyWithdraw implements WithdrawStrategy{

	/**  
	 *  Withdraw the requested amount of money.
	 *  Return an List of Valuable withdrawn from purse,
	 *  or return null if cannot withdraw the amount requested.
	 *  @param amount is the amount to withdraw
	 *  @param list of available valuable.
	 *  @return List of Valuable objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
	 */
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		Collections.sort(money, new CompareByCurrency());
		Collections.reverse(money);

		List<Valuable> templist = new ArrayList<>();
		double num = 0, total = amount;
		double balance = 0;
		for (Valuable i : money) {
			balance += i.getValue();
		}
		if ( balance >= total) {
			for (int i = 0; num < total && i < money.size(); i++) {
				if (money.get(i).getValue() <= amount) {
					templist.add(money.get(i));
					num += money.get(i).getValue();
					amount -= money.get(i).getValue();
				}
			}
			if (num == total) {
				return templist;
			}
			else {
				return null;
			}
		}
		return null;
	}
}
