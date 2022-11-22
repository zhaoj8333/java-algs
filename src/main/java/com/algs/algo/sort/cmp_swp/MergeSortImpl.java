package com.algs.algo.sort.cmp_swp;

import java.util.Comparator;

/**
 * Divide and Merge
 *
 * Comparison of:
 * {@link MergeSortTopdownImpl}
 * {@link MergeSortBottomupImpl}
 */
public abstract class MergeSortImpl<E extends Comparable<E>> extends CompareAndSwapSort<E> {

    protected final E[] aux = (E[]) new Comparable[array.length];

    public MergeSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

}
