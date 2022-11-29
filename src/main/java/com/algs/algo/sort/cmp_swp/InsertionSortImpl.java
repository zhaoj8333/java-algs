package com.algs.algo.sort.cmp_swp;

import com.algs.algo.sort.cmp_swp.quick.QuickSortImpl;

import java.util.Comparator;

/**
 * Inversion:
 *  {2,3,8,6,1}: <2,1>; <3,1>; <8,6>; <8,1>; <6,1>
 *
 * The complexity of {@link InsertionSortImpl} and Number of Inversion is directly proportional, the more inversions, the higher complexity
 *
 * 倒序数组逆序最多，插入排序复杂度最高
 *
 * When the number of inversion is very few, or the array length is very small, {@link InsertionSortImpl} can be faster than {@link QuickSortImpl}
 *
 * Time Complexity: O(N) ~ O(N^2) Stable
 */
public class InsertionSortImpl<E extends Comparable<E>> extends CompareAndSwapSort<E> {

    public InsertionSortImpl(E[] array) {
        this(array, null);
    }

    public InsertionSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
//        sort0();
//        sort1();
        sort2();
    }

    private void sort2() {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int dest = binarySearch(i);
            insert(i, dest);
        }
    }

    private void insert(int start, int dest) {
        E e = array[start];
        for (int i = start; i > dest; i--) {
            array[i] = array[i - 1];
        }
        array[dest] = e;
    }

    /**
     * get the last element smaller than array[index]
     *          3
     *                5
     *                   6
     * 1, 2, 3, 3, 3, 6, 7, (4)
     */
    private int binarySearch(int index) {
        E entry = array[index];
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (compareEntry(entry, array[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }

    private void sort1() {
        int len = array.length;
        // insert
        for (int i = 1; i < len; i++) {
            int index = i;
            E tmp = array[index];
            // search
            while (index > 0 && compareEntry(tmp, array[index - 1]) < 0) {
                array[index] = array[index - 1];
                index--;
            }
            array[index] = tmp;
        }
    }

    private void sort0() {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int index = i;
            while (index > 0 && compareIndex(index, index - 1) < 0) {
                swap(index, index - 1);
                index--;
            }
        }
    }

}
