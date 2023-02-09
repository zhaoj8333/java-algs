package com.algs.datastructure.st;

import com.algs.datastructure.collection.Iterable;

import java.util.Objects;

public abstract class AbstractSequentialTable<K, V> implements ISymbolTable<K, V> {

    protected int size;

    @Override
    public final int size() {
        return size;
    }

    @Override
    public final boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void delete(K key) {
        put(key, null);
        size--;
    }

    @Override
    public final boolean contains(K key) {
        return Objects.nonNull(get(key));
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

}
