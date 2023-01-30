package com.algs.datastructure.collection.heap.pq;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.CollectionUtil;
import com.algs.utils.ObjectUtil;

import java.util.Comparator;
import java.util.Objects;

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
public class ArrayBinaryPqImpl<E extends Comparable<E>> implements IPriorityQueue<E> {

    private int size;
    private E[] entries;
    private Comparator<E> comparator;

    public ArrayBinaryPqImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public ArrayBinaryPqImpl(int capacity) {
        this.entries = (E[]) new Comparable[capacity];
        this.comparator = null;
    }

    public ArrayBinaryPqImpl(int capacity, Comparator<E> comparator) {
        this(capacity);
        this.comparator = comparator;
    }

    public ArrayBinaryPqImpl(Comparator<E> comparator) {
        this(DefaultValues.DEFAULT_CAPACITY);
        this.comparator = comparator;
    }

    public ArrayBinaryPqImpl(ICollection<E> collection) {
        this(collection.size());
        init(collection);
        heapify();
    }

    private void init(ICollection<E> collection) {
        int index = 0;
        Iterator<E> itr = collection.iterator();
        while (itr.hasNext()) {
            entries[index++] = itr.next();
            size++;
        }
    }

    public ArrayBinaryPqImpl(ICollection<E> collection, Comparator<E> comparator) {
        this(collection.size(), comparator);
        init(collection);
        heapify();
    }

    private void heapify0() {
        for (int i = 0; i < entries.length; i++) {
            siftUp(i);
        }
    }

    private void heapify() {
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCap) {
        E[] newEntries = (E[]) new Comparable[newCap];
        for (int i = 0; i < size; i++) {
            newEntries[i] = entries[i];
        }
        entries = newEntries;
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
    public int compare(E a, E b) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

    private void siftUp(int index) {
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

    private void siftDown(int index) {
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

    private class BinaryHeapImplIterator<E> implements Iterator<E> {

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
        return new BinaryHeapImplIterator<>();
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("unsupported operation");
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
    public void reverse() {
        throw new UnsupportedOperationException("unsupported operation");
    }

}
