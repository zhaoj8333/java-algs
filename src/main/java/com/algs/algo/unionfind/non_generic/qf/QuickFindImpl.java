package com.algs.algo.unionfind.non_generic.qf;

import com.algs.DefaultValues;
import com.algs.algo.unionfind.non_generic.IUnionFind;
import com.algs.utils.RangeUtil;

import java.util.Objects;

public class QuickFindImpl implements IUnionFind {

    protected final int[] id;
    protected int count;

    public QuickFindImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public QuickFindImpl(int capacity) {
        RangeUtil.requireGreaterThan(capacity, 0);
        id = new int[capacity];
        for (int i = 0; i < id.length; ) {
            id[i] = i++;
        }
        count = capacity;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(int a, int b) {
        int idA = find(a);
        int idB = find(b);
        if (Objects.equals(idA, idB)) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (Objects.equals(id[i], idA)) {
                id[i] = idB;
            }
        }
        count--;
    }

    @Override
    public int find(int a) {
        RangeUtil.requireIntRange(a, 0, id.length);
        return id[a];
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
