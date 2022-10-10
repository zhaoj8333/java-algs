package com.algs.algo.unionfind.non_generic.qu.weight.path_compression;

import com.algs.DefaultValues;
import com.algs.algo.unionfind.non_generic.qu.IUnionFind;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuPathCompressionImplTest {

    @Test
    void test() {
        IUnionFind qf = new QuFullPathCompressionImpl();
        common(qf);
        qf = new QuPathSplitImpl();
        common(qf);
        qf = new QuPathHalveImpl();
        common(qf);


    }

    @Test
    void common(IUnionFind qf) {
//        QuickUnionIntOptBySize qf = new QuickUnionIntOptBySize();
        Assertions.assertEquals(DefaultValues.DEFAULT_CAPACITY, qf.count());
        Assertions.assertEquals(0, qf.find(0));
        Assertions.assertEquals(3, qf.find(3));

        qf.union(1, 2);
        Assertions.assertTrue(qf.connected(1, 2));
        Assertions.assertEquals(9, qf.count());
        Assertions.assertEquals(2, qf.find(2));

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
}