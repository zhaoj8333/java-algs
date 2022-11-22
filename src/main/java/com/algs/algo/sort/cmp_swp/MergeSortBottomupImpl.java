package com.algs.algo.sort.cmp_swp;

import java.util.Comparator;

public class MergeSortBottomupImpl<E extends Comparable<E>> extends MergeSortImpl<E> {

    protected final E[] aux = (E[]) new Comparable[array.length];

    public MergeSortBottomupImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    /**
     * merge:
     * sz == 1:  (0, 2), (2, 4), (4, 6), (6, 8), (8, 10), (10, 12)
     * sz == 2:  (0, 4), (4, 8), (8, 12)
     * sz == 4:  (0, 8), (8, 16)
     * sz == 8:  (0, 16)
     */
    @Override
    public void sort() {
        int len = array.length;
        for (int sz = 1; sz < len; sz = sz + sz) {
            for (int begin = 0; begin < len; begin += sz + sz) {
                int end = begin + sz + sz;
                int mid = (begin + end) >> 1;
                merge(begin, mid, Math.min(end, len));
            }
        }
    }

    /**
     * merge: [begin, end)
     *  [begin, mid)
     *  [mid, end)
     */
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
