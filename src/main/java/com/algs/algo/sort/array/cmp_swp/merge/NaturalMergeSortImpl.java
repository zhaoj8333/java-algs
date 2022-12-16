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
        // merge: [li, le) [ri, re)
        int li = 0, le = 0, ri = 0, re = 0;
        while (true) {
            le = findSortedIndex(li);
            if (li == 0 && le == array.length) {
                return;
            }
            ri = le;
            re = findSortedIndex(ri);
            merge(li, le, re);
            li = re == array.length ? 0 : re;
        }
    }

    /**
     * {7, 9, 6, 2, 4, 0, 3, 6, 8}
     *
     * [li,le)
     */
    private int findSortedIndex(int start) {
        for (int i = start + 1; i < array.length; i++) {
            if (compareIndex(i - 1, i) > 0) {
                return i;
            }
        }
        return array.length;
    }
}
