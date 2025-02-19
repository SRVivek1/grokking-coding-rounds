# Integers: Roman to integer
## Problem stattement:
- Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

| Symbol | Value | Symbol | Value | Symbol | Value |
| ------ | ----- | ------ | ----- | ------ | ----- |
| I      | 1     | L      | 50    | D      | 500   |
| V      | 5     | C      | 100   | M      | 1000  |
| X      | 10    |


- For example, 
  - 2 is written as II in Roman numeral, just two ones added together. 
  - 12 is written as XII, which is simply X + II. 
  - The number 27 is written as XXVII, which is XX + V + II.

- Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. 
- There are six instances where subtraction is used:
  - I can be placed before V (5) and X (10) to make 4 and 9. 
  - X can be placed before L (50) and C (100) to make 40 and 90. 
  - C can be placed before D (500) and M (1000) to make 400 and 900.

- Given a roman numeral, convert it to an integer.
  - Example 1:
    - Input: s = "III"
    - Output: 3
    - Explanation: III = 3.

  - Example 2:
    - Input: s = "LVIII"
    - Output: 58
    - Explanation: L = 50, V= 5, III = 3.

  - Example 3:
    - Input: s = "MCMXCIV"
    - Output: 1994
    - Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 
- Constraints:
  - 1 <= s.length <= 15
  - s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
  - It is guaranteed that s is a valid roman numeral in the range [1, 3999].

## Soltuions:
### 1. Approach: Iterate string as array of chars
  - Check if next value is greater than previous than subtract it from next value and add it to result.
  - Otherwise simply add current value to result.

    ```java
        class Solution {
            public int romanToInt(String s) {
                int num = 0;
                for (int i = 0; i < s.length(); i++) {
                    int val1 = value(s.charAt(i));
                    if (i + 1 < s.length()) {
                        int val2 = value(s.charAt(i + 1));
                        if (val1 < val2) {
                            num += val2 - val1;
                            i++;
                        } else {
                            num += val1;
                        }
                    } else {
                        // last index
                        num += val1;
                    }
                }
                return num;
            }

            public int value(char roman) {
                switch (roman) {
                    case 'I':
                        return 1;
                    case 'V':
                        return 5;
                    case 'X':
                        return 10;
                    case 'L':
                        return 50;
                    case 'C':
                        return 100;
                    case 'D':
                        return 500;
                    case 'M':
                    default:
                        return 1000;
                }
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