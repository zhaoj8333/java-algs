package com.algs.algo.unionfind;

import com.algs.ImplFunctionalityTest;
import com.algs.algo.unionfind.non_generic.IDynamicUnionFind;
import com.algs.algo.unionfind.non_generic.qu.weighed.RankWeighedLinkedListImpl;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IDynamicUnionFindImplTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[]{
            RankWeighedLinkedListImpl.class,
    };

    @Override
    protected Class<?>[] getConstructorParameters() {
        return new Class[0];
    }

    @Override
    protected void testEach(Object obj) {
        IDynamicUnionFind uf = (IDynamicUnionFind) obj;
        Assertions.assertEquals(0, uf.count());

        for (int i = 0; i < 10; i++) {
            uf.newSite();
        }

        Assertions.assertEquals(0, uf.find(0));
        Assertions.assertEquals(3, uf.find(3));

        uf.union(1, 2);
        Assertions.assertTrue(uf.isSameSet(1, 2));
        Assertions.assertEquals(9, uf.count());
//        Assertions.assertEquals(2, uf.find(2));

        uf.union(4, 5);
        Assertions.assertTrue(uf.isSameSet(4, 5));
        Assertions.assertEquals(8, uf.count());

        uf.union(2, 4);
        Assertions.assertTrue(uf.isSameSet(1, 5));
        Assertions.assertTrue(uf.isSameSet(2, 5));
        Assertions.assertTrue(uf.isSameSet(4, 1));
        Assertions.assertTrue(uf.isSameSet(4, 2));
        Assertions.assertEquals(7, uf.count());
    }

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }
}