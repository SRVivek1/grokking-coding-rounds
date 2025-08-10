package com.srvivek.containsduplicate;

import java.util.HashSet;
import java.util.Set;

public class ArrayContainsDuplicate {

    /**
     * Checks if the array contains any duplicate elements.
     *
     * @param arr The input array of integers.
     * @return {@code true} if any value appears at least twice in the array,
     * {@code false} if every element is distinct.
     */
    public boolean containsDuplicate(int[] arr) {
        // Handle edge cases: null array or array with less than 2 elements
        if (arr == null || arr.length < 2) {
            return false;
        }

        // Use a HashSet for efficient O(1) average time complexity lookups.
        // The space complexity is O(n) in the worst-case (no duplicates).
        Set<Integer> seenNumbers = new HashSet<>();

        for (int num : arr) {
            // If the number is already in the set, we've found a duplicate.
            if (seenNumbers.contains(num)) {
                return true;
            }
            // If not, add the number to the set and continue.
            seenNumbers.add(num);
        }

        // If the loop completes without finding any duplicates, return false.
        return false;
    }

}
