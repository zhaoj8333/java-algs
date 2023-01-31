package com.algs.datastructure.collection.heap.link;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.heap.array.IPriorityQueue;
import com.algs.datastructure.node.PqNode;

import java.util.Comparator;
import java.util.Objects;

public abstract class LinkedPq<E extends Comparable<E>> implements IPriorityQueue<E> {

    protected int size;
    protected PqNode<E> root;
    protected Comparator<E> comparator;

    public LinkedPq() {
    }

    public LinkedPq(ICollection<E> collection) {
        this(collection, null);
    }

    public LinkedPq(ICollection<E> collection, Comparator<E> comparator) {
        Iterator<E> itr = collection.iterator();
        while (itr.hasNext()) {

        }
    }

    public LinkedPq(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    protected abstract void siftUp(int index);

    protected abstract void siftDown(int index);

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int compare(E a, E b) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

}
