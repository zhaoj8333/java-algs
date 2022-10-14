package com.algs.algo.unionfind.non_generic.qu;

import com.algs.algo.unionfind.non_generic.qf.QuickFindImpl;
import com.algs.algo.unionfind.non_generic.qu.path_compression.HalvingImpl;
import com.algs.algo.unionfind.non_generic.qu.path_compression.SplittingImpl;
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
//        swt = new UFPerformanceCompare(size, new QuPcImpl(size));
//        swt.exec();
//        swt = new UFPerformanceCompare(size, new FullCompressionImpl0(size));
//        swt.exec();
        swt = new UFPerformanceCompare(size, new SplittingImpl(size));
        swt.exec();
        swt = new UFPerformanceCompare(size, new HalvingImpl(size));
        swt.exec();

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