package com.algs.algo.sort.array.cmp_swp.merge;

import com.algs.algo.sort.array.cmp_swp.ArrayCompareAndSwapSort;

import java.util.Comparator;

// TODO: 12/16/22  
public class ExternalSortingImpl<E extends Comparable<E>> extends ArrayCompareAndSwapSort<E> {

    public ExternalSortingImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

}
