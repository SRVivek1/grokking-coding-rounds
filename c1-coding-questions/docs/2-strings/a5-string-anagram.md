# LeetCode: String Anagrams
## Problem statements:
- [Leetcode-242](https://leetcode.com/problems/valid-anagram/description/) [*Difficulty: Easy*]
  - Given two strings s and t, return true if t is an anagram of s, and false otherwise.
  - An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

### Examples:
  - **Example 1:**
    - **Input:** s = "anagram", t = "nagaram"
    - **Output:** true

  - **Example 2:**
    - **Input:** s = "rat", t = "car"
    - **Output:** false

### Constraints:
  - 1 <= s.length, t.length <= 5 * 10^4
  - s and t consist of lowercase English letters.



## Solution Approach:
  - **Edge Cases to Consider:**
    - ***Different lengths:*** 
      - If s and t have different lengths, they cannot be anagrams.
    - ***Empty strings:*** 
      - If both s and t are empty, they should return true.
    - ***Single-character strings:*** 
      - "a", "a" → true, "a", "b" → false
    - ***Same characters but different frequencies:*** 
      - "aabb" and "ab" → false
    - ***Uppercase vs. lowercase:*** 
      - Problem assumes lowercase only, but if case is considered, "Hello" and "hello" would be false.

  - **Approach 1: *Using a Frequency Counter (Time: O(n), Space: O(1))***
    - Use an integer array of size 26 (for lowercase English letters).
      - Increase the array size as needed for Unicode characters.
      - Use a HashMap for counting character frequencies instead of an array for all unicode characters.
    - Iterate through s, incrementing character count.
    - Iterate through t, decrementing character count.
    - If all counts are zero at the end, return true.
  
  - **Approach 2: *Using Sorting (Time: O(n log n), Space: O(1))***
    - Sort both strings.
    - Compare the sorted strings. If they are equal, they are anagrams.


## Solution: 
### 1. Using integer array to count frequency (Time: O(n), Space: O(1))
  ```java
      public boolean isAnagramArrSol(String s, String t) {
          if(s == null || t == null || s.length() != t.length()) return false;

          int[] fr = new int[26];

          // update frequency of chars
          for(char c: s.toCharArray()) {
              ++fr[c - 'a'];
          }

          // match frequency
          for(char c: t.toCharArray()) {
              --fr[c - 'a'];
          }

          for(int i = 0; i < fr.length; i++) {
              if(fr[i] != 0) return false;
          }

          return true;
      }
  ```

### 2. Using HashMap to count frequency (Time: O(n), Space: O(1))
  ```java
      public boolean isAnagramMapSol(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
              map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c: t.toCharArray()) {
              Integer v = map.get(c);
              if(v == null) {
                  return false;
              } else {
                  if (v > 1) {
                      map.put(c, v - 1);
                  } else {
                      map.remove(c);
                  }
              }
        }
        return map.isEmpty();
      }
  ```

### 3. Using Sorting (Time: O(n log n), Space: O(1))
  ```java
      public boolean isAnagramSortSol(String s, String t) {
          if(s == null || t == null || s.length() != t.length()) return false;

          char[] sArray = s.toCharArray();
          char[] tArray = t.toCharArray();

          Arrays.sort(sArray);
          Arrays.sort(tArray);

          return Arrays.equals(sArray, tArray);
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