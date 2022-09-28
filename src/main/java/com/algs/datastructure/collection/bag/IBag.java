package com.algs.datastructure.collection.bag;

import com.algs.datastructure.collection.ICollection;

/**
 * Bag: 目的是收集元素并迭代所有元素，不关心元素的顺序
 */
public interface IBag<E> extends ICollection<E> {

    int numberOf(E item);

    E remove();

}
