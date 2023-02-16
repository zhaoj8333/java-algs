package com.algs.datastructure.collection.stack;

import com.algs.DefaultValues;
import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.Iterator;
import com.algs.utils.array.ArraysUtil;
import com.algs.utils.CollectionUtil;

import java.util.Comparator;
import java.util.Objects;

public class StackImplByPq<E extends Comparable<E>> implements IStack<E> {

    private int size;
    private E[] entries;
    private final Comparator<E> comparator;

    public StackImplByPq() {
        this(DefaultValues.DEFAULT_CAPACITY, null);
    }

    public StackImplByPq(int size) {
        this(size, null);
    }

    public StackImplByPq(int size, Comparator<E> comparator) {
        this.size = size;
        this.entries = (E[]) new Comparable[size];
        this.comparator = comparator;
    }

    public StackImplByPq(ICollection<E> collection, Comparator<E> comparator) {
        this.size = collection.size();
        this.entries = (E[]) new Comparable[size];
        this.comparator = comparator;
        Iterator<E> itr = collection.iterator();
        int index = 0;
        while (itr.hasNext()) {
            this.entries[index++] = itr.next();
        }
        heapify();
    }

    private void heapify() {
        for (int i = (size >> 1) - 1; i >= 1; i--) {
            siftDown(i);
        }
    }

    private void siftDown(int index) {
        E entry = entries[index];
        while (index < size) {
            int childIndex = index << 1;
            E child = entries[childIndex];
            if (compare(child, entries[childIndex + 1]) > 0) {
                child = entries[++childIndex];
            }
            if (compare(entry, child) > 0) {
                break;
            }
            entries[index] = child;
            index = childIndex;
        }
        entries[index] = entry;
    }

    private int compare(E a, E b) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

    @Override
    public void push(E item) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E top() {
        return null;
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
    public boolean contains(E item) {
        return ArraysUtil.contains(entries, item);
    }

    @Override
    public E[] toArray() {
        return CollectionUtil.toArray(this);
    }

    @Override
    public Iterator<E> iterator() {
        return new StackImplByPqIterator<>();
    }

    @Override
    public Iterator<E> reverseIterator() {
        return null;
    }

    private static class StackImplByPqIterator<E> implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }

    @Override
    public void reverse() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public E get(int i) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public void add(E item) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public E remove(int i) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public E remove(E item) {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("UnsupportedOperation");
    }

}
