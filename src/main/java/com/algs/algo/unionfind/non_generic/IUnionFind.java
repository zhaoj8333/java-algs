package com.algs.algo.unionfind.non_generic;

public interface IUnionFind {

    int count();

    void union(int a, int b);

    int find(int p);

    boolean isSameSet(int a, int b);

    int[] getIds();

}
