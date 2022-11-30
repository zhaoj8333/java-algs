package com.algs.algo.sort.cmp_swp.merge;

import java.util.Comparator;

public class MergeSortTdImpl<E extends Comparable<E>> extends MergeSortImpl<E> {

    public MergeSortTdImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        if (array.length == 1) {
            return;
        }
        sort0(0, array.length - 1);
//        sort(0, array.length);
    }

    /**
     * sort array[]: [begin, end), begin <= index < end
     */
    protected void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    /**
     * merge: [begin, mid) and [mid, end)
     */
    protected void merge(int begin, int mid, int end) {
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
    private void sort0(int begin, int end) {
        if (end <= begin) {
            return;
        }
        int mid = (end + begin) >> 1;
        sort0(begin, mid);
        sort0(mid + 1, end);
        merge0(begin, mid, end);
//        fastMerge(begin, mid, end);
    }

    /**
     *          0          5          10
     * left[]:  E O R S T  X  A E L M P
     *          m             n
     *                    mid
     */
    private void merge0(int begin, int mid, int end) {
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

    /**
     * Copy the right half of array in a reversed order to aux
     * This can avoid the test of the right has been exhausted from the inner loop
     *
     * This may cause unstable sorting
     */
    private void fastMerge(int begin, int mid, int end) {
        int auxIndex = begin;
        for (int i = begin; i <= mid; i++) {
            aux[auxIndex++] = array[i];
        }
        for (int i = end; i > mid; i--) {
            aux[auxIndex++] = array[i];
        }
        int li = begin, ri = end, ai = begin;
        while (li <= mid) {
            if (compareEntry(aux[li], aux[ri]) <= 0) {
                array[ai++] = aux[li++];
            } else {
                array[ai++] = aux[ri--];
            }
        }
    }

}
