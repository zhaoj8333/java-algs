package com.algs.algo.unionfind.generic.qu;

import com.algs.algo.unionfind.generic.IDisjointSet;
import com.algs.algo.unionfind.generic.Village;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GenericImplTest {

    @Test
    void testVillage() {
        IDisjointSet<Village> uf = new WeighedPathHalvingImpl<>(100);
        Village village1 = new Village("name" + 1, "location: " + 1);
        Village village2 = new Village("name" + 2, "location: " + 2);
        uf.makeSet(village1);
        uf.makeSet(village2);
        for (int i = 3; i < 10; i++) {
            uf.makeSet(new Village("name:" + i, "location: " + i));
        }
        uf.union(village1, village2);

        Assertions.assertTrue(uf.connected(village1, village2));

    }

    @Test
    void testInt() {
        IDisjointSet<Integer> uf = new WeighedPathHalvingImpl<>();
        for (int i = 0; i < 10; i++) {
            uf.makeSet(i);
        }

        Assertions.assertEquals(0, uf.find(0));
        Assertions.assertEquals(2, uf.find(2));
        Assertions.assertEquals(4, uf.find(4));
        Assertions.assertEquals(8, uf.find(8));

        uf.union(0, 2);
        int i0 = uf.find(0);
        int i2 = uf.find(2);
        Assertions.assertEquals(i0, i2);
        Assertions.assertTrue(uf.connected(0, 2));

        uf.union(4, 5);
        int i4 = uf.find(4);
        int i5 = uf.find(5);
        Assertions.assertEquals(i4, i5);
        Assertions.assertTrue(uf.connected(4, 5));

        uf.union(0, 4);
        int a = uf.find(0);
        int b = uf.find(4);

        Assertions.assertTrue(uf.connected(0, 4));
        Assertions.assertTrue(uf.connected(2, 5));

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