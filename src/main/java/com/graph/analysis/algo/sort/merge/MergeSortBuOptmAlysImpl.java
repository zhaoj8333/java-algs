package com.graph.analysis.algo.sort.merge;

import com.algs.utils.array.ArraySortUtil;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public class MergeSortBuOptmAlysImpl<E extends Comparable<E>> extends MergeSortBuAlysImpl<E> {

    public MergeSortBuOptmAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        int sz = this.useInsertThreshold;
        for (int begin = 0; begin < array.length; begin += sz) {
            int end = Math.min(array.length, begin + sz);
            insertionSort(array, begin, end);
        }
        if (useInsertThreshold >= array.length) {
            Assertions.assertTrue(ArraySortUtil.isSorted(array));
            return;
        }
        for (; sz < array.length; sz <<= 1) {
            for (int begin = 0; begin < array.length; begin += sz + sz) {
                int end = Math.min(begin + (sz << 1), array.length);
                int mid = Math.min(begin + sz, array.length - 1);
                arrayAcc += 2;
                if (compareIndex(mid - 1, mid) > 0) {
                    merge(begin, mid, end);
                }
            }
        }
        Assertions.assertTrue(ArraySortUtil.isSorted(array));
    }

}
