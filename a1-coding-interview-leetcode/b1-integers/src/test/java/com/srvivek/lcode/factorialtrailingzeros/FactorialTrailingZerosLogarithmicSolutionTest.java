package com.srvivek.lcode.factorialtrailingzeros;

import com.srvivek.common.SolutionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTrailingZerosLogarithmicSolutionTest {

  private final FactorialTrailingZeros solution = new FactorialTrailingZeros();

    @Test
    void testOptimalWithZero() {
      assertEquals(0, solution.trailingZeros(0, SolutionType.OPTIMAL));
    }

    @Test
    void testOptimalWithLessThanFive() {
      assertEquals(0, solution.trailingZeros(4, SolutionType.OPTIMAL));
    }

    @Test
    void testOptimalWithFive() {
      assertEquals(1, solution.trailingZeros(5, SolutionType.OPTIMAL));
    }

    @Test
    void testOptimalWithTen() {
      assertEquals(2, solution.trailingZeros(10, SolutionType.OPTIMAL));
    }

    @Test
    void testOptimalWithTwentyFive() {
      // n=25, 25! has multiples of 5 (5,10,15,20,25) and one extra 5 from 25 itself.
      // 5 + 1 = 6 trailing zeroes.
      assertEquals(6, solution.trailingZeros(25, SolutionType.OPTIMAL));
    }

    @Test
    void testOptimalWithOneHundred() {
      // n=100. (100/5) + (100/25) = 20 + 4 = 24.
      assertEquals(24, solution.trailingZeros(100, SolutionType.OPTIMAL));
    }

    @Test
    void testOptimalWithMaxConstraint() {
      // n=10^4.
      // (10000/5) + (10000/25) + (10000/125) + (10000/625) + (10000/3125) = 2000 + 400 + 80 + 16 + 3
      // = 2499.
      assertEquals(2499, solution.trailingZeros(10000, SolutionType.OPTIMAL));
    }
}
