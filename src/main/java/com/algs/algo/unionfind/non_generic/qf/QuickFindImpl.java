package com.algs.algo.unionfind.non_generic.qf;

import com.algs.DefaultValues;
import com.algs.algo.unionfind.non_generic.qu.IUnionFind;
import com.algs.util.RangeUtil;

import java.util.Objects;

public class QuickFindImpl implements IUnionFind {

    private final int[] id;
    private int count;

    public QuickFindImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public QuickFindImpl(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity should >= 1");
        }
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
        RangeUtil.requireIndexRange(a, 0, id.length);
        RangeUtil.requireIndexRange(b, 0, id.length);
        int idA = id[a];
        int idB = id[b];
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
        RangeUtil.requireIndexRange(a, 0, id.length);
        return id[a];
    }

    @Override
    public boolean connected(int a, int b) {
        RangeUtil.requireIndexRange(a, 0, id.length);
        RangeUtil.requireIndexRange(b, 0, id.length);
        return Objects.equals(find(a), find(b));
    }

    @Override
    public int[] getIds() {
        return id;
    }
}
