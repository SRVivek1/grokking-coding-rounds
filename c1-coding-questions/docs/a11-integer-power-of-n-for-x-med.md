# LeetCode: Calculate the power of x raised to n
## Problem statements:

- [Leetcode-50](https://leetcode.com/problems/powx-n/ ) [*Difficulty: Medium*]
  - Implement $pow(x, n)$, which calculates $x$ raised to the power $n$ (i.e., x^n).

  - **Example 1:**
    - **Input:** x = 2.00000, n = 10  
    - **Output:** 1024.00000  

  - **Example 2:**
    - **Input:** x = 2.10000, n = 3  
    - **Output:** 9.26100  

  - **Example 3:**
    - **Input:** x = 2.00000, n = -2  
    - **Output:** 0.25000  
    - **Explanation:** 
      - *$2^{-2} = \frac{1}{2^2} = \frac{1}{4} = 0.25$  *
 
## Constraints:
  - *-100.0 < x < 100.0*
  - *-231 <= n <= 231-1*
  - *n is an integer.*
  - *Either x is not zero or n > 0.*
  - *-104 <= xn <= 104*

## Solution:
  - **Problem Statement:**
    - We need to implement a function that calculates $(x^n)$ (x raised to the power n). 
  - **Given constraints ensure:**
    - $x$ is a floating-point number in the range − $100.0 < x < 100.0$
    - $n$ is an integer, ranging from $−2^{31} ≤ n ≤ 2^{31}−1$.
    - The computed result should be in the range $−10^4 ≤ x^n ≤ 10^4$.
    - Either $x$ is nonzero, or $n$ is strictly positive (to avoid division by zero).
    - Our goal is to optimize the time complexity.


  - **Edge Cases to Consider:**
    - **Base Cases:**
      - If $x$ is 0 and $n$ is less than or equal to 0, return an error to avoid division by zero.
      - If $n$ is 0, the result should return $1$ since any number raised to the power of 0 is 1.
      - If $n$ is 1, the result should return $x$ since any number raised to the power of 1 is the number itself.
    
    - **Negative Exponents:**
      - If $n$ is -1, the result should return $\frac{1}{x}$ since any number raised to the power of -1 is the reciprocal of the number.
      - Handling large negative values like $n = -2^{31}$ without overflow.

      - If $n$ is 0, the result should return 1 since any number raised to the power of 0 is 1.

    - **Fractional Base:**
      - If $x$ is a small fraction (e.g., 0.1), raising it to a high power leads to values close to 0.

    - **Large Positive/Negative Values of n:**
      - Prevent overflow for very large/small results.
      - Use constraints $−10^4 ≤ x^n ≤ 10^4$ to ensure valid output limits.

    - **Precision Issues:**
      - Using floating-point arithmetic can introduce rounding errors.
      - Consider using higher precision libraries or methods if necessary.

  - **Optimized Approach (Binary Exponentiation - O(log n))**
    - Instead of multiplying $x$ by itself $n$ times (O(n) complexity), we use **Exponentiation by Squaring**, which reduces the complexity to $O(log n)$.

    - **Approach:**
      - If $n$ is negative, compute $\frac{1}{x^{-n}}$ to handle negative exponents. 
      - Use recursion or iterative method to divide the problem:
        - If $n$ is even, compute $x^n = (x^{n/2})^2$.
        - If $n$ is odd, compute $x^n = x \times (x^{(n-1)/2})^2$. 
        - This reduces the number of multiplications significantly.

  - **Time & Space Complexity Analysis:**
    - **Time Complexity:** O(log n) (as we divide n by 2 in each step).
    - **Space Complexity:** O(1) (iterative approach avoids recursion stack).

  - **Java Implementation: Iterative approach**
    ```java
        public double myPow(double x, int n) {
            double res = 1.0;
            long exp = Math.abs((long) n);
            while(exp != 0) {
                if(exp % 2 == 1) {
                    res *= x;
                    exp--;
                }
                x *= x;
                exp >>= 1; //exp / 2;
            }
            return (n < 0) ? 1.0 / res : res;
        }
    ```

  - **Java Implementation: Recursion Approach**
  - **Note:** Recursion uses stack memory, may lead to stack overflow for large values of n.
    ```java
        public double myPowRecursion(double x, int n) {
            if (n == 0)
                return 1.0;
            if (n < 0) {
                return 1.0 / x * myPowRecursion(1.0 / x, -(n + 1));
            }
            return (n % 2 == 0) ? myPowRecursion(x * x, n / 2) : x * myPowRecursion(x * x, n / 2);
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