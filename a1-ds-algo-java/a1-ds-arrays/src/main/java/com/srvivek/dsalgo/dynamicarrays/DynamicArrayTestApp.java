package com.srvivek.dsalgo.dynamicarrays;

public class DynamicArrayTestApp {

    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        arr.add(50);
        arr.add(60);

        System.out.println("Array size : " + arr.size());
        System.out.println("Data : " + arr);


        // remove data from index 2
        arr.removeAt(2);
        System.out.println("Array size : " + arr.size());
        System.out.println("Data : " + arr);

        System.out.println("arr.indexOf(10) : " + arr.indexOf(10));
        System.out.println("arr.indexOf(20) : " + arr.indexOf(20));
        System.out.println("arr.indexOf(30) : " + arr.indexOf(30));
    }
}
