package com.algs.algo.unionfind.non_generic.qu;

public interface IUnionFind {

    int count();

    void union(int a, int b);

    int find(int p);

    boolean connected(int a, int b);

    int[] getIds();
}
