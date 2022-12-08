package com.algs.algo.unionfind;

import com.algs.algo.unionfind.non_generic.qf.QuickFindImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickFindImplTest {

    @Test
    void test() {
        QuickFindImpl qf = new QuickFindImpl();
        // 0 1 2 3 4 5 6 7 8 9
        // 0 1 2 3 4 5 6 7 8 9
        qf.union(0, 1);
        // 0 1  2 3 4 5 6 7 8 9
        // 1 1  2 3 4 5 6 7 8 9
        Assertions.assertEquals(qf.find(0), qf.find(1));
        Assertions.assertEquals(9, qf.count());

        qf.union(3, 4);
        Assertions.assertEquals(qf.find(3), qf.find(4));
        Assertions.assertEquals(8, qf.count());

        // 0 1  2  3 4  5 6 7 8 9
        // 4 4  2  4 4  5 6 7 8 9
        qf.union(0, 4);
        Assertions.assertEquals(qf.find(0), qf.find(4));
        Assertions.assertEquals(qf.find(0), qf.find(3));
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