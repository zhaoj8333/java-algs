package com.algs.datastructure.collection.deque;

import com.algs.datastructure.collection.queue.IQueue;

public interface IDeque<E> extends IQueue<E> {

    void enqueHead(E item);

    E dequeHead();

    void enqueTail(E item);

    E dequeTail();

    E peekHead();

    E peekTail();

}
