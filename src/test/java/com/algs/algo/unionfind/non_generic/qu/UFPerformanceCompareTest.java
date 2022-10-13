package com.algs.algo.unionfind.non_generic.qu;

import com.algs.algo.unionfind.non_generic.qf.QuickFindImpl;
import com.algs.algo.unionfind.non_generic.qu.weight.path_compression.QuPcImpl;
import com.algs.algo.unionfind.non_generic.qu.weight.path_compression.QuPcImpl0;
import com.algs.analysis.StopWatchTask;
import org.junit.jupiter.api.Test;

class UFPerformanceCompareTest {

    @Test
    void test() {
        int size = 1000_000;

        StopWatchTask swt = new UFPerformanceCompare(size, new QuickFindImpl(size));
//        swt.exec();
//        swt = new UFPerformanceCompare(size, new QuSizeImpl(size));
//        swt.exec();
//        swt = new UFPerformanceCompare(size, new QuRankImpl(size));
//        swt.exec();
        swt = new UFPerformanceCompare(size, new QuPcImpl(size));
        swt.exec();
        swt = new UFPerformanceCompare(size, new QuPcImpl0(size));
        swt.exec();
//        swt = new UFPerformanceCompare(size, new QuPathSplitImpl(size));
//        swt.exec();
//        swt = new UFPerformanceCompare(size, new QuPathHalveImpl(size));
//        swt.exec();

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