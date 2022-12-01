package com.algs.algo.sort.array.cmp_swp.merge;

import com.algs.algo.sort.array.cmp_swp.ArrayCompareAndSwapSort;

import java.util.Comparator;

/**
 * Divide and Merge
 *
 * Comparison of:
 * {@link MergeSortTdImpl}
 * {@link MergeSortBuImpl}
 */
public abstract class MergeSortImpl<E extends Comparable<E>> extends ArrayCompareAndSwapSort<E> {

    protected final E[] aux = (E[]) new Comparable[array.length];

    public MergeSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    protected int insertionSortThreshold = 8;

    /**
     * If the index range specified by {@link MergeSortImpl} is under {@link #insertionSortThreshold},
     * use {@link #insertionSort(E[], int, int)} instead of merge, this can reduce time by 10% ~ 15%
     */
    public void setInsertionSortThreshold(int insertionSortThreshold) {
        this.insertionSortThreshold = insertionSortThreshold;
    }

    protected void insertionSort(E[] array, int begin, int end) {
        for (int i = begin + 1; i < end; i++) {
            int index = i;
            E tmp = array[index];
            while (index > begin && compareEntry(tmp, array[index - 1]) < 0) {
                array[index] = array[index - 1];
                index--;
            }
            array[index] = tmp;
        }
    }

}
