package com.algs.algo.sort.array.cmp_swp;

import com.algs.algo.sort.ISortable;
import com.algs.utils.CompareUtil;
import com.algs.utils.ObjectUtil;
import com.algs.utils.array.ArraySortUtil;
import jdk.jshell.spi.ExecutionControl;

import java.util.Comparator;

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
        return CompareUtil.compare(a, b, comparator);
    }

    protected int compareIndex(int i, int j) {
        return compareEntry(array[i], array[j]);
    }

    protected void swap(int i, int j) {
        ArraySortUtil.swap(array, i, j);
    }

    protected int insertionCutoff = 8;

    /**
     * If the index range specified by {@link com.algs.algo.sort.array.cmp_swp.merge.MergeSortImpl} is under {@link #insertionCutoff},
     * use {@link #insertionSort(E[], int, int)} instead of merge, this can reduce time by 10% ~ 15%
     */
    public void setInsertionCutoff(int insertionCutoff) {
        this.insertionCutoff = insertionCutoff;
    }

    protected void insertionSort(E[] array) {
        insertionSort(array, 0, array.length);
    }

    protected void insertionSort(E[] array, int begin, int end) {
        for (int i = begin + 1; i < end; i++) {
            int index = i;
            E tmp = array[index];
            while (index > begin && compareEntry(tmp, array[index - 1]) < 0) {
                array[index] = array[index - 1];
                index--;
            }
            array[index] = tmp;
        }
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
