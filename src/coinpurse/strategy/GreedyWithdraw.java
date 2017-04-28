package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import coinpurse.Valuable;
import coinpurse.CompareByCurrency;

public class GreedyWithdraw implements WithdrawStrategy{

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		// TODO Auto-generated method stub
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
//                for (Valuable x : templist) {
//                    money.remove(x);
//                }
//                Valuable[] array = new Valuable[templist.size()]; // create the array
//                templist.toArray(array); // copy to array
//                setChanged();
//                notifyObservers("withdraw" + total);
                System.out.println("in GreedyWithdraw");
                return templist;
            }
            else {
                return null;
            }
        }
        return null;
	}

}
