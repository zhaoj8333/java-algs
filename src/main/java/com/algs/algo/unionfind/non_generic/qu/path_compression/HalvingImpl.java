package com.algs.algo.unionfind.non_generic.qu.path_compression;

import com.algs.DefaultValues;
import com.algs.utils.RangeUtil;
import java.util.Objects;

/**
 * 路径减半: 每隔一个节点指向其祖父节点
 */
public class HalvingImpl extends FullCompressImpl {

    public HalvingImpl() {
        this(DefaultValues.DEFAULT_CAPACITY);
    }

    public HalvingImpl(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int a) {
        RangeUtil.requireIntRange(a, 0, id.length);
        while (!Objects.equals(a, id[a])) {
            id[a] = id[id[a]];
            a = id[a];
        }
        return a;
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
