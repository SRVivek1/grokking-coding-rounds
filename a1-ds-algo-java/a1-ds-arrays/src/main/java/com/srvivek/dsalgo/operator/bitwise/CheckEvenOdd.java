package com.srvivek.dsalgo.operator.bitwise;

/**
 * Bitwise `&` AND operator.
 */
public class CheckEvenOdd {

    public static void main(String[] args) {

        int x = 10;
        System.out.printf("%d is even : %b.%n", x, isEven(x));

        int[] inputs = new int[25];
        for (int i = 1; i <= inputs.length; i++) inputs[i-1] = i;

        checkEven(inputs);
    }

    /**
     * @param num input number
     * @return true for even number
     */
    public static boolean isEven(int num) {
        return (num & 1) == 0;
    }

    /**
     * check numbers if they are odd / even.
     *
     * @param nums int array
     */
    public static void checkEven(int[] nums) {

        for (int i : nums) {
            System.out.printf("%d is even : %b.%n", i, isEven(i));
        }
    }
}
