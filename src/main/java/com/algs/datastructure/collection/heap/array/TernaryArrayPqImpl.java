package com.algs.datastructure.collection.heap.array;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.Iterator;

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
    protected void heapify(int begin) {
        for (int i = (size / 3) - 1; i >= begin; i--) {
            siftDown(i);
        }
    }

    @Override
    protected void siftUp(int i) {
        E entry = entries[i];
        while (i > 0) {
            int pi = (i - 1) / 3;
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
        int lp = size / 3;
        while (i < lp) {
            int ci = i * 3 + 1;     // index of max child
            E child = entries[ci];
            if (ci + 1 < size && compare(child, entries[ci + 1]) < 0) {
                child = entries[++ci];
            }
            if (ci + 1 < size && compare(child, entries[ci + 1]) < 0) {
                child = entries[++ci];
            }
            if (compare(root, child) >= 0) {
                break;
            }
            entries[i] = child;
            i = ci;
        }
        entries[i] = root;
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
