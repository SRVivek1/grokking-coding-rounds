# LeetCode: Reverse String
## Problem statements:
- [Leetcode-344](https://leetcode.com/problems/reverse-string/description/?source=submission-ac) [*Difficulty: Easy*]
  - You are given a character array s. Reverse the array in-place, meaning you must do it without allocating extra space for another array.
    - that is you must do this by modifying the input array in-place with O(1) extra memory.

  - **Example 1**
    - Input: s = ['h','e','l','l','o']
    - Output: ['o','l','l','e','h']

  - **Example 2**
    - Input: s = ['H','a','n','n','a','h']
    - Output: ['h','a','n','n','a','H']


  - **Edge Cases to Consider**
    - Empty array: s = [] (Should return [])
    - Single-character array: s = ['a'] (Should return ['a'])
    - Even-length array: s = ['a', 'b', 'c', 'd']
    - Odd-length array: s = ['x', 'y', 'z']
    - Array with all same characters: s = ['a', 'a', 'a', 'a']
    - Mixed-case characters: s = ['A', 'b', 'C', 'd']

  - **Solution:**
    - **Two-Pointer Approach**
      - Use two pointers: one at the start (left) and one at the end (right).
      - Swap the characters at these positions.
      - Move left forward and right backward.
      - Continue swapping until left >= right.
    - ***Time Complexity:*** 
      - $O(n)$, as we iterate through half of the array.
    - ***Space Complexity:*** 
      - $O(1)$, as we modify the array in-place.
    - **Java implementation:**  
      ```java
          public void reverseString(char[] s) {
              int start = 0, end = s.length - 1;
              while(start < end) {
                  char t = s[start];
                  s[start++] = s[end];
                  s[end--] = t;
              }
          }
          
          /** API to support String input to reverse.**/
          public static String reverse(String s) {
            char[] t = s.toCharArray();
            reverse(t);
            return new String(t);
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