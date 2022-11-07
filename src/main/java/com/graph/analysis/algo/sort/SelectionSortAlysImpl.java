package com.graph.analysis.algo.sort;

import com.algs.algo.sort.SelectionSortImpl;
import com.graph.GraphicAnalysis;

public class SelectionSortAlysImpl<E extends Comparable<E>> extends SelectionSortImpl<E> implements GraphicAnalysis {

    private int totalCost = 0;
    private int cost = 0;
    private int swapCount = 0;
    private int cmpCount = 0;
    private final int offset;

    public SelectionSortAlysImpl(E[] data, int graphOffset) {
        super(data, null);
        this.offset = graphOffset;
    }

    @Override
    protected int compare(E a, E b) {
        cmpCount++;
        cost++;
        return super.compare(a, b);
    }

    @Override
    protected void swap(int i, int j) {
        swapCount++;
        cost++;
        super.swap(i, j);
    }

    @Override
    public void sort() {
        int len = array.length;
        if (len < 2) {
            cost++;
            return;
        }
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                cost ++;
                if (compare(array[min], array[j]) < 0) {
                    min = j;
                    cost++;
                }
            }
            swap(min, i);
        }
    }

    @Override
    public void analyze() {
        sort();
    }

}
