package com.algs.algo.sort.array.cmp_swp.quick;

import com.algs.algo.sort.array.cmp_swp.ArrayCompareAndSwapSort;
import java.util.Comparator;

/**
 * Faster than {@link QuickSortImpl0} ?
 */
public class NoSentinelQuickSortImpl<E extends Comparable<E>> extends ArrayCompareAndSwapSort<E> {

    public NoSentinelQuickSortImpl(E[] array) {
        this(array, null);
    }

    public NoSentinelQuickSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        if (array.length == 0) {
            return;
        }
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (compareIndex(maxIndex, i) < 0) {
                maxIndex = i;
            }
        }
        swap(maxIndex, array.length - 1);
        sort(0, array.length);
    }

    private void sort(int begin, int end) {
//        if (end <= begin + insertionSortThreshold) {
//            insertionSort(array, begin, end);
//        }
        if (end - begin < 2) {
            return;
        }
        int mid = partition(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

    /**
     * [begin, end)
     */
    private int partition(int begin, int end) {
        E pivot = array[begin];
        int i = begin, j = end;
        while (true) {
            while (compareEntry(pivot, array[++i]) > 0);
            while (compareEntry(pivot, array[--j]) < 0);
            if (i >= j) {
                break;
            }
            swap(i, j);
        }
        swap(begin, j);
        return j;
    }
}
