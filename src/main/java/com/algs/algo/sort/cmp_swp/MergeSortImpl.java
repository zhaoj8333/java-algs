package com.algs.algo.sort;

import java.util.Comparator;

/**
 * Devide and Merge
 *
 * Comparison of:
 * {@link MergeSortTopdownImpl}
 * {@link MergeSortBottomupImpl}
 */
public abstract class MergeSortImpl<E extends Comparable<E>> extends CompareAndSwapSort<E> {

    protected final E[] aux = (E[]) new Comparable[array.length >> 1];

    public MergeSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

}
