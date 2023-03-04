package com.algs.datastructure.st;

import com.algs.datastructure.Iiterable;

/**
 * Symbol Table is a data structure for key-value pairs that supports insert(put) and search(get) for the value
 *  associated with a given key
 *
 *  Typical Applications:
 *      dictionary, book index, file share, account management, web search, compiler
 *
 *  Convention:
 *      Only one value is associated with one key, key is unique
 *      When a new key-value {@link #put(Object, Object)} into table which already contains this key, new value will replace the old one
 *      Null keys: Key can't be null,
 *      Null values: Value can't be null, {@link #get(Object)} should be null for keys not in the table
 *
 *      Shorthand methods: {@link #contains(Object)}, {@link #size()}, {@link #isEmpty()}
 *      Key Equality: Object Equality, also key should be kept immutable
 */
public interface ISymbolTable<K, V> {

    int size();

    boolean isEmpty();

    V get(K key);

    void put(K key, V val);

    /**
     * Deletion:
     *     lazy deletion: associate the key with null, then remove all such keys at some later time, use {@link #put(Object, Object)} with null value
     *     eager deletion: delete the key immediately
     */
    void delete(K key);

    boolean contains(K key);

    /**
     * We don't implement {@link Iiterable} interface, instead, use {@link #keys()} method to return a {@link Iiterable}
     */
    Iiterable<K> keys();

    void clear();

}
