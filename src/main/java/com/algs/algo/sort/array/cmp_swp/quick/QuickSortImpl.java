package com.algs.algo.sort.array.cmp_swp.quick;

import com.algs.algo.sort.array.cmp_swp.ArrayCompareAndSwapSort;

import java.util.Comparator;

/**
 * Essential of {@link QuickSortImpl}:
 *  Make every element as the pivot element, when every element becomes pivot, the array is sorted
 */
public class QuickSortImpl<E extends Comparable<E>> extends ArrayCompareAndSwapSort<E> {

    public QuickSortImpl(E[] array) {
        this(array, null);
    }

    public QuickSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        sort(0, array.length);
    }

    /**
     * [begin, end)
     *
     * array.length == end - begin
     */
    public void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = pivot(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

    /**
     * return the final position index of pivot element [begin, end)
     */
    private int pivot(int begin, int end) {
        E pivotEntry = array[begin];
        end--;
        while (begin < end) {
            while (begin < end) {
                // use < to ensure the pivot will be in the middle when all or part of the elements are the same
                // if <=, all the elements <= pivot entry won't change
                if (compareEntry(pivotEntry, array[end]) < 0) {
                    end--;
                } else {
                    array[begin++] = array[end];
                    break;
                }
            }
            while (begin < end) {
                if (compareEntry(pivotEntry, array[begin]) > 0) {
                    begin++;
                } else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }
        array[begin] = pivotEntry;
        return begin; // or end
    }

}
