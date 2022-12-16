package com.graph.analysis.algo.sort;

import com.algs.algo.sort.ISortable;
import com.algs.utils.ObjectUtil;
import com.algs.utils.array.ArraySortUtil;
import com.graph.GraphicAnalysis;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;
import java.util.Objects;

/**
 * Comparison and swap based sorting
 */
public abstract class CompareAndSwapSortAlys<E extends Comparable<E>> implements ISortable<E>, GraphicAnalysis {

    protected E[] array;
    protected Comparator<E> comparator;

    protected int cost = 0;
    protected int swapCount = 0;
    protected int cmpCount = 0;
    protected int arrayAcc = 0;

    public CompareAndSwapSortAlys(E[] array, Comparator<E> comparator) {
        ObjectUtil.requireNonNull(array);
        cost = 0;
        swapCount = 0;
        cmpCount = 0;
        arrayAcc = 0;
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

    public int getArrayAcc() {
        return arrayAcc;
    }

    public E[] getArray() {
        return array;
    }

    @Override
    public void analyze() {
        sort();
        Assertions.assertTrue(ArraySortUtil.isSorted(array));
        plot(array.length, arrayAcc);
        plot(array.length, cmpCount);
//        plot(array.length, leftSubarrayLength + rightSubarrayLength, DrawUtil.GREEN);
    }
}
