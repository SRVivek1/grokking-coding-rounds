package com.srvivek.dsalgo.queue.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * To create a MaxPQ using default implementation of MinPQ, simply negate the data/value by multiplying it with '-1'.
 * Do the same while polling from queue to get the actual value.
 */
public class MinPQToMaxPQByNegatingValues {

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

        final Queue<Integer> maxPQ = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder("Input array: [");
        for (int t : data) {
            /*
             * Negate the value while adding to the queue.
             * While polling back, negate them back before processing
             */
            maxPQ.offer(t * -1);
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
            /*
             * Negating the value to transform it to the actual value.
             */
            sb.append(queue.poll() * -1).append(", ");
        }
        sb.append("}");
        System.out.println(sb.toString());
    }
}

/**
 * Output
 * ======================
 * Input array: [3, 10, 1, 15, 100, 22, ]
 * MaxPQ :  {100, 22, 15, 10, 3, 1, }
 * 
 */