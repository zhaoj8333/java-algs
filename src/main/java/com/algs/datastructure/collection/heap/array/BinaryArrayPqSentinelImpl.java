package com.algs.datastructure.collection.heap.array;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;
import com.algs.utils.ObjectUtil;
import com.algs.utils.array.ArraysUtil;

import java.util.Comparator;

/**
 * Sentinel: keep first entry for nothing use
 * i = 1, root node
 * i > 1, index of parent node is: i/2
 *        index of child nodes are: 2i, 2i
 */
public class BinaryArrayPqSentinelImpl<E extends Comparable<E>> extends ArrayPq<E> {

    public BinaryArrayPqSentinelImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public BinaryArrayPqSentinelImpl(int capacity) {
        this(capacity, null);
    }

    public BinaryArrayPqSentinelImpl(int capacity, Comparator<E> comparator) {
        super(capacity + 1, comparator);
    }

    public BinaryArrayPqSentinelImpl(E[] array) {
        this(array, null);
    }

    public BinaryArrayPqSentinelImpl(E[] array, Comparator<E> comparator) {
        this(array.length, comparator);
        ObjectUtil.requireNonNullElement(array);
        ArraysUtil.copyAll(array, entries, 0, 1, array.length);
        size = array.length;
        for (int i = (size >> 1) - 1; i >= 1; i--) {
            siftDown(i);
        }
    }

    public BinaryArrayPqSentinelImpl(ICollection<E> collection) {
        this(collection, null);
    }

    public BinaryArrayPqSentinelImpl(ICollection<E> collection, Comparator<E> comparator) {
        this(collection.size() + 1, comparator);
        Iterator<E> itr = collection.iterator();
        int i = 1;
        while (itr.hasNext()) {
            entries[i++] = itr.next();
        }
        size = collection.size();
        heapify(1);
    }

    @Override
    protected void heapify(int begin) {
        for (int i = (size >> 1) - 1; i >= begin; i--) {
            siftDown(i);
        }
    }

    protected void ensureCapacity(int newCap) {
        E[] newEntries = (E[]) new Comparable[newCap];
        for (int i = 1; i < size + 1; i++) {
            newEntries[i] = entries[i];
        }
        entries = newEntries;
    }

    @Override
    protected void siftUp(int i) {
        E entry = entries[i];
        while (i > 1) {
            int pi = i / 2;
            if (compare(entry, entries[pi]) <= 0) {
                break;
            }
            entries[i] = entries[pi];
            i = pi;
        }
        entries[i] = entry;
    }

    protected void siftDown(int i) {
        E entry = entries[i];
        int half = size >> 1;
        while (i <= half) {
            int ci = i << 1;
            E child = entries[ci];
            if (ci + 1 <= size && compare(entries[ci], entries[ci + 1]) < 0) {
                child = entries[++ci];
            }
            if (compare(entry, child) >= 0) {
                break;
            }
            entries[i] = child;
            i = ci;
        }
        entries[i] = entry;
    }

    @Override
    public boolean contains(E item) {
        return ArraysUtil.contains(entries, item, 1, size);
    }

    @Override
    public E get() {
        ObjectUtil.requireNonEmpty(this);
        return entries[1];
    }

    @Override
    public E remove() {
        ObjectUtil.requireNonEmpty(this);
        E entry = entries[1];
        int li = --size + 1;
        entries[1] = entries[li];
        entries[li] = null;
        siftDown(1);
        return entry;
    }

    @Override
    public E replace(E item) {
        ObjectUtil.requireNonNull(item);
        E root = null;
        if (size == 0) {
            entries[1] = item;
            size++;
        } else {
            root = entries[1];
            entries[1] = item;
            siftDown(1);
        }
        return root;
    }

    @Override
    public void add(E item) {
        ObjectUtil.requireNonNull(item);
        if (size >= entries.length - 1) {
            ensureCapacity((size << 1) + 1);
        }
        entries[++size] = item;
        siftUp(size);
    }

    @Override
    public void clear() {
        ArraysUtil.fill(entries, 1, size, null);
        size = 0;
    }

    private class BinaryArrayPqSentinelImplIterator<E> implements Iterator<E> {

        private int index = 1;

        @Override
        public boolean hasNext() {
            return index <= size;
        }

        @Override
        public E next() {
            return (E) entries[index++];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new BinaryArrayPqSentinelImplIterator<>();
    }

}
