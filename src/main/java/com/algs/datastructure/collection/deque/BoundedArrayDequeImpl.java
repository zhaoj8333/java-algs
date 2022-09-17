package com.algs.datastructure.collection.deque;

import com.algs.datastructure.collection.CollectionDefaultValues;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.queue.BoundedArrayQueueImpl;
import com.algs.util.ObjectUtil;

import java.util.Objects;

public class BoundedArrayDequeImpl<E> implements IDeque<E> {

    private int size;
    private int headIndex;
    private final E[] entries;

    public BoundedArrayDequeImpl() {
        this(CollectionDefaultValues.DEFAULT_CAPACITY);
    }

    public BoundedArrayDequeImpl(int capacity) {
        entries = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    private int getTailIndex() {
        return (headIndex + size) % entries.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == entries.length;
    }

    @Override
    public void enqueHead(E item) {
        if (isFull()) {
            throw new RuntimeException("Already Full");
        }
        ObjectUtil.requireNonNull(item);
        headIndex = ((headIndex - 1) + entries.length) % entries.length;
        entries[headIndex] = item;
        size++;
    }

    @Override
    public E dequeHead() {
        return deque();
    }

    @Override
    public void enqueTail(E item) {
        enque(item);
    }

    @Override
    public E dequeTail() {
        ObjectUtil.requireNonEmpty(this);
        int tailIndex = (headIndex + size - 1) % entries.length;
        E entry = entries[tailIndex];
        entries[tailIndex] = null;
        size--;
        return entry;
    }

    @Override
    public E peekHead() {
        return entries[headIndex];
    }

    @Override
    public E peekTail() {
        return entries[getTailIndex()];
    }

    @Override
    public void enque(E item) {
        if (isFull()) {
            throw new RuntimeException("Already Full");
        }
        ObjectUtil.requireNonNull(item);
        entries[getTailIndex()] = item;
        size++;
    }

    @Override
    public E deque() {
        ObjectUtil.requireNonEmpty(this);
        E entry = entries[headIndex];
        entries[headIndex] = null;
        headIndex = (++headIndex) % entries.length;
        size--;
        return entry;
    }

    @Override
    public E peek() {
        return peekHead();
    }

    @Override
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(entries[(headIndex + i) % entries.length], item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final void add(E o) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public final E remove(E o) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            deque();
        }
        headIndex = 0;
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = entries[(headIndex + i) % entries.length];
        }
        return array;
    }

    private class ArrayDequeIterator<E> implements Iterator<E> {

        private int n = -1;

        @Override
        public boolean hasNext() {
            return n < size - 1;
        }

        @Override
        public E next() {
            return (E) entries[++n];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayDequeIterator<>();
    }
}
