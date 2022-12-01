package com.algs.algo.sort.array.cmp_swp.quick;

import com.algs.algo.sort.array.cmp_swp.CompareAndSwapSort;
import com.algs.util.RandomUtil;

import java.util.Comparator;

/**
 * {@link #partition(int, int)}
 */
public class QuickSortImpl0<E extends Comparable<E>> extends CompareAndSwapSort<E> {

    public QuickSortImpl0(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        RandomUtil.shuffle(array);
        sort(0, array.length);
    }

    /**
     * [begin, end)
     */
    public void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = partition(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

    /**
     * [begin, mid), mid, [mid + 1, end)
     */
    private int partition(int begin, int end) {
        E entry = array[begin];
        int i = begin, j = end;
        while (true) {
            do {
                ++i;
            } while (i < end && compareEntry(array[i], entry) < 0);

            do {
                --j;
            } while (j > begin && compareEntry(array[j], entry) > 0);
            if (i >= j) {
                break;
            }
            swap(i, j);
        }
        swap(begin, j);
        return j;
    }

}
