package com.algs.algo.sort.array.cmp_swp.merge;

import java.util.Comparator;

public class MergeSortTdOptmImpl<E extends Comparable<E>> extends MergeSortTdImpl<E> {

    public MergeSortTdOptmImpl(E[] array) {
        this(array, null);
    }

    public MergeSortTdOptmImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        for (int i = 0; i < array.length; i++) {
            aux[i] = array[i];
        }
        sort(aux, array, 0, array.length - 1);
    }

    private void sort(E[] array, E[] aux, int begin, int end) {
        // Optimization #2 - Use InsertionSort for small arrays
        if (end - begin < insertionSortThreshold) {
            insertionSort(aux, begin, end + 1);
            return;
        }
        int mid = (begin + end) >> 1;
        sort(aux, array, begin, mid);
        sort(aux, array, mid + 1, end);
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

    /*
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
    */

}
