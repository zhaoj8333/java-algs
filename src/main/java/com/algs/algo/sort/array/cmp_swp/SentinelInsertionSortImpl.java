package com.algs.algo.sort.array.cmp_swp;

import com.algs.algo.sort.array.cmp_swp.quick.QuickSortImpl;

import java.util.Comparator;

/**
 * Inversion:
 *  {2,3,8,6,1}: <2,1>; <3,1>; <8,6>; <8,1>; <6,1>
 *
 * The complexity of {@link SentinelInsertionSortImpl} and Number of Inversion is directly proportional, the more inversions, the higher complexity
 *
 * 倒序数组逆序最多，插入排序复杂度最高
 *
 * When the number of inversion is very few, or the array length is very small, {@link SentinelInsertionSortImpl} can be faster than {@link QuickSortImpl}
 *
 * Time Complexity: O(N) ~ O(N^2) Stable
 */
public class SentinelInsertionSortImpl<E extends Comparable<E>> extends CompareAndSwapSort<E> {

    public SentinelInsertionSortImpl(E[] array) {
        this(array, null);
    }

    public SentinelInsertionSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
//        sort0();
        sort1();
    }

    private void sort1() {
        int len = array.length;
        int minIndex = 0;
        for (int i = 1; i < len; i++) {
            if (compareIndex(minIndex, i) > 0) {
                minIndex = i;
            }
        }
        swap(minIndex, 0);
        // insert
        for (int i = 2; i < len; i++) {
            int index = i;
            E tmp = array[index];
            // search
            while (compareEntry(tmp, array[index - 1]) < 0) {
                array[index] = array[index - 1];
                index--;
            }
            array[index] = tmp;
        }
    }

}
