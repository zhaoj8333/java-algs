package com.graph.analysis.algo.sort;

import com.algs.algo.sort.array.cmp_swp.shell.sequence.SequenceGenerator;

import java.util.Comparator;

public class IncrementSequenceOfShellsort<E extends Comparable<E>> {

    private final ShellSortAlysImpl<E> sort;
    public final E[] array;

    public IncrementSequenceOfShellsort(E[] array, Comparator<E> comparator, SequenceGenerator sg) {
        this.array = array;
        this.sort = new ShellSortAlysImpl<>(array, comparator, sg);
    }

    public void sort() {
        sort.sort();
    }

    public int getCost() {
        return sort.getCost();
    }

    public int getCmpCount() {
        return sort.getCmpCount();
    }

    public int getSwapCount() {
        return sort.getSwapCount();
    }

}
