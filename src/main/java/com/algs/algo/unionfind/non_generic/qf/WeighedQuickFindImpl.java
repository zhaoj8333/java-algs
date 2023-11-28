package com.algs.algo.unionfind.non_generic.qf;

import com.algs.DefaultValues;
import com.algs.algo.unionfind.non_generic.IUnionFind;
import com.algs.utils.RangeUtil;
import com.algs.utils.array.ArraysUtil;
import java.util.Objects;

public class WeighedQuickFindImpl implements IUnionFind {

    private final int[] id;
    private final int[] sz;
    private int count;

    public WeighedQuickFindImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public WeighedQuickFindImpl(int capacity) {
        RangeUtil.requireGreaterThan(capacity, 0);
        id = new int[capacity];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        sz = new int[capacity];
        ArraysUtil.fill(sz, 1);
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
        int ts = sz[a] + sz[b];
        int oId, nId;
        if (sz[a] < sz[b]) {
            oId = rootA;
            nId = rootB;
        } else {
            oId = rootB;
            nId = rootA;
        }
        for (int i = 0; i < id.length; i++) {
            if (Objects.equals(id[i], oId)) {
                id[i] = nId;
            }
            if (Objects.equals(id[i], nId)) {
                sz[i] = ts;
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
    public boolean isSameSet(int a, int b) {
        return Objects.equals(find(a), find(b));
    }

    @Override
    public int[] getIds() {
        return id;
    }

}
