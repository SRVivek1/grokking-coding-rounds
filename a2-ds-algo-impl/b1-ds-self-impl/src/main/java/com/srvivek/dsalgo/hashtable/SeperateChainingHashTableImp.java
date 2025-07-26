package com.srvivek.dsalgo.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class demonstrates a Hash table implementation using separate chaining for hash collisions.
 */
@SuppressWarnings("unchecked")
public class SeperateChainingHashTableImp<K, V> implements Iterable<K> {

    private static final int DEFAULT_CAPACITY = 8;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private double maxLoadFactor;
    private int capacity, threshold, size = 0;

    /**
     * Array of LinedList Objects.
     */
    private LinkedList<Entry<K, V>>[] table;

    public SeperateChainingHashTableImp(){
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public SeperateChainingHashTableImp(int capacity, double maxLoadFactor) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity.");

        if (maxLoadFactor <= 0 || Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor))
            throw new IllegalArgumentException("Illegal maxLoadFactor");

        this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
        this.maxLoadFactor = maxLoadFactor;
        this.threshold = (int) (capacity * maxLoadFactor);
        this.table = new LinkedList[this.capacity];
    }

    /**
     * Count of elements in Hash table.
     *
     * @return count of elements
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns true of hash table has no elements.
     *
     * @return true if no elem present in HT
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /*
     * Converts a Hash value to an Index.
     *
     * Essentially it strips the negative signs and places the hash value in the domain [0, capacity].
     */
    private int normalizeIndex(int keyHash) {
        /*
         * (keyHash & 0x7FFFFFFF) normalizes the negative hashcode values to positive int values
         * Note: For positive int values, same value will be returned after & operation.
         * For negative values a calculated (different) positive int value is returned.
         * With modulo we get an index within the capacity/
         */
        return (keyHash & 0x7FFFFFFF) % this.capacity;
    }

    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    /**
     * Returns TRUE if key is present in the HashTable.
     *
     * @param key kry
     * @return boolean
     */
    public boolean containsKey(K key) {
        return hasKey(key);
    }

    /*
     * Return TRUE if key is present in HT.
     */
    public boolean hasKey(K key) {
        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketSeekEntry(bucketIndex, key) != null;
    }

    /**
     * Save the value in the HT
     */
    public V put(K key, V value) {
        return insert(key, value);
    }

    /**
     * Save the value in the HT
     */
    public V add(K key, V value) {
        return insert(key, value);
    }

    /**
     * Save the value in the HT
     */
    public V insert(K key, V value) {
        if (key == null) throw new IllegalArgumentException("null key");

        Entry<K, V> newEntry = new Entry<>(key, value);
        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketInsertEntry(bucketIndex, newEntry);
    }

    /**
     * Returns the value associated with the given key.
     * Returns null if key is not found.
     *
     * @param key key
     * @return V
     */
    public V get(K key) {
        if (key == null) return null;

        int bucketIndex = normalizeIndex(key.hashCode());
        Entry<K, V> entry = bucketSeekEntry(bucketIndex, key);
        if (entry != null) return entry.value;

        // Key not found
        return null;
    }

    /*
     * Removes the entry from HT associated with key and return the Entry value.
     * Returns null if key is not found also if the associated value is `null'
     */

    public V remove(K key) {
        if (key == null) return null;

        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketRemoveEntry(bucketIndex, key);
    }

    /**
     * Removes entry from given bucket if it exists.
     *
     * @param bucketIndex index
     * @param key         key
     * @return V
     */
    private V bucketRemoveEntry(int bucketIndex, K key) {
        Entry<K, V> entry = bucketSeekEntry(bucketIndex, key);

        // No entry associated with given key
        if (entry == null) return null;

        LinkedList<Entry<K, V>> links = table[bucketIndex];
        links.remove(entry);
        --size;
        return entry.value;
    }

    /**
     * Inserts an entry in given bucket only if the entry doesn't already exist in the
     * bucket else update the value.
     */
    private V bucketInsertEntry(int bucketKey, Entry<K, V> entry) {

        // Lazy initialization of bucket
        LinkedList<Entry<K, V>> bucket = table[bucketKey];
        if (bucket == null) table[bucketKey] = bucket = new LinkedList<>();

        //check if key exists
        Entry<K, V> existingEntry = bucketSeekEntry(bucketKey, entry.key);

        if (existingEntry == null) {
            bucket.add(entry);
            if (++size > threshold) resizeTable();
            return null; // indicating that entry is new
        } else {
            V oldValue = existingEntry.value;
            existingEntry.value = entry.value;
            return oldValue;
        }
    }

    /**
     * Finds and returns a given entry in a given bucket if it exists, returns null otherwise.
     */
    private Entry<K, V> bucketSeekEntry(int bucketIndex, K key) {
        if (key == null) return null;

        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        if (bucket == null) return null;

        // iterate and check each entry
        for (Entry<K, V> entry : bucket) {
            if (key.equals(entry.key)) {
                return entry;
            }
        }
        // No matching entry found
        return null;
    }

    /**
     * Resize the internal table holding bucket entries.
     */
    private void resizeTable() {
        capacity *= 2; // double the capacity
        threshold = (int) (capacity * maxLoadFactor);

        // Create a new linked list
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[capacity];

        // Add entries to new table
        for (int i = 0; i < table.length; i++) {

            LinkedList<Entry<K, V>> oldBucket = table[i];

            // Ignore if bucket is null
            if (oldBucket == null) continue;

            for (Entry<K, V> entry : oldBucket) {
                int bucketIndex = normalizeIndex(entry.hash);
                LinkedList<Entry<K, V>> bucket = newTable[bucketIndex];

                if (bucket == null) bucket = newTable[bucketIndex] = new LinkedList<>();
                bucket.add(entry);
            }

            // Avoid memory leak
            oldBucket.clear(); // delete all objects
            oldBucket = null; // delete link to current object
        }

        table = newTable;
    }

    /**
     * Return the list of Keys found within the HashTable.
     */
    public List<K> keys() {
        final List<K> keys = new ArrayList<>(size());

        for (LinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    keys.add(entry.key);
                }
            }
        }
        return keys;
    }

    /**
     * Returns the list of values found within the hash table.
     */
    public List<V> values() {
        final List<V> values = new ArrayList<>(size());

        for (LinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    values.add(entry.value);
                }
            }
        }
        return values;
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Iterator<K> iterator() {
        int elemCount = size();
        return new Iterator<K>() {
            int bucketIndex = 0;
            Iterator<Entry<K, V>> bucketIter = (table[0] == null) ? null : table[0].iterator();

            @Override
            public boolean hasNext() {
                // concurrent modification exception
                if (size() != elemCount) throw new ConcurrentModificationException();

                if (bucketIter == null || !bucketIter.hasNext()) {
                    // Search next buckets until a valid iterator is found
                    while (++bucketIndex < capacity) {
                        if (table[bucketIndex] != null) {
                            // Make sure this iterator actually has elements
                            Iterator<Entry<K, V>> nextIter = table[bucketIndex].iterator();
                            if (nextIter.hasNext()) {
                                bucketIter = nextIter;
                                break;
                            }
                        }
                    }
                }
                return bucketIndex < capacity;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public K next() {
                return bucketIter.next().key;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < capacity; i++) {
            if(table[i] == null) continue;
            for(Entry<K,V> entry: table[i]) sb.append(entry).append(", ");
        }
        sb.append("}");

        return sb.toString();
    }
}

/**
 * Entry object to store elements inserted in HashTable.
 *
 * @param <K>
 * @param <V>
 */
class Entry<K, V> {
    int hash;
    K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = this.key.hashCode();
    }

    public boolean equals(Entry<K, V> other) {
        if (this.hash != other.hash) return false;
        return this.key.equals(other.key);
    }

    @Override
    public String toString() {
        return this.key.toString() + " ==> " + this.value.toString();
    }
}