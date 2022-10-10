package com.algs.algo.unionfind.non_generic.qu.weight;

import com.algs.algo.unionfind.non_generic.qf.QuickFindImpl;
import com.algs.algo.unionfind.non_generic.qu.IUnionFind;
import com.algs.algo.unionfind.non_generic.qu.QuickUnionImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuWeightImplTest {

    private static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "[" + a + ", " + b + "]";
        }
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

        qf = new QuSizeImpl();
        printPath(qf, pairs);
        System.out.println(repeat);

        qf = new QuRankImpl();
        printPath(qf, pairs);

    }

    private void printPath(IUnionFind uf, Pair[] pairs) {
        System.out.println();
        for (Pair pair : pairs) {
            System.out.print(pair);
            uf.union(pair.a, pair.b);
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
    void find() {
    }

    @Test
    void connected() {
    }

    @Test
    void getIds() {
    }

    @Test
    void testUnion() {
    }
}