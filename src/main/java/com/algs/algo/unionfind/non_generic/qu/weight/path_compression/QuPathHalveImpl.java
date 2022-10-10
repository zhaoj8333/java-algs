package com.algs.algo.unionfind.non_generic.qu.weight.path_compression;

import com.algs.DefaultValues;
import com.algs.util.RangeUtil;

import java.util.Objects;

/**
 * 路径减半: 每隔一个节点指向其祖父节点
 */
public class QuPathHalveImpl extends QuFullPathCompressionImpl {

    public QuPathHalveImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public QuPathHalveImpl(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int a) {
        RangeUtil.requireIndexRange(a, 0, id.length);
        while (!Objects.equals(a, id[a])) {
            id[a] = id[id[a]];
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
