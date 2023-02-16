package com.algs.datastructure.collection.heap.link;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.stack.ArrayStackImpl;
import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.node.BinaryPqNode;
import com.algs.utils.ObjectUtil;

// TODO: 2/4/23  
public class BinaryLinkedPqImpl<E extends Comparable<E>> extends LinkedPq<E> {

    private BinaryPqNode<E> root = new BinaryPqNode<>(null);

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return root.value;
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
    public E get(int i) {
        return null;
    }

    @Override
    public boolean contains(E item) {
        return false;
    }

    @Override
    public void add(E item) {
        ObjectUtil.requireNonNull(item);
        BinaryPqNode<E> node = new BinaryPqNode<>(item);
        int pi = size >> 1;
        IStack<Integer> paths = indexToPath(pi);
        Iterator<Integer> itr = paths.iterator();
        while (itr.hasNext()) {
            Integer index = paths.pop();
            
        }
        size++;
    }

    private IStack<Integer> indexToPath(final int i) {
        IStack<Integer> stack = new ArrayStackImpl<>();
        int index = i;
        while (index > -1) {
            stack.push(index);
            index = (i - 1) / 2;
        }
        return stack;
    }

    @Override
    public E remove(int i) {
        return null;
    }

    @Override
    public E remove(E item) {
        return null;
    }

    @Override
    public void clear() {
        root.value = null;
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
