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
        this.entries = (E[]) new Comparable[capacity];
        this.comparator = comparator;
    }

    public ArrayPq(E[] array) {
        this(array, null);
    }

    public ArrayPq(E[] array, Comparator<E> comparator) {
        this(array.length, comparator);
        ObjectUtil.requireNonNullElement(array);
        ArraysUtil.copyAll(array, entries);
        size = array.length;
        heapify(0);
    }

    protected void heapify(int begin) {
        for (int i = (size >> 1) - 1; i >= begin; i--) {
            siftDown(i);
        }
    }

    protected void resize(int newCap) {
        E[] newEntries = (E[]) new Comparable[newCap];
        for (int i = 0; i < size; i++) {
            newEntries[i] = entries[i];
        }
        entries = newEntries;
    }

    protected abstract void siftUp(int index);

    protected abstract void siftDown(int index);

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int compare(E a, E b) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

    @Override
    public boolean contains(E item) {
        return ArraysUtil.contains(entries, item);
    }

    @Override
    public void clear() {
        ArraysUtil.fill(entries, 0, size, null);
        size = 0;
    }

    @Override
    public E[] toArray() {
        return CollectionUtil.toArray(this);
    }

    @Override
    public final E get(int index) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public final E remove(int index) {
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
