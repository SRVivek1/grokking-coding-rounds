# LeetCode: Factorail Trailling zeros
## Problem statements:

- [Leetcode-7](https://leetcode.com/problems/reverse-integer/description/) [*Difficulty: Medium*]
  - Given a signed 32-bit integer $x$, return $x$ with its digits reversed. If reversing $x$ causes the value to go outside the signed ***32-bit integer range [-231, 231 - 1]***, then ***return 0***.

  - Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

  - **Example 1:**
    - **Input:** x = 123
    - **Output:** 321
  
  - **Example 2:**
    - **Input:** x = -123
    - **Output:** -321

  - **Example 3:**
    - **Input:** x = 120
    - **Output:** 21
  

  - **Constraints:**
    - *-231 <= x <= 231 - 1*

## Solution:
  - **Critical Problem Areas:**
    - ***Handling Negative Numbers:***
      - The negative sign should be preserved in the reversed number.

    - ***Handling Trailing Zeros:***
      - Trailing zeros in the original number should not appear at the beginning of the reversed number (e.g., 120 → 21).

    - ***32-bit Integer Overflow:***
      - The reversed number must fit within the 32-bit signed integer range (-2^31 to 2^31 - 1). If the reversed number overflows, the program should return 0.

  - **Solution Approach:**
    - ***Extract the Sign:***
      - Determine if the number is negative and store the sign separately.

    - ***Reverse the Digits:***
      - Use modulo and division operations to reverse the digits of the absolute value of the number.

    - ***Check for Overflow:***
      - Before returning the result, ensure that the reversed number is within the 32-bit signed integer range.

    - **Return the Result:**
      - Apply the sign to the reversed number and return it.

  - **Time Complexity:**
    - The time complexity is $O(log₁₀n)$, where n is the input number, because we process each digit of the number once.

  - **Space Complexity:**
    - The space complexity is $O(1)$, as we are using a constant amount of extra space.

  - **Implementation:**
    ```java
          public int reverse(int x) {
              if(x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) return 0;

              int rev = 0;
              while(x != 0) {
                  int ld = x % 10;

                  // Reduces runtime score in leetcode
                  //if(isIntOutOfRange(rev, ld)) return 0;
                  
                  //leet code - beats 100%
                  if((rev > Integer.MAX_VALUE / 10) || (rev < Integer.MIN_VALUE / 10)) return 0;

                  rev = (rev * 10) + ld;
                  x = x / 10;
              }

              return rev;
          }

          /**
           * Verifies if the reverse integer will overflow if last digit is added
           */
          public boolean isIntOutOfRange(int rev, int ld) {
              if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && ld > 7)) {
                  return true;
              }

              if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && ld < -8)) {
                  return true;
              }

              return false;
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