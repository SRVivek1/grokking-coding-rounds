# Integers: Leetcode - Check palindrome number
## Problem statements:
- Given an integer x, return true if x is a palindrome, and false otherwise.

  - **Example 1:**
    - **Input:** x = 121
    - **Output:** true
    - **Explanation:** 121 reads as 121 from left to right and from right to left.

  - **Example 2:**
    - **Input:** x = -121
    - **Output:** false
    - **Explanation:** From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

- **Example 3:**
  - **Input:** x = 10
  - **Output:** false
  - **Explanation:** Reads 01 from right to left. Therefore it is not a palindrome.
 
- **Constraints:**
  - *-231 <= x <= 231 - 1*
 
- **Follow up:** 
  - Could you solve it without converting the integer to a string?


## Edge Cases / Constraints
### Let's discuss some important edge cases.
  - **Negative Numbers:** 
    - As per the definition, negative numbers cannot be palindromes.
    - For example, *-121* read backward is *121-*, which is not the same as *-121*. 
    - So, if ***x < 0***, return **false**.

  - **Single-Digit Numbers:** 
    - Numbers from 0 to 9 are all palindromes. 0 is a special case. 
    - So return **true**.

  - **Numbers ending in 0 (and not just 0 itself):** 
    - If a number x ends in 0 (e.g., 10, 120), for it to be a palindrome, its first digit must also be 0. The only integer with a leading 0 is 0 itself. Any other number ending in 0 (e.g., 10, 200) cannot be a palindrome because its reversed version would lose the trailing 0 (e.g., 01, 002), which is not the same as the original number.
    - So, if x % 10 == 0 and x != 0, return **false**.

  - **Large Integers:** 
    - The problem doesn't explicitly state the range of x, but typically LeetCode problems deal with integers that fit within a 32-bit signed integer range (approx. −2 times $10^9$ to 2 times $10^9$). 
    - Hence, we need to ***be careful about potential integer overflow*** if we try to reverse the entire number.


## Soltuions:

### 1. Brute-Force Approach: Convert to String
- **Idea:** The simplest way to check for a palindrome is to convert the integer to a string, then check if the string is a palindrome.

- **Algorithm:**
  - **Handle edge cases:**
    - If x < 0, ***return false***.
    - If x % 10 == 0 and x != 0, ***return false***. 
      - (Though for string conversion, this isn't strictly necessary, it's good practice for an interview to mention it as an optimization if the interviewer asks for it later).

  - Convert the integer `x` to a string `s`.
  - **Initialize two pointers**, left at the beginning of the string (index 0) and right at the end of the string (index s.length() - 1).
    - While `left < right`:
      - **Step-1:** If `s[left]` is not equal to `s[right]`, ***return false***.
      - **Step-2:** Increment left and decrement right.
    - If the loop completes, it means all characters matched, so ***return true***.

- **Time Complexity:**
  - **Converting integer to string:** 
    - $O(log10(x))$ because the number of digits is $log10(x)$.
  - **Comparing string characters:** 
    - $O(log10(x))$ as we iterate through half the digits.
  - **Overall:** 
    - $O(log10(x))$

- **Space Complexity:**
  - $O(log10(x))$ to store the string representation of the integer.

- **Java Implementaion:**
  ```java 
  class Solution {
    public boolean isPalindrome(int x) {
        // Edge cases
        if (x < 0) {
            return false;
        }
        // Numbers ending in 0 (except 0 itself) cannot be palindromes
        if (x % 10 == 0 && x != 0) {
            return false;
      
        // Create string from integer
        String s = String.valueOf(x
        int left = 0;
        int right = s.length() - 
        // Compare all characters from both ends.
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
  }
  ```


### 2. Optimized Approach: Revert Half the Number
- **Idea:** Instead of converting to a string or reversing the entire number (which could lead to overflow), we can reverse only the second half of the number and then compare it with the first half.

- **Algorithm:**
  - **Handle Edge Cases:**
    - If $x < 0$, ***return false***.
    - If $x % 10 == 0$ and $x != 0$, ***return false***.
      - (This is crucial here to prevent issues with numbers like 10, 100, etc., where reversing half would give 01, 001 which isn't comparable to the first half 1, 1).
  - **Initialize revertedNumber:** 
    - Set $revertedNumber = 0$. This will store the reversed second half.
  - **Iterate and build revertedNumber:** 
    - Use a while loop that continues as long as $x > revertedNumber$.
  - **In each iteration:**
    - **Get the last digit of x:** 
      - digit = x % 10.
    - **Append this digit to revertedNumber:** 
      - $revertedNumber = revertedNumber * 10 + digit$.
    - **Remove the last digit from x:** 
      - $x = x / 10 (integer division)$.
  - **Comparison:**
    - When the loop terminates, we have two scenarios:
      - **Even number of digits:** 
        - If the original number had an even number of digits (e.g., 1221), x will be equal to revertedNumber (e.g., x becomes 12, revertedNumber becomes 12). 
        - In this case, x == revertedNumber will be true.
      - **Odd number of digits:** 
        - If the original number had an odd number of digits (e.g., 121), x will be the middle digit, and revertedNumber will contain the right half (e.g., x becomes 1, revertedNumber becomes 12). 
        - To compensate for the middle digit, we need to compare x with revertedNumber / 10. 
        - For example, 1 == 12 / 10 (which is 1).
    - **Final Comparision:** 
      - Therefore, the final comparison is return the result of $x == revertedNumber$ OR $x == revertedNumber / 10$.

  - **Time Complexity:**
    - $O(log10(x))$ as we essentially process half the digits of the number.
  - **Space Complexity:**
    - $O(1)$ as we only use a few variables.

- **Java implementation:**
  ```java
  class Solution {
    public boolean isPalindrome(int x) {
        // Edge cases
        // Negative numbers are not palindromes
        // Numbers ending in 0 (except 0 itself) cannot be palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
      
        int revertedNumber = 
        // Loop until we have reversed half of the digits
        // For an odd number of digits, x will be the middle digit
        // For an even number of digits, x will become equal to revertedNumber
        while (x > revertedNumber) {
            int digit = x % 10;
            revertedNumber = revertedNumber * 10 + digit;
            x /= 10; // Integer division
      
        // When the number has an odd number of digits,
        // we can get rid of the middle digit by revertedNumber / 10
        // For example, if x = 121, at the end of loop, x = 1, revertedNumber = 12
        // Then, compare x (1) with revertedNumber / 10 (12 / 10 = 1)
        return x == revertedNumber || x == revertedNumber / 10;
    }
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