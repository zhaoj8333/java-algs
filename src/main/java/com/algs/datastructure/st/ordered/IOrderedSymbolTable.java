package com.algs.datastructure.st.ordered;

import com.algs.datastructure.Iiterable;
import com.algs.datastructure.st.ISymbolTable;

/**
 * When a method is to return a key but there is no key fitting the description in the table, throw an exception
 * Shorthand methods:
 *  {@link #deleteMax()}
 *  {@link #deleteMin()}
 *  {@link #size(Comparable, Comparable)}
 *  {@link #keys()}
 *
 * Key's equality:
 *  we use {@link Comparable#compareTo(Object)} not {@link java.util.Objects#equals(Object, Object)}
 */
public interface IOrderedSymbolTable<K extends Comparable<K>, V> extends ISymbolTable<K, V> {

    K min();

    K max();

    /**
     * largest key less than or equal to key
     */
    K floor(K key);

    /**
     * smallest key greater than or equal to key
     */
    K ceil(K key);

    /**
     * number of keys less than key
     */
    int rank(K key);

    /**
     * key of rank k
     */
    K select(int k);

    void deleteMin();

    void deleteMax();

    int size(K low, K high);

    /**
     *  keys in [low, high], in sorted order
     */
    Iiterable<K> keys(K low, K high);

}
