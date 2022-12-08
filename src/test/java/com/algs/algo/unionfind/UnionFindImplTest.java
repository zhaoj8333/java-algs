package com.algs.algo.unionfind;

import com.algs.DefaultValues;
import com.algs.ImplFunctionalityTest;
import com.algs.algo.unionfind.non_generic.IUnionFind;
import com.algs.algo.unionfind.non_generic.qf.QuickFindImpl;
import com.algs.algo.unionfind.non_generic.qu.QuickUnionImpl;
import com.algs.algo.unionfind.non_generic.qu.path_compression.HalvingImpl;
import com.algs.algo.unionfind.non_generic.qu.path_compression.HalvingWithoutWeightImpl;
import com.algs.algo.unionfind.non_generic.qu.path_compression.SplittingWithoutWeightImpl;
import com.algs.algo.unionfind.non_generic.qu.weighed.RankWeighedImpl;
import com.algs.algo.unionfind.non_generic.qu.weighed.SizeWeighedImpl;
import com.algs.datastructure.collection.queue.ArrayQueueImpl;
import com.algs.datastructure.collection.queue.IQueue;
import com.algs.utils.Connection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class UnionFindImplTest extends ImplFunctionalityTest {

    @Test
    @Override
    public void test() {
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
            IUnionFind uf = ufs.deque();
            try {
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
            } catch (Throwable t) {
                System.out.println(uf.getClass().getName());
                t.printStackTrace();
            }
        }
    }

    @Test
    void _1_5_1_2_3() {
        Connection[] connections = new Connection[8];
        connections[0] = new Connection(9, 0);
        connections[1] = new Connection(3, 4);
        connections[2] = new Connection(5, 8);
        connections[3] = new Connection(7, 2);
        connections[4] = new Connection(2, 1);
        connections[5] = new Connection(5, 7);
        connections[6] = new Connection(0, 3);
        connections[7] = new Connection(4, 2);
        System.out.print("        ");

        IUnionFind qf = new QuickFindImpl();
        print(qf);

        printPath(qf, connections);
        String repeat = "-".repeat(50);
        System.out.println(repeat);

        qf = new QuickUnionImpl();
        printPath(qf, connections);
        System.out.println(repeat);

        qf = new SizeWeighedImpl();
        printPath(qf, connections);
        System.out.println(repeat);

        qf = new RankWeighedImpl();
        printPath(qf, connections);

    }

    private void printPath(IUnionFind uf, Connection[] connections) {
        System.out.println();
        for (Connection connection : connections) {
            System.out.print(connection);
            uf.union((int) connection.a, (int) connection.b);
            System.out.print(": ");
            print(uf);
        }
    }

    void print(IUnionFind uf) {
        System.out.println(Arrays.toString(uf.getIds()));
    }

    @Override
    protected Class<?>[] constructArgsType() {
        return new Class[0];
    }

    @Override
    protected Object construct(Class<?> targetClass) {
        return null;
    }

    @Override
    protected void testEach(Object obj) {


        testPathSplitting();
        testPathHalving();
    }

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
}