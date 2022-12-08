package com.algs.datastructure.collection.bag;

import com.algs.datastructure.collection.ICollection;

/**
 * Bag: Collect items and iterate them, doesn't care about the order of items
 */
public interface IBag<E> extends ICollection<E> {

    int numberOf(E item);

    E remove();

}
