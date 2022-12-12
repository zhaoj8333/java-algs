package com.algs.algo.sort.array.cmp_swp;

import com.algs.utils.array.ArraysUtil;

import java.util.Comparator;

/**
 * // TODO: 12/12/22  
 */
public class SortDescriptor<E extends Comparable<E>> extends ArrayCompareAndSwapSort<E> {

    private final E[] aux;
    private final int[] originalPositions;

    public SortDescriptor(E[] array, Comparator<E> comparator) {
        super(array, comparator);
        aux = (E[]) new Comparable[array.length >> 1];
        originalPositions = new int[array.length];
        ArraysUtil.fill(originalPositions, -1);
    }

    public int[] describe() {
        return describeOnMerge();
    }

    private int[] describeOnMerge() {
        if (array.length <= 1) {
            return originalPositions;
        }
        sort(0, array.length);
        return originalPositions;
    }

    // [begin, end)
    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    private void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;
        for (int i = 0; i < le; i++) {
            aux[i] = array[i + begin];
        }
        while (li < le) {
            if (ri < re && compareEntry(aux[li], array[ri]) > 0) {
                array[ai++] = array[ri++];
            } else {
                array[ai++] = aux[li++];
            }
        }
    }

}
