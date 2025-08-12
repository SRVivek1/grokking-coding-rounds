package com.srvivek.rotatearray;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateArrayKTimesTest {

    private final RotateArrayKTimes rotator = new RotateArrayKTimes();

    @Test
    void testRotateWithPositiveK() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] expected = {5, 6, 7, 1, 2, 3, 4};
        rotator.rotateArray(arr, 3);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testRotateWithKGreaterThanArrayLength() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] expected = {4, 5, 6, 1, 2, 3};
        rotator.rotateArray(arr, 9);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testRotateWithNegativeK() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] expected = {5, 6, 7, 1, 2, 3, 4};
        rotator.rotateArray(arr, -4);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testRotateWithEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        rotator.rotateArray(arr, 2);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testRotateWithNullArray() {
        int[] arr = null;
        rotator.rotateArray(arr, 2);
        // The method should handle null without throwing an exception.
        // We can't assert the array's content, so we just check for no exception.
        // If an exception were thrown, the test would fail.
    }

    @Test
    void testRotateWithSingleElementArray() {
        int[] arr = {1};
        int[] expected = {1};
        rotator.rotateArray(arr, 3);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testRotateWithZeroK() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        rotator.rotateArray(arr, 0);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testRotateWithKEqualToArrayLength() {
        int[] arr = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};
        rotator.rotateArray(arr, 4);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testRotateWithKAsMultipleOfArrayLength() {
        int[] arr = {1, 2, 3};
        int[] expected = {1, 2, 3};
        rotator.rotateArray(arr, 6);
        assertArrayEquals(expected, arr);
    }
}
