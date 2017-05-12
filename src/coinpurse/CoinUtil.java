package coinpurse;

import java.util.*;


/**
 * Some Coin utility methods for practice using Lists and Comparator.
 *
 * @author Wanchanapon Thanwaranurak
 * @version 11/2/2017.
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns
	 * only the coins that have a currency that matches the parameter value.
	 *
	 * @param coinList is a List of Coin objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist
	 * that have the requested currency.
	 */
	public static <E extends Valuable> List<E> filterByCurrency(final List<E> coinList, String currency) {
//		if (currency == null) {
//			throw new IllegalArgumentException();
//		}
		List<E> templist = new ArrayList<>();
//		for (E c : coinlist) {
//			if (c.getCurrency().equals(currency)) {
//				templist.add(c);
//			}
//		}
//		return templist; // return a list of coin references copied from coinlist
		if (coinList == null || currency == null) {
			throw new IllegalArgumentException();
		}
		coinList.stream().filter((c) -> c.getCurrency().equals(currency)).forEach(templist::add);
		return templist;
		
		
	}


	/**
	 * Method to sort a list of coins by currency.
	 * On return, the list (coins) will be ordered by currency.
	 *
	 * @param values is a List of Coin objects we want to sort.
	 */
	public static void sortByCurrency(List<? extends Valuable> values) {
		Collections.sort(values, new CompareByCurrency());
	}

	/**
	 * Sum coins by currency and print the sum for each currency.
	 * Print one line for the sum of each currency.
	 * For example:
	 * coins = { Coin(1,"Baht"), Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") }
	 * then sumByCurrency(coins) would print:
	 * <p>
	 * 11.00 Baht
	 * 20.50 Ringgit
	 * <p>
	 * Hint: this is easy if you sort the coins by currency first. :-)
	 */
	public static void sumByCurrency(List<Valuable> values) {
		Map<String, Double> map = new HashMap<>();
		for (Valuable v : values){
			map.put( v.getCurrency() , map.getOrDefault(v.getCurrency(), 0.0) + v.getValue());
		}
		for (String s : map.keySet()){
			System.out.println( map.get(s) + " " + s);
		}
	}

	/**
	 * Make a list of coins containing different currencies.
	 */
	public static List<Valuable> makeInternationalCoins() {
		List<Valuable> money = new ArrayList<>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/**
	 * Make a list of coins using given values.
	 */
	public static List<Valuable> makeCoins(String currency, double... values) {
		List<Valuable> list = new ArrayList<>();
		for (double value : values) list.add(new Coin(value, currency));
		return list;
	}

	/**
	 * Print the list on the console, on one line.
	 */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext()) System.out.print(separator);
		}
		System.out.println(); // end the line
	}

	/**
	 * Return the larger of a and b, according to the natural
	 * @param a
	 * @param b
	 * @return
	 */
	@SafeVarargs
	public static <E extends Comparable<? super E>> E max (E... items) {
		if (items.length <= 0) {
			return null;
		}
		
		E max = items[0]; 
		for (E item : items) {
			if (item.compareTo(max) > 0) {
				max = item;
			}
		}
		return max;
	}
	
	/**
	 * This method contains some code to test the above methods.
	 *
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of " + currency);
		List<Valuable> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		List<Valuable> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (coins.size() != size) System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		sortByCurrency(coins);
		System.out.print("RESULT: ");
		printList(coins, " ");

		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= ");
		printList(coins, " ");
		sumByCurrency(coins);
		Coin coin1 = new Coin(5);
		Coin coin2 = new Coin(5);
		BankNote note = new BankNote(20);
		Valuable max = CoinUtil.max(coin1,coin2,note);
		System.out.println(max + "eiei");
		List<Coin> coinss = Arrays.asList(new Coin(10,"Baht"),new Coin(5,"Baht"),new Coin(100,"Kip"));
		List<?> liste = filterByCurrency(coinss,"Kip");
		System.out.println(liste.toString());
	}

}