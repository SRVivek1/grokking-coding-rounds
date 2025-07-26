package com.srvivek.dsalgo.queue;

public class ArrayQueue<T> implements Queue<T> {

    private final T[] arr;
    private int front;
    private int rear;

    // Initial capacity is 8
    private static int initialCapacity = 1 << 3;

    public ArrayQueue() {
        this(initialCapacity);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        initialCapacity = capacity;
        arr = (T[]) new Object[initialCapacity];
        front = rear = 0;
    }

    @Override
    public void offer(T elem) {
        if (isFull()) {
            throw new RuntimeException("Queue is full.");
        }
        arr[rear++] = elem;
        rear = adjustIndex(rear, arr.length);
    }

    @Override
    public T poll() {
        if (isEmpty()) throw new RuntimeException("Queue is empty.");

        front = adjustIndex(front, arr.length);
        return arr[front++];
    }

    @Override
    public T peak() {
        if (isEmpty()) throw new RuntimeException("Queue is empty.");
        front = adjustIndex(front, arr.length);
        return arr[front];
    }

    @Override
    public int size() {
        return adjustIndex(rear + arr.length - front, arr.length);
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Return current index if it's less than array length, else return (index - length).
     *
     * @param index index
     * @param length array length
     * @return effective Index
     */
    private int adjustIndex(int index, int length) {
        return index >= length ? index - length : index;
    }

    /**
     * Checks if Queue is full.
     */
    private boolean isFull() {
        return (front + arr.length - rear) % arr.length == 1;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ArrayQueue [");

        for (int i = front; i < rear; i++) {
            sb.append(arr[i]);
            if (i < rear - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
