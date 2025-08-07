# LeetCode: Longest Substring Without Repeating Characters
## Problem statements:
- [Leetcode-3](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/) [*Difficulty: Medium*]
  - Given a string s, return the length of the longest substring without repeating characters.

### Examples:
  - **Example 1:**
    - **Input:** s = "abcabcbb"
    - **Output:** 3 ("abc")

  - **Example 2:**
    - **Input:** s = "bbbbb"
    - **Output:** 1 ("b")

  - **Example 3:**
    - **Input:** s = "pwwkew"
    - **Output:** 3 ("wke")

### Constraints:
  - 0 <= s.length <= 5 * 104
  - s consists of English letters, digits, symbols and spaces.


## Edge Cases to Consider
  - **Empty String ("")**: 
    - *The result should be 0.*
  - **Single Character String ("a")**: 
    - *The result should be 1.*
  - **All Unique Characters ("abcdef")**: 
    - *The result should be length of the string.*
  - **All Same Characters ("aaaa")**: 
    - *The result should be 1.*
  - **Repeating Characters in Between ("abcabcbb")**: 
    - *The result should be 3 ("abc").*
  - **Long Input String**: 
    - *Ensuring efficiency for large inputs*


## Solution Approach:
  - **Approach 1:** *We can use the Sliding Window with Array or HashMap (or HashSet)*
    - **Algorithm:**
      - Initialize two pointers, **left** and **right**, to define a window in the string.
      - Expand **right** to include characters until a duplicate is found.
      - Maintain an Array or HashSet (or HashMap) to track unique characters in the window.
        - **Note:** Using an Array is more efficient for memory and runtime than a HashSet.
      - If a duplicate is found, move **left** to shrink the window until uniqueness is restored.
      - Update the maximum length of such a window.
      - Continue adjusting the window until the end of the string is reached.
      - Finally, return the maximum length found.

    - **Time Complexity:**
      - Each character is processed at most twice (once added and once removed), making it O(n).

## Solution: 
  - **Solution-1: Array - Using Sliding Window with Array (Time: O(n), Space: O(1))**
    ```java
        public int lengthOfLongestSubstringArr(String s) {
            if(s == null || s.length() == 0) return 0;

            int[] fr = new int[128]; // frequency
            int l = 0, r = 0, ml = 0; // left, right, maxLength

            while(r < s.length()){
                char c = s.charAt(r);
                while(fr[c] > 0) {
                    fr[s.charAt(l)]--;
                    l++;
                }
                fr[c]++;
                ml = Math.max(ml, r - l + 1);
                r++;
            }
            return ml;
        }
    ```

  - **Solution-1: Set - Using Sliding Window with Array (Time: O(n), Space: O(1))**
  ```java
      public int lengthOfLongestSubstringSet(String s) {
          if(s == null || s.length() == 0) return 0;

          int l = 0, ml = 0;
          Set<Character> uc = new HashSet<>();
          
          for(int r = 0; r < s.length(); r++) {
              while(uc.contains(s.charAt(r))) {
                  uc.remove(s.charAt(l));
                  l++;
              }
              uc.add(s.charAt(r));
              ml = Math.max(ml, r - l + 1);
          }
          return ml;     
      }
  ```


## Summary:
  - We have solved the problem using the Sliding Window technique.
  - We have used an Array to track the frequency of characters in the window.
  - We have also solved the problem using a HashSet to track unique characters in the window.
  - The time complexity of both solutions is $O(n)$, where n is the length of the input string.
  - The space complexity of both solutions is $O(1)$, as the size of the Array or HashSet is constant.

  
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