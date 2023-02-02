package com.algs.datastructure.collection.heap.array;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;

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
        while (i < half) { // i < index of first leaf-node(number of non leaf-node)
            int ci = (i << 1) + 1;
            E child = entries[ci];
            int ri = ci + 1;
            if (ri < size && compare(entries[ri], child) > 0) {
                child = entries[ci = ri];
            }
            if (compare(root, child) >= 0) {
                break;
            }
            entries[i] = child;
            i = ci;
        }
        entries[i] = root;
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
