package com.algs.datastructure.collection.heap.ipq;

import com.algs.datastructure.collection.heap.pq.IPriorityQueue;

/**
 * Disadvantage of {@link IPriorityQueue}: Can't access the objects in the queue and update them which sometimes we need to do it.
 * {@link IndexedPriorityQueue}: Use integer(index) to locate the Object which needs to be updated.
 *  After the update, the location of the object may change, so the queue is still a {@link IPriorityQueue}
 * @param <E>
 */
public interface IndexedPriorityQueue<E extends Comparable<E>> extends IPriorityQueue<E> {

    /**
     * @param i i is the associated number of item, can use i get the item, i should be unique in this queue
     * @param item put item in an array of index i
     */
    void add(int i, E item);

    void change(int i, E item);

    boolean contains(int i);

    void delete(int k);

    E min();

    int minIndex();

    /**
     * @return the index of deleted item
     */
    int delMin();

}
