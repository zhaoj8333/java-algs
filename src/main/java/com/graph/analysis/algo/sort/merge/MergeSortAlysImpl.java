package com.graph.analysis.algo.sort.merge;

import com.algs.utils.array.ArraySortUtil;
import com.graph.GraphicAnalysis;
import com.graph.analysis.algo.sort.CompareAndSwapSortAlys;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public abstract class MergeSortAlysImpl<E extends Comparable<E>> extends CompareAndSwapSortAlys<E> implements GraphicAnalysis {

    protected E[] aux = (E[]) new Comparable[array.length];

    protected int useInsertThreshold = 16;

    public MergeSortAlysImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    public void setUseInsertThreshold(int useInsertThreshold) {
        this.useInsertThreshold = useInsertThreshold;
    }

    /**
     * {0, 1, 2, 3, 4, 5, 6, 7, 8}
     */
    protected void insertionSort(E[] array, int begin, int end) {
        for (int i = begin + 1; i < end; i++) {
            int index = i;
            E entry = array[index];
            arrayAcc += 1;
            while (index > begin) {
                arrayAcc += 1;
                if (compareEntry(entry, array[index - 1]) < 0) {
                    array[index] = array[index - 1];
                    arrayAcc += 2;
                    index--;
                } else {
                    break;
                }
            }
            array[index] = entry;
            arrayAcc += 1;
        }
    }

    @Override
    public void analyze() {
        sort();
        Assertions.assertTrue(ArraySortUtil.isSorted(array));
        plot(array.length, arrayAcc);
        plot(array.length, cmpCount);
    }
}
