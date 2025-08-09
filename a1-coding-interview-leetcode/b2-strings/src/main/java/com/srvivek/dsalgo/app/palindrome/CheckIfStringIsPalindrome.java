package com.srvivek.dsalgo.app.palindrome;

public class CheckIfStringIsPalindrome {

  /**
   * Check if given string is palindrome.
   *
   * @param str
   * @return
   */
  public static Boolean palindromeAlgo(String str) {
    boolean res = true;

    for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
      if (str.charAt(i) != str.charAt(j)) {
        res = false;
        break;
      }
    }
    return res;
  }

  /**
   * Convert string to lower case and then check for palindrome.
   *
   * @param str
   * @return
   */
  public static String convertToLowerCase(String str) {
    StringBuilder res = new StringBuilder();

    for (char c : str.toCharArray()) {

      // if upper case convert to lowercase
      if (c >= 'A' && c <= 'Z') {
        res.append((char) (c + ('a' - 'A')));
      } else {
        res.append(c);
      }
    }
    return res.toString();
  }

  public static boolean palindromeAloCaseInsesitive(String str) {
    boolean res = true;

    // lower case the string
    String lstr = convertToLowerCase(str);

    for (int i = 0, j = lstr.length() - 1; i < j; i++, j--) {
      if (lstr.charAt(i) != lstr.charAt(j)) {
        res = false;
        break;
      }
    }
    return res;
  }

  private static final void printResponse(boolean res, String input) {
    if (res) {
      System.out.printf("%s : Palindrome. %n", input);
    } else {
      System.out.printf("%s : Not a palindrome. %n", input);
    }
  }

  public static void main(String[] args) {
    String ip1 = "Apple";
    String ip2 = "abcdcba";

    boolean res = palindromeAlgo(ip1);
    printResponse(res, ip1);

    res = palindromeAlgo(ip2);
    printResponse(res, ip2);

    // Input 3
    String ip = "Mazazam";
    printResponse(palindromeAlgo(ip), ip);

    // Input 3 - ignore case
    printResponse(palindromeAloCaseInsesitive(ip), ip);
  }
}
