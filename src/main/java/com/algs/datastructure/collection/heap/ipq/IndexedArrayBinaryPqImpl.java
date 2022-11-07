package com.algs.datastructure.collection.heap.ipq;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;
import com.algs.util.ArraysUtil;
import com.algs.util.ObjectUtil;
import com.algs.util.RangeUtil;

import java.util.Comparator;
import java.util.Objects;

public class IndexedArrayBinaryPqImpl<E extends Comparable<E>> implements IndexedPriorityQueue<E> {

    private int size;
    private E[] entries;
    private int[] pq; // pq[i] = k, k is index in entries, heap sorted
    private int[] qp; // qp: i = pq[i], qp[i] = i in pq
    private final Comparator<E> comparator;

    public IndexedArrayBinaryPqImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public IndexedArrayBinaryPqImpl(int capacity) {
        this(capacity, null);
    }

    public IndexedArrayBinaryPqImpl(int capacity, Comparator<E> comparator) {
        this.size = capacity;
        entries = (E[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        ArraysUtil.fill(qp, -1);
        this.comparator = comparator;
    }

    public IndexedArrayBinaryPqImpl(ICollection<E> collection) {
        this(collection.size());
    }

    public IndexedArrayBinaryPqImpl(ICollection<E> collection, Comparator<E> comparator) {
        this(collection.size(), comparator);
        Iterator<E> itr = collection.iterator();
        int index = 0;
        for (int i = 0; i < collection.size(); i++) {
            entries[index++] = itr.next();
        }
        heapify();
    }

    private void heapify() {

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
    public int compare(E a, E b) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

    @Override
    public void add(E item) {
        add(size, item);
    }

    @Override
    public void add(int i, E item) {
        ObjectUtil.requireNonNull(item);
        RangeUtil.requireRangeWhenAdd(i, 0, size);
        if (i > size) {
            resize(size << 1);
        }
        entries[i] = item;
        size++;
        pq[size] = i;
        siftUp(size);
    }

    private void resize(int newCapacity) {
        E[] newEntries = (E[]) new Comparable[newCapacity + 1];
        System.arraycopy(entries, 0, newEntries, 0, size);
        entries = newEntries;
        int[] newPq = new int[newCapacity + 1];
        System.arraycopy(pq, 0, newPq, 0, size);
        pq = newPq;
        int[] newQp = new int[newCapacity + 1];
        System.arraycopy(qp, 0, newQp, 0, size);
        pq = newQp;
    }

    private void siftUp(int index) {
        int i = pq[index];
        E entry = entries[i];
        while (index > 1) {
            int pIndex = index << 1;
            E parent = entries[pq[pIndex]];
            if (compare(parent, entry) <= 0) {
                break;
            }
            pq[index] = pq[pIndex];
            index = pIndex;
        }
        pq[index] = pq[i];
    }

    @Override
    public void change(int i, E item) {
        ObjectUtil.requireNonNull(item);

    }

    @Override
    public boolean contains(int i) {
        return false;
    }

    @Override
    public void delete(int k) {

    }

    @Override
    public E min() {
        return null;
    }

    @Override
    public int minIndex() {
        return 0;
    }

    @Override
    public int delMin() {
        return 0;
    }

    @Override
    public boolean contains(E item) {
        return ArraysUtil.contains(entries, item);
    }

    @Override
    public void clear() {
        ArraysUtil.fill(pq, 0);
        ArraysUtil.fill(qp, 0);
        ArraysUtil.fill(entries, null);
        size = 0;
    }

    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public E get() {
        return entries[pq[1]];
    }

    @Override
    public E remove() {
        int index = pq[1];
        E entry = entries[index];
        entries[index] = null;
        pq[1] = pq[size--];
        siftDown(index);
        return entry;
    }

    private void siftDown(int index) {
        E entry = entries[index];
        int half = size >> 1;

    }

    @Override
    public E replace(E item) {
        ObjectUtil.requireNonNull(item);

        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public E remove(E item) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public void reverse() {
        throw new UnsupportedOperationException("unsupported operation");
    }

}
