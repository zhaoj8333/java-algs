package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.ICollection;

/**
 * FIFO
 */
public interface IQueue<E> extends ICollection<E> {

    void enque(E item);

    E deque();

    E peek();

}

