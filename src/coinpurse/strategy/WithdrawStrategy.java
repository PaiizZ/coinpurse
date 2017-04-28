package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;

/**
 * A WithdrawStrategy is interface which contain withdraw method.
 * @author Wanchanapon Thanwaranurak
 * @version 28/4/2017
 */
public interface WithdrawStrategy {
	/** 
	 * Find and return a collection of money that will enable the purse to withdraw the requested amount.
	 * @param amount is the amount of money to withdraw.
	 * @param money the contents that are available for possible withdraw.
	 * 		  must not be null, but mat be an empty list.
	 * 		  This list is not modified.
	 * @return if a solution is found, return a List containing referenced
	 * 		   from the money parameter (List) whose sum equals the amount.
	 * 		   If a solution is not found, return null.
	 */
	public List<Valuable> withdraw (double amount , List<Valuable> money);
}

