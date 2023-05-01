package com.algs.algo.unionfind.non_generic.qu.path_compression;

import com.algs.DefaultValues;
import com.algs.algo.unionfind.non_generic.IUnionFind;
import com.algs.utils.RangeUtil;
import com.algs.utils.array.ArraysUtil;
import java.util.Objects;

/**
 * 该路径压缩成本稍高
 */
public class FullCompressImpl implements IUnionFind {

    protected int count;
    protected final int[] rank;
    protected final int[] id;

    public FullCompressImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public FullCompressImpl(int capacity) {
        RangeUtil.requireGreaterThan(capacity, 0);
        id = new int[capacity];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        rank = new int[capacity];
        ArraysUtil.fill(rank, 1);
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
        if (rank[rootA] > rank[rootB]) {
            id[rootB] = rootA;
        } else if (rank[rootA] < rank[rootB]) {
            id[rootA] = rootB;
        } else {
            id[rootA] = rootB;
            rank[rootB]++;
        }
        count--;
    }

    /**
     * 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
     * ------------------------------
     * [1, 2, 3, 4, 5, 6, 7, 8, 9, 9]
     */
    @Override
    public int find(int a) {
        RangeUtil.requireIntRange(a, 0, id.length);
        if (!Objects.equals(a, id[a])) {
            id[a] = find(id[a]);
        }
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
