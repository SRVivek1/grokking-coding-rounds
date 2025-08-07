# LeetCode: Factorail Trailling zeros
## Problem statements:

- [Leetcode-172](https://leetcode.com/problems/factorial-trailing-zeroes/description/) [*Difficulty: Medium*]
  - Given an integer n, return the number of trailing zeroes in n!.
  - **Note** that $n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1$.


  - **Example 1:**
    - **Input:** n = 3
    - **Output:** 0
    - **Explanation:** 3! = 6, no trailing zero.

  - **Example 2:**
    - **Input:** n = 5
    - **Output:** 1
    - **Explanation:** 5! = 120, one trailing zero.

  - **Example 3:**
    - **Input:** n = 0
    - **Output:** 0
 
  - **Constraints:**
    - *0 <= n <= 104*
 

- **Follow up:** Could you write a solution that works in logarithmic time complexity?

## Solution:
  - **Problem Explanation:**
    - The problem requires us to find the number of trailing zeros in the factorial of a given integer n. - Trailing zeros in a factorial are produced by the factors of 10, which are the result of multiplying 2 and 5. 
      - Since there are always more 2s than 5s in the prime factorization of a factorial, the number of trailing zeros is determined by the number of times 5 is a factor in the numbers from 1 to n.

  - **Key Insight:**
    - To count the number of trailing zeros in n!, we need to count the number of times 5 is a factor in all numbers from 1 to n. 
      - This can be done by dividing n by 5, then by 25, then by 125, and so on, until the division result is less than 1. 
      - The sum of these divisions gives the total number of trailing zeros.
  
  - **Algorithm:**
    - ***Step-1:*** Initialize a variable count to 0.
    - ***Step-2:*** Divide n by 5 and add the result to count.
      - Repeat the process with n divided by 25, 125, etc., until the division result is less than 1.
    - ***Step-3:*** Return count as the number of trailing zeros.

  - **Time/Space Complexity:**
    - The time complexity of this algorithm is $O(log₅ n)$, as we are dividing n by powers of 5 in each step.
    - The space complexity is O(1), as we are using a constant amount of extra space.


  - **Solution-1: Logrithmic approach**
    - ***Dividing the input by 5.***
      ```java
          public int trailingZeroes(int n) {
              int count = 0;
              while( n > 0) {
                  n = n / 5;
                  count += n;
              }
              return count;
          }
      ```

    - ***Increasing a divisor with power of 5.***
      ```java
          public int trailingZeroes(int n) {
              int count = 0;
              int pof = 5;
              while(n >= pof) {
                  count += n / pof;
                  pof *= 5;
              }
              return count;
          }
      ```

  - **Solution-1: Bruteforce approach**
    - **Approach:**
      - Calculate the factorial of given number.
      - initialize a counter variable with $0$.
      - Extract the digits of number from Last Signifincat Bit(LSB) to MSB.
        - Loop till the number becomes non-zero.
      - Return the counter.
    
    - **Time Complexity:**
      - The time complexity of computing the factorial is $O(n)$, as we multiply numbers from 1 to n.
      - Counting the trailing zeros is $O(log₁₀(n!))$, as we divide the factorial by 10 repeatedly.
    - **Space Complexity:**
      - The space complexity is $O(1)$ for counting trailing zeros.

    - **Limitations:**
      - **Integer Overflow:**
        - The factorial of even small numbers like 20 is a very large number (2,432,902,008,176,640,000), which cannot be stored in a long variable. This leads to overflow.

      - **Inefficiency:**
        - For large values of n, computing the factorial is computationally expensive and impractical.

    - **Note:** 
      - Computing the factorial requires storing a very large number, which can lead to integer overflow for large n.    
      - Overall, the brute force approach is inefficient for large values of n due to the factorial computation.

    - **Implementation:**
      ```java
            public class TrailingZerosInFactorialBruteForce {
                // Function to compute the factorial of a number
                public static long computeFactorial(int n) {
                    long factorial = 1;
                    for (int i = 2; i <= n; i++) {
                        factorial *= i;
                    }
                    return factorial;
                }

                // Function to count trailing zeros in the factorial
                public static int countTrailingZeros(int n) {
                    // Compute the factorial of n
                    long factorial = computeFactorial(n);
                    
                    // Count the number of trailing zeros
                    int count = 0;
                    while (factorial > 0) {
                        if (factorial % 10 == 0) {
                            count++;
                            factorial /= 10;
                        } else {
                            break;
                        }
                    }
                    return count;
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