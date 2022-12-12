package com.algs.algo.sort.array.cmp_swp.merge;

import com.algs.algo.sort.array.cmp_swp.ArrayCompareAndSwapSort;

import java.util.Comparator;

public class MultiWayMergeSortImpl<E extends Comparable<E>> extends ArrayCompareAndSwapSort<E> {

    private int way = 2;

    public MultiWayMergeSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    public MultiWayMergeSortImpl(E[] array, Comparator<E> comparator, int way) {
        super(array, comparator);
        this.way = way;
    }

}
