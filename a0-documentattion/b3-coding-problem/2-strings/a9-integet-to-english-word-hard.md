# LeetCode: Integer to English
## Problem statements:
- [Leetcode-273](https://leetcode.com/problems/integer-to-english-words/description/) [*Difficulty: Hard*]
Convert a non-negative integer num to its English words representation.

 
### Examples:
  - **Example 1:**

    - ***Input:*** num = 123
    - ***output:*** "One Hundred Twenty Three"
  
  - ***Example 2:***
    - ***Input:*** num = 1,234
    - ***output:*** "One Thousand Two Hundred Thirty Four"

  - ***Example 3:***
    - ***Input:*** num = 12,345
    - ***output:*** "Twelve Thousand Three Hundred Forty Five"

  - ***Example 4:***
    - ***Input:*** num = 123,456
    - ***output:*** "One Hundred Twenty Three Thousand Four Hundred Fifty Six"
 
  - ***Example 5:***
    - ***Input:*** num = 1,234,567
    - ***output:*** "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
  
  - ***Example 6:***
     - ***Input:*** num = 12,345,678
    - ***output:*** "Twelve Million Three Hundred Forty Five Thousand Six Hundred Seventy Eight"

  - ***Example 7:***
    - ***Input:*** num = 123,456,789
    - ***output:*** "One Hunddred Twenty Three Million Four hundred Fifty Six Thousand Seven hundred Eighty nine"

  - ***Example 7:***
    - ***Input:*** num = 5,123,456,789
    - ***output:*** "Five Billion One Hunddred Twenty Three Million Four hundred Fifty Six Thousand Seven hundred Eighty nine"


> **Note:**
> A million is ($10^6$), that is 1,000,000 (Ten lakhs).
> A billion is ($10^9$), that is 1,000,000,000 (100 crore).
> A trillion is ($10^12$), that is 1,000,000,000,000 (10 lakh crore).
> A Quadrillion is ($10^15$), that is 1,000,000,000,000,000 (100 lakh crore).

### Constraints:
  - 0 <= num <= 231 - 1


## Challenges in This Problem
  - **Handling Large Numbers:**
    - Numbers can be very large (up to 2,147,483,647). We need to efficiently decompose and process large values.
  - **Handling Different Word Conventions:**
    - Special cases like 11 to 19 (Eleven, Twelve, ..., Nineteen) follow a different naming convention.
    - Tens place (20, 30, ..., 90) has unique words like "Twenty", "Thirty", etc.
    - Hundreds, Thousands, Millions, Billions must be processed in groups of three digits.
  - **Edge Cases:**
    - 0 should return "Zero".
    - Numbers like 1000, 1000000 should not have extra spaces ("One Thousand" instead of "One Thousand ").
  

## Solution Approach:
  - **1. Divide the Number into Chunks of 3 Digits:**
    - We process the number three digits at a time, from right to left (units, thousands, millions, billions).
    - **Example:** 
      - 1,234,567,890 → 890 (units), 567 (thousands), 234 (millions), 1 (billions).

  - **2. Process Each Three-Digit Chunk**
    - ***Convert numbers under 1000 using:***
      - ***Single digits:*** 
        - "One", "Two", ..., "Nine"
      - ***Teens:*** 
        - "Eleven", "Twelve", ..., "Nineteen"
      - **Tens:** 
        - "Twenty", "Thirty", ..., "Ninety"
      - ***Hundreds:*** 
        - "One Hundred", "Two Hundred", ..., "Nine Hundred"
    - Handle edge cases like "Eleven" (not "Ten One") and "Zero" (not "Zero Hundred").
  - **3. Recursively Process Each Chunk with Correct Suffix**
    - Append "Thousand", "Million", "Billion" based on the chunk position.



## Solution: 
### Solution-1: Optimized CPU time and Memory
  ```java
        String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        public String numberToWords(int num) {   
            if(num == 0) {
                return "Zero";
            } else {
                return helperX(num);
            }
        }

        public String helperX(int num) {
            StringBuilder sb = new StringBuilder();

            if(num < 20) 
                sb.append(belowTwenty[num]); 
            else if(num < 100)
                sb.append(tens[num / 10]).append(" ").append(helperX(num % 10));
            else if(num < 1000)  
                sb.append(helperX(num / 100)).append(" Hundred ").append(helperX(num % 100));
            else if(num < 1000000) 
                sb.append(helperX(num / 1000)).append(" Thousand ").append(helperX(num % 1000));
            else if(num < 1000000000) 
                sb.append(helperX(num / 1000000)).append(" Million ").append(helperX(num % 1000000));
            else 
                sb.append(helperX(num / 1000000000)).append(" Billion ").append(helperX(num % 1000000000));

            return sb.toString().trim();
        }
  ```

### Solution-2: Requires more CPU Time and Memory
  ```java 
      package com.srvivek;

      public class IntegerToEnglishWord {

          String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                  "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

          String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

          final String HUNDRED = "Hundred";

          String[] thousands = {"", "Thousand", "Million", "Billion", "Trillion"};


          public String integerToEnglish(Integer value) {

              if (value == null ) return "";
              if(value == 0) return "zero";

              int x = value;
              StringBuilder sb = new StringBuilder();
              int index = 0;
              while(value != 0) {
                  if(value % 1000 > 0) {
                      String t = helper(value % 1000);
                      if(index == 0) {
                          sb.insert(0, t);
                      } else {
                          sb.insert(0, t + " " + thousands[index] + (sb.isEmpty() ? "" : " "));
                      }
                  }
                  value /= 1000;
                  ++index;
              }

              String word = sb.toString();
              System.out.printf("Input : %d %nOutput: %s%n", x, word);
              return word;
          }

          /**
           * Process value in 3 digit chunks
           */
          private String helper(int value) {
              if (value == 0) return "";
              if (value < 20) return belowTwenty[value];
              if(value < 100) return tens[value/10] + " " + helper(value % 10);
              else return belowTwenty[value / 100] + " " + HUNDRED + " " + helper(value % 100);
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