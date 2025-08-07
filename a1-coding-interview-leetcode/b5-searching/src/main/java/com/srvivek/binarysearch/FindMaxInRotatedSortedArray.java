package com.srvivek.binarysearch;

public class FindMaxInRotatedSortedArray {

    public int findMax(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1) return arr[0];
        if (arr[0] < arr[arr.length - 1]) return arr[arr.length - 1];

        int l = 0, r = arr.length - 1;

        /*
         * Modified binary search to find the maximum element in the rotated
         * sorted array.
         */
        while (l < r) {
            int m = l + (r - l) / 2;

            if (arr[m] > arr[r]) l = m + 1;
            else r = m;
        }

        return arr[l - 1];
    }


    public int findMax2(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1 || arr[0] <= arr[arr.length - 1]) return arr[arr.length - 1];

        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            // check the highest element near to mid
            if (mid < r && arr[mid] > arr[mid + 1]) return arr[mid];
            if (mid > l && arr[mid] < arr[mid - 1]) return arr[mid - 1];

            if (arr[mid] < arr[l]) r = mid - 1;
            else l = mid + 1;
        }
        return arr[l];
    }
}
