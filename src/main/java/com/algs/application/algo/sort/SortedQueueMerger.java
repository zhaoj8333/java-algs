package com.algs.application.algo.sort;

import com.algs.datastructure.collection.deque.LinkedListDequeImpl0;
import com.algs.datastructure.collection.queue.IQueue;

public class SortedQueueMerger<E extends Comparable<E>> {

    private final IQueue<E> q1;
    private final IQueue<E> q2;

    public SortedQueueMerger(IQueue<E> q1, IQueue<E> q2) {
        this.q1 = q1;
        this.q2 = q2;
    }

    public IQueue<E> merge() {
        IQueue<E> q = new LinkedListDequeImpl0<>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            E n1 = q1.peek();
            E n2 = q2.peek();
            if (n1.compareTo(n2) < 0) {
                q.enque(q1.deque());
            } else {
                q.enque(q2.deque());
            }
        }
        while (!q1.isEmpty()) {
            q.enque(q1.deque());
        }
        while (!q2.isEmpty()) {
            q.enque(q2.deque());
        }
        return q;
    }
}
