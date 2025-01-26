package com.srvivek.dsalgo.queue.problems;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinPQToMaxPQUsingComparable {

    public static void main(String[] args) {

        final int[] data = new int[]{3, 10, 1, 15, 100, 22};

        final Queue<Integer> defaultPQ = new PriorityQueue<>();

        /*
         * Comparator returns a negative integer, zero, or a positive integer as the first argument
         * is less than, equal to, or greater than the second.
         */
        final Queue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer arg1, Integer arg2) {
                return arg1 <= arg2 ? 0 : -1;
            }
        });

        for (int i = 0; i < data.length; i++) {
            int t = data[i];
            defaultPQ.offer(t);
            maxPQ.offer(t);
        }

        System.out.println("=============== toString() ========================");
        System.out.println("Default Queue: " + defaultPQ.toString());
        System.out.println("MaxPQ : " + maxPQ.toString());

        System.out.println("=============== poll() ========================");
        print("Default Queue: ", defaultPQ);
        print("MaxPQ : ", maxPQ);
    }

    private static void print(String message, Queue<Integer> queue) {
        StringBuilder sb = new StringBuilder(message).append(" {");

        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(", ");
        }
        sb.append("}");
        System.out.println(sb.toString());
    }
}
