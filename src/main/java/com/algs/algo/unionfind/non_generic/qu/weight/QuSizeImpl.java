package com.algs.algo.unionfind.non_generic.qu.weight;

import com.algs.DefaultValues;
import com.algs.algo.unionfind.non_generic.qu.QuickUnionImpl;
import com.algs.util.ArraysUtil;

import java.util.Objects;

/**
 * 基于size的优化： 树存在不平衡问题
 *    讲数量较少的嫁接到较多的节点, 可能导致比较高的树嫁接到比较矮的树
 */
public class QuSizeImpl extends QuickUnionImpl {

    private final int[] sz;

    public QuSizeImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public QuSizeImpl(int capacity) {
        super(capacity);
        sz = new int[capacity];
        ArraysUtil.fill(sz, 1);
    }

    @Override
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (Objects.equals(rootA, rootB)) {
            return;
        }
        if (sz[rootA] < sz[rootB]) {
            id[rootA] = rootB;
            sz[rootB] += sz[rootA];
        } else {
            id[rootB] = rootA;
            sz[rootA] += sz[rootB];
        }
        count--;
    }

    @Override
    public int[] getIds() {
        return id;
    }

}
