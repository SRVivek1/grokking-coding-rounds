package com.srvivek.dsalgo.queue;

public class LinkedListQueueTestApp {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedListQueue<>();
        System.out.println("Queue : " + queue);

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println("Queue : " + queue);

        Integer t = queue.peak();
        System.out.println("Top : " + t);

        t = queue.size();
        System.out.println("Size : " + t);


        t = queue.poll();
        System.out.println("poll() : " + t);
        System.out.println("Size : " + queue.size());
        System.out.println("Size : " + queue);

        System.out.println("isEmpty : " + queue.isEmpty());
    }
}
