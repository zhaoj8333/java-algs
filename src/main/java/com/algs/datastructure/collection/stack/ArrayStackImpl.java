package com.algs.datastructure.collection.stack;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.Iterator;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;

import java.util.ConcurrentModificationException;

public class ArrayStackImpl<E> implements IStack<E> {

    private int size;
    private int modCount;
    private E[] entries;

    public ArrayStackImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public ArrayStackImpl(int capacity) {
        entries = (E[]) new Object[capacity];
    }

    private void resize(int newCapacity) {
        E[] newEntries = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newEntries[i] = entries[i];
        }
        entries = newEntries;
    }

    @Override
    public void push(E item) {
        ObjectUtil.requireNonNull(item);
        modCount++;
        if (size == entries.length) {
            resize(size << 1);
        }
        entries[size++] = item;
    }

    @Override
    public E pop() {
        ObjectUtil.requireNonEmpty(this);
        modCount++;
        E entry = entries[size - 1];
        entries[size--] = null;
        return entry;
    }

    @Override
    public E top() {
        return entries[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E item) {
        return ArraysUtil.contains(entries, item);
    }

    @Override
    public void clear() {
        ArraysUtil.fill(entries, 0, size, null);
        modCount++;
        size = 0;
    }

    @Override
    public E[] toArray() {
        return CollectionUtil.toArray(this);
    }

    @Override
    public String toString() {
        return CollectionUtil.toString(this);
    }

    private class ArrayStackIterator<E> implements Iterator<E> {

        private int n = size - 1;

        @Override
        public boolean hasNext() {
            return n >= 0;
        }

        @Override
        public E next() {
            return (E) entries[n--];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayStackIterator<>();
    }

    private final class ArrayStackReverseIterator<E> implements Iterator<E> {

        private int n = 0;

        @Override
        public boolean hasNext() {
            return n < size;
        }

        @Override
        public E next() {
            return (E) entries[n++];
        }
    }

    private final class UnmodifiableArrayStackReverseIterator<E> implements Iterator<E> {

        private int n = 0;
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Can't modify elements while iterating");
            }
            return n < size;
        }

        @Override
        public E next() {
            return (E) entries[n++];
        }
    }

    @Override
    public final Iterator<E> reverseIterator() {
        return new ArrayStackReverseIterator<>();
    }

    @Override
    public final E get(int index) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public final void add(E o) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public final E remove(int index) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public final E remove(E o) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public final void reverse() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

}
