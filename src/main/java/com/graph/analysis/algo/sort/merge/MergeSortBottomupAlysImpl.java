package com.graph.analysis.algo.sort.merge;

import com.algs.util.SortUtil;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public class MergeSortBottomupAlysImpl<E extends Comparable<E>> extends MergeSortAlysImpl<E> {

    protected final E[] aux = (E[]) new Comparable[array.length];

    public MergeSortBottomupAlysImpl(E[] array, Comparator<E> comparator) {
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
        if (array.length == 1) {
            return;
        }
        sort1();
        Assertions.assertTrue(SortUtil.isSorted(array));
    }

    private void sort1() {
        for (int sz = 1; sz < array.length; sz <<= 1) {
            for (int begin = 0; begin + sz < array.length; begin += (sz << 1)) {
//                int end = Math.min(begin + (sz << 1) - 1, array.length - 1);
//                int mid = begin + sz - 1;
//                merge1(begin, mid, end);
                int end = Math.min(begin + (sz << 1), array.length);
                int mid = begin + sz;
                merge(begin, mid, end);
            }
        }
    }

    /**
     * merge: [begin, mid) and [mid, end)
     *
     * 0                 9       13        18
     *                   begin   mid       end
     * - - - - - - - - - - - - - - - - - -      array
     *                   l       r         end
     *                   ai
     *
     *                   0
     *                   - - - -                aux
     *                   l       r
     */
    private void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid;
        int ai = begin;
        for (int i = li; i < le; i++) {
            aux[i] = array[i + begin];
            arrayAcc += 2;
        }
        while (li < le) {
            if (ri < end && compareEntry(array[ri], aux[li]) < 0) {
                array[ai++] = array[ri++];
            } else {
                array[ai++] = aux[li++];
            }
            arrayAcc += 2;
        }
    }

    private void merge0(int begin, int mid, int end) {
        int l = begin, r = mid;
        for (int i = begin; i < end; i++) {
            aux[i] = array[i];
            arrayAcc += 2;
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
            arrayAcc += 2;
        }
    }

    private void merge1(int begin, int mid, int end) {
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

}
