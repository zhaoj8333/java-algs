package com.graph.analysis.algo.sort.quick;

import com.algs.algo.sort.array.cmp_swp.quick.NoSentinelQuickSortImpl;
import com.algs.utils.array.ArraySortUtil;
import com.graph.analysis.algo.sort.CompareAndSwapSortAlys;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

/**
 * The average {@link CompareAndSwapSortAlys#arrayAcc} Which is fewer than 2*NlogN
 * is far fewer than {@link com.graph.analysis.algo.sort.merge.MergeSortTdAlysImpl}, which is between 5*NlogN ~ 6*NlogN
 */
public class QuickSortAlysImpl<E extends Comparable<E>> extends CompareAndSwapSortAlys<E> {

    public QuickSortAlysImpl(E[] array) {
        super(array);
    }

    public QuickSortAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    private int size0Array = 0;     // 1/3 of array.length
    private int size1Array = 0;     // 1/3 of array.length
    private int size2Array = 0;     // 1/6 of array.length
    private int size3Array = 0;     // 1/10 of array.length

    private int recursiveCalls = 0;
    private int recursiveDepth = 0;

    public int[] getSubarraySize() {
        return new int[] {size0Array, size1Array, size2Array, size3Array};
    }

    public int getRecursiveCalls() {
        return recursiveCalls;
    }

    public int getRecursiveDepth() {
        return recursiveDepth;
    }

    private void checkSubarraySize(int size) {
        if (size == 0) {
            size0Array++;
        } else if (size == 1) {
            size1Array++;
        } else if (size == 2) {
            size2Array++;
        } else if (size == 3) {
            size3Array++;
        }
    }

    @Override
    public void sort() {
        int len = array.length;
        if (len < 2) {
            testCount ++;
            return;
        }
        sort0(0, len, 0);
        Assertions.assertTrue(ArraySortUtil.isSorted(array));
    }

    /**
     * [start, end)
     */
    private void sort0(int start, int end, int depth) {
        recursiveCalls++;
        recursiveDepth += depth;
        if (end - start < 2) {
            testCount ++;
            return;
        }
        int mid = pivot(start, end);

//        checkSubarraySize(mid - start);
//        checkSubarraySize(end - mid - 1);

        int newDepth = depth + 1;
        sort0(start, mid, newDepth);
        sort0(mid + 1, end, newDepth);
    }

    /**
     * [4, 5, 1, 0, 9, 12, 3, 6)
     *     i                     j
     *
     * in {@link com.algs.algo.sort.array.cmp_swp.quick.QuickSortImpl0}, test count is quite high,
     * if we can reduce it, it will boost the performance,
     * see {@link NoSentinelQuickSortImpl}
     * {@link NoSentinelQuickSortAlysImpl}
     */
    private int pivot(int begin, int end) {
        E pivot = array[begin];

        cost++;
        arrayAcc++;

        int i = begin, j = end;
        while (i < j) {
            testCount ++;
            // don't use <= 0
            while (++i < end && compareEntry(pivot, array[i]) < 0) {
                testCount++;
            }
            if (i >= end) {
                testCount++;
            }
            // don't use <= 0
            while (begin < --j && compareEntry(pivot, array[j]) > 0) {
                testCount++;
            }
            if (begin >= j) {
                testCount++;
            }
            if (i >= j) {
                testCount += 1;
                break;
            }
            if (compareEntry(pivot, array[i]) >= 0) {
                testCount++;
            }
            if (compareEntry(pivot, array[j]) <= 0) {
                testCount++;
            }
            swap(i, j);
        }
        swap(begin, j);
        return j;
    }
}
