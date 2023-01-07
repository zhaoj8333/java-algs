package com.algs.algo.unionfind.non_generic.qu;

import com.algs.algo.unionfind.non_generic.IUnionFind;
import com.algs.analysis.StopWatchTask;

import java.util.Random;

public class UFPerformanceCompare extends StopWatchTask {

    private final IUnionFind uf;
    private final int size;
    private final Random r = new Random();

    public UFPerformanceCompare(int size, IUnionFind uf) {
        this.size = size;
        this.uf = uf;
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

    @Override
    protected void assertInput() {

    }

    @Override
    protected void assertResult() {

    }

}
