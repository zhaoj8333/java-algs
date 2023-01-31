package com.algs.datastructure.collection.heap.array;

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
        super();
    }

    public BinaryArrayPqSentinelImpl(int capacity) {
        super(capacity + 1, null);
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
    public void add(E item) {
        ObjectUtil.requireNonNull(item);
        if (size == entries.length - 1) {
            resize(size << 1);
        }
        entries[++size] = item;
        siftUp(size);
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
        entries[1] = entries[size];
        entries[size--] = null;
        siftDown(1);
        return entry;
    }

    @Override
    protected void siftUp(int index) {
        E entry = entries[index];
        while (index > 1) {
            int pIndex = index / 2;
            if (compare(entry, entries[pIndex]) <= 0) {
                break;
            }
            entries[index] = entries[pIndex];
            index = pIndex;
        }
        entries[index] = entry;
    }

    protected void siftDown(int index) {
        E entry = entries[index];
        int half = size >> 1;
        while (index <= half) {
            int childIndex = index << 1;
            E maxChild = entries[childIndex];
            if (childIndex + 1 <= size && compare(entries[childIndex], entries[childIndex + 1]) < 0) {
                maxChild = entries[++childIndex];
            }
            if (compare(entry, maxChild) >= 0) {
                break;
            }
            entries[index] = maxChild;
            index = childIndex;
        }
        entries[index] = entry;
    }

    @Override
    public E replace(E item) {
        ObjectUtil.requireNonNull(item);
        E root;
        if (size == 0) {
            entries[1] = item;
            size = 1;
            root = item;
        } else {
            root = entries[1];
            entries[1] = item;
            siftDown(1);
        }
        return root;
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
