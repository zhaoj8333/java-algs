package com.algs.algo.unionfind;

import com.algs.ImplFunctionalityTest;
import com.algs.algo.unionfind.non_generic.IUnionFind;
import com.algs.algo.unionfind.non_generic.qf.QuickFindImpl;
import com.algs.algo.unionfind.non_generic.qu.QuickUnionImpl;
import com.algs.algo.unionfind.non_generic.qu.path_compression.FullCompressImpl;
import com.algs.algo.unionfind.non_generic.qu.path_compression.FullCompressImpl0;
import com.algs.algo.unionfind.non_generic.qu.path_compression.HalvingImpl;
import com.algs.algo.unionfind.non_generic.qu.path_compression.SplittingImpl;
import com.algs.algo.unionfind.non_generic.qu.weighed.RankWeighedImpl;
import com.algs.algo.unionfind.non_generic.qu.weighed.SizeWeighedImpl;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickFindImplTest extends ImplFunctionalityTest {

    protected Class<?>[] targetClasses = new Class<?>[]{
            QuickFindImpl.class, QuickUnionImpl.class,
            SizeWeighedImpl.class, RankWeighedImpl.class,
            FullCompressImpl.class, FullCompressImpl0.class,
            SplittingImpl.class, HalvingImpl.class,
    };

    @Test
    @Override
    public void test() {
        test(targetClasses);
    }

    @Override
    protected Class<?>[] getConstructorParameters() {
        return null;
    }

    @Override
    protected void testEach(Object obj) {
        IUnionFind uf = (IUnionFind) obj;
        // 0 1 2 3 4 5 6 7 8 9
        // 0 1 2 3 4 5 6 7 8 9
        uf.union(0, 1);
        // 0 1  2 3 4 5 6 7 8 9
        // 1 1  2 3 4 5 6 7 8 9
        Assertions.assertEquals(uf.find(0), uf.find(1));
        Assertions.assertEquals(9, uf.count());

        uf.union(3, 4);
        Assertions.assertEquals(uf.find(3), uf.find(4));
        Assertions.assertEquals(8, uf.count());

        // 0 1  2  3 4  5 6 7 8 9
        // 4 4  2  4 4  5 6 7 8 9
        uf.union(0, 4);
        Assertions.assertEquals(uf.find(0), uf.find(4));
        Assertions.assertEquals(uf.find(0), uf.find(3));
        Assertions.assertEquals(7, uf.count());
    }
}