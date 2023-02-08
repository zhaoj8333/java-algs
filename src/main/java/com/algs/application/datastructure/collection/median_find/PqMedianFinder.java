package com.algs.application.datastructure.collection.median_find;

import com.algs.datastructure.collection.heap.array.BinaryArrayPqImpl;
import com.algs.datastructure.collection.heap.array.IPriorityQueue;
import com.algs.utils.CompareUtil;

import java.util.Comparator;

public class PqMedianFinder<E extends Comparable<E>> implements MedianFinder<E> {

    private int size;
    private final IPriorityQueue<E> minPq;
    private final IPriorityQueue<E> maxPq;

    public PqMedianFinder() {
        this.minPq = new BinaryArrayPqImpl<E>(0, Comparator.reverseOrder());    // bigger values
        this.maxPq = new BinaryArrayPqImpl<E>(0, Comparator.naturalOrder());    // smaller values
    }

    /**
     * Bigger values put into the min Pq, Smaller ones into the max pq
     *       max       min
     *        5         6
     *      /  \      /  \
     *     3    4    7    8
     *   / \        / \  / \
     *  1  2       9  10
     *
     */
    @Override
    public void insert(E item) {
        if (size == 0 || CompareUtil.less(item, maxPq.peek())) {
            maxPq.add(item);
        } else {
            minPq.add(item);
        }
        if (minPq.size() > maxPq.size() + 1) {
            maxPq.add(minPq.remove());
        } else if (maxPq.size() > minPq.size() + 1) {
            minPq.add(maxPq.remove());
        }
        size++;
    }

    @Override
    public E[] find() {
        E[] medians = (E[]) new Comparable[2];
        if (size == 0) {
            return medians;
        }
        if (size % 2 == 0) {
            medians[0] = minPq.peek();
            medians[1] = maxPq.peek();
        } else {
            if (minPq.size() > maxPq.size()) {
                medians[0] = minPq.peek();
            } else {
                medians[0] = maxPq.peek();
            }
        }
        return medians;
    }

    @Override
    public E[] delete() {
        E[] medians = (E[]) new Comparable[2];
        if (size == 0) {
            return medians;
        }
        if (size % 2 == 0) {
            medians[0] = minPq.remove();
            medians[1] = maxPq.remove();
            size -= 2;
        } else {
            if (minPq.size() > maxPq.size()) {
                medians[0] = minPq.remove();
            } else {
                medians[0] = maxPq.remove();
            }
            size--;
        }
        return medians;
    }
}
