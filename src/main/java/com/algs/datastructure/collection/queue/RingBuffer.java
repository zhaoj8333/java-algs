package com.algs.datastructure.collection.queue;

import com.algs.util.ObjectUtil;

/**
 * read/write logic are the same as {@link ArrayQueueImpl}
 *
 *
 */
public class RingBuffer<E> {

    private E[] buffer;
    private int size;
    private int readIndex;
    private int writeIndex;

    public RingBuffer(int capacity) {
        buffer = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == buffer.length;
    }

    public void write(E item) {
        ObjectUtil.requireNonNull(item);
        if (isFull()) {
            throw new RuntimeException("Already Full");
        }
        buffer[(writeIndex++) % buffer.length] = item;
        size++;
    }

    public E read() {
        if (isEmpty()) {
            throw new RuntimeException("already empty");
        }
        size--;
        return buffer[(readIndex++) % buffer.length];
    }
}
