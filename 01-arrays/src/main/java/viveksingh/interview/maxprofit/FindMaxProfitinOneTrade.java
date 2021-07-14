/**
 * Find maximum profit in give price array in a single trade.
 * 
 */
package viveksingh.interview.maxprofit;

/**
 * @author vivek
 *
 */
public class FindMaxProfitinOneTrade {


	public static void main(String[] args) {

		final int[] prices_input_1 = { 7, 1, 5, 3, 6, 4 };

		final int[] prices_input_4 = { 7, 1, 5, 7, 6, 4 };

		final int[] prices_input_5 = { 7, 1, 5, 7, 3, 6, 4 };

		final int[] prices_input_2 = { 1, 2, 3, 4, 5 };

		final int[] prices_input_3 = { 7, 6, 4, 3, 1 };

		int maxProfit = maxProfitInOneTrade(prices_input_1);
		printArray(prices_input_1);
		System.out.println("Max profit : " + maxProfit + "\n");

		maxProfit = maxProfitInOneTrade(prices_input_4);
		printArray(prices_input_4);
		System.out.println("Max profit : " + maxProfit + "\n");

		maxProfit = maxProfitInOneTrade(prices_input_5);
		printArray(prices_input_5);
		System.out.println("Max profit : " + maxProfit + "\n");

		maxProfit = maxProfitInOneTrade(prices_input_2);
		printArray(prices_input_2);
		System.out.println("Max profit : " + maxProfit + "\n");

		maxProfit = maxProfitInOneTrade(prices_input_3);
		printArray(prices_input_3);
		System.out.println("Max profit : " + maxProfit + "\n");

	}

	/**
	 * Find max profit in a single trade.
	 * 
	 * @param prices
	 * @return
	 */
	private static int maxProfitInOneTrade(int[] prices) {
		int maxProfit = 0;
		int minTradeValue = prices[0];

		for (int i = 1; i < prices.length; i++) {
			// Find minimum stock prices in array so far
			minTradeValue = Math.min(minTradeValue, prices[i]);

			// decide max profit with current day
			maxProfit = Math.max(maxProfit, (prices[i] - minTradeValue));
		}
		
		System.out.println("Buy price : " + minTradeValue);
		System.out.println("Sell price : " + (maxProfit + minTradeValue));
		
		return maxProfit;
	}

	/**
	 * Print input array data.
	 * 
	 * @param prices_input_1
	 */
	private static void printArray(int[] arr) {

		System.out.print("[");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		System.out.println("]");
	}
}
