package com.srvivek.dsalgo.app.reversal;

/**
 * Problem: Given a string, reverse the order of words in the string without reversing the
 * characters of the individual words. Example: Input : "Hello World from Java"; Output: "Java from
 * World Hello"
 *
 * <p>Approach: ----------- 1. Split the string into words. 2. Reverse the array of words. 3. Join
 * the words back into a string.
 */
public class ReverseStringButNotTheCharsInWords {

  /**
   * Reverse the string without reversing the characters of individual words. Approach: -----------
   * 1. Split the string into words. 2. Reverse the array of words. 3. Join the words back into a
   * string.
   *
   * @param str
   * @return
   */
  public static String reverse(String str) {

    // Empty string check
    if (str == null || str.isEmpty()) {
      return "";
    }

    final StringBuilder res = new StringBuilder();

    // Split string with spaces
    final String[] arr = str.split("\\s+");

    // iterate from last index to first and add in StringBuilder
    for (int i = arr.length - 1; i >= 0; i--) {
      res.append(arr[i]);
      if (i != 0) {
        res.append(" ");
      }
    }
    return res.toString();
  }

  public static void main(String[] args) {
    String input = "Hello world from Java";
    String res = reverse(input);
    System.out.println("Input: " + input);
    System.out.println("Output: " + res);
  }
}
