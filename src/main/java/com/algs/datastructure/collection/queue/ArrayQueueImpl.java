package com.algs.datastructure.collection.queue;

import com.algs.datastructure.collection.CollectionDefaultValues;
import com.algs.datastructure.collection.Iterator;
import com.algs.util.ObjectUtil;

import java.util.Objects;

/**
 * {@link ArrayQueueImpl}: also name is CircularQueue, RingBuffer
 * ArrayQueue: when enqueue, #{{@link ArrayQueueImpl#ensureCapacity(int)}} is called, will extend the entries automatically
 */
@SuppressWarnings("unchecked")
public class ArrayQueueImpl<E> implements IQueue<E> {

    protected int size;
    protected int headIndex;
    protected E[] entries;

    public ArrayQueueImpl() {
        this(CollectionDefaultValues.DEFAULT_CAPACITY);
    }

    public ArrayQueueImpl(int capacity) {
        entries = (E[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E o) {
        if (Objects.isNull(o)) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            E entry = entries[(headIndex + i) % entries.length];
            if (Objects.equals(entry, o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity <= entries.length) {
            return;
        }
        E[] newEntries = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newEntries[i] = entries[(headIndex + i) % entries.length];
        }
        entries = newEntries;
        headIndex = 0;
    }

    /**
     * Index of enqueue is: (headIndex + size) % entries.length
     */
    @Override
    public void enque(E item) {
        ObjectUtil.requireNonNull(item);
        if (size == entries.length) {
            int length = entries.length;
            ensureCapacity(length << 1);
        }
        entries[(headIndex + size) % entries.length] = item;
        size++;
    }

    @Override
    public E deque() {
        E headEntry = entries[headIndex];
        entries[headIndex] = null;
        headIndex = (++headIndex) % entries.length;
        size--;
        return headEntry;
    }

    @Override
    public E peek() {
        return entries[headIndex];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            entries[(headIndex + i) % entries.length] = null;
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

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public final void add(E o) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(E o) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public void reverse() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    private class ArrayQueueIterator<E> implements Iterator<E> {

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
        return new ArrayQueueIterator<>();
    }
}
