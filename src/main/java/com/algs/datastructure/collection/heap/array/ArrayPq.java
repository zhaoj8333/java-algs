package com.algs.datastructure.collection.heap.array;

import com.algs.DefaultValues;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;
import com.algs.utils.array.ArraysUtil;

import java.util.Comparator;
import java.util.Objects;

public abstract class ArrayPq<E extends Comparable<E>> implements IPriorityQueue<E> {

    protected int size;
    protected E[] entries;
    protected Comparator<E> comparator;

    public ArrayPq() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public ArrayPq(int capacity) {
        this(capacity, null);
    }

    public ArrayPq(int capacity, Comparator<E> comparator) {
        if (capacity <= DefaultValues.DEFAULT_CAPACITY) {
            capacity = DefaultValues.DEFAULT_CAPACITY;
        }
        this.entries = (E[]) new Comparable[capacity];
        this.comparator = comparator;
    }

    public ArrayPq(E[] array) {
        this(array, null);
    }

    public ArrayPq(E[] array, Comparator<E> comparator) {
        this(array.length, comparator);
        ArraysUtil.copyAll(array, entries);
        size = array.length;
        heapify(0);
    }

    protected void ensureCapacity(int newCap) {
        E[] newEntries = (E[]) new Comparable[newCap];
        for (int i = 0; i < size; i++) {
            newEntries[i] = entries[i];
        }
        entries = newEntries;
    }

    /**
     * {@link #siftDown(int)} from bigger index to smaller index, maintains the nature of heap
     */
    protected void heapify(int begin) {
        for (int i = (size >> 1) - 1; i >= begin; i--) {
            siftDown(i);
        }
    }

    @Override
    public final int size() {
        return size;
    }

    @Override
    public final boolean isEmpty() {
        return size == 0;
    }

    @Override
    public final int compare(E a, E b) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

    @Override
    public boolean contains(E item) {
        return ArraysUtil.contains(entries, item, 0, size);
    }

    @Override
    public E get() {
        ObjectUtil.requireNonEmpty(this);
        return entries[0];
    }

    @Override
    public E remove() {
        ObjectUtil.requireNonEmpty(this);
        E entry = entries[0];
        int li = --size;
        entries[0] = entries[li];
        entries[li] = null;
        if (size > 1) {
            siftDown(0);
        }
        return entry;
    }

    @Override
    public E replace(E item) {
        ObjectUtil.requireNonNull(item);
        E root = null;
        if (size == 0) {
            entries[0] = item;
            size++;
        } else {
            root = entries[0];
            entries[0] = item;
            siftDown(0);
        }
        return root;
    }

    @Override
    public void add(E item) {
        ObjectUtil.requireNonNull(item);
        if (size >= entries.length) {
            ensureCapacity(size << 1);
        }
        entries[size++] = item;
        siftUp(size - 1);
    }

    @Override
    public void clear() {
        ArraysUtil.fill(entries, 0, size, null);
        size = 0;
    }

    protected abstract void siftUp(int i);

    protected abstract void siftDown(int i);

    @Override
    public E[] toArray() {
        return CollectionUtil.toArray(this);
    }

    @Override
    public final E get(int i) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(int i) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(E item) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final void reverse() {
        throw new UnsupportedOperationException("unsupported operation");
    }

}
