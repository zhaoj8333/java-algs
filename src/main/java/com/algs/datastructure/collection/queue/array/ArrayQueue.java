package com.algs.datastructure.collection.queue.array;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.queue.IQueue;

public abstract class ArrayQueue<E> implements IQueue<E> {

    protected int head;
    protected E[] entries;

    public ArrayQueue() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        entries = (E[]) new Object[capacity];
    }

    @Override
    public final E get(int i) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public final void add(E o) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(int i) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(E o) {
        throw new UnsupportedOperationException("unsupported operation");
    }

//    @Override
//    public final void reverse() {
//        throw new UnsupportedOperationException("UnsupportedOperation");
//    }

}
