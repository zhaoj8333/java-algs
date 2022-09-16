package com.algs.datastructure.collection.bag;

import com.algs.datastructure.collection.Collection;

/**
 * Bag: 不支持从中删除元素，目的是收集元素并迭代所有元素，不关心元素的顺序
 */
public interface IBag<E> extends Collection<E> {

    boolean isEmpty();

    int size();

    void add(E item);

    int numberOf(E item);

    boolean contains(E item);

    E remove();

    E remove(E item);

    void clear();

    E[] toArray();

}
