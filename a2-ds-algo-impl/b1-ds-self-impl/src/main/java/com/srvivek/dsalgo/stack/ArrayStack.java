package com.srvivek.dsalgo.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {

    private T[] data;

    // Initial capacity 16
    private static int initialCapacity = 1 << 3;

    // Points to the most recent object pushed.
    private int top = -1;

    public ArrayStack() {
        this(initialCapacity);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        initialCapacity = capacity;
        data = (T[]) new Object[initialCapacity];
    }

    @Override
    public void push(T elem) {
        if (size() + 1 >= initialCapacity) {
            increaseCapacity();
        }
        ++top;
        data[top] = elem;
    }

    /**
     * Increase capacity of existing array
     */
    private void increaseCapacity() {
        // Double the capacity
        initialCapacity = initialCapacity << 1;
        data = Arrays.copyOf(data, initialCapacity);
        System.out.println("Capacity increased to : " + initialCapacity);
    }

    /**
     * Removes the element from TOP and return the ame.
     *
     * @return
     */
    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T elem = (T) data[top];
        data[top] = null;
        --top;
        return elem;
    }

    /**
     * Read the TOP element in stack.
     *
     * @return
     */
    @Override
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return (T) data[top];
    }

    /**
     * Returns '-1' if empty.
     *
     * @return
     */
    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ArrayStack [");

        if (size() > -1) {
            for (int i = data.length - 1; i >= 0; i--) {
                sb.append(data[i]);
                if (i != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
