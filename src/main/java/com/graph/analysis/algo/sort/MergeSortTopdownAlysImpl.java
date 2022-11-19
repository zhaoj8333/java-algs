package com.graph.analysis.algo.sort;

import java.util.Comparator;

public class MergeSortTopdownAlysImpl<E extends Comparable<E>> extends MergeSortAlysImpl<E> {

    public MergeSortTopdownAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
//        sort(0, array.length - 1);
        sort0(0, array.length);
    }

    /**
     * sort array[]: [begin, end), begin <= index < end
     */
    private void sort0(int begin, int end) {
    }

    /**
     * merge: [begin, mid) and [mid, end)
     */
    protected void merge0(int begin, int mid, int end) {

    }

    /**
     * [0, array.length - 1]
     *
     * [begin, end]
     */
    private void sort(int begin, int end) {

    }

    /**
     *          0          5          10
     * left[]:  E O R S T  X  A E L M P
     *          m             n
     *                    mid
     */
    private void merge(int begin, int mid, int end) {

    }

}
