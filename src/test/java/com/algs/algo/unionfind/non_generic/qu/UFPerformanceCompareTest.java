package com.algs.algo.unionfind.non_generic.qu;

import com.algs.algo.unionfind.non_generic.qf.QuickFindImpl;
import com.algs.algo.unionfind.non_generic.qu.path_compression.FullCompressImpl0;
import com.algs.algo.unionfind.non_generic.qu.path_compression.HalvingImpl;
import com.algs.algo.unionfind.non_generic.qu.path_compression.SplittingImpl;
import com.algs.algo.unionfind.non_generic.qu.weighed.RankWeighedImpl;
import com.algs.algo.unionfind.non_generic.qu.weighed.SizeWeighedImpl;
import com.algs.analysis.StopWatchTask;
import org.junit.jupiter.api.Test;

class UFPerformanceCompareTest {

    @Test
    void compare() {
        for (int size = 10000; size < 1000000; size *= 10) {
            StopWatchTask swt = new UFPerformanceCompare(size, new QuickFindImpl(size));
            swt.exec(true);
            swt = new UFPerformanceCompare(size, new SizeWeighedImpl(size));
            swt.exec(true);
            swt = new UFPerformanceCompare(size, new RankWeighedImpl(size));
            swt.exec(true);
            swt = new UFPerformanceCompare(size, new FullCompressImpl0(size));
            swt.exec(true);
            swt = new UFPerformanceCompare(size, new SplittingImpl(size));
            swt.exec(true);
            swt = new UFPerformanceCompare(size, new HalvingImpl(size));
            swt.exec(true);
        }
    }

    /**
     * O(n^2)
     * {@link QuickFindImpl}
     * {@link QuickUnionImpl}
     *
     * O(n)
     * {@link RankWeighedImpl}
     * {@link SizeWeighedImpl}
     * {@link HalvingImpl}
     * {@link SplittingImpl}
     */
    @Test
    void ratio() {
        int n = 40000;
//        for (int size = n / 8; size <= n; size *= 2) {
//            StopWatchTask swt = new UFPerformanceCompare(size, new QuickFindImpl(size));
//            swt.exec();
//        }

//        for (int size = n / 8; size <= n; size *= 2) {
//            StopWatchTask swt = new UFPerformanceCompare(size, new QuickUnionImpl(size));
//            swt.exec();
//        }

//        for (int size = n / 8; size <= n; size *= 2) {
//            StopWatchTask swt = new UFPerformanceCompare(size, new RankWeightImpl(size));
//            swt.exec();
//        }

        for (int size = n / 8; size <= n; size *= 2) {
            StopWatchTask swt = new UFPerformanceCompare(size, new HalvingImpl(size));
            long duration = swt.exec(true);
            System.out.println("=================================================");
            System.out.println(size + "->" + duration);
            System.out.println("=================================================");
        }
    }

    @Test
    void getProfile() {
    }

    @Test
    void exec() {
    }

    @Test
    void profileTask() {
    }
}