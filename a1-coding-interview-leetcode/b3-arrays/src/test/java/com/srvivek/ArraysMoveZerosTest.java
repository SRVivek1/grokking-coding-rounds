package com.srvivek;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArraysMoveZerosTest {

    private final ArraysMoveZeros arraysMoveZeros = new ArraysMoveZeros();

    @Test
    public void nullArrayTest() {
        int[] arr = null;
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> arraysMoveZeros.moveZerosToEnd(arr));
    }

    @Test
    public void emptyArrayTest() {
        int[] arr = {};
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> arraysMoveZeros.moveZerosToEnd(arr));
    }

    @Test
    public void noZerosTest() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        arraysMoveZeros.moveZerosToEnd(arr);
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    public void allZerosTest() {
        int[] arr = {0, 0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0, 0};
        arraysMoveZeros.moveZerosToEnd(arr);
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    public void mixedZerosTest() {
        int[] arr = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
        arraysMoveZeros.moveZerosToEnd(arr);
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    public void zerosAtEndTest() {
        int[] arr = {1, 2, 3, 0, 0};
        int[] expected = {1, 2, 3, 0, 0};
        arraysMoveZeros.moveZerosToEnd(arr);
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    public void zerosAtStartTest() {
        int[] arr = {0, 0, 1, 2, 3};
        int[] expected = {1, 2, 3, 0, 0};
        arraysMoveZeros.moveZerosToEnd(arr);
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    public void largeArrayTest() {
        int[] arr = new int[5000];
        for (int i = 0; i < 2500; i++) {
            arr[i] = i + 1;
        }
        for (int i = 2500; i < 5000; i++) {
            arr[i] = 0;
        }
        int[] expected = new int[5000];
        for (int i = 0; i < 2500; i++) {
            expected[i] = i + 1;
        }
        arraysMoveZeros.moveZerosToEnd(arr);
        Assertions.assertArrayEquals(expected, arr);
    }
}