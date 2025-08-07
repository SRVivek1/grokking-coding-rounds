# LeetCode: Longest String Palindrome
## Problem statements:
- [Leetcode-5](https://leetcode.com/problems/longest-palindromic-substring/description/) [*Difficulty: Medium*]
  - Given a string s, return the longest palindromic substring in s.

### Examples:
  - **Example 1:**
    - **Input:** s = "babad"
    - **Output:** "bab" or "aba"

  - **Example 2:**
    - **Input:** s = "cbbd"
    - **Output:** "bb"

### Constraints:
  - 1 <= s.length <= 1000
  - s consists of only digits and English letters.


## Solution Approach:
### Approach-1: Brute Force Approach (Time Complexity : O(N³) and Space Complexity : O(1))
  - **Steps:**
    - ***Step-1:*** 
      - Generate all possible substrings of the given string.
    - ***Step-2:*** 
      - Check each substring if it's a palindrome.
    - ***Step-3:*** 
      - Keep track of the longest palindrome found.
  💡- **Note:** 
      - Not an efficient due to $O(N³)$ complexity.

### Approach-2: Expand Around Center (Time Complexity : O(N²) and Space Complexity : O(1))
  - **Approach**
    - Palindrome property: A palindrome mirrors around its center.
    - There are 2N-1 centers (each character and the gaps between characters).
    - Expand outward from each center and find the longest palindrome.
  
  - **Steps:**
    - ***Step-1:*** 
      - Iterate through each character of the string.
    - ***Step-2:*** 
      - For each character, expand around the center to find the longest palindrome while ***left == right*** and ***s[left] == s[right]***.
    - ***Step-3:***
      - Do the same for odd and even length palindromes.
    - ***Step-4:*** 
      - Keep track of the longest palindrome found.


### Approach-3: Dynamic Programming (Time Complexity : O(N²) and Space Complexity : O(N))
  - ***Approach***
    - Create a 2D table to store results of subproblems.
  - ***Step-1:*** 
    - Initialize a table to false, and set the diagonal to true (single character palindromes).
  - ***Step-2:*** 
    - Fill in the table according to the palindromic conditions.
  - ***Step-3:*** 
    - Track the longest palindrome using start and max_length variables.



## Solution: 
### Approach-2: Expand Around Center (Time Complexity : O(N²) and Space Complexity : O(1))
  - **Recursion Approach:**
    - **Note:** The recursion solution is not efficient due to the extra space used in the recursive stack.
    ```java 
            String lps = "";
            public String longestPalindrome(String s) {
                if (s == null || s.length() <= 1) return s;

                for(int i = 0; i < s.length(); i++) {
                    expandAroundCenter(s, i, i);
                    expandAroundCenter(s, i, i + 1);
                }
                return lps;
            }

            public void expandAroundCenter(String s, int l, int r){
                while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
                l++;
                r--;
                if(lps.length() < r - l + 1) {
                    lps = s.substring(l, r + 1);
                }
            }
    ```

  - **Iterative Approach:**  
    ```java
              public String longestPalindrome_iterative(String s) {
                  if (s == null || s.length() <= 1) return s;

                  String lps = "";
                  int si = 0, ei = 0;

                  for(int i = 0; i < s.length(); i++) {
                  
                      // Odd length substring
                      int l = i, r = i;
                      while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                          if(lps.length() < r - l + 1) {
                              lps = s.substring(l, r + 1);
                              si = l;
                              ei = r;
                          }
                          l--;
                          r++;
                      }

                      // even length substring
                      l = i;
                      r = (i < s.length() - 1) ? i + 1 : i;
                      while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                          if(lps.length() < r - l + 1) {
                              lps = s.substring(l, r + 1);
                              si = l;
                              ei = r;
                          }
                          l--;
                          r++;
                      }
                  }
                  return lps;
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