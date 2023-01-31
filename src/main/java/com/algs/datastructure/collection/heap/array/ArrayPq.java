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

    protected abstract void heapify(int i);

    protected abstract void siftUp(int i);

    protected abstract void siftDown(int i);

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
