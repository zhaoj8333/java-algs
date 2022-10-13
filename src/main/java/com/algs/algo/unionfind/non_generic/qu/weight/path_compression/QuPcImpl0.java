package com.algs.algo.unionfind.non_generic.qu.weight.path_compression;

import com.algs.DefaultValues;
import com.algs.util.RangeUtil;

import java.util.Objects;

/**
 * 该路径压缩成本稍高
 */
public class QuPcImpl0 extends QuPcImpl {

    public QuPcImpl0() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public QuPcImpl0(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int a) {
        RangeUtil.requireIndexRange(a, 0, id.length);
        int root = a;
        while (!Objects.equals(root, id[root])) {
            root = id[root];
        }
        int tmp = a;
        while (!Objects.equals(tmp, id[tmp])) {
            tmp = id[tmp];
            id[tmp] = root;
        }
        return root;
    }
}
