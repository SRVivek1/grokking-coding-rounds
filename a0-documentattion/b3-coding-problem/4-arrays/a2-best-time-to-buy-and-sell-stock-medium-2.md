# [Leetcode Q122 (Medium):](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/) Best time to buy and sell stocks

## Problem statements:
- You are given an integer ***array prices*** where $prices[i]$ is the price of a given stock on the $i-th$ day.
  - On each day, you may decide to buy and/or sell the stock. 
  - You can only hold at most one share of the stock at any time. 
  - However, you can buy it then immediately sell it on the same day.
  - Find and return the maximum profit you can achieve.

<br/>

  - **Constraints:** 
    - 1 <= prices.length <= 3 * 104
    - 0 <= prices[i] <= 104

<br/>

- **Examples:**
  - **Example 1:**
    -  ***Input:*** prices = [7,1,5,3,6,4]
    -  ***Output:*** 7
    -  **Explanation:** 
       - Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
       - Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
       - Total profit is 4 + 3 = 7.
  
  <br/>

  -  **Example 2:**
    -  ***Input:*** prices = [1,2,3,4,5]
    -  ***Output:*** 4
    -  **Explanation:** 
       - Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
       - Total profit is 4.

  <br/>

    -  **Example 3:**
       - ***Input:*** prices = [7,6,4,3,1]
       - ***Output:*** 0
       - **Explanation:** 
         - There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

<br/>

## Problem Analysis:
  - The problem asks us to find the maximum profit we can achieve by buying and selling a stock multiple times. 
  - We are given an array of prices, where $prices[i]$ is the price of the stock on the $i-th$ day. 
  - We can complete as many transactions as we like, but we must sell the stock before we can buy again.

### Edge Cases:
  - **Empty or single-element array:** 
    - If the prices array is empty or has only one element, no profit can be made. 
    - Hence, the maximum profit should be 0.
  - **Prices are in decreasing order:** 
    - If the prices are always decreasing, we can never make a profit. 
    - Hence, the maximum profit will be 0.
  - **Prices are in increasing order:** 
    - If the prices are always increasing, we can buy on day 1, sell on day 2, buy on day 2, sell on day 3, and so on. 
    - This is the optimal strategy.
  - **Array with all same values:** 
    - If all prices are the same, no profit can be made. 
    - Hence, the maximum profit will be 0.

<br/>

## Solutions:

### Brute-Force Approach (Recursion with Backtracking):
  - The brute-force approach involves exploring all possible combinations of buying and selling days. We can use a recursive function to simulate the process. 
  - At each day, we have two choices:
    - **Do nothing:** 
      - Move to the next day without performing any transaction.
    - **Perform a transaction:**
      - If we have a stock, we can sell it. If we don't have a stock, we can buy one.

  - We can keep track of our current profit and whether we are holding a stock. The base case for the recursion would be when we reach the end of the prices array.

<br/>

- **Algorithm:**
  - Define a recursive function, say calculate(prices, index, holding_stock).
    - **The base case:** 
      - If index is equal to the length of the prices array, return 0.
  - Inside the function, we'll calculate the maximum profit for two scenarios:
    - **Skipping the current day:** 
      - profit_skip = calculate(prices, index + 1, holding_stock)
  - **Performing a transaction:**
    - **If holding_stock is true**, we can sell: 
      - profit_sell = prices[index] + calculate(prices, index + 1, false)
    - **If holding_stock is false**, we can buy: 
      - profit_buy = -prices[index] + calculate(prices, index + 1, true)
  - **Return** the maximum of the calculated profits.

  - **Time Complexity:**
    - This approach has a time complexity of $O(2n)$, where $n$ is the number of days, due to the branching nature of the recursion. 
    - **Note:** This is highly inefficient for large inputs.

<br/>

### Optimized Approach (Greedy Algorithm)
  - The key insight for the optimized approach is that we want to capture every single profitable transaction. 
  - A profitable transaction occurs whenever the price of the stock increases from one day to the next.

  - We can iterate through the prices array and, whenever the price of the current day is greater than the price of the previous day, we add the difference to our total profit. 
  - This works because we can think of it as buying on the previous day and selling on the current day. 
  - If we have multiple consecutive days of increasing prices, say $p1 < p2 < p3$, we can capture the profit $(p2-p1) + (p3-p2)$ which is equal to $(p3-p1)$. 
  - Our greedy strategy naturally captures this.

  - **Algorithm:**
    - Initialize a variable ***max_profit*** to $0$.
    - Iterate through the ***prices*** array from the second element (index 1) to the end.
    - In each iteration, check if $prices[i] > prices[i-1]$.
      - **If the condition is true**, it means we can make a profit by buying on day i-1 and selling on day i. 
        - Add $prices[i] - prices[i-1]$ to ***max_profit***.
    - After the loop, return the max_profit which holds the total maximum profit.

  - **Time Complexity:**
    - This approach is much more efficient, with a time complexity of $O(n)$ because we only need to iterate through the array once. 
  - **Space Complexity:** 
    - The space complexity is $O(1)$ as we only use a few variables.

#### Implemention - Java:

```java
    /**
     * Calculates the maximum profit by buying and selling a stock multiple times.
     * This method uses a greedy approach to sum all positive price differences.
     * @param prices An array of stock prices.
     * @return The maximum possible profit.
     */
    public int maxProfit(int[] prices) {
        // Handle edge cases where no transaction is possible
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        // Iterate through the prices and add up all increments
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

```

---
<center>
<h3> ------ End ------ </h3>
</center>

<!-- HTML styling -->
<style>
  table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
  }
  heading {
    color: blue;
    font-size: 20px;
  }
</style>
