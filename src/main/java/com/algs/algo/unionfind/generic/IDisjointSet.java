package com.algs.algo.unionfind.generic;

public interface IDisjointSet<E> {

    void makeSet(E item);

    int count();

    void union(E a, E b);

    E find(E a);

    boolean isSameSet(E a, E b);

}
