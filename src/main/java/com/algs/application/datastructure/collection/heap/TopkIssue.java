package com.algs.application.datastructure.collection.heap;

import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.heap.pq.ArrayBinaryPqImpl;
import com.algs.datastructure.collection.heap.pq.IPriorityQueue;
import com.algs.util.ObjectUtil;

import java.util.Comparator;

public class TopkIssue<E extends Comparable<E>> {

    public ICollection<E> solution(ICollection<E> collection, Comparator<E> comparator, int k) {

        ObjectUtil.requireNonEmpty(collection);
        IPriorityQueue<E> heap = new ArrayBinaryPqImpl<>(k, comparator);
        Iterator<E> itr = collection.iterator();

        while (itr.hasNext()) {
            E next = itr.next();
            if (heap.size() < k) {
                heap.add(next);
            } else if (heap.compare(next, heap.get()) < 0) {
                heap.replace(next);
            }
        }
        return heap;
    }

}
