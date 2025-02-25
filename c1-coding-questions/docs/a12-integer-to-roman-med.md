# LeetCode: Convert integer to Roman
## Problem statements:

- [Leetcode-12](https://leetcode.com/problems/integer-to-roman/ ) [*Difficulty: Medium*]
  - Implement the function that converts an integer to its Roman numeral representation.

  - Seven different symbols represent Roman numerals with the following values:
    - *I (1), V (5), X (10), L (50), C (100), D (500), M (1000).*

## Roman numerals formation:
  - Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:
    - If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
    - If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
    - Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.

## Given an integer, convert it to a Roman numeral.
  - **Example-1:**
    - **Input:** num = 3749
    - **Output:** "MMMDCCXLIX"

    - **Explanation:**
      - 3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
      - 700 = DCC as 500 (D) + 100 (C) + 100 (C)
      - 40 = XL as 10 (X) less of 50 (L)
      - 9 = IX as 1 (I) less of 10 (X)
    > **Note:** 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places.

  - **Example-2:**
    - **Input:** num = 58
    - **Output:** "LVIII"

    - **Explanation:**
      - 50 = L as 50 (L)
      - 8 = VIII as 5 (V) + 1 (I) + 1 (I) + 1 (I)
  - **Example-3:**
    - **Input:** num = 1994
    - **Output:** "MCMXCIV"

    - **Explanation:**
      - 1000 = M as 1000 (M)
      - 900 = CM as 1000 (M) less of 100 (C)
      - 90 = XC as 100 (C) less of 10 (X)
      - 4 = IV as 5 (V) less of 1 (I)


## Constraints:
  - *1 <= num <= 3999*

## Solution:
  - **Problem Statement:**
    - The input integer is within the range 1 to 3999.
    - Roman numerals are based on the following symbols:
      - I = 1
      - V = 5
      - X = 10
      - L = 50
      - C = 100
      - D = 500
      - M = 1000
    - Numbers are formed using subtractive notation, meaning:
      - IV (4) instead of IIII
      - IX (9) instead of VIIII
      - XL (40) instead of XXXX
      - XC (90) instead of LXXXX
      - CD (400) instead of CCCC
      - CM (900) instead of DCCCC


  - **Approach:**
    - Create Mappings: Use an array of values and their corresponding Roman numeral symbols.
    - Iterate from Largest to Smallest: Start from the largest value and subtract from num while appending the corresponding Roman numeral.
    - Use Subtractive Notation: Since we prioritize the largest values first, we automatically handle cases like IV, IX, etc.
    - Iterate through the mappings, using a while loop to continue subtracting the Roman numeral values from the input integer until it reaches zero.
    - Construct the final result string using the collected Roman numerals.
  

  - **Time & Space Complexity Analysis:**
    - **Time Complexity:** 
      - $O(1)$ (Since the maximum number is 3999, the loop runs at most 13 times)
    - **Space Complexity:** 
      - $O(1)$ (Only a fixed-size StringBuilder is used).

  - **Java Implementation:**
    ```java
        public String intToRoman(int num) {
          StringBuilder res = new StringBuilder();
          int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
          String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

          for(int i = 0; i < values.length; i++) {
                while (num >= values[i]) {
                    res.append(symbols[i]);
                    num = num - values[i];
                }
          }
          return res.toString();
        }
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