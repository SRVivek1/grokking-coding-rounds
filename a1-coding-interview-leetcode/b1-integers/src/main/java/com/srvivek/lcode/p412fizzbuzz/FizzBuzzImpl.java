package com.srvivek.lcode.p412fizzbuzz;

import java.util.Scanner;

public class FizzBuzzImpl {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = in.nextInt();

        System.out.println("********************** Using if-else *********************");
        String[] result = fizzBuzzBruteForce(n);

        System.out.print("[");
        for (String s : result) {
            System.out.print(s + ", ");
        }
        System.out.println("]");


        System.out.println("********************** Using String builder *********************");
        result = fizzBuzz_buzz_string_builder(n);

        System.out.print("[");
        for (String s : result) {
            System.out.print(s + ", ");
        }
        System.out.println("]");
    }

    /**
     * Brute force approach
     *
     * @param n
     * @return
     */
    private static String[] fizzBuzzBruteForce(int n) {
        String[] result = new String[n];

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                result[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                result[i - 1] = "Buzz";
            } else {
                result[i - 1] = i + "";
            }
        }
        return result;
    }

    /**
     * Optimized Solution (Avoid Multiple Modulus Operations)
     * Instead of checking i % 3 and i % 5 multiple times, we can store the result in a StringBuilder:
     *
     * TC: O(N)
     * SC: O(N)
     * @param n max
     * @return string[]
     */
    private static String[] fizzBuzz_buzz_string_builder(int n) {
        String[] result = new String[n];

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) sb.append("Fizz");
            if (i % 5 == 0) sb.append("Buzz");

            // result[i - 1] = sb.length() > 0 ? sb.toString() : i + ""; //both works fines
            result[i - 1] = sb.isEmpty() ? i + "" : sb.toString();
        }
        return result;
    }
}
