package com.algs.datastructure.collection.heap.array;

import com.algs.datastructure.Iterator;
import com.algs.utils.ObjectUtil;
import com.algs.utils.RangeUtil;
import com.algs.utils.array.ArraysUtil;

public class IndexedBinaryArrayPqImpl<E extends Comparable<E>> extends ArrayPq<E> {

    private int[] pq; // pq[i] = k, k is index in entries, heap sorted
    private int[] qp; // qp: i = pq[i], qp[i] = i in pq

    @Override
    protected void heapify(int i) {

    }

    @Override
    public void add(E item) {
        add(size, item);
    }

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

    protected void resize(int newCapacity) {
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

    public void siftUp(int index) {
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

    public void change(int i, E item) {
        ObjectUtil.requireNonNull(item);

    }

    public boolean contains(int i) {
        return false;
    }

    public void delete(int k) {

    }

    public E min() {
        return null;
    }

    public int minIndex() {
        return 0;
    }

    public int delMin() {
        return 0;
    }

    @Override
    public boolean contains(E item) {
        return ArraysUtil.contains(entries, item);
    }

    @Override
    public void clear() {
        ArraysUtil.fill(pq, 0, size, 0);
        ArraysUtil.fill(qp, 0, size, 0);
        ArraysUtil.fill(entries, null);
        size = 0;
    }

    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public E peek() {
        return entries[pq[1]];
    }

    @Override
    public E remove() {
        int i = pq[1];
        E entry = entries[i];
        entries[i] = null;
        pq[1] = pq[size--];
        siftDown(i);
        return entry;
    }

    public void siftDown(int i) {
        E entry = entries[i];
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

}
