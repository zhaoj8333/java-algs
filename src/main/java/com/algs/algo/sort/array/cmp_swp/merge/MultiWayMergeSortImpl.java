package com.algs.algo.sort.array.cmp_swp.merge;

import com.algs.algo.sort.array.cmp_swp.ArrayCompareAndSwapSort;

import java.util.Comparator;

// TODO: 12/13/22  
public class MultiWayMergeSortImpl<E extends Comparable<E>> extends ArrayCompareAndSwapSort<E> {

    private final int way;

    public MultiWayMergeSortImpl(E[] array, Comparator<E> comparator) {
        this(array, comparator, 2);
    }

    public MultiWayMergeSortImpl(E[] array, Comparator<E> comparator, int way) {
        super(array, comparator);
        this.way = way;
    }

    @Override
    public void sort() {
        if (array.length == 1) {
            return;
        }
        sort0();
    }

    private void sort0() {

    }
}
