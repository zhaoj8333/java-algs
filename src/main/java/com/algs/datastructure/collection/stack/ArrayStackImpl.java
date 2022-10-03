package com.algs.datastructure.collection.stack;

import com.algs.datastructure.collection.CollectionDefaultValues;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.bag.ArrayBagImpl;
import com.algs.util.ObjectUtil;

import java.util.Arrays;
import java.util.Objects;

public class ArrayStackImpl<E> implements IStack<E> {

    private int size;
    private E[] entries;

    public ArrayStackImpl() {
        this(CollectionDefaultValues.DEFAULT_CAPACITY);
    }

    public ArrayStackImpl(int capacity) {
        entries = (E[]) new Object[capacity];
    }

    private void resize(int newCapacity) {
        E[] newEntries = (E[]) new Object[newCapacity];
        System.arraycopy(entries, 0, newEntries, 0, size);
        entries = newEntries;
    }

    @Override
    public void push(E item) {
        ObjectUtil.requireNonNull(item);
        if (size == entries.length) {
//            throw new RuntimeException("Already Full");
            resize(size << 1);
        }
        entries[size++] = item;
    }

    @Override
    public E pop() {
        ObjectUtil.requireNonEmpty(this);
        E entry = entries[size - 1];
        entries[size - 1] = null;
        size--;
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
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, entries[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            entries[i] = null;
        }
        size = 0;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        if (size >= 0) System.arraycopy(entries, 0, array, 0, size);
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
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
