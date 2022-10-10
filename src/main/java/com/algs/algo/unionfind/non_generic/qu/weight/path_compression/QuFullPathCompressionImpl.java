package com.algs.algo.unionfind.non_generic.qu.weight.path_compression;

import com.algs.DefaultValues;
import com.algs.algo.unionfind.non_generic.qu.IUnionFind;
import com.algs.util.ArraysUtil;
import com.algs.util.RangeUtil;

import java.util.Objects;

/**
 * 该路径压缩成本稍高
 */
public class QuFullPathCompressionImpl implements IUnionFind {

    protected int count;
    protected final int[] heights;
    protected final int[] id;

    public QuFullPathCompressionImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public QuFullPathCompressionImpl(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity should >= 1");
        }
        id = new int[capacity];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        heights = new int[capacity];
        ArraysUtil.fill(heights, 1);
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
        count--;
        if (heights[rootA] > heights[rootB]) {
            id[rootB] = rootA;
        } else if (heights[rootA] < heights[rootB]) {
            id[rootA] = rootB;
        } else {
            id[rootA] = rootB;
            heights[rootB]++;
        }
    }

    @Override
    public int find(int a) {
        RangeUtil.requireIndexRange(a, 0, id.length);
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
