package com.graph.analysis.algo.sort;

import com.algs.algo.sort.ISortable;
import com.algs.util.ObjectUtil;

import java.util.Comparator;
import java.util.Objects;

/**
 * Comparison and swap based sorting
 */
public abstract class CompareAndSwapSortAlys<E extends Comparable<E>> implements ISortable<E> {

    protected E[] array;
    protected Comparator<E> comparator;

    protected int cost = 0;
    protected int swapCount = 0;
    protected int cmpCount = 0;


    public CompareAndSwapSortAlys(E[] array, Comparator<E> comparator) {
        ObjectUtil.requireNonNull(array);
        this.array = array;
        this.comparator = comparator;
    }

    protected int compareEntry(E a, E b) {
        cmpCount++;
        cost++;

        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

    protected int compareIndex(int i, int j) {
        return compareEntry(array[i], array[j]);
    }

    protected void swap(int i, int j) {
        swapCount++;
        cost++;

        E tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

    public int getCost() {
        return cost;
    }

    public int getSwapCount() {
        return swapCount;
    }

    public int getCmpCount() {
        return cmpCount;
    }
}
