package com.algs.datastructure.collection.heap.pq;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.node.PqNode;
import com.algs.utils.ObjectUtil;

import java.util.Comparator;
import java.util.Objects;

public class LinkedBinaryPqImpl<E extends Comparable<E>> implements IPriorityQueue<E> {

    private int size;
    private PqNode<E> root;
    private Comparator<E> comparator;

    public LinkedBinaryPqImpl() {
    }

    public LinkedBinaryPqImpl(ICollection<E> collection) {
        this(collection, null);
    }

    public LinkedBinaryPqImpl(ICollection<E> collection, Comparator<E> comparator) {
        Iterator<E> itr = collection.iterator();
        while (itr.hasNext()) {

        }
    }

    public LinkedBinaryPqImpl(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public E get() {
        if (isEmpty()) {
            return null;
        }
        return root.item;
    }

    @Override
    public E remove() {
        ObjectUtil.requireNonEmpty(this);
        return null;
    }

    @Override
    public E replace(E item) {
        return null;
    }

    @Override
    public int compare(E a, E b) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
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
    public E get(int index) {
        return null;
    }

    @Override
    public boolean contains(E item) {
        return false;
    }

    @Override
    public void add(E item) {
        ObjectUtil.requireNonNull(item);
        if (isEmpty()) {
            root = new PqNode<>(item, null, null, null);
        } else {

        }
        size++;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E remove(E item) {
        return null;
    }

    @Override
    public void clear() {
        root.item = null;
        root.left = null;
        root.right = null;
        size = 0;
    }

    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public void reverse() {
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
