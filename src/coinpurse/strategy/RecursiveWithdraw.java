package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.CompareByCurrency;
import coinpurse.Valuable;

/**
 * A RecursiveWithdraw is withdraw the valuable with greedy algorithm.
 * @author Wanchanapon Thanwaranurak
 * @version 29/4/2017
 */
public class RecursiveWithdraw implements WithdrawStrategy{

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
		List<Valuable> result = new ArrayList<>();
		if ( amount == 0 ) return result;
		if( money.size() <= 0 ) return null;
		Valuable first = money.get(0);
		result = withdraw( amount - first.getValue(), money.subList(1,money.size())) ; 
		if( result != null){
			result.add(first);
			return result;
		}
		return withdraw( amount , money.subList(1,money.size()));
	}
}
