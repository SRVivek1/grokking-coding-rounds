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
    - $0 <= n <= 10^4$
 

## Follow up Questions:
  - Could you write a solution that works in logarithmic time complexity ?


## Problem Analysis:
  - The problem asks us to find the number of trailing zeroes in given number $n$. 
    - A trailing zero is formed by a factor of 10. 
    - Since $10 = 2 * 5$, we need to count the number of pairs of 2 and 5 in the prime factorization of $n$.
  - For any integer $k$, the number of factors of $2$ will always be greater than or equal to the number of factors of $5$. 
    - This is because multiples of $2$ appear more frequently than multiples of $5$ (e.g., 2, 4, 6, 8... vs. 5, 10, 15...). 
    - Therefore, the number of trailing zeroes is limited by the number of factors of $5$. 
    - Hence, our task simplifies to counting the total number of factors of $5$ in the prime factorization of $n$.
  - We can calculate this by summing up the number of times 5, 25, 125, etc., are factors in the numbers from 1 to n.
    - Numbers that are multiples of **5, *contribute one factor of 5*** (5, 10, 15, 20...).
    - Numbers that are multiples of **25, *contribute an additional factor of 5*** (25, 50, 75...).
    - Numbers that are multiples of **125, *contribute yet another factor of 5*** (125, 250...). 
  - This pattern suggests an efficient way to count these factors.

## Ease cases to consider:
  - **Smaller n, *$n < 5$*:** 
    - For $n = 0, 1, 2, 3, 4$ n will not have a factor of 5, so the number of trailing zeroes is always 0.
  - **Large n:** 
    - The value of n can become extremely large and exceed the limits of standard integer data types. 
    - We shouldn't actually calculate n and then count the zeroes. 
    - The problem is designed to be solved without computing the factorial itself.


## This tabe represents the transition of triling zeros .

| n  | Zeros in n! | n  | Zeros in n! | n  | Zeros in n! | n  | Zeros in n! | n  | Zeros in n! |
|----|--------------|----|--------------|----|--------------|----|--------------|----|--------------|
| 1  | 0 | 11  | 2 | 21  | 4 | 31  | 7 | 41  | 9 |
| 2  | 0 | 12  | 2 | 22  | 4 | 32  | 7 | 42  | 9 |
| 3  | 0 | 13  | 2 | 23  | 4 | 33  | 7 | 43  | 9 |
| 4  | 0 | 14  | 2 | 24  | 4 | 34  | 7 | 44  | 9 |
| 5  | 1 | 15  | 3 | 25  | 6 | 35  | 8 | 45  | 10 |
| 6  | 1 | 16  | 3 | 26  | 6 | 36  | 8 | 46  | 10 |
| 7  | 1 | 17  | 3 | 27  | 6 | 37  | 8 | 47  | 10 |
| 8  | 1 | 18  | 3 | 28  | 6 | 38  | 8 | 48  | 10 |
| 9  | 1 | 19  | 3 | 29  | 6 | 39  | 8 | 49  | 10 |
| 10  | 2 | 20  | 4 | 30  | 7 | 40  | 9 | 50  | 12 |


## Solution Approach:

### Brute-Force Approach (and why it fails):
  - A "brute-force" approach would be to calculate factorial of $n$ and then count the trailing zeroes by repeatedly taking the modulo 10 and dividing by 10 until the remainder (right most digit in number) is not $0$.
<br/>
- **Algorithm:**
  - Calculate n.
  - Initialize a counter for zeroes to 0.
  - While n
  - p mod 10 == 0:
    - a. n = n / 10
    - b. Increment the counter.
  - Return the counter.
<br/>
- **Why it fails:** 
  - As mentioned, $n$ for even a moderately large n (like n=20) will overflow a 64-bit integer. 
  - Hence, this approach is not feasible.

<br/>

- **Time Complexity:**
  - The time complexity of computing the factorial is $O(n)$, as we multiply numbers from 1 to n.
  - Counting the trailing zeros is $O(log₁₀(n!))$, as we divide the factorial by 10 repeatedly.

<br/>

- **Space Complexity:**
  - The space complexity is $O(1)$ for counting trailing zeros.

<br/>

- **Limitations:**
  - Integer Overflow:
    - The factorial of even small numbers like 20 is a very large number (2,432,902,008,176,640,000), which cannot be stored in a long variable. This leads to overflow.

  - Inefficiency:
    - For large values of n, computing the factorial is computationally expensive and impractical.

<br/>

- **Note:**
  - Computing the factorial requires storing a very large number, which can lead to integer overflow for large n.
  - Overall, the brute force approach is inefficient for large values of n due to the factorial computation.

<br/>

### Optimal Soluion
  - The optimized approach is based on the insight that the number of trailing zeroes is determined by the number of factors of $5$ in the prime factorization of $n$.

<br/>  

  - **Algorithm:**
    - Initialize a variable $count = 0$.
    - Start with a ***divisor*** $i = 5$.
    - Loop ***while*** $i <= n$.
      - In each iteration, add $n / i$ to count.
        - This integer division effectively counts the multiples of ***i up to n***.
      - Update $i$ to $i * 5$ for the next iteration (e.g., from 5 to 25, then 25 to 125).
        - Or alterntively we can divide th $n$ as $n = n / 5$, both will have same impact. 
      - ***Repeat*** until $i > n$.
    - ***Return*** $count$.

<br/>

  - **Time/Space Complexity:**
    - The time complexity of this algorithm is $O(log₅ n)$, as we are dividing n by powers of 5 in each step.
    - The space complexity is O(1), as we are using a constant amount of extra space.

<br/>

  - This algorithm works because,
    - In the first step of the loop, $n = n/5$ (integer division) counts all numbers that are multiples of 5. 
    - The next step, after dividing ***n by 5***, $n = n/5$, will count numbers that are multiples of 25 (e.g. 25, 50, 75...). 
      - This is a clever way to handle the additional factors of 5. 
    - The process continues until $n < 5$.


<br/>

  - **Java program: *Dividing the input by 5.***
  ```java 
    /**
     * Optimal Logarithmic solution log base 5 (n)
     *
     * @param n
     * @return
     */
    public int logrithmicSolution(int n) {
      int count = 0;
      while(n >= 5) {
        count += n / 5;
          n = n / 5;
      }
      return count;
    }
  ```

  - **Java program: *Increasing the divisor with power of 5.***
  ```java 
    /**
     * Optimal Logarithmic solution log base 5 (n)
     *
     * @param n
     * @return
     */
    public int logrithmicSolution(int n) {
        int count = 0;
        int pof = 5;
        while(n >= pof) {
            count += n / pof;
            pof *= 5;
        }
        return count;
    }
  ```

---
<center>
<h3> ------ End of document------ </h3>
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