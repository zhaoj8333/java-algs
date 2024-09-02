package com.algs.datastructure.collection.queue.array;

import com.algs.datastructure.Iterator;
import com.algs.utils.ObjectUtil;

import java.util.Objects;

/**
 * {@link ArrayQueueImpl0}: also name is CircularQueue, RingBuffer
 */
public class ArrayQueueImpl0<E> extends ArrayQueue<E> {

    public ArrayQueueImpl0() {
        super();
    }

    public ArrayQueueImpl0(int cap) {
        super(cap);
    }

    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E o) {
        if (Objects.isNull(o)) return false;
        for (int i = 0; i < size(); i++) {
            E entry = entries[(head + i) % entries.length];
            if (Objects.equals(entry, o)) {
                return true;
            }
        }
        return false;
    }

    private void grow(int newCap) {
        if (newCap <= entries.length) return;
        E[] newEntries = (E[]) new Object[newCap];
        for (int i = 0; i < size(); i++) {
            newEntries[i] = entries[(head + i) % entries.length];
        }
        entries = newEntries;
        head = 0;
    }

    private boolean isFull() {
        return size == entries.length;
    }

    private void reset() {
        head = size = 0;
    }

    /**
     * 1. = = = = = = = = = =
     *    |                 |
     *    head              head + size - 1
     */
    @Override
    public void enque(E item) {
        ObjectUtil.requireNonNull(item);
        if (isFull()) {
            grow(entries.length << 1);
        }
        entries[(head + size) % entries.length] = item;
        size++;
    }

    @Override
    public E deque() {
        ObjectUtil.requireNonEmpty(this);
        E entry = entries[head];
        entries[head] = null;
        size--;
        head = ++head % entries.length;
        return entry;
    }

    @Override
    public E peek() {
        return entries[head];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            entries[(head + i) % entries.length] = null;
        }
        reset();
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = entries[(head + i) % entries.length];
        }
        return array;
    }

    private class ArrayQueueIterator<E> implements Iterator<E> {

        private int n = -1;

        @Override
        public boolean hasNext() {
            return n < size() - 1;
        }

        @Override
        public E next() {
            return (E) entries[++n];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator<>();
    }

}
