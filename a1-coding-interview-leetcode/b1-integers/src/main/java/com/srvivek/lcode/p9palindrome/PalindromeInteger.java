package com.srvivek.lcode.p9palindrome;

import java.util.Scanner;

public class PalindromeInteger {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int num = sc.nextInt();

    PalindromeInteger sol = new PalindromeInteger();
    boolean res = sol.isPalindrome(num);

    if (res) {
      System.out.printf("%d is a palindrome number.%n", num);
    } else {
      System.out.printf("%d is not a palindrome number.%n", num);
    }
  }

  public boolean isPalindrome(int x) {
    // ease cases
    if (x < 0 || (x != 0 && x % 10 == 0)) return false;

    // reverse half
    int rev = 0;
    while (x > rev) {
      int t = x % 10;
      rev = (rev * 10) + t;
      x /= 10;
    }

    // check if palindrome
    return x == rev || x == rev / 10;
  }
}
