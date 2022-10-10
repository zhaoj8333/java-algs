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

    private final int[] sizes;

    public QuSizeImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public QuSizeImpl(int capacity) {
        super(capacity);
        sizes = new int[capacity];
        ArraysUtil.fill(sizes, 1);
    }

    @Override
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (Objects.equals(rootA, rootB)) {
            return;
        }
        count--;
        if (sizes[rootA] < sizes[rootB]) {
            id[rootA] = rootB;
            sizes[rootB] += sizes[rootA];
        } else {
            id[rootB] = rootA;
            sizes[rootA] += sizes[rootB];
        }
    }

    @Override
    public int[] getIds() {
        return id;
    }
}
