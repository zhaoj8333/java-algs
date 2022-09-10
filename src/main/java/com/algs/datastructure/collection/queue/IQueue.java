package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.Iterable;

public interface IQueue<E> extends Iterable<E> {

    void enqueue(E item);

    E dequeue();

    boolean isEmpty();

    int size();

}
