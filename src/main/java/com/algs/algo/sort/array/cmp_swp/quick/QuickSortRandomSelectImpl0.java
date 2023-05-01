package com.algs.algo.sort.array.cmp_swp.quick;

import com.algs.utils.RandomUtil;
import java.util.Comparator;

/**
 * {@link #partition(int, int)}
 */
public class QuickSortRandomSelectImpl0<E extends Comparable<E>> extends QuickSortImpl0<E> {

    public QuickSortRandomSelectImpl0(E[] array) {
        this(array, null);
    }

    public QuickSortRandomSelectImpl0(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        sort(0, array.length);
    }

    public void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = partition(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

    protected int partition(int begin, int end) {
        int uniform = RandomUtil.uniform(begin, end);
        swap(uniform, begin);
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
