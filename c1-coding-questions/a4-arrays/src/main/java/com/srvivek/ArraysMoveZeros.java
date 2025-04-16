package com.srvivek;

public class ArraysMoveZeros {

    public void moveZerosToEnd(int[] arr) {

        if (arr == null || arr.length == 0)
            throw new ArrayIndexOutOfBoundsException("Array is null / empty.");

        int l = 0, r = 0;
        while(r < arr.length) {
            if(arr[r] != 0) arr[l++] = arr[r];
            r++;
        }

        // ensure all are 0 post non-zeros
        while(l < arr.length) {
            arr[l++] = 0;
        }
    }
}
