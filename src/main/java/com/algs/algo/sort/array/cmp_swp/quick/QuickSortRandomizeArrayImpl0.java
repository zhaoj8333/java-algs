package com.algs.algo.sort.array.cmp_swp.quick;

import com.algs.utils.RandomUtil;

import java.util.Comparator;

/**
 * {@link #partition(int, int)}
 */
public class QuickSortRandomizeArrayImpl0<E extends Comparable<E>> extends QuickSortImpl0<E> {

    public QuickSortRandomizeArrayImpl0(E[] array) {
        this(array, null);
    }

    public QuickSortRandomizeArrayImpl0(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        RandomUtil.shuffle(array);
        sort(0, array.length);
    }

    /**
     * [begin, end)
     */
    public void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
//        if (end <= begin + insertionCutoff) {
//            insertionSort(array, begin, end);
//            return;
//        }
        int mid = partition(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

}
