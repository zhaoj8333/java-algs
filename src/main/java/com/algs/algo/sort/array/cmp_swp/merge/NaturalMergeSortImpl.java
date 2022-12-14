package com.algs.algo.sort.array.cmp_swp.merge;

import java.util.Comparator;

public class NaturalMergeSortImpl<E extends Comparable<E>> extends MergeSortBuImpl<E> {

    public NaturalMergeSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        int len = array.length;
        if (len < 2) {
            return;
        }

        int li = 0, le = 0, ri = 0, re = 0;
        while (true) {
            le = findSortedArray(li);
            if (le == array.length - 1) {
                return;
            }
            ri = le + 1;
            re = findSortedArray(ri);
            merge(li, ri, re + 1);
            li = re == array.length - 1 ? 0 : re + 1;
        }
    }

    /**
     * {a, b, c, d, e}
     */
    private int findSortedArray(int start) {
        for (int i = start + 1; i < array.length; i++) {
            if (compareIndex(start, i) > 0) {
                return i - 1;
            }
        }
        return array.length - 1;
    }
}
