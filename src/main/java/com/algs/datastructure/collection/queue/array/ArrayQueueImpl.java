package com.algs.datastructure.collection.queue.array;

import com.algs.datastructure.Iterator;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;
import java.util.Objects;

/**
 * {@link ArrayQueueImpl}: also name is CircularQueue, RingBuffer
 */
public class ArrayQueueImpl<E> extends ArrayQueue<E> {

    protected int tail;

    public ArrayQueueImpl() {
        super();
    }

    public ArrayQueueImpl(int cap) {
        super(cap);
    }

    protected void reset() {
        head = tail = 0;
    }

    @Override
    public int size() {
        if (tail >= head) {
            return tail - head;
        }
        return tail - head + entries.length;
    }

    protected boolean isFull() {
        return head - tail == 1;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean contains(E o) {
        if (Objects.isNull(o)) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            E entry = entries[(head + i) % entries.length];
            if (Objects.equals(entry, o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * When {@link ArrayQueueImpl#enque(Object)}, this will be called, will extend the entries automatically
     */
    private void ensureCapacity(int newCap) {
        if (newCap <= entries.length) {
            return;
        }
        E[] newEntries = (E[]) new Object[newCap];
        for (int i = 0; i < size(); i++) {
            newEntries[i] = entries[(head + i) % entries.length];
        }
        entries = newEntries;
        head = 0;
    }

    /**
     * 1. =========-----------------
     *    |       |
     *    head    tail
     *
     * 2. ======-------===============
     *         |       |
     *         tail    head
     */
    @Override
    public void enque(E item) {
        ObjectUtil.requireNonNull(item);
        if (isFull()) {
            ensureCapacity(entries.length << 1);
        }
        entries[(tail++) % entries.length] = item;
    }

    @Override
    public E deque() {
        ObjectUtil.requireNonEmpty(this);
        E headEntry = entries[head];
        entries[head] = null;
        head = (++head) % entries.length;
        return headEntry;
    }

    @Override
    public E peek() {
        return entries[head];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            entries[(head + i) % entries.length] = null;
        }
        reset();
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size()];
        for (int i = 0; i < size(); i++) {
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
