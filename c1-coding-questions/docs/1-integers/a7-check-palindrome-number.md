# Integers: Check palindrome
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

## Soltuions:
### 1. Slice num while adding digits to reverse
  - **Approach:**
    - Inital check:
      - **False:** if *n < 0*
      - **False:** if *x != 0 && x % 10 == 0*
    - Add last digit to *rev* and slice it from *n*.
      - Do it till *n* is greater than *rev*.
    - Check palindrome:
      - **True:** if *rev* is equal to *n*.
      - **True:** if *rev / 10* is equal to *n* (for inputs with odd digit count).
      - Otherwise false.
  ```java
        public boolean isPalindrome(int x) {

            // if x < 0
            if(x < 0) return false;
            if(x != 0 && x % 10 == 0) return false;

            int reverse = 0;
            // Loop till rev is smaller than num
            while(x > reverse) {
                int ld = x % 10;
                reverse = (reverse * 10) + ld;
                x = x / 10;
            }
            
            
            if(reverse == x) {
              // When n has odd numers of digits
              return true;
            } else if(x == (reverse / 10)) {
              // When n has odd numers of digits
              return true;
            } else {
                return false;
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