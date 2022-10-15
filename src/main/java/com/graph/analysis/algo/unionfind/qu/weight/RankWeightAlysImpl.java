package com.graph.analysis.algo.unionfind.qu.weight;

import com.algs.algo.unionfind.non_generic.qu.weight.RankWeightImpl;
import com.algs.datastructure.collection.Iterator;
import com.algs.datastructure.collection.list.IList;
import com.algs.util.DrawUtil;
import com.algs.util.Pair;
import com.graph.GraphicAnalysis;

import java.util.Objects;

public class RankWeightAlysImpl extends RankWeightImpl implements GraphicAnalysis {

    private int totalCost = 0;
    private int cost;
    private final IList<Pair<Integer>> data;

    public RankWeightAlysImpl(IList<Pair<Integer>> data) {
        super(data.size());
        this.data = data;
    }

    @Override
    public int find(int a) {
        while (!Objects.equals(a, id[a])) {
            a = id[a];
            cost += 2;
        }
        return a;
    }

    @Override
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (Objects.equals(rootA, rootB)) {
            return;
        }
        if (rank[rootA] > rank[rootB]) {
            id[rootB] = rootA;
        } else if (rank[rootA] < rank[rootB]) {
            id[rootA] = rootB;
        } else {
            id[rootB] = rootA;
            rank[rootA]++;
        }
        cost += 2;
        count--;
    }

    @Override
    public void analyze() {
        DrawUtil.setTitle(RankWeightImpl.class.getSimpleName());
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
                totalCost += cost;
                plot(i, cost, totalCost);
                continue;
            }
            union(a, b);
            i++;
            totalCost += cost;
            plot(i, cost, totalCost);
        }
    }

}
