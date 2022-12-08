package com.algs.algo.unionfind;

import com.algs.algo.unionfind.non_generic.ErdosRenyi;
import com.algs.algo.unionfind.non_generic.IUnionFind;
import com.algs.algo.unionfind.non_generic.qu.QuickUnionImpl;
import com.algs.algo.unionfind.non_generic.qu.path_compression.HalvingImpl;
import org.junit.jupiter.api.Test;

class ErdosRenyiTest {

    @Test
    void test() {
        int n = 10;
        int[] edges = new int[n];
        ErdosRenyi er = new ErdosRenyi();
        for (int i = 0; i < 5; i++) {
//            IUnionFind uf = new HalvingImpl(n);
            IUnionFind uf = new QuickUnionImpl(n);
            System.out.println(n + "\t" + er.count(uf));
            n *= 10;
        }
    }

    /**
     * In order to get one Singly component, the numbers of pair needed is ~1/2 n * logN
     */
    @Test
    void _1_5_21() {
        ErdosRenyi er = new ErdosRenyi();
        for (int n = 10; n < 10000; n *= 2) {
            int total = 0;
            for (int j = 0; j < 100; j++) {
                IUnionFind uf = new HalvingImpl(n);
//                IUnionFind uf = new QuickUnionImpl(n);
                total += er.count(uf);
            }
            System.out.println("result:  " + (total / 100));
            System.out.println("1/2NlnN: " + n * Math.log(n) * 0.5);
            System.out.println();
        }
    }
}