package com.srvivek;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindMinInRotatedSortedArrayTest {

    private final FindMinInRotatedSortedArray object = new FindMinInRotatedSortedArray();

    @Test
    public void nullTest() {
        int[] ip = null;
        int expected = -1;
        int res = object.findMinimum(ip);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void emptyTest() {
        int[] ip = {};
        int expected = -1;
        int res = object.findMinimum(ip);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void singleElementTest() {
        int[] ip = {5};
        int expected = 5;
        int res = object.findMinimum(ip);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void alreadySortedArrayTest() {
        int[] ip = {1, 2, 3, 4, 5};
        int expected = 1;
        int res = object.findMinimum(ip);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void rotatedArrayTest() {
        int[] ip = {4, 5, 1, 2, 3};
        int expected = 1;
        int res = object.findMinimum(ip);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void rotatedArrayWithNegativeNumbersTest() {
        int[] ip = {2, 3, -4, -3, -2, -1, 0, 1};
        int expected = -4;
        int res = object.findMinimum(ip);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void allNegativeNumbersTest() {
        int[] ip = {-5, -4, -3, -2, -1};
        int expected = -5;
        int res = object.findMinimum(ip);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void allSameNumbersTest() {
        int[] ip = {5, 5, 5, 5, 5};
        int expected = 5;
        int res = object.findMinimum(ip);
        Assertions.assertEquals(expected, res);
    }


    @Test
    public void largeArrayTest() {
        int[] ip = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            ip[i] = i + 1;
        }
        int expected = 1;
        int res = object.findMinimum(ip);
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void largeRotatedArrayTest() {
        int[] ip = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            ip[i] = (i + 500000) % 1000000 + 1;
        }
        int expected = 1;
        int res = object.findMinimum(ip);
        Assertions.assertEquals(expected, res);
    }
}
