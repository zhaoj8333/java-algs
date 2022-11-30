package com.graph.analysis.algo.sort.merge;

import com.algs.util.SortUtil;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public class MergeSortTdOptmAlysImpl<E extends Comparable<E>> extends MergeSortTdAlysImpl<E> {

    public MergeSortTdOptmAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    /**
     * [begin, mid)
     * [mid, end)
     * 1. Optimization - Skip merge if the array is already in order
     *    will reduce the calls of {@link #merge0(int, int, int)}, thus reduce the array access,
     *    but will still maintain the number of comparison
     *
     * 2. Use Insertion sort for small arrays
     *    Insertion sort can be faster for small arrays, but have to fine tune the threshold,
     *    if the threshold is too big, the number of comparisons, and array access can significantly larger
     *
     * 3. Copy once: can reduce the array access times to less than 4.5 * N * logN, compare times will
     *    increase a little bit
     */
    @Override
    public void sort() {
        // #3 Copy once
        for (int i = 0; i < array.length; i++) {
            aux[i] = array[i];
            arrayAcc += 2;
        }

//        sort0(0, array.length);
//        sort1(0, array.length - 1);
        sort2(aux, array, 0, array.length - 1);

        Assertions.assertTrue(SortUtil.isSorted(array));
    }

    private void sort2(E[] array, E[] aux, int begin, int end) {
        if (begin >= end) {
            return;
        }
//        if (end - begin < 8) {
//            insertionSort(aux, begin, end + 1);
//            return;
//        }
        int mid = (begin + end) >> 1;
        sort2(aux, array, begin, mid);
        sort2(aux, array, mid + 1, end);
//        if (compareIndex(mid - 1, mid) > 0) {
//        }
        merge(array, aux, begin, mid, end);
    }

    /**
     * array: {0, 1, 2, 3, 4, 5, 6, 7}
     * aux :  {0, 1, 2, 3, 4, 5, 6, 7}
     *         i        mid         end
     *                     j
     */
    private void merge(E[] array, E[] aux, int begin, int mid, int end) {
        int i = begin, j = mid + 1;
        for (int k = begin; k <= end; k++) {
            if (i > mid) {
                aux[k] = array[j++];
            } else if (j > end) {
                aux[k] = array[i++];
            } else if (compareEntry(array[i], array[j]) > 0) {
                arrayAcc += 2;
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
            arrayAcc += 2;
        }
    }

    private void sort0(int begin, int end) {
//        if (end - begin < 2) {
//            return;
//        }
        // # 2
        if (end - begin < 7) {
            insertionSort(array, begin, end);
            return;
        }
        int mid = (end + begin) >> 1;
        sort0(begin, mid);
        sort0(mid, end);
        // # 1
        if (compareIndex(mid - 1, mid) > 0) {
            merge0(begin, mid, end);
        }
    }

    private final E[] aux1 = (E[]) new Comparable[array.length];

    private void sort1(int begin, int end) {
        if (end <= begin) {
            return;
        }
        int mid = (begin + end) >> 1;
        sort1(begin, mid);
        sort1(mid + 1, end);
        merge10(begin, mid, end);
    }

    private void merge1(int begin, int mid, int end) {
        int i = begin, j = mid + 1;
        for (int m = begin; m <= end; m++) {
            aux1[m] = array[m];
            arrayAcc += 2;
        }
        for (int m = begin; m <= end; m++) {
            if (i > mid) {
                array[m] = aux1[j++];
            } else if (j > end) {
                array[m] = aux1[i++];
            } else if (compareEntry(aux1[i], aux1[j]) > 0) {
                arrayAcc += 2;
                array[m] = aux1[j++];
            } else {
                array[m] = aux1[i++];
            }
            arrayAcc += 2;
        }
    }

    private E[] aux10 = (E[]) new Comparable[(array.length + 1) >> 1];

    private void merge10(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid + 1, ai = begin;
        for (int m = li; m <= le; m++) {
            aux10[m] = array[m + begin];
            arrayAcc += 2;
        }
        while (li <= le) {
            if (ri <= end && compareEntry(array[ri], aux10[li]) < 0) {
                arrayAcc += 2;
                array[ai++] = array[ri++];
            } else {
                array[ai++] = aux10[li++];
            }
            arrayAcc += 2;
        }
   }

}