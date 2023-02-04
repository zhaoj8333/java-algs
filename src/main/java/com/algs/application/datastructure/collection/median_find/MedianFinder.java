package com.algs.application.datastructure.collection.median_find;

public interface MedianFinder<E> {

    void insert(E item);

    E[] find();

    E[] delete();

}
