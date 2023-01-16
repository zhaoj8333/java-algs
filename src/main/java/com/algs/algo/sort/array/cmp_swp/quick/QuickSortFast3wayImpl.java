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
     * // TODO: 1/16/23  
     * {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}
     * begin                                 end
     * entry
     *
     *          lt                        gt
     *             i
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int lt = begin, i = begin + 1, gt = end - 1;
        E entry = array[begin];
        while (i <= gt) {
            int cmp = compareEntry(entry, array[i]);
            if (cmp < 0) {
                swap(i, gt--);
            } else if (cmp > 0) {
                swap(lt++, i++);
            } else {    // ==
                i++;
            }
        }
        sort(begin, lt);
        sort(gt + 1, end);
    }

}
