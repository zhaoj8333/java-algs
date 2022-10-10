package com.algs.algo.unionfind;

import com.algs.algo.unionfind.non_generic.qu.IUnionFind;
import com.algs.analysis.StopWatchTask;
import org.apache.commons.lang.math.RandomUtils;

/**
 * Using both path compression, splitting, or halving and union by rank or size ensures that the
 * amortized time per operation is only O(a(n)), which is optimal, where a(n) is the inverse Ackermann function.
 *
 * This function has a value a(n) < 5 for any value of n that can be written in this physical universe,
 * so the disjoint-set operations take place in essentially constant time
 */
public class UFPerformanceCompare extends StopWatchTask {

    private final int[] array;
    private final IUnionFind uf;

    public UFPerformanceCompare(int size, IUnionFind uf) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            int n = RandomUtils.nextInt(size);
            array[i] = n;
        }
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
        for (int i = 1; i < array.length; i++) {
            this.union(array[i - 1], array[RandomUtils.nextInt(array.length)]);
        }
        for (int i = 1; i < array.length; i++) {
            this.find(array[i - 1]);
        }
        for (int i = 1; i < array.length; i++) {
            this.connected(array[i - 1], array[RandomUtils.nextInt(array.length)]);
        }
        return "Void";
    }

}
