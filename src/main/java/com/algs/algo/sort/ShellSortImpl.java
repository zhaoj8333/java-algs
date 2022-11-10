package com.algs.algo.sort;

import java.util.Comparator;

/**
 * Diminishing Increment Sort
 *
 * {@link ShellSortImpl}: reduce the number of Inversion, is improved version of {@link InsertionSortImpl}
 */
public class ShellSortImpl<E extends Comparable<E>> extends CompareAndSwapSort<E> {

    public ShellSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {

    }

}
