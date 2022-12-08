package com.algs.algo.sort.linkedlist;

import com.algs.datastructure.collection.list.linked.ISequentialAccessList;

import java.util.Comparator;

public class SinglyLinkedListSortImpl<E extends Comparable<E>> extends LinkedCompareAndSwapSort<E> {

    public SinglyLinkedListSortImpl(ISequentialAccessList<E> linkedList) {
        super(linkedList);
    }

    public SinglyLinkedListSortImpl(ISequentialAccessList<E> linkedList, Comparator<E> comparator) {
        super(linkedList, comparator);
    }

    @Override
    public void sort() {

    }

    @Override
    protected void bubbleSort() {

    }

    @Override
    protected void selectionSort() {

    }

    @Override
    protected void insertionSort() {

    }

    @Override
    protected void mergeSort() {

    }

    @Override
    protected void quickSort() {

    }
}
