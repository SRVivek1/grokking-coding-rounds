# LeetCode: Longest Common Prefix
## Problem statements:
- [Leetcode-14](https://leetcode.com/problems/longest-common-prefix/description/) [*Difficulty: Easy*]
  - Write a function to find the longest common prefix string amongst an array of strings.
  - If there is no common prefix, return an empty string "".

 
### Examples:
  - **Example 1:**
    - **Input:** strs = ["flower","flow","flight"]
    - **Output:** "fl"

  - **Example 2:**
    - **Input:** strs = ["dog","racecar","car"]
    - **Output:** ""
    - **Explanation:** 
      - There is no common prefix among the input strings.

  - **Example 3:**
    - **Input:** strs = ["apple","apricot","apartment"]
    - **Output:** "ap"
 
### Constraints:
  - *1 <= strs.length <= 200*
  - *0 <= strs[i].length <= 200*
  - *strs[i] consists of only lowercase English letters if it is non-empty.*


### Solution Approach:
  - 1. **Horizontal Scanning (Efficient for small input):**
    - Start with the first string as the prefix.
    - Compare it with each subsequent string and reduce the prefix until a match is found.
    - If at any point, the prefix becomes an empty string, return "".
    - **Time Complexity:**
      - *O(N×M)*, where *N* is the number of strings and *M* is the length of the longest string.
    - **Additional Notes:**
      - The above approach is simple and works well for small input sizes.

  - 2. **Vertical Scanning (Optimized for early mismatch):**
    - Pick characters one by one from the first string.
    - Compare it with corresponding characters in other strings.
    - Stop if there is a mismatch or if we reach the end.
    - **Time Complexity:**
      - *O(N×M)*, but can be faster in case of early mismatches.

  - 3. **Divide and Conquer (Optimized for large input):**
    - Divide/Split the array into two halves.
    - Find the common prefix of each half.
    - Merge the two common prefixes.
    - **Time Complexity:**
      - *O(N×M)*, but can be faster in case of early mismatches.
  
  - 4. **Bitwise Comparison (Alternative approach):**
    - Use bitwise operations to compare characters in positions across strings.
    - Increase efficiency in cases where many strings share identical prefixes.
    - **Time Complexity:**
      - *O(N × M)*, but efficient for large datasets with high similarity.

  - 4. **Trie (For Large Inputs):**
    - Insert all words into a Trie.
    - Traverse down until a branching occurs.
    - **Time Complexity:**
      - *O(N×M)*, but requires extra space *O(N×M)*.

## Solution: Horizontal Scanning
```java
      public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
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