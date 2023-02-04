package com.algs.application.datastructure.collection.heap;

import com.algs.datastructure.collection.heap.array.BinaryArrayPqImpl;
import com.algs.datastructure.collection.heap.array.IPriorityQueue;
import com.algs.utils.CompareUtil;

import java.util.Comparator;

public class MedianFinder<E extends Comparable<E>> {

    private int size;
    private final IPriorityQueue<E> minPq;
    private final IPriorityQueue<E> maxPq;

    public MedianFinder() {
        this.minPq = new BinaryArrayPqImpl<E>(0, Comparator.reverseOrder());
        this.maxPq = new BinaryArrayPqImpl<E>(0, Comparator.naturalOrder());
    }

    public void insert(E item) {
        if (size == 0 || CompareUtil.less(item, maxPq.get())) {
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

    public E[] find() {
        E[] medians = (E[]) new Comparable[2];
        if (size % 2 == 0) {
            medians[0] = minPq.get();
            medians[1] = maxPq.get();
        } else {
            if (minPq.size() > maxPq.size()) {
                medians[0] = minPq.get();
            } else {
                medians[0] = maxPq.get();
            }
        }
        return medians;
    }

    public E[] delete() {
        E[] medians = (E[]) new Comparable[2];
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
