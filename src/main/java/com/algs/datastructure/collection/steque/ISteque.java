package com.algs.datastructure.collection.stack;

import com.algs.datastructure.collection.queue.IQueue;

/**
 * {@link IQueue}
 */
public interface ISteque<E> extends IQueue<E> {

    void enqueFirst(E item);

    void enque(E item);

    E deque();

    E peek();

}

