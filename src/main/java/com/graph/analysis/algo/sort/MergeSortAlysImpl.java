package com.graph.analysis.algo.sort;

import com.algs.util.SortUtil;
import com.graph.GraphicAnalysis;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public abstract class MergeSortAlysImpl<E extends Comparable<E>> extends CompareAndSwapSortAlys<E> implements GraphicAnalysis {

    protected E[] aux = (E[]) new Comparable[array.length];

    public MergeSortAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void analyze() {
        sort();
        Assertions.assertTrue(SortUtil.isSorted(array));
        plot(array.length, arrayAcc);
        plot(array.length, cmpCount);
    }
}
