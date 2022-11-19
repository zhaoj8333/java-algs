package com.graph.analysis.algo.sort;

import com.graph.GraphicAnalysis;

import java.util.Comparator;

public abstract class MergeSortAlysImpl<E extends Comparable<E>> extends CompareAndSwapSortAlys<E> implements GraphicAnalysis {

    protected E[] aux = (E[]) new Comparable[array.length >> 1];

    public MergeSortAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void analyze() {
        cost = 0;
        sort();

        plot(array.length, cost, 0);
    }
}
