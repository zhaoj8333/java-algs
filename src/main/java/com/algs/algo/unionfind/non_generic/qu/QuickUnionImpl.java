package com.algs.algo.unionfind.non_generic.qu;

import com.algs.DefaultValues;
import com.algs.algo.unionfind.non_generic.IUnionFind;
import com.algs.utils.RangeUtil;

import java.util.Objects;

public class QuickUnionImpl implements IUnionFind {

    protected final int[] id;
    protected int count;

    public QuickUnionImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public QuickUnionImpl(int capacity) {
        RangeUtil.requireGreaterThan(capacity, 0);
        id = new int[capacity];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        count = capacity;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (Objects.equals(rootA, rootB)) {
            return;
        }
        id[rootA] = rootB;
        count--;
    }

    @Override
    public int find(int a) {
        RangeUtil.requireIntRange(a, 0, id.length);
        while (id[a] != a) {
            a = id[a];
        }
        return a;
    }

    @Override
    public boolean connected(int a, int b) {
        return Objects.equals(find(a), find(b));
    }

    @Override
    public int[] getIds() {
        return id;
    }
}
