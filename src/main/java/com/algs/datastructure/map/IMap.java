package com.algs.datastructure.map;

import com.algs.datastructure.collection.Iterable;

public interface IMap<K, V> extends Iterable<V> {

    int size();

    boolean isEmpty();

    boolean contains(K key);

    V put(K key, V val);

    V get(K key);

    V remove(K key);

    void clear();

//    ICollection<E> copy();

}
