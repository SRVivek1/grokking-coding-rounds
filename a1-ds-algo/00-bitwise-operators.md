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