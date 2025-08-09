package com.srvivek.dsalgo.app.palindrome;

/**
 * Remove all special characters from given string other than the [A-Za-z].
 *
 * <p>Reference: --> https://www.geeksforgeeks.org/remove-characters-alphabets-string/
 */
public class StringRemoveSpecialCharacters {

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

  public static void main(String[] args) {

    String s = "$Gee*k;s..fo, r'Ge^eks?";
    String res = removeSpecialCharacters(s);
    System.out.printf("Input: %s %nOutput: %s", s, res);
  }
}
