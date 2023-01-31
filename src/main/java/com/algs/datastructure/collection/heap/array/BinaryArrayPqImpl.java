package com.algs.datastructure.collection.heap.array;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;
import com.algs.utils.ObjectUtil;

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

    @Override
    public void add(E item) {
        ObjectUtil.requireNonNull(item);
        if (size >= entries.length) {
            resize(size << 1);
        }
        entries[size++] = item;
        siftUp(size - 1);
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
        int lastIndex = --size;
        entries[0] = entries[lastIndex];
        entries[lastIndex] = null;
        siftDown(0);
        return entry;
    }

    @Override
    protected void siftUp(int index) {
        E entry = entries[index];
        while (index > 0) {
            int pIndex = (index - 1) >> 1;
            E parent = entries[pIndex];
            if (compare(entry, parent) <= 0) {
                break;
            }
            entries[index] = parent;
            index = pIndex;
        }
        entries[index] = entry;
    }

    @Override
    protected void siftDown(int index) {
        E root = entries[index];
        int half = size >> 1;
        while (index < half) { // index < index of first leaf-node(number of non leaf-node)
            int maxIndex = (index << 1) + 1;
            E maxChild = entries[maxIndex];
            int rightIndex = maxIndex + 1;
            if (rightIndex < size && compare(entries[rightIndex], maxChild) > 0) {
                maxChild = entries[maxIndex = rightIndex];
            }
            if (compare(root, maxChild) >= 0) {
                break;
            }
            entries[index] = maxChild;
            index = maxIndex;
        }
        entries[index] = root;
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
