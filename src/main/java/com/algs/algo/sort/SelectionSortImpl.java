package com.algs.algo.sort;

import java.util.Comparator;

public class SelectionSortImpl<E extends Comparable<E>> extends CompareAndSwapSort<E> {

    public SelectionSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        if (array.length < 2) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (compareEntry(array[j], array[min]) < 0) {
                    min = j;
                }
            }
            swap(min, i);
        }
    }

    @Override
    public E[] getArray() {
        return array;
    }

}
