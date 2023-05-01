package com.algs.algo.sort.array.cmp_swp.merge;

import com.algs.algo.sort.array.cmp_swp.ArrayCompareAndSwapSort;
import java.util.Comparator;

/**
 * Divide and Merge
 *
 * Comparison of:
 * {@link MergeSortTdImpl}
 * {@link MergeSortBuImpl}
 */
public abstract class MergeSortImpl<E extends Comparable<E>> extends ArrayCompareAndSwapSort<E> {

    protected final E[] aux = (E[]) new Comparable[array.length];

    public MergeSortImpl(E[] array) {
        this(array, null);
    }

    public MergeSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

}
