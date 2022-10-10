package com.algs.algo.unionfind;

public interface IDisjointSet<E> {

    int count();

    void union(E p, E q);

    E find(E p);

    boolean connected(E p, E q);

}
