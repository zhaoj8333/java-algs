package com.algs.datastructure.collection.heap.array;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;
import com.algs.utils.ObjectUtil;
import com.algs.utils.array.ArraysUtil;

import java.util.Comparator;

/**
 * The logic structure of Binary Heap is a Complete Binary Tree
 *
 * Discipline of index:
 *
 * using the first entry
 *
 * i = 0, root node
 * i > 1, index of parent node is: (i - 1) / 2
 *        index of child nodes are: 2i + 1, 2i + 2
 *
 *   i     0  1  2  3  4  5  6  7  8  9  10
 * a[i] -  T  S  R  P  N  O  A  E  I  H   G
 *
 * the height of a BinaryHeap is logN
 */
public class BinaryArrayPqImpl<E extends Comparable<E>> extends ArrayPq<E> {

    public BinaryArrayPqImpl() {
        super();
    }

    public BinaryArrayPqImpl(int capacity) {
        this(capacity, null);
    }

    public BinaryArrayPqImpl(int capacity, Comparator<E> comparator) {
        super(capacity, comparator);
    }

    public BinaryArrayPqImpl(E[] array) {
        this(array, null);
    }

    public BinaryArrayPqImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    public BinaryArrayPqImpl(ICollection<E> collection) {
        this(collection, null);
    }

    public BinaryArrayPqImpl(ICollection<E> collection, Comparator<E> comparator) {
        this(collection.size(), comparator);
        Iterator<E> itr = collection.iterator();
        while (itr.hasNext()) {
            entries[size++] = itr.next();
        }
        heapify(0);
    }

    protected void heapify(int begin) {
        for (int i = (size >> 1) - 1; i >= begin; i--) {
            siftDown(i);
        }
    }

    protected void ensureCapacity(int newCap) {
        E[] newEntries = (E[]) new Comparable[newCap];
        for (int i = 0; i < size; i++) {
            newEntries[i] = entries[i];
        }
        entries = newEntries;
    }

    @Override
    protected void siftUp(int i) {
        E entry = entries[i];
        while (i > 0) {
            int pi = (i - 1) >> 1;
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
        int half = size >> 1;
        while (i < half) { // index < index of first leaf-node(number of non leaf-node)
            int mi = (i << 1) + 1;
            E child = entries[mi];
            int ri = mi + 1;
            if (ri < size && compare(entries[ri], child) > 0) {
                child = entries[mi = ri];
            }
            if (compare(root, child) >= 0) {
                break;
            }
            entries[i] = child;
            i = mi;
        }
        entries[i] = root;
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

    private class BinaryArrayPqImplIterator<E> implements Iterator<E> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return (E) entries[index++];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new BinaryArrayPqImplIterator<>();
    }

}
