package com.srvivek.lcode.p412fizzbuzz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FizzBuzzCustomDivisorsImpl {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int n = in.nextInt();

    // Rules - using LinkedHashMap to preserve insertion order
    final Map<Integer, String> rules = new LinkedHashMap<>();
    rules.put(4, "Fizz");
    rules.put(6, "Buzz");
    rules.put(9, "Bazz");

    System.out.println("********************** If else **************************");
    String[] res = fizzBuzzCustomDivisors(n, rules);
    printArray(res);

    System.out.println("********************** Using Streams **************************");
    res = fizzBuzzCustomDivisorsStreams(n, rules);
    printArray(res);

    System.out.println(
        "********************** Using Streams parallelism **************************");
    res = fizzBuzzCustomDivisorsStreamsParallel(n, rules);
    printArray(res);
  }

  /**
   * Fizz Buzz Bazz custom divisors
   *
   * @param n input size
   * @param rules divisors
   */
  private static String[] fizzBuzzCustomDivisors(int n, Map<Integer, String> rules) {

    final String[] result = new String[n];

    for (int i = 1; i <= n; i++) {
      StringBuilder sb = new StringBuilder();
      for (Map.Entry<Integer, String> entry : rules.entrySet()) {
        if (i % entry.getKey() == 0) {
          sb.append(entry.getValue());
        }
      }
      // append to result array
      result[i - 1] = sb.isEmpty() ? i + "" : sb.toString();
    }

    return result;
  }

  /**
   * Implement fizz buzz using java 8 streams.
   *
   * @param n
   * @param rules
   * @return
   */
  private static String[] fizzBuzzCustomDivisorsStreams(int n, Map<Integer, String> rules) {
    return IntStream.rangeClosed(1, n)
        .mapToObj(
            i -> {
              String res =
                  rules.entrySet().stream()
                      .filter(entry -> i % entry.getKey() == 0)
                      .map(Map.Entry::getValue)
                      .reduce("", String::concat);
              return res.isEmpty() ? i + "" : res;
            })
        .toArray(String[]::new);
  }

  /**
   * Implement fizz buzz using java 8 streams and parallelism.
   *
   * @param n
   * @param rules
   * @return
   */
  public static String[] fizzBuzzCustomDivisorsStreamsParallel(int n, Map<Integer, String> rules) {
    return IntStream.rangeClosed(1, n)
        .parallel() // Enables parallel execution
        .mapToObj(
            i -> {
              String result =
                  rules.entrySet().stream()
                      .filter(entry -> i % entry.getKey() == 0)
                      .map(Map.Entry::getValue)
                      .reduce("", String::concat);
              return result.isEmpty() ? String.valueOf(i) : result; // FIXED: Use `i` instead of `N`
            })
        .toArray(String[]::new);
  }

  /**
   * Print array.
   *
   * @param res
   */
  private static void printArray(String[] res) {

    System.out.print("[");
    for (String r : res) {
      System.out.print(r + ", ");
    }
    System.out.println("]");
  }
}
