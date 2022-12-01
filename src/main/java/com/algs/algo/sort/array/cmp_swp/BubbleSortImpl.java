package com.algs.algo.sort.array.cmp_swp;

import java.util.Comparator;

public class BubbleSortImpl<E extends Comparable<E>> extends ArrayCompareAndSwapSort<E> {

    public BubbleSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        sort2();
    }

    /**
     * From index(0) to index(length-1)
     */
    private void sort0() {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (compareIndex(i, j) > 0) {
                    swap(i, j);
                }
            }
        }
    }

    private void sort1() {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            boolean sorted = true;
            for (int j = i + 1; j < len; j++) {
                if (compareIndex(i, j) > 0) {
                    swap(i, j);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    /**
     * From index(length-1) to index(0)
     *
     * lastSwappedAt: if the array is fully sorted, then it takes only n times to compare
     */
    private void sort2() {
        int len = array.length;
        for (int j = len - 1; j > 0; j--) {
            int lastSwappedAt = 0;
            for (int i = j - 1; i >= 0; i--) {
                if (compareIndex(i, j) > 0) {
                    swap(i, j);
                    lastSwappedAt = j;
                }
            }
            j = lastSwappedAt;
        }
    }

}
