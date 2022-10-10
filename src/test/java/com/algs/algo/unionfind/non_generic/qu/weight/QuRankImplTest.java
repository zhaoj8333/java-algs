package com.algs.algo.unionfind.non_generic.qu.weight;

import com.algs.DefaultValues;
import com.algs.algo.unionfind.non_generic.qu.IUnionFind;
import com.algs.algo.unionfind.non_generic.qu.weight.QuRankImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuRankImplTest {

    @Test
    void test() {
        IUnionFind qf = new QuRankImpl(10);
        Assertions.assertEquals(DefaultValues.DEFAULT_CAPACITY, qf.count());
        Assertions.assertEquals(0, qf.find(0));
        Assertions.assertEquals(3, qf.find(3));

        qf.union(1, 2);
        Assertions.assertTrue(qf.connected(1, 2));
        Assertions.assertEquals(9, qf.count());

        qf.union(4, 5);
        Assertions.assertTrue(qf.connected(4, 5));
        Assertions.assertEquals(8, qf.count());

        qf.union(2, 4);
        Assertions.assertTrue(qf.connected(1, 5));
        Assertions.assertTrue(qf.connected(2, 5));
        Assertions.assertTrue(qf.connected(4, 1));
        Assertions.assertTrue(qf.connected(4, 2));
        Assertions.assertEquals(7, qf.count());

    }

    @Test
    void count() {
    }

    @Test
    void union() {
    }

    @Test
    void find() {
    }

    @Test
    void connected() {
    }

    @Test
    void testUnion() {
    }

    @Test
    void testFind() {
    }

    @Test
    void testConnected() {
    }
}