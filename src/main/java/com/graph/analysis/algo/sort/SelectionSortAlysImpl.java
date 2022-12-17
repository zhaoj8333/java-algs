package com.graph.analysis.algo.sort;

import java.util.Comparator;

public class SelectionSortAlysImpl<E extends Comparable<E>> extends CompareAndSwapSortAlys<E> {

    public SelectionSortAlysImpl(E[] array) {
        this(array, null);
    }

    public SelectionSortAlysImpl(E[] data, Comparator<E> comparator) {
        super(data, comparator);
    }

    @Override
    public void sort() {
        int len = array.length;
        if (len < 2) {
            cost++;
            return;
        }
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                cost ++;
                if (compareEntry(array[min], array[j]) > 0) {
                    min = j;
                    cost++;
                }
            }
            swap(min, i);
        }
    }

}
