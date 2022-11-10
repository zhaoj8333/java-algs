package com.algs.algo.sort;

import java.util.Comparator;

/**
 * {@link HeapSortImpl}:
 *
 * Advantages: ~ 2N logN
 * Disadvantages: can't use cache, it is barely used, because it don't compare adjacent members,
 *  the cache miss is far more higher than adjacent comparing soring: {@link QuickSortImpl}, {@link MergeSortImpl}, {@link ShellSortImpl}
 */
public class HeapSortImpl<E extends Comparable<E>> extends CompareAndSwapSort<E> {

    private int heapSize;

    public HeapSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
        heapSize = array.length;
    }

    private void siftDown(int index) {
        E ele = array[index];
        int half = heapSize >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            E child = array[childIndex];
            if (childIndex + 1 < heapSize && compareEntry(array[childIndex + 1], child) > 0) {
                child = array[++childIndex];
            }
            if (compareEntry(ele, child) >= 0) {
                break;
            }
            array[index] = child;
            index = childIndex;
        }
        array[index] = ele;
    }

    @Override
    public void sort() {
        if (heapSize < 2) {
            return;
        }
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
        while (heapSize > 1) {
            swap(0, --heapSize);
            siftDown(0);
        }
    }

}
