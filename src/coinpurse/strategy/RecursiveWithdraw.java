package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.CompareByCurrency;
import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy{

	@Override
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
