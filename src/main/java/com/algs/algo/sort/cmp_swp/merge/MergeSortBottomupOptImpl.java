package com.algs.algo.sort.cmp_swp.merge;

import java.util.Comparator;

public class MergeSortBottomupOptImpl<E extends Comparable<E>> extends MergeSortBottomupImpl<E> {

    public MergeSortBottomupOptImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    /**
     *   begin    mid      end
     *   0        3        6
     *   0, 1, 2, 3, 4, 5
     *
     * // TODO: 11/23/22: if the array is already sorted, merge can be skipped, so the compare time would be linear compare operations
     */
    @Override
    public void sort() {
        if (array.length == 1) {
            return;
        }
        for (int sz = 1; sz < array.length; sz = sz + sz) {
            for (int begin = 0; begin < array.length; begin += sz + sz) {
                int end = Math.min(begin + (sz << 1), array.length);
                int mid = begin + sz;
                merge(begin, mid, end);
            }
        }
    }

    private void merge(int begin, int mid, int end) {
        int l = begin, r = mid;
        for (int i = begin; i < end; i++) {
            aux[i] = array[i];
        }
        for (int i = begin; i < end; i++) {
            if (l >= mid) {
                array[i] = aux[r++];
            } else if (r >= end) {
                array[i] = aux[l++];
            } else if (compareEntry(aux[l], aux[r]) > 0) {
                array[i] = aux[r++];
            } else {
                array[i] = aux[l++];
            }
        }
    }

}
