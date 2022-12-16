package com.graph.analysis.algo.sort.merge;

import com.algs.utils.array.ArraySortUtil;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public class NaturalMergeSortBuAlysImpl<E extends Comparable<E>> extends MergeSortBuAlysImpl<E> {

    protected final E[] aux = (E[]) new Comparable[array.length];

    public NaturalMergeSortBuAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        int len = array.length;
        if (len == 1) {
            return;
        }
        int begin = 0, mid = 0, end = 0;
        while (true) {
            mid = findSortedIndex(begin);
            if (begin == 0 && mid == len) {
                Assertions.assertTrue(ArraySortUtil.isSorted(array));
                return;
            }
            end = findSortedIndex(mid);
            merge(begin, mid, end);
            begin = end == len ? 0 : end;
        }
    }

    private int findSortedIndex(int start) {
        for (int i = start + 1; i < array.length; i++) {
            arrayAcc += 2;
            if (compareIndex(i - 1, i) > 0) {
                return i;
            }
        }
        return array.length;
    }
}
