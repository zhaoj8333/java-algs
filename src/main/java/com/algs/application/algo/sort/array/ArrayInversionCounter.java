package com.algs.application.algo.sort.array;

import com.algs.algo.sort.array.cmp_swp.merge.MergeSortImpl;

import java.util.Comparator;

public class ArrayInversionCounter<E extends Comparable<E>> extends MergeSortImpl<E> {

    protected E[] aux = (E[]) new Comparable[array.length >> 1];

    public ArrayInversionCounter(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    public int count() {
        return split(0, array.length);
    }

    private int split(int begin, int end) {
        if (end - begin < 2) {
            return 0;
        }
        int mid = (begin + end) >> 1;
        int inversion = split(begin, mid);
        inversion += split(mid, end);
        return inversion + mergeCount(begin, mid, end);
    }

    /**
     * [begin, mid), [mid, end)
     *
     * i: index of left sub-array, sorted
     * j: index of right sub-array, sorted
     *
     * If a[i] > a[j], a[i+1], a[i+2] ... a[mid] all will be greater than a[j]
     * Then there are (mid - i) inversions
     */
    private int mergeCount(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, ai = begin;
        for (int i = 0; i < le; i++) {
            aux[i] = array[begin + i];
        }
        int count = 0;
        while (li < le) {
            if (ri < end) {
                if (compareEntry(aux[li], array[ri]) > 0) {
                    array[ai++] = array[ri++];
                } else {
                    count += mid - li + 1;
                    array[ai++] = aux[li++];
                }
            } else {
                array[ai++] = aux[li++];
            }
        }
        return count;
    }

    @Override
    public final void sort() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }
}
