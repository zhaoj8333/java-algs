package com.algs.algo.sort.array.cmp_swp.merge;

import java.util.Comparator;

public class MergeSortBuOptmImpl<E extends Comparable<E>> extends MergeSortBuImpl<E> {

    public MergeSortBuOptmImpl(E[] array) {
        this(array, null);
    }

    public MergeSortBuOptmImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    /**
     * [begin, mid)
     * [mid, end)
     * 1. Optimization - Skip merge if the array is already in order
     *    will reduce the calls of {@link #merge(int, int, int)}, thus reduce the array access,
     *    but will still maintain the number of comparison
     *
     * 2. Use Insertion sort for small arrays
     *    Insertion sort can be faster for small arrays, but have to fine tune the threshold,
     *    if the threshold is too big, the number of comparisons, and array access can significantly larger
     *      {0, 1, 2, 3, 4,   5, 6, 7, 8, 9,   10, 11, 12}
     *      --------------    -------------    ------------
     *      begin       end
     *    The reduce of array access and comparison are not significant, but can reduce the array copy in merge
     *
     * 3. // TODO: 11/30/22 Copy once
     */
    @Override
    public void sort() {
        int sz = insertionSortThreshold;
        for (int begin = 0; begin < array.length; begin += sz) {
            int end = Math.min(array.length, begin + sz);
            insertionSort(array, begin, end);
        }
        if (insertionSortThreshold >= array.length) {
            return;
        }
        for (; sz < array.length; sz = sz + sz) {
            for (int begin = 0; begin < array.length; begin += sz + sz) {
                int end = Math.min(begin + (sz << 1), array.length);
                int mid = Math.min(begin + sz, array.length - 1);
                if (compareIndex(mid - 1, mid) > 0) {
                    merge(begin, mid, end);
                }
            }
        }
    }

}
