package com.graph.analysis.algo.sort.quick;

import com.algs.utils.array.ArraySortUtil;
import com.graph.analysis.algo.sort.CompareAndSwapSortAlys;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

/**
 * The average {@link CompareAndSwapSortAlys#arrayAcc} Which is fewer than 2*NlogN
 * is far fewer than {@link com.graph.analysis.algo.sort.merge.MergeSortTdAlysImpl}, which is between 5*NlogN ~ 6*NlogN
 */
public class QuickSortIgnoreSmallArrayAlysImpl<E extends Comparable<E>> extends QuickSortAlysImpl<E> {

    public QuickSortIgnoreSmallArrayAlysImpl(E[] array) {
        super(array);
    }

    public QuickSortIgnoreSmallArrayAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        int len = array.length;
        testCount ++;
        if (len < 2) {
            return;
        }
        sort0(0, len, 0);
        insertionSort(array);

        Assertions.assertTrue(ArraySortUtil.isSorted(array));
    }

    /**
     * [start, end)
     */
    public void sort0(int begin, int end, int depth) {
        recursiveCalls++;
        recursiveDepth += depth;
//        if (end - begin < 2) {
//            testCount ++;
//            return;
//        }
        testCount ++;
        if (end <= begin + insertionCutoff) {
            return;
        }
        int mid = pivot(begin, end);

        checkSubarraySize(mid - begin);
        checkSubarraySize(end - mid - 1);

        int newDepth = depth + 1;
        sort0(begin, mid, newDepth);
        sort0(mid + 1, end, newDepth);
    }

}
