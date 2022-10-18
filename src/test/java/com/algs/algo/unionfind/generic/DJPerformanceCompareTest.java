package com.algs.algo.unionfind.generic;

import com.algs.algo.unionfind.generic.qu.WeighedQuickUnionWithPathHalvingImpl;
import com.algs.analysis.StopWatchTask;
import com.algs.datastructure.collection.deque.ArrayDequeImpl;
import com.algs.datastructure.collection.deque.IDeque;
import com.algs.datastructure.collection.deque.LinkedListDequeImpl0;
import org.junit.jupiter.api.Test;

class DJPerformanceCompareTest {

    @Test
    void beforeExec() {
    }

    @Test
    void afterExec() {
    }

    @Test
    void test() {
        int max = 500000;
        for (int size = 200000; size < max; size *= 2) {
            IDeque<Village> villages = new LinkedListDequeImpl0<>();
            IDisjointSet<Village> ds = new WeighedQuickUnionWithPathHalvingImpl<>(size);
            for (int i = 0; i < size; i++) {
                Village v = new Village("name" + i, "");
                villages.enque(v);
                ds.makeSet(v);
            }

            long l = System.currentTimeMillis();
            StopWatchTask<Village> swt = new DJPerformanceCompare<>(ds, villages);
            System.out.println("init data spend: " + ((System.currentTimeMillis() - l) / 1000) + " s");
            System.out.println("test start");
            long o = swt.exec();
            System.out.println("test end");
        }
    }

    @Test
    void renderStopWatchProfile() {
    }

    @Test
    void exec() {
    }

    @Test
    void profileTask() {
    }
}