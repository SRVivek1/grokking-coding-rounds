package com.srvivek;

public class FindMinInRotatedSortedArray {

    public int findMinimum(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if(arr[0] < arr[arr.length - 1]) return arr[0];

        int l = 0, r = arr.length - 1;

        /*
         * Note: Having check for "l <= r" would cause ArrayIndexOutOfBoundsException in case
         * the array is having all duplicates.
         *
         * For example, if the input array is {5, 5, 5, 5, 5, 5}.
         */
        while (l < r) {
            int mid = l + (r - l) / 2;

            if(arr[mid] < arr[r]) r = mid;
            else l = mid + 1;
        }
        // At this point, l == r and arr[l] points to the minimum element
        return arr[l];
    }
}
