package com.algs.algo.sort.array.cmp_swp.quick;

import com.algs.utils.RandomUtil;
import java.util.Comparator;

// // TODO: 1/14/23  
public class QuickSampleSortImpl<E extends Comparable<E>> extends QuickSortImpl0<E> {

    public QuickSampleSortImpl(E[] array) {
        super(array);
    }

    public QuickSampleSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        sort(array.length);
    }

    private void sort(int size) {
        if (size < 2) {
            return;
        }
        int k = Math.toIntExact(Math.round(Math.log(size) / Math.log(2)));
        int pivots = (int) Math.pow(2, k) - 1;
        // pick samples
        System.out.println("pivots: " + pivots);
        for (int i = 0; i < pivots; i++) {
            swap(i, RandomUtil.uniform(size));
        }
        sort(pivots);
        sort(pivots, size, pivots);

    }

    public void sort(int begin, int end, int pivots) {
        if (begin > end) {
            return;
        }
        if (pivots == 0) {
            return;
        }
        if (pivots > 0) {
            pivots /= 2;
        } else {
            pivots = -pivots;
        }
    }
}
