package com.algs.algo.unionfind.non_generic;

import com.algs.DefaultValues;
import com.algs.algo.unionfind.non_generic.qf.QuickFindImpl;
import com.algs.algo.unionfind.non_generic.qu.QuickUnionImpl;
import com.algs.algo.unionfind.non_generic.qu.path_compression.*;
import com.algs.algo.unionfind.non_generic.qu.weight.RankWeightImpl;
import com.algs.algo.unionfind.non_generic.qu.weight.SizeWeightImpl;
import com.algs.datastructure.collection.queue.ArrayQueueImpl;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.util.Pair;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class NonGenericImplTest {

    @Test
    void testPathSplitting() {
        IUnionFind qu = new SplittingWithoutWeightImpl();

        qu.union(0, 1);
        qu.union(1, 2);
        qu.union(2, 3);
        qu.union(3, 4);
        qu.union(4, 5);

        qu.find(0);
        qu.find(2);

    }

    @Test
    void testPathHalving() {
        IUnionFind qu = new HalvingWithoutWeightImpl();

        qu.union(0, 1);
        qu.union(1, 2);
        qu.union(2, 3);
        qu.union(3, 4);
        qu.union(4, 5);

        qu.find(0);
        qu.find(2);

    }

    @Test
    void test() {
        IQueue<IUnionFind> ufs = new ArrayQueueImpl<>();
//        ufs.enque(new QuickUnionImpl());
//        ufs.enque(new QuPathCompressImpl());
//        ufs.enque(new QuPcImpl0());
//        ufs.enque(new QuPcImpl());
//        ufs.enque(new QuSizeImpl());
//        ufs.enque(new QuRankImpl());
//        ufs.enque(new QuPathSplitImpl());
        ufs.enque(new HalvingImpl());
//        ufs.enque(new WeighedQuickFindImpl());

        while (!ufs.isEmpty()) {
            IUnionFind next = ufs.deque();
            try {
                commonFunctionality(next);
            } catch (Throwable t) {
                System.out.println(next.getClass().getName());
                t.printStackTrace();
            }
        }
    }

    void commonFunctionality(@NotNull IUnionFind uf) {
        Assertions.assertEquals(DefaultValues.DEFAULT_CAPACITY, uf.count());
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

    @Test
    void find() {
        IUnionFind uf = new FullCompressImpl0();
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
    void _1_5_1_2_3() {
        Pair[] pairs = new Pair[8];
        pairs[0] = new Pair(9, 0);
        pairs[1] = new Pair(3, 4);
        pairs[2] = new Pair(5, 8);
        pairs[3] = new Pair(7, 2);
        pairs[4] = new Pair(2, 1);
        pairs[5] = new Pair(5, 7);
        pairs[6] = new Pair(0, 3);
        pairs[7] = new Pair(4, 2);
        System.out.print("        ");

        IUnionFind qf = new QuickFindImpl();
        print(qf);

        printPath(qf, pairs);
        String repeat = "-".repeat(50);
        System.out.println(repeat);

        qf = new QuickUnionImpl();
        printPath(qf, pairs);
        System.out.println(repeat);

        qf = new SizeWeightImpl();
        printPath(qf, pairs);
        System.out.println(repeat);

        qf = new RankWeightImpl();
        printPath(qf, pairs);

    }

    private void printPath(IUnionFind uf, Pair[] pairs) {
        System.out.println();
        for (Pair pair : pairs) {
            System.out.print(pair);
            uf.union((int) pair.a, (int) pair.b);
            System.out.print(": ");
            print(uf);
        }
    }

    void print(IUnionFind uf) {
        System.out.println(Arrays.toString(uf.getIds()));
    }

    @Test
    void count() {
    }

    @Test
    void union() {
    }

    @Test
    void connected() {
    }
}