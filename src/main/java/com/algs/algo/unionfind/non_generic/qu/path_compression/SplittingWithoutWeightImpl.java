package com.algs.algo.unionfind.non_generic.qu.path_compression;

import com.algs.algo.unionfind.non_generic.qu.QuickUnionImpl;
import com.algs.util.RangeUtil;

import java.util.Objects;

public class SplittingWithoutWeightImpl extends QuickUnionImpl {

    /**
     *              a == 1          a == 2
     *
     *      5         5                5
     *      |        / \             / \ \
     *      4       4   3           2  3  4
     *      |      /     \         /    \
     *      3     2       1       0      1
     *      |    /
     *      2   0
     *      |
     *      1
     *      |
     *      0
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

}
