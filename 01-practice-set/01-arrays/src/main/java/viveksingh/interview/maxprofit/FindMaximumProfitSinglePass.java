/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

	Find the maximum profit you can achieve. You may complete as many transactions as you like 
	(i.e., buy one and sell one share of the stock multiple times).
	
	Note: 
		You may not engage in multiple transactions simultaneously (i.e., you must sell the 
		stock before you buy again).
		
	Example 1:
	
	Input: prices = [7,1,5,3,6,4]
	Output: 7
	Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
	Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
	Example 2:
	
	Input: prices = [1,2,3,4,5]
	Output: 4
	Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
	Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
	Example 3:
	
	Input: prices = [7,6,4,3,1]
	Output: 0
	Explanation: In this case, no transaction is done, i.e., max profit = 0.
 *
 *
 */
package viveksingh.interview.maxprofit;

import viveksingh.interview.utils.ArrayUtils;

/**
 * @author vivek
 *
 */
public class FindMaximumProfitSinglePass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final int[] prices_input_1 = { 7, 1, 5, 3, 6, 4 };

		final int[] prices_input_4 = { 7, 1, 5, 7, 6, 4 };

		final int[] prices_input_5 = { 7, 1, 5, 7, 3, 6, 4 };

		final int[] prices_input_2 = { 1, 2, 3, 4, 5 };

		final int[] prices_input_3 = { 7, 6, 4, 3, 1 };

		int maxProfit = maxProfit(prices_input_1);
		ArrayUtils.printArray(prices_input_1);
		System.out.println("Max profit : " + maxProfit + "\n");

		maxProfit = maxProfit(prices_input_4);
		ArrayUtils.printArray(prices_input_4);
		System.out.println("Max profit : " + maxProfit + "\n");

		maxProfit = maxProfit(prices_input_5);
		ArrayUtils.printArray(prices_input_5);
		System.out.println("Max profit : " + maxProfit + "\n");

		maxProfit = maxProfit(prices_input_2);
		ArrayUtils.printArray(prices_input_2);
		System.out.println("Max profit : " + maxProfit + "\n");

		maxProfit = maxProfit(prices_input_3);
		ArrayUtils.printArray(prices_input_3);
		System.out.println("Max profit : " + maxProfit + "\n");

	}

	/**
	 * Find max profit that can be made on provided day wise trade price.
	 * 
	 * Algorithm : Peak valley approach.
	 * 
	 * Complexity Analysis :
	 * 
	 * Time complexity : O(n). Single pass.
	 * 
	 * Space complexity : O(1). Constant space required.
	 * 
	 * 
	 * @param prices
	 * @return
	 */
	private static int maxProfit(int[] prices) {
		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] >= prices[i - 1]) {
				System.out.println("Buy : day - " + (i - 1) + ", price - " + prices[i - 1]);
				System.out.println("Sell : day - " + i + ", price - " + prices[i]);

				maxProfit += prices[i] - prices[i - 1];
			}
		}
		return maxProfit;
	}
}
