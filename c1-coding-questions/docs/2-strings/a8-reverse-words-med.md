# LeetCode: Reverse Words in a String
## Problem statements:
- [Leetcode-151](https://leetcode.com/problems/reverse-words-in-a-string/description/) [*Difficulty: Medium*]
  - Given a string s, reverse the order of words in a string while preserving spaces.
  - A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
  - Return a string of the words in reverse order concatenated by a single space.
  > **Note:** That the String ***s*** may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

### Examples:
  - **Example 1:**
    - **Input:** s = "the sky is blue"
    - **Output:** "blue is sky the"

  - **Example 2:**
    - **Input:** s = "  hello world  "
    - **Output:** "world hello"

  - **Example 3:**
    - **Input:** s = "a good   example"
    - **Output:** "example good a"

### Constraints:
  - 1 <= s.length <= 104
  - s contains English letters (upper-case and lower-case), digits, and spaces ' '.
  - There is at least one word in s.


## Edge Cases to Consider
  - **Multiple spaces:** Ensure consecutive spaces are reduced to one.
    - ***Input:*** " hello world "
    - ***Output:*** "world hello"
  - **Leading or trailing spaces:** They should be removed.
    - ***Input:*** " hello "
    - ***Output:*** "hello"
  - **Single word:** Should return the word itself without extra spaces.
    - ***Input:*** "hello"
    - ***Output:*** "hello"
  - **Empty string or spaces only:** Should return an empty string.
    - ***Input:*** " "
    - ***Output:*** ""
  - **Special characters and numbers:** They should be treated as normal words.
    - ***Input:*** "123 hello! @world"
    - ***Output:*** "@world hello! 123"
  

## Solution Approach:
### **Approach-1:** *In-place Reversal (Optimal) - T.C: O(N) & S.C: O(1)*
  - Since we need $O(1)$ space complexity, we must modify the string in-place without using extra memory for storing words separately.
  - **Steps to Solve:**
    - **Stage-A:** Reverse the string
      - **Step-1: *Reverse the entire string:***
        - This moves the last word to the front and vice versa.
      - **Step-2: *Reverse each word individually:***
        - This restores the correct word order.
    - **Stage-B: Trim extra spaces:** 
      - **Step-1: *Cleanup spaces in the string.***
        - Remove leading, trailing, and multiple spaces.
    - Finally, Return the final reversed string.

### **Approach-2:** *Using StringBuilder to split and merge words*
  - This approach uses ***StringBuilder*** to construct the reversed string efficiently. 
  - While ***StringBuilder*** takes extra space, we will aim for minimal extra memory usage by avoiding ***List<String>*** storage.
  - **Steps to Solve:**
    - **Step-1: *Trim leading/trailing spaces:*** 
      - Use String class *trim()* API to remove leading and trailling spaces.
    - **Step-2: *Split words efficiently:*** 
      - Instead of using ***split(" ")***, we can manually extract words while skipping extra spaces.
    - **Step-3: *Use StringBuilder for efficient concatenation:*** 
      - Append words in reverse order to avoid extra memory overhead from ***List<String>***.



## Solution: 
### **Solution-1:** *Two Pointer approach [T.C: O(n) & S.C: O(1)]*
  - This solution uses 2 pointer approach to reverse string, words and space cleanup.  
  ```java
          public String solution(String s) {
              if (s == null || s.isBlank()) return "";
              if (s.length() == 1) return s;

              char[] arr = s.toCharArray();

              // Step-1: Reverse entire string
              reverse(arr, 0, arr.length - 1);

              // step-2: reverse each word
              reverseWord(arr);

              // Step-3: clean spaces
              int len = cleanSpaces(arr);

              String res = new String(arr, 0, len);
              System.out.printf("Input : [%s] %nOutput: [%s] %n", s, res);
              return res;
          }

          public int cleanSpaces(char[] arr) {
              int l = 0, r = 0;
              while(r < arr.length) {
                  while (r < arr.length && arr[r] == ' ') r++;
                  while (r < arr.length && arr[r] != ' ') {
                      arr[l++] = arr[r++];
                  }
                  // Skip extra spaces between words
                  while (r < arr.length && arr[r] == ' ') r++;
                  if (r < arr.length) arr[l++] = ' ';
              }
              // Remove trailing space if it exists
              return (l > 0 && arr[l - 1] == ' ') ? l - 1 : l;
          }


          public void reverseWord(char[] arr) {
              int l = 0, r = 0;
              while(r < arr.length) {
                  // Find start of the word
                  while(l < arr.length && arr[l] == ' ') l++;
                  if (l >= arr.length) break;

                  // Find end of the word
                  r = l;
                  while (r < arr.length && arr[r] != ' ') r++;

                  // reverse word
                  if(l < r) reverse(arr, l, r - 1);

                  //move to next word
                  l = r;
              }
          }

          public void reverse(char[] arr, int start, int end) {
              while(start < end) {
                  char temp = arr[start];
                  arr[start++] = arr[end];
                  arr[end--] = temp;
              }
          }
  ```
  - Time & Space Complexity Analysis
    - **Time Complexity:**
      - ***Removing extra spaces:*** $O(n)$
      - ***Reversing the entire string:*** $O(n)$
      - ***Reversing each word:*** $O(n)$
      - ***Total:*** $O(n)$
    - **Space Complexity:**
      - In-place modification, using only a few extra variables → $O(1)$
  

### **Solution-2:** *Using StringBuilder to split and merge words*
  ```java 
        public static String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            int right = s.length() - 1;

            while (right >= 0) {
                // Skip trailing spaces
                while (right >= 0 && s.charAt(right) == ' ') right--;
                if (right < 0) break;

                // Find start of the word
                int left = right;
                while (left >= 0 && s.charAt(left) != ' ') left--;

                // Append word
                sb.append(s, left + 1, right + 1).append(' ');

                // Move right pointer
                right = left;
            }

            // Remove last space
            return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
        }
  ```
  - **Time & Space Complexity Analysis**
    - **Time Complexity:** 
      - ***Traversing the string once from right to left:*** $O(n)$
      - ***Appending words to StringBuilder:*** $O(n)$
      - ***Total:*** $O(n)$
    - **Space Complexity:**
      - $O(n)$ for StringBuilder (used for output).
      - Not $O(1)$, since we store the result separately.

---

### Comparison with In-Place Approach

| Approach	| Time Complexity	| Space	Complexity	| Pros	| Cons |
| --------- | ---------------- | ---------------- | ----- | ---- |
| In-Place Reversal |	O(n) | O(1)| No extra space, efficient | Complex implementation |
| StringBuilder Approach | O(n) | O(n) | Simple, easy to understand | Uses extra space |


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