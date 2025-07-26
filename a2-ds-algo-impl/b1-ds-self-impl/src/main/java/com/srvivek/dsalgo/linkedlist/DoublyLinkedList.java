package com.srvivek.dsalgo.linkedlist;

import java.util.Iterator;

/**
 * A custom implementation for doubly linked list.
 * <p>
 * TODO:
 *  --> Add support for concurrent modification check.
 *  --> Implement ListIterator
 *
 * @param <T>
 */
public class DoublyLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    // Node class to hold data
    private static class Node<T> {
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    /**
     * Empty this linked list
     * T.C.: O(N)
     */
    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Add elements in the beginning of the linked list
     * T.C. -> O(1)
     *
     * @param elem
     */
    public void addFirst(T elem) {
        if (isEmpty()) {
            head = tail = new Node<>(elem, null, null);
        } else {
            head.prev = new Node<>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    /**
     * Add element to the tail of the linked list.
     * T.C. -> O(1)
     *
     * @param elem
     */
    public void addLast(T elem) {
        if (isEmpty()) {
            head = tail = new Node<>(elem, null, null);
        } else {
            tail.next = new Node<>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Add elements to the tail of the linked list.
     *
     * @param elem
     */
    public void add(T elem) {
        this.addLast(elem);
    }

    /**
     * Add Element on given index.
     *
     * @param index
     * @param elem
     */
    public void addAt(int index, T elem) {
        if (index < 0 || index > size) throw new RuntimeException("Invalid index - " + index);

        if (index == 0) {
            addFirst(elem);
            return;
        }
        if (index == size) {
            addLast(elem);
            return;
        }

        Node<T> trav = head;
        for (int i = 0; i < index; i++) {
            trav = trav.next;
        }
        Node<T> newNode = new Node<>(elem, trav.prev, trav);
        trav.prev.next = newNode;
        trav.prev = newNode;

        size++;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("List is empty.");
        return tail.data;
    }


    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("List is empty.");

        T data = head.data;
        head = head.next;
        --size;

        // if list has become empty (when there was only one element)
        if (isEmpty()) tail = null;

        // Memory clean-up for previous node
        head.prev = null;

        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("List is empty,");

        T data = tail.data;
        tail = tail.prev;
        --size;

        // If list has become empty now.
        if (isEmpty()) head = null;

        // if more elements are there
        // Memory clean-up for next node
        tail.next = null;

        return data;
    }

    /**
     * Find and remove an arbitary node from list.
     *
     * @param node
     * @return
     */
    private T remove(Node<T> node) {

        // Check if the node is first or last node
        if (node.prev == null) return this.removeFirst();
        if (node.next == null) return this.removeLast();

        // Remove current node from the linked list chain
        node.next.prev = node.prev;
        node.prev.next = node.next;

        // Node data to be returned
        T data = node.data;

        //memory cleanup
        node.data = null;
        node = node.next = node.prev = null;
        --size;
        return data;
    }

    /**
     * Remove data from provided index.
     *
     * @param index
     * @return
     */
    public T removeAt(int index) {
        if (isEmpty()) throw new RuntimeException("List is empty");
        if (index < 0 || index >= size()) throw new IllegalArgumentException("Invalid index. List size : " + size());

        int i;
        Node<T> trav;
        if (index <= size() / 2) {
            // Search from starting of the list.
            for (i = 0, trav = head; i != index; i++) trav = trav.next;
        } else {
            // Search from back of the list
            for (i = size() - 1, trav = tail; i != index; i--) trav = trav.prev;
        }

        return this.remove(trav);
    }

    /**
     * Removes the first node holding particular value from linked list.
     * T.C. -> O(n)
     *
     * @param data
     * @return
     */
    public boolean remove(T data) {
        if (isEmpty()) throw new RuntimeException("List is empty.");

        Node<T> trav = head;

        // if provided data is null
        if (data == null) {
            while (trav != null) {
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
                trav = trav.next;
            }
        } else {
            // if data is not null
            while (trav != null) {
                if (data.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
                trav = trav.next;
            }
        }
        return false;
    }

    /**
     * Return index of first occurrence of the data in the linked list.
     *
     * @param data
     * @return
     */
    public int indexOf(T data) {
        int index = 0;
        Node<T> trav;

        // if provided data is null
        if (data == null) {
            for (trav = head; trav != null; trav = trav.next, index++) {
                if (trav.data == null) return index;
            }
        } else {
            for (trav = head; trav != null; trav = trav.next, index++) {
                if (data.equals(trav.data)) return index;
            }
        }
        return -1;
    }

    /**
     * Returns TRUE if data is present in the linked list.
     *
     * @param data
     * @return
     */
    public boolean contains(T data) {
        return this.indexOf(data) != -1;
    }

    /**
     * Iterator fot the linked list
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> trav = head;

            /**
             * Returns True if has more nodes
             */
            @Override
            public boolean hasNext() {
                return trav != null;
            }

            /**
             * Returns data from current node and points to next node.
             *
             * @return
             */
            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data);
            if (trav.next != null) sb.append(", ");
            trav = trav.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
