package com.algs.datastructure.collection.deque;

import com.algs.DefaultValues;
import com.algs.datastructure.Iterator;
import com.algs.utils.ObjectUtil;
import com.algs.utils.array.ArraysUtil;

import java.util.Objects;

public class ArrayDequeImpl<E> implements IDeque<E> {

    private int size;
    private int headIndex;
    private final E[] entries;

    public ArrayDequeImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public ArrayDequeImpl(int capacity) {
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
    public void clear() {
//        while (!isEmpty()) {
//            deque();
//        }
        ArraysUtil.fill(entries, 0, size, null);
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

    @Override
    public final E get(int i) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public final void add(E o) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public final E remove(int i) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(E o) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public final void reverse() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

}
