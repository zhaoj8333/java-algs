package com.algs.datastructure.collection.heap.link;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.heap.array.IPriorityQueue;
import com.algs.datastructure.node.BinaryPqNode;
import com.algs.utils.ObjectUtil;
import java.util.Comparator;
import java.util.Objects;

public abstract class LinkedPq<E extends Comparable<E>> implements IPriorityQueue<E> {

    protected int size;
    protected BinaryPqNode<E> root;
    protected Comparator<E> comparator;

    public LinkedPq() {
        this((ICollection<E>) null);
    }

    public LinkedPq(E[] array) {
        this(array, null);
    }

    public LinkedPq(E[] array, Comparator<E> comparator) {
        ObjectUtil.requireNonNull(array);
        for (E entry : array) {
            add(entry);
        }
        this.comparator = comparator;
    }

    public LinkedPq(ICollection<E> collection) {
        this(collection, null);
    }

    public LinkedPq(ICollection<E> collection, Comparator<E> comparator) {
        ObjectUtil.requireNonNull(collection);
        if (!collection.isEmpty()) {
            Iterator<E> itr = collection.iterator();
            while (itr.hasNext()) {
                add(itr.next());
            }
        }
        this.comparator = comparator;
    }

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
