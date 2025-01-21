package com.srvivek.dsalgo.arrays.dynamic;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {

    private static final int DEFAULT_CAP = 1 << 3;

    // Data array
    private T[] arr;

    // Data size
    private int len = 0;

    // Actual array size
    private int capacity = 0;

    public DynamicArray() {
        this(DEFAULT_CAP);
    }

    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Illegal capacity : " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[this.capacity];
    }

    /**
     * Create array from the given array
     *
     * @param array
     */
    public DynamicArray(T[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array can't be null");
        }
        arr = Arrays.copyOf(array, array.length);
        capacity = len = arr.length;
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T data) {
        arr[index] = data;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T elem) {
        //Increase size if array is full.
        if (len + 1 >= capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }
        }
        arr = Arrays.copyOf(arr, capacity);

        // add element
        arr[len++] = elem;
    }


    /**
     * Remove data ot given index.
     *
     * @param rm_index
     * @return
     */
    public T removeAt(int rm_index) {
        if (rm_index < 0 || rm_index >= len) {
            throw new IllegalArgumentException("Index : " + rm_index + ", Array size = " + len);
        }
        T oldObject = arr[rm_index];

        // JDK API to copy array data new array - O(n)
        System.arraycopy(arr, rm_index + 1, arr, rm_index, len - rm_index - 1);
        len--;
        capacity--;
//        Manually copy elements to new array
//        @SuppressWarnings("unchecked")
//        T[] array = (T[]) new Object[len - 1];
//
//        for (int i = 0, j=0; i < arr.length; i++, j++) {
//            if (i == rm_index) {
//                j--;
//            } else {
//                array[i] = arr[i];
//            }
//        }
//        arr = array;
        return oldObject;
    }

    public boolean remove(T elem) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(elem)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }


    public int indexOf(T elem) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T elem) {
        return indexOf(elem) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {

        if (len == 0) return "[]";

        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < len - 1; i++) {
            sb.append(arr[i]);
            sb.append(", ");
        }
        return sb.append(arr[len-1]).append("]").toString();
    }
}
