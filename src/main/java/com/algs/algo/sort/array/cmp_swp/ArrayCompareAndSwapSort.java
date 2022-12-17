package com.algs.algo.sort.array.cmp_swp;

import com.algs.algo.sort.ISortable;
import com.algs.utils.ObjectUtil;
import jdk.jshell.spi.ExecutionControl;

import java.util.Comparator;
import java.util.Objects;

/**
 * Comparison and swap based sorting
 */
public abstract class ArrayCompareAndSwapSort<E extends Comparable<E>> implements ISortable<E> {

    protected E[] array;
    protected Comparator<E> comparator;

    public ArrayCompareAndSwapSort(E[] array) {
        this.array = array;
    }

    public ArrayCompareAndSwapSort(E[] array, Comparator<E> comparator) {
        ObjectUtil.requireNonNull(array);
        this.array = array;
        this.comparator = comparator;
    }

    public E[] getArray() {
        return array;
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

    @Override
    public void sort() {
        try {
            throw new ExecutionControl.NotImplementedException("Please override this method");
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
    }

}
