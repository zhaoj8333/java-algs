package com.graph.analysis.algo.sort.quick;

import com.algs.utils.array.ArraySortUtil;
import com.graph.analysis.algo.sort.CompareAndSwapSortAlys;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public class QuickSort3wayAlysImpl<E extends Comparable<E>> extends CompareAndSwapSortAlys<E> {

    public QuickSort3wayAlysImpl(E[] array) {
        this(array, null);
    }

    public QuickSort3wayAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        sort(0, array.length - 1);
        Assertions.assertTrue(ArraySortUtil.isSorted(array));
    }

    /**
     * pivot
     * |--------------|-----------|------------|
     * begin    <    lt(i)  =    gt     >    end
     */
    private void sort(int begin, int end) {
        if (end - begin < 1) {
            return;
        }
        int lt = begin, i = begin + 1, gt = end;
        E pivot = array[begin];

        arrayAcc++;
        cost++;

        while (i <= gt) {
            int cmp = compareEntry(array[i], pivot);

            arrayAcc++;

            if (cmp < 0) {
                swap(i++, lt++);
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
