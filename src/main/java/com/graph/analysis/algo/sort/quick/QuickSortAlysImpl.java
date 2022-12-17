package com.graph.analysis.algo.sort.quick;

import com.algs.utils.array.ArraySortUtil;
import com.graph.analysis.algo.sort.CompareAndSwapSortAlys;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public class QuickSortAlysImpl<E extends Comparable<E>> extends CompareAndSwapSortAlys<E> {

    public QuickSortAlysImpl(E[] array) {
        super(array);
    }

    public QuickSortAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
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
            while (++i < end && compareEntry(pivot, array[i]) < 0);
            while (start < --j && compareEntry(pivot, array[j]) > 0);
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
