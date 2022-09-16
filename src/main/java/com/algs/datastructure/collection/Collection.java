package com.algs.datastructure.collection;

public interface Collection<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    boolean contains(E o);

    void add(E o);

    E remove(E o);

    void clear();

    E[] toArray();

}
