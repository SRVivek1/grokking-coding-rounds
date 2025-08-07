package com.srvivek.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindMaxInRotatedSortedArrayTest {

    private final FindMaxInRotatedSortedArray object = new FindMaxInRotatedSortedArray();

    @Test
    public void nullArrayTest() {
        int[] arr = null;
        //Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> object.findMax(arr));
        Assertions.assertEquals(-1, object.findMax(arr));
        Assertions.assertEquals(-1, object.findMax2(arr));
    }

    @Test
    public void emptyArrayTest() {
        int[] arr = {};
        //Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> object.findMax(arr));
        Assertions.assertEquals(-1, object.findMax(arr));
        Assertions.assertEquals(-1, object.findMax2(arr));
    }

    @Test
    public void singleElementArrayTest() {
        int[] arr = {5};
        int expected = 5;
        int result = object.findMax(arr);
        Assertions.assertEquals(expected, result);

        result = object.findMax2(arr);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void alreadySortedArrayTest() {
        int[] arr = {1, 2, 3, 4, 5};
        int expected = 5;
        int result = object.findMax(arr);
        Assertions.assertEquals(expected, result);

        result = object.findMax2(arr);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void rotatedArrayRotated1TimeTest() {
        int[] arr = {4, 5, 1, 2, 3};
        int expected = 5;
        int result = object.findMax(arr);
        Assertions.assertEquals(expected, result);

        result = object.findMax2(arr);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void rotatedArrayRotated2TimeTest() {
        int[] arr = {4, 5, 1, 2, 3};
        int expected = 5;
        int result = object.findMax(arr);
        Assertions.assertEquals(expected, result);

        result = object.findMax2(arr);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void rotatedArrayRotated3TimesTest() {
        int[] arr = {3, 4, 5, 1, 2};
        int expected = 5;
        int result = object.findMax(arr);
        Assertions.assertEquals(expected, result);

        result = object.findMax2(arr);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void rotatedArrayWithNegativeNumbersTest() {
        int[] arr = {-3, -2, -1, 0, 1, 2, 3, -4};
        int expected = 3;
        int result = object.findMax(arr);
        Assertions.assertEquals(expected, result);

        result = object.findMax2(arr);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void allNegativeNumbersTest() {
        int[] arr = {-5, -4, -3, -2, -1};
        int expected = -1;
        int result = object.findMax(arr);
        Assertions.assertEquals(expected, result);

        result = object.findMax2(arr);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void largeArrayTest() {
        int[] arr = new int[5000];
        for (int i = 0; i < 5000; i++) {
            arr[i] = i - 2500;
        }
        int expected = 2499;
        int result = object.findMax(arr);
        Assertions.assertEquals(expected, result);

        result = object.findMax2(arr);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void largeRotatedArrayTest() {
        int[] arr = new int[5000];
        for (int i = 0; i < 5000; i++) {
            arr[i] = (i + 2500) % 5000 - 2500;
        }
        int expected = 2499;
        int result = object.findMax(arr);
        Assertions.assertEquals(expected, result);

        result = object.findMax2(arr);
        Assertions.assertEquals(expected, result);
    }
}
