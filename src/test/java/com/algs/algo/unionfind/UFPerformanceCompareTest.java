package com.algs.algo.unionfind;

import com.algs.algo.unionfind.non_generic.qf.QuickFindImpl;
import com.algs.algo.unionfind.non_generic.qu.weight.path_compression.QuPathHalveImpl;
import com.algs.algo.unionfind.non_generic.qu.weight.path_compression.QuPathSplitImpl;
import com.algs.algo.unionfind.non_generic.qu.weight.path_compression.QuFullPathCompressionImpl;
import com.algs.algo.unionfind.non_generic.qu.weight.QuRankImpl;
import com.algs.algo.unionfind.non_generic.qu.weight.QuSizeImpl;
import com.algs.analysis.StopWatchTask;
import org.junit.jupiter.api.Test;

class UFPerformanceCompareTest {

    @Test
    void test() {
        int size = 10000_000;

        StopWatchTask swt = new UFPerformanceCompare(size, new QuickFindImpl(size));
//        swt.exec();
//        swt = new UFPerformanceCompare(size, new QuickUnionIntImpl(size));
//        swt.exec();
        swt = new UFPerformanceCompare(size, new QuSizeImpl(size));
        swt.exec();
        swt = new UFPerformanceCompare(size, new QuRankImpl(size));
        swt.exec();
        swt = new UFPerformanceCompare(size, new QuFullPathCompressionImpl(size));
        swt.exec();
        swt = new UFPerformanceCompare(size, new QuPathSplitImpl(size));
        swt.exec();
        swt = new UFPerformanceCompare(size, new QuPathHalveImpl(size));
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