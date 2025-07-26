package com.srvivek.dsalgo.stack;

import com.srvivek.dsalgo.linkedlist.DoublyLinkedList;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Stack DS using LinkedList follows LIFO ordering.
 *
 * @param <T>
 */
public class LinkedListStack<T> implements Iterable<T>, Stack<T> {

    //private final DoublyLinkedList<T> list = new DoublyLinkedList<>();
    private final LinkedList<T> list = new LinkedList<>();

    /**
     * Empty stack.
     */
    public LinkedListStack() {
    }

    public LinkedListStack(T elem) {
        push(elem);
    }

    @Override
    public void push(T elem) {
        list.addFirst(elem);
    }

    /**
     * Returns the top element from the stack.
     * Throws EmptyStackException if stack is empty.
     *
     * @return
     */
    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return list.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return list.peek();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return "LinkedListStack" + list.toString();
    }
}
