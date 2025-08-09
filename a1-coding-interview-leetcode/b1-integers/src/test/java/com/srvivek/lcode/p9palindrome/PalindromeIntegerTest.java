package com.srvivek.lcode.p9palindrome;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PalindromeIntegerTest {

  private final PalindromeInteger palindromeInteger = new PalindromeInteger();

  @Test
  void testPositivePalindrome() {
    assertTrue(palindromeInteger.isPalindrome(121));
    assertTrue(palindromeInteger.isPalindrome(12321));
    assertTrue(palindromeInteger.isPalindrome(1));
    assertTrue(palindromeInteger.isPalindrome(0));
  }

  @Test
  void testPositiveNonPalindrome() {
    assertFalse(palindromeInteger.isPalindrome(123));
    assertFalse(palindromeInteger.isPalindrome(10));
    assertFalse(palindromeInteger.isPalindrome(1002));
  }

  @Test
  void testNegativeNumbers() {
    assertFalse(palindromeInteger.isPalindrome(-121));
    assertFalse(palindromeInteger.isPalindrome(-1));
  }

  @Test
  void testNumbersEndingWithZero() {
    assertFalse(palindromeInteger.isPalindrome(10));
    assertTrue(palindromeInteger.isPalindrome(0));
  }
}
