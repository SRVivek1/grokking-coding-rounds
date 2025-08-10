package com.srvivek.containsduplicate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayContainsDuplicateTest {

    private final ArrayContainsDuplicate instance = new ArrayContainsDuplicate();

    @Test
    void emptyAndNullArrayTest() {
        int[] arr = new int[]{1};
        int[] arr2 = new int[5];

        assertFalse(instance.containsDuplicate(null));
        assertFalse(instance.containsDuplicate(new int[]{1}));
    }

    @Test
    void arrayWithUniqueElementsTest() {
        int[] arr = new int[]{1, 2, 3, 4 ,5};
        int[] arr2 = new int[]{1, 2};

        assertFalse(instance.containsDuplicate(arr));
        assertFalse(instance.containsDuplicate(arr2));
    }

    @Test
    void arrayWithDuplicateTest() {
        int[] arr = new int[] {1, 2, 3, 4 ,1};
        assertTrue(instance.containsDuplicate(arr));
    }
    @Test
    void testContainsDuplicates() {
        // Test case 1: Array with duplicates
        int[] nums = {1, 2, 3, 1};
        assertTrue(instance.containsDuplicate(nums), "Array [1, 2, 3, 1] should contain duplicates.");
    }

    @Test
    void testNoDuplicates() {
        // Test case 2: Array with no duplicates
        int[] nums = {1, 2, 3, 4};
        assertFalse(instance.containsDuplicate(nums), "Array [1, 2, 3, 4] should not contain duplicates.");
    }

    @Test
    void testEmptyArray() {
        // Test case 3: Empty array
        int[] nums = {};
        assertFalse(instance.containsDuplicate(nums), "Empty array should not contain duplicates.");
    }

    @Test
    void testSingleElementArray() {
        // Test case 4: Single element array
        int[] nums = {1};
        assertFalse(instance.containsDuplicate(nums), "Single element array should not contain duplicates.");
    }

    @Test
    void testMultipleDuplicates() {
        // Test case 5: Array with multiple duplicate pairs
        int[] nums = {1, 1, 2, 2, 3, 3};
        assertTrue(instance.containsDuplicate(nums), "Array [1, 1, 2, 2, 3, 3] should contain duplicates.");
    }

    @Test
    void testDuplicatesAtBeginning() {
        // Test case 6: Duplicates at the beginning
        int[] nums = {1, 1, 2, 3, 4};
        assertTrue(instance.containsDuplicate(nums), "Duplicates at the beginning should be found.");
    }

    @Test
    void testDuplicatesAtEnd() {
        // Test case 7: Duplicates at the end
        int[] nums = {1, 2, 3, 4, 4};
        assertTrue(instance.containsDuplicate(nums), "Duplicates at the end should be found.");
    }

    @Test
    void testNegativeNumbers() {
        // Test case 8: Array with negative numbers
        int[] nums = {-1, -2, -3, -1};
        assertTrue(instance.containsDuplicate(nums), "Array with negative duplicates should be found.");
    }

    @Test
    void testMixedNumbers() {
        // Test case 9: Array with mixed positive and negative numbers
        int[] nums = {-5, 0, 5, -5};
        assertTrue(instance.containsDuplicate(nums), "Array with mixed positive/negative duplicates should be found.");
    }

    @Test
    void testNullArray() {
        // Test case 10: Null array
        int[] nums = null;
        assertFalse(instance.containsDuplicate(nums), "Null array should not contain duplicates.");
    }
}
