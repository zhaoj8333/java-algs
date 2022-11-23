package com.graph.analysis.algo.sort.merge;

import com.algs.util.SortUtil;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public class MergeSortTopdownAlysImpl<E extends Comparable<E>> extends MergeSortAlysImpl<E> {

    public MergeSortTopdownAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        if (array.length == 1) {
            return;
        }
//        sort0(0, array.length);
        sort(0, array.length - 1);
        Assertions.assertTrue(SortUtil.isSorted(array));
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
//        fastMerge0(begin, mid, end);
    }

    /**
     * merge: [begin, mid) and [mid, end)
     *
     * 0                 9       13        18
     *                   begin   mid       end
     * - - - - - - - - - - - - - - - - - -      array
     *                   li      le        re
     *                           ri
     *                   ai
     *
     *                   0
     *                   - - - -                aux
     *                   li      le
     */
    protected void merge0(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;
        for (int i = li; i < le; i++) {
            aux[i] = array[i + begin];
            arrayAcc += 2;
        }
        while (li < le) {
            if (ri < re && compareEntry(array[ri], aux[li]) < 0) {
                array[ai++] = array[ri++];
                arrayAcc += 4;
            } else {
                array[ai++] = aux[li++];
                arrayAcc += 2;
            }
        }
    }

    /**
     * [0, array.length - 1]
     *
     * [begin, end]
     * 
     * add compareIndex(mid, mid + 1) > 0, may avoid call {@link #merge(int, int, int)}
     */
    private void sort(int begin, int end) {
        if (end <= begin) {
            return;
        }
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid + 1, end);
//        merge(begin, mid, end);
        fastMerge(begin, mid, end);
    }

    /**
     *          0          5          10
     * left[]:  E O R S T  X  A E L M P
     *          m             n
     *                    mid
     */
    private void merge(int begin, int mid, int end) {
        for (int i = begin; i <= end; i++) {
            aux[i] = array[i];
            arrayAcc += 2;
        }
        int li = begin, ri = mid + 1, ai = begin;
        while (li <= mid && ri <= end) {
            if (compareEntry(aux[li], aux[ri]) > 0) {
                array[ai++] = aux[ri++];
            } else {
                array[ai++] = aux[li++];
            }
            arrayAcc += 2;
        }
        while (li <= mid) {
            array[ai++] = aux[li++];
            arrayAcc += 2;
        }
    }

    private void fastMerge(int begin, int mid, int end) {
        int auxIndex = begin;
        for (int i = begin; i <= mid; i++) {
            aux[auxIndex++] = array[i];
            arrayAcc += 2;
        }
        for (int i = end; i > mid; i--) {
            aux[auxIndex++] = array[i];
            arrayAcc += 2;
        }
        int li = begin, ri = end, ai = begin;
        while (li <= mid) {
            if (compareEntry(aux[li], aux[ri]) <= 0) {
                array[ai++] = aux[li++];
            } else {
                array[ai++] = aux[ri--];
            }
            arrayAcc += 2;
        }
    }

}
