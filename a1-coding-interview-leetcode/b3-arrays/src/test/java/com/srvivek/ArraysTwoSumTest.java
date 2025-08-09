package com.srvivek;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArraysTwoSumTest {

  private final ArraysTwoSum arraysTwoSum = new ArraysTwoSum();

  @Test
  public void nullArrayTest() {
    int[] arr = null;
    Assertions.assertThrows(
        ArrayIndexOutOfBoundsException.class,
        () -> {
          arraysTwoSum.twoSum(arr, 4);
        });
  }

  @Test
  public void emptyArrayTest() {
    int[] arr = new int[0];
    Assertions.assertThrows(
        ArrayIndexOutOfBoundsException.class,
        () -> {
          arraysTwoSum.twoSum(arr, 4);
        });
  }

  @Test
  public void singleElementArrayTest() {
    int[] arr = {5};
    int target = 5;
    int[] result = arraysTwoSum.twoSum(arr, target);
    Assertions.assertArrayEquals(null, result);
  }

  @Test
  public void singleElementArray2Test() {
    long startTime = System.nanoTime();
    int[] arr = {5};
    int target = 5;
    int[] result = arraysTwoSum.twoSum(arr, target);
    long endTime = System.nanoTime();
    System.out.println("singleElementArray2Test execution time: " + (endTime - startTime) + " ns");
    System.out.println(
        "singleElementArray2Test execution time: " + (endTime - startTime) / 1000000 + " ms");
    Assertions.assertArrayEquals(null, result);
  }

  @Test
  public void noSolutionTest() {
    int[] arr = {1, 2, 3};
    int target = 6;
    int[] result = arraysTwoSum.twoSum(arr, target);
    Assertions.assertArrayEquals(null, result);
  }

  @Test
  public void validDataTest() {
    int[] arr = {2, 7, 11, 15};
    int target = 9;
    int[] result = arraysTwoSum.twoSum(arr, target);
    Assertions.assertArrayEquals(new int[] {0, 1}, result);
  }

  @Test
  public void negativeNumbersTest() {
    int[] arr = {-3, 4, 3, 90};
    int target = 0;
    int[] result = arraysTwoSum.twoSum(arr, target);
    Assertions.assertArrayEquals(new int[] {0, 2}, result);
  }

  @Test
  public void largeArrayTest() {
    int[] arr = new int[5000];
    for (int i = 0; i < 5000; i++) {
      arr[i] = i;
    }
    int target = 9997;
    int[] result = arraysTwoSum.twoSum(arr, target);
    Assertions.assertArrayEquals(new int[] {4998, 4999}, result);
  }

  @Test
  public void duplicateNumbersTest() {
    int[] arr = {3, 3};
    int target = 6;
    int[] result = arraysTwoSum.twoSum(arr, target);
    Assertions.assertArrayEquals(new int[] {0, 1}, result);
  }
}
