package com.algs.algo.unionfind.non_generic.qu;

import com.algs.algo.unionfind.non_generic.ErdosRenyi;
import com.algs.algo.unionfind.non_generic.IUnionFind;
import com.algs.algo.unionfind.non_generic.qu.path_compression.HalvingImpl;
import com.algs.analysis.StopWatchTask;
import org.apache.commons.lang.math.RandomUtils;

import java.lang.reflect.Constructor;
import java.util.Random;

/**
 * Using both path compression, splitting, or halving and union by rank or size ensures that the
 * amortized time per operation is only O(a(n)), which is optimal, where a(n) is the inverse Ackermann function.
 *
 * This function has a value a(n) < 5 for any value of n that can be written in this physical universe,
 * so the disjoint-set operations take place in essentially constant time
 */
public class UFPerformanceCompare extends StopWatchTask {

    private final IUnionFind uf;
    private final int size;
    private final Random r = new Random();

    public UFPerformanceCompare(int size, IUnionFind uf) {
        this.size = size;
        this.uf = uf;
    }

    private void union(int a, int b) {
        uf.union(a, b);
    }

    private int find(int a) {
        return uf.find(a);
    }

    private boolean connected(int a, int b) {
        return uf.connected(a, b);
    }

    @Override
    public Object profileTask() {
//        for (int i = 1; i < array.length; i++) {
//            this.union(array[i - 1], array[RandomUtils.nextInt(array.length)]);
//        }
//        for (int i = 1; i < array.length; i++) {
//            this.find(array[i - 1]);
//        }
//        for (int i = 1; i < array.length; i++) {
//            this.connected(array[i - 1], array[RandomUtils.nextInt(array.length)]);
//        }
//        return "Void";
        while (uf.count() > 1) {
            int a = r.nextInt(size);
            int b = r.nextInt(size);
            uf.union(a, b);
        }
        return "Void";
    }

}
