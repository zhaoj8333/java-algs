package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.Collection;

/**
 * FIFO
 */
public interface IQueue<E> extends Collection<E> {

    void enque(E item);

    E deque();

    E peek();

}

