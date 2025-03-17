package com.srvivek;

public class FindMinInRotatedSortedArray {

    public int findMinimum(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if(arr[0] < arr[arr.length - 1]) return arr[0];

        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;

            if(arr[mid] < arr[r]) r = mid;
            else l = mid + 1;
        }
        // At the end, l == r and points to the minimum element
        return arr[l];
    }
}
