package com.algs.algo.sort.array.cmp_swp.quick;

import java.util.Comparator;

/**
 * {@link #partition(int, int)}
 */
public class QuickSortIgnoreSmallArrayImpl0<E extends Comparable<E>> extends QuickSortImpl0<E> {

    public QuickSortIgnoreSmallArrayImpl0(E[] array) {
        this(array, null);
    }

    public QuickSortIgnoreSmallArrayImpl0(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        super.sort();
        insertionSort(array);
    }

    /**
     * [begin, end)
     */
    public void sort(int begin, int end) {
        if (end <= begin + insertionCutoff) {
            return;
        }
        int mid = partition(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

}
