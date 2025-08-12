# LeetCode: Best time to buy and sell stocks
## Problem statements:
<!-- - [Leetcode-121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/) [*Difficulty: Easy*] -->
  - You are given an array prices where prices[i] is the price of a given stock on the ith day.
  - You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
  - Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 
### Examples:

  - **Example 1:**
    - **Input:** prices = [7,1,5,3,6,4]
    - **Output:** 5
    - **Explanation:** 
      - Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
      - ***Note that*** buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
  
  - ***Example 2:***
    - **Input:** prices = [7,6,4,3,1]
    - **Output:** 0
    - **Explanation:** In this case, no transactions are done and the max profit = 0.

### Constraints:
  - 1 <= prices.length <= 105
  - 0 <= prices[i] <= 104


## Edge cases to consider
  - **Empty prices array:** 
    - If the input array is empty, no transaction can be made, so the profit should be 0.
  - **Array with only one price:** 
    - Similar to the empty array, if there's only one day's price, we can't buy and sell on different days, so the profit is 0.
  - **Prices are in decreasing order:** 
    - If the stock price consistently decreases, no profitable transaction is possible, and the profit should be 0.
  - **Prices are in increasing order:** 
    - In this case, buying on the first day and selling on the last day will yield the maximum profit.
  - **Prices are the same for all days:** 
    - No profit can be made as the buying and selling prices will always be equal, resulting in a profit of 0.
  

## Brute-Force Approach: *[T.C. - $O(n^2)$, S.C. - $O(1)$]*
  - The most straightforward approach is to consider all possible pairs of buying and selling days. 
  - We can iterate through the prices array using nested loops. 
    - The outer loop iterates from the first day to the second-to-last day (potential buy days), and the inner loop iterates from the day after the outer loop's current day to the last day (potential sell days). 
    - For each pair of buy and sell days, we calculate the profit and keep track of the maximum profit found so far.

### Algorithm for Brute-Force Approach:
  - Initialize a variable *max_profit* to 0.
  - Iterate through the prices array with an index `i` from 0 to `n-2` (where `n` is the length of prices). This represents the buy day.
    - For each i, iterate through the prices array with an index `j` from `i+1` to `n-1`. This represents the sell day.
    - Calculate the profit for this pair: $profit = prices[j] - prices[i]$.
    - If profit is greater than max_profit, update max_profit to profit.
  - After iterating through all possible pairs, return max_profit.

#### Complexity Analysis:
  - **Time Complexity:** 
    - The nested loops result in a time complexity of $O(n^2)$, where n is the number of days. 
    - As For each element, we are iterating through the rest of the array.
  - **Space Complexity:** 
    - We are only using a few variables to store the profit, so the space complexity is $O(1)$.


#### Brute-Force: Java implementation
  ```java 
      class SolutionBruteForce {
          public int maxProfit(int[] prices) {
              int n = prices.length;
              int maxProfit = 0;
              for (int i = 0; i < n - 1; i++) {
                  for (int j = i + 1; j < n; j++) {
                      int profit = prices[j] - prices[i];
                      if (profit > maxProfit) {
                          maxProfit = profit;
                      }
                  }
              }
              return maxProfit;
          }
      }
  ```

#### Brute-Force: Python implementation
  ```python 
        def max_profit_brute_force(prices):
          n = len(prices)
          max_profit = 0
          for i in range(n - 1):
              for j in range(i + 1, n):
                  profit = prices[j] - prices[i]
                  if profit > max_profit:
                      max_profit = profit
          return max_profit
  ```

## Optimized Approach: 
### Solution: Two pointer approach
  - We can optimize this by using a single pass through the prices array. The idea is to keep track of the minimum price encountered so far. For each day, we can calculate the potential profit if we were to sell on that day (by subtracting the minimum price seen so far). 
  - We then update the maximum profit if the current potential profit is greater than the current maximum profit.

### Algorithm for Optimized Approach [T.C: $$O(n), S.C: $O(1)$]:
  - Initialize min_price to infinity (or the price on the first day).
  - Initialize max_profit to 0.
  - Iterate through the prices array with an index i from 0 to n-1.
  - In each iteration:
    - Update min_price to be the minimum of the current min_price and prices[i]. 
      - This ensures we always have the lowest buying price encountered up to the current day.
    - Calculate the potential profit if we sell on the current day: 
      - *current_profit = prices[i] - min_price.*
    - Update max_profit to be the maximum of the current max_profit and current_profit.
  - After iterating through all the days, return max_profit.

#### Two poiner: Java implementation
##### Solution 1: 
  ```java
      public int maxProfit(int[] prices) {
          int minPrice = Integer.MAX_VALUE;
          int maxProfit = 0;
          for (int price : prices) {
              minPrice = Math.min(minPrice, price);
              int profit = price - minPrice;
              maxProfit = Math.max(maxProfit, profit);
          }
          return maxProfit;
      }
  ```

<br/>

##### Solution 2: 
   ```java
      public int maxProfit(int[] prices) {
        
        if(prices.length <= 1) return 0;
        
        int profit = 0, l = 0, r = l + 1;
        while(r < prices.length) {
            if(prices[l] < prices[r]) {
                int t = prices[r] - prices[l];
                profit = profit > t ? profit : t;
                r++;
            } else {
                l = r;
                r++;
            }
        }
        return profit;
    }
  ```


#### Two poiner : Python implementation
  ```python 
      def max_profit_optimized(prices):
        min_price = float('inf')
        max_profit = 0
        for price in prices:
            min_price = min(min_price, price)
            profit = price - min_price
            max_profit = max(max_profit, profit)
        return max_profit
  ```

---
<center>
<h1> ------ End ------ </h1>
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
