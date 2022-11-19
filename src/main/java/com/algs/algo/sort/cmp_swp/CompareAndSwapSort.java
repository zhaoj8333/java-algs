package com.algs.algo.sort.cmp_swp;

import com.algs.algo.sort.ISortable;
import com.algs.util.ObjectUtil;

import java.util.Comparator;
import java.util.Objects;

/**
 * Comparison and swap based sorting
 */
public abstract class CompareAndSwapSort<E extends Comparable<E>> implements ISortable<E> {

    public E[] array;
    protected Comparator<E> comparator;

    public CompareAndSwapSort(E[] array, Comparator<E> comparator) {
        ObjectUtil.requireNonNull(array);
        this.array = array;
        this.comparator = comparator;
    }

    protected int compareEntry(E a, E b) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

    protected int compareIndex(int i, int j) {
        return compareEntry(array[i], array[j]);
    }

    protected void swap(int i, int j) {
        E tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

}
