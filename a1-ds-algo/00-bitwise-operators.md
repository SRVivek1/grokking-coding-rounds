# Bitwise Operators
## 1. Introduction

- **<heading>Bitwise Operators</heading>**
  - Bitwise operators in Java are used to perform operations at the binary level. These operators work on individual bits of integer types (byte, short, int, long) and are useful for low-level programming, bit manipulation, and performance optimizations.
  - Operations performed using *Bitwise Operators* are comaratively fast as they perform directly on binary number bits.


- **Operators:**

| Operator |         Name         | Description |
| -------- | -------------------- | ------------------------------------- |
| &	       | Bitwise AND	      | Sets each bit to **1** if both corresponding bits are **1**. | 
| \|       | Bitwise OR           | Set each bit to **0** only if both corresponding bits are **0**. | 
| ^	       | Bitwise XOR	      | Sets each bit to **1** if only one of the corresponding bits is **1**. | 
| ~	       | Bitwise Complement	  | Inverts all bits (1's complement). Accepts one operand. | 
| <<	   | Left Shift	          | Shifts bits to the left, filling with **0s** on the right. <br/>  Multiplying by $2$ | 
| >>	   | Right Shift	      | Shifts bits to the right, preserving sign (MSB remains the same for negative numbers). <br/>  Dividing by $2$ | 
| >>>	   | Unsigned Right Shift | Shifts bits to the right, filling the left with **0s** (ignores sign bit). | 


- **Truth Table:**

|  A  |  B  | AND | OR | XOR | Complement (~A) |
| --- | --- | --- | -- | --- | --------------- |
|  0  |  0  |  0  | 0  |  0  |        1        |
|  0  |  1  |  0  | 1  |  1  |        1        |
|  1  |  0  |  0  | 1  |  1  |        0        |
|  1  |  1  |  1  | 1  |  0  |        0        |


- **Shift operators**
  - In below example operators are shifting the bit by **1**.

| Data  |       Binary        | Shift |    Left Shift    |    Right Shift    | Unsigned Right Shift |
| ----- | ------------------- | ----- | ---------------- | ----------------- | -------------------- |
| 32    | 100000  *($2^5$)*   | 1 bit | 1000000 $2^6$    | 10000 $2^4$       |                      |
| 32    | 100000  *($2^5$)*   | 2 bit | 10000000 $2^7$   | 1000 $2^3$        |                      |
| 8     | 1000  *($2^3$)*     | 1 bit | 10000 $2^4$      | 100 $2^2$         |                      |
| 8     | 1000  *($2^3$)*     | 2 bit | 100000 $2^5$     | 10 $2^1$          |                      |
| 14    | 1110                | 1 bit | 11100            | 0111              |                      |
| 14    | 1110                | 2 bit | 111000           | 0011              |                      |


- **Bitwise XOR:**
  - The bitwise XOR (exclusive OR) operator compares corresponding bits of two numbers and returns 1 if the bits are different and 0 if they are the same.
    - that is if we use XOR of two variables having same value it willreturn *0*.
  - Properties of XOR:
    - Self XOR (x ^ x = 0)
      - XOR-ing a number with itself always results in 0.
      - *System.out.println(7 ^ 7); // Output: 0*
    - XOR with Zero (x ^ 0 = x)
      - XOR-ing a number with 0 keeps it unchanged.
      - *System.out.println(9 ^ 0); // Output: 9*
    - XOR is Commutative (a ^ b = b ^ a)
      - *System.out.println((4 ^ 6) == (6 ^ 4)); // Output: true*
    - XOR is Associative (a ^ (b ^ c) = (a ^ b) ^ c)
      - *System.out.println((2 ^ (3 ^ 4)) == ((2 ^ 3) ^ 4)); // Output: true*
  
  - **Use cases: XOR**
    - ***Bitwise `XOR`:** Swap values in two variables:*
      - We can swap values between two numbers without use of temporary variables.
      - Java function to swap values using XOR operator.
      ```java
            public static void main(String[] args) {

                Integer a = 10;
                Integer b = 20;
                System.out.printf("a = %d, b= %d.%n", a, b);

                // Swap with Mathematical operator
                a = b + a;
                b = a - b;
                a = a - b;
                System.out.println("Mathematical operator:");
                System.out.printf("a = %d, b= %d.%n", a, b);

                /*
                * swap using bitwise XOR operator
                * -------------------------------------
                * a = 20 [10100], b = 10 [1010]
                * a = a ^ b ==> 10100 ^ 01010 ==> 11110 [30]
                * b = a ^ b ==> 11110 ^ 01010 ==> 10100 [20]
                * a = a ^ b ==> 11110 ^ 10100 ==> 01010 [10]
                */
                a = a ^ b;
                b = a ^ b;
                a = a ^ b;
                System.out.println("Bitwise XOR operator:");
                System.out.printf("a = %d, b= %d.%n", a, b);
            }
      ``` 
    - ***Bitwise `XOR`:** Finding the Unique Number in an Array (Single Number Problem)*
      - If every element appears twice except one, XOR-ing all elements gives the unique number.
      ```java
          /**
            * Find Unique number in an array using Bitwise XOR operator.
            * TC: O(n)
            * SC: O(1)
            *
            * @param nums
            * @return
            */
            public static int findSingleNumberBitwiseXor(int[] nums) {
                int res = 0;
                for (int i = 0; i < nums.length; i++) {
                    res = res ^ nums[i];
                }
                return res;
            }
      ```

    - ***Bitwise XOR:** Finding Two Unique Numbers in an Array*
      - If every number appears twice except two, XORing all elements gives a ^ b.
      - Find the rightmost set bit (LSB) in a ^ b and partition numbers into two groups based on it.
      ```java
          int[] findTwoUnique(int[] nums) {
              int xor = 0;
              for (int num : nums) xor ^= num;

              int diffBit = xor & (-xor); // Rightmost set bit
              int a = 0, b = 0;

              for (int num : nums) {
                  if ((num & diffBit) == 0) a ^= num;
                  else b ^= num;
              }
              return new int[]{a, b};
          }
      ```

    - ***Bitwise XOR:** Toggling a Bit at a Specific Position*
      - Formula: To toggle the bit at position pos in number n:
        - `n = n ^ (1 << pos);`
          - *1 << pos* creates a mask with a 1 at position *pos*.
          - XORing with 1 flips the bit:
            - 1 ^ 1 = 0 (turns off if it was on)
            - 0 ^ 1 = 1 (turns on if it was off)
      ```java
          public class ToggleBit {
            public static int toggleBit(int n, int pos) {
                return n ^ (1 << pos);
            }

            public static void main(String[] args) {
                int num = 10; // Binary: 1010
                int pos = 1;
                int toggled = toggleBit(num, pos);
                System.out.println("Before: " + Integer.toBinaryString(num)); // 1010
                System.out.println("After : " + Integer.toBinaryString(toggled)); // 1000
            }
        }
      ```

    - ***Bitwise XOR:** Power of Two Check Using XOR (Alternative to Bitwise AND Trick)*
      - Another way to check power of two without using % or loops.
      ```java
          boolean isPowerOfTwo(int n) {
              return n > 0 && (n ^ (n - 1)) == (2 * n - 1);
          }
      ```

    - ***Bitwise XOR:** Checking if Two Numbers Are Equal*
      - Useful in low-level optimizations.
      ```java
          boolean isEqual = (a ^ b) == 0;
      ```

    - ***Bitwise XOR:** Finding the Missing Number (XOR-based approach)*
      - Given an array of n numbers containing [0, n] with one missing.
      ```java
          int missingNumber(int[] nums) {
              int n = nums.length;
              int xorAll = 0, xorNums = 0;

              for (int i = 0; i <= n; i++) xorAll ^= i;
              for (int num : nums) xorNums ^= num;

              return xorAll ^ xorNums;
          }
      ```

    - ***Bitwise XOR:** Encryption and Decryption (XOR Cipher)*
      - XOR is used in simple encryption algorithms where applying XOR twice restores original data.
      - Used in lightweight security mechanisms.
      ```java
          char encrypt(char ch, char key) {
              return (char) (ch ^ key);  // Encryption
          }
          char decrypt(char ch, char key) {
              return (char) (ch ^ key); // Reverses encryption
          }

      ```



- **Use Cases:**
  - ***Right Shift Operator:** Divide by 2:*
    - Where ever we want to divide a given number by $2$, instead of `\` operator use Right Shift operator `>>`.
    - Very efficient when used in iterative statements.

  - ***Left Shift Operator:** Multiply by 2:*
    - Where ever we want to multiply a given number by $2$, instead of `*` operator use Left Shift operator `<<`.
    - Very efficient when used in iterative statements.

  - ***Bitwise `AND`:** Check Even/Odd numbers:*
    - An even number is completely divided by $2$.
    - Binary representation of some of the Even and Odd numbers are given below.
    - **Observation:** Every even number ends with *0* while every odd number ends with *1*.
    - **Approach:** So as we know that if we perform ***&*** / ***AND*** operation with any even number and ***1***, then remainder will always be ***0***, because every even number's last bit is ***0***.
      - Hence, ***0  &  1 ==> 0***.
    - ***Java function** to check if a number is even or odd.*
        ```java
                /**
                 * @param num input number
                 * @return true for even number
                 */
                public static boolean isEven(int num) {
                    return (num & 1) == 0;
                }
        ```


| Type    | Val | Val | Val | Val  | Val  | Val  | Val  | Val   | Val   | Val   | Val   | Val   |
| ------- | --- | --- | --- | ---  | ---  | ---  | ---  | ---   | ---   | ---   | ---   | ---   |
| Decimal | 02  | 04  | 06  | 08   | 10   | 12   | 14   | 16    | 18    | 20    | 22    | 24    |
| Binary  | 10  | 100 | 110 | 1000 | 1010 | 1100 | 1110 | 10000 | 10010 | 10100 | 10110 | 11000 |  


| Type    | Val | Val | Val | Val  | Val  | Val  | Val  | Val  | Val   | Val   | Val   | Val   | Val   |
| ------- | --- | --- | --- | ---  | ---  | ---  | ---  | ---  | ---   | ---   | ---   | ---   | ---   |
| Decimal | 01  | 03  | 05  | 07   | 09   | 11   | 13   | 15   | 17    | 19    | 21    | 23    | 25    |
| Binary  | 01  | 011 | 101 | 111  | 1001 | 1011 | 1101 | 1111 | 10001 | 10011 | 10101 | 10111 | 11001 |




- **Bit Masking**
  - TODO 


- **<ins>References:</ins>**
  - [https://www.youtube.com/watch?v=Db8OmMfzwl8](https://www.youtube.com/watch?v=Db8OmMfzwl8)
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