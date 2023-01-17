package com.algs.algo.filter;

public interface IFilter<E> {

    void put(E item);

    boolean contains(E item);

}
