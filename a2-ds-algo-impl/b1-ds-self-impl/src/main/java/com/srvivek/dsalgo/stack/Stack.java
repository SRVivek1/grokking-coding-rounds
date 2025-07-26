package com.srvivek.dsalgo.stack;

/**
 * @author srvivek1
 *
 * @param <T>
 */
public interface Stack<T> {

    // Add element on top
    public void push(T elem);

    // Returns the last inserted element.
    public T pop();

    // Returns the last inserted element.
    public T peek();

    // Returns the no. of elements present in the stack.
    public int size();

    public boolean isEmpty();
}
