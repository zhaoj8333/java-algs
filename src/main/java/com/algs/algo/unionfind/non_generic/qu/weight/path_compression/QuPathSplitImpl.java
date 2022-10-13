package com.algs.algo.unionfind.non_generic.qu.weight.path_compression;

import com.algs.DefaultValues;
import com.algs.util.RangeUtil;

import java.util.Objects;

/**
 * 路径分裂: 每个节点指向祖父节点
 */
public class QuPathSplitImpl extends QuPcImpl {

    public QuPathSplitImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public QuPathSplitImpl(int capacity) {
        super(capacity);
    }

    /**
     *  0, 1, 2, 3, 4, 5, 6, 7, 8, 9
     * ------------------------------
     * [1, 2, 3, 4, 5, 6, 7, 8, 9, 9]
     *
     * [2, 4, 5, 6, 7, 8, 9, 9, 9]
     */
    @Override
    public int find(int a) {
        RangeUtil.requireIndexRange(a, 0, id.length);
        while (!Objects.equals(a, id[a])) {
            int p = id[a];
            id[a] = id[id[a]];
            a = p;
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
