package com.graph.analysis.algo.sort.quick;

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

    public int[] getSubarraySize() {
        return new int[] {size0Array, size1Array, size2Array, size3Array};
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
            return;
        }
        sort0(0, len);
        Assertions.assertTrue(ArraySortUtil.isSorted(array));
    }

    /**
     * [start, end)
     */
    private void sort0(int start, int end) {
        if (end - start < 2) {
            return;
        }
        int mid = pivot(start, end);

        checkSubarraySize(mid - start);
        checkSubarraySize(end - mid - 1);

        sort0(start, mid);
        sort0(mid + 1, end);
    }

    /**
     * [4, 5, 1, 0, 9, 12, 3, 6)
     *     i                     j
     */
    private int pivot(int start, int end) {
        E pivot = array[start];

        cost++;
        arrayAcc++;

        int i = start, j = end;
        while (i < j) {
            while (++i < end && compareEntry(pivot, array[i]) < 0);     // don't use <= 0
            while (start < --j && compareEntry(pivot, array[j]) > 0);   // don't use <= 0
            if (i >= j) {
                break;
            }
            swap(i, j);
            swapCount++;
        }
        swap(start, j);
        swapCount++;
        return j;
    }
}
