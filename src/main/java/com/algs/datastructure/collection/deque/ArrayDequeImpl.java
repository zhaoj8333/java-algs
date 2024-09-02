package com.algs.datastructure.collection.deque;

import com.algs.DefaultValues;
import com.algs.datastructure.Iterator;
import com.algs.utils.ObjectUtil;
import com.algs.utils.array.ArraysUtil;
import java.util.Objects;

/**
 * Circular Deque
 */
public class ArrayDequeImpl<E> implements IDeque<E> {

    private int head;
    private int size;
    private int tail;
    private final E[] entries;

    public ArrayDequeImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public ArrayDequeImpl(int capacity) {
        entries = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return tail;
    }

    /**
     * 1.  --======================--------------
     *       |                    |
     *    head                tail = (head + size) % entries.length
     *
     * 2.  =========---------------==========
     *            |               |
     *            tail            head
     */
    private int tailIndex() {
        return (head + tail) % entries.length;
    }

    @Override
    public boolean isEmpty() {
        return tail == 0;
    }

    public boolean isFull() {
        return tail == entries.length;
    }

    @Override
    public void enqueHead(E item) {
        if (isFull()) {
            throw new RuntimeException("Already Full");
        }
        ObjectUtil.requireNonNull(item);
        head = ((head - 1) + entries.length) % entries.length;
        entries[head] = item;
        tail++;
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
        int tailIndex = (head + tail - 1) % entries.length;
        E entry = entries[tailIndex];
        entries[tailIndex] = null;
        tail--;
        return entry;
    }

    @Override
    public E peekHead() {
        return entries[head];
    }

    @Override
    public E peekTail() {
        return entries[tailIndex()];
    }

    @Override
    public void enque(E item) {
        if (isFull()) {
            throw new RuntimeException("Already Full");
        }
        ObjectUtil.requireNonNull(item);
        entries[tailIndex()] = item;
        tail++;
    }

    @Override
    public E deque() {
        ObjectUtil.requireNonEmpty(this);
        E entry = entries[head];
        entries[head] = null;
        head = (++head) % entries.length;
        tail--;
        return entry;
    }

    @Override
    public E peek() {
        return peekHead();
    }

    @Override
    public boolean contains(E item) {
        for (int i = 0; i < tail; i++) {
            if (Objects.equals(entries[(head + i) % entries.length], item)) {
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
        ArraysUtil.fill(entries, 0, tail, null);
        head = 0;
        tail = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[tail];
        for (int i = 0; i < tail; i++) {
            array[i] = entries[(head + i) % entries.length];
        }
        return array;
    }

    private class ArrayDequeIterator<E> implements Iterator<E> {

        private int n = -1;

        @Override
        public boolean hasNext() {
            return n < tail - 1;
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

//    @Override
//    public final void reverse() {
//        throw new UnsupportedOperationException("UnsupportedOperation");
//    }

}
