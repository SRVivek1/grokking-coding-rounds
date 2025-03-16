package com.srvivek;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    private final BinarySearch bs = new BinarySearch();

    @Test
    public void nullTest(){
        int res = bs.search(null, 2);
        Assertions.assertEquals(-1, res);
    }

    @Test
    public void zeroLengthArrayTest(){
        int[] arr = new int[0];
        int res = bs.search(arr, 2);
        Assertions.assertEquals(-1, res);
    }

    @Test
    public void singleElementArrayTest(){
        int[] arr = {5};
        int res = bs.search(arr, 5);
        Assertions.assertEquals(0, res);
    }

    @Test
    public void searchElementInMiddlePositionArrayTest(){
        int[] arr = {2, 3, 5, 7, 8, 21, 100, 1354, 40823, 714289};
        int res = bs.search(arr, 21);
        Assertions.assertEquals(5, res);
    }

    @Test
    public void searchElementInStartPositionArrayTest(){
        int[] arr = {2, 3, 5, 7, 8, 21, 100, 1354, 40823, 714289};
        int res = bs.search(arr, 2);
        Assertions.assertEquals(0, res);
    }

    @Test
    public void searchElementInEndPositionArrayTest(){
        int[] arr = {2, 3, 5, 7, 8, 21, 100, 1354, 40823, 714289};
        int res = bs.search(arr, 714289);
        Assertions.assertEquals(9, res);
    }

    @Test
    public void searchMissingElementInMiddlePositionArrayTest(){
        int[] arr = {2, 3, 5, 7, 8, 21, 100, 1354, 40823, 714289};
        int res = bs.search(arr, 23);
        Assertions.assertEquals(-1, res);
    }

    @Test
    public void searchMissingElementInStartPositionArrayTest(){
        int[] arr = {2, 3, 5, 7, 8, 21, 100, 1354, 40823, 714289};
        int res = bs.search(arr, 1);
        Assertions.assertEquals(-1, res);
    }

    @Test
    public void searchMissingElementInEndPositionArrayTest(){
        int[] arr = {2, 3, 5, 7, 8, 21, 100, 1354, 40823, 714289};
        int res = bs.search(arr, 814289);
        Assertions.assertEquals(-1, res);
    }
}
