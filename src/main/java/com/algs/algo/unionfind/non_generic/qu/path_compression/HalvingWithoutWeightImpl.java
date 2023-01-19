package com.algs.algo.unionfind.non_generic.qu.path_compression;

import com.algs.algo.unionfind.non_generic.qu.QuickUnionImpl;
import com.algs.utils.RangeUtil;

import java.util.Objects;

/**
 * Compare to {@link SplittingWithoutWeightImpl#find(int)},
 *
 * {@link SplittingWithoutWeightImpl#find(int)} take N steps to look and change the parent of every node
 * {@link HalvingWithoutWeightImpl#find(int)} will take N/2 steps, only processes half number of nodes in the whole path.
 *
 * {@link HalvingWithoutWeightImpl#find(int)} has better performance
 *
 * @see {@link com.algs.algo.unionfind.non_generic.qu.UFPerformanceCompareTest}
 */
public class HalvingWithoutWeightImpl extends QuickUnionImpl {

    /**
     *          a == 0      a == 2
     *
     *    5         5         5
     *    |        /         / \
     *    4      4          4   2
     *    |     / \        /   / \
     *    3    3   2      3   1   0
     *    |       / \
     *    2      1   0
     *    |
     *    1
     *    |
     *    0
     */
    @Override
    public int find(int a) {
        RangeUtil.requireIntRange(a, 0, id.length);
        while (!Objects.equals(a, id[a])) {
            id[a] = id[id[a]];
            a = id[a];
        }
        return a;
    }

}
