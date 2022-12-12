package com.algs.algo.sort.linkedlist;

import com.algs.algo.sort.ISortable;
import com.algs.datastructure.collection.list.linked.ISequentialAccessList;
import com.algs.datastructure.collection.node.LinkNode;

import java.util.Comparator;
import java.util.Objects;

public abstract class LinkedCompareAndSwapSort<E extends Comparable<E>> implements ISortable<E> {

    protected final ISequentialAccessList<E> list;
    protected final Comparator<E> comparator;

    public LinkedCompareAndSwapSort(ISequentialAccessList<E> linkedList) {
        this(linkedList, null);
    }

    public LinkedCompareAndSwapSort(ISequentialAccessList<E> linkedList, Comparator<E> comparator) {
        this.list = linkedList;
        this.comparator = comparator;
    }

    public ISequentialAccessList<E> getList() {
        return list;
    }

    protected int compareNode(LinkNode<E> a, LinkNode<E> b) {
        E aVal = a.getValue();
        E bVal = b.getValue();
        return Objects.nonNull(comparator) ? comparator.compare(aVal, bVal) : aVal.compareTo(bVal);
    }

    protected int compareEntry(E a, E b) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

    protected abstract void swap(LinkNode<E> a, LinkNode<E> b);

    public abstract void bubbleSort();

    public abstract void selectionSort();

    public abstract void insertionSort();

    public abstract void mergeSort();

    public abstract void quickSort();

}
