package com.algs.algo.sort.array.cmp_swp.quick;

import com.algs.algo.sort.array.cmp_swp.ArrayCompareAndSwapSort;
import com.algs.utils.RandomUtil;

import java.util.Comparator;

public class QuickSort3wayImpl<E extends Comparable<E>> extends ArrayCompareAndSwapSort<E> {

    public QuickSort3wayImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        RandomUtil.shuffle(array);
        sort(0, array.length - 1);
    }

    /**
     * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
     *
     * begin  lt                   gt     end
     *        i
     *
     * array[begin, lt - 1]: <  entry
     * array[lt,     i - 1]: == entry
     * array[gt + 1,   end]: >  entry
     */
    private void sort(int begin, int end) {
        if (end <= begin) {
            return;
        }
        int lt = begin, i = begin + 1, gt = end;
        E entry = array[begin];
        while (i <= gt) {
            int cmp = compareEntry(array[i], entry);
            if (cmp < 0) {
                swap(lt++, i++);
            } else if (cmp > 0) {
                swap(i, gt--);
            } else {
                i++;
            }
        }
        sort(begin, lt - 1);
        sort(gt + 1, end);
    }

}
