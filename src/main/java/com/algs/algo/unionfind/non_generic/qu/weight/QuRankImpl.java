package com.algs.algo.unionfind.non_generic.qu.weight;

import com.algs.DefaultValues;
import com.algs.algo.unionfind.non_generic.qu.QuickUnionImpl;
import com.algs.util.ArraysUtil;
import com.algs.util.RangeUtil;

import java.util.Objects;

/**
 * 解决 @{@link QuSizeImpl} 带来的树不平衡问题
 */
public class QuRankImpl extends QuickUnionImpl {

    private final int[] rank;

    public QuRankImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public QuRankImpl(int capacity) {
        super(capacity);
        rank = new int[capacity];
        ArraysUtil.fill(rank, 1);
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
            id[rootB] = rootA;
            rank[rootA]++;
        }
        count--;
    }

    @Override
    public int[] getIds() {
        return id;
    }
}
