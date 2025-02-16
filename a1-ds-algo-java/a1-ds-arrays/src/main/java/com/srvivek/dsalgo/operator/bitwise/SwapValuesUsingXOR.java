package com.srvivek.dsalgo.operator.bitwise;

/**
 * Swap values of two variables using `XOR` operator app.
 */
public class SwapValuesUsingXOR {

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
}
