package com.algs.datastructure.collection.heap.array;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;

import java.util.Comparator;

public class TernaryArrayPqImpl<E extends Comparable<E>> extends ArrayPq<E> {

    public TernaryArrayPqImpl() {
        super();
    }

    public TernaryArrayPqImpl(int capacity) {
        this(capacity, null);
    }

    public TernaryArrayPqImpl(int capacity, Comparator<E> comparator) {
        super(capacity, comparator);
    }

    public TernaryArrayPqImpl(E[] array) {
        this(array, null);
    }

    public TernaryArrayPqImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    public TernaryArrayPqImpl(ICollection<E> collection) {
        this(collection, null);
    }

    public TernaryArrayPqImpl(ICollection<E> collection, Comparator<E> comparator) {
        this(collection.size(), comparator);
        Iterator<E> itr = collection.iterator();
        while (itr.hasNext()) {
            entries[size++] = itr.next();
        }
        heapify(0);
    }

    @Override
    protected void heapify(int i) {

    }

    @Override
    protected void siftUp(int i) {

    }

    @Override
    protected void siftDown(int i) {

    }

    @Override
    public E get() {
        return null;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E replace(E item) {
        return null;
    }

    @Override
    public boolean contains(E item) {
        return false;
    }

    @Override
    public void add(E item) {

    }

    @Override
    public void clear() {

    }

    private class TernaryArrayPqImplIterator<E> implements Iterator<E> {

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
        return new TernaryArrayPqImplIterator<>();
    }

}
