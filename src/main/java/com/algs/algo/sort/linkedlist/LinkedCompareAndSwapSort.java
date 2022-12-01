package com.algs.algo.sort.linkedlist;

import com.algs.algo.sort.ISortable;
import com.algs.datastructure.collection.list.linked.ILinkedList;

import java.util.Comparator;
import java.util.Objects;

public abstract class LinkedCompareAndSwapSort<E extends Comparable<E>> implements ISortable<E> {

    private final ILinkedList<E> linkedList;
    private final Comparator<E> comparator;

    public LinkedCompareAndSwapSort(ILinkedList<E> linkedList) {
        this(linkedList, null);
    }

    public LinkedCompareAndSwapSort(ILinkedList<E> linkedList, Comparator<E> comparator) {
        this.linkedList = linkedList;
        this.comparator = comparator;
    }

    protected int compareIndex(int i, int j) {
        return compareEntry(linkedList.node(i).getValue(), linkedList.node(j).getValue());
    }

    protected int compareEntry(E a, E b) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

    protected void swap() {

    }

    protected abstract void bubbleSort();
    protected abstract void selectionSort();
    protected abstract void insertionSort();
    protected abstract void mergeSort();
    protected abstract void quickSort();

}
