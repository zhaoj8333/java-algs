package com.graph.analysis.algo.unionfind.qu.weight.path_compression;

import com.algs.algo.unionfind.non_generic.qu.weight.SizeWeightImpl;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.util.DrawUtil;
import com.algs.util.Pair;
import com.graph.GraphicAnalysis;

import java.util.Objects;

public class QuSizeAlysImpl extends SizeWeightImpl implements GraphicAnalysis {

    private int totalCost = 0;
    private int cost;
    private final IList<Pair<Integer>> data;

    public QuSizeAlysImpl(IList<Pair<Integer>> data) {
        super(data.size());
        this.data = data;
    }

    @Override
    public int find(int a) {
        while (!Objects.equals(a, id[a])) {
            a = id[a];
            cost++;
        }
        totalCost += cost;
        return a;
    }

    @Override
    public void union(int a, int b) {
        super.union(a, b);
        cost++;
        totalCost += cost;
    }

    @Override
    public void analyze() {
        DrawUtil.setXscale(0, id.length + 30);
        DrawUtil.setYscale(0, id.length * 2);
        DrawUtil.setPenRadius(0.003);
        DrawUtil.textLeft(1, id.length, String.valueOf(id.length));

        int i = 0;
        Iterator<Pair<Integer>> itr = data.iterator();
        while (itr.hasNext()) {
            cost = 0;
            Pair<Integer> pair = itr.next();
            Integer a = pair.a;
            Integer b = pair.b;
            if (connected(a, b)) {
                i++;
                plot(i, cost, totalCost);
                continue;
            }
            union(a, b);
            i++;
            plot(i, cost, totalCost);
        }
    }

}
