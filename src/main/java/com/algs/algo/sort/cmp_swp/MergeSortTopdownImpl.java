package com.algs.algo.sort;

import java.util.Comparator;

public class MergeSortTopdownImpl<E extends Comparable<E>> extends MergeSortImpl<E> {

    public MergeSortTopdownImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
//        sort(0, array.length - 1);
        sort0(0, array.length);
    }

    /**
     * sort array[]: [begin, end), begin <= index < end
     */
    private void sort0(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = (begin + end) >> 1;
        sort0(begin, mid);
        sort0(mid, end);
        merge0(begin, mid, end);
    }

    /**
     * merge: [begin, mid) and [mid, end)
     */
    protected void merge0(int begin, int mid, int end) {
        int li = 0, ri = mid, ai = begin;
        for (int i = li; i < mid - begin; i++) {
            aux[i] = array[begin + i];
        }
        while (li < mid - begin) {
            if (ri < end && compareEntry(aux[li], array[ri]) > 0) {
                array[ai++] = array[ri++];
            } else {
                array[ai++] = aux[li++];
            }
        }
    }

    /**
     * [0, array.length - 1]
     *
     * [begin, end]
     */
    private void sort(int begin, int end) {
        if (end <= begin) {
            return;
        }
        int mid = (end + begin) >> 1;
        sort(begin, mid);
        sort(mid + 1, end);
        merge(begin, mid, end);
    }

    /**
     *          0          5          10
     * left[]:  E O R S T  X  A E L M P
     *          m             n
     *                    mid
     */
    private void merge(int begin, int mid, int end) {
        int m = begin, n = mid + 1;
        for (int i = begin; i <= end; i++) {
            aux[i] = array[i];
        }
        for (int i = begin; i <= end; i++) {
            // should check index first, then compare elements
            if (m > mid) {
                array[i] = aux[n++];
            } else if (n > end) {
                array[i] = aux[m++];
            } else if (compareEntry(aux[m], aux[n]) > 0) {
                array[i] = aux[n++];
            } else {
                array[i] = aux[m++];
            }
        }
    }
}
