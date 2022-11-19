package com.graph.analysis.algo.sort;

import java.util.Comparator;

public class MergeSortBottomupAlysImpl<E extends Comparable<E>> extends MergeSortAlysImpl<E> {

    protected final E[] aux = (E[]) new Comparable[array.length];

    public MergeSortBottomupAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    /**
     * merge:
     * sz == 1:  (0, 2), (2, 4), (4, 6), (6, 8), (8, 10), (10, 12)
     * sz == 2:  (0, 4), (4, 8), (8, 12)
     * sz == 4:  (0, 8), (8, 16)
     * sz == 8:  (0, 16)
     */
    @Override
    public void sort() {
    }

    /**
     * merge: [begin, end)
     *  [begin, mid)
     *  [mid, end)
     */
    private void merge(int begin, int mid, int end) {
    }

}
