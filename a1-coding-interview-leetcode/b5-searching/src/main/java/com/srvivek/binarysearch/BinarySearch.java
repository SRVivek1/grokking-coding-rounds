package com.srvivek.binarysearch;

public class BinarySearch {

    public int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        // check the target in array
        return searchx(arr, 0, arr.length -1, target);
    }

    private int searchx(int[] arr, int start, int end, int target) {
        // exit condition if data not found
        if (start > end) return -1;

        // calculate mid, avoid integer overflow
        int mid = start + ((end -start) / 2);
        int v = arr[mid];

        // if mid-element is the target
        if(v == target) return mid;

        if(target < v) return searchx(arr, start, mid - 1, target);
        else return searchx(arr, mid + 1, end, target);
    }
}