package com.srvivek.dsalgo.queue;

public class ArrayQueueTestApp {

    public static void main(String[] args) {
        final Queue<Integer> queue = new ArrayQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);

        System.out.println(queue);
        System.out.println(queue.size());

        queue.peak();
        System.out.println(queue);
        System.out.println(queue.size());

        queue.poll();
        System.out.println(queue);
        System.out.println(queue.size());
    }
}
