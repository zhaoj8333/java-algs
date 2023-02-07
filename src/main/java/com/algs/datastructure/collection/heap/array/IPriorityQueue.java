package com.algs.datastructure.collection.heap.array;

import com.algs.datastructure.collection.ICollection;

public interface IPriorityQueue<E extends Comparable<E>> extends ICollection<E> {

    E peek();

    E remove();

    E replace(E item);

    int compare(E a, E b);

}
