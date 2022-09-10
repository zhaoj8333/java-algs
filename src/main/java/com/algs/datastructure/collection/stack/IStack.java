package com.algs.datastructure.collection.stack;

import com.algs.datastructure.collection.Iterable;

public interface IStack<E> extends Iterable<E> {

    void push(E item);

    E pop();

    boolean isEmpty();

    int size();

}
