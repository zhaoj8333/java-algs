package com.graph.analysis.datastructure.collection.heap.array;

import com.algs.datastructure.collection.heap.array.IPriorityQueue;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;
import com.algs.utils.array.ArraysUtil;
import com.graph.analysis.datastructure.collection.CollectionAlys;
import java.util.Comparator;
import java.util.Objects;

public abstract class ArrayPqAlys<E extends Comparable<E>> extends CollectionAlys<E> implements IPriorityQueue<E> {

    protected int size;
    protected E[] entries;
    protected Comparator<E> comparator;

    public ArrayPqAlys(E[] rawData, Comparator<E> comparator) {
        super(rawData);
        this.entries = (E[]) new Comparable[rawData.length];
        this.comparator = comparator;
    }

    protected void ensureCapacity(int newCap) {
        E[] newEntries = (E[]) new Comparable[newCap];
        for (int i = 0; i < size; i++) {
            newEntries[i] = entries[i];
        }
        arrayAcc += size;
        entries = newEntries;
    }

    protected void heapify() {
        for (int i = (size >> 1) - 1; i >= 0; i--) {
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

    /**
     * // TODO: 2/2/23  
     */
    @Override
    public boolean contains(E item) {
        return ArraysUtil.contains(entries, item, 0, size);
    }

    @Override
    public E peek() {
        ObjectUtil.requireNonEmpty(this);
        arrayAcc += 1;
        return entries[0];
    }

    @Override
    public E remove() {
        E entry = entries[0];
        int li = --size;
        entries[0] = entries[li];
        entries[li] = null;
        arrayAcc += 4;
        siftDown(0);
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
            arrayAcc++;
            siftDown(0);
        }
        arrayAcc++;
        return root;
    }

    @Override
    public void add(E item) {
        ObjectUtil.requireNonNull(item);
        if (size >= entries.length) {
            ensureCapacity(size << 1);
        }
        entries[size++] = item;
        arrayAcc++;
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
