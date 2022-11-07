package com.algs.datastructure.collection.heap.pq;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;
import com.algs.util.ArraysUtil;
import com.algs.util.ObjectUtil;

import java.util.Comparator;
import java.util.Objects;

/**
 * Not using first entry
 * i = 1, root node
 * i > 1, index of parent node is: i/2
 *        index of child nodes are: 2i, 2i
 */
public class ArrayBinaryPqImpl0<E extends Comparable<E>> implements IPriorityQueue<E> {

    private int size;
    private E[] entries;
    private Comparator<E> comparator;

    public ArrayBinaryPqImpl0() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public ArrayBinaryPqImpl0(int capacity) {
        this.entries = (E[]) new Comparable[capacity + 1];
        this.comparator = null;
    }

    public ArrayBinaryPqImpl0(int capacity, Comparator<E> comparator) {
        this(capacity);
        this.comparator = comparator;
    }

    public ArrayBinaryPqImpl0(Comparator<E> comparator) {
        this(DefaultValues.DEFAULT_CAPACITY);
        this.comparator = comparator;
    }

    public ArrayBinaryPqImpl0(ICollection<E> collection) {
        this(collection.size());
        init(collection);
        heapify();
    }

    private void init(ICollection<E> collection) {
        Iterator<E> itr = collection.iterator();
        while (itr.hasNext()) {
            entries[++size] = itr.next();
        }
    }

    public ArrayBinaryPqImpl0(ICollection<E> collection, Comparator<E> comparator) {
        this(collection.size(), comparator);
        init(collection);
        heapify();
    }

    private void heapify() {
        for (int i = (size >> 1) - 1; i >= 1; i--) {
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
        System.arraycopy(entries, 1, newEntries, 1, size);
        entries = newEntries;
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

    private void siftUp(int index) {
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

    private void siftDown(int index) {
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

    @Override
    public int compare(E a, E b) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

    @Override
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, entries[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        ArraysUtil.fill(entries, null);
        size = 0;
    }

    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<E> itr = iterator();
        sb.append("{ ");
        while (itr.hasNext()) {
            sb.append(itr.next()).append(',');
        }
        sb.append(" }");
        return sb.toString();
    }

    private class BinaryHeapImpl0Iterator<E> implements Iterator<E> {

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
        return new BinaryHeapImpl0Iterator<>();
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
