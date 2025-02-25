# Integers: Plus one
## Problem statements:

- [leetcode-66](https://leetcode.com/problems/plus-one/description/)
- You are given a large integer represented as an integer array digits, where each *digits[i]* is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

- Increment the large integer by one and return the resulting array of digits.
 
- **Example 1:**
  - **Input:** digits = [1,2,3]
  - **Output:** [1,2,4]
  - **Explanation:** 
    - The array represents the integer 123.
    - Incrementing by one gives 123 + 1 = 124.
    - Thus, the result should be [1,2,4].

- **Example 2:**
  - **Input:** digits = [4,3,2,1]
  - **Output:** [4,3,2,2]
  - **Explanation:** 
    - The array represents the integer 4321.
    - Incrementing by one gives 4321 + 1 = 4322.
    - Thus, the result should be [4,3,2,2].

- **Example 3:**
  - **Input:** digits = [9]
  - **Output:** [1,0]
  - **Explanation:** 
    - The array represents the integer 9.
    - Incrementing by one gives 9 + 1 = 10.
    - Thus, the result should be [1,0].
 

- **Constraints:**
  - *1 <= digits.length <= 100*
  - *0 <= digits[i] <= 9*
  - *digits does not contain any leading 0's.*

## Solution:
  - **Appraoch:**
    - We will need a array if all elements are *9* in the input array.
    - And in this case all other values in array will become *1*.
  - **Implementation:**
    ```java
        public int[] plusOne(int[] digits) {

            for(int i = digits.length - 1; i >=0; i--) {
                if (digits[i] < 9) {
                    digits[i] += 1;
                    return digits;
                }
                digits[i] = 0;
            }

            // that is all digits are 9, new array with size + 1 and set MSB to '1'
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;

            return newDigits;
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