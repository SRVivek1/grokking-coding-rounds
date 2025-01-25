package com.srvivek.dsalgo.queue.problems;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Problem:
 * -----------
 * You are given an array of length n.
 * You need to perform the following operation n times:
 * 1. Extract the maximum element from the array.
 * 2. Reduce the extracted element by half (round down to the nearest integer).
 * 3. Insert the reduced element back into the array.
 * 4. After n operations, calculate and return the sum of all the elements in the array.
 * <p>
 * E.g.
 * Input: [1, 2, 3, 1000]
 * Processing:
 * [1, 2, 3, 1000]
 * [1, 2, 3, 500]
 * [1, 2, 3, 250]
 * [1, 2, 3, 125]
 * -------------------------------
 * Output:
 *  = 131
 */
public class FindSumAfterDivision {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 100, 400, 50};

        final Queue<Integer> queue = getPqQueue(arr);

        divideHighestForNTimes(queue, arr.length);

        // Find Sum
        StringBuilder sb = new StringBuilder("[");
        int sum = 0;
        while (!queue.isEmpty()) {
            int t = queue.poll() * -1;
            sum += t;
            sb.append(t).append(", ");
        }
        sb.append("]");

        System.out.println("Updated Data :" + sb.toString());
        System.out.println("Sum = " + sum);
    }

    /**
     * Fetch the highest and divide by 2 and push it to queue for given times.
     *
     * @param queue
     * @param n
     * @return
     */
    private static void divideHighestForNTimes(Queue<Integer> queue, int n) {
        for (int i = 0; i < n; i++) {
            int t = queue.poll() * -1;
            t = t / 2;
            queue.offer(t * -1);
        }
    }

    /**
     * Construct Queue using array data.
     *
     * @param arr
     * @return
     */
    private static Queue<Integer> getPqQueue(int[] arr) {
        final StringBuilder sb = new StringBuilder("[");
        final Queue<Integer> queue = new PriorityQueue<>(arr.length);
        for (int i : arr) {
            sb.append(i).append(", ");
            queue.offer(i * -1);
        }
        sb.append("]");
        System.out.println("Input : " + sb.toString());
        System.out.println("Negated Queue : " + queue.toString());

        return queue;
    }
}
