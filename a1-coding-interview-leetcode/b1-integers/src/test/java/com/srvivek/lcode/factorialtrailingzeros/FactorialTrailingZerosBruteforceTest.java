package com.srvivek.lcode.factorialtrailingzeros;

import com.srvivek.common.SolutionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTrailingZerosBruteforceTest {

  private final FactorialTrailingZeros solution = new FactorialTrailingZeros();

  // Test cases for the brute-force solution, which will fail for large n due to integer overflow.

  @Test
  void testBruteForceWithZero() {
    assertEquals(0, solution.trailingZeros(0, SolutionType.BRUTEFORCE));
  }

  @Test
  void testBruteForceWithLessThanFive() {
    // n=4, 4! = 24, no trailing zeroes.
    assertEquals(0, solution.trailingZeros(4, SolutionType.BRUTEFORCE));
  }

  @Test
  void testBruteForceWithFive() {
    // n=5, 5! = 120, one trailing zero.
    assertEquals(1, solution.trailingZeros(5, SolutionType.BRUTEFORCE));
  }

  @Test
  void testBruteForceWithTen() {
    // n=10, 10! = 3,628,800, two trailing zeroes.
    assertEquals(2, solution.trailingZeros(10, SolutionType.BRUTEFORCE));
  }

  @Test
  void testBruteForceWithOverflow() {
    // This test case demonstrates the flaw in the brute-force approach.
    // For n=13, 13! overflows an int, resulting in a wrong answer.
    // The test asserts that the faulty code returns 0, which is its expected (though incorrect)
    // behavior.
    assertEquals(0, solution.trailingZeros(13, SolutionType.BRUTEFORCE));
  }

}
