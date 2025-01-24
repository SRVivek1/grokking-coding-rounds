package com.srvivek.dsalgo.queue;

import java.util.LinkedList;

public class LinkedListQueue<T> implements Queue<T> {

    private final LinkedList<T> data;
    private int size;

    public LinkedListQueue() {
        data = new LinkedList<>();
        size = 0;
    }

    public LinkedListQueue(T elem) {
        data = new LinkedList<>();
        offer(elem);
    }


    @Override
    public void offer(T elem) {
        data.addFirst(elem);
        size++;
    }

    @Override
    public T poll() {
        T elem = data.getLast();
        data.removeLast();
        size--;
        return elem;
    }

    @Override
    public T peak() {
        return data.getLast();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
