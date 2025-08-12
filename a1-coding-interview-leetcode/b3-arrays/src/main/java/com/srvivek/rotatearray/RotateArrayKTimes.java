package com.srvivek.rotatearray;

public class RotateArrayKTimes {

    /**
     * Rotates an array to the right by k steps.
     * The method handles various edge cases, including null arrays, empty arrays,
     * and rotation values (k) that are zero or larger than the array's length.
     * This implementation uses the three-reversal technique for O(1) space complexity.
     *
     * @param arr The integer array to be rotated.
     * @param k   The number of steps to rotate the array to the right. Can be positive or negative.
     */
    public void rotateArray(int[] arr, int k) {
        // Handle edge cases for null or empty arrays.
        if (arr == null || arr.length == 0) {
            return;
        }

        // Handle cases where rotation is zero or a multiple of the array length,
        // which results in no change.
        if (k == 0 || k % arr.length == 0) {
            return;
        }

        // The modulo operator in Java can return a negative number for negative inputs.
        // This ensures k is a positive value within the range of the array length.
        // int rotation = (k % arr.length + arr.length) % arr.length;
        int rotation = k % arr.length;
        if(k < 0) rotation += arr.length;

        // Step 1: Reverse the entire array.
        // This brings the elements that should be at the end to the front.
        rotate(arr, 0, arr.length - 1);

        // Step 2: Reverse the first 'rotation' elements.
        // This correctly places the elements that have been moved to the front.
        rotate(arr, 0, rotation - 1);

        // Step 3: Reverse the remaining elements from 'rotation' to the end.
        // This correctly places the rest of the array elements.
        rotate(arr, rotation, arr.length - 1);
    }

    /**
     * Reverses a sub-array in-place between the specified left and right indices.
     *
     * @param arr   The array containing the sub-array to be reversed.
     * @param left  The starting index of the sub-array (inclusive).
     * @param right The ending index of the sub-array (inclusive).
     */
    private void rotate(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
