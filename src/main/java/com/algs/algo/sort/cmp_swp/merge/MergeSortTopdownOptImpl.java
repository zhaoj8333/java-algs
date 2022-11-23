package com.algs.algo.sort.cmp_swp.merge;

import java.util.Comparator;

public class MergeSortTopdownOptImpl<E extends Comparable<E>> extends MergeSortTopdownImpl<E> {

    public MergeSortTopdownOptImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        if (array.length == 1) {
            return;
        }
//        sort(0, array.length);
//        sort1(0, array.length);
        sort2();
    }

    /**
     * // TODO: 11/23/22  
     */
    private void sort2() {
        // Optimization #3 - copy once only, Eliminate the copy to the auxiliary array on merge
        for (int i = 0; i < array.length; i++) {
            aux[i] = array[i];
        }
        sort2(aux, array, 0, array.length - 1);
    }

    private void sort2(E[] array, E[] aux, int begin, int end) {
        if (end <= begin) {
            return;
        }
        // Optimization #2 - Use InsertionSort for small arrays
//        if (end - begin <= useInsertThreshold) {
//            insertionSort(aux, begin, end + 1);
//            return;
//        }
        int mid = (begin + end) >> 1;
        sort2(aux, array, begin, mid);
        sort2(aux, array, mid + 1, end);
        // Optimization #1 - Skip merge if the array is already in order
//        if (compareEntry(array[mid], array[mid + 1]) <= 0) {
//            return;
//        }
        merge(array, aux, begin, mid, end);
    }

    private void merge(E[] array, E[] aux, int begin, int mid, int end) {
        int li = begin, ri = mid + 1;
        for (int i = begin; i <= end; i++) {
            if (li > mid) {
                aux[i] = array[ri++];
            } else if (ri > end) {
                aux[i] = array[li++];
            } else if (compareEntry(array[li], array[ri]) <= 0) {
                aux[i] = array[li++];
            } else {
                aux[i] = array[ri++];
            }
        }
    }

    private void sort1(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        if (end - begin < useInsertThreshold) {
            insertionSort(array, begin, end);
            return;
        }
        int mid = (begin + end) >> 1;
        sort1(begin, mid);
        sort1(mid, end);
        if (compareIndex(mid - 1, mid) > 0) {
            merge(begin, mid, end);
        }
    }

    /**
     *   begin    mid      end
     *   0        3        6
     *   0, 1, 2, 3, 4, 5
     *
     * if the array is already sorted, merge can be skipped, so the compare time would be linear compare operations
     */
    protected void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        if (compareIndex(mid - 1, mid) > 0) {
            merge(begin, mid, end);
        }
    }

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

    private void sort0(int begin, int end) {
        if (end <= begin) {
            return;
        }
        int mid = (end + begin) >> 1;
        sort0(begin, mid);
        sort0(mid + 1, end);
        merge0(begin, mid, end);
    }

    private void merge0(int begin, int mid, int end) {
        int m = begin, n = mid + 1;
        for (int i = begin; i <= end; i++) {
            aux[i] = array[i];
        }
        for (int i = begin; i <= end; i++) {
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
