# LeetCode: Longest Repeating DNA Sequence
## Problem statements:
- [Leetcode-187](https://leetcode.com/problems/repeated-dna-sequences/description/) [*Difficulty: Medium*]
  - The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
    - For example, "ACGAATTCCG" is a DNA sequence.
  - When studying DNA, it is useful to identify repeated sequences within the DNA.

  - Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

### Examples:
  - **Example 1:**
    - **Input:** s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    - **Output:** ["AAAAACCCCC","CCCCCAAAAA"]

  - **Example 2:**
    - **Input:** s = "AAAAAAAAAAAAA"
    - **Output:** ["AAAAAAAAAA"]

### Constraints:
  - The input string s has a length between 1 and 10^5.
  - The string s consists of only 'A', 'C', 'G', and 'T'.


## Solution Approach:
  - We need to efficiently find all ***10-letter*** substrings that appear more than once in the input String. 
    - The key is to: Extract substrings of length 10.
    - Track frequency of substrings using a set or hash map.
    - Return only the unique substrings that appear more than once.


## Solution: 
```java
      public List<String> findRepeatedDnaSequences(String s) {
          int len = 0;
          if(s == null || s.isBlank() || (len = s.length()) < 10 || len > 100000) {
            return Collections.emptyList();
          }
          
          Set<String> ss = new HashSet<>(), res = new HashSet<>();
          
          for(int i = 0; i <= len - 10; i++) {
              String t = s.substring(i, i + 10);
              if(!ss.add(t)){
                  res.add(t);
              }
          }
          return new ArrayList<>(res);
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