package com.algs.datastructure.collection.heap.link;

import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.node.PqNode;
import com.algs.utils.ObjectUtil;

public class BinaryLinkedPqImpl<E extends Comparable<E>> extends LinkedPq<E> {

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

    @Override
    protected void siftUp(int index) {

    }

    @Override
    protected void siftDown(int index) {

    }
}
