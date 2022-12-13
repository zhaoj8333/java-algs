package com.graph.analysis.algo.sort.merge;

import com.algs.utils.array.ArraySortUtil;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public class MergeSortTdAlysImpl<E extends Comparable<E>> extends MergeSortAlysImpl<E> {

    public MergeSortTdAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    protected E[] aux0 = (E[]) new Comparable[array.length >> 1];

    @Override
    public void sort() {

        sort0(0, array.length);
//        sort1(0, array.length - 1);

        Assertions.assertTrue(ArraySortUtil.isSorted(array));
    }

    /**
     * sort: [begin, end)
     *       [begin, mid)
     *       [mid, end)
     */
    private void sort0(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = (end + begin) >> 1;
        sort0(begin, mid);
        sort0(mid, end);
        merge0(begin, mid, end);
    }

    /**
     * {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
     * {0, 1, 2, 3, 4, 5} {6, 7, 8, 9, 10}
     *
     * merge:
     *  [begin, mid) [mid, end)
     */
    protected void merge0(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;
        for (int i = li; i < le; i++) {
            aux0[i] = array[begin + i];
            arrayAcc += 2;
        }
        while (li < le) {
            if (ri < re && compareEntry(aux0[li], array[ri]) > 0) {
                array[ai++] = array[ri++];
                arrayAcc += 4;
            } else {
                array[ai++] = aux0[li++];
                arrayAcc += 2;
                leftSubarrayLength++;
            }
        }
        rightSubarrayLength += re - ri;
    }

    private final E[] aux1 = (E[]) new Comparable[array.length];

    /**
     * sort: [begin, end]
     */
    private void sort1(int begin, int end) {
        if (end <= begin) {
            return;
        }
        int mid = (begin + end) >> 1;
        sort1(begin, mid);
        sort1(mid + 1, end);
        merge10(begin, mid, end);
    }

    /**
     * merge:
     * [begin, mid], [mid + 1, end]
     *
     * array: {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
     *         begin       mid            end
     *
     * aux1:  {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
     *         i              j
     */
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

    /**
     * merge:
     * [begin, mid], [mid + 1, end]
     *
     * array: {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
     *         begin       mid            end
     *                        j
     *
     * aux10: {0, 1, 2, 3, 4}
     *         i
     */
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