# String palindrome
## 1. Plindrome check (Case sensitive)
### Project Ref: [string-algo-palindrome](https://github.com/SRVivek1/grokking-coding-rounds/tree/main/a1-ds-algo-java/string-algo/src/main/java/com/srvivek/dsalgo/app/palindrome)

- **<ins>About / Introduction</ins>**
  - A string is said to be palindrome, if it remains the same on reading from both ends. 
  - It means that when we reverse a given string, it should be the same as the original string. 
  - **For instance,**
    - The string ***level*** is a palindrome because it remains the same when you read it from the beginning to the end and vice versa.
- **<ins>Advantage</ins>**
  - It shields the clients from the complexities of the sub-system components.
  - It promotes loose coupling between subsystems and its clients.
> Note: For such String problems, analyze the problem as a array of *characters* and not as a *String*.

## Approach
### *Approach 1. Two-Pointer Technique:*
  1. *Initialize two pointers:*
     - left at the start (0 index).
     - right at the end (length - 1 index).
  2. *Compare the characters at both pointers.*
    - If they don’t match, the string is not a palindrome.
      - set response to false
      - Exit the loop.
  3. *Move the pointers inward:*
    - Increment left.
    - Decrement right.
  4. *Repeat until the pointers cross.*
  - **Soution in Java:**
    ```java
        /**
         * Check if given string is palindrome.
        *
        * @param str
        * @return
        */
        public static Boolean palindromeAlgo(String str) {
            boolean res = true;

            for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
                if (str.charAt(i) != str.charAt(j)) {
                    res = false;
                    break;
                }
            }
            return res;
        }
    ```

### *Approach 2: Reverse and Compare*
 - Reverse the string and compare it to the original. If they match, it’s a palindrome.
 - **Steps:**
    1. Reverse the string.
    2. Compare the reversed string to the original.

### *Approach 3: Ignoring Case, Spaces, and Special Characters*
  - For more realistic cases (e.g., sentences like "A man, a plan, a canal, Panama"), ignore non-alphanumeric characters and consider case insensitivity.
  - **Steps:**
    1. Normalize the string:
          - Convert it to lowercase.
          - Remove non-alphanumeric characters. (If asked in problem to ignore numeric characters)
    2. Use either the two-pointer or reverse-and-compare approach.
       1. Check above for implementation.
  - **Soution in Java:**
    - *Normalize string by changing all chars to lower-case*
      ```java
              /**
               * Convert string to lower case and then check for palindrome.
                * @param str
              * @return
              */
              public static String convertToLowerCase(String str) {
                  StringBuilder res = new StringBuilder();

                  for (char c : str.toCharArray()) {

                      // if upper case convert to lowercase
                      if (c >= 'A' && c <= 'Z') {
                          res.append((char) (c + ('a' - 'A')));
                      } else {
                          res.append(c);
                      }
                  }
                  return res.toString();
              }
      ```
    - Remove non-alphabet chars from string
      ```java
              /**
               * Remove non alphabet chars from string.
               */
              public static final String removeSpecialCharacters(String str) {
                String s = str;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    // If not an alphabet
                    if (c < 'A' || c > 'Z' && c < 'a' || c > 'z') {
                        s = s.substring(0, i) + s.substring(i + 1);
                        i--;
                    }
                }
                return s;
            }
      ```
- **<ins>References:</ins>**
  - [https://www.javatpoint.com/java-ascii-table](https://www.javatpoint.com/java-ascii-table)
  - [https://www.geeksforgeeks.org/string-palindrome/](https://www.geeksforgeeks.org/string-palindrome/)

---


<center>
<h1> ------ End ------ </h1>
</center>
