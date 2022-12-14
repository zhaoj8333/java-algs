package com.algs.algo.sort.array;

import com.algs.algo.sort.ISortable;
import com.algs.utils.ObjectUtil;
import jdk.jshell.spi.ExecutionControl;

import java.util.Comparator;
import java.util.Objects;

/**
 * Comparison and swap based sorting
 */
public abstract class ArraySort<E extends Comparable<E>> implements ISortable<E> {

    protected E[] array;
    protected Comparator<E> comparator;

    public ArraySort(E[] array, Comparator<E> comparator) {
        ObjectUtil.requireNonNull(array);
        this.array = array;
        this.comparator = comparator;
    }

    protected int compareEntry(E a, E b) {
        return Objects.nonNull(comparator) ? comparator.compare(a, b) : a.compareTo(b);
    }

    public E[] getArray() {
        return array;
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
