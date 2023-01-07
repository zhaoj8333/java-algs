package com.algs.algo.sort.array.cmp_swp.quick;

import com.algs.algo.sort.array.cmp_swp.ArrayCompareAndSwapSort;

import java.util.Comparator;

/**
 * {@link #partition(int, int)}
 */
public class QuickSortImpl0<E extends Comparable<E>> extends ArrayCompareAndSwapSort<E> {

    public QuickSortImpl0(E[] array) {
        this(array, null);
    }

    public QuickSortImpl0(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
//        RandomUtil.shuffle(array);
        sort(0, array.length);
    }

    /**
     * [begin, end)
     */
    public void sort(int begin, int end) {
//        if (end - begin < 2) {
//            return;
//        }
        if (end <= begin + insertionCutoff) {
            insertionSort(array, begin, end);
            return;
        }
        int mid = partition(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

    /**
     * Hoare-partition
     * [begin, mid), mid, [mid + 1, end)
     *
     * If the first element is always the pivot and all elements are distinct,
     * the maximum number of swap times of the largest element is floor(N/2)
     * https://stackoverflow.com/questions/43263249/number-of-largest-element-exchanges-for-quicksort
     *
     * index j is the last(rightest) index of elements smaller than the pivot
     * i is not stable, i might == j, might i == j++,
     *
     * array[j] is surely <= pivot, and array[i] is surely >= pivot, so can't swap the possible bigger one to the left
     *
     * first loop: S
     * S O R T E X A M P L E
     * S     i 		    j		swap(i, j)
     * S O R E E X A M P L T 	    swap(i, j)
     * S 	      i       j
     * S O R E E L A M P X T		swap(begin, j)
     * 				j i
     * P O R E E L A M S X T
     */
    protected int partition(int begin, int end) {
        E entry = array[begin];
        int i = begin, j = end;
        while (true) {
            while (++i < end && compareEntry(array[i], entry) < 0);     // not <= 0
            while (--j > begin && compareEntry(array[j], entry) > 0);
            if (i >= j) {
                break;
            }
            swap(i, j);
        }
        swap(begin, j);
        return j;
    }

}
