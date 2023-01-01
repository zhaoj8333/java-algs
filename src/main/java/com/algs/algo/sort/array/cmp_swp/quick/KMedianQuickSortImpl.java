package com.algs.algo.sort.array.cmp_swp.quick;

import java.util.Comparator;

public class KMedianQuickSortImpl<E extends Comparable<E>> extends QuickSortImpl0<E> {

    public KMedianQuickSortImpl(E[] array) {
        this(array, null);
    }

    public KMedianQuickSortImpl(E[] array, Comparator<E> comparator) {
        this(array, comparator, 5);
    }

    public KMedianQuickSortImpl(E[] array, Comparator<E> comparator, int k) {
        super(array, comparator);
        this.k = k;
    }

    private final int k;

    @Override
    public void sort() {
        super.sort();
    }

    @Override
    protected int partition(int begin, int end) {
        int len = end - begin;
        if (len >= k) {
            insertionSort(array, begin, begin + k);
            swap(begin, begin + (k >> 1));
        }
        E entry = array[begin];
        int i = begin, j = end;
        while (i < j) {
            while (++i < end && compareEntry(entry, array[i]) > 0);
            while (--j > begin && compareEntry(entry, array[j]) < 0);
            if (i >= j) {
                break;
            }
            swap(i, j);
        }
        swap(begin, j);
        return j;
    }
}
