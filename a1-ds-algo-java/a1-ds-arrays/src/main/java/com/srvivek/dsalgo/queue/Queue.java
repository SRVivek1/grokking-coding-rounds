package com.srvivek.dsalgo.queue;

public interface Queue<T> {

    public void offer(T elem);

    public T poll();

    public T peak();

    public int size();

    public  boolean isEmpty();
}
