package com.srvivek.binarysearch;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

    public Integer search(Integer[] arr, int target) {

        return searchX(arr, 0, arr.length-1, target);
    }

    private int searchX(Integer[] arr, int l, int r, int target) {

        // elem not found
        if (l > r) return -1;

        //mid
        int mid = l + ((r - l) / 2);

        if(arr[mid] == target) return mid;

        // left half is sorted
        if(arr[l] <= arr[mid]) {
            if(target >= arr[l] && target < arr[mid]) {
                return searchX(arr, l, mid - 1, target);
            } else {
                return searchX(arr, mid + 1, r, target);
            }
        } else if(arr[mid] <= arr[r]) {
            if(target <= arr[r] && target > arr[mid]) {
                return searchX(arr, mid + 1, r, target);
            } else {
                return searchX(arr, l, mid - 1, target);
            }
        }
        return -1;
    }

    public int searchIterative(Integer[] arr, int target) {
        int[] xarr = Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
        return searchIterative(xarr, target);
    }

    public int searchIterative(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;

            // found at middle
            if(arr[mid] == target) return mid;

            // left to mid is sorted
            if(arr[l] <= arr[mid]) {
                if(target >= arr[l] && target < arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { // mid to right is sorted
                if(target > arr[mid] && target <= arr[r]){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        // Element not found
        return -1;
    }
}
