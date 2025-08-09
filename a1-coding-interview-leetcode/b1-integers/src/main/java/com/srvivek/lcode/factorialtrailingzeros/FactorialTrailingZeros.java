package com.srvivek.lcode.factorialtrailingzeros;

import com.srvivek.common.SolutionType;

public class FactorialTrailingZeros {

  public int trailingZeros(int n, SolutionType s) {

    return switch (s) {
      case BRUTEFORCE -> bruteForceSolution(n);
      case OPTIMAL -> logrithmicSolution(n);
      default -> 0;
    };
  }

  /**
   * Optimal Logarithmic solution log base 5 (n)
   *
   * @param n
   * @return
   */
  public int logrithmicSolution(int n) {

    int count = 0;
    while(n >= 5) {
      count += n / 5;
      n = n / 5;
    }

    return count;
  }

  /**
   * Brueforce solution
   *
   * @param n
   * @return
   */
  public int bruteForceSolution(int n) {
    int f = calculateFactorial(n);

    int count = 0;

    while (f % 10 == 0) {
      ++count;
      f /= 10;
    }
    System.out.printf("Factorial count: %d. %n", count);
    return count;
  }

  /**
   * Calculate factorial.
   *
   * @param n
   */
  private int calculateFactorial(int n) {
    if (n < 1) {
      return 1;
    }
    return n * calculateFactorial(n - 1);
  }
}
