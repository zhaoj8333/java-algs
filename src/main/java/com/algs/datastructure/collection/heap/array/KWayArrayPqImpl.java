package com.algs.datastructure.collection.heap.array;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.Iterator;
import com.algs.utils.array.ArraysUtil;

import java.util.Comparator;

public class KWayArrayPqImpl<E extends Comparable<E>> extends ArrayPq<E> {

    private int k;

    public KWayArrayPqImpl() {
        this(2);
    }

    public KWayArrayPqImpl(int k) {
        this(k, DefaultValues.DEFAULT_CAPACITY, null);
    }

    public KWayArrayPqImpl(int k, int capacity, Comparator<E> comparator) {
        if (k < 2) {
            throw new IllegalArgumentException("k should >= 2");
        }
        if (capacity < 1) {
            capacity = DefaultValues.DEFAULT_CAPACITY;
        }
        this.k = k;
        this.comparator = comparator;
        this.entries = (E[]) new Comparable[capacity];
    }

    public KWayArrayPqImpl(int k, E[] array) {
        this(k, array, null);
    }

    public KWayArrayPqImpl(int k, E[] array, Comparator<E> comparator) {
        this(k, array.length, comparator);
        ArraysUtil.copyAll(array, entries);
        size = array.length;
        heapify(0);
    }

    public KWayArrayPqImpl(int k, ICollection<E> collection) {
        this(k, collection, null);
    }

    public KWayArrayPqImpl(int k, ICollection<E> collection, Comparator<E> comparator) {
        this(k, collection.size(), comparator);
        Iterator<E> itr = collection.iterator();
        while (itr.hasNext()) {
            entries[size++] = itr.next();
        }
        heapify(0);
    }

    @Override
    protected void heapify(int begin) {
        for (int i = size / k; i >= begin; i--) {
            siftDown(i);
        }
    }

    @Override
    protected void siftUp(int i) {
        E entry = entries[i];
        while (i > 0) {
            int pi = (i - 1) / k;
            E parent = entries[pi];
            if (compare(entry, parent) <= 0) {
                break;
            }
            entries[i] = parent;
            i = pi;
        }
        entries[i] = entry;
    }

    @Override
    protected void siftDown(int i) {
        E root = entries[i];
        if (i >= size / k && k > 2) {
            k--;
        }
        while (i < size / k) {
            int ci = (i * k) + 1;
            E child = entries[ci];
            for (int m = 1; m < k; m++) {
                if (ci + m < size && compare(child, entries[ci + m]) < 0) {
                    child = entries[ci += m];
                }
            }
            if (compare(root, child) >= 0) {
                break;
            }
            entries[i] = child;
            i = ci;
        }
        entries[i] = root;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
