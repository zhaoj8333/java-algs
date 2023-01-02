package com.algs.algo.sort.array.cmp_swp.quick;

import com.algs.datastructure.collection.stack.IStack;
import com.algs.datastructure.collection.stack.LinkedListStackImpl;

import java.util.Comparator;

public class NonRecursiveQuickSortImpl<E extends Comparable<E>> extends QuickSortImpl0<E> {

    public NonRecursiveQuickSortImpl(E[] array) {
        this(array, null);
    }

    // [begin, end]
    private final IStack<Integer> ranges = new LinkedListStackImpl<>();

    public NonRecursiveQuickSortImpl(E[] array, Comparator<E> comparator) {
        super(array, comparator);
    }

    @Override
    public void sort() {
        sort(0, array.length);
    }

    @Override
    public void sort(int begin, int end) {
        ranges.push(begin);
        ranges.push(end);
        while (!ranges.isEmpty()) {
            Integer hi = ranges.pop();
            Integer lo = ranges.pop();
            int mid = partition(lo, hi);
            // Push the larger sub array first to guarantee that the stack will have at most lg N entries
            if (mid - lo > 1) {
                ranges.push(lo);
                ranges.push(mid);
            }
            if (hi - mid > 2) {
                ranges.push(mid + 1);
                ranges.push(hi);
            }
       }
    }
}
