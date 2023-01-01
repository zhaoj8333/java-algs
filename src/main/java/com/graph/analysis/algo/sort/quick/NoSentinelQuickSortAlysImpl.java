package com.graph.analysis.algo.sort.quick;

import com.algs.utils.array.ArraySortUtil;
import com.graph.analysis.algo.sort.CompareAndSwapSortAlys;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public class NoSentinelQuickSortAlysImpl<E extends Comparable<E>> extends CompareAndSwapSortAlys<E> {

    public NoSentinelQuickSortAlysImpl(E[] array) {
        super(array);
    }

    public NoSentinelQuickSortAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        if (array.length == 0) {
            testCount++;
            return;
        }
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            arrayAcc += 2;
            if (compareIndex(maxIndex, i) < 0) {
                maxIndex = i;
            }
            testCount ++;
        }
        swap(maxIndex, array.length - 1);
        sort(0, array.length);
        Assertions.assertTrue(ArraySortUtil.isSorted(array));
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) {
            testCount++;
            return;
        }
        int mid = pivot(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

    private int pivot(int begin, int end) {
        int i = begin, j = end;
        E pivot = array[begin];

        arrayAcc++;
        cost++;

        while (i < j) {
            testCount++;
            while (compareEntry(pivot, array[++i]) > 0) {
                testCount++;
            }
            while (compareEntry(pivot, array[--j]) < 0) {
                testCount++;
            }
            if (compareEntry(pivot, array[i]) <= 0) {
                testCount++;
            }
            if (compareEntry(pivot, array[j]) >= 0) {
                testCount++;
            }
            if (i >= j) {
                testCount++;
                break;
            }
            swap(i, j);
        }
        swap(begin, j);
        return j;
    }
}
