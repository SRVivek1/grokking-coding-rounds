package com.srvivek.dsalgo.queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Test and demonstrate the functionalities of {@link java.util.PriorityQueue PriorityQueue}
 */
public class JavaPriorityQueueTestApp {

    public static void main(String[] args) {
        final Queue<Integer> pQueue = new PriorityQueue<>();

        pQueue.offer(33);
        pQueue.offer(102);
        pQueue.offer(21);
        printQueue(pQueue);


        pQueue.offer(1000);
        printQueue(pQueue);

        pQueue.offer(5);
        printQueue(pQueue);

        pQueue.offer(1);
        printQueue(pQueue);

        pQueue.offer(-1);
        printQueue(pQueue);

        pQueue.offer(-7);
        printQueue(pQueue);

        pQueue.offer(-3);
        printQueue(pQueue);
    }

    public static void printQueue(Queue<Integer> queue) {

        //copy of queue
        queue = new PriorityQueue<>(queue);
        StringBuilder sb = new StringBuilder("Queue {");
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(", ");
        }
        sb.append("}");
        System.out.println(sb.toString());
    }
}
/**
 * Output:
 * ===========================
 * Queue {21, 33, 102, }
 * Queue {21, 33, 102, 1000, }
 * Queue {5, 21, 33, 102, 1000, }
 * Queue {1, 5, 21, 33, 102, 1000, }
 * Queue {-1, 1, 5, 21, 33, 102, 1000, }
 * Queue {-7, -1, 1, 5, 21, 33, 102, 1000, }
 * Queue {-7, -3, -1, 1, 5, 21, 33, 102, 1000, }
 *
 */