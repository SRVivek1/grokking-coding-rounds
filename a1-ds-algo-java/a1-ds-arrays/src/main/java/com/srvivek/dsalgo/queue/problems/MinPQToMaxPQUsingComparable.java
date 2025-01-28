package com.srvivek.dsalgo.queue.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinPQToMaxPQUsingComparable {

    public static void main(String[] args) {

        final int[] data = new int[]{3, 10, 1, 15, 100, 22};

        Queue<Integer> maxPQ = constructMaxPQueue(data);
        print(maxPQ);
    }

    /**
     * Create Max priority queue using provided data.
     *
     * @param data
     * @return
     */
    private static Queue<Integer> constructMaxPQueue(int[] data) {
        /*
         * Comparator returns a negative integer, zero, or a positive integer as the first argument
         * is less than, equal to, or greater than the second.
         */
        final Queue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {

            /**
             * {@inheritDoc}
             *
             * Reverse the return value to get Max Priority Queue.
             *
             * arg1 < arg2 ----> 1 [Default / MinPQ will return 1]
             * arg1 < arg2 ----> 0 [Default / MinPQ will return 0]
             * arg1 < arg2 ----> -1 [Default / MinPQ will return -1]
             *
             * @param arg1 the first object to be compared.
             * @param arg2 the second object to be compared.
             * @return
             */
            @Override
            public int compare(Integer arg1, Integer arg2) {
                if (arg1 > arg2) {
                    return -1;
                } else if (arg1.equals(arg2)) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        StringBuilder sb = new StringBuilder("Input array: [");
        for (int t : data) {
            maxPQ.offer(t);
            sb.append(t).append(", ");
        }
        sb.append("]");
        System.out.println(sb);
        return maxPQ;
    }

    /**
     * Print Queue data using `poll()` API.
     *
     * @param queue
     */
    private static void print(Queue<Integer> queue) {

        queue = new PriorityQueue<>(queue);
        StringBuilder sb = new StringBuilder("MaxPQ : ").append(" {");

        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(", ");
        }
        sb.append("}");
        System.out.println(sb.toString());
    }
}

/**
 * Output
 * ====================
 * Input array: [3, 10, 1, 15, 100, 22, ]
 * MaxPQ :  {100, 22, 15, 10, 3, 1, }
 *
 *
 */