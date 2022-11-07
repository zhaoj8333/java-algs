package com.algs.algo.sort;

import com.algs.util.ObjectUtil;

import java.util.Comparator;
import java.util.Objects;

/**
 * Comparison and swap based sorting
 */
public abstract class CompareAndSwapSort<E extends Comparable<E>> implements ISortable<E> {

    protected E[] array;
    protected Comparator<E> comparator;

    public CompareAndSwapSort(E[] array, Comparator<E> comparator) {
        ObjectUtil.requireNonNull(array);
        this.array = array;
        this.comparator = comparator;
    }

    protected int compare(E a, E b) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

    protected int compare(int i, int j) {
        return compare(array[i], array[j]);
    }

    protected void swap(int i, int j) {
        E tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

}
