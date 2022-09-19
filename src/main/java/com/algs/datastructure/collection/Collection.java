package com.algs.datastructure.collection;

public interface Collection<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    boolean contains(E item);

    void add(E item);

    E remove(int index);

    E remove(E item);

    void clear();

    E[] toArray();

}
