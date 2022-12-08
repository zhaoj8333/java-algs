package com.algs.algo.unionfind.compare;

import com.algs.algo.unionfind.generic.DJPerformanceCompare;
import com.algs.algo.unionfind.generic.IDisjointSet;
import com.algs.algo.unionfind.generic.Village;
import com.algs.algo.unionfind.generic.qu.WeighedPathHalvingImpl;
import com.algs.analysis.StopWatchTask;
import com.algs.datastructure.collection.deque.IDeque;
import com.algs.datastructure.collection.deque.LinkedListDequeImpl0;
import org.junit.jupiter.api.Test;

class DJPerformanceCompareTest {

    @Test
    void test() {
        int max = 500000;
        for (int size = 200000; size < max; size *= 2) {
            IDeque<Village> villages = new LinkedListDequeImpl0<>();
            IDisjointSet<Village> ds = new WeighedPathHalvingImpl<>(size);
            for (int i = 0; i < size; i++) {
                Village v = new Village("name" + i, "");
                villages.enque(v);
                ds.makeSet(v);
            }

            long l = System.currentTimeMillis();
            StopWatchTask<Village> swt = new DJPerformanceCompare<>(ds, villages);
            System.out.println("init data spend: " + ((System.currentTimeMillis() - l) / 1000) + " s");
            System.out.println("test start");
            long o = swt.exec(true);
            System.out.println("test end");
        }
    }

    @Test
    void renderStopWatchProfile() {
    }
}