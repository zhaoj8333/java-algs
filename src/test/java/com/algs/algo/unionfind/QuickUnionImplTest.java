package com.algs.algo.unionfind;

import com.algs.ImplFunctionalityTest;
import com.algs.algo.unionfind.non_generic.IDynamicUnionFind;
import com.algs.algo.unionfind.non_generic.qu.weighed.RankWeighedLinkedListImpl;
import org.junit.jupiter.api.Assertions;

class QuickUnionImplTest extends ImplFunctionalityTest {

    @Override
    protected Object construct(Class<?> targetClass) {
        return null;
    }

    @Override
    protected void testEach(Object obj) {
        IDynamicUnionFind uf = new RankWeighedLinkedListImpl();
        Assertions.assertEquals(0, uf.count());

        for (int i = 0; i < 10; i++) {
            int i1 = uf.newSite();
        }

        Assertions.assertEquals(0, uf.find(0));
        Assertions.assertEquals(3, uf.find(3));

        uf.union(1, 2);
        Assertions.assertTrue(uf.connected(1, 2));
        Assertions.assertEquals(9, uf.count());
//        Assertions.assertEquals(2, uf.find(2));

        uf.union(4, 5);
        Assertions.assertTrue(uf.connected(4, 5));
        Assertions.assertEquals(8, uf.count());

        uf.union(2, 4);
        Assertions.assertTrue(uf.connected(1, 5));
        Assertions.assertTrue(uf.connected(2, 5));
        Assertions.assertTrue(uf.connected(4, 1));
        Assertions.assertTrue(uf.connected(4, 2));
        Assertions.assertEquals(7, uf.count());
    }

    @Override
    public void test() {
    }
}