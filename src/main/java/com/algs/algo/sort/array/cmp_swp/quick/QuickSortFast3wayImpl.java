package com.algs.algo.sort.array.cmp_swp.quick;

import com.algs.algo.sort.array.cmp_swp.ArrayCompareAndSwapSort;
import java.util.Comparator;

public class QuickSortFast3wayImpl<E extends Comparable<E>> extends ArrayCompareAndSwapSort<E> {

    public QuickSortFast3wayImpl(E[] array) {
        super(array);
    }

    public QuickSortFast3wayImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        sort(0, array.length);
    }

    /**
     * {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}
     * begin                                 end
     *          lt                        gt
     *             i
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int i = begin, p = begin;
        int j = end, q = end;
        E entry = array[begin];
        while (true) {
            if (i > begin && compareEntry(array[i], entry) == 0) {
                swap(++p, i);
            }
            if (j <= end && compareEntry(array[j], entry) == 0) {
                swap(--q, j);
            }
            while (compareEntry(array[++i], entry) < 0) {
                if (i == end) {
                    break;
                }
            }
            while (compareEntry(array[--j], entry) > 0) {
                if (j == begin) {
                    break;
                }
            }
            if (i == j && compareEntry(entry, array[i]) == 0) {
                swap(++p, i);
            }
            if (i >= j) {
                break;
            }
            swap(i, j);
        }
    }

}
