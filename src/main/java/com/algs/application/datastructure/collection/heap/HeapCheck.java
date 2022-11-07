package com.algs.application.datastructure.collection.heap;

import java.util.Comparator;

/**
 * algs 4th: 2.4.15
 *
 * Check weather a heap is Min-Heap or Max-Heap
 */
public class HeapCheck<E extends Comparable<E>> {

    private final Comparator<E> comparator = Comparator.naturalOrder();

    /**
     * @param pq: use linear time complexity to check if an array(started from 1) is a heap array
     * @return true: Min Heap, false: Max Heap,
     */
    public Boolean isMinHeap(E[] pq) {
        int size = pq.length;
        for (int i = (size >> 1) - 1; i > 0; i--) {
            E parent = pq[i];
            E child = pq[i << 1];
            if (comparator.compare(parent, child) > 0) {
                return false;
            }
            child = pq[(i << 1) + 1];
            if (comparator.compare(parent, child) > 0) {
                return false;
            }
        }
        return true;
    }
}
