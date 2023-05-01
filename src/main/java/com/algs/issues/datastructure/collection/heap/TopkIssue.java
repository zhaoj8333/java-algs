package com.algs.issues.datastructure.collection.heap;

import com.algs.datastructure.Iterator;
import com.algs.datastructure.collection.ICollection;
import com.algs.datastructure.collection.heap.array.BinaryArrayPqImpl;
import com.algs.datastructure.collection.heap.array.IPriorityQueue;
import com.algs.utils.ObjectUtil;
import java.util.Comparator;

public class TopkIssue<E extends Comparable<E>> {

    public ICollection<E> solution(ICollection<E> collection, Comparator<E> comparator, int k) {

        ObjectUtil.requireNonEmpty(collection);
        IPriorityQueue<E> heap = new BinaryArrayPqImpl<>(k, comparator);
        Iterator<E> itr = collection.iterator();

        while (itr.hasNext()) {
            E next = itr.next();
            if (heap.size() < k) {
                heap.add(next);
            } else if (heap.compare(next, heap.peek()) < 0) {
                heap.replace(next);
            }
        }
        return heap;
    }

}
